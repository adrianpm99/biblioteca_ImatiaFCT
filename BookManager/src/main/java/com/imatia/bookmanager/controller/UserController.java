package com.imatia.bookmanager.controller;

import com.imatia.bookmanager.model.data.UserDao;
import com.imatia.bookmanager.model.entities.User;

/**
 * class to implement the methods to connect views with data
 * 
 * @author Grupo2FCTImatia
 *
 */
public class UserController {

	UserDao ud = new UserDao();

	/**
	 * method to get a user filter by id
	 * 
	 * @param id
	 * @return user
	 */
	public User getUserById(int id) {

		User user = ud.getUserById(id);
		return user;
	}
	
	/**
	 * method to get a user filter by name and surname
	 * @param name
	 * @param surname
	 * @return user
	 */
	public User getUserByNameAndSurname(String name, String surname) {
		
		User user = ud.getUserByNameAndSurname(name, surname);
		
		return user;
	}

	/**
	 * method to add a user to database
	 * 
	 * @param user
	 */
	public void addUser(User user) {
		ud.addUser(user);
	}

	/**
	 * method to modify a user in database
	 * 
	 * @param user
	 */
	public void modifyUser(User user) {
		ud.modifyUser(user);

	}

	/**
	 * metho to delete a user in database
	 * 
	 * @param id
	 */
	public void deleteUser(int id) {
		ud.deleteUser(id);
	}

}
