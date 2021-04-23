package com.imatia.bookmanager.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.imatia.bookmanager.model.entities.User;

/**
 * class to map the table user to object user
 * 
 * @author GrupoFCTImatia
 *
 */
public class UserDao {

	ConnectionSQLite connectionSQLite = new ConnectionSQLite();

	/**
	 * method to add a user to database
	 * 
	 * @param user
	 */
	public void addUser(User user) {

		String query = "INSERT INTO user (userName, userSurname) VALUES (?,?)";

		try {
			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserSurname());
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
	 * method to get a user filter by id
	 * 
	 * @param id
	 * @return user
	 */
	public User getUserById(int id) {

		User user = new User();

		String query = "SELECT * FROM user WHERE userId = ?";

		try {
			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, id);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			rs.next();

			int userId = rs.getInt("userId");
			String userName = rs.getString("userName");
			String userSurname = rs.getString("userSurname");

			user = new User(userId, userName, userSurname);

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

		return user;

	}

	/**
	 * method to modify a user
	 * 
	 * @param user
	 */
	public void modifyUser(User user) {

		String query = "UPDATE user SET userName= ?, userSurname = ? WHERE userId= ?";

		try {
			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserSurname());
			ps.setInt(3, user.getUserId());

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
	 * method to delete a user
	 * 
	 * @param id
	 */
	public void deleteUser(int id) {

		String query = "DELETE FROM user WHERE userId = ?";

		try {
			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, id);
			ps.execute();

			System.out.println("Usuario con id: " + id + " borrado");

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
	 * method to get a user filter by name and surname
	 * 
	 * @param name
	 * @param surname
	 * @return user
	 */
	public User getUserByNameAndSurname(String name, String surname) {

		String query = "SELECT * FROM user WHERE userName = ? AND userSurname=? ";
		User user = new User();

		try {
			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, name);
			ps.setString(2, surname);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			rs.next();

			int userId = rs.getInt("userId");
			String userName = rs.getString("userName");
			String userSurname = rs.getString("userSurname");

			user = new User(userId, userName, userSurname);

			ps.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

}
