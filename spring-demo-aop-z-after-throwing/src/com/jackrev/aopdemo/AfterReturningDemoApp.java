package com.jackrev.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jackrev.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts(false);

		// display the accounts
		System.out.println("\n\nMain program : AfterReturningDemoApp");
		System.out.println("------");

		System.out.println(theAccounts);

		System.out.println("\n");

		context.close();
	}

}
