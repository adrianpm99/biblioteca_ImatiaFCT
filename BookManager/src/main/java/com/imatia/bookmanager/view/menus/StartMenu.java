package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.AddBookUi;
import com.imatia.bookmanager.view.ui.LendingsUi;
import com.imatia.bookmanager.view.ui.SearchesUi;
import com.imatia.bookmanager.view.ui.UserManagementUi;

public class StartMenu {

	public static void showStartMenuOption() {
		String option;

		do {
			option = InputUserData.checkUserInput("option", "Opcion no valida. Pruebe de nuevo (entero positivo)");
		} while (option.equals("") && !option.equals("0") && !option.equals("1") && !option.equals("2") && 
				!option.equals("3") && !option.equals("4"));

			switch (Integer.parseInt(option)) {

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

		

	}

}
