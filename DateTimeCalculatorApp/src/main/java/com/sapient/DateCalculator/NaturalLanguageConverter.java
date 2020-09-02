package com.sapient.DateCalculator;

import java.lang.reflect.InvocationTargetException;

public class NaturalLanguageConverter {
	
	public static boolean isNumeric(String str) { 
		  try {  
		    Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}

	public static Date FunctionParser(String function, Date date) {
		int n = 0; 
		String[] s = function.split(" ");
		if(isNumeric(s[0])) {
			n = Integer.parseInt(s[0]);
			s[0] = "n";
		}
		function = String.join("",s);
		DateTimeOperations dto = new DateTimeOperations();
		java.lang.reflect.Method method;
		try {
			if(n==0) {
				method = dto.getClass().getMethod(function,Date.class);
				method.invoke(dto,date);
			}
			else {
				method = dto.getClass().getMethod(function,Date.class,int.class);
				method.invoke(dto,date,n);
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
}
