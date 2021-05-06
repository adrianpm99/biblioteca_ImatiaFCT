package com.imatia.bookmanager.view.ui;

import com.imatia.bookmanager.view.menus.DeleteCopyMenu;

/**
 * This is the ui to show when the user selects to delete a copy
 */

public class DeleteCopyUi {
	public static void showDeleteCopyUi()
	{
		System.out.println(
				"***********************\r\n" + 
				"** ELIMINAR EJEMPLAR **\r\n" + 
				"***********************\r\n" + 
				"------------------------------------------------------\r\n" + 
				"|| Introduzca el id del ejemplar que desea eliminar ||\r\n" + 
				"------------------------------------------------------");
		DeleteCopyMenu.showDeleteCopyMenu();
	}//showDeleteCopyUi()
}//class DeleteCopyUi
