package com.imatia.bookmanager.model.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.imatia.bookmanager.model.entities.Copy;
import com.imatia.bookmanager.model.entities.Lending;

public class LendingDao {

	ConnectionSQLite connectionSQLite = new ConnectionSQLite();

	public void addLending(Lending lending, ArrayList<Integer> listIdCopy) {
		String queryGetCopy = "SELECT * FROM copy WHERE copyId = ?";
		String queryLending = "INSERT INTO lending (userId, lendingDate, lendingDeadLine,lendingReturnDate) " + "VALUES (?,?,?,?) ";
		String queryCopyLending = "INSERT INTO copyLending (copyId, lendingId) " + "Values(?,?) ";

		try {
			Connection con = connectionSQLite.getConnection();
			for (int cont = 0; cont < listIdCopy.size(); cont++) {
				PreparedStatement psGetCopy = con.prepareStatement(queryGetCopy);

				psGetCopy.setInt(1, listIdCopy.get(cont));
				psGetCopy.execute();

				ResultSet rs = psGetCopy.getResultSet();
				rs.next();

				int bookId = rs.getInt("bookId");
				Copy copy = new Copy(listIdCopy.get(cont), bookId);

				PreparedStatement ps = con.prepareStatement(queryLending);
				ps.setInt(1, lending.getUserId());

				//esto daba error  (java.lang.ClassCastException: java.util.Date cannot be cast to java.sql.Date)
			
			//	Date lendingDate = (Date) Date
			// 			.from(lending.getLendingDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
				Date lendingDate = Date.valueOf(lending.getLendingDate());
				ps.setDate(2, lendingDate);
			//	Date deadLineDate = (Date) Date
			//			.from(lending.getLendingDeadLine().atStartOfDay(ZoneId.systemDefault()).toInstant());
				Date lendingDeadLine = Date.valueOf(lending.getLendingDeadLine());
				ps.setDate(3, lendingDeadLine);
				
			
				ps.setDate(4,lendingDeadLine);

				ps.execute();

				ps.close();

				PreparedStatement ps2 = con.prepareStatement(queryCopyLending);
				ps2.setInt(1, copy.getCopyId());
				
				//aquí hay que averiguar el codigo autogenerado para lendingId 
				//cuando se hizo la inserción en la tabla lending
				// ahora está poniendo siempre 1
				ps2.setInt(2, lending.getLendingId());

				ps2.execute();
				ps2.close();

				
			}

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

	public void deleteLending(Lending lending, Copy copy) {
		String query = "DELETE FROM copyLending WHERE lendingId = ?";

		try {
			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, lending.getLendingId());
			ps.execute();
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
	 * method to modify the Lending return date
	 * 
	 * @param lending
	 * @param dateReturnDate
	 */
	public void modifyLendingReturndDate(Lending lending, LocalDate dateReturnDate) {

		String query = "UPDATE lending SET lendingReturnDate =? WHERE lendingId= ?";

		try {
			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setDate(1, Date.valueOf(dateReturnDate));
			ps.setInt(2, lending.getLendingId());

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
	 * method to get a lending filter by id
	 * @param id
	 * @return lending
	 */
	public Lending getLendingById(int id) {
		
		Lending lending = new Lending();

		String query = "SELECT * FROM lending WHERE lendingId = ?";

		try {
			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, id);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			rs.next();

			int lendingId = rs.getInt("lendingId");
			int userId = rs.getInt("userId");
			LocalDate lendingDate = rs.getDate("lendingDate").toLocalDate();
			LocalDate lendingDeadLine = rs.getDate("lendingDeadLine").toLocalDate();
			LocalDate lendingReturnDate = rs.getDate("lendingReturnDate").toLocalDate();

			lending= new Lending(lendingId, userId, lendingDate, lendingDeadLine, lendingReturnDate);
			
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

		return lending;
	}
	

}
