/*
 * ITMD 510 - Object Oriented Application Development - Fall 2017
 * 
 * 
 * Project Name: Dr.Help -> Health Care Management System
 * 
 * 
 * Developed By: Anantharaman Chandar - A20403439
 *               Ashok Ramasami       - A20441032
 * 				 Gowrisankar Arumugam - A20400590					  -
 * 
 * Instructor: Prof. James Papademas 
 */

package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Connector {

	//Papa Server DB Connection
	public static Connection getConnection() throws Exception {
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@www.papademas.net:1521:orcl";
			String username = "ora_aag";
			String password = "oracle";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			
			return conn;
		}
		
		catch (Exception e) 
			{
			System.out.println("Error "+e);
			}

			return null;
	}
	
	
	
}
