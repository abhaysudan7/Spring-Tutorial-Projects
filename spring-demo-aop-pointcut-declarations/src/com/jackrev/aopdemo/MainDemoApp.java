package com.jackrev.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jackrev.aopdemo.dao.AccountDAO;
import com.jackrev.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		theAccountDAO.addAccount(new Account(), true);

		theAccountDAO.doWork();

		theMembershipDAO.addSilly();

		theMembershipDAO.goToSleep();

		context.close();
	}

}
