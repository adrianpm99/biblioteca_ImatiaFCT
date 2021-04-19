package com.imatia.bookmanager;

import java.sql.SQLException;

import com.imatia.bookmanager.model.data.ConnectionSQLite;

/**
 * BookManagerApp
 *
 */
public class BookManagerApp 
{
    public static void main( String[] args )
    {
    	ConnectionSQLite connect = new ConnectionSQLite();
    	try {
			connect.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
