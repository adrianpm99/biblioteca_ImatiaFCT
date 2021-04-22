package com.imatia.bookmanager.model.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.ZoneId;

import com.imatia.bookmanager.model.entities.Lending;

public class LendingDao {

	ConnectionSQLite connectionSQLite = new ConnectionSQLite();

	public void addLending(Lending lending) {
		String query = "INSERT INTO book (idCopy, idUser, lendingDate, lendingDeadLine) " + "VALUES (?,?,?,?) ";

		try {
			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, lending.getIdCopy());
			ps.setInt(2, lending.getIdUser());
			Date lendingDate = (Date) Date
					.from(lending.getLendingDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
			ps.setDate(3, lendingDate);
			Date deadLineDate = (Date) Date
					.from(lending.getLendingDeadLine().atStartOfDay(ZoneId.systemDefault()).toInstant());
			ps.setDate(4, deadLineDate);

			ps.execute();

			ps.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;

	}

}
