package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.LendingController;
import com.imatia.bookmanager.model.entities.Lending;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.results.LendingDetails;
import com.imatia.bookmanager.view.ui.SearchLendingUi;

public class SearchLendingMenu {

	public static void showSearchLendingMenuOptions() {
		LendingController lc = new LendingController();
		String option;
		String filter;

		do {
			option = InputUserData.checkUserInput("option", "Opcion no válida. Pruebe de nuevo(entero positivo)");
		} while (option.equals("") && !option.equals("0") && !option.equals("1") && !option.equals("2")
				&& !option.equals("3"));
		switch (Integer.parseInt(option)) {

		case 0:
			SearchLendingUi.showSearchLendingUi();
			break;
		case 1:
			do {
				System.out.print("Introduzca el id del prestamo: ");
				filter = InputUserData.checkUserInput("id","Pruebe de nuevo(entero positivo)");
			} while (filter.equals(""));
			Lending lending = lc.getLendingById(Integer.valueOf(filter));
			LendingDetails.showLendingDetalis(lending);

			break;
		case 2:
			// not implemented yet

			break;
		case 3:
			// not implemented yet
			break;
		}

	}

}
