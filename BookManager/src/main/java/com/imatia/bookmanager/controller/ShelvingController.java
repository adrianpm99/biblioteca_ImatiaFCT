package com.imatia.bookmanager.controller;

import com.imatia.bookmanager.model.data.ShelvingDao;
import com.imatia.bookmanager.model.entities.Shelving;

/**
 * class to implement the methods to connect views with data
 * 
 * @author Grupo2FCTImatia
 *
 */
public class ShelvingController {

	ShelvingDao sd = new ShelvingDao();
	/*
	 * method to add a shelving
	 */
	public void addShelving(Shelving shelving) {

		sd.addShelving(shelving);
	}// addShelving

	/*
	 * method to add a copy shelving
	 */
	public void addCopyShelving(int idShelving, int idCopy) {

		sd.addCopyShelving(idShelving, idCopy);
	}// addCopyShelving

	/*
	 * method to get a shelving by id
	 */
	public Shelving getShelvingById(int id) {
		Shelving shelving = sd.getShelvingById(id);
		return shelving;
	}// getShelvingById

}
