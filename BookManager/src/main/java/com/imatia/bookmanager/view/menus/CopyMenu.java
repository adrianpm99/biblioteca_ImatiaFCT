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
import com.imatia.bookmanager.view.ui.EditCopyUi;
import com.imatia.bookmanager.view.ui.StartMenuUI;

/**
 * Class to show Copies options
 * 
 * @author Grupo2FCTImatia
 */

public class CopyMenu {
	
	public static void showCopyOptions() {
		
		CopyController cc = new CopyController();

		String idCopy;
		String option;
		String filter;
		List<Copy> copyList = new ArrayList<>();

		do {
			
			//Ask for the option
			option = InputUserData.checkUserInput("option", "Opcion no valida. Pruebe de nuevo (entero positivo)");
			
			//Check if option is wrong
			if (!option.equals("") && !option.equals("0") && !option.equals("1") && !option.equals("2")
					&& !option.equals("3") && !option.equals("4")) {
				System.out.println("Opcion no valida. Pruebe de nuevo (entero positivo)");
			}
			
		} while (!option.equals("0") && !option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4"));

		switch (Integer.parseInt(option)) {
		
		// Go to StartMenu
		case 0:
			StartMenuUI.showStartMenuUi();
			break;

		//Go to AddCopyUi
		case 1:
			// option to insert Copy
			AddCopyUi.showAddCopyUi();
			break;

		//Go to Searck Copy
		case 2:
			// option to search Copy by id
			// Search Copy
			do {
				
				//Ask for bookId
				System.out.println("Introduzca el id del libro (entero positivo): ");
				filter = InputUserData.checkUserInput("id", "Pruebe de nuevo (entero positivo): ");
				
			}while(filter.equals(""));
			
			//Get a list of Copies of the bookId
			copyList = cc.getCopyByBookId(Integer.parseInt(filter));
			
			if(copyList.isEmpty()) {
				
				//If no copies
				System.out.println("No se han encontrado ejemplares de ese libro.");
				
				//Go to ShowCopyUi
				CopyUi.showCopyUi();
				
			}else {
				
				//Show the render of copies
				CopyRenderers.renderBookIdListCopy(copyList);
				
			}
			
			//Go to showCopyUi
			CopyUi.showCopyUi();
			
			break;

		//Let u edit the copyNotes
		case 3:
			
			do {
				
				//Ask for copyId
				System.out.print("Introduzca el id del ejemplar: ");
				idCopy = InputUserData.checkUserInput("id", "Pruebe de nuevo(entero positivo)");
				
			} while (idCopy.equals(""));
			
			//Let u edit the copyNotes
			EditCopyUi.showEditCopyUi(Integer.parseInt(idCopy));
			
			break;
		
		//Go to deleteCopyUi
		case 4:
			
			// Go to deleteCopyUi
			DeleteCopyUi.showDeleteCopyUi();
			
			break;
			
		}

	}// showCopyOptions()
	
}//class CopyMenu
