package com.imatia.bookmanager.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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

			ps.setString(1, title + "%");
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
	 * 
	 * @param isbn
	 * @return book
	 */
	public Book getBookByIsbn(String isbn) {

		String query = "SELECT * FROM book WHERE ISBN = ?";
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
	
	public void addBook(Book book) {


		String consulta = "INSERT INTO book (title, description, author, pageNumber, ISBN, editorial, edition, bookPublicationYear) "
				+ "VALUES (?,?,?,?,?,?,?,?) ";

		Connection con;
		try {
			con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(consulta);

			ps.setString(1, book.getTitle());
			ps.setString(2, book.getDescription());
			ps.setString(3, book.getAuthor());
			ps.setInt(4, book.getPageNumber());
			ps.setString(5, book.getISBN());
			ps.setString(6, book.getEditorial());
			ps.setInt(7, book.getEdition());
			String bookPublicationYear = new SimpleDateFormat("yyyy").format(book.getBookPublicationYear());
			ps.setString(8, bookPublicationYear);

			ps.execute();

			ps.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void modifyBook(Book book) {
		String consulta = "UPDATE book SET title=  ?, description = ?, author = ?, pageNumber = ?, ISBN = ?, editorial = ?, edition = ?, bookPublicationYear= ? WHERE id = ?;";

		try {
			Connection con = connectionSQLite.getConnection();
			
			PreparedStatement ps = con.prepareStatement(consulta);
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getDescription());
			ps.setString(3, book.getAuthor());
			ps.setInt(4, book.getPageNumber());
			ps.setString(5, book.getISBN());
			ps.setString(6, book.getEditorial());
			ps.setInt(7, book.getEdition());
			String bookPublicationYear = new SimpleDateFormat("yyyy").format(book.getBookPublicationYear());
			ps.setString(8, bookPublicationYear);
			ps.setInt(9, book.getId());
			
			ps.execute();
			
			ps.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * method to get a list of books filter by author
	 * 
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

			ps.setString(1, author + "%");
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
