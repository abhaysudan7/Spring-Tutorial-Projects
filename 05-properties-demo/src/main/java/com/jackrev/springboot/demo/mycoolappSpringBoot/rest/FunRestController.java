package com.jackrev.springboot.demo.mycoolappSpringBoot.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	// getting values from custom properties
	@Value("${coach.name}")
	private String coachName;

	@Value("${team.name}")
	private String teamName;

	// expose endpoint for "teaminfo"
	@GetMapping("teaminfo")
	public String getTeamInfo() {
		return "Coach : " + coachName + "," + "Team : " + teamName;
	}

	// expose "/" that return hello world

	@GetMapping
	public String sayHello() {
		return "Hello World! Time on server is " + LocalDateTime.now();

	}

	// expose a new endpoint for "workout"
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5K!";
	}

	// expose a new endpoint for "fortune"
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Today is your lucky day.";
	}
}
