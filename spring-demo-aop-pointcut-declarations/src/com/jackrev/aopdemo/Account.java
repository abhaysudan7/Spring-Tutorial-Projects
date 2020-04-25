package com.jackrev.aopdemo;

import org.springframework.stereotype.Component;

@Component
public class Account {

	private String name;
	private String level;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
