package com.imatia.bookmanager.controller;

import java.util.List;

import com.imatia.bookmanager.model.data.BookDao;
import com.imatia.bookmanager.model.entities.Book;

public class BookController {

	BookDao bd = new BookDao();

	public List<Book> getBookByTitle(String title) {

		List<Book> bookList = bd.getBookByTitle(title);

		return bookList;
	}
	
	public Book getBookByIsbn(String isbn) {
		
		Book book = bd.getBookByIsbn(isbn);
		return book;
	}
	
	public List<Book> getBooksByAuthor(String author){
		
		List<Book> bookList = bd.getBooksByAuthor(author);

		return bookList;
		
	}

	public void addBook(Book book) {
		
		bd.addBook(book);
	}
	
	public void modifyBook(Book book) {
		
		bd.modifyBook(book);
	}
}
