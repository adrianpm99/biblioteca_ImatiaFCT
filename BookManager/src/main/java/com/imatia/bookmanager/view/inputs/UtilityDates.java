package com.imatia.bookmanager.view.inputs;

import java.time.LocalDate;

/**
 * Class to implement the methods to change Date format
 * 
 * @author Grupo2FCTImatia
 * 
 */

public class UtilityDates {

	/**
	 * Change Date format from dd-mm-yyyy to yyyy-mm-dd
	 * 
	 * @param String
	 * @return String
	 */

	public static String formatYearMonthDay(String date) {

		String newDate;

		if (date != null) {// to pass the date as localDate it has to have this format

			String year = date.substring(6, 10);
			String month = date.substring(3, 5);
			String day = date.substring(0, 2);
			newDate = year + "-" + month + "-" + day;

		} else {

			newDate = date;

		}

		return newDate;

	}// formatYearMonthDay

	/**
	 * Change Date format from yyyy-mm-dd to dd-mm-yyyy
	 * 
	 * @param LocalDate
	 * @return LocalDate
	 */

	public static String formatDayMonthYear(LocalDate date) {

		String newDate;

		if (date != null) {

			newDate = String.valueOf(date);

			String year = newDate.substring(0, 4);
			String month = newDate.substring(5, 7);
			String day = newDate.substring(8, 10);
			newDate = day + "-" + month + "-" + year;

		} else {

			newDate = "null";

		}

		return newDate;

	}// formatDayMonthYear

}// class UtilityDates
