package com.imatia.bookmanager.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.imatia.bookmanager.model.entities.Reservation;


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
	 * Method to check if a book exists in the copyLending table
	 * @param bookId (the id of the book)
	 * @return true if exists, false if doesn't
	 */
	public boolean checkLendingBookExist(int bookId)
	{
		boolean reservationExists= false;
		
		String query= "SELECT * FROM copy c,copyLending cl WHERE c.copyId = cl.copyId AND c.bookId = ?";
		
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
	}//checkLendingBookExist()
	
	
	/**
	 * Method to search and get a list whith data about
	 * the availables copies of a book (if there are)
	 * @param the id of the book
	 * @return Strings with the title of the book, the id of the book,
	 * and the id of every copy of the book which is not reservated yet.
	 */
	public ArrayList<String> getAvailableCopies(int bookId)
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
	}//getAvailableCopies()
	
	/**
	 * Method to search and get a list whith data about
	 * the availables copies of a book (if there are)
	 * @param the id of the book
	 * @return Strings with the title of the book, the id of the book,
	 * and the id of every copy of the book which is not reservated yet.
	 */
	public ArrayList<String> getAvailableCopiesAlternative(int bookId)
	{
		ArrayList<String> copyDataList= new ArrayList<String>();
		String copyData;
		
		String query= "SELECT id, title , c.copyId FROM book b, copy c WHERE b.id = c.bookId AND b.id = ?";
		
		try(Connection con= connectionSQLite.getConnection(); 
			PreparedStatement ps= con.prepareStatement(query); )
		{
			ps.setInt(1, bookId);
			ps.execute();
			ResultSet rs= ps.getResultSet();
			
			while(rs.next())
			{
				String bookTitle= rs.getString("title");
				int idBook= rs.getInt("id");
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
	}//getAvailableCopies()
	
	/**
	 * Method to add a new reservation into the bbdd
	 * @param bookId
	 * @param userId
	 */
	public void addReservation(Reservation reserv)
	{
		String query= "INSERT INTO reservation (bookId, userId) VALUES (?,?)";
		
		try(Connection con= connectionSQLite.getConnection(); 
			PreparedStatement ps= con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
		{
			ps.setInt(1, reserv.getBookId());
			ps.setInt(2, reserv.getUserId());
			ps.execute();
					
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1);
			reserv.setReservationId(id);
		}
		catch (SQLException e) {e.printStackTrace();}
		catch (ClassNotFoundException e1) {e1.printStackTrace();}
		finally
		{
			try {connectionSQLite.closeConnection();}
			catch (SQLException e) {e.printStackTrace();}
		}
	}//addReservation
	
	
	
	/**
	* method to get the data to the result of the ReservationResult
	* 
	* @param id Returned book id from lending
	*/
	public ArrayList<String> getReservationAdditionalData(int id) {

		String query = "SELECT r.reservationId, b.id, b.title, u.userId, u.userName, u.userSurname "
				+ " FROM reservation r, user u, book b WHERE r.userId = u.userId AND r.bookId = b.id AND b.id = ?;";
		ArrayList<String> al = new ArrayList<String>();
		
		try {
			Connection con = connectionSQLite.getConnection();
			PreparedStatement ps = con.prepareStatement(query);

			ps.setLong(1, id);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			rs.next();
			String reservationId = String.valueOf(rs.getInt("reservationId"));
			String bookId = String.valueOf(rs.getInt("id"));
			String title  = rs.getString("title");
			String userId = String.valueOf(rs.getInt("userId"));
			String name = rs.getString("userName");
			String surname = rs.getString("userSurname");

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
	
	public void deleteReservation(int id) {
		String query = "DELETE FROM reservation WHERE reservationId = ?";

		try {
			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, id);
			ps.execute();

			System.out.println("Reserva con id " + id + " borrada");

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
	}//deleteReservation

	public Reservation getReservationById(int id) {
		
		Reservation reservation= null;
		String query ="SELECT * FROM reservation WHERE reservationId = ?";
		
		try {
			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, id);
			ps.execute();

			ResultSet rs = ps.getResultSet();
			rs.next();

			int reservationId = rs.getInt("reservationId");
			int bookId = rs.getInt("bookId");
			int userId = rs.getInt("userId");

			reservation = new Reservation(reservationId, bookId, userId);

			ps.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("La consulta no ha devuelto ning??n resultado");
			//e.printStackTrace();
		} finally {
			try {
				connectionSQLite.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return reservation;
	}//getReservationById
	
}//class ReservationDao