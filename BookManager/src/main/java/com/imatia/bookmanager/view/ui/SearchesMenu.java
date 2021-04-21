package com.imatia.bookmanager.view.ui;

import com.imatia.bookmanager.view.menus.SearchesMenuController;

/**
 * Searches Menu, to search by author, title or ISBN
 */
public class SearchesMenu
{
	public static void showSearchesMenu()
	{
		System.out.println(
				"***************\r\n" + 
				"** BUSQUEDAS **\r\n" + 
				"***************\r\n" + 
				"------------------------------------------------------------------------------------------------------\r\n" + 
				"|| 1- Buscar por autor || 2- Buscar por titulo || 3- Buscar por ISBN || 0- Volver al menu principal ||\r\n" + 
				"------------------------------------------------------------------------------------------------------");
		
		SearchesMenuController.showSearchesMenuOptions();
	}//showSearchesMenu()
}//class SearchesMenu