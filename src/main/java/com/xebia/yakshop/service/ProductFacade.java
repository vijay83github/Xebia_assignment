package com.xebia.yakshop.service;

import com.xebia.yakshop.model.YakProducts;

public interface ProductFacade {
	public YakProducts findAllStock(Integer daysElapsed);
}
