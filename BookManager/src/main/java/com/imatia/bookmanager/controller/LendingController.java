package com.imatia.bookmanager.controller;

import com.imatia.bookmanager.model.data.LendingDao;
import com.imatia.bookmanager.model.entities.Copy;
import com.imatia.bookmanager.model.entities.Lending;

public class LendingController {
	LendingDao ld = new LendingDao();
	
	public void addBook(Lending lending, Copy copy) {
		
		ld.addLending(lending, copy);
	}
}
