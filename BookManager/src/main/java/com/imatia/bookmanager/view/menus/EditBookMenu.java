package com.imatia.bookmanager.view.menus;

import java.time.Year;

import com.imatia.bookmanager.controller.BookController;
import com.imatia.bookmanager.model.entities.Book;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.StartMenuUI;

/**
 * Class for editing and changing the data information
 * of an existing book, received as argument
 */
public class EditBookMenu
{
	public static void showEditBookMenu(int id)
	{
		String title;
		String description;
		String author;
		String pageNumber;
		String ISBN;
		String editorial;
		String edition;
		Year bookPublicationYear;
		String stringYear;
		
		Book b= null;
		
		
		
		//get the book by Id
		BookController bc = new BookController();
		b= bc.getBookById(id);
		
		//ask-verify-change data
		System.out.print("Introduzca nuevo titulo: (enter para mantener el existente)");
		title = InputUserData.checkUserInput("title", "Maximo 50 caracteres.");
		if(!title.equals("")) b.setTitle(title);
		
		System.out.print("Introduzca nueva descripcion: (enter para mantener el existente)");
		description = InputUserData.checkUserInput("description", "Maximo 300 caracteres");
		if(!description.equals("")) b.setDescription(description);
		
		System.out.print("Introduzca nuevo autor: (enter para mantener el existente)");
		author = InputUserData.checkUserInput("author", "Maximo 50 caracteres.");
		if(!author.equals("")) b.setAuthor(author);
		
		System.out.print("Introduzca nuevo numero paginas: (enter para mantener el existente)");
		pageNumber = InputUserData.checkUserInput("pageNumber", "Valor incorrecto. Pruebe de nuevo (entero positivo).");
		if(!pageNumber.equals("")) b.setPageNumber(Integer.parseInt(pageNumber));
		
		System.out.print("Introduzca nuevo ISBN: (enter para mantener el existente)");
		ISBN = InputUserData.checkUserInput("ISBN", "Valor incorrecto. Pruebe de nuevo (13 caracteres sin espacios).");
		if(!ISBN.equals("")) b.setISBN(ISBN);
		
		System.out.print("Introduzca nueva Editorial: (enter para mantener el existente)");
		editorial = InputUserData.checkUserInput("editorial", "Maximo 50 caracteres.");
		if(!editorial.equals("")) b.setEditorial(editorial);
		
		System.out.print("Introduzca nueva edicion: (enter para mantener el existente)");
		edition = InputUserData.checkUserInput("edition", "Valor incorrecto. Pruebe de nuevo (entero positivo).");
		if(!edition.equals("")) b.setEdition(Integer.parseInt(edition));
		
		System.out.print("Introduzca nuevo año publicacion: (enter para mantener el existente)");
		stringYear= InputUserData.checkUserInput("bookPublicationYear", "Valor incorrecto. Pruebe de nuevo (entero 4 cifras positivo).");
		if(!stringYear.equals(""))
		{
			bookPublicationYear = Year.parse(stringYear);
			b.setBookPublicationYear(bookPublicationYear);
		}
		
		//call the method which update the data of the book
		bc.modifyBook(b);
		
		//finally, go to the start menu
		StartMenuUI.showStartMenuUi();
	}//showEditBookMenu
}//class EditBookMenu