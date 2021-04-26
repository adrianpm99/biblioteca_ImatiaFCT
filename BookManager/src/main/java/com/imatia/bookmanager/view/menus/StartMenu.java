package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.AddBookUi;
import com.imatia.bookmanager.view.ui.LendingsUi;
import com.imatia.bookmanager.view.ui.SearchesUi;
import com.imatia.bookmanager.view.ui.UserManagementUi;

public class StartMenu {

	public static void showStartMenuOption() {
		int option;

		do {
			option = Integer.parseInt(InputUserData.checkUserInput("option"));

			switch (option) {

			case 0:
				System.out.println("\nFinalizando la ejecución del programa");
				System.exit(0);
			case 1:
				SearchesUi.showSearchesUi();
				break;
			case 2:
				LendingsUi.showLendingsUi();
				break;
			case 3:
				AddBookUi.showAddBookUi();
				break;
			case 4:
				UserManagementUi.showUserManagementUi();
				break;
			}

		} while (option != 0 && option != 1 && option != 2 && option != 3 && option != 4);

	}

}
