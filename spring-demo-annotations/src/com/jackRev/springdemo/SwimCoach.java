package com.jackRev.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService theFortuneService;

	@Value("${foo.email}")
	private String email;

	@Value("${foo.team}")
	private String team;

	public SwimCoach(FortuneService theFortuneService) {
		this.theFortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Swim 1000m as a warm up.";
	}

	@Override
	public String getDailyFortune() {
		return theFortuneService.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}
	
}
