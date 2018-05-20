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

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import Dr.Help.Admin_Screen;
import Dr.Help.IssueDescription;
import Dr.Help.Login_All;
import Dr.Help.Management_Report;
import Dr.Help.appointment;
import ErrorHandler.Login_Error;
import View.Admin_Select_DDL;

public class ResultSetFetch 
{ //RS -S
	
	// Declare necessary variables 
	static	ResultSet rs;
	static int EmailID_Check;
	static String PasswordFromDB;
	static int TicketID_Validate;
	
	
	//Create Ref objects for Errors
	static Login_Error LE = new Login_Error();
	static Admin_Select_DDL ASDDL = new Admin_Select_DDL();
	
	
	// Validate Login Details depending upon Category
	public static  ResultSet  getLoginDetails(String EmailId, String Password, String Category) throws Exception
	{ // AccountStat - S
			System.out.println(Category);
			
			// If Login is a USER then
			if(Category.equals("USER"))
			 { //If 1.0 -S
				
					
					String result =(getEmailCount(Category, EmailId)); // Check for the Category and EmailID  is available or not
					/*System.out.println("Method Over Now Results");
					System.out.println("Password from DB is "+result);
					System.out.println("Password From LoginScreen is "+Password);*/
					
					if(result.equals(Password))
					{ //If 1.1 -S
						System.out.println("Password Validation done");
						String AccountLocked = getAccountStatus(Category,EmailId); // Check if Account is Locked or Not
							
						if(AccountLocked.equals("N"))
							{//If 1.1.1 -S
								new IssueDescription(); //Redirect to User Next Page
								updateLoginTime(Category, EmailId); //Update Login Time for User
							}//If 1.1.1 -E
							
							else
							{//else 1.1.1 -S
								JOptionPane.showMessageDialog(null, "Your Account is Locked. Please Raise a Request To Get Your Account Unlocked");
								LE.accountLockedUser();
								new Login_All(); //Redirect to Login Page
							}//else 1.1.1 -E
							
					}//If 1.1 -E
					else if(result.equals("0"))
					{
						JOptionPane.showMessageDialog(null, "UserName Not Found. Please Register Yourself To Access Dr.Help");
						LE.wrongDomainLoginUser(); //Log error
						new Login_All();
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Incorrect Password For the Registered User. Please Try Again");
						LE.wrongEmailIDAndPasswordUser(); //Log error
						new Login_All();
					}
					
			  }//If 1.0 -E
					
			
			//If Category is Doctor
			else if(Category.equals("DOCTOR"))
			{ //else if 2.0 -S
				System.out.println("Searching Doctor Table");
				String result =(getEmailCount(Category, EmailId)); // Check for the Category and EmailID  is available or not
			/*	System.out.println("Method Over Now Results");
				System.out.println("Password from DB is "+result);*/
				/*System.out.println("Password From LoginScreen is "+Password);*/
				
				if(result.equals(Password))
				{ //If 2.1 -S
				    	System.out.println("Password Validation done");
						String AccountLocked = getAccountStatus(Category,EmailId);  // Check if Account is Locked or Not
							if(AccountLocked.equals("N"))
							{//If 2.1.1 -S
								updateLoginTime(Category, EmailId);//Update Login Time for Doc
								new appointment(); //Redirect to Doc Page
							}//If 2.1.1 -E
							
							else
							{//else 2.1.1 -S
								JOptionPane.showMessageDialog(null, "Your Account is Locked. Please Raise a Request To Get Your Account Unlocked");
								LE.accountLockedUserDoc();
								new Login_All();
							}//else 2.1.1 -S
							
				} //If 2.1 -E
				else if(result.equals("0"))
					{
						JOptionPane.showMessageDialog(null, "DoctorName Not Found. Please Register Yourself To Access Dr.Help");
						LE.wrongDomainLoginUserDoc();
						new Login_All();
					}
					else 
					{ //else 2.1 -S
						JOptionPane.showMessageDialog(null, "Incorrect Password For the Registered User. Please Try Again");
						LE.wrongEmailIDAndPasswordDoc();
						new Login_All();
					}//else 2.1 -E
					
				
			}//else if 2.0 -E
			
			
			// IF Management login
			else if(Category.equals("MANAGEMENT"))
			{//else if 3.0 -S
				System.out.println("Searching MANAGER Table");
				String result =(getEmailCount(Category, EmailId)); // Check for the Category and EmailID  is available or not
				/*System.out.println("Method Over Now Results");
				System.out.println("Password from DB is "+result);
				System.out.println("Password From LoginScreen is "+Password);*/
				
				if(result.equals(Password))
				{ // if 3.1 - S
					System.out.println("Password Validation done");
					System.out.println("Password Validation done");
					String AccountLocked = getAccountStatus(Category,EmailId);  // Check if Account is Locked or Not
						if(AccountLocked.equals("N"))
						{// if 3.1.1 - S
							updateLoginTime(Category, EmailId); //Update Login Time for Manager
							new Management_Report(); //Redirect to Management Page
						}// if 3.1.1 - E
						
						else
						{// else 3.1.1 - S
							JOptionPane.showMessageDialog(null, "Your Account is Locked. Please Raise a Request To Get Your Account Unlocked");
							LE.accountLockedMgmt();
							new Login_All(); //Redirect to Login Page
						}// else 3.1.1 - S
						
				} // if 3.1 - E
				
				else if(result.equals("0"))
				{ // elseif 3.2 - S
					JOptionPane.showMessageDialog(null, "Manager Name Not Found. Please Register Yourself To Access Dr.Help");
					LE.wrongDomainLoginMgmt(); // Log Error
					new Login_All();
				}// elseif 3.2 - E
				else 
				{// else 3.1 - S
					JOptionPane.showMessageDialog(null, "Incorrect Password For the Registered User. Please Try Again");
					LE.wrongEmailIDAndPasswordMgmt(); // Log Error
					new Login_All();
				}// else 3.1 - E
				
			}//else if 3.0 -e
			
			
			// IF Admin Loging
			else if(Category.equals("ADMIN"))
			{//else if 4.0 -S
				System.out.println("Searching Admin Table");
				String result =(getEmailCount(Category, EmailId)); // Check for the Category and EmailID  is available or not
				/*System.out.println("Method Over Now Results");
				System.out.println("Password from DB is "+result);
				System.out.println("Password From LoginScreen is "+Password);*/
				
				if(result.equals(Password))
				{// if 4.1 -S
					
					System.out.println("Password Validation done");
					String AccountLocked = getAccountStatus(Category,EmailId);  // Check if Account is Locked or Not
						if(AccountLocked.equals("N"))
						{// if 4.1.1 -S
							updateLoginTime(Category, EmailId);  //Update Login Time for Admin
							new Admin_Screen(); // Move to Admin Screen
							
							
						}// if 4.1.1 -E
						else
						{
							JOptionPane.showMessageDialog(null, "Your Account is Locked. Please Raise a Request To Get Your Account Unlocked");
							LE.accountLockedAdmin(); //Log error
							new Login_All();
						}
				}// if 4.1 -E
				
				else if(result.equals("0"))
				{// elseif 4.1 -S
					JOptionPane.showMessageDialog(null, "Admin Name Not Found. Please Register Yourself To Access Dr.Help");
					LE.wrongDomainLoginAdmin(); //Log error
					new Login_All();
				}// elseif 4.1 -E
				else 
				{// else 4.1 - S
					JOptionPane.showMessageDialog(null, "Incorrect Password For the Registered User. Please Try Again");
					LE.wrongEmailIDAndPasswordAdmin(); //Log error
					new Login_All();
				}// else 4.1 - E
				
			} //else if 4.0 -E
		
			else
			{
				System.out.println("No Errors");
			}
			return null;
		} // AccountStat - S
		
		
		
		
	
	//Login Access to check if Email is available or not
	private static  String getEmailCount(String Category, String EmailId) throws Exception 
	{
	
		System.out.println("Searching " + Category + " Table");
		Connection conn = Models.Connector.getConnection();
			String sqlSearch = "SELECT COUNT(*)C FROM "
								+ "DH_"  + Category+"S_1" 
								+ " WHERE" + " EMAIL_ID" + "=" + "'"+ EmailId+"'" ;
		
		Statement stmt = conn.prepareStatement(sqlSearch);
		rs = stmt.executeQuery(sqlSearch);
		while(rs.next())
		{
			EmailID_Check = rs.getInt("C");
		}
		
		if(EmailID_Check == 1)
		{
			System.out.println("Going For PD Verification");
			PasswordFromDB=getPasswordValidation(Category, EmailId); //If Yes,the go for Password Validation
			return PasswordFromDB;
		}
		else
			return "0";
	}
	
	//Password Validation to return with MD-5  hashing
	private static String getPasswordValidation(String Category, String EmailId) throws Exception
	{
		
		Connection conn = Models.Connector.getConnection();
		String sqlSearch="SELECT PASSWORD FROM " 
						 +"DH_"+ Category+"S_1" 
						 + " WHERE EMAIL_ID =" + "'"+EmailId +"'";
		Statement stmt = conn.prepareStatement(sqlSearch);
		rs = stmt.executeQuery(sqlSearch);
		while(rs.next())
		{
			return rs.getString("PASSWORD");
			
		}
		return "1";
	}
	
	
	//Check If Account is Locked or Not
	private static String getAccountStatus(String Category, String EmailId) throws Exception 
	{
		Connection conn = Models.Connector.getConnection();
		String sqlSearch = "SELECT ACCOUNT_LOCKED FROM DH_"
						  		+ Category + "S_1" 
						  		+ " WHERE EMAIL_ID ='"
						  		+ EmailId +"'";
		Statement stmt = conn.prepareStatement(sqlSearch);
		rs = stmt.executeQuery(sqlSearch);
		while(rs.next())
		{
			return rs.getString("ACCOUNT_LOCKED");
		}
				
		return "3";
	}
	
	
	//Update Login time for each Login
	public static void updateLoginTime(String Category, String EmailId) throws Exception
	{
	
		Connection conn = Models.Connector.getConnection();
		String sqlSearch = "UPDATE DH_"+ Category +"S_1" 
							+ " SET LAST_LOGIN = SYSTIMESTAMP"
							+" WHERE EMAIL_ID =" +"'" + EmailId +"'";
		Statement stmt = conn.prepareStatement(sqlSearch);
		stmt.executeQuery(sqlSearch);
		
	}
	
	
	//Update Login time for each Login
		public static void updateLogoutTime(String Category, String EmailId) throws Exception
		{
		
			Connection conn = Models.Connector.getConnection();
			String sqlSearch = "UPDATE DH_"+ Category +"S_1" 
								+ " SET LAST_LOGOUT = SYSTIMESTAMP"
								+" WHERE EMAIL_ID =" +"'" + EmailId +"'";
			Statement stmt = conn.prepareStatement(sqlSearch);
			stmt.executeQuery(sqlSearch);
			
		}
	// Get Hosp Details depending upon Location
	public static ResultSet getMedRecordsByLoc(String tLocName) throws Exception {
		try {
			Connection conn = Models.Connector.getConnection();
			String selectStat = "SELECT "
								+ "HOSPITAL_NAME,ADDRESS,CITY,STATE,ZIPCODE,PHONE_NUMBER "
								+ "FROM DH_HOSPLIST_1 "
								+ " WHERE CITY LIKE '" + tLocName.toUpperCase() +"%'" ;
			System.out.println(selectStat);
			Statement stat = conn.prepareStatement(selectStat);
			rs = stat.executeQuery(selectStat);
			System.out.println("Fetched Results from DB");
			

		} catch (Exception e) {
			System.out.println(e);
		}
		return rs;
	}

	// Get Hosp Details depending upon ZipCode
	public static ResultSet getMedRecordsByZip(String tZipCode) throws Exception {
		try {
			Connection conn = Models.Connector.getConnection();
			String selectStat = "SELECT "
								+ "HOSPITAL_NAME,ADDRESS,CITY,STATE,ZIPCODE,PHONE_NUMBER "
								+ "FROM DH_HOSPLIST_1 "
								+ " WHERE ZIPCODE ='" + tZipCode +"'";
			System.out.println(selectStat);
			Statement stat = conn.prepareStatement(selectStat);
			rs = stat.executeQuery(selectStat);
			System.out.println("Fetched Results from DB");
			

		} catch (Exception e) {
			System.out.println(e);
		}
		return rs;
	}

	//Get Doctors List along with Salary, Rating,  Active 
	public static ResultSet getDocList(String Start_Date, String End_Date) throws Exception {
		try {
			Connection conn = Models.Connector.getConnection();
			String selectStat = "SELECT "
								+"NAME, ADDRESS, CITY, COUNTY, STATE, ZIP, MOBILE, EMAIL_ID,"
								+"DATE_OF_JOIN, CATEGORY, SALARY, RATING, ACTIVE"
								+ " FROM DH_DOC_LIST_1 "
								+ "  WHERE DATE_OF_JOIN BETWEEN TO_DATE('" + Start_Date +"', 'MM-DD-YY')" 
								+ "AND TO_DATE('"+ End_Date +"', 'MM-DD-YY')";
			System.out.println(selectStat);
			Statement stat = conn.prepareStatement(selectStat);
			rs = stat.executeQuery(selectStat);
			System.out.println("Fetched Results from DB");
			

		} catch (Exception e) {
			System.out.println(e);
		}
		return rs;
	}
	
	
	//Get Hosp Details depending upon the Venture Data
	public static ResultSet getHospVenture(String Start_Date, String End_Date) throws Exception {
		try {
			Connection conn = Models.Connector.getConnection();
			String selectStat = "SELECT "
								+"HOSPITAL_NAME, ADDRESS, CITY, STATE, ZIPCODE, PHONE_NUMBER, DATE_OF_VENTURE"
								+ " FROM DH_HOSP_VENTURE "
								+ "  WHERE DATE_OF_VENTURE BETWEEN TO_DATE('" 	+ Start_Date +"', 'MM-DD-YY')" 
								+ "AND TO_DATE('"+ End_Date +"', 'MM-DD-YY')";
			System.out.println(selectStat);
			Statement stat = conn.prepareStatement(selectStat);
			rs = stat.executeQuery(selectStat);
			System.out.println("Fetched Results from DB");
			

		} catch (Exception e) {
			System.out.println(e);
		}
		return rs;
	}
	
	// Get Hosp List based on Category
	public static ResultSet getHospCategory(int Count) throws Exception {
		try {
			Connection conn = Models.Connector.getConnection();
			String selectStat = "SELECT "
								+"H_ID, HOSPITAL_NAME, ADDRESS, CITY, STATE, ZIPCODE, PHONE_NUMBER "
								+ " FROM DH_HOSPLIST_1 "
								+ "  WHERE CATEGORY = " + Count + "ORDER BY 1 ASC" ;
			System.out.println(selectStat);
			Statement stat = conn.prepareStatement(selectStat);
			rs = stat.executeQuery(selectStat);
			System.out.println("Fetched Results from DB");
			

		} catch (Exception e) {
			System.out.println(e);
		}
		return rs;
	}
	
	// Get User Report List based on appointment Date
		public static ResultSet getUserAppointment(String Start_Date, String End_Date) throws Exception {
			try {
				Connection conn = Models.Connector.getConnection();
				String selectStat = "SELECT "
									+"AID,HOSPITAL_NAME, DATE_SCHEDULED, TIME_SLOT,U_EMAIL_ID, D_EMAIL_ID, CATEGORY,"
									+"DIAGONSIS, DRUG_PRESCRIBED,NEXT_VISIT,REFER_TO,COMMENTS"
									+ " FROM DH_APPOINTMENT "
									+ "  WHERE "
									+ " DATE_SCHEDULED BETWEEN TO_CHAR(TO_DATE('" + Start_Date +"','MM-DD-YY'))"
									+ " AND TO_CHAR(TO_DATE('" + End_Date +"','MM-DD-YY')) ORDER BY 1 DESC"; 
									
				
				System.out.println(selectStat);
				Statement stat = conn.prepareStatement(selectStat);
				rs = stat.executeQuery(selectStat);
				System.out.println("Fetched Results from DB");
				

			} catch (Exception e) {
				System.out.println(e);
			}
			return rs;
		}
	
	
	
	
	//Fetch Admin Tickets 
	public static ResultSet admin_Tickets(String Status, String Priority) throws Exception {
		try {
			Connection conn = Models.Connector.getConnection();
			String selectStat = "SELECT "
								+"TICKET_NUMBER, RAISED_BY, CONTACT_NUMBER, ISSUE_CATEGORY, "
								+ "ISSUE_DESCRIPTION,PRIORITY_LEVEL, DATE_SUBMITTED, SLA_DAYS, HOURS_REMAINING, STATUS "
								+ " FROM DH_ADMIN_TICKETS "
								+ "  WHERE STATUS = "    +"'"   + Status  +"'"  
								+ " AND PRIORITY_LEVEL  = "           + Priority ;
			System.out.println(selectStat);
			Statement stat = conn.prepareStatement(selectStat);
			rs = stat.executeQuery(selectStat);
			System.out.println("Fetched Results from DB");
			

		} catch (Exception e) {
			System.out.println(e);
		}
		return rs;
	}
	
	
	// SQL Syntax Syntax validator from DDL
		public static  void validateSQLQueryDDL(String Statment, String Screen, String TicketNumber) throws Exception {
			try {

				Connection conn = Models.Connector.getConnection();
				String ValidateSQLStatement= Statment;
				Statement stmt = conn.createStatement();
				System.out.println(ValidateSQLStatement);
				int result = stmt.executeUpdate(ValidateSQLStatement);
				System.out.println("Statement "+ result);
				if (result == 1) 
				{
					JOptionPane.showMessageDialog(null, "SQL Query Executed Successfully");
					updateClosedTicketTime(TicketNumber,Login_All.UserName);
					new Admin_Screen();
				} 
				
			}
				catch (Exception e)
			{
				System.out.println("Error");
				InsertInToDB.SQLSyntaxErrorMessage(e.getMessage(), Statment, Screen);
				JOptionPane.showMessageDialog(null, "Syntax Error. Please Check DH_SQL_ERRORS_1 Table For More Details");
					
			}
			
		}
			
	
			// SQL Syntax Syntax validator from DML
		public static  void validateSQLQueryDML(String Statment, String Screen, String TicketNumber) throws Exception {
			try {

				Connection conn = Models.Connector.getConnection();
				String ValidateSQLStatement= Statment;
				Statement stmt = conn.createStatement();
				
				int result = stmt.executeUpdate(ValidateSQLStatement);
				System.out.println("Statement "+ result);
				if (result == 0) 
				{
					JOptionPane.showMessageDialog(null, "SQL Query Executed Successfully");
					updateClosedTicketTime(TicketNumber,Login_All.UserName);
					new Admin_Screen();
				
				} 
				
			}
				catch (Exception e)
			{
				
				InsertInToDB.SQLSyntaxErrorMessage(e.getMessage(), Statment, Screen);
				JOptionPane.showMessageDialog(null, "Syntax Error. Please Check DH_SQL_ERRORS_1 Table For More Details");
					
			}
			
		}
		
		
		// SQL Select Statement After Validating SQL Query 
		public static void validateSQLQuerySelect(String Statment, String Screen, String TicketNumber) throws Exception {
			try {

				Connection conn = Models.Connector.getConnection();
				String ValidateSQLStatement= Statment;
				Statement stmt = conn.createStatement();
				System.out.println(ValidateSQLStatement);
				int result = stmt.executeUpdate(ValidateSQLStatement);
				System.out.println("Statement "+ result);
				ASDDL.Admin_Select_DDL(Statment, Screen, TicketNumber);
				updateClosedTicketTime(TicketNumber,Login_All.UserName);
				new Admin_Screen();
				
			}
				catch (Exception e)
			{
				
				InsertInToDB.SQLSyntaxErrorMessage(e.getMessage(), Statment, Screen);
				JOptionPane.showMessageDialog(null, "Syntax Error. Please Check DH_SQL_ERRORS_1 Table For More Details");
							
					
			}
			
		}
		
				
			//Validate Select Statement from DDL
			public static ResultSet admin_SelectDDL(String Statement, String Screen, String TicketNumber) throws Exception {
				try {
					Connection conn = Models.Connector.getConnection();
					String selectStat = Statement;
					System.out.println(selectStat);
					Statement stat = conn.prepareStatement(selectStat);
					rs = stat.executeQuery(selectStat);
					System.out.println("Fetched Results from DB");
					

				} catch (Exception e) {
					System.out.println(e);
				}
				return rs;
			}
	
		// SQL Syntax Syntax validator from DCL 
		public static  void validateSQLQueryDCL(String Statment, String Screen, String TicketNumber) throws Exception {
			try {

				Connection conn = Models.Connector.getConnection();
				String ValidateSQLStatement= Statment;
				Statement stmt = conn.createStatement();
				
				int result = stmt.executeUpdate(ValidateSQLStatement);
				System.out.println("Statement "+ result);
				if (result == 0) 
				{
					JOptionPane.showMessageDialog(null, "SQL Query Executed Successfully");
					updateClosedTicketTime(TicketNumber,Login_All.UserName);
					new Admin_Screen();
				
				} 
				
				
			}
				catch (Exception e)
			{
				
				InsertInToDB.SQLSyntaxErrorMessage(e.getMessage(), Statment, Screen);
				JOptionPane.showMessageDialog(null, "Syntax Error. Please Check DH_SQL_ERRORS_1 Table For More Details");
					
			}
					
				}				
		
	// Check whether Ticket Number is available or not
	public static  String validateTicketNumber(String TicketNumber) throws Exception 
	{
	
		System.out.println("Searching Admin Tickets Table");
		Connection conn = Models.Connector.getConnection();
			String sqlSearch = "SELECT COUNT(*)C FROM "
								+ "DH_ADMIN_TICKETS"   
								+ " WHERE" + " TICKET_NUMBER" + "=" + "'"+ TicketNumber+"'"
								+ " AND STATUS = 'Open'";
		
		Statement stmt = conn.prepareStatement(sqlSearch);
		rs = stmt.executeQuery(sqlSearch);
		while(rs.next())
		{
			TicketID_Validate = rs.getInt("C");
		}
		
		if(TicketID_Validate == 1)
		{
			return "1";
		}
		else
			return "0";
	}

	//Update Tickets when it is resolved
	private static void updateClosedTicketTime(String TicketNumber, String Name) throws Exception
	{
	
		Connection conn = Models.Connector.getConnection();
		String sqlSearch = "UPDATE DH_ADMIN_TICKETS" 
							+ " SET STATUS = 'Closed'"      +","
							+ "TIME_CLOSED = SYSTIMESTAMP"  +","
							+ "ASSIGNED_TO =" +"'" + Name +"'"
							+" WHERE  TICKET_NUMBER=" + TicketNumber ;
		Statement stmt = conn.prepareStatement(sqlSearch);
		stmt.executeQuery(sqlSearch);
		
	}
	
	
	//Domain List for Logging and Registration
	public static ResultSet domainList() throws Exception
	{
		Connection conn = Models.Connector.getConnection();
		String sqlSearch = "SELECT DOMAIN_NAME FROM DH_EMAIL_DOMAIN";
		Statement stmt = conn.prepareStatement(sqlSearch);
		rs=stmt.executeQuery(sqlSearch);
		return rs;
	}
	
	
	//MD-5 Algo for Password
	public static String get_SecurePassword(String passwordToHash) throws UnsupportedEncodingException
	{
		String generatedPassword = passwordToHash;
		System.out.println(passwordToHash);
		System.out.println(generatedPassword);
		    try {
		         MessageDigest md = MessageDigest.getInstance("SHA-256");
		         
		         byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
		         StringBuilder sb = new StringBuilder();
		         for(int i=0; i< bytes.length ;i++){
		            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		         }
		         generatedPassword = sb.toString();
		        } 
		       catch (NoSuchAlgorithmException e){
		        e.printStackTrace();
		       }
		    return generatedPassword;
	
	
		}
	
	//Get list of Hospitals depending upon the choice
	public static ResultSet hosplist(String cityname,int i,int j) throws Exception
	{
		Connection conn = Models.Connector.getConnection();
		String sqlSearch = "SELECT HOSPITAL_NAME FROM DH_HOSPLIST_1 WHERE CITY="+ "'"+cityname.toUpperCase()+"'"
		+"AND MEDICAL_INSURANCE="+i+"AND CATEGORY ="+j;
		Statement stmt = conn.prepareStatement(sqlSearch);
		rs=stmt.executeQuery(sqlSearch);
		return rs;
	}

	
	//Check available date for User to Book Appointment
	public static ResultSet checkdate(String hosp,String date) throws Exception
	{
		Connection conn = Models.Connector.getConnection();
		String sqlSearch = "SELECT TIME_SLOT FROM DH_APPOINTMENT WHERE HOSPITAL_NAME="+ "'"+hosp.toUpperCase()+"'"
		+"AND DATE_SCHEDULED="+"'"+date+"'";
		Statement stmt = conn.prepareStatement(sqlSearch);
		rs=stmt.executeQuery(sqlSearch);
		return rs;
	}
	
	//Fetch DocName and Doc Email for the respective Hosp, Login
	public static ResultSet getdoc(String hosp) throws Exception
	{
		Connection conn = Models.Connector.getConnection();
		String sqlSearch = "SELECT DOCTOR_NAME, DOCTOR_EMAIL_ID, H_ID FROM DH_HOSPLIST_1 WHERE HOSPITAL_NAME="+ "'"+hosp.toUpperCase()+"'";
		Statement stmt = conn.prepareStatement(sqlSearch);
		System.out.println(sqlSearch);
		rs=stmt.executeQuery(sqlSearch);
		return rs;
	}
 
	
	 
	
	//Get User Appointment Summary
		public static ResultSet getsummary(String dte,String time,String hosp,String uname) throws Exception
		{
			Connection conn = Models.Connector.getConnection();
			String sqlSearch = "SELECT * FROM DH_APPOINTMENT WHERE DATE_SCHEDULED="+ "'"+dte+"'"
			+"AND HOSPITAL_NAME="+"'"+hosp+"'" +"AND U_EMAIL_ID ="+"'"+uname+"'"+"AND TIME_SLOT="+"'"+time+"'";
			Statement stmt = conn.prepareStatement(sqlSearch);
			rs=stmt.executeQuery(sqlSearch);
			
			return rs;
		}
		
		//Fetch respective appointment details for the time slot and date 
		public static ResultSet selapp(String dname,String date, String tslot) throws Exception
		{
		Connection conn = Models.Connector.getConnection();
		String sqlSearch = "SELECT AID, U_EMAIL_ID, DIAGONSIS, DRUG_PRESCRIBED, NEXT_VISIT, REFER_TO FROM DH_APPOINTMENT WHERE D_EMAIL_ID="+ "'"+dname+"'"
		+" AND DATE_SCHEDULED="+"'"+date+"'"+ " AND TIME_SLOT = '" + tslot + "'";
		Statement stmt = conn.prepareStatement(sqlSearch);
		rs=stmt.executeQuery(sqlSearch);
		return rs;
		}
		
		//Select User name to be displayed in the screen of Doc's appointment
		public static ResultSet selusr(String uEmail) throws Exception
		{
		Connection conn = Models.Connector.getConnection();
		String sqlSearch = "SELECT NAME FROM DH_USERS_1 WHERE EMAIL_ID="+ "'"+uEmail+"'";
		Statement stmt = conn.prepareStatement(sqlSearch);
		rs=stmt.executeQuery(sqlSearch);
		return rs;
		}
		
		
		//Check available time slot for the respective date, doctor
		public static ResultSet checkapp(String dname,String date) throws Exception
		{
		Connection conn = Models.Connector.getConnection();
		String sqlSearch = "SELECT TIME_SLOT FROM DH_APPOINTMENT WHERE D_EMAIL_ID="+ "'"+dname+"'"
		+"AND DATE_SCHEDULED="+"'"+date+"'";
		Statement stmt = conn.prepareStatement(sqlSearch);
		rs=stmt.executeQuery(sqlSearch);
		return rs;
		}
		
		
		// Fetch Doc name to be displayed in the Screen
		public static ResultSet docname(String dname) throws Exception
		{
		Connection conn = Models.Connector.getConnection();
		String sqlSearch = "SELECT NAME FROM DH_DOCTORS_1 WHERE EMAIL_ID="+ "'"+dname+"'";
		Statement stmt = conn.prepareStatement(sqlSearch);
		rs=stmt.executeQuery(sqlSearch);
		return rs;
		}
		
		//Updates user medical records If date is given
		public static void updateApp(String dname,String date, String tslot, String dia,String drugs, String nVisit,String rTo ) throws Exception 
		{

			Connection conn = Models.Connector.getConnection();
			String sqlSearch = "UPDATE DH_APPOINTMENT " + " SET DIAGONSIS ="+"'"+ dia +"'" + "," + " DRUG_PRESCRIBED ="+"'"+drugs+"'"+"," + " NEXT_VISIT = "+"'"+nVisit+"'"+"," +" REFER_TO ="+"'"+rTo+"'"
					+ " WHERE D_EMAIL_ID="+ "'"+dname+"'" + 
					" AND DATE_SCHEDULED="+"'"+date+"'"+ " AND TIME_SLOT = '" + tslot + "'";
			System.out.println(sqlSearch);
			Statement stmt = conn.prepareStatement(sqlSearch);
			stmt.executeQuery(sqlSearch);
		
		}
		
		//Updates user medical records If date is not given
		public static void updateApp1(String dname,String date, String tslot, String dia,String drugs, String rTo ) throws Exception 
		{

			Connection conn = Models.Connector.getConnection();
			String sqlSearch = "UPDATE DH_APPOINTMENT " + " SET DIAGONSIS ="+"'"+ dia +"'" + "," + " DRUG_PRESCRIBED ="+"'"+drugs+"'"+"," +" REFER_TO ="+"'"+rTo+"'"
					+ " WHERE D_EMAIL_ID="+ "'"+dname+"'" + 
					" AND DATE_SCHEDULED="+"'"+date+"'"+ " AND TIME_SLOT = '" + tslot + "'";
			System.out.println(sqlSearch);
			Statement stmt = conn.prepareStatement(sqlSearch);
			stmt.executeQuery(sqlSearch);
		
		}


	
}//RS -E