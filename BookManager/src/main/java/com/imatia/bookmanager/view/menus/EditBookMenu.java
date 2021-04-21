package com.imatia.bookmanager.view.menus;

import java.time.Year;

import com.imatia.bookmanager.model.entities.Book;
import com.imatia.bookmanager.view.ui.EditBookUi;

/**
 * Class for editing and changing the data information
 * of an existing book, received as argument
 */
public class EditBookMenu
{
	public static void showEditBookMenu(Book b)
	{
		String title;
		String description;
		String author;
		int pageNumber;
		String ISBN;
		String editorial;
		int edition;
		Year bookPublicationYear;
		
		EditBookUi.showEditBookUi();
		
		System.out.print("Introduza el nuevo titulo: (enter para mantener el existente)");
	}//showEditBookMenu
}//class EditBookMenu