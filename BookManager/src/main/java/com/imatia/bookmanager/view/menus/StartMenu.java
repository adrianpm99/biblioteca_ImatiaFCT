package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.BookController;
import com.imatia.bookmanager.model.entities.Book;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.results.BookDetails;
import com.imatia.bookmanager.view.ui.AddBookUi;
import com.imatia.bookmanager.view.ui.LendingsUi;
import com.imatia.bookmanager.view.ui.SearchesUi;
import com.imatia.bookmanager.view.ui.UserManagementUi;

public class StartMenu {

	public static void showStartMenuOption() {
		String option;
		String bookId;

		do {
			option = InputUserData.checkUserInput("option", "Opcion no valida. Pruebe de nuevo (entero positivo)");
		} while (option.equals("") && !option.equals("0") && !option.equals("1") && !option.equals("2")
				&& !option.equals("3") && !option.equals("4") && !option.equals("5") && !option.equals("6"));

		switch (Integer.parseInt(option)) {

		case 0:
			System.out.println("\nFinalizando la ejecución del programa");
			System.exit(0);
		case 1:
			SearchesUi.showSearchesUi();
			break;
		case 2:
			LendingsUi.showLendingsUi();
			break;
		case 3:
			AddBookUi.showAddBookUi();
			break;
		case 4:
			UserManagementUi.showUserManagementUi();
			break;
		case 5:
			do {
				System.out.print("Introduzca el id del libro: ");
				bookId = InputUserData.checkUserInput("id",
						"Valor de Id incorrecto. Pruebe de nuevo (entero positivo).");
			} while (bookId.equals(""));

			Book book = new BookController().getBookById(Integer.parseInt(bookId));
			BookDetails.showBookDetails(book);
			break;
		case 6:
			//Not implemented yet
			break;
		}

	}

}
