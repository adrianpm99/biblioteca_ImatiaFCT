package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.UserController;
import com.imatia.bookmanager.model.entities.User;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.results.UserDetails;
import com.imatia.bookmanager.view.ui.UserManagementUi;

public class SearchUserMenu {

	public static void showSearchUserMenuOptions() {
		UserController uc = new UserController();
		String option;
		String filter;
		String filter2;
		User user = new User();

		do {
			option = InputUserData.checkUserInput("option", "Opcion no válida. Pruebe de nuevo(entero positivo)");
		} while (option.equals("") && !option.equals("0") && !option.equals("1") && !option.equals("2"));

		switch (Integer.parseInt(option)) {

		case 0:
			UserManagementUi.showUserManagementUi();
			;
			break;
		case 1:
			do {
				System.out.print("Introduzca el id del usuario: ");
				filter = InputUserData.checkUserInput("id", "Pruebe de nuevo(entero positivo)");
			} while (filter.equals(""));
			user = uc.getUserById(Integer.valueOf(filter));
			UserDetails.showUserDetails(user);

			break;
		case 2:
			do {
				System.out.print("Introduzca el nombre: ");
				filter = InputUserData.checkUserInput("name","Maximo 50 carácteres");
			} while (filter.equals(""));
			do {

				System.out.print("Introduzca el apellido: ");
				filter2 = InputUserData.checkUserInput("surname", "Máximo 50 carácteres");
			} while (filter2.equals(""));
			user = uc.getUserByNameAndSurname(filter, filter2);
			UserDetails.showUserDetails(user);

			break;

		}

	}

}
