package com.gmail.at.lekkas.alexander.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gmail.at.lekkas.alexander.production.Converter;
import com.gmail.at.lekkas.alexander.production.Currency;

public class ConverterTest {

	@Test
	public void converter_should_convert_from_USD_to_USD(){
		Currency usd = new Currency("USD");
		Currency gbp = new Currency("GBP");
		assertEquals("converter converts 100 USD to USD assuming rate of 1:1", 0, Double.compare(100.0, Converter.convert(usd, usd, 100.0)));
	}
	
}
