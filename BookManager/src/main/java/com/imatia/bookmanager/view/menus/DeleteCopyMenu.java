package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.CopyController;
import com.imatia.bookmanager.controller.ShelvingController;
import com.imatia.bookmanager.model.entities.Copy;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.inputs.UtilityInputs;
import com.imatia.bookmanager.view.ui.CopyUi;

/**
 * Class to show a delete copy menu
 * 
 * @author Grupo2FCTImatia
 */

public class DeleteCopyMenu {

	public static void showDeleteCopyMenu() {

		CopyController cc = new CopyController();
		ShelvingController sc = new ShelvingController();

		String copyId;

		do {
			
			// Input for the copyId
			copyId = InputUserData.checkUserInput("id", "Pruebe de nuevo(entero positivo)");
			
		} while (copyId.equals(""));

		//Get a copy from the CopyId
		Copy copy = cc.getCopyById(Integer.parseInt(copyId));
		
		if (copy == null) {
			
			//Copy with copyId do not exist
			System.out.println("No existe ningun ejemplar con el id facilitado");
			
			//Go to CopyUi
			CopyUi.showCopyUi();
			
		} else {
			// get the confirmation of the delete
			boolean confirmationDelete = UtilityInputs.getConfirmation("borrar", "ejemplar " + copyId);
			
			//??
			System.out.println(Integer.parseInt(copyId));
			
			// get the confirmation of the delete
			if (confirmationDelete) {
				
				//Delete copy location
				sc.deleteCopyShelvingByCopyId(Integer.parseInt(copyId));
				//Delete a copy from database
				cc.deleteCopy(Integer.parseInt(copyId));
			}
			
			//Go to CopyUi
			CopyUi.showCopyUi();
		}

	}// showDeleteCopyMenu()
}// class DeleteCopyMenu
