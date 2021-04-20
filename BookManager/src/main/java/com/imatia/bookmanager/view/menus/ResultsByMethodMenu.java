package com.imatia.bookmanager.view.menus;

/**
 * This view shows only the menu options 
 * in the results when searching by author, title, or ISBN
 * (searching method is passed as argument)
 */
public class ResultsByMethodMenu
{
	public static void showResultsByMehod(String method)
	{
		String searchMethod= "AUTOR";
		
		System.out.println(
				"***************************************\r\n" + 
				"** BUSCAR POR "+searchMethod+"\t- RESULTADOS **\r\n" + 
				"***************************************\r\n" + 
				"------------------------------------------------------------\r\n" + 
				"|| 1- Seleccionar libro || 0- Volver al menu de busquedas ||\r\n" + 
				"------------------------------------------------------------");
	}//showResultsView()
}//class ResultsByMethodMenu