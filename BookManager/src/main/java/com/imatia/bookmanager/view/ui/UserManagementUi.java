package com.imatia.bookmanager.view.ui;

import com.imatia.bookmanager.view.menus.UserManagementMenu;

/**
 * this is the UI to show the user manage options
 *
 */
public class UserManagementUi {
	
	public static void showUserManagementUi() {
		
		System.out.println(
				"***************\r\n" + 
				"** USUARIOS **\r\n" + 
				"***************\r\n" + 
				"----------------------------------------------------------------------------\r\n" + 
				"|| 1- Alta de usuario || 2- Buscar usuario || 0- Volver al menu principal ||\r\n" + 
				"----------------------------------------------------------------------------");
		//show the management menu options
		UserManagementMenu.showUserManagementMenuOptions();
	}//showUserManagementUi
	

}
