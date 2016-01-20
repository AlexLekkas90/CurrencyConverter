package com.gmail.at.lekkas.alexander.production;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Converter {
	private String URL = "http://api.fixer.io/latest?symbols=";
	private JSONObject rates;

	public double convert(String startCurrency, String endCurrency, double ammount) throws InvalidUserInputException {
		rates = fetchCurrencies();
		if (!validInput(startCurrency.toUpperCase(), endCurrency.toUpperCase())) {
			throw new InvalidUserInputException("User input not a valid currency");
		}
		return calculateResult(startCurrency, endCurrency, ammount);
	}

	private boolean validInput(String startCurrency, String endCurrency) {
		if (rates.get(startCurrency) != null && rates.get(endCurrency) != null) {
			return true;
		}
		return false;
	}

	public void setURL(String url) {
		URL = url;
	}

	public String getURL() {
		return URL;
	}

	private double calculateResult(String startCurrency, String endCurrency, double ammount) {
		double startCurrencyRate = (Double) rates.get(startCurrency.toUpperCase());
		double endCurrencyRate = (Double) rates.get(endCurrency.toUpperCase());
		if (new Double((startCurrencyRate)).equals(0.0)) {
			return -1.0;
		}
		double startCurrencyInEuro = (ammount / startCurrencyRate);
		return (startCurrencyInEuro * endCurrencyRate);
	}

	private JSONObject fetchCurrencies() {
		JSONParser jsonParser = new JSONParser();
		JSONObject json = null;
		try {
			json = (JSONObject) jsonParser.parse(URLReader.read(URL));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return (JSONObject) json.get("rates");
	}

}
