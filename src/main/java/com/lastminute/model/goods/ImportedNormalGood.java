package com.lastminute.model.goods;

import java.math.BigDecimal;

import com.lastminute.model.goods.exceptions.NoNegativeValueException;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ImportedNormalGood extends NormalGood {
	
	/*
	 *  Lombock can't be used for constructor with arguments
	 *  of super class due to technical limitation
	 */
	public ImportedNormalGood(String name, String shelfPrice) throws NoNegativeValueException {
		super(name, shelfPrice);
	}

	@Override
	public BigDecimal getTaxRate() {
		return super.getTaxRate().add(new BigDecimal("0.05"));
	}

}
