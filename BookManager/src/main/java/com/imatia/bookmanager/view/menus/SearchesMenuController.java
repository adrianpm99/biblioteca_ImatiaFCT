package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.BookController;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.results.BookRenderers;
import com.imatia.bookmanager.view.ui.ResultsByMethodMenu;
import com.imatia.bookmanager.view.ui.StartMenu;

public class SearchesMenuController {

	public static void showSearchesMenuOptions() {
		
		BookController bc = new BookController();
		String filter;
		int option;
		do {
			option = Integer.parseInt(InputUserData.checkUserInput("option"));

			switch (option) {

			case 0:
				StartMenu.showStartMenu();
				break;
			case 1:
				System.out.print("Introduzca el autor: ");
				filter = InputUserData.checkUserInput("author");
				
				ResultsByMethodMenu.showResultsView("AUTOR");
				BookRenderers.renderAuthorListBooks(bc.getBooksByAuthor(filter));
				
				ResultsByMethodMenuController.showResultsByMethodMenuOptions();	
				break;
			case 2:
				System.out.print("Introduzca el titulo: ");
				filter = InputUserData.checkUserInput("title");
				ResultsByMethodMenu.showResultsView("TITULO");
				BookRenderers.renderTitleListBooks(bc.getBookByTitle(filter));
				ResultsByMethodMenuController.showResultsByMethodMenuOptions();	
				
				break;
			case 3:
				System.out.print("Introduzca el ISBN: ");
				filter = InputUserData.checkUserInput("ISBN");
				ResultsByMethodMenu.showResultsView("ISBN");
				BookRenderers.renderISBNListBooks(bc.getBookByIsbn(filter));
				ResultsByMethodMenuController.showResultsByMethodMenuOptions();	
				break;
			}
		} while (option != 0 && option != 1 && option != 2 && option != 3);
	}

}
