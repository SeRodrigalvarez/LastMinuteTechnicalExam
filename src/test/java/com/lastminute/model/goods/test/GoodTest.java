package com.lastminute.model.goods.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.lastminute.model.goods.BasicGood;
import com.lastminute.model.goods.Good;
import com.lastminute.model.goods.ImportedBasicGood;
import com.lastminute.model.goods.ImportedNormalGood;
import com.lastminute.model.goods.NormalGood;
import com.lastminute.model.goods.exceptions.NoNegativeValueException;

@RunWith(JUnit4.class)
public class GoodTest {
	
	
	@Test(expected = NumberFormatException.class)
	public void numberFormatExceptionTest () throws NoNegativeValueException {
		new BasicGood ("wrongPriceGood", "fadfuy");
	}
	
	@Test(expected = NumberFormatException.class)
	public void emptyPriceExceptionTest () throws NoNegativeValueException {
		new BasicGood ("emptyPriceGood", "");
	}
	
	@Test(expected = NullPointerException.class)
	public void nullPriceExceptionTest () throws NoNegativeValueException {
		new BasicGood ("nullPriceGood", null);
	}
	
	@Test(expected = NoNegativeValueException.class)
	public void noNegativeValueExceptionTest () throws NoNegativeValueException {
		new BasicGood ("negativeGood", "-0.01");
	}
	
	@Test
	public void basicGoodsTest () throws NoNegativeValueException {
		
		Good book = new BasicGood("book", "12.49");
		Good chocolate = new BasicGood("chocolate bar", "0.85");
		Good headachePills = new BasicGood ("headache pills", "9.75");
		Good veryCheapThing = new BasicGood ("veryCheapThing", "0.01");
		Good zeroThing = new BasicGood ("zeroThing", "0.00");
		
		assertEquals(new BigDecimal ("0.00"), book.getSaleTax());
		assertEquals(new BigDecimal ("12.49"), book.getTotalPrice());
		
		assertEquals(new BigDecimal("0.00"), chocolate.getSaleTax());
		assertEquals(new BigDecimal("0.85"), chocolate.getTotalPrice());
		
		assertEquals(new BigDecimal("0.00"), headachePills.getSaleTax());
		assertEquals(new BigDecimal("9.75"), headachePills.getTotalPrice());
		
		assertEquals(new BigDecimal("0.00"), veryCheapThing.getSaleTax());
		assertEquals(new BigDecimal("0.01"), veryCheapThing.getTotalPrice());
		
		assertEquals(new BigDecimal("0.00"), zeroThing.getSaleTax());
		assertEquals(new BigDecimal("0.00"), zeroThing.getTotalPrice());
	}
	
	@Test
	public void normalGoodsTest () throws NoNegativeValueException {
		
		Good musicCD = new NormalGood("music CD", "14.99");
		Good perfume = new NormalGood("bottle of perfume", "18.99");
		Good thing1 = new NormalGood ("thing1", "2.72");
		Good thing2 = new NormalGood ("thing2", "1.57");
		Good veryCheapThing = new NormalGood ("veryCheapThing", "0.01");
		Good zeroThing = new NormalGood ("zeroThing", "0.00");
		
		assertEquals(new BigDecimal("1.50"), musicCD.getSaleTax());
		assertEquals(new BigDecimal("16.49"), musicCD.getTotalPrice());
		
		assertEquals(new BigDecimal("1.90"), perfume.getSaleTax());
		assertEquals(new BigDecimal("20.89"), perfume.getTotalPrice());
		
		assertEquals(new BigDecimal("0.30"), thing1.getSaleTax());
		assertEquals(new BigDecimal("3.02"), thing1.getTotalPrice());
		
		assertEquals(new BigDecimal("0.20"), thing2.getSaleTax());
		assertEquals(new BigDecimal("1.77"), thing2.getTotalPrice());
		
		assertEquals(new BigDecimal("0.05"), veryCheapThing.getSaleTax());
		assertEquals(new BigDecimal("0.06"), veryCheapThing.getTotalPrice());
		
		assertEquals(new BigDecimal("0.00"), zeroThing.getSaleTax());
		assertEquals(new BigDecimal("0.00"), zeroThing.getTotalPrice());
	}
	
	@Test
	public void ImportedBasicsGood () throws NoNegativeValueException {
		
		Good importedChocolate1 = new ImportedBasicGood("chocolate1", "10.00");
		Good importedChocolate2 = new ImportedBasicGood("chocolate2", "11.25");
		Good importedThing1 = new ImportedBasicGood("thing1", "0.51");
		Good veryCheapThing = new ImportedBasicGood("veryCheapThing", "0.01");
		Good zeroThing = new ImportedBasicGood("zeroThing", "0.00");
		
		assertEquals(new BigDecimal("0.50"), importedChocolate1.getSaleTax());
		assertEquals(new BigDecimal("10.50"), importedChocolate1.getTotalPrice());
		
		assertEquals(new BigDecimal("0.60"), importedChocolate2.getSaleTax());
		assertEquals(new BigDecimal("11.85"), importedChocolate2.getTotalPrice());
		
		assertEquals(new BigDecimal("0.05"), importedThing1.getSaleTax());
		assertEquals(new BigDecimal("0.56"), importedThing1.getTotalPrice());
		
		assertEquals(new BigDecimal("0.05"), veryCheapThing.getSaleTax());
		assertEquals(new BigDecimal("0.06"), veryCheapThing.getTotalPrice());
		
		assertEquals(new BigDecimal("0.00"), zeroThing.getSaleTax());
		assertEquals(new BigDecimal("0.00"), zeroThing.getTotalPrice());
	}
	
	@Test
	public void ImportedNormalGood () throws NoNegativeValueException {
		
		Good importedPerfume = new ImportedNormalGood("perfume", "47.5");
		Good importedThing1 = new ImportedNormalGood("thing1", "0.01");
		Good importedThing2 = new ImportedNormalGood("thing2", "0.51");
		Good veryCheapThing = new ImportedNormalGood("veryCheapThing", "0.01");
		Good zeroThing = new ImportedNormalGood("zeroThing", "0.00");
		
		assertEquals(new BigDecimal("7.15"), importedPerfume.getSaleTax());
		assertEquals(new BigDecimal("54.65"), importedPerfume.getTotalPrice());
		
		assertEquals(new BigDecimal("0.05"), importedThing1.getSaleTax());
		assertEquals(new BigDecimal("0.06"), importedThing1.getTotalPrice());
		
		assertEquals(new BigDecimal("0.10"), importedThing2.getSaleTax());
		assertEquals(new BigDecimal("0.61"), importedThing2.getTotalPrice());
		
		assertEquals(new BigDecimal("0.05"), veryCheapThing.getSaleTax());
		assertEquals(new BigDecimal("0.06"), veryCheapThing.getTotalPrice());
		
		assertEquals(new BigDecimal("0.00"), zeroThing.getSaleTax());
		assertEquals(new BigDecimal("0.00"), zeroThing.getTotalPrice());
	}

}
