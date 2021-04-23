package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.BookController;
import com.imatia.bookmanager.controller.LendingController;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.inputs.UtilityInputs;
import com.imatia.bookmanager.view.ui.SearchesUi;

public class DeleteLendingMenu
{
	
	public static void showDeleteLendingMenu()
	{
		int id; //the Id of the copy which belongs to the lending
		
		LendingController lc = new LendingController();
		
		System.out.println("Introduzca el Id del ejemplar del prestamo para borrar");
		id= Integer.parseInt(InputUserData.checkUserInput("id"));
		
		boolean confirmationDelete= UtilityInputs.getConfirmation("borrar", "ejemplar del prestamo");
		
		// get the confirmation of the delete
		//AHORA LLAMARÍA AL MÉTODO DEL LENDINGCONTROLLER PARA BORRAR EL EJEMPLAR
		
		//if (confirmationDelete == true) lc.METODO_PARA_BORRAR_EJEMPLAR;
		//else SearchesUi.showSearchesUi();
	}//showDeleteLendingMenu()
}//class DeleteLendingMenu