package com.imatia.bookmanager.model.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.ZoneId;

import com.imatia.bookmanager.model.entities.Copy;
import com.imatia.bookmanager.model.entities.Lending;

public class LendingDao {

	ConnectionSQLite connectionSQLite = new ConnectionSQLite();

	public void addLending(Lending lending, Copy copy) {
		String queryLending = "INSERT INTO lending (userId, lendingDate, lendingDeadLine) " + "VALUES (?,?,?,?) ";
		String queryCopyLending = "INSERT INTO copyLending (copyId, lendingId) " + "Values(?,?) ";
		try {
			Connection con = connectionSQLite.getConnection();

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

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
