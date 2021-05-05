package com.imatia.bookmanager.controller;

import com.imatia.bookmanager.model.data.ShelvingDao;
import com.imatia.bookmanager.model.entities.Shelving;

public class ShelvingController {
	
	/**
	 * Get a Shelving Object by copyId
	 * @param copyId
	 * @return Shelving
	 */
	public  Shelving getShelvingByCopyId(int copyId) {	
		
		ShelvingDao sd = new ShelvingDao();
		
		Shelving shelving = sd.getShelvingByCopyId(copyId);
		
		return shelving;
		
	}//getShelvingByCopyId()
	
}//class ShelvingController
