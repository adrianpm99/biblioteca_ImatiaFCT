package com.imatia.bookmanager.model.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.imatia.bookmanager.model.entities.Copy;
import com.imatia.bookmanager.model.entities.Lending;
import com.imatia.bookmanager.view.ui.SearchLendingUi;
import com.imatia.bookmanager.model.entities.Reservation;

/**
 * class to map the table lending to object lending
 * 
 * @author Grupo2FCTImatia
 * 
 */

public class LendingDao {
	
	//First we open a connection to the database
	
	ConnectionSQLite connectionSQLite = new ConnectionSQLite();
	
	/**
	 * method to add a lending
	 * 
	 * @param lending
	 * @param listIdCopy
	 * @return
	 */

	//addLending method does not currently call addLendingNotes, method modifyLendingReturnDate does
	public String addLending(Lending lending, ArrayList<Integer> listIdCopy) {

		String queryGetUser = "SELECT * FROM user WHERE userId = ?";
		String error = "";
		int lendingId = 0;
		
		try (Connection con = connectionSQLite.getConnection();
				//this Prepared Statement selects everything given a certain userId
				PreparedStatement psGetUser = con.prepareStatement(queryGetUser);) {
			
			//checks if the user exists
			if (checkUser(lending, con)) {
				
				Integer duplicatedBook = checkDuplicateBookLending(listIdCopy, con);
				
				//checks if a book that has been lent is duplicate
				if (duplicatedBook == null) {
					for (int cont = 0; cont < listIdCopy.size(); cont++) {
						//checks if a copy is existing
						if (checkCopy(lending, con, listIdCopy.get(cont))) {
							//checks if a copy is lent
							if (checkLending(lending, con, listIdCopy.get(cont))) {
								//el ejemplar existe (checkCopy) y no está prestado (checkLending)
								lendingId = addLendingMethod(lending, con, listIdCopy.get(cont), cont, lendingId);
							} else {
								//el ejemplar existe pero está prestado
								return error = "El ejemplar con id " + listIdCopy.get(cont) + " ya esta prestado";
							}
						} else {
							//el ejemplar no existe
							return error = "No existe el ejemplar";
						}
					}
				} else {
					return error = "Error en el ejemplar con id " + duplicatedBook + ", dos ejemplares del mismo libro";
				}
			} else {
				return error = "No existe el usuario";
			}
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
		return error;
	}//addLending

	/**
	 * method to check if a copy is doubled (private to addLending)
	 */
	
	private Integer checkDuplicateBookLending(ArrayList<Integer> listIdCopy, Connection con) { 
		//Returns duplicatedBook = null if not duplicated
		
		Integer duplicatedBook = null;
		String queryGetCopy = "SELECT * FROM copy WHERE copyId = ?";
		ArrayList<Integer> listIdBook = new ArrayList<Integer>();
		
		try {
			for (int cont = 0; cont < listIdCopy.size(); cont++) {
				PreparedStatement psGetCopy = con.prepareStatement(queryGetCopy);
				
				psGetCopy.setInt(1, listIdCopy.get(cont));
				psGetCopy.execute();

				ResultSet rs = psGetCopy.getResultSet();
				rs.next();

				int bookId = rs.getInt("bookId");
				listIdBook.add(bookId);
				for (int cont2 = 0; cont2 < listIdBook.size(); cont2++) {
					if (cont2 != cont) {
						if(bookId == listIdBook.get(cont2)) {
							duplicatedBook = listIdCopy.get(cont);
							//checkDuplicated = false;
							//System.out.println("Error en el ejemplar con id " + listIdCopy.get(cont)");
							break;
						}
					}
				}

				if(duplicatedBook != null) {
					break;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return duplicatedBook;

	}//checkDuplicateBookLending
	
	/**
	 * method to check if a user exists (private to addLending)
	 */

	private boolean checkUser(Lending lending, Connection con) {
		String queryGetUser = "SELECT * FROM user WHERE userId = ?";
		boolean check = false;
		try {
			PreparedStatement psGetUser = con.prepareStatement(queryGetUser);
			
			psGetUser.setInt(1, lending.getUserId());
			psGetUser.execute();

			ResultSet rsUser = psGetUser.getResultSet();

			if (rsUser.next()) {
				psGetUser.close();
				rsUser.close();
				return check = true;
			} else {
				return check = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}//checkUser

	/**
	 * method to check if a copy exists (private to addLending)
	 */
	
	private boolean checkCopy(Lending lending, Connection con, int idCopy) {
		String queryGetCopy = "SELECT * FROM copy WHERE copyId = ?";
		boolean check = false;
		try {
			PreparedStatement psGetCopy = con.prepareStatement(queryGetCopy);

			psGetCopy.setInt(1, idCopy);
			psGetCopy.execute();
			ResultSet rs = psGetCopy.getResultSet();
			if (rs.next()) { // Compruebo existecia de la copia
				rs.close();
				psGetCopy.close();

				return check = true;
			} else {
				return check = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}//checkCopy

	/**
	 * method to check if an existing copy is lent (private to addLending)
	 */
	
	private boolean checkLending(Lending lending, Connection con, int copyId) {
		String queryLendingCheck = "SELECT * FROM copy c, copyLending cl, lending l WHERE c.copyId = ? AND c.copyId = cl.copyId "
				+ "AND l.lendingId = cl.lendingId AND l.lendingReturndate is null";
		boolean check = true;
		PreparedStatement psLendingCheck;
		
		try {
			psLendingCheck = con.prepareStatement(queryLendingCheck);
			
			psLendingCheck.setInt(1, copyId);
			psLendingCheck.execute();
			
			ResultSet rs = psLendingCheck.getResultSet();
			if (rs.next()) {

				rs.close();
				psLendingCheck.close();

				return check = false;
			} else {
				return check = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}//checkLending

	/**
	 * method to insert a lending of a copy into the lending table
	 */
	
	private int addLendingMethod(Lending lending, Connection con, int copyId, int cont, int lendingId) {
		String queryLending = "INSERT INTO lending (userId, lendingDate, lendingDeadLine,lendingReturnDate) "
				+ "VALUES (?,?,?,?) ";

		try {
			if (cont == 0) {
				PreparedStatement ps = con.prepareStatement(queryLending, Statement.RETURN_GENERATED_KEYS);
				
				ps.setInt(1, lending.getUserId());
				Date lendingDate = Date.valueOf(lending.getLendingDate());
				ps.setDate(2, lendingDate);
				Date lendingDeadLine = Date.valueOf(lending.getLendingDeadLine());
				ps.setDate(3, lendingDeadLine);
				ps.setDate(4, null);

				ps.execute();

				lendingId = addCopyLendingMethod(ps, lending, con, cont, copyId, lendingId);

				return lendingId;
			} else {
				addCopyLendingMethod(null, lending, con, cont, copyId, lendingId);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lendingId;
	}//addLendingMethod

	/**
	 * method to insert the lending of a copy into the copyLending table, called by addLendingMethod
	 */
	
	public int addCopyLendingMethod(PreparedStatement ps, Lending lending, Connection con, int cont, int copyId,
			int lendingId) {
		
		String queryCopyLending = "INSERT INTO copyLending (copyId, lendingId) " + "Values(?,?) ";
		ResultSet rsId;
		
		try {
			if (cont == 0) {
				rsId = ps.getGeneratedKeys();
				rsId.next();

				lending.setLendingId(rsId.getInt(1));
				ps.close();

				PreparedStatement ps2 = con.prepareStatement(queryCopyLending);
				
				ps2.setInt(1, copyId);
				ps2.setInt(2, lending.getLendingId());
				ps2.execute();
				ps2.close();
				
				lendingId = lending.getLendingId();
				
				return lending.getLendingId();
			} else {
				PreparedStatement ps2 = con.prepareStatement(queryCopyLending);
				
				ps2.setInt(1, copyId);
				ps2.setInt(2, lendingId);
				ps2.execute();
				ps2.close();
				
				return lendingId;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lendingId;
	}//addCopyLendingMethod
	
	/**
	 * method to delete a lending given its id
	 */

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
		} finally {
			try {
				connectionSQLite.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}//deleteLending

	/**
	 * method to modify the Lending return date given its id
	 */
	
	public void modifyLendingReturnDate(int id, LocalDate dateReturnDate) {

		String query = "UPDATE lending SET lendingReturnDate =? WHERE lendingId= ?";

		try {
			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setDate(1, Date.valueOf(dateReturnDate));
			ps.setInt(2, id);

			System.out.println("Fecha de devolucion: " + dateReturnDate);

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
	}//modifyLendingReturnDate
	
	/**
	 * Method to add notes about an existing lending into the database
	 * @param lendingId, lendingNotes
	 */
	
	public void addLendingNotes(int lendingId, String lendingNotes)
	{
		String query = "UPDATE lending SET lendingNotes =? WHERE lendingId= ?";
		try(Connection con = connectionSQLite.getConnection(); PreparedStatement ps = con.prepareStatement(query))
		{
			ps.setString(1, lendingNotes);
			ps.setInt(2, lendingId);
			ps.executeUpdate();
		}
		catch (ClassNotFoundException e) {e.printStackTrace();} 
		catch (SQLException e) {e.printStackTrace();}
		finally
		{
			try {connectionSQLite.closeConnection();}
			catch (SQLException e) {e.printStackTrace();}
		}
	}//addLendingNotes()
	
	/**
	 * method to get a lending filtered by its id
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
			String lendingNotes = rs.getString("lendingNotes");

			if (rs.getDate("lendingReturnDate") != null) {

				LocalDate lendingReturnDate = rs.getDate("lendingReturnDate").toLocalDate();
				lending = new Lending(lendingId, userId, lendingDate, lendingDeadLine, lendingReturnDate, lendingNotes);

			} else {

				lending = new Lending(lendingId, userId, lendingDate, lendingDeadLine, lendingNotes);
			}
			ps.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("No se ha encontrado ningun prestamo con el id facilitado");
			// e.printStackTrace();
			SearchLendingUi.showSearchLendingUi();
		} finally {
			try {
				connectionSQLite.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return lending;
	}//getLendingById

	/**
	 * method to get a lending filtered by UserId
	 * 
	 * @param userId
	 * @return lending
	 */
	
	public List<Lending> getLendingByUserId(int id) {

		Lending lending = new Lending();
		List<Lending> lendingList = new ArrayList<>();

		String query = "SELECT * FROM lending WHERE UserId = ?";

		try {
			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, id);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {

				int lendingId = rs.getInt("lendingId");
				int userId = rs.getInt("userId");
				LocalDate lendingDate = rs.getDate("lendingDate").toLocalDate();
				LocalDate lendingDeadLine = rs.getDate("lendingDeadLine").toLocalDate();
				String lendingNotes = rs.getString("lendingNotes");

				if (rs.getDate("lendingReturnDate") != null) {

					LocalDate lendingReturnDate = rs.getDate("lendingReturnDate").toLocalDate();
					lending = new Lending(lendingId, userId, lendingDate, lendingDeadLine, lendingReturnDate, lendingNotes);

				} else {

					lending = new Lending(lendingId, userId, lendingDate, lendingDeadLine, lendingNotes);
				}
				lendingList.add(lending);
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
		}

		return lendingList;
	}//getLendingByUserId

	/**
	 * method to get a lending filter by its deadline (both first and second dates)
	 */
	
	public List<Lending> getLendingByDeadLine(String firstDate, String secondDate) {

		Lending lending = new Lending();
		List<Lending> lendingList = new ArrayList<>();

		String query = "SELECT * FROM lending WHERE lendingDeadLine BETWEEN ? AND ?";

		try {
			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setDate(1, Date.valueOf(firstDate));
			ps.setDate(2, Date.valueOf(secondDate));

			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {

				int lendingId = rs.getInt("lendingId");
				int userId = rs.getInt("userId");
				LocalDate lendingDate = rs.getDate("lendingDate").toLocalDate();
				LocalDate lendingDeadLine = rs.getDate("lendingDeadLine").toLocalDate();
				String lendingNotes = rs.getString("lendingNotes");

				if (rs.getDate("lendingReturnDate") != null) {

					LocalDate lendingReturnDate = rs.getDate("lendingReturnDate").toLocalDate();
					lending = new Lending(lendingId, userId, lendingDate, lendingDeadLine, lendingReturnDate, lendingNotes);

				} else {

					lending = new Lending(lendingId, userId, lendingDate, lendingDeadLine, lendingNotes);
				}
				lendingList.add(lending);
			}
			ps.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("La consulta no ha devuelto ningún resultado");
			// e.printStackTrace();
			SearchLendingUi.showSearchLendingUi();
		} finally {
			try {
				connectionSQLite.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return lendingList;
	}//getLendingByDeadline

	/**
	 * returns a List of reservation object with user and book information, be there or not
	 */
	
	public ArrayList<Reservation> checkIfReservatedBook(int id) { // id (lendingId)

		Reservation reservation = new Reservation();
		ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
		// reservationList = null;

		String query = "SELECT  r.reservationId, r.bookId, r.userId" + " FROM copyLending cl,copy c, reservation r"
				+ " WHERE lendingId = ?" + " AND c.copyId = cl.copyId" + " AND r.bookId = c.bookId";

		try {
			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, id);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) { // reservationList

				int reservationId = rs.getInt("reservationId");
				int bookId = rs.getInt("bookId");
				int userId = rs.getInt("userId");

				reservation = new Reservation(reservationId, bookId, userId);
				reservationList.add(reservation);
			}
			ps.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("No se ha encontrado ningun prestamo con el id facilitado");
			// e.printStackTrace();
			SearchLendingUi.showSearchLendingUi();
		} finally {
			try {
				connectionSQLite.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return reservationList;
	}//checkIfReservationBook
	
}//class LendingDao
