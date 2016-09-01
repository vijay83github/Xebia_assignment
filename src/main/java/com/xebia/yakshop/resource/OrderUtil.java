package com.xebia.yakshop.resource;

import org.springframework.http.HttpStatus;

import com.xebia.yakshop.model.OrderInfo;
import com.xebia.yakshop.model.YakProducts;

public class OrderUtil {
	
	public static HttpStatus compareAvailableAndRequestedProductQuality(YakProducts availableProducts, OrderInfo orderInfo,
			YakProducts requestedProducts) {

		int count = 0;
		if (orderInfo.getOrder().getMilk() < availableProducts.getMilk()) {
			requestedProducts.setMilk(orderInfo.getOrder().getMilk());
			count++;
		}
		if (orderInfo.getOrder().getSkins() < availableProducts.getSkins()) {
			requestedProducts.setSkins(orderInfo.getOrder().getSkins());
			count++;
		}
		if (count == 2) {
			return HttpStatus.CREATED;
		} else if (count == 1) {
			return HttpStatus.PARTIAL_CONTENT;
		} else {
			return HttpStatus.NO_CONTENT;
		}
	}
}