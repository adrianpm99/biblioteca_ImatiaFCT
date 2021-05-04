package com.imatia.bookmanager.view.menus;

import java.util.ArrayList;
import java.util.List;

import com.imatia.bookmanager.controller.CopyController;
import com.imatia.bookmanager.model.entities.Copy;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.results.CopyRenderers;
import com.imatia.bookmanager.view.ui.AddCopyUi;
import com.imatia.bookmanager.view.ui.CopyUi;
import com.imatia.bookmanager.view.ui.DeleteCopyUi;
import com.imatia.bookmanager.view.ui.StartMenuUI;

public class CopyMenu {
	public static void showCopyOptions() {

		String option;
		String filter;
		List<Copy> copyList = new ArrayList<>();
		CopyController cc = new CopyController();

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
			do {
				System.out.println("Introduzca el id del libro (entero positivo): ");
				filter = InputUserData.checkUserInput("id", "Pruebe de nuevo (entero positivo): ");
			}while(filter.equals(""));
			
			copyList = cc.getCopyByBookId(Integer.parseInt(filter));
			if(copyList.isEmpty()) {
				System.out.println("No se han encontrado ejemplares de ese libro.");
				CopyUi.showCopyUi();
			}else {
				//ResultsCopyUi.showResultsCopyUi("ID DE LIBRO");
				CopyRenderers.renderBookIdListCopy(copyList);
				
			}
			CopyMenu.showCopyOptions();
			break;

		case 3:
			// option to modify the Notes of the Copy
			// Modify CopyNotes
			break;
		case 4:
			// option to delete Copy
			DeleteCopyUi.showDeleteCopyUi();
			break;
		}

	}// showCopyOptions()
}//class CopyMenu
