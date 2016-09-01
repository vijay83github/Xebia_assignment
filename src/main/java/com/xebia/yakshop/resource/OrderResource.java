package com.xebia.yakshop.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.yakshop.model.OrderInfo;
import com.xebia.yakshop.model.YakProducts;
import com.xebia.yakshop.service.ProductFacade;
import com.xebia.yakshop.utils.YakshopConstants;

@RestController
@RequestMapping(value = "/yak-shop/order")

public class OrderResource {
	@Autowired
	ProductFacade productFacade;


	@RequestMapping(value = "/{days}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<YakProducts> listAllYaks(@PathVariable Integer days, @RequestBody OrderInfo orderInfo) {
		YakProducts availableProducts = productFacade.findAllStock(days - YakshopConstants.CURRENT_DAY);
		
		YakProducts requestedProducts = new YakProducts();
		
		HttpStatus httpStatus = compareAvailableAndRequestedProductQuality(availableProducts, orderInfo,
				requestedProducts);

		return new ResponseEntity<YakProducts>(requestedProducts, httpStatus);

	}

	private HttpStatus compareAvailableAndRequestedProductQuality(YakProducts availableProducts, OrderInfo orderInfo,
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