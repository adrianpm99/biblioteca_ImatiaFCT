package com.imatia.bookmanager.model.entities;

import java.time.Year;

/**
 * Class that defines the Book object with its attributes, constructors and
 * getter and setter methods
 * 
 * @author Grupo2FCTImatia
 */

public class Book {

	int id;
	String title;
	String description;
	String author;
	int pageNumber;
	String ISBN;
	String editorial;
	int edition;
	Year bookPublicationYear;

	public Book() {
	}// Book()

	/**
	 * Called by getBookBy..., gets an already existing Book in the DB
	 */
	
	public Book(int id, String title, String description, String author, int pageNumber, String ISBN, String editorial,
			int edition, Year bookPublicationYear) {

		this.id = id;
		this.title = title;
		this.description = description;
		this.author = author;
		this.pageNumber = pageNumber;
		this.ISBN = ISBN;
		this.editorial = editorial;
		this.edition = edition;
		this.bookPublicationYear = bookPublicationYear;

	}// Book
	
	/**
	 * Called by showAddBookMenu, adds a new book and gives it an id
	 */
	
	public Book(String title, String description, String author, int pageNumber, String iSBN, String editorial,
			int edition, Year bookPublicationYear) {
		
		super();
		this.title = title;
		this.description = description;
		this.author = author;
		this.pageNumber = pageNumber;
		ISBN = iSBN;
		this.editorial = editorial;
		this.edition = edition;
		this.bookPublicationYear = bookPublicationYear;

	}// Book()

	public int getId() {
		return id;
	}// getId()

	public void setId(int id) {
		this.id = id;
	}// setId()

	public String getTitle() {
		return title;
	}// getTitle()

	public void setTitle(String title) {
		this.title = title;
	}// setTitle()

	public String getDescription() {
		return description;
	}// getDescription()

	public void setDescription(String description) {
		this.description = description;
	}// setDescription()

	public String getAuthor() {
		return author;
	}// getAuthor()

	public void setAuthor(String author) {
		this.author = author;
	}// setAuthor()

	public int getPageNumber() {
		return pageNumber;
	}// getPageNumber()

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}// setPageNumber()

	public String getISBN() {
		return ISBN;
	}// getISBN()

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}// setISBN()

	public String getEditorial() {
		return editorial;
	}// getEditorial()

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}// setEditorial()

	public int getEdition() {
		return edition;
	}// getEdition()

	public void setEdition(int edition) {
		this.edition = edition;
	}// setEdition()

	public Year getBookPublicationYear() {
		return bookPublicationYear;
	}// getBookPublicationYear()

	public void setBookPublicationYear(Year bookPublicationYear) {
		this.bookPublicationYear = bookPublicationYear;
	}// setBookPublicationYear()

}// class Book
