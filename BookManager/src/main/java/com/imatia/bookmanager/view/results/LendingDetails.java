package com.imatia.bookmanager.view.results;

import java.util.ArrayList;
import java.util.List;

import com.imatia.bookmanager.controller.BookController;
import com.imatia.bookmanager.controller.CopyController;
import com.imatia.bookmanager.controller.UserController;
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
	
	
	public static void showLendingDetails(Lending l, User u, List<Integer> bookList ) {

		BookController bc = new BookController();
		CopyController cc = new CopyController();
		
		List<Integer> copyList = new ArrayList<>();
		String bookCopys = "";
		//string of book titles to print in the lending details view
		String bookTitles = "";

		for (Integer i : bookList) {
			//get a String of book titles of the lending
			String bookTitle = bc.getBookById(i).getTitle();
			//get the copys of the book lending
			copyList = cc.getCopyIdInLendingByBook(l.getLendingId(), bc.getBookById(i).getId());
			//building the strings to show the results
			bookCopys = "(Id Ejemplar:" + copyList.toString() 
						+ " Estado:["+cc.getCopyById(copyList.get(0)).getcopyNotes()+"])\r||\r";
			bookTitles = bookTitles + bookTitle + bookCopys + "|| ";
		}

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
