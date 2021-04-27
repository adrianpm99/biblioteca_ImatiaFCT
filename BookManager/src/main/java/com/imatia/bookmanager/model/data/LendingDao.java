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

public class LendingDao {
	ConnectionSQLite connectionSQLite = new ConnectionSQLite();

	public String addLending(Lending lending, ArrayList<Integer> listIdCopy) {

		String queryLendingCheck = "SELECT * FROM copy c, copyLending cl, lending l WHERE c.copyId = ? AND c.copyId = cl.copyId "
				+ "AND l.lendingId = cl.lendingId AND l.lendingReturndate is null";
		String queryGetUser = "SELECT * FROM user WHERE userId = ?";
		String error = "";

		try (Connection con = connectionSQLite.getConnection();
				PreparedStatement psGetUser = con.prepareStatement(queryGetUser);) {
			if (checkUser(lending, con)) {

				for (int cont = 0; cont < listIdCopy.size(); cont++) {
					if (checkCopy(lending, con, listIdCopy.get(cont))) {
						if (checkLending(lending, con, listIdCopy.get(cont))) {
							addLendingMethod(lending, con, listIdCopy.get(cont));
						} else {
							return error = "El ejemplar ya esta prestado";
						}
					} else {
						return error = "No existe la copia";
					}
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
	}

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
	}

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
	}

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
				rs.next();

				rs.close();
				psLendingCheck.close();

				return check = true;
			} else {
				return check = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}

	private void addLendingMethod(Lending lending, Connection con, int copyId) {
		String queryLending = "INSERT INTO lending (userId, lendingDate, lendingDeadLine,lendingReturnDate) "
				+ "VALUES (?,?,?,?) ";
		String queryCopyLending = "INSERT INTO copyLending (copyId, lendingId) " + "Values(?,?) ";
		// PreparedStatement ps = con.prepareStatement(queryLending);
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(queryLending, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, lending.getUserId());

			// esto daba error (java.lang.ClassCastException: java.util.Date cannot be cast
			// to java.sql.Date)

			// Date lendingDate = (Date) Date
			// .from(lending.getLendingDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
			Date lendingDate = Date.valueOf(lending.getLendingDate());
			ps.setDate(2, lendingDate);
			// Date deadLineDate = (Date) Date
			// .from(lending.getLendingDeadLine().atStartOfDay(ZoneId.systemDefault()).toInstant());
			Date lendingDeadLine = Date.valueOf(lending.getLendingDeadLine());
			ps.setDate(3, lendingDeadLine);

			ps.setDate(4, null);

			ps.execute();

			ResultSet rsId = ps.getGeneratedKeys();
			rsId.next();

			lending.setLendingId(rsId.getInt(1));

			ps.close();

			PreparedStatement ps2 = con.prepareStatement(queryCopyLending);
			ps2.setInt(1, copyId);

			ps2.setInt(2, lending.getLendingId());

			ps2.execute();
			ps2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	 * 
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

			lending = new Lending(lendingId, userId, lendingDate, lendingDeadLine, lendingReturnDate);

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
	}

	/**
	 * method to get a lending filter by UserId
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
				LocalDate lendingReturnDate = rs.getDate("lendingReturnDate").toLocalDate();

				lending = new Lending(lendingId, userId, lendingDate, lendingDeadLine, lendingReturnDate);
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
	}

	/**
	 * method to get a lending filter by UserId
	 * 
	 * @param userId
	 * @return lending
	 */
	public List<Lending> getLendingByDeadLine(LocalDate date) {

		Lending lending = new Lending();
		List<Lending> lendingList = new ArrayList<>();

		String query = "SELECT * FROM lending WHERE lendingDeadLine = ?";

		try {
			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setDate(1, Date.valueOf(date));
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {

				int lendingId = rs.getInt("lendingId");
				int userId = rs.getInt("userId");
				LocalDate lendingDate = rs.getDate("lendingDate").toLocalDate();
				LocalDate lendingDeadLine = rs.getDate("lendingDeadLine").toLocalDate();
				LocalDate lendingReturnDate = rs.getDate("lendingReturnDate").toLocalDate();

				lending = new Lending(lendingId, userId, lendingDate, lendingDeadLine, lendingReturnDate);
				lendingList.add(lending);
			}
			ps.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("No se ha encontrado ningun prestamo con la fecha de devolución facilitado");
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
	}

}
