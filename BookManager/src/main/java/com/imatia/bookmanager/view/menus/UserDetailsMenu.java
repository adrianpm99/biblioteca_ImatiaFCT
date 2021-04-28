package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.EditUserUi;
import com.imatia.bookmanager.view.ui.SearchUserUi;
import com.imatia.bookmanager.view.ui.UserManagementUi;

public class UserDetailsMenu {

	public static void showUserDetailsMenuOptions(int id) {

		String option;

		do {
			option = InputUserData.checkUserInput("option", "Opcion no valida. Pruebe de nuevo (entero positivo)");
			if(!option.equals("") && !option.equals("0") && !option.equals("1") && !option.equals("2")) {
				System.out.println("Opcion no valida. Pruebe de nuevo (entero positivo)");
			}
		} while (!option.equals("0") && !option.equals("1") && !option.equals("2"));

		switch (Integer.parseInt(option)) {
		case 0:
			SearchUserUi.showSearchUserUi();
			break;
		case 1:
			EditUserUi.showEditUserUi(id);
			break;
		case 2:
			DeleteUserMenu.showDeleteUserMenu(id);
			UserManagementUi.showUserManagementUi();
		}

	}

}
