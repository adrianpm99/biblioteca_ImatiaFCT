package com.imatia.bookmanager;

<<<<<<< HEAD

=======
import java.sql.SQLException;

import com.imatia.bookmanager.model.data.ConnectionSQLite;
>>>>>>> branch 'Development' of https://github.com/adrianpm99/biblioteca_ImatiaFCT

/**
 * BookManagerApp
 *
 */
public class BookManagerApp 
{
    public static void main( String[] args )
    {
<<<<<<< HEAD
    	
=======
    	ConnectionSQLite connect = new ConnectionSQLite();
    	try {
			connect.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
>>>>>>> branch 'Development' of https://github.com/adrianpm99/biblioteca_ImatiaFCT
    }
}
