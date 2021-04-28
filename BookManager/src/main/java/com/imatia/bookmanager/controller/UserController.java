package com.imatia.bookmanager.controller;

import java.util.ArrayList;
import java.util.List;

import com.imatia.bookmanager.model.data.UserDao;
import com.imatia.bookmanager.model.entities.User;
import com.imatia.bookmanager.view.ui.SearchUserUi;

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
		if(user == null) {
			SearchUserUi.showSearchUserUi();
		}
		return user;
	}
	
	/**
	 * method to get a list of users filter by name and surname
	 * @param name
	 * @param surname
	 * @return userList
	 */
	public List<User> getUserByNameAndSurname(String name, String surname) {
		
		List<User> userList = new ArrayList<>();
		if(userList.isEmpty()) {
			System.out.println("No se ha encontrado ninún usuario con los datos facilitados");
			SearchUserUi.showSearchUserUi();
		}
		userList = ud.getUserByNameAndSurname(name, surname);
		
		return userList;
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
