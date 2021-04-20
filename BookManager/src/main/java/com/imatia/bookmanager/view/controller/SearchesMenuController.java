package com.imatia.bookmanager.view.controller;

import com.imatia.bookmanager.controller.BookController;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.menus.ResultsByMethodMenu;
import com.imatia.bookmanager.view.menus.StartMenu;
import com.imatia.bookmanager.view.results.BookRenderers;

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
				BookRenderers.renderAuthorListBooks(bc.getBooksByAuthor(filter));
				ResultsByMethodMenu.showResultsView("AUTOR");
				
				
				break;
			case 2:
				System.out.print("Introduzca el titulo: ");
				filter = InputUserData.checkUserInput("title");
				BookRenderers.renderTitleListBooks(bc.getBookByTitle(filter));
				ResultsByMethodMenu.showResultsView("TITULO");
				break;
			case 3:
				System.out.print("Introduzca el ISBN: ");
				filter = InputUserData.checkUserInput("ISBN");
				BookRenderers.renderISBNListBooks(bc.getBookByIsbn(filter));
				ResultsByMethodMenu.showResultsView("ISBN");
				break;
			}
		} while (option != 0 && option != 1 && option != 2 && option != 3);
	}

}
