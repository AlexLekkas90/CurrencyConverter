package com.gmail.at.lekkas.alexander.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gmail.at.lekkas.alexander.production.UserInputValidator;

public class UserInputValidatorTest {

	
	@Test
	public void isInputValidCurrency_should_return_true_for_valid_currency_USD(){
		assertTrue("Given the input string USD the validator returns true", UserInputValidator.isInputValidCurrency("USD"));
	}
	
	@Test
	public void isInputValidCurrency_should_return_false_for_invalid_currency_111(){
		assertFalse("Given the input string 111 the validator returns false", UserInputValidator.isInputValidCurrency("111"));
	}

	@Test
	public void isInputValidCurrency_should_return_false_for_invalid_currency_1111(){
		assertFalse("Given the input string 111 the validator returns false", UserInputValidator.isInputValidCurrency("1111"));
	}

}