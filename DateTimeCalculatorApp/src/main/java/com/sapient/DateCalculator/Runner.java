package com.sapient.DateCalculator;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;


public class Runner {

	public static void main(String[] args) {
		
		System.out.println("Welcome to a DateTimeCalculator Application");
		System.out.println("Enter a Date On which You want TO perform Opertions on");
		Scanner rd = new Scanner(System.in);
		String s = rd.nextLine();		
		Date date = new Date(s);
		System.out.println(date);
		String Function = rd.nextLine();
		NaturalLanguageConverter.FunctionParser(Function,date); 

	}
}
