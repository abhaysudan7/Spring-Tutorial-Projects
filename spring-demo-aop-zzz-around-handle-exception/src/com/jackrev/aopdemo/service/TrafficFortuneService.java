package com.jackrev.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {

		// stimulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// return a fortune
		return "Except heavy traffic this morning";
	}

	public String getFortune(boolean tripWire) {
		if (tripWire) {
			throw new RuntimeException("Major Accident! Highway is closed!");
		}
		return getFortune();
	}
}
