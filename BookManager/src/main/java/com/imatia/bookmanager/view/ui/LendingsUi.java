package com.imatia.bookmanager.view.ui;

import com.imatia.bookmanager.view.menus.LendingsMenu;

/**
 * This is the UI for the Lendings
 */

public class LendingsUi
{
	public static void showLendingsUi()
	{
		System.out.println(
				"\n***************\r\n" + 
				"** PRESTAMOS **\r\n" + 
				"***************\r\n" + 
				"---------------------------------------------------------------------------------------------------\r\n" + 
				"|| 1- Añadir prestamo || 2- Buscar prestamo || 3- Cerrar prestamo || 0- Volver al menu principal ||\r\n" + 
				"---------------------------------------------------------------------------------------------------");
		

		 LendingsMenu.showLendingsOptions();
		 
	}//showLendingsUi()
}//class LendingsUi