package com.imatia.bookmanager.view.menus;

import java.time.LocalDate;
import java.util.Scanner;

import com.imatia.bookmanager.controller.LendingController;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.LendingsUi;

/**
 * Options to show after Lendings UI, when user choses to close a lending
 */

public class CloseLendingMenu
{	
	static LendingController lc= new LendingController();
	static Scanner sc = new Scanner(System.in);
	
	public static void showCloseLendingMenu()
	{
		String id; // the Id of the copy which belongs to the lending
		String lendingNotes; //Notes to add comments about the lending
		
		//first, select the id of the lending to be closed
		do {
			System.out.print("Introduzca el id del prestamo que desea cerrar: ");
			id = InputUserData.checkUserInput("id", "Valor de Id incorrecto. Pruebe de nuevo (entero positivo).");
		} while (id.equals(""));
		
		//second, add (if wanted) some annotations to the lending
		System.out.println("Añada comentarios sobre el prestamo\n(Pulse enter solamente para omitir)");
		lendingNotes= sc.nextLine();
		
		//finally, close the lending, adding the current date and comments
		lc.modifyLendingReturnDate(Integer.parseInt(id), LocalDate.now(), lendingNotes);
		
		LendingsUi.showLendingsUi();
	}// showDeleteLendingMenu()

	
	
	
	public static void showCloseLendingMenu(int id)
	{	
		System.out.println("Añada comentarios sobre el prestamo\n(Pulse enter solamente para omitir)");
		String lendingNotes= sc.nextLine();
		lc.modifyLendingReturnDate(id, LocalDate.now(), lendingNotes);
		LendingsUi.showLendingsUi();
	}// showCloseLendingMenu()
	
}// class DeleteLendingMenu