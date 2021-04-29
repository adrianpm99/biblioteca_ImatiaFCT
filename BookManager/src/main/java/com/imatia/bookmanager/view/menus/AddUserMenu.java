package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.UserController;
import com.imatia.bookmanager.model.entities.User;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.StartMenuUI;
/*
 * class to show the add user menu options
 */
public class AddUserMenu {
	
	public static void showAddUserMenu() {
		
		UserController uc = new UserController();
		
		String name;
		String surName;
		
		do {
			System.out.print("Nombre: ");
			name = InputUserData.checkUserInput("name","Maximo 50 caracteres.");
			if(name.equals("")) System.out.println("El nombre es obligatorio. Pruebe de nuevo.");
		} while (name.equals(""));

		do {
			System.out.print("Apellidos: ");
			surName = InputUserData.checkUserInput("surname","Maximo 50 caracteres.");
			if(surName.equals("")) System.out.println("El apellido es obligatorio. Pruebe de nuevo.");
		} while (surName.equals(""));
		
		User user = new User(name, surName);
		
		uc.addUser(user);
		//show the start menu
		StartMenuUI.showStartMenuUi();
	}//showAddUserMenu

}
