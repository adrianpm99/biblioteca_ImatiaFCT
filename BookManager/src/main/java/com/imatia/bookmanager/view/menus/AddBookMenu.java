package com.imatia.bookmanager.view.menus;

import java.time.Year;

import com.imatia.bookmanager.controller.BookController;
import com.imatia.bookmanager.controller.CopyController;
import com.imatia.bookmanager.model.entities.Book;
import com.imatia.bookmanager.model.entities.Copy;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.StartMenuUI;

/**
 * class implements the add book menu
 * 
 * @author Grupo2FCTImatia
 *
 */
public class AddBookMenu {

	public static void showAddBookMenu() {

		BookController bc = new BookController();
		CopyController cc = new CopyController();
		String title;
		String description;
		String author;
		int pageNumber;
		String ISBN;
		String editorial;
		int edition;
		Year bookPublicationYear;
		int copyNumber;

		// get the data from user
		System.out.print("Titulo: ");
		title = InputUserData.checkUserInput("title");
		System.out.print("Descripcion: ");
		description = InputUserData.checkUserInput("description");
		System.out.print("Autor: ");
		author = InputUserData.checkUserInput("author");
		System.out.print("Páginas del libro: ");
		pageNumber = Integer.parseInt(InputUserData.checkUserInput("pageNumber"));
		System.out.print("ISBN: ");
		ISBN = InputUserData.checkUserInput("ISBN");
		System.out.print("Editorial: ");
		editorial = InputUserData.checkUserInput("editorial");
		System.out.print("Edicion: ");
		edition = Integer.parseInt(InputUserData.checkUserInput("edition"));
		System.out.print("Año de publicación: ");
		bookPublicationYear = Year.parse(InputUserData.checkUserInput("bookPublicationYear"));
		System.out.print("Introduzca el numero de ejemplares del libro: ");
		copyNumber = Integer.parseInt(InputUserData.checkUserInput("copyNumber"));

		Book book = new Book(title, description, author, pageNumber, ISBN, editorial, edition, bookPublicationYear);

		// add the book to the database
		bc.addBook(book);

		// add the copys of book to the database
		for (int i = 0; i < copyNumber; i++) {
			Copy copy = new Copy();
			copy.setBookId(book.getId());
			copy.setCopyAvaiable(true);

			cc.addCopy(copy);
		}

		StartMenuUI.showStartMenuUi();

	}

}
