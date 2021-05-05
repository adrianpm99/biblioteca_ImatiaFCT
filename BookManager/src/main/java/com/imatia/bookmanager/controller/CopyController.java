package com.imatia.bookmanager.controller;

import java.util.ArrayList;
import java.util.List;

import com.imatia.bookmanager.model.data.CopyDao;
import com.imatia.bookmanager.model.entities.Copy;

/**
 * class to implement the methods to connect views with data (regarding Copies)
 * 
 * @author Grupo2FCTImatia
 *
 */

public class CopyController {
	
	
	CopyDao cd = new CopyDao();
	
	/**
	 * method to add a copy to the database
	 * 
	 * @param copy
	 */
	
	public void addCopy(Copy copy) {
		
		cd.addCopy(copy);
	}//addCopy
	
	/**
	 * method to delete a copy from the database by its own id
	 * 
	 * @param id
	 */
	
	public void deleteCopy(int copyId) {
		
		if(!cd.checkIfCopyIsLended(copyId)) {
			//Deletes the copy
			cd.deleteCopy(copyId);
		}else {
			//Does not delete the copy
			System.out.println("No se puede borrar, el ejemplar está prestado");
		}
	}//deleteCopy
	
	
	/**
	 * method to delete a copy from the database by its books id
	 * 
	 * @param id
	 */
	
	public void deleteCopyByIdBook(int id) {
		cd.deleteCopybyIdBook(id);
	}//deleteCopyIdBook
	
	/**
	 * method to get a copy from the database filtered by its id
	 * 
	 * @param id
	 * @return copy
	 */
	
	public Copy getCopyById(int id) {
		
		Copy copy = new Copy();
		copy = cd.getCopyById(id);
		
		return copy;
	}//getCopyById


	/**
	 * method to get a list of idcopy in lending by book
	 * 
	 * @param lendingId
	 * @param bookId
	 * @return
	 */
	
	public List<Integer> getCopyIdInLendingByBook(int lendingId, int bookId){
		List<Integer> listIdCopys = new ArrayList<>();
		
		listIdCopys = cd.getCopyIdInLendingByBook(lendingId, bookId);
		
		return listIdCopys;
	}//getCopyInLendingByBook


	/**
	 * method to edit the notes of a Copy
	 * 
	 * @param id, copyNote
	 * @return copyList
	 */
	
	public void editCopyNotes(int id, String copyNote) {
		
		cd.editCopyNotes(id, copyNote);
	}//editCopyNotes

	/**
	 * method to get a list of all the copies available for every bookId 
	 * 
	 * @param listIdCopy
	 * @return copyList
	 */
	
	public ArrayList<Copy> getCopiesLists( ArrayList<Integer> listIdCopy) {
		ArrayList<Copy> copyList = new ArrayList<Copy>();
		for(int cont = 0 ; cont < listIdCopy.size() ; cont ++ ) {
			Copy copy =  cd.getCopyById(listIdCopy.get(cont));
			copyList.add(copy);
		}//for loop
		return copyList;
	}//getCopiesLists
	
	/**
	 * method to get a list of copies of a single book
	 * 
	 * @param BookId
	 * @return copyList
	 */
	
	public List<Copy> getCopyByBookId(int BookId) {
		
		List<Copy> copyList = cd.getCopyByBookId(BookId);
		
		return copyList;
	}//getCopyByBookId

}//CopyController
