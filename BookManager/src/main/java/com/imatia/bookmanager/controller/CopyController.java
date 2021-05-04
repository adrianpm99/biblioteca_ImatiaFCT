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
	public void deleteCopy(int id) {
		cd.deleteCopy(id);
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
	
	public ArrayList<Copy> getCopiesLists( ArrayList<Integer> listIdCopy) {
		ArrayList<Copy> copyList = new ArrayList<Copy>();
		for(int cont = 0 ; cont < listIdCopy.size() ; cont ++ ) {
			Copy copy =  cd.getCopyById(listIdCopy.get(cont));
			copyList.add(copy);
		}
		return copyList;
	}
}
