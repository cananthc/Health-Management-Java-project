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
import java.sql.Statement;

import javax.swing.JOptionPane;

import Dr.Help.newUser;

public class InsertInToDB {
	
	
	static String syntax;

	// Insert New Users
	public static void insertNewUsers(String Name, String Password, String DOB, String Gender, String Email, String Mobile) {
		// TODO Auto-generated method stub
		
		
		Connection conn;
		try {
			conn = Connector.getConnection();

			String insertTbl = "INSERT INTO DH_USERS_1 (U_ID, NAME, PASSWORD, DOB, GENDER, EMAIL_ID, MOBILE, ACCOUNT_LOCKED) VALUES(";
			String autoIncrementID = "SEQ_PERSON.NEXTVAL";
			String endValueBrack = ")";
			String accountStatus = "N";
			String insertCmd = insertTbl + autoIncrementID             + "," 
										 + "'" + Name          + "'"   + "," 
										 + "'" + Password      + "'"   + ","
										 + "'" + DOB           + "'"   + "," 
										 + "'" + Gender        + "'"   + "," 
										 + "'" + Email         + "'"   + "," 
										       + Mobile                + "," 
										 + "'" + accountStatus + "'"   
										       + endValueBrack;
			syntax = "EmailID " + Email;
			Statement stmt = conn.createStatement();
			// System.out.println(insertCmd);
			int result = stmt.executeUpdate(insertCmd);
			// System.out.println(result);
			if (result == 1) {
				System.out.println("User Details Successfully Inserted into Papa Server");
				JOptionPane.showMessageDialog(null, "Successfully Registered. Proceed To Login");
				
			} else {
				System.out.println("User Details Not Successfully Inserted into Papa Server");
			}
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error " + e);
			InsertInToDB.SQLSyntaxErrorMessage(e.getMessage(), syntax, "New User");
			JOptionPane.showMessageDialog(null, "Unable To Register Now. Please Contact IT Admin");
		}

	}

	// Insert New Doctors
	public static void insertNewDoctor(String Name, String Password, String DOB, String Gender, String Email,
			String Mobile, int Category, String HospName) {
		Connection conn;
		try {
			conn = Connector.getConnection();

			String insertTbl = "INSERT INTO DH_DOCTORS_1 (D_ID, NAME, PASSWORD, DOB, GENDER, EMAIL_ID, MOBILE, "
					+ "CATEGORY, HOSPITAL_NAME, ACCOUNT_LOCKED) VALUES(";
			String autoIncrementID = "SEQ_PERSON.NEXTVAL";
			String endValueBrack = ")";
			String accountStatus = "N";
			String insertCmd = insertTbl + autoIncrementID               + "," 
										 + "'" + Name         + "'"       + "," 
										 + "'" + Password     + "'"      + ","
										 + "'" + DOB          + "'"      + "," 
										 + "'" + Gender       + "'"      + "," 
										 + "'" + Email        + "'"      + "," 
										 	   + Mobile 		         + ","
										 	   + Category 			     + "," 
										 + "'" + HospName      + "'"     + "," 
										 + "'" + accountStatus + "'" 
										       + endValueBrack;
			syntax = "EmailID " + Email;
			Statement stmt = conn.createStatement();
			// System.out.println(insertCmd);
			int result = stmt.executeUpdate(insertCmd);

			// System.out.println(result);
			if (result == 1) {
				System.out.println("Doctor Details Successfully Inserted into Papa Server");

				JOptionPane.showMessageDialog(null, "Successfully Registered. Proceed To Login");

			} else {
				System.out.println("Doctor Details Not Successfully Inserted into Papa Server");
			}
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			InsertInToDB.SQLSyntaxErrorMessage(e.getMessage(), syntax, "New Doctor");
			JOptionPane.showMessageDialog(null, "Unable To Register Now. Please Contact IT Admin");
		}
	}

	// Insert New Managers
	public static void insertNewManager(String Name, String Password, String Gender, String Email) {
		Connection conn;
		try {
			conn = Connector.getConnection();

			String insertTbl = "INSERT INTO DH_MANAGEMENTS_1 (M_ID, NAME, PASSWORD, GENDER, EMAIL_ID, ACCOUNT_LOCKED) VALUES(";
			String autoIncrementID = "SEQ_PERSON.NEXTVAL";
			String endValueBrack = ")";
			String accountStatus = "N";
			String insertCmd = insertTbl + autoIncrementID                + "," 
									     + "'" + Name           + "'"     + "," 
									     + "'" + Password       + "'"     + ","
									     + "'" + Gender         + "'"     + "," 
									     + "'" + Email          + "'"     + "," 
									     + "'" + accountStatus  + "'" 
									     	   + endValueBrack;
			syntax = "EmailID " + Email;
			Statement stmt = conn.createStatement();
			// System.out.println(insertCmd);
			int result = stmt.executeUpdate(insertCmd);
			// System.out.println(result);
			if (result == 1) {
				System.out.println("Manager Details Successfully Inserted into Papa Server");
				JOptionPane.showMessageDialog(null, "Successfully Registered. Proceed To Login");

			} else {
				System.out.println("Manager Details Not Successfully Inserted into Papa Server");
			}
			
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error " + e);
			InsertInToDB.SQLSyntaxErrorMessage(e.getMessage(), syntax, "New Manager");
			JOptionPane.showMessageDialog(null, "Unable To Register Now. Please Contact IT Admin");
		}
	}

	
	//Insert new Admin 
	public static void insertNewAdmin(String Name, String Password, String DOB, String Email, String Gender) {

		Connection conn;
		try {
			conn = Connector.getConnection();

			String insertTbl = "INSERT INTO DH_ADMINS_1 (A_ID, NAME, PASSWORD, DOB, EMAIL_ID, GENDER, ACCOUNT_LOCKED) VALUES(";
			String autoIncrementID = "SEQ_PERSON.NEXTVAL";
			String endValueBrack = ")";
			String accountStatus = "N";
			String insertCmd = insertTbl + autoIncrementID                + "," 
										 +"'"  + Name          + "'"      + "," 
										 + "'" + Password      + "'"      + ","
										 + "'" + DOB           + "'"      + ","
										 + "'" + Email         + "'"      + "," 
										 + "'" + Gender        + "'"      + ","
										 + "'" + accountStatus + "'" 
										       + endValueBrack;
			syntax = "EmailID " + Email;
			Statement stmt = conn.createStatement();
			// System.out.println(insertCmd);
			int result = stmt.executeUpdate(insertCmd);

			// System.out.println(result);
			if (result == 1) {
				System.out.println("Admin Details Successfully Inserted into Papa Server");
				JOptionPane.showMessageDialog(null, "Successfully Registered. Proceed To Login");
				
			} else {
				System.out.println("Admin Details Not Successfully Inserted into Papa Server");
			}
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error " + e);
			InsertInToDB.SQLSyntaxErrorMessage(e.getMessage(), syntax, "New Admin");
			JOptionPane.showMessageDialog(null, "Unable To Register Now. Please Contact IT Admin");
		}
		
	}

	//Create a new Request ID
	public static void insertRequestTick(int confrmationNumber,String UserName,String Mobile, String Category, String Issue_Desc, int Priority, int SLA, int Hours) {

		Connection conn;
		try {
			conn = Connector.getConnection();

			String insertTbl = "INSERT INTO DH_ADMIN_TICKETS (TICKET_NUMBER, RAISED_BY, CONTACT_NUMBER, ISSUE_CATEGORY, ISSUE_DESCRIPTION, PRIORITY_LEVEL"
															  + " ,SLA_DAYS, HOURS_REMAINING, STATUS) VALUES(";
			
			String endValueBrack = ")";
			String insertCmd = insertTbl + confrmationNumber                               +","
															 + "'"   + UserName     +"'"   +","
															 + "'"   + Mobile       +"'"   +","
															 + "'"   + Category     +"'"   +","
															 + "'"   + Issue_Desc   +"'"   +"," 
															         + Priority            +","
															         + SLA                 +","
															         + Hours               +","
															 +"'"    + "Open"              +"'"
															         +endValueBrack;
			System.out.println(insertCmd);
			Statement stmt = conn.createStatement();
			// System.out.println(insertCmd);
			int result = stmt.executeUpdate(insertCmd);

			// System.out.println(result);
			if (result == 1) {
				System.out.println("Ticket successfully Created");

			} else {
				System.out.println("Error While Creating Ticket");
				
			}
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error " + e);
		}
	}
	
	// Insert Error Details
	public static void errorHandler(int numId) {
		Connection conn;
		try {
			conn = Connector.getConnection();

			String insertTbl = "INSERT INTO DH_VALIDATION_ERROR_1 (UNIQUE_ID, DESCRIPTION) VALUES(";
			String autoIncrementID = "SEQ_PERSON.NEXTVAL";
			String endValueBrack = ")";
			if (numId == 1) {
     				String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  + "Name Validation Error"  + "'"  + endValueBrack;
					Statement stmt = conn.createStatement();
        			stmt.executeUpdate(insertCmd);
			} else if (numId == 2) {
				String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  + "Password Validation Error"  + "'"  + endValueBrack;
				Statement stmt = conn.createStatement();
    			stmt.executeUpdate(insertCmd);
			} else if (numId == 3) {
				String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  + "DOB Validation Error"  + "'"  + endValueBrack;
				Statement stmt = conn.createStatement();
    			stmt.executeUpdate(insertCmd);
			} else if (numId == 4) {
				String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  + "E-Mail Validation Error"  + "'"  + endValueBrack;
				Statement stmt = conn.createStatement();
    			stmt.executeUpdate(insertCmd);
			} else if (numId == 5) {
				String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  + "Mobile Validation Error"  + "'"  + endValueBrack;
				Statement stmt = conn.createStatement();
    			stmt.executeUpdate(insertCmd);
			} else if (numId == 6) {
				String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  + "Gender Validation Error"  + "'"  + endValueBrack;
				Statement stmt = conn.createStatement();
    			stmt.executeUpdate(insertCmd);
			} else if (numId == 7) {
				String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  + "Category Validation Error"  + "'"  + endValueBrack;
				Statement stmt = conn.createStatement();
    			stmt.executeUpdate(insertCmd);
			} else if (numId == 8) {
				String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  + "HospName Validation Error"  + "'"  + endValueBrack;
				Statement stmt = conn.createStatement();
    			stmt.executeUpdate(insertCmd);
			}
			conn.close();
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
	}
	
	
	//Login Screen Error Handler Table
	public static void loginError(int numId, String Category) {
		Connection conn;
		try {
			conn = Connector.getConnection();
			String insertTbl = "INSERT INTO DH_LOGIN_ERROR_1 (UNIQUE_ID, DESCRIPTION, CATEGORY) VALUES(";
			String autoIncrementID = "ERROR_IDENTIFIER.NEXTVAL";
			String endValueBrack = ")";
			
				if (numId == 1)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +"Wrong EmailID and Password"  + "'" +"," 
												                           +"'"  + Category +"'" + endValueBrack;
					System.out.println(insertCmd);
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				else if (numId == 2)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +"No EmailId Found"  + "'"  +","  
																		   +"'"  + Category +"'" + endValueBrack;
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				else if (numId == 3)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  + "Account Locked"  + "'"  + ","
																		   +"'"  + Category +"'" + endValueBrack;
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				conn.close();
			}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

	// Empty Fields Handler
		public static void emptyFieldsHandler(int numId, String Screen_Name)
		{
			Connection conn;
			try {
				conn = Connector.getConnection();
				String insertTbl = "INSERT INTO DH_EMPTY_FIELDS_1 (UNIQUE_ID, DESCRIPTION, SCREEN_NAME) VALUES(";
				String autoIncrementID = "ERROR_IDENTIFIER.NEXTVAL";
				String endValueBrack = ")";
			
				if (numId == 1)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +"EmailID Empty"  + "'" +"," 
												                           +"'"  + Screen_Name +"'" + endValueBrack;
					
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				else if (numId == 2)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +"EmailID @ Symbol"  + "'" +"," 
												                           +"'"  + Screen_Name +"'" + endValueBrack;
					
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				else if (numId == 3)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +"Domain Not Selected"  + "'" +"," 
												                           +"'"  + Screen_Name +"'" + endValueBrack;
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				else if (numId == 4)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +"Password Empty"  + "'" +"," 
												                           +"'"  + Screen_Name +"'" + endValueBrack;
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				else if (numId == 5)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +"Category Not Selected"  + "'" +"," 
												                           +"'"  + Screen_Name +"'" + endValueBrack;
					
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				else if (numId == 6)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +"Name Filled As Empty"  + "'" +"," 
												                           +"'"  + Screen_Name +"'" + endValueBrack;
					
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				else if (numId == 7)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +"Password Mismatch"  + "'" +"," 
												                           +"'"  + Screen_Name +"'" + endValueBrack;
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				else if (numId == 8)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +"DOB Empty"  + "'" +"," 
												                           +"'"  + Screen_Name +"'" + endValueBrack;
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				else if (numId == 9)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +"Phone Number Empty"  + "'" +"," 
												                           +"'"  + Screen_Name +"'" + endValueBrack;
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				else if (numId == 10)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +"Invalid EmailID - No @ Used"  + "'" +"," 
												                           +"'"  + Screen_Name +"'" + endValueBrack;
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				else if (numId == 11)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +"Invalid Phone Number "  + "'" +"," 
												                           +"'"  + Screen_Name +"'" + endValueBrack;
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				else if (numId == 12)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +"Gender Not Filled "  + "'" +"," 
												                           +"'"  + Screen_Name +"'" + endValueBrack;
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				else if (numId == 13)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +"Doctor Category Not Filled "  + "'" +"," 
												                           +"'"  + Screen_Name +"'" + endValueBrack;
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				else if (numId == 14)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +"Hospital Name Not Filled "  + "'" +"," 
												                           +"'"  + Screen_Name +"'" + endValueBrack;
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				else if (numId == 15)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +"Medical Option Not Selected "  + "'" +"," 
												                           +"'"  + Screen_Name +"'" + endValueBrack;
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				else if (numId == 16)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +"Either Location or ZipCode not Selected"  + "'" +"," 
												                           +"'"  + Screen_Name +"'" + endValueBrack;
					
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				else if (numId == 17)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +"Start Date Not Selected"  + "'" +"," 
												                           +"'"  + Screen_Name +"'" + endValueBrack;
					
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				else if (numId == 18)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +"End Date Not Selected"  + "'" +"," 
												                           +"'"  + Screen_Name +"'" + endValueBrack;
					
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				else if (numId == 19)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +"Issue Description Not Filled"  + "'" +"," 
												                           +"'"  + Screen_Name +"'" + endValueBrack;
				
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				else if (numId == 20)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +"Priority Not Filled"  + "'" +"," 
												                           +"'"  + Screen_Name +"'" + endValueBrack;
				
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				else if (numId == 21)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +"ReValidate Contents "  + "'" +"," 
												                           +"'"  + Screen_Name +"'" + endValueBrack;
					
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				else if (numId == 22)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +"Hosp Search Loction Or ZipCode Empty "  + "'" +"," 
												                           +"'"  + Screen_Name +"'" + endValueBrack;
					
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				else if (numId == 23)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +"Admin Ticket Selection Status Empty"  + "'" +"," 
												                           +"'"  + Screen_Name +"'" + endValueBrack;
					
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				else if (numId == 24)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +"Admin Ticket Selection Priority Empty"  + "'" +"," 
												                           +"'"  + Screen_Name +"'" + endValueBrack;
					
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				else if (numId == 25)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +" Ticket Number Empty "  + "'" +"," 
												                           +"'"  + Screen_Name +"'" + endValueBrack;
					
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				else if (numId == 26)
				{
					String insertCmd = insertTbl + autoIncrementID  + ","  +"'"  +" Appointment Book Date Empty "  + "'" +"," 
												                           +"'"  + Screen_Name +"'" + endValueBrack;
					
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertCmd);
				}
				
				conn.close();
			}
			
			catch (Exception e)
			{
				
			}
		}

		
		//SQL Error Trapping Error
		public static void SQLSyntaxErrorMessage(String Error_Message, String Syntax, String Screen)
		{
			Connection conn;
			try {
				conn = Connector.getConnection();
				String insertTbl = "INSERT INTO DH_SQL_ERRORS_1 (UNIQUE_ID, DESCRIPTION, SYNTAX ,ERROR_FROM) VALUES(";
				String autoIncrementID = "ERROR_IDENTIFIER.NEXTVAL";
				String endValueBrack = ")";
				String insertCmd = insertTbl + autoIncrementID  + ","  
													+"'"  + Error_Message + "'" +"," 
													+"'"  + Syntax        +"'"  +"," 
													+"'"  + Screen        +"'"  
													+ endValueBrack;
				System.out.println(insertCmd);
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(insertCmd);
				conn.close();
			}
			catch
			(Exception e)
			{
				System.out.println(e);
			}
		}
		
		
		//Book  User appointment
		public static void bookappointment(String hospital, String date,String slot,int cat,String mail,String docmail,String hid)
		{
			Connection conn;
			try {
				conn = Connector.getConnection();
				String insertapt = "INSERT INTO DH_APPOINTMENT (AID,H_ID,HOSPITAL_NAME,DATE_SCHEDULED,TIME_SLOT,U_EMAIL_ID,CATEGORY,D_EMAIL_ID) VALUES(";
				String aID = "APPOINTMENT.NEXTVAL";
				String endValueBrack = ")";
				
				String insertCmd = insertapt + aID  + ","  
													+"'"  + hid      + "'" +"," 
													+"'"  + hospital + "'" +"," 
													+"'"  + date      +"'"  +"," 
													+"'"  + slot        +"',"
													+"'"  + mail        +"',"
													+ cat+","+"'"+docmail+"'"+endValueBrack;
				System.out.println(insertCmd);
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(insertCmd);
				conn.close();
			}
			catch
			(Exception e)
			{
				System.out.println(e);
			}
		}
		
		//Cancel an Users Appointment
		public static void cancelappointment(String dte,String time,String hosp,String uname)
		{
			Connection conn;
			try {
				String sqlSearch = "DELETE FROM DH_APPOINTMENT WHERE DATE_SCHEDULED="+ "'"+dte+"'"
						+"AND HOSPITAL_NAME="+"'"+hosp+"'" +"AND U_EMAIL_ID ="+"'"+uname+"'"+"AND TIME_SLOT="+"'"+time+"'";
				conn = Connector.getConnection();
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sqlSearch);
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		
		//Feedback Updates
		public static void feedbackComments(String Comments)
		{
			Connection conn;
			try {
				conn = Connector.getConnection();
				String insertapt = "INSERT INTO DH_FEEDBACK (COMMENTS) VALUES(";
				String endValueBrack = ")";
				String insertCmd = insertapt + "'" + Comments + "'"
											+ endValueBrack;
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(insertCmd);
				conn.close();
			}
			catch
			(Exception e)
			{
				System.out.println(e);
			}
		}
}

