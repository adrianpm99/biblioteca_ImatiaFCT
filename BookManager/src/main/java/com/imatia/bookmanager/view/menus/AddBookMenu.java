package com.imatia.bookmanager.view.menus;

import java.time.Year;

import com.imatia.bookmanager.controller.BookController;
import com.imatia.bookmanager.model.entities.Book;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.StartMenuUI;

public class AddBookMenu {

	public static void showAddBookMenu() {

		BookController bc = new BookController();
		String title;
		String description;
		String author;
		int pageNumber;
		String ISBN;
		String editorial;
		int edition;
		Year bookPublicationYear;

		System.out.println("Introduzca los datos para añadir del libro");
		System.out.print("Titulo: ");
		title = InputUserData.checkUserInput("title");
		System.out.print("Descripcion: ");
		description = InputUserData.checkUserInput("description");
		System.out.print("Autor: ");
		author = InputUserData.checkUserInput("author");
		System.out.print("Páginas del libro: ");
		pageNumber = Integer.parseInt(InputUserData.checkUserInput("numberOfSheets"));
		System.out.print("ISBN: ");
		ISBN = InputUserData.checkUserInput("ISBN");
		System.out.print("Editorial: ");
		editorial = InputUserData.checkUserInput("editorial");
		System.out.print("Edicion: ");
		edition = Integer.parseInt(InputUserData.checkUserInput("edition"));
		System.out.print("Año de publicación: ");
		bookPublicationYear = Year.parse(InputUserData.checkUserInput("bookPublicationYear"));

		Book book = new Book(title, description, author, pageNumber, ISBN, editorial, edition, bookPublicationYear);

		bc.addBook(book);
		
		StartMenuUI.showStartMenuUi();

	}

}
