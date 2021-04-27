package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.BookController;
import com.imatia.bookmanager.controller.LendingController;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.inputs.UtilityInputs;
import com.imatia.bookmanager.view.ui.SearchesUi;

/**
 * Options to show after Lendings UI, when user choses to delete a lending
 */

public class DeleteLendingMenu
{
	public static void showDeleteLendingMenu()
	{
		String id; //the Id of the copy which belongs to the lending
		
		LendingController lc = new LendingController();
		
		do
		{
			System.out.println("Introduzca el Id del ejemplar del prestamo para borrar:");
			id= InputUserData.checkUserInput("id", "Valor de Id incorrecto. Pruebe de nuevo (entero positivo).");
		}while(id.equals(""));
				
		boolean confirmationDelete= UtilityInputs.getConfirmation("borrar", "ejemplar del prestamo");
		
	}//showDeleteLendingMenu()
}//class DeleteLendingMenu