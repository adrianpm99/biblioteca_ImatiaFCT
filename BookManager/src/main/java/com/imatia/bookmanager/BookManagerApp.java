package com.imatia.bookmanager;

import com.imatia.bookmanager.controller.BookController;

/**
 * BookManagerApp
 *
 */

public class BookManagerApp 
{
    public static void main( String[] args )
    {
    System.out.println("AdiosMundo");
    
    BookController bc = new BookController();
    
    System.out.println(bc.getBooksByAuthor("Edurne Portela"));
    }
}
