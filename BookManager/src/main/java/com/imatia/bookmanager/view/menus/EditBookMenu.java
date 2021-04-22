package com.imatia.bookmanager.view.menus;

import java.time.Year;

import com.imatia.bookmanager.controller.BookController;
import com.imatia.bookmanager.model.entities.Book;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.EditBookUi;
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
		int pageNumber;
		String ISBN;
		String editorial;
		int edition;
		Year bookPublicationYear;
		String stringYear;
		
		Book b= null;
		
		//first show the UI
		EditBookUi.showEditBookUi();
		
		//get the book by Id
		BookController bc = new BookController();
		b= bc.getBookById(id);
		
		//ask-verify-change data
		System.out.print("Introduzca nuevo titulo: (enter para mantener el existente)");
		title = InputUserData.checkUserInput("title");
		if(!title.equals("")) b.setTitle(title);
		
		System.out.print("Introduzca nueva descripcion: (enter para mantener el existente)");
		description = InputUserData.checkUserInput("description");
		if(!description.equals("")) b.setDescription(description);
		
		System.out.print("Introduzca nuevo autor: (enter para mantener el existente)");
		author = InputUserData.checkUserInput("author");
		if(!author.equals("")) b.setAuthor(author);
		
		System.out.print("Introduzca nuevo numero paginas: (0 para mantener el existente)");
		pageNumber = Integer.parseInt(InputUserData.checkUserInput("numberOfSheets"));
		if(pageNumber!=0) b.setPageNumber(pageNumber);
		
		System.out.print("Introduzca nuevo ISBN: (0 para mantener el existente)");
		ISBN = InputUserData.checkUserInput("ISBN");
		if(pageNumber!=0) b.setISBN(ISBN);
		
		System.out.print("Introduzca nueva Editorial: (enter para mantener el existente)");
		editorial = InputUserData.checkUserInput("editorial");
		if(!editorial.equals("")) b.setEditorial(editorial);
		
		System.out.print("Introduzca nueva edicion: (0 para mantener el existente)");
		edition = Integer.parseInt(InputUserData.checkUserInput("edition"));
		if(edition!=0) b.setEdition(edition);
		
		System.out.print("Introduzca nuevo año publicacion: (enter para mantener el existente)");
		stringYear= InputUserData.checkUserInput("bookPublicationYear");
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