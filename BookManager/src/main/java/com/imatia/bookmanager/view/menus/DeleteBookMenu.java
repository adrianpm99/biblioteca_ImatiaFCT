package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.BookController;
import com.imatia.bookmanager.view.inputs.UtilityInputs;

public class DeleteBookMenu {
	
	public static void showDeleteBookMenu(int id) {
		
		BookController bc = new BookController();
		boolean confirmationDelete= UtilityInputs.getConfirmation("borrar");
		// get the confirmation of the delete
		if (confirmationDelete == true) {
			//bc.deleteBook(id);

		}else {
			//Not implemented yet
		}
		
		
	}

}
