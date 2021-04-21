package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.view.inputs.InputUserData;

public class BookDetailsMenu {

	public static void showBookDetailsOptions(int id) {

		int option;

		do {

			option = Integer.parseInt(InputUserData.checkUserInput("option"));

			switch (option) {
			
			case 0:
				//Not implemented yet
			case 1: 
				//Not implemented yet
			case 2:

				DeleteBookMenu.showDeleteBookMenu(id);


			}

		} while (option != 0 && option != 1 && option != 2);
	}

}
