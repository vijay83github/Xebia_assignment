package com.xebia.yakshop.utils;

public class ProductCalculator {

	private static final int FIXED_SHAVING_PERIOD = 8;
	private static final float TO_BE_SHAVED_FACTOR = 0.01f;
	private static final int DAYS_IN_YAK_YEAR = 100;
	private static final int FIXED_MILK = 50;
	private static final int CURRENT_DAY = 1;
	private static final int DAYS_REQUIRED_TO_SHAVE = 1;
	private static final float MILK_FACTOR = 0.03f;

	/*
	 * • Each day a LabYak produces 50-D*0.03 liters of milk (D = age in days).
	 * • At most every 8+D*0.01 days you can again shave a LabYak (D = age in
	 * days). • A yak can be first shaven when he is 1 year. • A LabYak dies the
	 * day he turns 10.
	 */

	public float calculateMilk(int age, int elapsedDays) {
		float milk = FIXED_MILK
				- (calcuateAgeInDays(age, elapsedDays - CURRENT_DAY))
				* MILK_FACTOR;
		return milk;
	}

	/**
	 * @param age
	 * @param elapsedDays
	 * @return
	 */
	private int calcuateAgeInDays(int age, int elapsedDays) {
		return (age * DAYS_IN_YAK_YEAR) + elapsedDays;
	}

	public int calculateSkins(int age, int elapsedDays) {
		if ((elapsedDays - CURRENT_DAY) >= (calculateDaysToShave(age,
				elapsedDays) + DAYS_REQUIRED_TO_SHAVE)) {
			return 1;
		}
		return 0;
	}

	private int calculateDaysToShave(int age, int elapsedDays) {
		int days = FIXED_SHAVING_PERIOD
				+ Math.round(calcuateAgeInDays(age, elapsedDays - CURRENT_DAY)
						* TO_BE_SHAVED_FACTOR);
		return days;
	}
}
