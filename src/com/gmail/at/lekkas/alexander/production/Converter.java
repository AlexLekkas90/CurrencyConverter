package com.gmail.at.lekkas.alexander.production;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Converter {
	private String URL = "http://api.fixer.io/latest";
	private JSONObject rates;

	public double convert(String startCurrency, String endCurrency, double ammount) throws InvalidUserInputException {
		rates = fetchCurrencies();
		if (!validInput(startCurrency.toUpperCase(), endCurrency.toUpperCase())) {
			throw new InvalidUserInputException("User input contains invalid currency name");
		}
		return calculateResult(startCurrency.toUpperCase(), endCurrency.toUpperCase(), ammount);
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

	private boolean validInput(String startCurrency, String endCurrency) {
		if ((rates.get(startCurrency) != null || startCurrency.equals("EUR"))
				&& (rates.get(endCurrency) != null || endCurrency.equals("EUR"))) {
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

	private double calculateResult(String startCurrency, String endCurrency, double amount) {
		if (startCurrency.equals(endCurrency)){
			return roundResult(amount);
		} else if (endCurrency.equals("EUR")) {
			double startCurrencyRate = (Double) rates.get(startCurrency);
			if (new Double((startCurrencyRate)).equals(0.0)) {
				return -1.0;
			}
			return roundResult(amount / startCurrencyRate);
		} else if (startCurrency.equals("EUR")) {
			double endCurrencyRate = (Double) rates.get(endCurrency);
			return roundResult(amount * endCurrencyRate);
		}
		double startCurrencyRate = (Double) rates.get(startCurrency);
		double endCurrencyRate = (Double) rates.get(endCurrency);
		if (new Double((startCurrencyRate)).equals(0.0)) {
			return -1.0;
		}
		double startCurrencyInEuro = (amount / startCurrencyRate);
		double result = roundResult(startCurrencyInEuro * endCurrencyRate);
		return result;
	}

	private double roundResult(double result) {
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		return Double.parseDouble(df.format(result));
	}

}
