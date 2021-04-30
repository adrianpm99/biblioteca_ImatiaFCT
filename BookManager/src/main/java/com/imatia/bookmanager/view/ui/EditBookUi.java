package com.imatia.bookmanager.view.ui;

import com.imatia.bookmanager.view.menus.EditBookMenu;

/**
 * This is the UI for the Edit Book menu.
 */
public class EditBookUi
{
	public static void showEditBookUi(int id)
	{
		System.out.println(
				"\n******************\r\n" + 
				"** EDITAR LIBRO **\r\n" + 
				"******************\r\n" + 
				"-------------------------------------------\r\n" + 
				"|| Introduzca los nuevos datos del libro ||\r\n" + 
				"-------------------------------------------");
		
		EditBookMenu.showEditBookMenu(id);
	}//showAddBookMenu()
}//class EditBookUi