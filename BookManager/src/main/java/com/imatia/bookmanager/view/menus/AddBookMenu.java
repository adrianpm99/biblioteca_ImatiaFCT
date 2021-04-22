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
		String pageNumber;
		String ISBN;
		String editorial;
		String edition;
		String bookPublicationYear;
		String copyNumber;

		// get the data from user
		do {
			System.out.print("Titulo: ");
			title = InputUserData.checkUserInput("title");
		} while (title.equals(""));

		do {
			System.out.print("Descripcion: ");
			description = InputUserData.checkUserInput("description");
		} while (description.equals(""));

		do {

			System.out.print("Autor: ");
			author = InputUserData.checkUserInput("author");
		} while (author.equals(""));

		do {
			System.out.print("Páginas del libro: ");
			pageNumber = InputUserData.checkUserInput("pageNumber");
		} while (pageNumber.equals(""));
		
		do {
			System.out.print("ISBN: ");
			ISBN = InputUserData.checkUserInput("ISBN");
		} while (ISBN.equals(""));

		do {
			System.out.print("Editorial: ");
			editorial = InputUserData.checkUserInput("editorial");
		} while (editorial.equals(""));

		do {

			System.out.print("Edicion: ");
			edition = InputUserData.checkUserInput("edition");

		} while (edition.equals(""));

		do {

			System.out.print("Año de publicación: ");
			bookPublicationYear = InputUserData.checkUserInput("bookPublicationYear");

		} while (bookPublicationYear.equals(""));

		do {

			System.out.print("Introduzca el numero de ejemplares del libro: ");
			copyNumber = InputUserData.checkUserInput("copyNumber");
		} while (String.valueOf(copyNumber).equals(""));

		Book book = new Book(title, description, author, Integer.parseInt(pageNumber), ISBN, editorial, Integer.parseInt(edition), Year.parse(bookPublicationYear));

		// add the book to the database
		bc.addBook(book);

		// add the copys of book to the database
		for (int i = 0; i < Integer.parseInt(copyNumber); i++) {
			Copy copy = new Copy();
			copy.setBookId(book.getId());
			copy.setCopyAvaiable(true);

			cc.addCopy(copy);
		}

		StartMenuUI.showStartMenuUi();

	}

}
