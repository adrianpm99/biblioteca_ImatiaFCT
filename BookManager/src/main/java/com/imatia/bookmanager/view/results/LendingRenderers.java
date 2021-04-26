package com.imatia.bookmanager.view.results;

import java.util.List;

import com.imatia.bookmanager.model.entities.Book;
import com.imatia.bookmanager.model.entities.Lending;

/**
 * These utils receive a list of lending
 * and then, according to the search method,
 * will print some specific basic data
 */
public class LendingRenderers {
	/**
	 * shows: lendingId, userId, lendingDate, lendingDeadLine, lendingReturnDate
	 * @param lendingList searched by userId 
	 */
	public static void renderUserIdListLending(List<Lending> lendingList)
	{
		for(Lending l: lendingList)
		{
			System.out.println("===========================================================================================\n");
			System.out.println("Id Prestamo: "+l.getLendingId()+"\t|| Id Usuario: "+l.getUserId()+ 
								"\t|| Fecha Préstamo: "+l.getLendingDate()+"\t|| Fecha Devolución: "+l.getLendingDeadLine()+
								"\t|| Fecha Devuelto: "+l.getLendingReturnDate()+"\n");
		}
	}//renderUserIdListLending()
	
	
	/**
	 * shows: lendingId, userId, lendingDate,  lendingReturnDate
	 * @param lendingList searched by lendingDeadLine
	 */
	public static void renderDateListLending(List<Lending> lendingList)
	{
		for(Lending l: lendingList)
		{
			System.out.println("===========================================================================================\n");
			System.out.println("Id Prestamo: "+l.getLendingId()+"\t|| Id Usuario: "+l.getUserId()+ 
								"\t|| Fecha Préstamo: "+l.getLendingDate()+
								"\t|| Fecha Devuelto: "+l.getLendingReturnDate()+"\n");
		}
	}//renderDateListLending()
	
	
	

	
}//class LendingRenderers


