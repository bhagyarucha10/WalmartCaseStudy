package com.Email.EmailApp_Skeleton;
import java.util.*;
import java.io.*;

import com.model.Ticket;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.Authenticator;
import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
public class GEMailSender {
	
	/*This method is called from routeGeneratedTickets method of RoutingTickets class
	 *  this method validates sender mail and send each ticket to specified mailid(specfied in :to) with ticket details
	 * 
	 * 
	 */
	public boolean sendEmail(String to,String from,String subject,Ticket ticket)
	{
		boolean flag=false;
		
		Properties properties=new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable",true);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.host","smtp.gmail.com");
		
		 final String username="your username here    ";   //(type sender's username) 
		final String password="  ";////generate password(dont hardcode your mailid's password)..
		Session session=Session.getInstance(properties,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(username,password);
			}
			
		});
		try
		{
			Message message=new MimeMessage(session);
			message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
			message.setFrom(new InternetAddress(from));
			message.setSubject(subject);
		//	message.setText(text);
			message.setText("Here is a new Ticket Raised\n"+" " +"Ticket Id:"+ticket.getTicketId()+"  "+
			"Ticket Type:"+ticket.getTicketType()+"  "+
			"Customer Name:"+ticket.getCustomerName()+"  "+
			"Phone Number:"+ticket.getPhone()+"  "+
			"Description Issue:"+ticket.getDescriptionIssue()+" "+
			"Ticket Type:"+ticket.getTicketType()+" "+
			"SLA Hours:"+ticket.getSlaHours());
			
			Transport.send(message);
			
			flag=true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	/*This method is called from App.java
	 * This method stores  the List< ticket>  in a file tickets with SLA Hours  and sends that file as an attachment to the email of  Line Manager
	 * 
	 * 
	 * 
	 */
	public void  sendEmailToLineManager(String to,String from,String subject,List<Ticket> ticket)
	{
		PrintWriter pw=null;
		try {
		
		//write code to put List<Ticket> to a file
			
			
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}pw.close();
		
		
		
		boolean flag=false;
		
		Properties properties=new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable",true);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.host","smtp.gmail.com");
	
		 final String username="your username here";//type username of your maild here
		final String password="  ";   //generate password(dont hardcode your mailid's password)..
		Session session=Session.getInstance(properties,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(username,password);
			}
			
		});
		try
		{
			Message message=new MimeMessage(session);
			message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
			message.setFrom(new InternetAddress(from));
			message.setSubject(subject);
		
	         BodyPart messageBodyPart = new MimeBodyPart();
	       
	         messageBodyPart.setText("Dear Sir,Pls find the Issues reported for the Day as in attachment");

	         
	         Multipart multipart = new MimeMultipart();

	        
	         multipart.addBodyPart(messageBodyPart);

	        
	         messageBodyPart = new MimeBodyPart();
	         String filename = "    ";     //put the filename where all List<Ticket> is stored
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);

	         message.setContent(multipart);

	        
	         Transport.send(message);

	         System.out.println("Sent message to Line Manager successfully....");
	  
	      } catch (MessagingException e) {
	         throw new RuntimeException(e);
	      }
	}

}
