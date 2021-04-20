package com.imatia.bookmanager.view.controller;

import com.imatia.bookmanager.view.menus.SearchesMenu;

public class StartMenuController {

	public static void showStartMenuOption() {
		int option;

		do {
			option = 1;// getInput

			switch (option) {

			case 0:
				System.out.println("\nFinalizando la ejecución del programa");
				System.exit(0);
			case 1:
				SearchesMenu.showSearchesMenu();
				break;
			case 2:
				// Not implemented yet
			case 3:
				// Not implemented yet
			}

		} while (option != 0 && option != 1 && option != 2 && option != 3);

	}

}
