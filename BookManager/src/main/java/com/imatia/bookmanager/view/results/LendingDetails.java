package com.imatia.bookmanager.view.results;

import com.imatia.bookmanager.model.entities.Lending;
import com.imatia.bookmanager.model.entities.User;
import com.imatia.bookmanager.view.inputs.UtilityDates;
import com.imatia.bookmanager.view.menus.LendingDetailsMenu;



/**
 * Called by the "Select Lending" option in the SearchLendingMenu, class to show specific lending details:
 * The user who requested the lending, their id, the book(s) he lent, the date in which he did, the date 
 * when he should bring them back, the date where the devolution is cancelled, and the notes of the lending
 */

public class LendingDetails {
	
	
	public static void showLendingDetails(Lending l, User u, String bookTitles) {
	
		System.out.println(
	
			"\n************************\r\n" + 
			"** DATOS DEL PRESTAMO **\r\n" + 
			"************************\r\n" + 
			"-----------------------------------------------------------\r\n" + 
			"|| 1- Cerrar prestamo || 0- Volver al menu de busquedas  ||\r\n" + 
			"-----------------------------------------------------------\r\n" + 
			"|| Usuario: "+u.getUserName()+" "+u.getUserSurname()+ "(Id:[" + u.getUserId() + "])" +"\r\n" + 
			"||	\r\n" + 
			"|| Libros: "+bookTitles+"\r\n" +
			"||	\r\n" + 
			"|| Fecha de Prestamo: "+UtilityDates.formatDayMonthYear(l.getLendingDate())+"\r\n" + 
			"||	\r\n" + 
			"|| Fecha de vencimiento: "+UtilityDates.formatDayMonthYear(l.getLendingDeadLine())+"\r\n" + 
			"|| \r\n" + 
			"|| Fecha de devolucion: "+UtilityDates.formatDayMonthYear(l.getLendingReturnDate())+"\r\n" + 
			"|| \r\n" +
			"|| Notas: " + l.getLendingNotes() +"\r\n" +
			"==========================================================\r\n");
		
		//show the lending details menu
		LendingDetailsMenu.showLendingDetailsMenuOptions(l.getLendingId());


	}//showLendingDetails
}//LendingDetails
