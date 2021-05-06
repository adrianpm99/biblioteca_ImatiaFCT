package com.imatia.bookmanager.view.menus;

import java.time.Year;

import com.imatia.bookmanager.controller.BookController;
import com.imatia.bookmanager.controller.CopyController;
import com.imatia.bookmanager.controller.ShelvingController;
import com.imatia.bookmanager.model.entities.Book;
import com.imatia.bookmanager.model.entities.Copy;
import com.imatia.bookmanager.model.entities.Shelving;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.StartMenuUI;

/**
 * Class implements the add book menu
 * 
 * @author Grupo2FCTImatia
 */

public class AddBookMenu {

	public static void showAddBookMenu() {

		BookController bc = new BookController();
		CopyController cc = new CopyController();
		ShelvingController sc = new ShelvingController();

		String title;
		String description;
		String author;
		String pageNumber;
		String ISBN;
		String editorial;
		String edition;
		String bookPublicationYear;
		String copyNumber;
		String shelvingId;

		// Get the data from user

		// Ask for Title
		do {

			System.out.print("Titulo: ");

			title = InputUserData.checkUserInput("title", "Maximo 50 caracteres.");

			if (title.equals(""))
				System.out.println("El titulo es obligatorio. Pruebe de nuevo.");

		} while (title.equals(""));

		// Ask for Description
		do {

			System.out.print("Descripcion: ");

			description = InputUserData.checkUserInput("description", "Maximo 300 caracteres");

			if (description.equals(""))
				System.out.println("La descripcion es obligatoria. Pruebe de nuevo.");

		} while (description.equals(""));

		// Ask for Autor
		do {

			System.out.print("Autor: ");

			author = InputUserData.checkUserInput("author", "Maximo 50 caracteres.");

			if (author.equals(""))
				System.out.println("El autor es obligatorio. Pruebe de nuevo.");

		} while (author.equals(""));

		// Ask for PageNumber
		System.out.print("Páginas del libro (numero entero positivo): ");

		pageNumber = InputUserData.checkUserInput("pageNumber", "Valor incorrecto. Pruebe de nuevo (entero positivo).");

		// Ask for ISBN
		do {

			System.out.print("ISBN (13 caracteres: numeros y letras sin espacios): ");

			ISBN = InputUserData.checkUserInput("ISBN",
					"Valor incorrecto. Pruebe de nuevo (13 caracteres sin espacios).");

			if (ISBN.equals(""))
				System.out.println("El ISBN es obligatorio. Pruebe de nuevo.");

		} while (ISBN.equals(""));

		// Ask for Editorial
		do {

			System.out.print("Editorial: ");

			editorial = InputUserData.checkUserInput("editorial", "Maximo 50 caracteres.");

			if (author.equals(""))
				System.out.println("La editorial es obligatoria. Pruebe de nuevo.");

		} while (editorial.equals(""));

		// Ask for Edicion
		System.out.print("Edicion(numero entero positivo): ");

		edition = InputUserData.checkUserInput("edition", "Valor incorrecto. Pruebe de nuevo (entero positivo).");

		// Ask for PublicationYear
		System.out.print("Año de publicación (numero 4 cifras entero positivo): ");

		bookPublicationYear = InputUserData.checkUserInput("bookPublicationYear",
				"Valor incorrecto. Pruebe de nuevo (entero 4 cifras positivo).");

		// Ask for Number of copies
		System.out.print("Introduzca el numero de ejemplares del libro (numero entero positivo): ");

		copyNumber = InputUserData.checkUserInput("copyNumber", "Valor incorrecto. Pruebe de nuevo (entero positivo).");

		// Create the new Book
		Book book = new Book(title, description, author, Integer.parseInt(pageNumber), ISBN, editorial,
				Integer.parseInt(edition), Year.parse(bookPublicationYear));

		// Add the Book into database
		bc.addBook(book);

		if (!copyNumber.equals("")) {

			// Add the copies of book to the database
			for (int i = 0; i < Integer.parseInt(copyNumber); i++) {

				Shelving shelving = null;
				Copy copy = new Copy();

				// Set BookId for the copy
				copy.setBookId(book.getId());

				// Set CopyNotes for the copy
				copy.setcopyNotes("Buen estado");

				// Add the copy into database
				cc.addCopy(copy);

				do {

					// Add the shelving where copy is located
					System.out.print("Introduzca la estantería para el ejemplar " + copy.getCopyId()
							+ " (numero entero positivo): ");

					shelvingId = InputUserData.checkUserInput("pageNumber",
							"Valor incorrecto. Pruebe de nuevo (entero positivo).");

					// check if the shelving exists
					shelving = sc.getShelvingById(Integer.parseInt(shelvingId));

					if (shelving == null) {

						System.out.println("No se ha econtrado ninguna estantería con el id facilitado");

					} else {

						// Add the Copy to the copyShelving into database
						sc.addCopyShelving(shelving.getShelvingId(), copy.getCopyId());
					}

				} while (shelving == null);
			}
		}

		// Go to the Start Menu
		StartMenuUI.showStartMenuUi();

	}// showAddBookMenu()

}// class AddBookMenu
