package com.imatia.bookmanager.view.results;

import com.imatia.bookmanager.model.entities.Lending;
import com.imatia.bookmanager.model.entities.User;
import com.imatia.bookmanager.view.menus.LendingDetailsMenu;


public class LendingDetails {
	
	
	public static void showLendingDetails(Lending l, User u, String bookTitles) {
	
		System.out.println(
	
			"\n************************\r\n" + 
			"** DATOS DEL PRESTAMO **\r\n" + 
			"************************\r\n" + 
			"-----------------------------------------------------------\r\n" + 
			"|| 1- Cerrar prestamo || 0- Volver al menu de busquedas  ||\r\n" + 
			"-----------------------------------------------------------\r\n" + 
			"|| Usuario: "+u.getUserName()+" "+u.getUserSurname()+"\r\n" + 
			"||	\r\n" + 
			"|| Libros: "+bookTitles+"\r\n" +
			"||	\r\n" + 
			"|| Fecha de Prestamo: "+l.getLendingDate()+"\r\n" + 
			"||	\r\n" + 
			"|| Fecha de vencimiento: "+l.getLendingDeadLine()+"\r\n" + 
			"|| \r\n" + 
			"|| Fecha de devolucion: "+l.getLendingReturnDate()+"\r\n" + 
			"==========================================================\r\n");
		

		LendingDetailsMenu.showLendingDetailsMenuOptions(l.getLendingId());


	}
}
