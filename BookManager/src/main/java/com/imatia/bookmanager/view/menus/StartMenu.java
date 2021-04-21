package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.view.controller.StartMenuController;

/**
 * Start menu with tha main functions: 
 * (searches, loans, add books and exit).
 */
public class StartMenu
{
	public static void showStartMenu()
	{
		System.out.println(
				"==Seleccione una opcion==\r\n" + 
				"\r\n" + 
				"	1 - BUSQUEDAS\r\n" + 
				"	\r\n" + 
				"	2 - PRESTAMOS\r\n" + 
				"\r\n" + 
				"	3 - AÑADIR LIBRO\r\n" + 
				"\r\n" + 
				"	0 - SALIR\r\n");
		
		
		StartMenuController.showStartMenuOption();
	}//showStartMenu()
}//class StartMenu