package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.SearchLendingUi;

public class LendingDetailsMenu {
	public static void showLendingDetailsMenuOptions(int id) {

		String option;

		do {
			option = InputUserData.checkUserInput("option", "Opcion no valida. Pruebe de nuevo (entero positivo)");
		} while (option.equals("") && !option.equals("0") && !option.equals("1"));

		switch (Integer.parseInt(option)) {
		case 0:
			SearchLendingUi.showSearchLendingUi();
			break;
		case 1:
			CloseLendingMenu.showCloseLendingMenu(id);
			break;
		
		}

	}

}
