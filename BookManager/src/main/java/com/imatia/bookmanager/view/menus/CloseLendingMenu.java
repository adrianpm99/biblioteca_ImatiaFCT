package com.imatia.bookmanager.view.menus;

import java.time.LocalDate;

import com.imatia.bookmanager.controller.LendingController;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.LendingsUi;

/**
 * Options to show after Lendings UI, when user chose to close a lending
 */

public class CloseLendingMenu {
	public static void showCloseLendingMenu() {
		String id; // the Id of the copy which belongs to the lending

		LendingController lc = new LendingController();

		do {
			System.out.print("Introduzca el id del prestamo que desea cerrar: ");
			id = InputUserData.checkUserInput("id", "Valor de Id incorrecto. Pruebe de nuevo (entero positivo).");
		} while (id.equals(""));

		lc.modifyLendingReturnDate(Integer.parseInt(id), LocalDate.now());

		LendingsUi.showLendingsUi();

	}// showDeleteLendingMenu()

	public static void showCloseLendingMenu(int id) {

		LendingController lc = new LendingController();

		lc.modifyLendingReturnDate(id, LocalDate.now());

		LendingsUi.showLendingsUi();

	}// showDeleteLendingMenu()
}// class DeleteLendingMenu