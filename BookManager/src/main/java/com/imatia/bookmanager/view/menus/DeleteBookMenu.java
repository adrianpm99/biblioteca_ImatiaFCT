package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.BookController;
import com.imatia.bookmanager.view.inputs.UtilityInputs;
import com.imatia.bookmanager.view.ui.SearchesUi;
import com.imatia.bookmanager.view.ui.StartMenuUI;

/*
 * class to show a delete book menu
 */
public class DeleteBookMenu {
	
	public static void showDeleteBookMenu(int id) {
		
		BookController bc = new BookController();
		boolean confirmationDelete= UtilityInputs.getConfirmation("borrar","libro");
		// get the confirmation of the delete
		if (confirmationDelete == true) {
			bc.deleteBook(id);
			StartMenuUI.showStartMenuUi();

		}else {
			SearchesUi.showSearchesUi();
		}
		
		
	}//showDeleteBookMenu

}
