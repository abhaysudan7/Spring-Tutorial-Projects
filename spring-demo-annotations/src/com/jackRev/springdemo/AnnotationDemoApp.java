package com.jackRev.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Coach theCoach = context.getBean("thatSillyCoach", Coach.class);

		// Default bean id
		Coach theCoach_2 = context.getBean("tennisCoach", Coach.class);

		// System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach_2.getDailyWorkout());
		System.out.println(theCoach_2.getDailyFortune());

		Coach theCoach_3 = context.getBean("chessCoach", Coach.class);

		System.out.println(theCoach_3.getDailyWorkout());
		System.out.println(theCoach_3.getDailyFortune());

		context.close();
	}

}
