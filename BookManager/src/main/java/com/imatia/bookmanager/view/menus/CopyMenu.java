package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.AddCopyUi;
import com.imatia.bookmanager.view.ui.EditCopyUi;
import com.imatia.bookmanager.view.ui.StartMenuUI;

public class CopyMenu {
	public static void showCopyOptions() {
		String idCopy;
		String option;

		do {
			option = InputUserData.checkUserInput("option", "Opcion no valida. Pruebe de nuevo (entero positivo)");
			if (!option.equals("") && !option.equals("0") && !option.equals("1") && !option.equals("2")
					&& !option.equals("3") && !option.equals("4")) {
				System.out.println("Opcion no valida. Pruebe de nuevo (entero positivo)");
			}
		} while (!option.equals("0") && !option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4"));

		switch (Integer.parseInt(option)) {
		case 0:
			StartMenuUI.showStartMenuUi();
			break;

		case 1:
			// option to insert Copy
			AddCopyUi.showAddCopyUi();
			break;

		case 2:
			// option to search Copy by id
			// Search Copy
			//SearchCopyUi.showSearchCopyUi();
			break;

		case 3:
			// option to modify the Notes of the Copy
			do {
				System.out.print("Introduzca el id del ejemplar: ");
				idCopy = InputUserData.checkUserInput("id", "Pruebe de nuevo(entero positivo)");
			} while (idCopy.equals(""));
			EditCopyUi.showEditCopyUi(Integer.parseInt(idCopy));
			break;
		case 4:
			// option to delete Copy
			// DeleteCopy
			break;
		}

	}// showCopyOptions()
}//class CopyMenu
