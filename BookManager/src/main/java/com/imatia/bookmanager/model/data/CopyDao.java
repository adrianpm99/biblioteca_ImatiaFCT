package com.imatia.bookmanager.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.imatia.bookmanager.model.entities.Copy;

/**
 * class to map the table copy to object copy
 * @author Grupo2FCTImatia
 *
 */
public class CopyDao {

	ConnectionSQLite connectionSQLite = new ConnectionSQLite();

	/**
	 * method to insert a copy in database
	 * 
	 * @param copy
	 */
	public void addCopy(Copy copy) {

		String query = "INSERT INTO copy (bookId,copyNotes) VALUES (?,?)";

		try {
			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, copy.getBookId());
			ps.setString(2, copy.getcopyNotes());
			ps.execute();
			
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
	}

	/**
	 * method to get a copy filte by id
	 * @param id
	 * @return copy
	 */
	public Copy getCopyById(int id) {

		Copy copy = new Copy();

		String query = "SELECT * FROM copy WHERE copyId = ?";

		try {
			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, id);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			rs.next();

			int copyId = rs.getInt("copyId");
			int bookId = rs.getInt("bookId");
			String copyNotes = rs.getString("copyNotes");

			copy = new Copy(copyId, bookId, copyNotes);
			
			ps.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connectionSQLite.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return copy;
	}
	
	/**
	 * method to delete a copy filter by id
	 * @param id
	 */
	public void deleteCopy(int id) {
		
		String query ="DELETE FROM copy WHERE id = ?";
		
		try {
			Connection con = connectionSQLite.getConnection();
			
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, id);
			ps.execute();
			
			System.out.println("Ejemplar con id: "+ id +" borrado");
			
			ps.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connectionSQLite.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * method to delete a copy of book by idBook
	 * @param id
	 */
	public void deleteCopybyIdBook(int id) {
		
		String query ="DELETE FROM copy WHERE bookId = ?";
		
		try {
			Connection con = connectionSQLite.getConnection();
			
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, id);
			ps.execute();
			
			System.out.println("Ejemplares del libro con id "+ id +" borrados");
			
			ps.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connectionSQLite.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	/**
	 * method to get a list of idCopys in lending by book
	 * @param lendingId
	 * @param bookId
	 * @return
	 */
	public List<Integer> getCopyIdInLendingByBook(int lendingId, int bookId){
		List<Integer> listIdCopys = new ArrayList<>();
		
		String query = "SELECT copyId FROM copyLending WHERE lendingId= ? AND copyId IN(SELECT copyId FROM copy WHERE bookId= ?)";

		try {
			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, lendingId);
			ps.setInt(2, bookId);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while(rs.next()) {

			int idCopy = rs.getInt("copyId");
			
			listIdCopys.add(idCopy);
			
			}
			
			
			ps.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connectionSQLite.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		return listIdCopys;
	}
	
	
}
