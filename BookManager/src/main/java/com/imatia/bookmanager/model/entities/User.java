package com.imatia.bookmanager.model.entities;


/**
 * 
 * class that defines the User object with its attributes, 
 * constructors and getter and setter methods
 *
 */

	
	public class User {

		
		int userId;
		String userName;
		String userSurname;
		
		public User() {
			
		}

		public User(int userId, String userName, String userSurname) {
			
			this.userId = userId;
			this.userName = userName;
			this.userSurname = userSurname;
		}
		
		
		public User(String userName, String userSurname) {
			super();
			this.userName = userName;
			this.userSurname = userSurname;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getUserSurname() {
			return userSurname;
		}

		public void setUserSurname(String userSurname) {
			this.userSurname = userSurname;
		}

		
		

		
		
	}
