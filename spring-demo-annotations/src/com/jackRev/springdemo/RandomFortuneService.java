/**
 * 
 */
package com.jackRev.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

/**
 * @author Abhay Sudan
 *
 */
@Component
public class RandomFortuneService implements FortuneService {

	private String[] data = { "BEware of the wolf in sheep's clothing", "Diligence is the mother of good luck",
			"The journey is the reward" };

	private Random myRandom = new Random();

	@Override
	public String getFortune() {

		int index = myRandom.nextInt(data.length);

		String fortune = data[index];

		return fortune;
	}

}
