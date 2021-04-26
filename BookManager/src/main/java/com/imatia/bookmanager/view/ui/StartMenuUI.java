package com.imatia.bookmanager.view.ui;

import com.imatia.bookmanager.view.menus.StartMenu;

/**
 * Start menu with the main functions: 
 * (searches, loans, add books and exit).
 */
public class StartMenuUI
{
	public static void showStartMenuUi()
	{
		System.out.println(

				"\n==Seleccione una opcion==\r\n" + 
				"\r\n" + 
				"	1 - BUSQUEDAS\r\n" + 
				"	\r\n" + 
				"	2 - PRESTAMOS\r\n" + 
				"\r\n" + 
				"	3 - AÑADIR LIBRO\r\n" + 
				"\r\n" + 
				"	4 - GESTION DE USUARIOS\r\n" + 
				"\r\n" + 
				"	0 - SALIR\r\n");
		
		
		StartMenu.showStartMenuOption();
	}//showStartMenu()
}//class StartMenu