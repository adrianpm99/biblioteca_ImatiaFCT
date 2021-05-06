package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.ReservationController;
import com.imatia.bookmanager.model.entities.Reservation;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.results.ReservationDetails;
import com.imatia.bookmanager.view.ui.SearchReservationUi;

/**
 * class to show the menu options of results by method of reservations
 * 
 * @author Grupo2FCTImatia
 *
 */

public class ReservationResultsByMethodMenu {

	public static void showReservationResultsByMethodMenuOptions() {

		String reservationId;
		String option;
		do {
			option = InputUserData.checkUserInput("option", "Opcion no valida. Pruebe de nuevo (entero positivo)");
			if (!option.equals("") && !option.equals("0") && !option.equals("1")) {
				System.out.println("Opcion no valida. Pruebe de nuevo (entero positivo)");
			}
		} while (!option.equals("0") && !option.equals("1"));

		switch (Integer.parseInt(option)) {
		case 0:
			SearchReservationUi.showSearchReservationUi();
			break;
		case 1:
			do {
				System.out.print("Introduzca el id de la reserva: ");
				reservationId = InputUserData.checkUserInput("id",
						"Valor de Id incorrecto. Pruebe de nuevo (entero positivo).");
			} while (reservationId.equals(""));

			Reservation reservation = new ReservationController().getReservationById(Integer.parseInt(reservationId));
			if(reservation == null) {
				System.out.println("No se ha econtrado ninguna reserva con el id facilitado");
				SearchReservationUi.showSearchReservationUi();
			}else {
				ReservationDetails.showReservationDetails(reservation);
			}
			break;
		}
		
	}// showUserResultsByMethodMenuOptions

}// ReservationResultsByMethodMenu
