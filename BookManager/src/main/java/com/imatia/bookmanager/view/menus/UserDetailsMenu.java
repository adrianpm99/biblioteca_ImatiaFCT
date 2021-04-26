package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.SearchUserUi;

public class UserDetailsMenu {

	public static void showUserDetailsMenuOptions(int id) {

		String option;

		do {
			option = InputUserData.checkUserInput("option", "Opcion no valida. Pruebe de nuevo (entero positivo)");
		} while (option.equals("") && !option.equals("0") && !option.equals("1") && !option.equals("2"));

		switch (Integer.parseInt(option)) {
		case 0:
			SearchUserUi.showSearchUserUi();
			break;
		case 1:

			// Not implemented yet
			// modifyUserUi
			break;
		case 2:
			// Not implemented yet
			// deleteUserUi

		}

	}

}
