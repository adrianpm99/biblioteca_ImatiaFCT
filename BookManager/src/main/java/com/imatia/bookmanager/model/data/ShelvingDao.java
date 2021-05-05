package com.imatia.bookmanager.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.imatia.bookmanager.model.entities.Shelving;

public class ShelvingDao {
	
	//First, crate a new instance of the connection SQLite
	ConnectionSQLite connectionSQLite = new ConnectionSQLite();
	
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
