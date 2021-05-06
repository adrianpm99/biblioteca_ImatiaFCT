package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.SearchLendingUi;

/**
 *class to show menu options of lending details
 * 
 * @author Grupo2FCTImatia
 *
 */

public class LendingDetailsMenu {
	
	/**
	 * show menu options of lending details
	 * @param id
	 */
	
	public static void showLendingDetailsMenuOptions(int id) {

		String option;

		do {
			option = InputUserData.checkUserInput("option", "Opcion no valida. Pruebe de nuevo (entero positivo)");
			if(!option.equals("") && !option.equals("0") && !option.equals("1")) {
				System.out.println("Opcion no valida. Pruebe de nuevo (entero positivo)");
			}
		} while (!option.equals("0") && !option.equals("1"));

		switch (Integer.parseInt(option)) {
		case 0:
			SearchLendingUi.showSearchLendingUi();
			break;
		case 1:
			CloseLendingMenu.showCloseLendingMenu(id);
			break;
		}

	}//end showLendingDetailsMenuOptions

}//end LendingDetailsMenu
