package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.EditBookUi;
import com.imatia.bookmanager.view.ui.SearchesUi;

/**
 * Class to show the book details menu options
 * 
 * @author Grupo2FCTImatia
 */

public class BookDetailsMenu {
	public static void showBookDetailsOptions(int id) {

		String option;

		do {

			// Ask for an option
			option = InputUserData.checkUserInput("option", "Opcion no valida. Pruebe de nuevo (entero positivo)");

			// Check if option is wrong
			if (!option.equals("") && !option.equals("0") && !option.equals("1") && !option.equals("2")) {
				System.out.println("Opcion no valida. Pruebe de nuevo (entero positivo)");
			}

		} while (!option.equals("0") && !option.equals("1") && !option.equals("2"));

		switch (Integer.parseInt(option)) {

		// Go to SearchesUi
		case 0:
			SearchesUi.showSearchesUi();
			break;

		// Go to EditBookUi
		case 1:
			EditBookUi.showEditBookUi(id);
			break;

		// Go to DeleteBookMenu
		case 2:
			DeleteBookMenu.showDeleteBookMenu(id);
			break;
		}

	}// showBookDetailsOptions()

}// class BookDetailsMenu