package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.SearchesUi;



public class BookDetailsMenu
{

	public static void showBookDetailsOptions() {

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
				//Not implemented yet

			}

		} while (option != 0 && option != 1 && option != 2);
		
	}//showBookDetailsOptions()
}//class BookDetailsMenu