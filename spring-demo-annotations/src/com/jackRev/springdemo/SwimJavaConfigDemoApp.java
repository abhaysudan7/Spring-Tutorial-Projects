package com.jackRev.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SwimSportConfig.class);

		// Default bean id
		SwimCoach theCoach_2 = context.getBean("swimCoach", SwimCoach.class);

		System.out.println(theCoach_2.getDailyWorkout());
		System.out.println(theCoach_2.getDailyFortune());

		System.out.println("Email : " + theCoach_2.getEmail());
		System.out.println("Team : " + theCoach_2.getTeam());

		context.close();
	}

}
