package com.imatia.bookmanager.view.results;

import java.util.List;

import com.imatia.bookmanager.model.entities.Book;

/**
 * These utils receive a list of books and then, according to the search method,
 * will print some specific basic data
 */
public class BookRenderers {
	/**
	 * shows: id, title, author, ISBN
	 * 
	 * @param bookList
	 *            searched by title (complete or single words)
	 */
	public static void renderTitleListBooks(List<Book> bookList) {
		if (bookList.isEmpty()) {
			System.out.println("No hay ningún libro con el titulo facilitado");
		}
		for (Book b : bookList) {
			System.out.println(
					"===========================================================================================\n");
			System.out.println("Id: " + b.getId() + "\t|| Titulo: " + b.getTitle() + "\t|| Autor: " + b.getAuthor()
					+ "\t|| ISBN: " + b.getISBN() + "\n");
		}
	}// renderTitleLisBooks()

	/**
	 * shows: id, title, ISBN
	 * 
	 * @param bookList
	 *            searched by author (complete name or single words)
	 */
	public static void renderAuthorListBooks(List<Book> bookList) {
		if (bookList.isEmpty()) {
			System.out.println("No hay ningún libro del autor facilitado");
		}
		for (Book b : bookList) {
			System.out.println(
					"===========================================================================================\n");
			System.out
					.println("Id: " + b.getId() + "\t|| Titulo: " + b.getTitle() + "\t|| ISBN: " + b.getISBN() + "\n");
		}
	}// renderAuthorListBooks()

	/**
	 * shows: id, title, author
	 * 
	 * @param bookList
	 *            searched by ISBN (just one result)
	 */
	public static void renderISBNListBooks(List<Book> bookList) {
		if (bookList.isEmpty()) {
			System.out.println("No hay ningún libro con el ISBN facilitado");
		} else {
			for (Book b : bookList) {
				System.out.println(
						"===========================================================================================\n");
				System.out.println(
						"Id: " + b.getId() + "\t|| Titulo: " + b.getTitle() + "\t|| Autor: " + b.getAuthor() + "\n");
			}
		}
	}// renderISBNListBooks()

}// class BookRenderers