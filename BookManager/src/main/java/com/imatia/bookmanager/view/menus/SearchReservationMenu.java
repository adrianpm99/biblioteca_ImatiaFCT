package com.imatia.bookmanager.view.menus;

import java.util.ArrayList;
import java.util.List;

import com.imatia.bookmanager.controller.ReservationController;
import com.imatia.bookmanager.model.entities.Reservation;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.results.ReservationRenderers;
import com.imatia.bookmanager.view.ui.ReservationResultsByMethodUi;
import com.imatia.bookmanager.view.ui.ReservationUi;
import com.imatia.bookmanager.view.ui.SearchReservationUi;

/**
 * class to show the search reservation menu options
 * 
 * @author Grupo2FCTImatia
 *
 */

public class SearchReservationMenu {
	
	public static void showSeachReservationMenuOptions() {
		
		ReservationController rc= new ReservationController();
		String option;
		String filter;
		List<Reservation> reservationList = new ArrayList<>();
		//Option
		do {
			option = InputUserData.checkUserInput("option", "Opcion no valida. Pruebe de nuevo (entero positivo)");
			if(!option.equals("") && !option.equals("0") && !option.equals("1") && !option.equals("2"))
			{
				System.out.println("Opcion no valida. Pruebe de nuevo (entero positivo)");
			}
		} while (!option.equals("0") && !option.equals("1") && !option.equals("2"));
		
		switch (Integer.parseInt(option))
		{
		case 0:
			//Return to the SearchReservationUi
			ReservationUi.showReservationUi();
			break;		
		case 1:
			do {
				System.out.print("Introduzca el id del libro: ");
				filter = InputUserData.checkUserInput("id", "Pruebe de nuevo(entero positivo)");
			} while (filter.equals(""));
			reservationList = rc.getReservationsByIdBook(Integer.parseInt(filter));
			if(reservationList.isEmpty()) {
				System.out.println("Este libro no tiene ninguna reserva");
				SearchReservationUi.showSearchReservationUi();
			}else {
				//show the resultsUI by method
				ReservationResultsByMethodUi.showReservationResultsUi("LIBRO");
				//render the reservations
				ReservationRenderers.renderReservationsList(reservationList);
				//show results by method
				ReservationResultsByMethodMenu.showReservationResultsByMethodMenuOptions();
			}
			break;
			
		case 2:
			do {
				System.out.print("Introduzca el id del usuario: ");
				filter = InputUserData.checkUserInput("id", "Pruebe de nuevo(entero positivo)");
			} while (filter.equals(""));
			
			reservationList = rc.getReservationsByIdUser(Integer.parseInt(filter));
			
			if(reservationList.isEmpty())
			{
				System.out.println("Este libro no tiene ninguna reserva");
				SearchReservationUi.showSearchReservationUi();
			}
			else
			{
				//show the resultsUI by method
				ReservationResultsByMethodUi.showReservationResultsUi("USUARIO");
				//render the reservations
				ReservationRenderers.renderReservationsList(reservationList);
				//show results by method
				ReservationResultsByMethodMenu.showReservationResultsByMethodMenuOptions();
			}			
			break;
		}//switch
		
	}//end showSeachReservationMenuOptions()

}//end SearchReservationMenu