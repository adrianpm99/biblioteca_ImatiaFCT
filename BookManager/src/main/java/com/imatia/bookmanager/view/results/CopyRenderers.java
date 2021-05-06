package com.imatia.bookmanager.view.results;

import java.util.List;

import com.imatia.bookmanager.controller.ShelvingController;
import com.imatia.bookmanager.model.entities.Copy;
import com.imatia.bookmanager.model.entities.Shelving;

/**
 * These utils recieve a list of copies and then, according to the selected BookId, will print:
 * Its copy id, its notes, and its shelving public number
 * 
 */

public class CopyRenderers {
	/**
	 * shows copyId and copyNotes
	 * 
	 * @param copyList 
	 */
	
	public static void renderBookIdListCopy(List<Copy> copyList) {
		for (Copy c : copyList) {
			Shelving shelving = new ShelvingController().getShelvingByCopyId(c.getCopyId());
			System.out.println(
					"===========================================================================================\n");
			System.out.println(
					"Id ejemplar: " + c.getCopyId() + "\t|| Observaciones ejemplar: "+c.getcopyNotes() + "|| Localizacion (Estantería): "+shelving.getShelvingPublicNumber()+"\n");
		}
		
	}//renderBookIdListCopy()	

}//CopyRenderers
