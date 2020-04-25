package com.jackrev.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jackrev.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("\nMain Program: AroundHandleExceptionDemoApp");

		myLogger.info("Calling getFortune");
		
		boolean tripWire = true;

		String data = theFortuneService.getFortune(tripWire);

		myLogger.info("\nMy Fortune is: " + data);

		myLogger.info("Finished");

		// close the context
		context.close();
	}

}
