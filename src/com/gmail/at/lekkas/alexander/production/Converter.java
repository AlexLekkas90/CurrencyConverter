package com.gmail.at.lekkas.alexander.production;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Converter {
	private String URL = "http://api.fixer.io/latest?symbols=";

	public double convert(Currency startCurrency, Currency endCurrency, double ammount) {
		updateRates(startCurrency, endCurrency);//TODO move to Currency or new class?
		return calculateResult(startCurrency, endCurrency, ammount);
	}
	
	public void setURL(String url){
		URL = url;
	}
	
	public String getURL(){
		return URL;
	}

	private void updateRates(Currency startCurrency, Currency endCurrency) {
		JSONObject fetchedRates = fetchSpecifiedCurrencies(startCurrency, endCurrency);
		startCurrency.setRate((Double) fetchedRates.get(startCurrency.getName()));
		endCurrency.setRate((Double) fetchedRates.get(endCurrency.getName()));
	}

	private JSONObject fetchSpecifiedCurrencies(Currency currency1, Currency currency2){
		JSONParser jsonParser = new JSONParser();
		JSONObject json = null;
		try {
			json = (JSONObject) jsonParser.parse(URLReader.read(URL + currency1.getName() + "," + currency2.getName()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return (JSONObject) json.get("rates");
	}
	
	private double calculateResult(Currency startCurrency, Currency endCurrency, double ammount) {
		if(new Double(startCurrency.getRate()).equals(0.0)){return -0.1;}
		double startCurrencyInEuro = ammount / startCurrency.getRate();
		return startCurrencyInEuro * endCurrency.getRate();
	}
	
}
