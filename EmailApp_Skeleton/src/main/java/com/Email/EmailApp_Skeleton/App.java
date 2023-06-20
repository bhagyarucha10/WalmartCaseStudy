package com.Email.EmailApp_Skeleton;

import com.model.Ticket;
import com.util.RoutingTickets;
import com.util.Util;
import java.util.*;

/**
 * Main Application starts here.does 3 tasks
 * 1.invokes readFile method and return valid TicketTypes with SLA Hours
 * 2.invokes routeGenertedTickets method to route every ticket to different tech support engineer based on ticket type through mail
 * 3.send a report of all tickets to line manager through mail
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Util u=new Util();
    	
  System.out.println("Reading text file and determing SLA time");
    	List<Ticket> t= u.readFile("resources/details.txt");
    	
    	System.out.println("Routing Generated Tickets to a Tech Support engineer with Ticket Details");
    	RoutingTickets.routeGeneratedTickets(t);
   
    	 
    	System.out.println("Sending all tickets raised to Line Manager");
    	 GEMailSender mail=new GEMailSender();
         String from="techsupport_engineer_emailid_here";//put ur mailid here
      
         String to="line_manager_emailid_here";// put ur line_manager mailid here
         String sub="Tickets Raised for the Day";
     
       
        		mail.sendEmailToLineManager(to,from,sub, t);
     
    }
    	}
    


