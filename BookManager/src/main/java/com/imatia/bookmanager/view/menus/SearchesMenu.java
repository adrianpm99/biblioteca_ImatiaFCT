package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.BookController;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.results.BookRenderers;
import com.imatia.bookmanager.view.ui.ResultsByMethodUi;
import com.imatia.bookmanager.view.ui.StartMenuUI;

public class SearchesMenu {

	public static void showSearchesMenuOptions() {
		
		BookController bc = new BookController();
		String filter;
		int option;
		do {
			option = Integer.parseInt(InputUserData.checkUserInput("option"));

			switch (option) {

			case 0:
				StartMenuUI.showStartMenuUi();
				break;
			case 1:
				System.out.print("Introduzca el autor: ");
				filter = InputUserData.checkUserInput("author");
				
				ResultsByMethodUi.showResultsUi("AUTOR");
				BookRenderers.renderAuthorListBooks(bc.getBooksByAuthor(filter));
				
				ResultsByMethodMenu.showResultsByMethodMenuOptions();	
				break;
			case 2:
				System.out.print("Introduzca el titulo: ");
				filter = InputUserData.checkUserInput("title");
				ResultsByMethodUi.showResultsUi("TITULO");
				BookRenderers.renderTitleListBooks(bc.getBookByTitle(filter));
				ResultsByMethodMenu.showResultsByMethodMenuOptions();	
				
				break;
			case 3:
				System.out.print("Introduzca el ISBN: ");
				filter = InputUserData.checkUserInput("ISBN");
				ResultsByMethodUi.showResultsUi("ISBN");
				BookRenderers.renderISBNListBooks(bc.getBookByIsbn(filter));
				ResultsByMethodMenu.showResultsByMethodMenuOptions();	
				break;
			}
		} while (option != 0 && option != 1 && option != 2 && option != 3);
	}

}
