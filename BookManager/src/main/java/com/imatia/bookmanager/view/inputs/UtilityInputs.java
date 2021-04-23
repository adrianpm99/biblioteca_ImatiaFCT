package com.imatia.bookmanager.view.inputs;

import java.util.Scanner;

public class UtilityInputs
{	
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * method to confirm the delete or the modify of book
	 * valid aswell to confirm the delete of a lending
	 * @param action
	 * @return boolean
	 */
	public static boolean getConfirmation(String action, String object) {
		
		Boolean confirmation  = false;
		sc = new Scanner(System.in);
		
		System.out.println("¿Esta seguro de "+action+" el "+object+"?");
		System.out.print("Escriba  Si/No para confirmar: ");
		
		String request = sc.nextLine();
		
		if(request.equalsIgnoreCase("si")) {
			confirmation = true;
		}
		if(request.equalsIgnoreCase("no")) {
			confirmation = false;
		}
		
		return confirmation;
	}//getConfirmation()
}//classUtilityInputs