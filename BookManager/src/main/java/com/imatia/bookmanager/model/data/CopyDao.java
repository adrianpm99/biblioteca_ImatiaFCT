package com.imatia.bookmanager.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.imatia.bookmanager.model.entities.Copy;
import com.imatia.bookmanager.view.ui.SearchLendingUi;

/**
 * class to map the copy table to copy object
 * 
 * @author Grupo2FCTImatia
 *
 */

public class CopyDao {
	
	//First we open a connection to the database

	ConnectionSQLite connectionSQLite = new ConnectionSQLite();

	/**
	 * method to insert a copy in the database
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
		}//finally
	}//addCopy

	/**
	 * method to get a copy filtered by id
	 * @param id
	 * @return copy
	 */
	
	public Copy getCopyById(int id) {

		Copy copy = null;
		String query = "SELECT * FROM copy WHERE copyId = ?";

		try {
			Connection con = connectionSQLite.getConnection();
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, id);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			if(rs.next()) {
				int copyId = rs.getInt("copyId");
				int bookId = rs.getInt("bookId");
				String copyNotes = rs.getString("copyNotes");

				copy = new Copy(copyId, bookId, copyNotes);
			}
			
			ps.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {			
			System.out.println("La consulta no ha devuelto ningún resultado");			
		}finally {
			try {
				connectionSQLite.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//finally
		
		return copy;
	}//getCopyById
	
	/**
	 * method to delete a copy filtered by id
	 * @param id
	 */
	
	public void deleteCopy(int id) {
		
		String query ="DELETE FROM copy WHERE copyId = ?";
		
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
		}//finally		
	}//deleteCopy
	
	/**
	 * method to delete a copy of a book by idBook
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
		}//finally		
	}//deleteCopybyIdBook
	
	/**
	 * method to get a list of id copies in lending by book
	 * @param lendingId, bookId
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
		}//finally
		
		return listIdCopys;
	}//getCopyIdInLendingByBook

	/**
	 * method to get a List of all the copies of a book
	 * @param bookId
	 */
	
	public List<Copy> getCopyByBookId(int bookId) {
		
		Copy copy = new Copy();
		List<Copy> copyList = new ArrayList<>();
		
		String query = "SELECT * FROM copy WHERE bookId = ?";
		
		try {
			Connection con = connectionSQLite.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, bookId);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while(rs.next()) {
				int copyId = rs.getInt("copyId");
				String copyNotes = rs.getString("CopyNotes");
				
				//There is no else as copyNotes is NOT NULL in the db
				copy = new Copy(copyId, copyNotes);
				copyList.add(copy);
			}
			
			ps.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("No se ha encontrado ningun prestamo con el id de usuario facilitado");
			// e.printStackTrace();
			SearchLendingUi.showSearchLendingUi();
		} finally {
			try {
				connectionSQLite.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};//finally
		
		return copyList;
	}//getCopyByBookId
	
	/**
	 * method to edit the notes of a Copy
	 * 
	 * @param id, copyNote
	 */
	
	public void editCopyNotes(int id, String copyNote) {
		
		String query = "UPDATE copy SET copyNotes =? WHERE copyId= ?";

		try {
			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, copyNote);
			ps.setInt(2, id);

			System.out.println("La nota se ha actualizado");

			ps.executeUpdate();

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
	 * method to check if a copy is lent before proceeding to delete the copy
	 * 
	 * @param id
	 * @return true if the copy is lent, false if not
	 */
	public boolean checkIfCopyIsLended(int copyId) {
		
		boolean lendingExist = false;
	
		String verify = "SELECT * FROM copyLending cl ,lending l WHERE l.lendingReturnDate ISNULL AND l.lendingId = cl.lendingId AND cl.copyId = ?";
		
		try {

			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(verify);

			ps.setInt(1, copyId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				//if there is a record, the copy is lended
				lendingExist = true;
			}else {
				//if there is not a record, the copy is not lended
				lendingExist = false;
			}
			rs.close();
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
		return lendingExist;
	}//checkIfCopyIsLended()
	
}//class CopyDao
