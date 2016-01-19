package com.gmail.at.lekkas.alexander.production;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class UserInputValidator {
	private final static String URL = "http://api.fixer.io/latest";
	
	public static boolean isInputValidCurrency(String userInput){
		Double selectedCurrencyRate = -1.0;
		if (userInput.length() <= 3) {
			try {
				selectedCurrencyRate = (Double) fetchAllCurrencies().get(userInput);
			} catch (InvalidUserInputException e) {
				return false;
			}
			if (selectedCurrencyRate != null && selectedCurrencyRate.doubleValue() > -1) {
				return true;
			} else {
				return false;
			}
		}
			return false;
	}
	
	private static JSONObject fetchAllCurrencies() throws InvalidUserInputException {
		JSONParser jsonParser = new JSONParser();
		JSONObject json;
		try {
			json = (JSONObject) jsonParser.parse(URLReader.read(URL));
		} catch (ParseException e) {
			throw new InvalidUserInputException("Not a valid currency");
		}
		return (JSONObject) json.get("rates");
	}
	
}
