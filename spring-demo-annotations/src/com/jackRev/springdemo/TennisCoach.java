package com.jackRev.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(/* "thatSillyCoach" */)
//@Scope("prototype")
public class TennisCoach implements Coach {

	private FortuneService theFortuneService;

	// @Autowired
	public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService) {
		System.out.println(">> Tennis Coach : Inside Constructor");
		this.theFortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return theFortuneService.getFortune();
	}

	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> Tennis Coach : Inside doMyStartupStuff");
	}

	@PreDestroy
	public void doMyCleanUpStuff() {
		System.out.println(">> Tennis Coach : Inside doMyCleanUpStuff");
	}

}
