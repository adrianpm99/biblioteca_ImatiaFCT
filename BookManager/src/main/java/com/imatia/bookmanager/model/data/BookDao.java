package com.imatia.bookmanager.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import com.imatia.bookmanager.model.entities.Book;

/**
 * class to map the table book to object book
 * 
 * @author Grupo2FCTImatia
 *
 */
public class BookDao {

	ConnectionSQLite connectionSQLite = new ConnectionSQLite();

	/**
	 * method to get a list of books filter by title
	 * 
	 * @param title
	 * @return bookList
	 */
	public List<Book> getBookByTitle(String title) {

		String query = "SELECT * FROM book WHERE title LIKE ?";
		List<Book> bookList = new ArrayList<>();
		Book book = new Book();

		try {

			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, "%" + title + "%");
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {

				int id = rs.getInt("id");
				String bookTitle = rs.getString("title");
				String description = rs.getString("description");
				String author = rs.getString("autor");
				int pagesNumber = rs.getInt("numberOfSheets");
				String isbn = rs.getString("isbn");
				String editorial = rs.getString("editorial");
				int edition = rs.getInt("edition");
				Year bookPublicationYear = Year.parse(rs.getString("bookPublicationYear"));

				book = new Book(id, bookTitle, description, author, pagesNumber, isbn, editorial, edition,
						bookPublicationYear);
				bookList.add(book);

			}
			ps.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connectionSQLite.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return bookList;
	}

	/**
	 * method to get a book filter by isbn
	 * @param isbn
	 * @return book
	 */
	public Book getBookByIsbn(String isbn) {

		String query = "SELECT * FROM book WHERE ISBN=?";
		Book book = new Book();

		try {

			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, isbn);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			rs.next();

			int id = rs.getInt("id");
			String bookTitle = rs.getString("title");
			String description = rs.getString("description");
			String author = rs.getString("autor");
			int pagesNumber = rs.getInt("numberOfSheets");
			String bookIsbn = rs.getString("isbn");
			String editorial = rs.getString("editorial");
			int edition = rs.getInt("edition");
			Year bookPublicationYear = Year.parse(rs.getString("bookPublicationYear"));

			book = new Book(id, bookTitle, description, author, pagesNumber, bookIsbn, editorial, edition,
					bookPublicationYear);

			ps.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connectionSQLite.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return book;
	}

	/**
	 * method to get a list of books filter by author
	 * @param author
	 * @return bookList
	 */
	public List<Book> getBooksByAuthor(String author) {

		String query = "SELECT * FROM book WHERE autor LIKE ?";
		List<Book> bookList = new ArrayList<>();
		Book book = new Book();

		try {

			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, "%" + author + "%");
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {

				int id = rs.getInt("id");
				String bookTitle = rs.getString("title");
				String description = rs.getString("description");
				String bookAuthor = rs.getString("autor");
				int pagesNumber = rs.getInt("numberOfSheets");
				String isbn = rs.getString("isbn");
				String editorial = rs.getString("editorial");
				int edition = rs.getInt("edition");
				Year bookPublicationYear = Year.parse(rs.getString("bookPublicationYear"));

				book = new Book(id, bookTitle, description, bookAuthor, pagesNumber, isbn, editorial, edition,
						bookPublicationYear);
				bookList.add(book);

			}
			ps.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connectionSQLite.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return bookList;
	}

}
