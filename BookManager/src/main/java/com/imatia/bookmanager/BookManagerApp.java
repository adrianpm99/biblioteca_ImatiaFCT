package com.imatia.bookmanager;

import java.util.List;

import com.imatia.bookmanager.controller.BookController;
import com.imatia.bookmanager.model.entities.Book;

/**
 * BookManagerApp
 *
 */

public class BookManagerApp {
	public static void main(String[] args) {
		//System.out.println("AdiosMundo");
		BookController bc = new BookController();
		
		
		List<Book> lista = bc.getBookByTitle("El Evan");
		
		for (Book b: lista) {
			System.out.println(b);
		}
	}
}
