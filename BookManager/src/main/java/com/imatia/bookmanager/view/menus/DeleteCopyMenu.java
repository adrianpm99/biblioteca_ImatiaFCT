package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.CopyController;
import com.imatia.bookmanager.model.entities.Copy;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.inputs.UtilityInputs;
import com.imatia.bookmanager.view.ui.CopyUi;

/*
 * class to show a delete book menu
 */
public class DeleteCopyMenu {

	public static void showDeleteCopyMenu() {
		
		String copyId;
		CopyController cc = new CopyController();
		
		//Get copyId from user
		do {
			copyId = InputUserData.checkUserInput("id", "Pruebe de nuevo(entero positivo)");
		} while (copyId.equals(""));

		//confirm if a Copy with this id exists
		Copy copy =cc.getCopyById(Integer.parseInt(copyId));
		if(copy == null) {
			System.out.println("No existe ningun ejemplar con el id facilitado");
			CopyUi.showCopyUi();
		}else {
			boolean confirmationDelete = UtilityInputs.getConfirmation("borrar", "ejemplar " + copyId);
			System.out.println(Integer.parseInt(copyId));
			// get the confirmation of the delete
			if (confirmationDelete) {
				cc.deleteCopy(Integer.parseInt(copyId));
				CopyUi.showCopyUi();

			} else {
				CopyUi.showCopyUi();
			}
		}
		
	}// showDeleteCopyMenu()
}// class DeleteCopyMenu
