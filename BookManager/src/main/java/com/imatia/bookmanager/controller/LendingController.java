
package com.imatia.bookmanager.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	
	public Lending getLendingById(int id) {
		
		Lending lending = ld.getLendingById(id);
		return lending;
	}
	
	/**
	 * method to get a list of lendings filter by UserId
	 * @param UserId
	 * @return lendingList
	 */
	public List<Lending> getLendingByUserId(int id) {
		
		List<Lending> lendingList = ld.getLendingByUserId(id);
		return lendingList;
	}
	
	/**
	 * method to get a list of lendings filter by LendingDeadLine
	 * @param LendingDeadLine
	 * @return lendingList
	 */
	public List<Lending> getLendingByDeadLine(LocalDate date) {
		
		List<Lending> lendingList = ld.getLendingByDeadLine(date);
		return lendingList;
	}
	
	public void modifyLendingReturnDate(int id, LocalDate lendingReturnDate) {
		ld.modifyLendingReturndDate(id, lendingReturnDate);
	}
	
	
	
}

