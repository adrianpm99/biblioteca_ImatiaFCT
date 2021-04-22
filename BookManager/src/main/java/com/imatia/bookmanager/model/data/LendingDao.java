package com.imatia.bookmanager.model.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;

import com.imatia.bookmanager.model.entities.Copy;
import com.imatia.bookmanager.model.entities.Lending;

public class LendingDao {

	ConnectionSQLite connectionSQLite = new ConnectionSQLite();

	public void addLending(Lending lending, ArrayList<Integer> listIdCopy) {
		String queryGetCopy = "SELECT * FROM copy WHERE copyId = ?";
		String queryLending = "INSERT INTO lending (userId, lendingDate, lendingDeadLine) " + "VALUES (?,?,?,?) ";
		String queryCopyLending = "INSERT INTO copyLending (copyId, lendingId) " + "Values(?,?) ";
		String updateAvailable = "UPDATE copy SET copyAvailable = ? WHERE id = ?";

		try {
			Connection con = connectionSQLite.getConnection();
			for (int cont = 0; cont < listIdCopy.size(); cont++) {
				PreparedStatement psGetCopy = con.prepareStatement(queryGetCopy);

				psGetCopy.setInt(1, listIdCopy.get(cont));
				psGetCopy.execute();

				ResultSet rs = psGetCopy.getResultSet();
				rs.next();

				int bookId = rs.getInt("bookId");
				Copy copy = new Copy(listIdCopy.get(cont), bookId, false);

				PreparedStatement ps = con.prepareStatement(queryLending);
				ps.setInt(1, lending.getUserId());
				Date lendingDate = (Date) Date
						.from(lending.getLendingDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
				ps.setDate(2, lendingDate);
				Date deadLineDate = (Date) Date
						.from(lending.getLendingDeadLine().atStartOfDay(ZoneId.systemDefault()).toInstant());
				ps.setDate(3, deadLineDate);

				ps.execute();

				ps.close();

				PreparedStatement ps2 = con.prepareStatement(queryCopyLending);
				ps2.setInt(1, copy.getCopyId());
				ps2.setInt(2, lending.getLendingId());

				ps2.execute();
				ps2.close();

				PreparedStatement ps3 = con.prepareStatement(updateAvailable);
				ps3.setBoolean(1, false);
				ps3.setInt(2, copy.getCopyId());

				ps3.execute();
				ps3.close();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteLending(Lending lending, Copy copy) {
		String query = "DELETE FROM copyLending WHERE lendingId = ?";
		String updateAvailable = "UPDATE copy SET copyAvailable = ? WHERE id = ?";

		try {
			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, lending.getLendingId());
			ps.execute();
			PreparedStatement ps2 = con.prepareStatement(updateAvailable);
			ps2.setBoolean(1, true);
			ps2.setInt(2, copy.getCopyId());

			ps2.execute();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
