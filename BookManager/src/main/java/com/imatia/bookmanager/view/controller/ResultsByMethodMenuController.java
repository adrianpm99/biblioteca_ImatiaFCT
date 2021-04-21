package com.imatia.bookmanager.view.controller;

import com.imatia.bookmanager.model.data.BookDao;
import com.imatia.bookmanager.model.entities.Book;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.menus.SearchesMenu;
import com.imatia.bookmanager.view.results.BookDetails;


public class ResultsByMethodMenuController {
	
	public static void showResultsByMethodMenuOptions() {
		
		int bookId;
		int option;
		do {
			option = Integer.parseInt(InputUserData.checkUserInput("option"));

			switch (option) {

			case 0:
				SearchesMenu.showSearchesMenu();
				break;
			case 1:
				System.out.print("Introduzca el id del libro: ");
				bookId = Integer.parseInt(InputUserData.checkUserInput("id"));
				Book book = new BookDao().getBookById(bookId);
				BookDetails.showBookDetails(book);
				break;
			}
			
		}while (option != 0 && option != 1);
	}
	
	
}
