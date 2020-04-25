package com.jackrev.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jackrev.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		System.out.println("\nMain Program: AroundDemoApp");

		System.out.println("Calling getFortune");

		String data = theFortuneService.getFortune();

		System.out.println("\nMy Fortune is: " + data);

		System.out.println("Finished");

		// close the context
		context.close();
	}

}
