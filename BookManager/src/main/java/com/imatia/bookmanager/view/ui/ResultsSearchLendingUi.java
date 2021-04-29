package com.imatia.bookmanager.view.ui;

/*
 * this is the UI to show the options of search lending by method
 */
public class ResultsSearchLendingUi {

	public static void showResultsSearchLendingUi(String searchMethod) {
		
		System.out.println(
				"\n***************************************\r\n" + 
				"** BUSCAR POR "+searchMethod+"\t- RESULTADOS **\r\n" + 
				"***************************************\r\n" + 
				"------------------------------------------------------------\r\n" + 
				"|| 1- Seleccionar prestamo || 0- Volver al menu de busquedas ||\r\n" + 
				"------------------------------------------------------------");
		
	}//showResultsSearchLendingUi
}
