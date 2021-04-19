package com.imatia.bookmanager.model.entities;

import java.time.Year;

public class Book {
	
	
	int id;
	String title;
	String description;
	String author;
	String hashtag;
	int numberOfSheets;
	String ISBN;
	String editorial;
	int edition;
	Year bookPublication;
	String genre;
	
	
	
	public Book(int id, String title, String description, String author, String hashtag, int numberOfSheets, String ISBN,
			String editorial, int edition, Year bookPublication, String genre) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.author = author;
		this.hashtag = hashtag;
		this.numberOfSheets = numberOfSheets;
		this.ISBN = ISBN;
		this.editorial = editorial;
		this.edition = edition;
		this.bookPublication = bookPublication;
		this.genre = genre;
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
	public String getHashtag() {
		return hashtag;
	}
	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
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
	public Year getBookPublication() {
		return bookPublication;
	}
	public void setBookPublication(Year bookPublication) {
		this.bookPublication = bookPublication;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", description=" + description + ", author=" + author
				+ ", hashtag=" + hashtag + ", numberOfSheets=" + numberOfSheets + ", ISBN=" + ISBN + ", editorial="
				+ editorial + ", edition=" + edition + ", bookPublication=" + bookPublication + ", genre=" + genre
				+ "]";
	}

}
