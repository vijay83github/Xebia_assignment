package com.xebia.yakshop.utils;

import java.util.List;

import com.zebia.yakshop.model.Yak;
import com.zebia.yakshop.model.YakProducts;

public class YakShopPrinter {
	public void printStocks(YakProducts products) {
		System.out.println("In Stock:");
		System.out.println(products.getMilk() + " liters of milk ");
		System.out.println(products.getSkins() + " skins of wool");
	}

	public void printHerd(List<Yak> yaks) {
		System.out.println("Herd:");
		for (Yak yak : yaks) {
			System.out.println(yak.getName() + " " + yak.getAge() + "Years Old. ");
		}
	}
}
