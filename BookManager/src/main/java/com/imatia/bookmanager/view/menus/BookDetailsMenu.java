package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.SearchesUi;




public class BookDetailsMenu
{

	public static void showBookDetailsOptions(int id) {

		int option;

		do {
			option = Integer.parseInt(InputUserData.checkUserInput("option"));

			switch (option)
			{
			case 0:
				SearchesUi.showSearchesUi();
				break;
			case 1: 
				//Not implemented yet
			case 2:

				DeleteBookMenu.showDeleteBookMenu(id);



			}

		} while (option != 0 && option != 1 && option != 2);
		
	}//showBookDetailsOptions()
}//class BookDetailsMenu