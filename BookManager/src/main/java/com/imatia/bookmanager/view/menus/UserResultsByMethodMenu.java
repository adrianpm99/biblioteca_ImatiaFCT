package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.UserController;
import com.imatia.bookmanager.model.entities.User;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.results.UserDetails;
import com.imatia.bookmanager.view.ui.SearchUserUi;
/*
 * this is the menu options for the user search results by method
 */
public class UserResultsByMethodMenu {
	/**
	 * method to show the menu options for the user search results by method
	 */
	public static void showUserResultsByMethodMenuOptions() {

		String userId;
		String option;
		do {
			option = InputUserData.checkUserInput("option", "Opcion no valida. Pruebe de nuevo (entero positivo)");
			if(!option.equals("") && !option.equals("0") && !option.equals("1")) {
				System.out.println("Opcion no valida. Pruebe de nuevo (entero positivo)");
			}
		} while (!option.equals("0") && !option.equals("1"));

		switch (Integer.parseInt(option)) {
		case 0:
			SearchUserUi.showSearchUserUi();
			break;
		case 1:
			do {
				System.out.print("Introduzca el id del usuario: ");
				userId = InputUserData.checkUserInput("id",
						"Valor de Id incorrecto. Pruebe de nuevo (entero positivo).");
			} while (userId.equals(""));

			User user = new UserController().getUserById(Integer.parseInt(userId));
			UserDetails.showUserDetails(user);
			break;
		}//showUserResultsByMethodMenuOptions
	}

}
