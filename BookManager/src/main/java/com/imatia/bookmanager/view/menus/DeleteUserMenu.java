package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.UserController;
import com.imatia.bookmanager.view.inputs.UtilityInputs;

/*
 * class for show a deleter user menu
 */
public class DeleteUserMenu {
	public static void showDeleteUserMenu(int id) {
		
		UserController uc = new UserController();
		//Confirm the delete action
		if(UtilityInputs.getConfirmation("borrar", "el usuario "+id)){
			uc.deleteUser(id);
			System.out.println("Se ha eliminado el usuario "+id+" correctamente.");
		}else{
			System.out.println("No se ha eliminado el usuario "+id+".");
		}
	}// showDeleteUserMenu()
}// class DeleteUserMenu