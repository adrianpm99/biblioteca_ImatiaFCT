package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.controller.CopyController;
import com.imatia.bookmanager.model.entities.Copy;
import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.CopyUi;

/*
 * this is the class to show edit copy menu
 */
public class EditCopyMenu {
	
	public static void showEditCopyMenu(int id) {
		
		String copyNote;
		CopyController cc = new CopyController();
		
		//check if exits a copy with this id
		Copy copy = cc.getCopyById(id);
		if(copy == null) {
			System.out.println("No existe ningún ejemplar con el id facilitado");
			CopyUi.showCopyUi();
		}else {
		
		System.out.print("Introduzca el nuevo estado: ");
		copyNote = InputUserData.checkUserInput("copyNotes", "Máximo 50 caracteres.");
		
		//edit the copyNotes of Copy with the new note
		cc.editCopyNotes(id, copyNote);
		
		//show the Copy Ui
		CopyUi.showCopyUi();
		}
	}


}
