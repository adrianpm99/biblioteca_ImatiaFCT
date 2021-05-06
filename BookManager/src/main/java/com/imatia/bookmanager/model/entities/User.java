package com.imatia.bookmanager.model.entities;

/**
 * Class that defines the User object with its attributes, constructors and
 * getter and setter methods
 *
 * @author Grupo2FCTImatia
 */

public class User {

	int userId;
	String userName;
	String userSurname;

	public User() {
	}// User()

	/**
	 * Called by getUserBy..., gets an existing User in the DB
	 */
	public User(int userId, String userName, String userSurname) {

		this.userId = userId;
		this.userName = userName;
		this.userSurname = userSurname;

	}// User()

	/**
	 * Called by the "Add User" option in the UserManagementMenu, creates a new user and gives them an ID
	 */
	
	public User(String userName, String userSurname) {

		super();
		this.userName = userName;
		this.userSurname = userSurname;

	}// User()

	public int getUserId() {
		return userId;
	}// getUserId()

	public void setUserId(int userId) {
		this.userId = userId;
	}// setUserId()

	public String getUserName() {
		return userName;
	}// getUserName()

	public void setUserName(String userName) {
		this.userName = userName;
	}// setUserName()

	public String getUserSurname() {
		return userSurname;
	}// getUserSurname()

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}// setUserSurname()

}// class User
