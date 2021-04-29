package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.AddUserUi;
import com.imatia.bookmanager.view.ui.SearchUserUi;
import com.imatia.bookmanager.view.ui.StartMenuUI;

public class UserManagementMenu {

	public static void showUserManagementMenuOptions() {

		String option;

		do {
			option = InputUserData.checkUserInput("option", "Opcion no válida. Pruebe de nuevo(entero positivo)");
			if(!option.equals("") && !option.equals("0") && !option.equals("1") && !option.equals("2")) {
				System.out.println("Opcion no válida. Pruebe de nuevo(entero positivo)");
			}
		} while (!option.equals("0") && !option.equals("1") && !option.equals("2"));

		switch (Integer.parseInt(option)) {

		case 0:
			StartMenuUI.showStartMenuUi();
			break;
		case 1:
			AddUserUi.showAddUserUi();
			break;
		case 2:
			SearchUserUi.showSearchUserUi();
			break;

		}

	}

}
