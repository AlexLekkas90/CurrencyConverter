package com.gmail.at.lekkas.alexander.production;

public final class Currency {
	private String name;
	private double lastRecordedRate;
	
	public Currency(String userInput) {
		setName(userInput);
		setRate(-1.0);
	}

	private void setName(String name) {
			this.name = name;
	}

	protected void setRate(double rate){
		lastRecordedRate = rate;
	}	
	
	public double getRate(){
		return lastRecordedRate;
	}

	public String getName() {
		return name;
	}


}
