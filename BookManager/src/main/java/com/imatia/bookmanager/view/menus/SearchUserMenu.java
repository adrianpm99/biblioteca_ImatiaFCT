package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.UserController;
import com.imatia.bookmanager.model.entities.User;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.results.UserDetails;
import com.imatia.bookmanager.view.ui.UserManagementUi;

public class SearchUserMenu {
	
	public static void showSearchUserMenuOptions() {
		UserController uc = new UserController();
		int option;
		String filter;
		String filter2;
		User user = new User();

		do {
			option = Integer.parseInt(InputUserData.checkUserInput("option"));

			switch (option) {

			case 0:
				UserManagementUi.showUserManagementUi();;
				break;
			case 1:
				System.out.print("Introduzca el id del usuario: ");
				filter = InputUserData.checkUserInput("id");
				user =uc.getUserById(Integer.valueOf(filter));
				UserDetails.showUserDetails(user);
				
				break;
			case 2:
				System.out.print("Introduzca el nombre: ");
				filter= InputUserData.checkUserInput("name");
				System.out.print("Introduzca el apellido: ");
				filter2 = InputUserData.checkUserInput("surname");
				user = uc.getUserByNameAndSurname(filter, filter2);
				UserDetails.showUserDetails(user);
						
				break;
			
			}
		} while (option != 0 && option != 1 && option != 2);
		
	}

}
