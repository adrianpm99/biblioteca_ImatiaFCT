package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.StartMenuUI;
import com.imatia.bookmanager.controller.ReservationController;

public class ReservationMenu {
	public static void showReservationOptions() {
		String option;
		//Option
		do {
			option = InputUserData.checkUserInput("option", "Opcion no valida. Pruebe de nuevo (entero positivo)");
		} while (option.equals("") && !option.equals("0") && !option.equals("1"));
		
		switch (Integer.parseInt(option))
		{
		case 0:
			//Return to de start Menu
			StartMenuUI.showStartMenuUi();
			break;
			
		case 1:
			//Add reservation
			break;
		}
	}//showReservationMenuOptions()
}//class ReservationsMenu