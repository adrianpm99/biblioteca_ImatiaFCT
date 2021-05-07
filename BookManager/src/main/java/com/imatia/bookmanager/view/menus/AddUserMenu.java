package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.UserController;
import com.imatia.bookmanager.model.entities.User;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.StartMenuUI;

/**
 * Class to show the add user menu options
 * 
 * @author Grupo2FCTImatia
 */

public class AddUserMenu {

	public static void showAddUserMenu() {

		UserController uc = new UserController();

		String name;
		String surName;

		do {

			// Ask for the name
			System.out.print("Nombre: ");
			name = InputUserData.checkUserInput("name", "Maximo 50 caracteres.");

			// Checks the name is not empty
			if (name.equals(""))
				System.out.println("El nombre es obligatorio. Pruebe de nuevo.");

		} while (name.equals(""));

		do {

			// Ask for the surname
			System.out.print("Apellidos: ");
			surName = InputUserData.checkUserInput("surname", "Maximo 50 caracteres.");

			// Checks the surname is not empty
			if (surName.equals(""))
				System.out.println("El apellido es obligatorio. Pruebe de nuevo.");

		} while (surName.equals(""));

		// Insert the name and surname into the user
		User user = new User(name, surName);

		// Add a new user into database
		uc.addUser(user);

		// Show the start menu
		StartMenuUI.showStartMenuUi();

	}// showAddUserMenu

}// class AddUserMenu
