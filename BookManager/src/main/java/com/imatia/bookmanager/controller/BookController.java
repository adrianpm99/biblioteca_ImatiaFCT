package com.imatia.bookmanager.controller;

import java.util.ArrayList;
import java.util.List;

import com.imatia.bookmanager.model.data.BookDao;
import com.imatia.bookmanager.model.entities.Book;


/**
 * class to implement the methods to connect views with data (regarding Books)
 * 
 * @author Grupo2FCTImatia
 *
 */

public class BookController {

	BookDao bd = new BookDao();

	/**
	 * method to get a single book by its id
	 * 
	 * @param id
	 * @return book
	 */
	
	public Book getBookById(int id) {
		
		Book book = bd.getBookById(id);
		return book;
	}//getBookById

	/**
	 * method to get a list of books filtered by title
	 *  
	 * @param title
	 * @return bookList
	 */
	
	public List<Book> getBookByTitle(String title) {

		List<Book> bookList = bd.getBookByTitle(title);
		
		return bookList;
	}//getBookByTitle

	/**
	 * method to get a list of books filtered by isbn
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
	}//getBookByIsbn

	/**
	 * method to get a list of books filtered by author
	 * 
	 * @param author
	 * @return bookList
	 */
	
	public List<Book> getBooksByAuthor(String author) {

		List<Book> bookList = bd.getBooksByAuthor(author);

		return bookList;
	}//getBooksByAuthor

	/**
	 * method to insert a book in the database
	 * 
	 * @param book
	 */
	
	public void addBook(Book book) {

		bd.addBook(book);
	}//addBook

	/**
	 * method to edit a book
	 * 
	 * @param book
	 */
	
	public void modifyBook(Book book) {

		bd.modifyBook(book);		
	}//modifyBook

	/**
	 * method to delete a book
	 * 
	 * @param id
	 */
	
	public void deleteBook(int id) {
		bd.deleteBook(id);

	}//deleteBook
	
	/**
	 * method to get a list of id books by copies in the DB's copylending table
	 * 
	 * @param lendingId
	 * @return listIdBook
	 */
	
	public List<Integer> getListIdBookByCopysInLendingCopy(int lendingId) {
		
		List<Integer> listIdBook = bd.getListIdBookByCopysInLendingCopy(lendingId);
				
		return listIdBook;
	
	}//getListIdBookByCopysInLendingCopy
	
}//BookController
