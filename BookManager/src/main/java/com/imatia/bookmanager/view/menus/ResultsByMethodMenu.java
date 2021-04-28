package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.BookController;
import com.imatia.bookmanager.model.entities.Book;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.results.BookDetails;
import com.imatia.bookmanager.view.ui.SearchesUi;


public class ResultsByMethodMenu {
	
	public static void showResultsByMethodMenuOptions() {
		
		String bookId;
		String option;
		do {
			option = InputUserData.checkUserInput("option", "Opcion no valida. Pruebe de nuevo (entero positivo)");
			if(!option.equals("") && !option.equals("0") && !option.equals("1")) {
				System.out.println("Opcion no valida. Pruebe de nuevo (entero positivo)");
			}
		}while (!option.equals("0") && !option.equals("1"));
		
		
		switch (Integer.parseInt(option))
		{
		case 0:
			SearchesUi.showSearchesUi();
			break;
		case 1:
			do
			{
				System.out.print("Introduzca el id del libro: ");
				bookId = InputUserData.checkUserInput("id", "Valor de Id incorrecto. Pruebe de nuevo (entero positivo).");
			}while(bookId.equals(""));
			
		Book book = new BookController().getBookById(Integer.parseInt(bookId));
		BookDetails.showBookDetails(book);
		break;
		}
		
	}
}
