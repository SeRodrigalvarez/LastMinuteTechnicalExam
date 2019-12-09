package com.lastminute.model.goods;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.lastminute.model.goods.exceptions.NoNegativeValueException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public abstract class Good {
	
	private static final BigDecimal TAX_ROUND = new BigDecimal("0.05");
	
	private String name;
	
	/*
	 * For monetary calculus, we use BigDecimal due to small error on precision
	 * of double primary type and operation support. If we make several multiplications and divisions,
	 * said error would be a amplified.
	 */
	private String shelfPrice;
	
	/*
	 * As we don't want to create goods with negative prices, we use a custom made constructor which may throw
	 * - NumberFormatException: an unchecked exception, if shelfPrice can't be parsed as number
	 * - NoNegativeValueException: a checked exception, if shelfPrice is negative
	 */
	public Good (String name, String shelfPrice) throws NoNegativeValueException {
		
		BigDecimal bDShelfPrice = new BigDecimal (shelfPrice);
		
		if (bDShelfPrice.signum()==-1) {
			throw new NoNegativeValueException();
		} else {
			this.name=name;
			this.shelfPrice=shelfPrice;
		}
		
	}
	
	/*
	 * We override lombock setter as we don't want to create goods with negative prices
	 */
	public void setShelfPrice (String shelfPrice) throws NoNegativeValueException {
		
		BigDecimal bDShelfPrice = new BigDecimal (this.shelfPrice);
		
		if (bDShelfPrice.signum()==-1) {
			throw new NoNegativeValueException();
		} else {
			this.shelfPrice=shelfPrice;
		}
	}
	
	public abstract BigDecimal getTaxRate();
	
	public BigDecimal getSaleTax() {
		
		BigDecimal bDShelfPrice = new BigDecimal (this.shelfPrice);
		
		// Get sale tax
		BigDecimal unroundedSaleTax = bDShelfPrice.multiply(this.getTaxRate());
		
		// Get sale tax rounded to TAX_ROUND
		BigDecimal divided = unroundedSaleTax.divide(TAX_ROUND, 0, RoundingMode.CEILING);
		return divided.multiply(TAX_ROUND);
	}
	
	public BigDecimal getTotalPrice () {
		
		BigDecimal bDShelfPrice = new BigDecimal (this.shelfPrice);
		
		return bDShelfPrice.add(this.getSaleTax());
	}
}
