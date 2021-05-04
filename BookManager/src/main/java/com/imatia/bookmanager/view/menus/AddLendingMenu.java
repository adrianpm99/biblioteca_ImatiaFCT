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

/*
 * class to show the add lending menu options
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
			System.out.print("\rNumero de ejemplares que se quieren prestar (de 1 a 3): ");
			option = InputUserData.checkUserInput("option", "Opcion no valida. Pruebe de nuevo (entero positivo)");
			if (!option.equals("") && !option.equals("1") && !option.equals("2") && !option.equals("3")) {
				System.out.println("Opcion no valida. Pruebe de nuevo (entero positivo)");
			}

		} while (!option.equals("1") && !option.equals("2") && !option.equals("3"));

		for (int i = 1; i <= Integer.parseInt(option); i++) {
			do {
				repeated = false;
				do {
					System.out.print("\rIdentificador ejemplar numero " + i + " a prestar:  (entero positivo) ");

					// return string
					idCopy = InputUserData.checkUserInput("id",
							"Valor de Id incorrecto. Pruebe de nuevo (entero positivo).");
				} while (idCopy.equals(""));

				// the id cannot be repeated
				for (int numIdCopy : idcopies) {
					// it goes through the arrayList and compares with the new data, if it is equal
					// to one, it asks for a new entry
					if (numIdCopy == Integer.parseInt(idCopy)) {
						System.out.println("\rNo se puede insertar un identificador de ejemplar repetido");
						repeated = true;
					}
				} // for
			} while (repeated);

			// insert the new idCopy only if it is different from the ones already inserted,

			idcopies.add(Integer.parseInt(idCopy));

		} // for
		do {
			System.out.print("\rId usuario: (entero positivo) ");
			// it should be verified that the user exists in the user table

			// return string
			idUser = InputUserData.checkUserInput("id", "Valor de Id incorrecto. Pruebe de nuevo (entero positivo).");
		} while (idUser.equals(""));

		LocalDate dateNow = LocalDate.now();
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/LL/yyyy");

		LocalDate dateReturn = dateNow.plusDays(15);

		// the lendingId is created automatically when inserting in the database
		Lending lending = new Lending(1, Integer.parseInt(idUser), dateNow, dateReturn, null);

		ArrayList<Copy> copyList = cc.getCopiesLists(idcopies);
		// idCopy and idUser existence checks are done at insert time
		// if it returns "" it is correct, if it returns a message it means that the
		// insertion has not been made
		String mensajeAddLending = lc.addLending(lending, idcopies);
		if (mensajeAddLending.equals("")) {
			// correct
			System.out.println("\rEstado de los ejemplares: ");
			for (int cont = 0; cont < copyList.size(); cont++) {
				System.out.println("\r Ejemplar " + copyList.get(cont).getCopyId() + ", " + copyList.get(cont).getcopyNotes());
			}
			// Today's date is automatically seen
			System.out.print("\rFecha del préstamo: " + formatoFecha.format(dateNow));
			// automatically see the return date that is 15 days later
			System.out.println("\rFecha de devolución del préstamo : " + formatoFecha.format(dateReturn));
			System.out.print("\rPréstamo añadido correctamente ");

		} else {
			System.out.println(mensajeAddLending);
		}
		LendingsUi.showLendingsUi();

	}// showAddLendingMenu()
}// class AddLendingMenu