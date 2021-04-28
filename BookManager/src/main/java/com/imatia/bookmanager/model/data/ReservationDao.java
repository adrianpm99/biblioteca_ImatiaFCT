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
	/**
	 * method to get the data to the result of the ReservationResult
	 * 
	 * @param id Returned book id from lending
	 */
	public ArrayList<String> getReservationAdditionalData(int id) {

		String query = "SELECT r.reservationId, b.id, b.title, u.userId, u.userName, u.userSurname  FROM reservation r, user u, book b WHERE r.userId = u.userId AND r.bookId = b.id = ?;";
		ArrayList<String> al = new ArrayList<String>();
		
		try {
			Connection con = connectionSQLite.getConnection();
			PreparedStatement ps = con.prepareStatement(query);

			ps.setLong(1, id);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			rs.next();
			String reservationId = String.valueOf(rs.getInt("r.reservationId"));
			String bookId = String.valueOf(rs.getInt("b.id"));
			String title  = rs.getString("b.title");
			String userId = String.valueOf(rs.getInt("u.userId"));
			String name = rs.getString("u.userName");
			String surname = rs.getString("u.userSurname");

			ps.close();
			al.add(reservationId);
			al.add(bookId);
			al.add(title);
			al.add(userId);
			al.add(name);
			al.add(surname);
			
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
		return al;
		
	}//getReservationAdditionalData
}//class ReservationDao