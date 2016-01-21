package com.gmail.at.lekkas.alexander.production;

public class Main {

	public static void main(String[] args) {
		Converter converter = new Converter();
		try {
			Double result = converter.convert(args[0], args[1], Double.parseDouble(args[2]));
			if (result < 0) {
				System.out.println("User input not a valid currency amount");
			} else {
				System.out.println(args[2] + " " + args[0].toUpperCase() + " is equivalent to " + result + " "
						+ args[1].toUpperCase());
			}
		} catch (NumberFormatException | InvalidUserInputException e) {
			if (e.getClass() == InvalidUserInputException.class) {
				System.out.println(e.getMessage());
			} else {
				System.out.println("User input not a valid currency amount");
			}
		}

	}

}
