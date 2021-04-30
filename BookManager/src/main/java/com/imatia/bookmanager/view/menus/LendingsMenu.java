package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.SearchLendingUi;
import com.imatia.bookmanager.view.ui.StartMenuUI;

/*
 * this is the class to show the lending menu options
 */
public class LendingsMenu {
	public static void showLendingsOptions() {

		String option;

		do {
			option = InputUserData.checkUserInput("option", "Opcion no valida. Pruebe de nuevo (entero positivo)");
			if (!option.equals("") && !option.equals("0") && !option.equals("1") && !option.equals("2")
					&& !option.equals("3")) {
				System.out.println("Opcion no valida. Pruebe de nuevo (entero positivo)");
			}
		} while (!option.equals("0") && !option.equals("1") && !option.equals("2") && !option.equals("3"));

		switch (Integer.parseInt(option)) {
		case 0:
			StartMenuUI.showStartMenuUi();
			break;

		case 1:
			// option to insert lendings
			AddLendingMenu.showAddLendingMenu();
			break;

		case 2:
			// option to search lendings
			SearchLendingUi.showSearchLendingUi();

			break;

		case 3:
			// option to delete lendings
			CloseLendingMenu.showCloseLendingMenu();
			break;
		}

	}// showLendingDetailsOptions()
}// class LendingDetailsMenu