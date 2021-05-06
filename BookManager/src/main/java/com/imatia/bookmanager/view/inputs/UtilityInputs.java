package com.imatia.bookmanager.view.inputs;

import java.util.Scanner;

/**
 * Class to implement the methods to confirm an action
 * 
 * @author Grupo2FCTImatia
 * 
 */

public class UtilityInputs {

	static Scanner sc = new Scanner(System.in);

	/**
	 * Method to confirm the delete or the modify of book valid aswell to confirm
	 * the delete of a lending
	 * 
	 * @param action
	 * @param object
	 * 
	 * @return boolean
	 */

	public static boolean getConfirmation(String action, String object) {

		Boolean confirmation = false;
		String request;
		
		System.out.println("¿Esta seguro de " + action + " el " + object + "?");
		System.out.print("Escriba  si/no para confirmar: ");
		
		do {
			
			request = sc.nextLine();
			
			if (request.equalsIgnoreCase("si")) {
				
				confirmation = true;
				
			} else if (request.equalsIgnoreCase("no")) {
				
				confirmation = false;
				
			} else {
				
				System.out.println("Opcion incorrecta. \nEscriba si para borrar el " + object
						+ "\nEscriba no para cancelar el borrado.");
				
			}
			
		} while (!request.equalsIgnoreCase("si") && !request.equalsIgnoreCase("no"));

		return confirmation;
		
	}//getConfirmation()
	
}//class UtilityInputs