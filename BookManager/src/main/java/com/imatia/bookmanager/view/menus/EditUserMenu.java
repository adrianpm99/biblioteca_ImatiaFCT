package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.UserController;
import com.imatia.bookmanager.model.entities.User;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.StartMenuUI;

/**
 * class for editing the data of a exiting user
 * @author Grupo2FCTImatia
 *
 */
public class EditUserMenu {

	/**
	 * method to show the edition menu of user
	 * @param id
	 */
	public static void showEditUserMenu(int id) {
		
		String name;
		String surname;

		User u = null;

		// get the user by Id
		UserController uc = new UserController();
		u = uc.getUserById(id);

		// ask-verify-change data
		System.out.print("Introduzca nuevo nombre (enter para mantener el existente): ");
		name = InputUserData.checkUserInput("name", "Maximo 50 caracteres.");
		if (!name.equals(""))
			u.setUserName(name);

		System.out.print("Introduzca nuevo apellido (enter para mantener el existente): ");
		surname = InputUserData.checkUserInput("surname", "Maximo 50 caracteres");
		if (!surname.equals(""))
			u.setUserSurname(surname);

		// call the method which update the data of the user
		uc.modifyUser(u);

		// finally, go to the start menu
		StartMenuUI.showStartMenuUi();
		
	}//endshowEditUserMenu

}//end EditUserMenu
