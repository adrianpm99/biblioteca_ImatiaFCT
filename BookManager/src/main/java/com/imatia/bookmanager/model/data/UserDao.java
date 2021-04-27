package com.imatia.bookmanager.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.imatia.bookmanager.model.entities.User;
import com.imatia.bookmanager.view.ui.SearchUserUi;

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

			System.out.println("El usuario se ha añadido correctamente");
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
			System.out.println("No se ha encontrado ningún usuario con el id facilitado");
			// e.printStackTrace();
			SearchUserUi.showSearchUserUi();
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
			
			System.out.println("Los datos del usuario se han actualizado correctamente");

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

			System.out.println("Usuario con id " + id + " borrado");

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
	public List<User> getUserByNameAndSurname(String name, String surname) {

		String query = "SELECT * FROM user WHERE userName LIKE ? OR userSurname LIKE ? ";
		List<User> userList = new ArrayList<>();
		User user = new User();

		try {
			Connection con = connectionSQLite.getConnection();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, name );
			ps.setString(2, surname);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while(rs.next()) {

			int userId = rs.getInt("userId");
			String userName = rs.getString("userName");
			String userSurname = rs.getString("userSurname");

			user = new User(userId, userName, userSurname);
			userList.add(user);
		}
			ps.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("No se ha encontrado ningun usuario con los datos facilitados");
			// e.printStackTrace();
			SearchUserUi.showSearchUserUi();
		}

		return userList;
	}

}
