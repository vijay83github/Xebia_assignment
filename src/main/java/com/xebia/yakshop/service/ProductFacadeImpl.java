package com.xebia.yakshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xebia.yakshop.model.Herd;
import com.xebia.yakshop.model.Yak;
import com.xebia.yakshop.model.YakProducts;
import com.xebia.yakshop.utils.ProductCalculator;
import com.xebia.yakshop.utils.YakshopConstants;

@Component("productFacade")
public class ProductFacadeImpl implements ProductFacade{

	@Autowired
	HerdReader  herdReader;
	
	@Autowired
	ProductCalculator  productCalculator;
	
	@Override
	public YakProducts findAllStock(Integer elapsedDays) {
		Herd herd = herdReader.readList(YakshopConstants.HERD_XML);
		Yak[] yaks =  herd.getYaks();
		float milk= 0f;
		float skins= 3f;
		YakProducts products = new YakProducts();
		for (Yak yak : yaks) {
			milk+=productCalculator.calculateMilk(yak.getAge(), elapsedDays);
			skins+=productCalculator.calculateSkins(yak.getAge(), elapsedDays);
		}
		System.out.println(milk);
		System.out.println(skins);
		products.setMilk(milk);
		products.setSkins(skins);
		return products;
	}

}
