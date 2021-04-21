package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.AddBookUi;
import com.imatia.bookmanager.view.ui.SearchesUi;

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
				SearchesUi.showSearchesMenu();
				break;
			case 2:
				// Not implemented yet
			case 3:
				AddBookUi.showAddBookMenu();
			}

		} while (option != 0 && option != 1 && option != 2 && option != 3);

	}

}
