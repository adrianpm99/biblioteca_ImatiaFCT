package com.imatia.bookmanager.view.ui;

import com.imatia.bookmanager.view.menus.CopyMenu;

public class CopyUi {
	public static void showCopyUi()
	{
		System.out.println(
				"\n***************\r\n" + 
				"** EJEMPLARES **\r\n" + 
				"***************\r\n" + 
				"--------------------------------------------------------------------------------------------------------------------------------\r\n" + 
				"|| 1- Añadir ejemplar || 2- Buscar por Id de libro || 3- Editar estado || 4- Eliminar Ejemplar || 0- Volver al menu principal ||\r\n" + 
				"--------------------------------------------------------------------------------------------------------------------------------");

		 CopyMenu.showCopyOptions();
		 
	}//showCopyUi()
}//class CopyUi
