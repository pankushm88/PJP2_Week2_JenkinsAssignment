package com.sapient.DateCalculator;

public class DateTimeOperations {
	
	final String[] DAY_STRING = {" days "," day "};
	final String[] MONTH_STRING = {" months "," month "};
	final String[] YEAR_STRING = {" years "," year "};
	
	public Date add(Date d1,Date d2) {
		d1.addYears(d2.getYear());
		d1.addMonths(d2.getMonth());
		d1.addDays(d2.getdays());
		return d1;
	}
	
	public Date sub(Date d1,Date d2) {
		try {
			d1.subtractYears(d2.getYear());
			if(d1.getMonth() != d2.getMonth())
				d1.subtractMonths(d2.getMonth());
			else
				d1.setMonth(0);
			if(d1.getdays() != d2.getdays()) 
				d1.subtractDays(d2.getdays());
			else
				d1.setdays(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d1;
	}
	
	
	public String subtractinformatdaysmonthsyears(Date d1,Date d2) {
		d1 = sub(d1,d2);
		String result = "";
		if(d1.getdays()>0) {
			result += d1.getdays() + (d1.getdays() == 1 ? DAY_STRING[1] : DAY_STRING[0]);
		}
		if(d1.getMonth()>0) {
			result += d1.getMonth() + (d1.getMonth() == 1 ? MONTH_STRING[1] : MONTH_STRING[0]);
		}
		if(d1.getYear()>0) {
			result += d1.getYear() + (d1.getYear() == 1 ? YEAR_STRING[1] : YEAR_STRING[0]);
		}
		return result.trim();
	}
	
	public String subtractindays(Date d1,Date d2) {
		d1 = sub(d1, d2);
		double totalDays = d1.getYear()*365.25 + d1.getMonth()*30.355 + d1.getdays();
		return (int)totalDays + (totalDays == 1 ? DAY_STRING[1] : DAY_STRING[0]);
	}
	
	public static void weeknumber(Date d) {
		System.out.println(d.weekNumber());
	}
	
	public static void dayofweek(Date d) {
		System.out.println(d.getDay());
	}
	public static void tomorrow(Date d){
		d.addDays(1);
		System.out.println(d);
	}
	public static void dayaftertomorrow(Date d){	
		d.addDays(2);
		System.out.println(d);
	}
	public static void yesterday(Date d) throws Exception
	{
		d.subtractDays(1);
		System.out.println(d);
	}
	public static void  daybeforeyesterday(Date d) throws Exception
	{
		d.subtractDays(2);
		System.out.println(d);
	}
	public static void lastweek(Date d) throws Exception
	{
		d.subtractWeeks(1);
		System.out.println(d);
	}
	public static void nextweek(Date d) {
		d.addWeeks(1);
		System.out.println(d);
	}
	public static void nextmonth(Date d)
	{
		d.addMonths(1);
		System.out.println(d);
	}
	public static void lastmonth(Date d) throws Exception
	{
		d.subtractMonths(1);
		System.out.println(d);
	}
	public static void nextyear(Date d)
	{
		d.addYears(1);
		System.out.println(d);
	}
	public static void lastyear(Date d) throws Exception
	{
		d.subtractYears(1);
		System.out.println(d);
	}
	public static void nweeksafter(Date d,int n)
	{
		d.addWeeks(n);
		System.out.println(d);
	}
	public static void ndaysafter(Date d,int n)
	{
		d.addDays(n);
		System.out.println(d);
	}
	public static void nmonthsafter(Date d,int n)
	{
		d.addMonths(n);
		System.out.println(d);
	}
	public static void nyearsafter(Date d,int n)
	{
		d.addYears(n);
		System.out.println(d);
	}
	public static void nweeksbefore(Date d,int n) throws Exception
	{
		d.subtractWeeks(n);
		System.out.println(d);
	}
	public static void ndaysbefore(Date d,int n) throws Exception
	{
		d.subtractDays(n);
		System.out.println(d);
	}
	public static void nmonthsbefore(Date d,int n) throws Exception
	{
		d.subtractMonths(n);
		System.out.println(d);
	}
	public static void nyearsbefore(Date d,int n) throws Exception
	{
		d.subtractYears(n);
		System.out.println(d);
	}
	
}
