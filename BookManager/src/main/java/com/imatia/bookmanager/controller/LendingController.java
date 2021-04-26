package com.imatia.bookmanager.controller;

import java.util.ArrayList;

import com.imatia.bookmanager.model.data.LendingDao;
import com.imatia.bookmanager.model.entities.Copy;
import com.imatia.bookmanager.model.entities.Lending;

public class LendingController {
	LendingDao ld = new LendingDao();
	
	public String addLending(Lending lending, ArrayList<Integer> listIdCopy) {
		
		String error = ld.addLending(lending, listIdCopy);
		return error;
	}
	
	public void deleteLending(Lending lending, Copy copy) {
		
		ld.deleteLending(lending, copy);
	}
}
