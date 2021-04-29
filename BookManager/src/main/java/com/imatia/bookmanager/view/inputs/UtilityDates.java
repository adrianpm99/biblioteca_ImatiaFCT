package com.imatia.bookmanager.view.inputs;

import java.time.LocalDate;

/**
 * 
 *date utilities method
 *
 */
public class UtilityDates {
	/**
	 * go from dd-mm-yyyy format to yyyy-mm-dd format
	 * 
	 * @param String
	 * @return String
	 */
	public static String  formatYearMonthDay(String date) {

		String newDate;
		if (date != null) {// to pass the date as localDate it has to have this format
			String year = date.substring(6, 10);
			String month = date.substring(3, 5);
			String day = date.substring(0, 2);
			newDate = year + "-" + month + "-" + day;
		}else {
			newDate = date;
		}
		return newDate;

	}

	/**
	 * go from yyyy-mm-dd format to dd-mm-yyyy  format
	 * 
	 * @param LocalDate
	 * @return LocalDate
	 */
	public static String  formatDayMonthYear(LocalDate date) {
		
		String newDate;
		if (date != null) {
			newDate = String.valueOf(date);
	
			String year = newDate.substring(0, 4);
			String month = newDate.substring(5, 7);
			String day = newDate.substring(8, 10);
			newDate = day + "-" + month + "-" + year;
			
		}else {
			newDate = "null";
		}
			
		return newDate;

	}
}
