package com.imatia.bookmanager.view.controller;

import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.menus.SearchesMenu;


public class ResultsByMethodMenuController {
	
	public static void showResultsByMethodMenuOptions() {
		
		int option;
		do {
			option = Integer.parseInt(InputUserData.checkUserInput("option"));

			switch (option) {

			case 0:
				SearchesMenu.showSearchesMenu();
				break;
			case 1:
				SearchesMenu.showSearchesMenu();
				break;
			}
			
		}while (option != 0 && option != 1);
	}
	
	
}
