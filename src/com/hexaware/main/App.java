package com.hexaware.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hexaware.main.beans.Account;



public class App {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/hexaware/main/Beans.xml");
		Account account=(Account)context.getBean("account");
		
		account.setId(1L);
		account.setName("Harry potter");
		System.out.println(account);
		((ClassPathXmlApplicationContext)context).close();
		
				
	}

}

