package com.spike.sales.service.impl;

import com.spike.sales.service.SaleService;

public class SaleServiceImpl implements SaleService {

	private int count = 0;
	
	@Override
	public String getName() {
		count++;
		return "IPL:" +count ;
	}

}
