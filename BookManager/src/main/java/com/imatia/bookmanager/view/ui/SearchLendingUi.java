package com.imatia.bookmanager.view.ui;

import com.imatia.bookmanager.view.menus.SearchLendingMenu;

/**
 * this is the UI for the search lending options
 *
 */
public class SearchLendingUi {
	
	public static void showSearchLendingUi() {
	
		System.out.println(
				
				"\n**********************\r\n" + 
				"** BUSCAR PRESTAMOS **\r\n" + 
				"**********************\r\n" + 
				"-----------------------------------------------------------------------------------------------------------------------\r\n" + 
				"|| 1- Visualizar por ID || 2- Buscar por usuario || 3- Buscar por fecha de devolucion || 0- Volver al menu principal ||\r\n" + 
				"-----------------------------------------------------------------------------------------------------------------------");
		//show the search lending menu options
		SearchLendingMenu.showSearchLendingMenuOptions();
		
	}//showSearchLendingUi

}
