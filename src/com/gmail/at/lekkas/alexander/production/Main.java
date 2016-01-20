package com.gmail.at.lekkas.alexander.production;

public class Main {
	
	public static void main(String[] args){
		Converter converter = new Converter();
		try {
			System.out.println(converter.convert(args[0], args[1], Double.parseDouble(args[2])) + " " + args[1]);
		} catch (NumberFormatException | InvalidUserInputException e) {
			if(e.getClass() == InvalidUserInputException.class){
				System.out.println(e.getMessage());
			} else{
				System.out.println("User input not a valid currency amount");
			}
		}
		
	}

}
