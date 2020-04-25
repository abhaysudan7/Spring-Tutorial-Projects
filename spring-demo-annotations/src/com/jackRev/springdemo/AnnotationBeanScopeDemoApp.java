package com.jackRev.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Default bean id
		Coach theCoach = context.getBean("tennisCoach", Coach.class);

		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

		System.out.println(theCoach == alphaCoach);

		System.out.println("\nMemorory location of theCoach: " + theCoach);
		System.out.println("\nMemorory location of alphaCoach: " + alphaCoach);

		context.close();
	}
}
