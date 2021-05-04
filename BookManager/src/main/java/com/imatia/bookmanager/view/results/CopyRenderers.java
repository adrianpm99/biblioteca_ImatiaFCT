package com.imatia.bookmanager.view.results;

import java.util.List;
import com.imatia.bookmanager.model.entities.Copy;

/**
 * These utils recieve a list of copies and then, according to the selected BookId, will print some specific basic data
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
			System.out.println(
					"===========================================================================================\n");
			System.out.println(
					"Id ejemplar: " + c.getCopyId() + "\t|| Observaciones ejemplar: "+c.getcopyNotes() + "\n");
		}
		
	}//renderBookIdListCopy()
	
	

}
