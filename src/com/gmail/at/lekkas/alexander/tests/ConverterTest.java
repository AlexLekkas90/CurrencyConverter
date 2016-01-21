package com.gmail.at.lekkas.alexander.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gmail.at.lekkas.alexander.production.Converter;
import com.gmail.at.lekkas.alexander.production.InvalidUserInputException;

public class ConverterTest {

	@Test
	public void converter_should_convert_from_USD_to_GBP() throws InvalidUserInputException{
		Converter converter = new Converter();
		converter.setURL("https://raw.githubusercontent.com/AlexLekkas90/CurrencyConverter/master/test%20resources/TestRates.json");
		assertEquals("converter converts 100 USD to GBP assuming rate of 1:1", 0, Double.compare(100.0, converter.convert("USD", "GBP", 100.0)));
	}
	
	@Test
	public void converter_should_convert_from_GBP_to_USD() throws InvalidUserInputException{
		Converter converter = new Converter();
		converter.setURL("https://raw.githubusercontent.com/AlexLekkas90/CurrencyConverter/master/test%20resources/TestRates.json");
		assertEquals("converter converts 100 GBP to USD assuming rate of 1:1", 0, Double.compare(100.0, converter.convert("GBP", "USD", 100.0)));
	}
	
	@Test
	public void converter_should_convert_from_EUR_to_EUR() throws InvalidUserInputException{
		Converter converter = new Converter();
		converter.setURL("https://raw.githubusercontent.com/AlexLekkas90/CurrencyConverter/master/test%20resources/TestRates.json");
		assertEquals("Converter converts 100 EUR to 100 EUR without throwing an exception, EUR is an edge case", 0, Double.compare(100.0, converter.convert("eur", "EUR", 100.0)));
	}
	
	@Test
	public void converter_should_convert_from_EUR_to_USD() throws InvalidUserInputException{
		Converter converter = new Converter();
		converter.setURL("https://raw.githubusercontent.com/AlexLekkas90/CurrencyConverter/master/test%20resources/TestRates.json");
		assertEquals("Converter converts 100 EUR to 100 USD without throwing an exception, EUR is an edge case", 0, Double.compare(100.0, converter.convert("EUR", "USD", 100.0)));
	}
	
	@Test
	public void converter_should_convert_from_USD_to_EUR() throws InvalidUserInputException{
		Converter converter = new Converter();
		converter.setURL("https://raw.githubusercontent.com/AlexLekkas90/CurrencyConverter/master/test%20resources/TestRates.json");
		assertEquals("Converter converts 100 USD to 100 EUR without throwing an exception, EUR is an edge case", 0, Double.compare(100.0, converter.convert("USD", "EUR", 100.0)));
	}
	
	@Test
	public void should_convert_valid_lower_and_upper_case_currencies() throws InvalidUserInputException{
		Converter converter = new Converter();
		converter.setURL("https://raw.githubusercontent.com/AlexLekkas90/CurrencyConverter/master/test%20resources/TestRates.json");
		assertEquals("converter converts 100 USD to GBP assuming rate of 1:1 and given the values in lower case", 0, Double.compare(100.0, converter.convert("usd", "gbp", 100.0)));
	}
	
	@Test(expected = InvalidUserInputException.class)
	public void should_throw_an_exception_when_invalid_user_input_for_first_currency() throws InvalidUserInputException{ 
		Converter converter = new Converter();
		converter.setURL("https://raw.githubusercontent.com/AlexLekkas90/CurrencyConverter/master/test%20resources/TestRates.json");
		assertEquals("Returns InvalidUserInputException when attempting to convert from 123 to USD", 0, Double.compare(100.0, converter.convert("123", "USD", 100.0)));
	}
	
	@Test(expected = InvalidUserInputException.class)
	public void should_throw_an_exception_when_invalid_user_input_for_second_currency() throws InvalidUserInputException{ 
		Converter converter = new Converter();
		converter.setURL("https://raw.githubusercontent.com/AlexLekkas90/CurrencyConverter/master/test%20resources/TestRates.json");
		assertEquals("Returns InvalidUserInputException when attempting to convert from USD to 1234", 0, Double.compare(100.0, converter.convert("USD", "1234", 100.0)));
	}
}
