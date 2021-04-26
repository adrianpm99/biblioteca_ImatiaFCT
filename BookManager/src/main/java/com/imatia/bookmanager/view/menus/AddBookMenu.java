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

		do
		{
			System.out.print("Titulo: ");
			title = InputUserData.checkUserInput("title", "Maximo 50 caracteres.");
			if(title.equals("")) System.out.println("El titulo es obligatorio. Pruebe de nuevo.");
		}while(title.equals(""));

		do
		{
			System.out.print("Descripcion: ");
			description = InputUserData.checkUserInput("description", "Maximo 300 caracteres");
			if(description.equals("")) System.out.println("La descripcion es obligatoria. Pruebe de nuevo.");
		}while(description.equals(""));
		

		do
		{
			System.out.print("Autor: ");
			author = InputUserData.checkUserInput("author", "Maximo 50 caracteres.");
			if(author.equals("")) System.out.println("El autor es obligatorio. Pruebe de nuevo.");
		}while(author.equals(""));
		

		System.out.print("Páginas del libro: (numero entero positivo)");
		pageNumber = InputUserData.checkUserInput("pageNumber", "Valor incorrecto. Pruebe de nuevo (entero positivo).");

		System.out.print("ISBN: (13 caracteres: numeros y letras sin espacios)");
		ISBN = InputUserData.checkUserInput("ISBN", "\"Valor incorrecto. Pruebe de nuevo (13 caracteres sin espacios).");

		do
		{
			System.out.print("Editorial: ");
			editorial = InputUserData.checkUserInput("editorial", "Maximo 50 caracteres.");
			if(author.equals("")) System.out.println("La editorial es obligoria. Pruebe de nuevo.");
		}while(editorial.equals(""));
		
		System.out.print("Edicion: (numero entero positivo)");
		edition = InputUserData.checkUserInput("edition", "Valor incorrecto. Pruebe de nuevo (entero positivo).");
		
		System.out.print("Año de publicación: (numero 4 cifras entero positivo)");
		bookPublicationYear = InputUserData.checkUserInput("bookPublicationYear", "Valor incorrecto. Pruebe de nuevo (entero 4 cifras positivo).");

		System.out.print("Introduzca el numero de ejemplares del libro: (numero entero positivo)");
		copyNumber = InputUserData.checkUserInput("copyNumber", "Valor incorrecto. Pruebe de nuevo (entero positivo).");

		Book book = new Book(title, description, author, Integer.parseInt(pageNumber), ISBN, editorial,
				Integer.parseInt(edition), Year.parse(bookPublicationYear));

		// add the book to the database
		bc.addBook(book);

		// add the copys of book to the database
		for (int i = 0; i < Integer.parseInt(copyNumber); i++) {

			Copy copy = new Copy();
			copy.setBookId(book.getId());

			cc.addCopy(copy);
		}

		StartMenuUI.showStartMenuUi();

	}

}
