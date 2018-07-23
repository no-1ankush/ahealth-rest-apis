package com.ahealth.api.rest.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AHealthRestUtility {
	
	/**
	 * Converts the current system date in format of YYYY-MM-DD
	 * @return String
	 */
	public static String getCurrentDateAsString() {
		return new SimpleDateFormat("yyyy-MM-dd")
						.format(Calendar.getInstance().getTime());
	}
	
	/**
	 * Converts provided date information in the format of YYYY-MM-DD
	 *  
	 * @param year
	 * @param month
	 * @param date
	 * @return String
	 */
	public static String getDateAsString(int year, int month, int date) {
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DATE, date);
        
		return new SimpleDateFormat("yyyy-MM-dd")
						.format(cal.getTime());
	}
	
	/**
	 * Converts provided date information in the format of YYYY-MM-DD
	 *  
	 * @param calendar
	 * @return String
	 */
	public static String getDateAsString(Calendar calendar) {
		return getDateAsString(calendar.get(Calendar.YEAR),
								calendar.get(Calendar.MONTH),
								calendar.get(Calendar.DATE));
	}
	/**
	 * Converts the String to Calendar
	 * 
	 * @param inputString
	 * @return Calendar
	 */
	public static Calendar getStringAsCalendar(String inputString) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(inputString));
			return calendar;
		} catch (ParseException e) {
			return null;
		}
	}
}
