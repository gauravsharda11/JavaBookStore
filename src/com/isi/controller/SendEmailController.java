package com.isi.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.isi.entity.User;
import com.sun.mail.smtp.SMTPMessage;

/**
 * Servlet implementation class SendEmailController
 */
@WebServlet("/SendEmailController")
public class SendEmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendEmailController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String result;
		   
		   // Recipient's email ID needs to be mentioned.
		   String to = "shipracad@gmail.com";

		   // Sender's email ID needs to be mentioned
		   String from = "shipra.ece.3@gmail.com";

		   // Assuming you are sending email from localhost
		   String host = "smtp.gmail.com";

		   // Get system properties object
		   Properties properties = System.getProperties();

		   // Setup mail server
		   properties.put("mail.smtp.host", "smtp.gmail.com");
		   properties.put("mail.smtp.port", "465");
		   properties.put("mail.smtp.auth", "true");
		   properties.put("mail.smtp.starttls.enable", "true");
		   properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		   properties.put("mail.smtp.ssl.enable", "true");

		   // Get the default Session object.
		   Session mailSession = Session.getDefaultInstance(properties);
			   

		   try {
		      // Create a default MimeMessage object.
			   SMTPMessage message = new SMTPMessage(mailSession);
		      
		      // Set From: header field of the header.
		      message.setFrom(new InternetAddress("shipra.ece.3@gmail.com"));
		      
		      // Set To: header field of the header.
		      message.addRecipient(Message.RecipientType.TO,
		                               new InternetAddress("shipra.ece.3@gmail.com"));
		      // Set Subject: header field
		      message.setSubject("This is the Subject Line!");
		      
		      // Now set the actual message
		      message.setText("This is actual message");
		     // message.setContent(content,"text/html");  
		      message.saveChanges();  
		      
		      // Send message
		      Transport tr = mailSession.getTransport("smtp");
		      
		
              tr.connect(host, "shipra.ece.3@gmail.com", "Kgbfbisez@123");
              tr.sendMessage(message, message.getAllRecipients());
              tr.close(); 
		      //Transport.send(message);
		      result = "Sent message successfully....";
		   } catch (Exception mex) {
		      mex.printStackTrace();
		      result = "Error: unable to send message....";
		   }
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {}

}
