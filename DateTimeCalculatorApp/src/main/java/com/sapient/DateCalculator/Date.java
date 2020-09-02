package com.sapient.DateCalculator;

import java.io.Serializable;

public class Date implements Serializable {
	private int days;
	private int month;
	private int year;
	
	final String[] DAYS = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	final int[][] MAX_DAYS_OF_MONTHS = {
				{31,28,31,30,31,30,31,31,30,31,30,31},
				{31,29,31,30,31,30,31,31,30,31,30,31}
			};
	
	public Date(int days, int month, int year) {
		super();
		this.days = days;
		this.month = month;
		this.year = year;
	}
	
	public Date(String date) {
		String[] s = date.split("/");
		this.days = Integer.parseInt(s[0]);
		this.month = Integer.parseInt(s[1]);
		this.year = Integer.parseInt(s[2]);
	}
	
	public int getdays() {
		return days;
	}

	public void setdays(int days) {
		this.days = days;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDay() {
		
		int m = month;
		int k = days;
		int d = year%100;
		int c = year/100;
		
		//making months and years compatible to the formula
		if(m == 1 || m == 2) {
			d = (year-1)%100;
			c = (year-1)/100;
			m += 10;
		}
		else {
			m -= 2;
		}
		
		return DAYS[((k + (13*m-1)/5 + 5*d/4 + c/4 - 2*c)%7 + 7)%7];
	}

	@Override
	public String toString() {
		return "date [" + days + "/" + month + "/" + year + "]";
	}
	
	public void addDays(int d) {
		days += d;
		while(days>MAX_DAYS_OF_MONTHS[year%4 == 0 ? 1 : 0][month-1]) {
			days -= MAX_DAYS_OF_MONTHS[year%4 == 0 ? 1 : 0][month-1];
			month += 1;
			if(month>12) {
				month -= 12;
				year += 1;
			}
		}
	}
	
	public void subtractDays(int d) throws Exception {
		days -= d;
		while(days<=0) {
			month -= 1;
			if(month<=0) {
				month += 12;
				if(year>=1)
					year -= 1;
				else
					throw new Exception("Years can  not be negetive");
			}
			days += MAX_DAYS_OF_MONTHS[year%4 == 0 ? 1 : 0][month-1];
		}
	}
	
	public void addWeeks(int w) {
		addDays(w*7);
	}
	
	public void subtractWeeks(int w) throws Exception {
		subtractDays(w*7);
	}
	
	public void addMonths(int m) {
		year += m/12;
		month += m%12;
		if(month>12) {
			month-=12;
			year+=1;
		}
	}
	
	public void subtractMonths(int m) throws Exception {
		
		if(year>=m/12)
			year -= m/12;
		else
			throw new Exception("Years can  not be negetive");
		
		month -= m%12;
		if(month<=0) {
			month += 12;
			if(year>=1)
				year -= 1;
			else
				throw new Exception("Years can  not be negetive");
		}
	}
	
	public void addYears(int y) {
		year += y;
	}
	
	public void subtractYears(int y) throws Exception {
		if(year>=y)
			year -= y;
		else
			throw new Exception("Years can  not be negetive");
	}
	
	public int dayOfYear() {
		int days_of_year=0;
		for(int i=1;i<month;i++) {
			days_of_year += MAX_DAYS_OF_MONTHS[year%4 == 0 ? 1 : 0][month-1];
		}
		days_of_year += days;
		return days_of_year;
	}
	
	public int weekNumber() {
		int c = (year-1)/100;
		int d = (year-1)%100;
		int check = ((1 + 5*d/4 + c/4 - 2*c)%7 + 7)%7;
		if(check>=1 && check<=4)
			return this.dayOfYear()/7 + 1;
		else 
			return (this.dayOfYear()-(7-(check+6)%7))/7 + 1;
	}
	
	
	
}
