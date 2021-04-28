package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.LendingController;
import com.imatia.bookmanager.model.entities.Lending;
import com.imatia.bookmanager.view.inputs.InputUserData;

import com.imatia.bookmanager.view.results.LendingDetails;
import com.imatia.bookmanager.view.results.LendingRenderers;

import com.imatia.bookmanager.view.ui.ResultsSearchLendingUi;
import com.imatia.bookmanager.view.ui.SearchLendingUi;

public class SearchLendingMenu {

	public static void showSearchLendingMenuOptions() {
		LendingController lc = new LendingController();
		String option;
		String filter;
		Lending lending;

		do {
			option = InputUserData.checkUserInput("option", "Opcion no válida. Pruebe de nuevo(entero positivo)");
			if(!option.equals("") && !option.equals("0") && !option.equals("1") && !option.equals("2")
				&& !option.equals("3")){
					System.out.println("Opcion no válida. Pruebe de nuevo(entero positivo)");
				}
		} while (!option.equals("0") && !option.equals("1") && !option.equals("2")
				&& !option.equals("3"));
		switch (Integer.parseInt(option)) {

		case 0:
			SearchLendingUi.showSearchLendingUi();
			break;
		case 1:
			do {
				System.out.print("Introduzca el id del prestamo: (entero positivo) ");
				filter = InputUserData.checkUserInput("id","Pruebe de nuevo(entero positivo)");
			} while (filter.equals(""));
			lending = lc.getLendingById(Integer.valueOf(filter));
			LendingDetails.showLendingDetalis(lending);

			break;
		case 2:
			do {
				System.out.print("Introduzca el id del usuario:  (entero positivo) ");
				filter = InputUserData.checkUserInput("id","Pruebe de nuevo(entero positivo)");
			} while (filter.equals(""));
		
			ResultsSearchLendingUi.showResultsSearchLendingUi("identificador de usuario");
			// just pull out a list
			LendingRenderers.renderUserIdListLending(lc.getLendingByUserId(Integer.valueOf(filter)));
			//Details
			do {
				System.out.print("Introduzca el id del prestamo: (entero positivo) ");
				filter = InputUserData.checkUserInput("id","Pruebe de nuevo(entero positivo)");
			} while (filter.equals(""));
			lending = lc.getLendingById(Integer.valueOf(filter));
			LendingDetails.showLendingDetalis(lending);
			break;
		case 3:
			do {
				System.out.print("Introduzca la fecha de devolución: (dd-mm-yyyy) ");
				filter = InputUserData.checkUserInput("date","Formato fecha(dd-mm-yyyy)");
			} while (filter.equals(""));
		
			ResultsSearchLendingUi.showResultsSearchLendingUi("fecha de devolución");
		
			
			//to pass the date as localDate it has to have this format
			String year = filter.substring(6, 10);
			String month = filter.substring(3, 5);
			String day =filter.substring(0, 2);
			String newDate = year +"-"+month +"-"+day;
			
			
			
			// newDate is a string
			 LendingRenderers.renderDateListLending(lc.getLendingByDeadLine(newDate));
		
			//Details
			do {
				System.out.print("Introduzca el id del prestamo: (entero positivo) ");
				filter = InputUserData.checkUserInput("id","Pruebe de nuevo(entero positivo)");
			} while (filter.equals(""));
			lending = lc.getLendingById(Integer.valueOf(filter));
			LendingDetails.showLendingDetalis(lending);
			
			break;
		}

	}

}
