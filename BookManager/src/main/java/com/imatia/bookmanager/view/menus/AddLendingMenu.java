package com.imatia.bookmanager.view.menus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.processing.SupportedSourceVersion;

import com.imatia.bookmanager.controller.LendingController;

import com.imatia.bookmanager.model.entities.Lending;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.LendingsUi;


public class AddLendingMenu {

	public static void showAddLendingMenu() {

		LendingController lc = new LendingController();
		
		int option;
		ArrayList<Integer> idcopies = new ArrayList<Integer>();
		String idCopy; 
		String idUser;
		boolean repeated = false;
		
		do {
			
			System.out.print("\rNumero de ejemplares que se quieren prestar (de 1 a 3): ");
			option = Integer.parseInt(InputUserData.checkUserInput("option"));
		} while (option != 1 && option != 2 && option != 3);
		
		
		for (int i = 1 ; i <= option ; i ++) {
			
		  do {	
			  repeated = false;
			System.out.print("\rIdentificador ejemplar num : " + i + " a prestar:  (entero positivo) ");

			//return string
			idCopy = InputUserData.checkUserInput("id", "Valor de Id incorrecto. Pruebe de nuevo (entero positivo).");

			// the id cannot be repeated
			for (int numIdCopy : idcopies) {
				// it goes through the arrayList and compares with the new data, if it is equal to one, it asks for a new entry
				if (numIdCopy == Integer.parseInt(idCopy)){
					System.out.println("\rNo se puede insertar un identificador de ejemplar repetido");
					repeated = true;
				}
			}
			
						
		  }while (repeated);
		 
		//insert the new idCopy only if it is different from the ones already inserted,
		 
		  idcopies.add(Integer.parseInt(idCopy));
			
		}	
		//
		System.out.print("\rId usuario: (entero positivo) ");
		
		// it should be verified that the user exists in the user table
		
		//return string
		idUser = InputUserData.checkUserInput("id", "Valor de Id incorrecto. Pruebe de nuevo (entero positivo).");
			
		LocalDate dateNow = LocalDate.now();
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/LL/yyyy");
		
		// Today's date is automatically seen
		System.out.print("\rFecha del préstamo: " + formatoFecha.format(dateNow)); 
		
		LocalDate dateReturn = dateNow.plusDays(15);

		// automatically see the return date that is 15 days later
		System.out.println("\rFecha de devolución del préstamo : " + formatoFecha.format(dateReturn)); 
		
		
		// the lendingId is created automatically when inserting in the database
		
		Lending lending = new Lending(1,Integer.parseInt(idUser),  dateNow, dateReturn,null);
		
		
		// idCopy and idUser existence checks are done at insert time
		// if it returns "" it is correct, if it returns a message it means that the insertion has not been made
		String mensajeAddLending = lc.addLending(lending, idcopies);
		if (mensajeAddLending.equals("")) {
			//correct
			System.out.print("\rPréstamo añadido correctamente "); 
			
		}else {
			System.out.println(mensajeAddLending);
		}
		LendingsUi.showLendingsUi();

	}

}
