package com.imatia.bookmanager.view.menus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.imatia.bookmanager.controller.CopyController;
import com.imatia.bookmanager.controller.LendingController;
import com.imatia.bookmanager.model.entities.Copy;
import com.imatia.bookmanager.model.entities.Lending;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.LendingsUi;

/**
 * Class implements the add Lending
 * 
 * @author Grupo2FCTImatia
 */

public class AddLendingMenu {

	public static void showAddLendingMenu() {

		LendingController lc = new LendingController();
		CopyController cc = new CopyController();

		String option;
		ArrayList<Integer> idcopies = new ArrayList<Integer>();
		String idCopy;
		String idUser;
		boolean repeated = false;

		do {

			// Ask for how many copies gonna borrow
			System.out.print("\rNumero de ejemplares que se quieren prestar (de 1 a 3): ");
			option = InputUserData.checkUserInput("option", "Opcion no valida. Pruebe de nuevo (entero positivo)");

			// Check is the option is wrong
			if (!option.equals("") && !option.equals("1") && !option.equals("2") && !option.equals("3")) {
				System.out.println("Opcion no valida. Pruebe de nuevo (entero positivo)");
			}

		} while (!option.equals("1") && !option.equals("2") && !option.equals("3"));

		for (int i = 1; i <= Integer.parseInt(option); i++) {

			do {

				repeated = false;

				do {

					// Ask for de copy or copies to lend
					System.out.print("\rIdentificador ejemplar numero " + i + " a prestar:  (entero positivo) ");
					idCopy = InputUserData.checkUserInput("id",
							"Valor de Id incorrecto. Pruebe de nuevo (entero positivo).");

				} while (idCopy.equals(""));

				// The id cannot be repeated
				for (int numIdCopy : idcopies) {

					// It goes through the arrayList and compares with the new data, if it is equal
					// to one, it asks for a new entry
					if (numIdCopy == Integer.parseInt(idCopy)) {
						System.out.println("\rNo se puede insertar un identificador de ejemplar repetido");
						repeated = true;
					}

				}

			} while (repeated);

			// Insert the new idCopy only if it is different from the ones already inserted,
			idcopies.add(Integer.parseInt(idCopy));

		}

		do {

			// Ask for the userId
			System.out.print("\rId usuario: (entero positivo) ");
			idUser = InputUserData.checkUserInput("id", "Valor de Id incorrecto. Pruebe de nuevo (entero positivo).");

		} while (idUser.equals(""));

		// Geting the time now and formating
		LocalDate dateNow = LocalDate.now();
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/LL/yyyy");

		// Geting the teorical returning date
		LocalDate dateReturn = dateNow.plusDays(15);

		// The lendingId is created automatically when inserting in the database
		Lending lending = new Lending(1, Integer.parseInt(idUser), dateNow, dateReturn, null, null);

		ArrayList<Copy> copyList = cc.getCopiesLists(idcopies);

		// idCopy and idUser existence checks are done at insert time
		// if it returns "" it is correct, if it returns a message it means that the
		// insertion has not been made
		String mensajeAddLending = lc.addLending(lending, idcopies);

		if (mensajeAddLending.equals("")) {

			// Show the copies that are lended
			System.out.println("\rEstado de los ejemplares: ");
			for (int cont = 0; cont < copyList.size(); cont++) {
				System.out.println(
						"\r Ejemplar " + copyList.get(cont).getCopyId() + ", " + copyList.get(cont).getcopyNotes());
			}

			// Today's date is automatically seen
			System.out.print("\rFecha del préstamo: " + formatoFecha.format(dateNow));

			// Automatically see the return date that is 15 days later
			System.out.println("\rFecha de devolución del préstamo : " + formatoFecha.format(dateReturn));
			System.out.print("\rPréstamo añadido correctamente ");

		} else {
			System.out.println(mensajeAddLending);
		}

		// Go to the LendingsUi
		LendingsUi.showLendingsUi();

	}// showAddLendingMenu()

}// class AddLendingMenu