package com.imatia.bookmanager.view.ui;

import com.imatia.bookmanager.view.menus.AddCopyMenu;

/**
 * This is the UI for the Add Copy menu.
 */

public class AddCopyUi {
	public static void showAddCopyUi()	{
			System.out.println(
					"\n******************\r\n" + 
					"** AÑADIR EJEMPLAR **\r\n" + 
					"******************\r\n" + 
					"---------------------------------------------------\r\n" + 
					"|| Introduzca los datos de los nuevos ejemplares ||\r\n" + 
					"---------------------------------------------------");
			
			AddCopyMenu.showAddCopyMenu();
	}//showAddCopyMenu()
}//class AddCopyMenu