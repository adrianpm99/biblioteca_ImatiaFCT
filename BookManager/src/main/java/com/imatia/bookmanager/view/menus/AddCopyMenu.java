package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.BookController;
import com.imatia.bookmanager.controller.CopyController;
import com.imatia.bookmanager.controller.ShelvingController;
import com.imatia.bookmanager.model.entities.Copy;
import com.imatia.bookmanager.model.entities.Shelving;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.CopyUi;

/**
 * Class implements the add copy menu
 * 
 * @author Grupo2FCTImatia
 */

public class AddCopyMenu {

	public static void showAddCopyMenu() {

		CopyController cc = new CopyController();
		BookController bc = new BookController();
		ShelvingController sc = new ShelvingController();
		
		String bookId = null;
		String shelvingId;
		String copyNumber;

		do {

			// Ask for bookId
			System.out.print("Introduzca el id del libro: ");
			bookId = InputUserData.checkUserInput("id", "Valor de Id incorrecto. Pruebe de nuevo (entero positivo).");

			if (bc.getBookById(Integer.parseInt(bookId)) == null) {
				System.out.print("Este libro no existe\r ");
				bookId = "";
			}

		} while (bookId.equals(""));

		do {

			// Ask for the number or copies
			System.out.print("Introduzca el numero de ejemplares del libro: (numero entero positivo)");
			copyNumber = InputUserData.checkUserInput("copyNumber",
					"Valor incorrecto. Pruebe de nuevo (entero positivo).");

		} while (copyNumber.equals(""));

		for (int i = 0; i < Integer.parseInt(copyNumber); i++) {

			Shelving shelving = null;
			Copy copy = new Copy();

			// Set the BookId of the copy
			copy.setBookId(Integer.parseInt(bookId));

			// Set the copyNotes of the copy
			copy.setcopyNotes("Buen estado");

			// Add the copy into database
			cc.addCopy(copy);

			do {

				// add the shelving where copy is located
				System.out.print("Introduzca la estantería para el ejemplar " + copy.getCopyId()
						+ " (numero entero positivo): ");
				shelvingId = InputUserData.checkUserInput("pageNumber",
						"Valor incorrecto. Pruebe de nuevo (entero positivo).");

				// check if the shelving exists
				shelving = sc.getShelvingById(Integer.parseInt(shelvingId));
				
				if (shelving == null) {
					System.out.println("No se ha econtrado ninguna estantería con el id facilitado");
				} else {
					
					//Add the Copy to the copyShelving into database
					sc.addCopyShelving(shelving.getShelvingId(), copy.getCopyId());
				}

			} while (shelving == null);

		}

		// Give an information message to the user
		System.out.print(copyNumber + " ejemplares del libro " + bookId + " creados con el estado 'Nuevo'");

		// Go to the Copy Menu
		CopyUi.showCopyUi();

	}// showAddCopyMenu()

}// class AddCopyMenu
