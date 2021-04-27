package com.imatia.bookmanager.view.ui;

import com.imatia.bookmanager.view.menus.EditUserMenu;

public class EditUserUi {
	
	public static void showEditUserUi(int id)
	{
		
		System.out.println(
				"\n********************\r\n" + 
				"** EDITAR USUARIO **\r\n" + 
				"********************\r\n" + 
				"---------------------------------------------\r\n" + 
				"|| Introduzca los nuevos datos del usuario ||\r\n" + 
				"---------------------------------------------");
		
		EditUserMenu.showEditUserMenu(id);
	
	}

}
