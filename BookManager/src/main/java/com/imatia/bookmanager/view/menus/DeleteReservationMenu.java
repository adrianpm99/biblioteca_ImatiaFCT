package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.ReservationController;
import com.imatia.bookmanager.model.entities.Reservation;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.inputs.UtilityInputs;
import com.imatia.bookmanager.view.ui.ReservationUi;
import com.imatia.bookmanager.view.ui.StartMenuUI;

public class DeleteReservationMenu
{
	public static void showDeleteReservationMenu()
	{
		ReservationController rc = new ReservationController();
		String reservationId;
		
		do 
		{
			reservationId = InputUserData.checkUserInput("id", "Inserte un id valido (entero positivo)");
			if(reservationId.equals("")) System.out.println("Opcion no valida. Pruebe de nuevo (entero positivo)");
		}while(reservationId.equals(""));
		
		//confirm to this reservationId exists
		Reservation reservation =rc.getReservationById(Integer.parseInt(reservationId));
		if(reservation == null) {
			System.out.println("No existe ninguna reserva con el id facilitado");
			ReservationUi.showReservationUi();
		}
		boolean confirmationDelete= UtilityInputs.getConfirmation("cancelar","reserva");
		// get the confirmation of the delete
		if (confirmationDelete == true) rc.deleteReservation(Integer.parseInt(reservationId));
		StartMenuUI.showStartMenuUi();
	}//showDeleteBookMenu()
}//class DeleteReservationMenu