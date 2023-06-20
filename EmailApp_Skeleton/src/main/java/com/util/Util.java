package com.util;
import java.util.*;

import com.exception.InvalidTicketException;
import com.model.*;
import java.io.*;
public class Util 
{
	/** This method is called from readFile method
	 *  determines SLA Hours and assigns to slaHours of Ticket class
	 * 
	 *  
	 **/
	public List<Ticket> findSLATime(List<Ticket> ticketList)
	{
		
		// for each ticket,check the ticket type.if ticket type is "Report a problem" assign slaHours as 4,
	//	if ticket type is "Access Issue" assign slaHours as 3,
		//if ticket type is "General Enquiry" assign slaHours as 2,
		//if ticket type is "Feedback" assign slaHours as 1,
		
		
		
		return ticketList;
	
	}

	/** This method reads details.txt file passed from App.java and stored in inputfeed variable
	 * details.txt contains data in the following order 1)ticketid 2)tickettype 3)customername 4)phone number 5)Description of the issue
	 * this method reads everyline of input,checks the tickettype is either 1)Report a problem 2) Access Issue
	 * 3)General enquiry 4)Feedback....the ticket type can be checked by invoking validticketType method with ticket type as argument.
	 * if any other ticket type is found ,an InvalidTicketException should be generated.other wise return boolean value true.
	 * for all valid ticket types,add each ticket to a List<Ticket> type.
	 * next determine SLA Hours by invoking findSLATime method and passing List<Ticket> as argument.
	 *Lastly return ticket List with SLA hours computed.
	 */
public 	List<Ticket> readFile(String inputfeed)
	{
	
	//write code for specification as above
	
	return null;    //change return type here
	
	}
	
/*
 * 
 * This method is called from readFile method.
 * This method checks for valid tickettypei.e.,1)Report a problem 2) Access Issue
	 * 3)General enquiry 4)Feedback..for valid ticket type return true else throw InvalidTicketException
 * 
 */
public boolean validateTicketType(String s) throws InvalidTicketException
{
	//write code for specification as above
	
	return true ;
}
}
