package com.imatia.bookmanager.controller;

import java.util.ArrayList;
import java.util.List;

import com.imatia.bookmanager.model.data.BookDao;
import com.imatia.bookmanager.model.entities.Book;
import com.imatia.bookmanager.view.ui.SearchesUi;

/**
 * class to implement the methods to connect views with data
 * 
 * @author Grupo2FCTImatia
 *
 */
public class BookController {

	BookDao bd = new BookDao();

	public Book getBookById(int id) {
		
		Book book = bd.getBookById(id);
		if(book == null) {
			System.out.println("No se ha encontrado ningún libro con el id facilitado");
			SearchesUi.showSearchesUi();
		}
		return book;
	}

	/**
	 * method to get a list of books filter by title
	 * 
	 * @param title
	 * @return bookList
	 */
	public List<Book> getBookByTitle(String title) {

		List<Book> bookList = bd.getBookByTitle(title);
		
		return bookList;
	}

	/**
	 * method to get a list of books filter by isbn
	 * 
	 * @param isbn
	 * @return bookList
	 */
	public List<Book> getBookByIsbn(String isbn) {

		List<Book> bookList = new ArrayList<>();
		Book book = bd.getBookByIsbn(isbn);
		if (book.getId()!=0) {
			bookList.add(book);
		}
		return bookList;
	}

	/**
	 * method to get a list of books filter by author
	 * 
	 * @param author
	 * @return bookList
	 */
	public List<Book> getBooksByAuthor(String author) {

		List<Book> bookList = bd.getBooksByAuthor(author);

		return bookList;

	}

	/**
	 * method to insert a book in database
	 * 
	 * @param book
	 */
	public void addBook(Book book) {

		bd.addBook(book);
	}

	/**
	 * method to edit a book
	 * 
	 * @param book
	 */
	public void modifyBook(Book book) {

		bd.modifyBook(book);
	}

	/**
	 * method to delete a book
	 * 
	 * @param id
	 */
	public void deleteBook(int id) {
		bd.deleteBook(id);

	}//deleteBook
	/**
	 * method to get a list of id books by copys in copylending table
	 * @param lendingId
	 * @return listIdBook
	 */
	public List<Integer> getListIdBookByCopysInLendingCopy(int lendingId) {
		
		List<Integer> listIdBook = bd.getListIdBookByCopysInLendingCopy(lendingId);
				
		return listIdBook;
	
	}//getListIdBookByCopysInLendingCopy
}
