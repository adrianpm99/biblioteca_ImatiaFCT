package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.LendingController;
import com.imatia.bookmanager.model.entities.Lending;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.results.LendingDetails;
import com.imatia.bookmanager.view.ui.SearchLendingUi;

public class SearchLendingMenu {

	public static void showSearchLendingMenuOptions() {
		LendingController lc = new LendingController();
		int option;
		String filter;

		do {
			option = Integer.parseInt(InputUserData.checkUserInput("option"));

			switch (option) {

			case 0:
				SearchLendingUi.showSearchLendingUi();
				break;
			case 1:
				System.out.print("Introduzca el id del prestamo: ");
				filter = InputUserData.checkUserInput("id");
				Lending lending =lc.getLendingById(Integer.valueOf(filter));
				LendingDetails.showLendingDetalis(lending);
				
				break;
			case 2:
				// not implemented yet

				break;
			case 3:
				// not implemented yet
				break;
			}
		} while (option != 0 && option != 1 && option != 2 && option != 3);
	}

}
