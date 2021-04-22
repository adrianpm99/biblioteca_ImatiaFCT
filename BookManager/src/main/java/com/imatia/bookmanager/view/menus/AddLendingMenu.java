package com.imatia.bookmanager.view.menus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import com.imatia.bookmanager.controller.BookController;
import com.imatia.bookmanager.controller.LendingController;
import com.imatia.bookmanager.model.entities.Book;
import com.imatia.bookmanager.model.entities.Copy;
import com.imatia.bookmanager.model.entities.Lending;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.LendingsUi;
import com.imatia.bookmanager.view.ui.StartMenuUI;

public class AddLendingMenu {

	public static void showAddLendingMenu() {

		LendingController lc = new LendingController();
		
	
		ArrayList<Integer> idcopies = new ArrayList<Integer>();
		String idCopy; 
		String idUser;
				
		for (int i = 1 ; i <4 ; i ++) {
			System.out.print("Identificador ejemplar num : " + i + " a prestar: ");
			
			//return string
			idCopy = InputUserData.checkUserInput("id");
			idcopies.add(Integer.parseInt(idCopy));
		}
		//
		System.out.print("Id usuario: ");
		
		// it should be verified that the user exists in the user table
		idUser = InputUserData.checkUserInput("id");
		
		LocalDate dateNow = LocalDate.now();
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/LL/yyyy");
		
		// automaticamente se ve la fecha de hoy
		System.out.print("Fecha del préstamo: " + formatoFecha.format(dateNow)); 
		
		LocalDate dateReturn = dateNow.plusDays(15);

		// automáticamente se ve la fecha de devolución que es de 15 días despues 
		System.out.println("Fecha de devolución del préstamo : " + formatoFecha.format(dateReturn)); 
		
		
		// el id del prestamo se crea automaticamente al insertar en la bbdd
		Lending lending = new Lending(1,Integer.parseInt(idUser),  dateNow, dateReturn,null);
		
		lc.addLending(lending, idcopies);
	
		
		LendingsUi.showLendingsUi();

	}

}
