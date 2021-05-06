package com.imatia.bookmanager.view.menus;

import java.time.LocalDate;
import java.util.Scanner;

import com.imatia.bookmanager.controller.LendingController;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.LendingsUi;

/**
 * Class to show after Lendings UI, when user choses to close a lending
 * 
 * @author Grupo2FCTImatia
 */

public class CloseLendingMenu {

	static LendingController lc = new LendingController();
	static Scanner sc = new Scanner(System.in);

	/**
	 * Close a Lending without the LendingId
	 */

	public static void showCloseLendingMenu() {

		String id; // the Id of the copy which belongs to the lending
		String lendingNotes; // Notes to add comments about the lending

		// First, select the id of the lending to be closed
		do {
			System.out.print("Introduzca el id del prestamo que desea cerrar: ");
			id = InputUserData.checkUserInput("id", "Valor de Id incorrecto. Pruebe de nuevo (entero positivo).");
		} while (id.equals(""));

		// second, add (if wanted) some annotations to the lending
		System.out.println("Añada comentarios sobre el prestamo\n(Pulse enter solamente para omitir)");

		// third, ask for the lending notes
		lendingNotes = InputUserData.checkUserInput("lendingNotes",
				"Valor de comentarios incorrecto. Pruebe de nuevo (Máximo 200 caracteres)");

		// finally, close the lending, adding the current date and comments
		lc.modifyLendingReturnDate(Integer.parseInt(id), LocalDate.now(), lendingNotes);

		// Go to Lending Ui
		LendingsUi.showLendingsUi();

	}// showDeleteLendingMenu()

	/**
	 * Close a Lending with the LendingId
	 * 
	 * @param id lendingId
	 */

	public static void showCloseLendingMenu(int id) {

		System.out.println("Añada comentarios sobre el prestamo\n(Pulse enter solamente para omitir)");

		// Ask for the lending notes
		String lendingNotes = InputUserData.checkUserInput("lendingNotes",
				"Valor de comentarios incorrecto. Pruebe de nuevo (Máximo 200 caracteres)");

		// close the lending, adding the current date and comments
		lc.modifyLendingReturnDate(id, LocalDate.now(), lendingNotes);

		// Go to LendingsUi
		LendingsUi.showLendingsUi();

	}// showCloseLendingMenu()

}// class DeleteLendingMenu