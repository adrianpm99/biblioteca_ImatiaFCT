package com.imatia.bookmanager.view.results;

import java.util.List;

import com.imatia.bookmanager.model.entities.User;

public class UserRenderers {
	
	public static void renderListUsers(List<User> userList)
	{
		for(User u: userList)
		{
			System.out.println("===========================================================================================\n");
			System.out.println("Id: "+u.getUserId()+
								"\t|| Nombre: "+u.getUserName()+ 
								"\t|| Apellidos: "+u.getUserSurname()+"\n");
		}
	}

}
