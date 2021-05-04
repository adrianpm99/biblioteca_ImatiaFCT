package com.imatia.bookmanager.controller;

import java.util.ArrayList;
import java.util.List;

import com.imatia.bookmanager.model.data.CopyDao;
import com.imatia.bookmanager.model.entities.Copy;

/**
 * class to implements method to connect views with data
 * @author Grupo2FCTImatia
 *
 */
public class CopyController {
	
	
	CopyDao cd = new CopyDao();
	
	/**
	 * method to add a copy to database
	 * @param copy
	 */
	public void addCopy(Copy copy) {
		
		cd.addCopy(copy);
	}
	/**
	 * method to delete a copy to database
	 * @param id
	 */
	public void deleteCopy(int copyId) {
		
		if(!cd.checkIfCopyIsLended(copyId)) {
			//Delete the copy
			cd.deleteCopy(copyId);
		}else {
			//Do not delete the copy
			System.out.println("No se puede borrar, el ejemplar está prestado");
		}
	}
	
	/**
	 * method to get a copy from database filter by id
	 * @param id
	 * @return copy
	 */
	public Copy getCopyById(int id) {
		
		Copy copy = new Copy();
		copy = cd.getCopyById(id);
		
		return copy;
	}
	
	/**
	 * method to delete a copy
	 * @param id
	 */
	public void deleteCopyByIdBook(int id) {
		cd.deleteCopybyIdBook(id);
	}

	/**
	 * method to get a list of idcopy in lending by book
	 * @param lendingId
	 * @param bookId
	 * @return
	 */
	public List<Integer> getCopyIdInLendingByBook(int lendingId, int bookId){
		List<Integer> listIdCopys = new ArrayList<>();
		
		listIdCopys = cd.getCopyIdInLendingByBook(lendingId, bookId);
		
		return listIdCopys;
	}//getCopyInLendingByBook
}
