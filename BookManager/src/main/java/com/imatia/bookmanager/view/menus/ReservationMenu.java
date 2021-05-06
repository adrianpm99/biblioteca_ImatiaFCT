package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.AddReservationUi;
import com.imatia.bookmanager.view.ui.DeleteReservationUi;
import com.imatia.bookmanager.view.ui.SearchReservationUi;
import com.imatia.bookmanager.view.ui.StartMenuUI;

/**
 * Options to manage what to do, after showing the reservations ui
 * 
 * @author Grupo2FCTImatia
 *
 */

public class ReservationMenu {
	
	public static void showReservationOptions() {
		String option;
		//Option
		do {
			option = InputUserData.checkUserInput("option", "Opcion no valida. Pruebe de nuevo (entero positivo)");
			if(!option.equals("") && !option.equals("0") && !option.equals("1") && !option.equals("2") && !option.equals("3"))
			{
				System.out.println("Opcion no valida. Pruebe de nuevo (entero positivo)");
			}
		} while (!option.equals("0") && !option.equals("1") && !option.equals("2") && !option.equals("3"));
		
		switch (Integer.parseInt(option))
		{
		case 0:
			//Return to de start Menu
			StartMenuUI.showStartMenuUi();
			break;
			
		case 1:
			//Show the add reservation ui
			AddReservationUi.showAddReservationUi();
			break;
			
		case 2:
			//Show the cancel reservation ui
			DeleteReservationUi.showDeleteReservationUi();
			break;
		
		case 3: 
			//Shpw the search reservation ui
			SearchReservationUi.showSearchReservationUi();
			break;
		}
		
	}//end showReservationMenuOptions()
	
}//end class ReservationsMenu