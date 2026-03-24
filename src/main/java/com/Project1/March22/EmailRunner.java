package com.Project1.March22;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmailRunner implements CommandLineRunner{

	
	@Autowired
	 private Dailymessageservice service;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		  try {
	            service.sendDailyMessage();
	            System.out.println("Email sent successfully ✅");
	        } catch (Exception e) {
	            System.out.println("Error while sending email ❌");
	            e.printStackTrace();
	        }

	        System.exit(0); // stops the app after execution
		
	}
	

}
