package com.imatia.bookmanager.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Methods for accessing data about reservations.
 * Add, Delete and search reservations
 */
public class ReservationDao
{
	//First, crate a new instance of the connection SQLite
	//Will be closed at the end of every method
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
}//class ReservationDao