package com.jackrev.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jackrev.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// call method to find the accounts

		List<Account> theAccounts = null;

		try {
			// add a boolean flag to stimulate exception

			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);

		} catch (Exception exc) {
			System.out.println("\n\nMain Program ... caught exception: " + exc);
		}

		// display the accounts
		System.out.println("\n\nMain program : AfterFinallyDemoApp");
		System.out.println("------");

		System.out.println(theAccounts);

		System.out.println("\n");

		context.close();
	}

}
