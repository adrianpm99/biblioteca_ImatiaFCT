package com.imatia.bookmanager.view.menus;


import com.imatia.bookmanager.controller.BookController;
import com.imatia.bookmanager.controller.CopyController;

import com.imatia.bookmanager.model.entities.Copy;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.CopyUi;

public class AddCopyMenu {
	
	public static void showAddCopyMenu() {

		CopyController cc = new CopyController();
		BookController bc = new BookController();
		
		String bookId = null; 
	
		String copyNumber;
	
		do
		{
			System.out.print("Introduzca el id del libro: ");
			bookId = InputUserData.checkUserInput("id", "Valor de Id incorrecto. Pruebe de nuevo (entero positivo).");
		}while(bookId.equals("") || (bc.getBookById(Integer.parseInt(bookId))== null));
		
		
		
		
		do {
			System.out.print("Introduzca el numero de ejemplares del libro: (numero entero positivo)");
			 copyNumber = InputUserData.checkUserInput("copyNumber", "Valor incorrecto. Pruebe de nuevo (entero positivo).");
		} while (copyNumber.equals(""));
			

		// add the copys of book to the database
		for (int i = 0; i < Integer.parseInt(copyNumber); i++) {

			Copy copy = new Copy();
			copy.setBookId(Integer.parseInt(bookId));
			copy.setcopyNotes("Nuevo");

			cc.addCopy(copy);
		}
		
		System.out.print( copyNumber +" ejemplares del libro " + bookId + " creados con el estado 'Nuevo'");
		CopyUi.showCopyUi();
		
	}
}
