package com.xebia.yakshop.utils;

import org.springframework.stereotype.Component;

@Component("productCalculator")
public class ProductCalculator implements YakshopConstants{

	

	

	public float calculateMilk(float age, int elapsedDays) {
		float milk = 0f;
		for (int i = 1; i <= elapsedDays; i++) {
			milk += FIXED_MILK
					- (calculateAgeInDays(age, i))
					* MILK_FACTOR;
		}
		 
		return milk;
	}

	
	private float calculateAgeInDays(float age, int elapsedDays) {
		return (age * DAYS_IN_YAK_YEAR) + elapsedDays;
	}

	public int calculateSkins(float age, int elapsedDays) {
		if ((elapsedDays) >= (calculateDaysToShave(age,
				elapsedDays) + DAYS_REQUIRED_TO_SHAVE)) {
			return 1;
		}
		return 0;
	}

	public int calculateDaysToShave(float age, int elapsedDays) {
		int days = FIXED_SHAVING_PERIOD
				+ Math.round(calculateAgeInDays(age, elapsedDays)
						* TO_BE_SHAVED_FACTOR);
		return days;
	}
	
	
}
