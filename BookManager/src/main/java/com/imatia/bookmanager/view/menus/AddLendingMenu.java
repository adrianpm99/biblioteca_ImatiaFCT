package com.imatia.bookmanager.view.menus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;



import com.imatia.bookmanager.controller.LendingController;

import com.imatia.bookmanager.model.entities.Lending;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.LendingsUi;


public class AddLendingMenu {

	public static void showAddLendingMenu() {

		LendingController lc = new LendingController();
		
	
		ArrayList<Integer> idcopies = new ArrayList<Integer>();
		String idCopy; 
		String idUser;
				
		for (int i = 1 ; i <4 ; i ++) {
			System.out.print("\rIdentificador ejemplar num : " + i + " a prestar: ");
			
			//return string
			idCopy = InputUserData.checkUserInput("id");
			idcopies.add(Integer.parseInt(idCopy));
		}
		//
		System.out.print("\rId usuario: (entero positivo)");
		
		// it should be verified that the user exists in the user table
		idUser = InputUserData.checkUserInput("id", "Valor de Id incorrecto. Pruebe de nuevo (entero positivo).");
		
		LocalDate dateNow = LocalDate.now();
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/LL/yyyy");
		
		// Today's date is automatically seen
		System.out.print("\rFecha del préstamo: " + formatoFecha.format(dateNow)); 
		
		LocalDate dateReturn = dateNow.plusDays(15);

		// automatically see the return date that is 15 days later
		System.out.println("\rFecha de devolución del préstamo : " + formatoFecha.format(dateReturn)); 
		
		
		// the lendingId is created automatically when inserting in the database
		Lending lending = new Lending(1, Integer.parseInt(idUser), dateNow, dateReturn, null);
		
		lc.addLending(lending, idcopies);
	
		
		LendingsUi.showLendingsUi();

	}

}
