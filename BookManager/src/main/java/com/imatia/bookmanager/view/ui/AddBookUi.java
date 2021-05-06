package com.imatia.bookmanager.view.ui;

import com.imatia.bookmanager.view.menus.AddBookMenu;

/**
 * This is the UI for the Add Book menu.
 */

public class AddBookUi	{
	public static void showAddBookUi()	{
		System.out.println(
				"\n******************\r\n" + 
				"** AÑADIR LIBRO **\r\n" + 
				"******************\r\n" + 
				"------------------------------------------\r\n" + 
				"|| Introduzca los datos del nuevo libro ||\r\n" + 
				"------------------------------------------");
		
		AddBookMenu.showAddBookMenu();
	}//showAddBookMenu()
}//class AddBookMenu