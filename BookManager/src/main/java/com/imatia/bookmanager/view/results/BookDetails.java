package com.imatia.bookmanager.view.results;

import com.imatia.bookmanager.model.entities.Book;

/**
 * This view shows the information details
 * about a selected book from the results list
 */
public class BookDetails
{
	public static void main(String[] args)
	{
		Book b= new Book();
		System.out.println(
				"*********************\r\n" + 
				"** DATOS DEL LIBRO **\r\n" + 
				"*********************\r\n" + 
				"----------------------------------------------------------\r\n" + 
				"|| 1- Editar libro || 0- Volver al menu de resultados	||\r\n" + 
				"----------------------------------------------------------\r\n" + 
				"|| Titulo: "+b.getTitle()+"\r\n" + 
				"||	\r\n" + 
				"|| Autor: "+b.getAuthor()+"\r\n" + 
				"||	\r\n" + 
				"|| ISBN: "+b.getISBN()+"	|| Año: "+b.getBookPublicationYear()+ "	|| Edicion: "+b.getEditorial()+"ª\r\n" + 
				"|| \r\n" + 
				"|| Editorial: "+b.getEditorial()+"	|| Hojas: "+b.getNumberOfSheets()+"\r\n" + 
				"==========================================================\r\n" + 
				"Descripcion:\r\n"+ 
				b.getDescription()+"\r\n" +
				"==========================================================");
	}//showBookDetails()
}//class BookDetails