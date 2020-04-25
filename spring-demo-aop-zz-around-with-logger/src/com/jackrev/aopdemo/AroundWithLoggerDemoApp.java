package com.jackrev.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jackrev.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("\nMain Program: AroundWithLoggerDemoApp");

		myLogger.info("Calling getFortune");

		String data = theFortuneService.getFortune();

		myLogger.info("\nMy Fortune is: " + data);

		myLogger.info("Finished");

		// close the context
		context.close();
	}

}
