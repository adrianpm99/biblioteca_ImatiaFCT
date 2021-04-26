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
		String option;
		do {
			option = InputUserData.checkUserInput("option", "Opcion no valida. Pruebe de nuevo (entero positivo)");
		} while (option.equals("") && !option.equals("0") && !option.equals("1") && !option.equals("2")
				&& !option.equals("3"));

		switch (Integer.parseInt(option)) {

		case 0:
			StartMenuUI.showStartMenuUi();
			break;
		case 1:
			do {
				System.out.print("Introduzca el autor: ");
				filter = InputUserData.checkUserInput("author", "Maximo 50 caracteres.");
			} while (filter.equals(""));
			ResultsByMethodUi.showResultsUi("AUTOR");
			BookRenderers.renderAuthorListBooks(bc.getBooksByAuthor(filter));

			ResultsByMethodMenu.showResultsByMethodMenuOptions();
			break;
		case 2:
			do {
				System.out.print("Introduzca el titulo: ");
				filter = InputUserData.checkUserInput("title", "Máximo 50 carácteres");
			} while (filter.equals(""));
			ResultsByMethodUi.showResultsUi("TITULO");
			BookRenderers.renderTitleListBooks(bc.getBookByTitle(filter));
			ResultsByMethodMenu.showResultsByMethodMenuOptions();

			break;
		case 3:
			do {
				System.out.print("Introduzca el ISBN: ");
				filter = InputUserData.checkUserInput("ISBN", "Debe introducir 13 enteros positivos");
			} while (filter.equals(""));
			ResultsByMethodUi.showResultsUi("ISBN");
			BookRenderers.renderISBNListBooks(bc.getBookByIsbn(filter));
			ResultsByMethodMenu.showResultsByMethodMenuOptions();
			break;
		}

	}

}
