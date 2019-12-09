package com.lastminute.model.receipt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.lastminute.model.goods.Good;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Receipt {
	
	private List<Good> goods = new ArrayList<Good>();
	
	@Override
	public String toString() {
		
		String receipt=new String();
		BigDecimal salesTaxes = new BigDecimal ("0.0");
		BigDecimal total = new BigDecimal ("0.0");
		
		for (Good good : goods) {
			receipt+=good.getName() + " : " + good.getTotalPrice() + "\n";
			salesTaxes=salesTaxes.add(good.getSaleTax());
			total=total.add(good.getTotalPrice());
		}
		
		receipt+="Sales Taxes: " + salesTaxes + "\n";
		receipt+="Total: " + total + "\n";
		
		return receipt;
	}
	
	public void add (Good good) {
		this.goods.add(good);
	}

}
