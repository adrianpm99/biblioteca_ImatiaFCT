package com.imatia.bookmanager.view.menus;

import java.util.ArrayList;
import java.util.List;

import com.imatia.bookmanager.controller.BookController;
import com.imatia.bookmanager.controller.CopyController;
import com.imatia.bookmanager.controller.LendingController;
import com.imatia.bookmanager.controller.UserController;
import com.imatia.bookmanager.model.entities.Lending;
import com.imatia.bookmanager.model.entities.User;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.inputs.UtilityDates;
import com.imatia.bookmanager.view.results.LendingDetails;
import com.imatia.bookmanager.view.results.LendingRenderers;
import com.imatia.bookmanager.view.ui.LendingsUi;
import com.imatia.bookmanager.view.ui.ResultsSearchLendingUi;
import com.imatia.bookmanager.view.ui.SearchLendingUi;

/**
 * class to implement the search lending menu options
 * 
 * @author Grupo2FCTImatia
 *
 */

public class SearchLendingMenu {

	public static void showSearchLendingMenuOptions() {
		
		LendingController lc = new LendingController();
		UserController uc = new UserController();
		BookController bc = new BookController();
		String option;
		String filter;
		String filter2;
		Lending lending = null;
		User user;
		List<Integer> bookList = new ArrayList<>();
		List<Lending> lendingList = new ArrayList<>();

		do {
			option = InputUserData.checkUserInput("option", "Opcion no válida. Pruebe de nuevo(entero positivo)");
			if (!option.equals("") && !option.equals("0") && !option.equals("1") && !option.equals("2")
					&& !option.equals("3")) {
				System.out.println("Opcion no válida. Pruebe de nuevo(entero positivo)");
			}
		} while (!option.equals("0") && !option.equals("1") && !option.equals("2") && !option.equals("3"));
		switch (Integer.parseInt(option)) {

		case 0:
			//back to lending ui
			LendingsUi.showLendingsUi();
			break;
			
		case 1: // search by LendingId
			do {
				System.out.print("Introduzca el id del prestamo: (entero positivo) ");
				filter = InputUserData.checkUserInput("id", "Pruebe de nuevo(entero positivo)");
			} while (filter.equals(""));
		
			//get the lending filter by id -- return only one
			lending = lc.getLendingById(Integer.valueOf(filter));
			//if there are no results
			if (lending == null) {
				System.out.println("No se ha encontrando ningún prestamo con el id facilitado");
				SearchLendingUi.showSearchLendingUi();
			} else {
				//get the user of the lending
				user = uc.getUserById(lending.getUserId());
				//get the books of the lending
				bookList = bc.getListIdBookByCopysInLendingCopy(lending.getLendingId());
/*
				for (Integer i : bookList) {
					//get a String of book titles of the lending
					String bookTitle = bc.getBookById(i).getTitle();
					//get the copys of the book lending
					copyList = cc.getCopyIdInLendingByBook(lending.getLendingId(), bc.getBookById(i).getId());
					//building the strings to show the results
					bookCopys = "(Id Ejemplar:" + copyList.toString() 
									+ " Estado:["+cc.getCopyById(copyList.get(0)).getcopyNotes()+"])\r||\r";
	
					bookTitles = bookTitles + bookTitle + bookCopys + "|| ";
				}
				//show the lending details
			*/	LendingDetails.showLendingDetails(lending, user, bookList);
		//		LendingDetails.showLendingDetails(lending);
			}
			break;
		case 2: // Search by UserId
			do {
				System.out.print("Introduzca el id del usuario:  (entero positivo) ");
				filter = InputUserData.checkUserInput("id", "Pruebe de nuevo(entero positivo)");
			} while (filter.equals(""));

			// just pull out a list -- return a list
			lendingList = lc.getLendingByUserId(Integer.valueOf(filter));
			//if there are no results
			if (lendingList.isEmpty()) {
				System.out.println("No se ha econtrando ningún prestamo del usuario facilitado");
				SearchLendingUi.showSearchLendingUi();
			} else {
				//show result lendingList
				ResultsSearchLendingUi.showResultsSearchLendingUi("ID DE USUARIO");
				LendingRenderers.renderUserIdListLending(lendingList);
				// Details
				do {
					System.out.print("Introduzca el id del prestamo: (entero positivo) ");
					filter = InputUserData.checkUserInput("id", "Pruebe de nuevo(entero positivo)");
				} while (filter.equals(""));
				//get the user of the lending
				user = uc.getUserById(lending.getUserId());
				//get the books of the lending
				bookList = bc.getListIdBookByCopysInLendingCopy(lending.getLendingId());
/*
				for (Integer i : bookList) {
					//get a String of book titles of the lending
					String bookTitle = bc.getBookById(i).getTitle();
					//get the copys of the book lending
					copyList = cc.getCopyIdInLendingByBook(lending.getLendingId(), bc.getBookById(i).getId());
					//building the strings to show the results
					bookCopys = "(Id Ejemplar:" + copyList.toString() 
									+ " Estado:["+cc.getCopyById(copyList.get(0)).getcopyNotes()+"])\r||\r";
	
					bookTitles = bookTitles + bookTitle + bookCopys + "|| ";
				}
				//show the lending details
			*/	LendingDetails.showLendingDetails(lending, user, bookList);
		//		LendingDetails.showLendingDetails(lending);
			}
			break;
		case 3: // search by dates
			System.out.println("Introduzca un rango de fechas: ");
			do {
				System.out.print("Introduzca la primera fecha: (dd-mm-yyyy) ");
				filter = InputUserData.checkUserInput("date", "Formato fecha(dd-mm-yyyy)");
			} while (filter.equals(""));

			do {
				System.out.print("Introduzca la segunda fecha: (dd-mm-yyyy) ");
				filter2 = InputUserData.checkUserInput("date", "Formato fecha(dd-mm-yyyy)");
			} while (filter.equals(""));
			
			// to pass the first date as localDate it has to have this format
			String firtsDate = UtilityDates.formatYearMonthDay(filter);
			// to pass the second date as localDate it has to have this format
			String secondDate = UtilityDates.formatYearMonthDay(filter2);

			// firtsDate and secondDate are a string -- return a list
			lendingList = lc.getLendingByDeadLine(firtsDate, secondDate);
			//if there are no results
			if (lendingList.isEmpty()) {
				System.out.println("No se ha encontrado ningún prestamo con la fecha de devolución facilitada");
				SearchLendingUi.showSearchLendingUi();
			} else {
				//show result lendingList
				ResultsSearchLendingUi.showResultsSearchLendingUi("FECHA DE DEVOLUCIÓN");
				LendingRenderers.renderDateListLending(lendingList);

				// Details
				do {
					System.out.print("Introduzca el id del prestamo: (entero positivo) ");
					filter = InputUserData.checkUserInput("id", "Pruebe de nuevo(entero positivo)");
				} while (filter.equals(""));
				//get the user of the lending
				user = uc.getUserById(lending.getUserId());
				//get the books of the lending
				bookList = bc.getListIdBookByCopysInLendingCopy(lending.getLendingId());
/*
				for (Integer i : bookList) {
					//get a String of book titles of the lending
					String bookTitle = bc.getBookById(i).getTitle();
					//get the copys of the book lending
					copyList = cc.getCopyIdInLendingByBook(lending.getLendingId(), bc.getBookById(i).getId());
					//building the strings to show the results
					bookCopys = "(Id Ejemplar:" + copyList.toString() 
									+ " Estado:["+cc.getCopyById(copyList.get(0)).getcopyNotes()+"])\r||\r";
	
					bookTitles = bookTitles + bookTitle + bookCopys + "|| ";
				}
				//show the lending details
			*/	LendingDetails.showLendingDetails(lending, user, bookList);
		//		LendingDetails.showLendingDetails(lending);
			}
			break;
		}

	}//end showSearchLendingMenuOptions

}//end SearchLendingMenu
