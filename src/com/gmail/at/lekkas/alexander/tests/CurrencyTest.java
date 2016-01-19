package com.gmail.at.lekkas.alexander.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gmail.at.lekkas.alexander.production.Currency;
import com.gmail.at.lekkas.alexander.production.InvalidUserInputException;

public class CurrencyTest {
	
	@Test
	public void should_be_able_to_create_specified_currency_object_given_valid_currency() throws InvalidUserInputException{
		assertEquals("USD", new Currency("USD").getName());
	}
	
	@Test
	public void should_be_able_to_fetch_a_currency_rate_from_the_web(){
		
	}
	
}
