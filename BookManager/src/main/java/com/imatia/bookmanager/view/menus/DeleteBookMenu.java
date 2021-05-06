package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.BookController;
import com.imatia.bookmanager.view.inputs.UtilityInputs;
import com.imatia.bookmanager.view.ui.SearchesUi;
import com.imatia.bookmanager.view.ui.StartMenuUI;

/**
 * Class to show a delete book menu
 * 
 * @author Grupo2FCTImatia
 */

public class DeleteBookMenu {

	public static void showDeleteBookMenu(int id) {

		BookController bc = new BookController();

		boolean confirmationDelete;

		// Calls confirmation to delete a book
		confirmationDelete = UtilityInputs.getConfirmation("borrar", "libro");

		// get the confirmation of the delete
		if (confirmationDelete == true) {

			// Delete book from database
			bc.deleteBook(id);

			// Go to StartMenuUi
			StartMenuUI.showStartMenuUi();

		} else {

			// Go to SearchesUi
			SearchesUi.showSearchesUi();
		}

	}// showDeleteBookMenu

}// class DeleteBookMenu
