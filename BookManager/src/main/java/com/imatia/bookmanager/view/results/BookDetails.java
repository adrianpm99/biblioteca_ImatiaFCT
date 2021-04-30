package com.imatia.bookmanager.view.results;

import com.imatia.bookmanager.model.entities.Book;
import com.imatia.bookmanager.view.menus.BookDetailsMenu;
import com.imatia.bookmanager.view.ui.SearchesUi;

/**
 * This view shows the information details
 * about a selected book from the results list
 */
public class BookDetails
{
	public static void showBookDetails(Book b)
	{
	
		if(b!=null)
		{
			System.out.println(
					"\n*********************\r\n" + 
					"** DATOS DEL LIBRO **\r\n" + 
					"*********************\r\n" + 
					"-----------------------------------------------------------------------------\r\n" + 
					"|| 1- Editar libro || 2- Eliminar libro || 0- Volver al menu de busquedas  ||\r\n" + 
					"-----------------------------------------------------------------------------\r\n" + 
					"|| Titulo: "+b.getTitle()+"\r\n" + 
					"||	\r\n" + 
					"|| Autor: "+b.getAuthor()+"\r\n" + 
					"||	\r\n" + 
					"|| ISBN: "+b.getISBN()+"	|| Año: "+b.getBookPublicationYear()+ "	|| Edicion: "+b.getEdition()+"ª\r\n" + 
					"|| \r\n" + 
					"|| Editorial: "+b.getEditorial()+"	|| Hojas: "+b.getPageNumber()+"\r\n" + 
					"==========================================================\r\n" + 
					"Descripcion:\r\n"+ 
					b.getDescription()+"\r\n" +
					"==========================================================");
			
			BookDetailsMenu.showBookDetailsOptions(b.getId());
		}
		else
		{
			System.out.println("Error. El id solicitado no existe.\n");
			SearchesUi.showSearchesUi(); //if error occurs, back to Searches Menu
		}
	}//showBookDetails()
}//class BookDetails