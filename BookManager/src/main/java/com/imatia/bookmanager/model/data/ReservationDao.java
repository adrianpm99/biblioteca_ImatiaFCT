package com.imatia.bookmanager.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Methods for accessing data about reservations.
 * Add, Delete and search reservations
 */
public class ReservationDao
{
	//First, crate a new instance of the connection SQLite
	ConnectionSQLite connectionSQLite = new ConnectionSQLite();
	
	
	/**
	 * Method to check if already exists a reservation of a book
	 * @param bookId (the id of the book)
	 * @return true if reservation exists, false if doesn't
	 */
	public boolean checkReservationExist(int bookId)
	{
		boolean reservationExists= false;
		
		String query= "SELECT * FROM reservation WHERE bookId= ?";
		
		try(Connection con= connectionSQLite.getConnection(); 
			PreparedStatement ps= con.prepareStatement(query))
		{
			ps.setInt(1, bookId);
			ps.execute();
			ResultSet rs= ps.getResultSet();
					
			if(rs.next()) reservationExists= true;
		}
		catch (SQLException e) {e.printStackTrace();}
		catch (ClassNotFoundException e1) {e1.printStackTrace();}
		finally
		{
			try {connectionSQLite.closeConnection();}
			catch (SQLException e) {e.printStackTrace();}
		}
		
		return reservationExists;
	}//checkReservationExist()
	
	
	
	/**
	 * Method to search and get a list whith data about
	 * the availables copies of a book (if there are)
	 * @param the id of the book
	 * @return Strings with the title of the book, the id of the book,
	 * and the id of every copy of the book which is not reservated yet.
	 */
	public ArrayList<String> getAvailablesCopies(int bookId)
	{
		ArrayList<String> copyDataList= new ArrayList<String>();
		String copyData;
		
		String query= "SELECT book.id AS 'bookId', book.title AS 'title', copyLending.copyId AS 'copyId' " + 
						"FROM book, copy, copyLending, lending " + 
						"WHERE book.id = ? " + 
						"AND book.id = copy.bookId " + 
						"AND copy.copyId = copyLending.copyId " + 
						"AND copyLending.lendingId = lending.lendingId " + 
						"AND lending.lendingReturnDate NOT NULL";
		
		try(Connection con= connectionSQLite.getConnection(); 
			PreparedStatement ps= con.prepareStatement(query); )
		{
			ps.setInt(1, bookId);
			ps.execute();
			ResultSet rs= ps.getResultSet();
			
			while(rs.next())
			{
				String bookTitle= rs.getString("title");
				int idBook= rs.getInt("bookId");
				int copyId= rs.getInt("copyId");
				
				copyData= "||Titulo: "+bookTitle+" ||Id del libro: "+idBook+" ||Id de la copia: "+copyId;
				copyDataList.add(copyData);
			}
		}
		catch (SQLException e) {e.printStackTrace();}
		catch (ClassNotFoundException e1) {e1.printStackTrace();}
		finally
		{
			try {connectionSQLite.closeConnection();}
			catch (SQLException e) {e.printStackTrace();}
		}
		
		return copyDataList;
	}//getAvailablesCopies()
	
	
}//class ReservationDao