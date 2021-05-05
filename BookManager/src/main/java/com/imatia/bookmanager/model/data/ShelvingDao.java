package com.imatia.bookmanager.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.imatia.bookmanager.model.entities.Shelving;

/**
 * class to map the table shelving to object shelving
 * 
 * @author Grupo2FCTImatia
 *
 */
public class ShelvingDao {

	ConnectionSQLite connectionSQLite = new ConnectionSQLite();

	/*
	 * method to add a shelving to database
	 */
	public void addShelving(Shelving shelving) {

		String query = "INSERT INTO shelving(shelvingNumber) VALUES (?)";

		try {
			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, shelving.getShelvingPublicNumber());
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
	}// addShelving

	/*
	 * method to add a copy shelving to the database
	 */
	public void addCopyShelving(int shelvingId, int copyId) {

		ConnectionSQLite connectionSQLite = new ConnectionSQLite();

		String query = "INSERT INTO CopyShelving(shelvingId,copyId) VALUES (?,?)";

		try {
			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, shelvingId);
			ps.setInt(2, copyId);
			ps.execute();

			System.out.println("Se ha actualizado la localización del ejemplar " + copyId);
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

	}// addCopyShelving

	/*
	 * method to get a shelving by id from the database
	 */
	public Shelving getShelvingById(int id) {

		Shelving shelving = null;

		String query = "SELECT * FROM shelving WHERE shelvingId = ?";

		try {
			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, id);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			if (rs.next()) {
				int shelvingId = rs.getInt("shelvingId");
				int shelvingPublicNumber = rs.getInt("shelvingPublicNumber");

				shelving = new Shelving(shelvingId, shelvingPublicNumber);
			}

			ps.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("La consulta no ha devuelto ningún resultado");
			// e.printStackTrace();
		} finally {
			try {
				connectionSQLite.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return shelving;
	}// getShelvingById
	
	/**
	 * Get the shelving object where is the copy
	 * @param copyId
	 * @return Shelving
	 */
	public Shelving getShelvingByCopyId(int copyId){
		
		Shelving shelving = null;
		
		String query ="SELECT * FROM shelving s, copyShelving cs WHERE s.shelvingId = cs.shelvingId AND cs.copyId = ?";
		
		try {
			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, copyId);
			ps.execute();

			ResultSet rs = ps.getResultSet();
			if(rs.next()) {
				//Get the data
				int shelvingId = rs.getInt("shelvingId");
				int shelvingPublicNumber = rs.getInt("shelvingPublicNumber");

				//Create a Object with the data
				shelving = new Shelving(shelvingId, shelvingPublicNumber);
			}
			ps.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			//e.printStackTrace();
		} finally {
			try {
				connectionSQLite.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return shelving;
		
	}//Shelving getShelvingByCopyId(int copyId){
	
}//class ShelvingDao
