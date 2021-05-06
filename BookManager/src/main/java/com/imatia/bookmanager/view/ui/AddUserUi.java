package com.imatia.bookmanager.view.ui;

import com.imatia.bookmanager.view.menus.AddUserMenu;

/**
 * this is the UI to show the add user view
 */

public class AddUserUi {
	
	public static void showAddUserUi() {
		
		System.out.println(
				"\n********************\r\n" + 
				"** AÑADIR USUARIO **\r\n" + 
				"********************\r\n" + 
				"--------------------------------------------\r\n" + 
				"|| Introduzca los datos del nuevo usuario ||\r\n" + 
				"--------------------------------------------");
		//show the add user menu
		AddUserMenu.showAddUserMenu();
	}//showAddUserUi

}//AddUserUi
