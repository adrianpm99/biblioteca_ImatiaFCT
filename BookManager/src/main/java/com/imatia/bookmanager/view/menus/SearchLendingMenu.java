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
import com.imatia.bookmanager.view.results.LendingDetails;
import com.imatia.bookmanager.view.results.LendingRenderers;
import com.imatia.bookmanager.view.ui.LendingsUi;
import com.imatia.bookmanager.view.ui.ResultsSearchLendingUi;
import com.imatia.bookmanager.view.ui.SearchLendingUi;


public class SearchLendingMenu {

	public static void showSearchLendingMenuOptions() {
		LendingController lc = new LendingController();
		UserController uc = new UserController();
		BookController bc = new BookController();
		CopyController cc = new CopyController();
		String option;
		String filter;
		String filter2;
		Lending lending;
		String bookCopys="";
		User user;
		List<Integer> bookList = new ArrayList<>();
		List<Integer> copyList = new ArrayList<>();
		List<Lending> lendingList = new ArrayList<>();

		String bookTitles = "";

		do {
			option = InputUserData.checkUserInput("option", "Opcion no válida. Pruebe de nuevo(entero positivo)");
			if (!option.equals("") && !option.equals("0") && !option.equals("1") && !option.equals("2")
					&& !option.equals("3")) {
				System.out.println("Opcion no válida. Pruebe de nuevo(entero positivo)");
			}
		} while (!option.equals("0") && !option.equals("1") && !option.equals("2") && !option.equals("3"));
		switch (Integer.parseInt(option)) {

		case 0:
			LendingsUi.showLendingsUi();
			break;
		case 1:
			do {
				System.out.print("Introduzca el id del prestamo: (entero positivo) ");
				filter = InputUserData.checkUserInput("id", "Pruebe de nuevo(entero positivo)");
			} while (filter.equals(""));
			lending = lc.getLendingById(Integer.valueOf(filter));
			if (lending == null) {
				System.out.println("No se ha econtrando ningún prestamo con el id facilitado");
				SearchLendingUi.showSearchLendingUi();
			} else {
				user = uc.getUserById(lending.getUserId());
				bookList = bc.getListIdBookByCopysInLendingCopy(lending.getLendingId());
				

				for (Integer i : bookList) {

					String bookTitle = bc.getBookById(i).getTitle();
					copyList = cc.getCopyIdInLendingByBook(lending.getLendingId(),bc.getBookById(i).getId());
					
					bookCopys = copyList.toString();
					bookTitles = bookTitles + bookTitle + "(Ejemplar:"+ bookCopys+"), ";
				}

				LendingDetails.showLendingDetails(lending, user, bookTitles);
			}
			break;
		case 2:
			do {
				System.out.print("Introduzca el id del usuario:  (entero positivo) ");
				filter = InputUserData.checkUserInput("id", "Pruebe de nuevo(entero positivo)");
			} while (filter.equals(""));

			// just pull out a list
			lendingList = lc.getLendingByUserId(Integer.valueOf(filter));
			if (lendingList.isEmpty()) {
				System.out.println("No se ha econtrando ningún prestamo del usuario facilitado");
				SearchLendingUi.showSearchLendingUi();
			} else {
				ResultsSearchLendingUi.showResultsSearchLendingUi("ID DE USUARIO");
				LendingRenderers.renderUserIdListLending(lendingList);
				// Details
				do {
					System.out.print("Introduzca el id del prestamo: (entero positivo) ");
					filter = InputUserData.checkUserInput("id", "Pruebe de nuevo(entero positivo)");
				} while (filter.equals(""));
				lending = lc.getLendingById(Integer.valueOf(filter));
				user = uc.getUserById(lending.getUserId());
				bookList = bc.getListIdBookByCopysInLendingCopy(lending.getLendingId());

				for (Integer i : bookList) {

					String bookTitle = bc.getBookById(i).getTitle();
					bookTitles = bookTitles + bookTitle + ", ";
				}

				LendingDetails.showLendingDetails(lending, user, bookTitles);
			}
			break;
		case 3:
			System.out.println("Introduzca un rango de fechas: ");
			do {
				System.out.print("Introduzca la primera fecha: (dd-mm-yyyy) ");
				filter = InputUserData.checkUserInput("date", "Formato fecha(dd-mm-yyyy)");
			} while (filter.equals(""));
			
			do {
				System.out.print("Introduzca la segunda fecha: (dd-mm-yyyy) ");
				filter2= InputUserData.checkUserInput("date", "Formato fecha(dd-mm-yyyy)");
			} while (filter.equals(""));

			

			// to pass the first date as localDate it has to have this format
			String year = filter.substring(6, 10);
			String month = filter.substring(3, 5);
			String day = filter.substring(0, 2);
			String firtsDate = year + "-" + month + "-" + day;
			
			// to pass the second date as localDate it has to have this format
			year = filter2.substring(6, 10);
			month = filter2.substring(3, 5);
			day = filter2.substring(0, 2);
			String secondDate = year + "-" + month + "-" + day;
			

			// firtsDate and secondDate are a string
			lendingList = lc.getLendingByDeadLine(firtsDate, secondDate);
			if (lendingList.isEmpty()) {
				System.out.println("No se ha encontrado ningún prestamo con la fecha de devolución facilitada");
				SearchLendingUi.showSearchLendingUi();
			} else {
				ResultsSearchLendingUi.showResultsSearchLendingUi("FECHA DE DEVOLUCIÓN");
				LendingRenderers.renderDateListLending(lendingList);

				// Details
				do {
					System.out.print("Introduzca el id del prestamo: (entero positivo) ");
					filter = InputUserData.checkUserInput("id", "Pruebe de nuevo(entero positivo)");
				} while (filter.equals(""));
				lending = lc.getLendingById(Integer.valueOf(filter));
				user = uc.getUserById(lending.getUserId());
				bookList = bc.getListIdBookByCopysInLendingCopy(lending.getLendingId());

				for (Integer i : bookList) {

					String bookTitle = bc.getBookById(i).getTitle();
					bookTitles = bookTitles + bookTitle + ", ";
				}

				LendingDetails.showLendingDetails(lending, user, bookTitles);
			}
			break;
		}

	}

}
