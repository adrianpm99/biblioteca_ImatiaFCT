package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.StartMenuUI;

/**
 * class to show the reservation details menu, in this case only shows one option
 * go to the start menu
 * 
 * @author Grupo2FCTImatia
 *
 */

public class ReservationDetailsMenu {

	public static void showReservationDetailsMenu() {
		String option;
		do {
			System.out.print("Pulse 0 para ir al menu principal: ");
			option = InputUserData.checkUserInput("option", "Opcion no valida. Pruebe de nuevo (entero positivo)");
			if (!option.equals("") && !option.equals("0")) {
				System.out.println("Opcion no valida. Pruebe de nuevo (entero positivo)");
			}
		} while (!option.equals("0"));
		StartMenuUI.showStartMenuUi();

	}//end showReservationDetailMenu

}//end ReservationDetailMenu
