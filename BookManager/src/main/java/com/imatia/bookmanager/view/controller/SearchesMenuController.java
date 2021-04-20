package com.imatia.bookmanager.view.controller;

import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.menus.ResultsByMethodMenu;
import com.imatia.bookmanager.view.menus.StartMenu;

public class SearchesMenuController {

	public static void showSearchesMenuOptions() {
		int option;
		do {
			option = Integer.parseInt(InputUserData.checkUserInput("option"));

			switch (option) {

			case 0:
				StartMenu.showStartMenu();
				break;
			case 1:
				ResultsByMethodMenu.showResultsByMehod("AUTOR");
				break;
			case 2:
				ResultsByMethodMenu.showResultsByMehod("TITULO");
				break;
			case 3:
				ResultsByMethodMenu.showResultsByMehod("ISBN");
				break;
			}
		} while (option != 0 && option != 1 && option != 2 && option != 3);
	}

}
