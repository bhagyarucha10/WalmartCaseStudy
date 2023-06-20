package com.Email.EmailApp;

import com.model.Ticket;
import com.util.RoutingTickets;
import com.util.Util;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Util u=new Util();
    	
  System.out.println("Reading text file and determing SLA time");
    	List<Ticket> t= u.readFile("resources/details.txt");
    	//System.out.println(t);
    	
    	System.out.println("Routing Generated Tickets to a Tech Support engineer with Ticket Details");
    	RoutingTickets.routeGeneratedTickets(t);
   
    	 
    	System.out.println("Sending all tickets raised to Line Manager");
    	 GEMailSender mail=new GEMailSender();
         String from="bhagyashree.mohan@gmail.com";
      
         String to="bhagyashree.chandraiah@u-next.com";
         String sub="Tickets Raised for the Day";
     
       
        		mail.sendEmailToLineManager(to,from,sub, t);
     
    }
    	}
    


