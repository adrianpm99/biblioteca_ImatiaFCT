package com.imatia.bookmanager.view.ui;




/**
 * This view shows only the menu options 
 * in the results when searching by author, title, or ISBN
 * (searching method is passed as argument)
 */
public class ResultsByMethodUi
{
	public static void showResultsUi(String searchMethod)
	{		
		System.out.println(
				"\n***************************************\r\n" + 
				"** BUSCAR POR "+searchMethod+"\t- RESULTADOS **\r\n" + 
				"***************************************\r\n" + 
				"------------------------------------------------------------\r\n" + 
				"|| 1- Seleccionar libro || 0- Volver al menu de busquedas ||\r\n" + 
				"------------------------------------------------------------");
		

	}//showResultsView()
}//class ResultsByMethodMenu