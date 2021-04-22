package com.imatia.bookmanager.view.ui;

import com.imatia.bookmanager.view.menus.LendingsMenu;

/**
 * Lendings UI
 */
public class LendingsUi
{
	public static void showLendingsUi()
	{
		System.out.println(
				"***************\r\n" + 
				"** PRESTAMOS **\r\n" + 
				"***************\r\n" + 
				"------------------------------------------------------------------------------------------------------\r\n" + 
				"|| 1- Añadir prestamo || 2- Modificar prestamo || 3- Borrar prestamo || 0- Volver al menu principal ||\r\n" + 
				"------------------------------------------------------------------------------------------------------");
		

		 LendingsMenu.showLendingsOptions();
		 
	}//showLendingsUi()
}//class LendingsUi