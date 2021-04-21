package com.imatia.bookmanager.model.entities;

import java.time.Year;

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
		
	}
	
	public Book(int id, String title, String description, String author, int pageNumber, String ISBN,
			String editorial, int edition, Year bookPublicationYear) {
		
		this.id = id;
		this.title = title;
		this.description = description;
		this.author = author;	
		this.pageNumber = pageNumber;
		this.ISBN = ISBN;
		this.editorial = editorial;
		this.edition = edition;
		this.bookPublicationYear = bookPublicationYear;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public Year getBookPublicationYear() {
		return bookPublicationYear;
	}
	public void setBookPublicationYear(Year bookPublicationYear) {
		this.bookPublicationYear = bookPublicationYear;
	}

}
