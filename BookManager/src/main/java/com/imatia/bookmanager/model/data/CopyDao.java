package com.imatia.bookmanager.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.imatia.bookmanager.model.entities.Copy;

public class CopyDao {

	ConnectionSQLite connectionSQLite = new ConnectionSQLite();

	/**
	 * method to insert a copy in database
	 * 
	 * @param copy
	 */
	public void addCopy(Copy copy) {

		String query = "INSERT INTO copy (bookId, copyAvaliable) VALUES (?,?)";

		try {
			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, copy.getIdBook());
			ps.setBoolean(2, copy.isAvaliable());	
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
			Boolean avaliable = rs.getBoolean("avaliable");

			copy = new Copy(copyId, bookId, avaliable);
			
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
		
		String query ="DELETE FROM book WHERE id = ?";
		
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
}
