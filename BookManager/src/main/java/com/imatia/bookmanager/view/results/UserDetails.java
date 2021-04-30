package com.imatia.bookmanager.view.results;

import com.imatia.bookmanager.model.entities.User;
import com.imatia.bookmanager.view.menus.UserDetailsMenu;
/*
 * this is the class to show the user details
 */
public class UserDetails {
	/**
	 * method to print the User details
	 * @param u
	 */
	public static void showUserDetails(User u) {
		
		System.out.println(
				
				"\n***********************\r\n" + 
				"** DATOS DEL USUARIO **\r\n" + 
				"***********************\r\n" + 
				"---------------------------------------------------------\r\n" + 
				"|| 1- Editar Usuario || 0- Volver al menu de busquedas ||\r\n" + 
				"---------------------------------------------------------\r\n" + 
				"|| Nombre: "+u.getUserName()+"\r\n" + 
				"||	\r\n" + 
				"|| Apellidos: "+u.getUserSurname()+"\r\n" + 
				"||	\r\n" + 
				"==========================================================\r\n");
		//show the users details menu options
		UserDetailsMenu.showUserDetailsMenuOptions(u.getUserId());
		
	}//showUserDetails

}
