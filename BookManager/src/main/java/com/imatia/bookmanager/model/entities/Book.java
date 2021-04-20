package com.imatia.bookmanager.model.entities;

import java.time.Year;

public class Book {
	
	
	int id;
	String title;
	String description;
	String author;
	int numberOfSheets;
	String ISBN;
	String editorial;
	int edition;
	Year bookPublicationYear;

	
	
	
	public Book(int id, String title, String description, String author, int numberOfSheets, String ISBN,
			String editorial, int edition, Year bookPublicationYear) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.author = author;
		
		this.numberOfSheets = numberOfSheets;
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
	
	public int getNumberOfSheets() {
		return numberOfSheets;
	}
	public void setNumberOfSheets(int numberOfSheets) {
		this.numberOfSheets = numberOfSheets;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String ISBN) {
		ISBN = ISBN;
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
	

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", description=" + description + ", author=" + author
				 + ", numberOfSheets=" + numberOfSheets + ", ISBN=" + ISBN + ", editorial="
				+ editorial + ", edition=" + edition + ", bookPublicationYear=" + bookPublicationYear 
				+ "]";
	}

}
