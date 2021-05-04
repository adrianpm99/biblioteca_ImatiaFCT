package com.imatia.bookmanager.view.ui;

import com.imatia.bookmanager.view.menus.EditCopyMenu;

/*
 * this is the class to show the edit copy ui
 */
public class EditCopyUi {
	
	
	public static void showEditCopyUi(int id)
	{
		
		System.out.println(
				"\n*******************\r\n" + 
				"** EDITAR ESTADO **\r\n" + 
				"*******************\r\n");
			
		//show the edit copy menu
		EditCopyMenu.showEditCopyMenu(id);
	
	}//showEditUserUi

}
