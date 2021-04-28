package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.EditBookUi;
import com.imatia.bookmanager.view.ui.SearchesUi;




public class BookDetailsMenu
{
	public static void showBookDetailsOptions(int id) {

		String option;

		do
		{
			option = InputUserData.checkUserInput("option", "Opcion no valida. Pruebe de nuevo (entero positivo)");
			if(!option.equals("") && !option.equals("0") && !option.equals("1") && !option.equals("2")) {
				System.out.println("Opcion no valida. Pruebe de nuevo (entero positivo)");
			}
		} while (!option.equals("0") && !option.equals("1") && !option.equals("2"));
		
		switch (Integer.parseInt(option))
		{
		case 0:
			SearchesUi.showSearchesUi();
			break;
		case 1: 
			EditBookUi.showEditBookUi(id);
			break;
		case 2:
			DeleteBookMenu.showDeleteBookMenu(id);
			break;
		}
	}//showBookDetailsOptions()
}//class BookDetailsMenu