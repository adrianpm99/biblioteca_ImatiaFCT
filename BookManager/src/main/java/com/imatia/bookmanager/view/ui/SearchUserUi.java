package com.imatia.bookmanager.view.ui;

import com.imatia.bookmanager.view.menus.SearchUserMenu;

public class SearchUserUi {
	
	public static void showSearchUserUi() {
		
		System.out.println(
				
				"\n*********************\r\n" + 
				"** BUSCAR USUARIOS **\r\n" + 
				"*********************\r\n" + 
				"-----------------------------------------------------------------------------------------\r\n" + 
				"|| 1- Buscar por ID || 2- Buscar por nombre y apellidos || 0- Volver al menu principal ||\r\n" + 
				"-----------------------------------------------------------------------------------------");
		
		SearchUserMenu.showSearchUserMenuOptions();
	}

}
