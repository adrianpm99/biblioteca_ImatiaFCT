package com.imatia.bookmanager.controller;

import java.util.ArrayList;

import com.imatia.bookmanager.model.data.LendingDao;
import com.imatia.bookmanager.model.entities.Copy;
import com.imatia.bookmanager.model.entities.Lending;

public class LendingController {
	
	LendingDao ld = new LendingDao();
	
	public void addLending(Lending lending, ArrayList<Integer> listIdCopy) {
		
		ld.addLending(lending, listIdCopy);
	}
	
	public void deleteLending(Lending lending, Copy copy) {
		
		ld.deleteLending(lending, copy);
	}
	
	public Lending getLendingById(int id) {
		
		Lending lending = ld.getLendingById(id);
		return lending;
	}
}
