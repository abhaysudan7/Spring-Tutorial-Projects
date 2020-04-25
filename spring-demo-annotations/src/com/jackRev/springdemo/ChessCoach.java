package com.jackRev.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ChessCoach implements Coach {

	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService theFortuneService;

	@Override
	public String getDailyWorkout() {
		return "Solve 10 endgames.";
	}

	@Override
	public String getDailyFortune() {
		return theFortuneService.getFortune();
	}

//	@Autowired
//	public void setTheFortuneService(FortuneService theFortuneService) {
//		this.theFortuneService = theFortuneService;
//	}

}
