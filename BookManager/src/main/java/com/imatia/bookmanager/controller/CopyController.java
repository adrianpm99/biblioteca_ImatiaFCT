package com.imatia.bookmanager.controller;

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

}
