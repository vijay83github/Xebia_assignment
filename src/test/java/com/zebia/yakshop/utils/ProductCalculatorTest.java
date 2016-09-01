package com.zebia.yakshop.utils;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.xebia.yakshop.utils.ProductCalculator;

public class ProductCalculatorTest {
	ProductCalculator calculator = null;
	@Before
	public void setUp() throws Exception {
		calculator = new ProductCalculator();
	}

	@Test
	public void testCalculateMilk() {
		assertEquals(491,Math.round(calculator.calculateMilk(4, 13)));
		assertEquals(335,Math.round(calculator.calculateMilk(8, 13)));
		assertEquals(277,Math.round(calculator.calculateMilk(9.5f, 13)));
	}

	@Test
	public void testCalculateSkins() {
		assertEquals(0,Math.round(calculator.calculateSkins(4, 12)));
		assertEquals(1,Math.round(calculator.calculateSkins(4, 13)));
	}

}
