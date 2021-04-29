package com.imatia.bookmanager.view.results;

import java.util.List;
import com.imatia.bookmanager.model.entities.Lending;
import com.imatia.bookmanager.view.inputs.UtilityDates;



/**
 * These utils receive a list of lending and then, according to the search
 * method, will print some specific basic data
 */
public class LendingRenderers {
	/**
	 * shows: lendingId, userId, lendingDate, lendingDeadLine, lendingReturnDate
	 * 
	 * @param lendingList
	 *            searched by userId
	 */
	public static void renderUserIdListLending(List<Lending> lendingList) {
		for (Lending l : lendingList) {
			System.out.println(
					"===========================================================================================\n");
			System.out.println("Id Prestamo: " + l.getLendingId() + "\t|| Id Usuario: " + l.getUserId()
					+ "\t|| Fecha Préstamo: " + UtilityDates.formatDayMonthYear(l.getLendingDate()) 
					+ "\t|| Fecha Devolución: " + UtilityDates.formatDayMonthYear(l.getLendingDeadLine())
					+ "\t|| Fecha Devuelto: " + UtilityDates.formatDayMonthYear(l.getLendingReturnDate()) + "\n");
		}
	}// renderUserIdListLending()

	/**
	 * shows: lendingId, userId, lendingDate, lendingReturnDate
	 * 
	 * @param lendingList
	 *            searched by lendingDeadLine
	 */
	public static void renderDateListLending(List<Lending> lendingList) {
		for (Lending l : lendingList) {
			System.out.println(
					"===========================================================================================\n");
			System.out.println(
					"Id Prestamo: " + l.getLendingId() + "\t|| Id Usuario: " + l.getUserId()
					+ "\t|| Fecha Préstamo: " + UtilityDates.formatDayMonthYear(l.getLendingDate()) 
					+ "\t|| Fecha Devolución: " + UtilityDates.formatDayMonthYear( l.getLendingDeadLine())
					+ "\t|| Fecha Devuelto: " + UtilityDates.formatDayMonthYear(l.getLendingReturnDate()) + "\n");
		}
	}// renderDateListLending()

}// class LendingRenderers
