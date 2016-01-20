package com.gmail.at.lekkas.alexander.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gmail.at.lekkas.alexander.production.Converter;
import com.gmail.at.lekkas.alexander.production.Currency;

public class ConverterTest {

	@Test
	public void converter_should_convert_from_USD_to_USD(){
		Converter converter = new Converter();
		converter.setURL("http://raw.githubusercontent.com/AlexLekkas90/CurrencyConverter/master/test%20resources/TestRates.html");
		Currency usd = new Currency("USD");
		Currency gbp = new Currency("GBP");
		assertEquals("converter converts 100 USD to GBP assuming rate of 1:1", 0, Double.compare(100.0, converter.convert(usd, gbp, 100.0)));
	}
	
}
