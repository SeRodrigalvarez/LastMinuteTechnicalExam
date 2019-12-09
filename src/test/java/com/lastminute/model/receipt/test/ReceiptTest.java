package com.lastminute.model.receipt.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.lastminute.model.goods.BasicGood;
import com.lastminute.model.goods.Good;
import com.lastminute.model.goods.ImportedBasicGood;
import com.lastminute.model.goods.ImportedNormalGood;
import com.lastminute.model.goods.NormalGood;
import com.lastminute.model.goods.exceptions.NoNegativeValueException;
import com.lastminute.model.receipt.Receipt;

@RunWith(JUnit4.class)
public class ReceiptTest {
	
	@Test
	public void receiptTest () throws NoNegativeValueException {
		
		Receipt receipt1 = new Receipt();
		
		Good book = new BasicGood("book", "12.49");
		Good musicCD = new NormalGood("music CD", "14.99");
		Good chocolate = new BasicGood("chocolate bar", "0.85");
		
		receipt1.add(book);
		receipt1.add(musicCD);
		receipt1.add(chocolate);
		
		System.out.print("Output 1:\n" + receipt1 + "\n");
		
		Receipt receipt2 = new Receipt();
		
		Good importedChocolate1 = new ImportedBasicGood("imported box of chocolates", "10.00");
		Good importedPerfume1 = new ImportedNormalGood("imported bottle of perfume", "47.5");
		
		receipt2.add(importedChocolate1);
		receipt2.add(importedPerfume1);
		
		System.out.print("Output 2:\n" + receipt2 + "\n");
		
		Receipt receipt3 = new Receipt();
		
		Good importedPerfume2 = new ImportedNormalGood("imported bottle of perfume", "27.99");
		Good perfume = new NormalGood("imported bottle of perfume", "18.99");
		Good headachePills = new BasicGood ("packet of headache pills", "9.75");
		Good importedChocolate2 = new ImportedBasicGood("box of imported chocolates", "11.25");
		
		receipt3.add(importedPerfume2);
		receipt3.add(perfume);
		receipt3.add(headachePills);
		receipt3.add(importedChocolate2);
		
		System.out.print("Output 3:\n" + receipt3 + "\n");
	}

}
