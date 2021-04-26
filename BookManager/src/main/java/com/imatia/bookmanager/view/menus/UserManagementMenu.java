package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.AddUserUi;
import com.imatia.bookmanager.view.ui.StartMenuUI;

public class UserManagementMenu {
	
	public static void showUserManagementMenuOptions() {
		
		int option;

		do {
			option = Integer.parseInt(InputUserData.checkUserInput("option"));

			switch (option) {

			case 0:
				StartMenuUI.showStartMenuUi();
				break;
			case 1:
				AddUserUi.showAddUserUi();
				break;
			case 2:
				//
				break;
		
			}

		} while (option != 0 && option != 1 && option != 2 );

	
	}

}
