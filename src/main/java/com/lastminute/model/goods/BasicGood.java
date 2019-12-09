package com.lastminute.model.goods;

import java.math.BigDecimal;

import com.lastminute.model.goods.exceptions.NoNegativeValueException;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BasicGood extends Good {

	/*
	 *  Lombock can't be used for constructor with arguments
	 *  of super class due to technical limitation
	 */
	public BasicGood(String name, String shelfPrice) throws NoNegativeValueException {
		super(name, shelfPrice);
	}

	@Override
	public BigDecimal getTaxRate() {
		return new BigDecimal("0.0");
	}
}
