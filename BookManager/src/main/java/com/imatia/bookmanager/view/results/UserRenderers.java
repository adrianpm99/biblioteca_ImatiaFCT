package com.imatia.bookmanager.view.results;

import java.util.List;

import com.imatia.bookmanager.model.entities.User;

/*
 * this is the class to render the results of user search
 */
public class UserRenderers {
	/**
	 * method to print a list of users
	 * @param userList
	 */
	public static void renderListUsers(List<User> userList)
	{
		for(User u: userList)
		{
			System.out.println("===========================================================================================\n");
			System.out.println("Id: "+u.getUserId()+
								"\t|| Nombre: "+u.getUserName()+ 
								"\t|| Apellidos: "+u.getUserSurname()+"\n");
		}
	}//renderListUsers

}
