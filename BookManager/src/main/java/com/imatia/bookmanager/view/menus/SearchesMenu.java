package com.imatia.bookmanager.view.menus;

import java.util.ArrayList;
import java.util.List;

import com.imatia.bookmanager.controller.BookController;
import com.imatia.bookmanager.model.entities.Book;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.results.BookRenderers;
import com.imatia.bookmanager.view.ui.ResultsByMethodUi;
import com.imatia.bookmanager.view.ui.SearchesUi;
import com.imatia.bookmanager.view.ui.StartMenuUI;

/*
 * this is the search book menu options
 */
public class SearchesMenu {

	public static void showSearchesMenuOptions() {

		BookController bc = new BookController();
		String filter;
		String option;
		List<Book> bookList = new ArrayList<>();
		do {
			option = InputUserData.checkUserInput("option", "Opcion no valida. Pruebe de nuevo (entero positivo)");
			if (!option.equals("") && !option.equals("0") && !option.equals("1") && !option.equals("2")
					&& !option.equals("3")) {
				System.out.println("Opcion no valida. Pruebe de nuevo (entero positivo)");
			}
		} while (!option.equals("0") && !option.equals("1") && !option.equals("2") && !option.equals("3"));

		switch (Integer.parseInt(option)) {

		case 0:
			StartMenuUI.showStartMenuUi();
			break;
		case 1:
			do {
				System.out.print("Introduzca el autor: ");
				filter = InputUserData.checkUserInput("author", "Maximo 50 caracteres.");
			} while (filter.equals(""));
			//get the books by filter
			bookList = bc.getBooksByAuthor(filter);
			//if there are no results
			if (bookList.isEmpty()) {
				System.out.println("No se ha econtrando ningun libro del autor facilitado");
				//back to the searches UI
				SearchesUi.showSearchesUi();
			} else {
				//show the resultsUI by method
				ResultsByMethodUi.showResultsUi("AUTOR");
				//render the books
				BookRenderers.renderAuthorListBooks(bookList);
				//show results by method
				ResultsByMethodMenu.showResultsByMethodMenuOptions();
			}
			break;
		case 2:
			do {
				System.out.print("Introduzca el titulo: ");
				filter = InputUserData.checkUserInput("title", "Máximo 50 carácteres");
			} while (filter.equals(""));
			bookList = bc.getBookByTitle(filter);
			if (bookList.isEmpty()) {
				System.out.println("No se ha encontrado ningún libro con el titulo facilitado");
				SearchesUi.showSearchesUi();
			} else {
				ResultsByMethodUi.showResultsUi("TITULO");
				BookRenderers.renderTitleListBooks(bc.getBookByTitle(filter));
				ResultsByMethodMenu.showResultsByMethodMenuOptions();
			}
			break;
		case 3:
			do {
				System.out.print("Introduzca el ISBN: ");
				filter = InputUserData.checkUserInput("ISBN", "Debe introducir 13 enteros positivos");
			} while (filter.equals(""));
			bookList = bc.getBookByIsbn(filter);
			if (bookList.isEmpty()) {
				System.out.println("No se ha econtrado ningún libro con el ISBN facilitado");
				SearchesUi.showSearchesUi();
			} else {
				ResultsByMethodUi.showResultsUi("ISBN");
				BookRenderers.renderISBNListBooks(bc.getBookByIsbn(filter));
				ResultsByMethodMenu.showResultsByMethodMenuOptions();
			}
			break;
		}

	}//show searchesMenuOptions

}
