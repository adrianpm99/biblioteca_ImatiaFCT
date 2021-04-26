package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.SearchUserUi;

public class UserDetailsMenu {

	public static void showUserDetailsMenuOptions(int id) {

		int option;

		do {
			option = Integer.parseInt(
					InputUserData.checkUserInput("option", "Opcion no valida. Pruebe de nuevo (entero positivo)"));

			switch (option) {
			case 0:
				SearchUserUi.showSearchUserUi();
				break;
			case 1:

				// Not implemented yet
				// modifyUserUi
				break;
			case 2:
				//Not implemented yet
				//deleteUserUi

			}

		} while (option != 0 && option != 1 && option !=2);
	}

}
