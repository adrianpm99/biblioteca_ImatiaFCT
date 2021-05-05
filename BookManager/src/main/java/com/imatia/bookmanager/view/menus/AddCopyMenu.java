package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.BookController;
import com.imatia.bookmanager.controller.CopyController;
import com.imatia.bookmanager.controller.ShelvingController;
import com.imatia.bookmanager.model.entities.Copy;
import com.imatia.bookmanager.model.entities.Shelving;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.CopyUi;

public class AddCopyMenu {

	public static void showAddCopyMenu() {

		CopyController cc = new CopyController();
		BookController bc = new BookController();
		ShelvingController sc = new ShelvingController();
		String bookId = null;
		String shelvingId;
		String copyNumber;

		do {
			System.out.print("Introduzca el id del libro: ");
			bookId = InputUserData.checkUserInput("id", "Valor de Id incorrecto. Pruebe de nuevo (entero positivo).");
			if (bc.getBookById(Integer.parseInt(bookId)) == null) {
				System.out.print("Este libro no existe\r ");
				bookId = "";
			}
		} while (bookId.equals(""));

		do {
			System.out.print("Introduzca el numero de ejemplares del libro: (numero entero positivo)");
			copyNumber = InputUserData.checkUserInput("copyNumber",
					"Valor incorrecto. Pruebe de nuevo (entero positivo).");
		} while (copyNumber.equals(""));

		// add the copies of book to the database
		for (int i = 0; i < Integer.parseInt(copyNumber); i++) {
			Shelving shelving = null;
			Copy copy = new Copy();
			copy.setBookId(Integer.parseInt(bookId));
			copy.setcopyNotes("Buen estado");
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
					sc.addCopyShelving(shelving.getShelvingId(), copy.getCopyId());
				}
			}while(shelving == null);
		}

		System.out.print(copyNumber + " ejemplares del libro " + bookId + " creados con el estado 'Nuevo'");
		CopyUi.showCopyUi();

	}
}
