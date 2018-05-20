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

package ErrorHandler;

public class Login_Error {

	
	/*
	 * 
	 * USER Error Handler
	 */

	//If Wrong Cate Login for User
	public void wrongEmailIDAndPasswordUser()
	{
		Models.InsertInToDB.loginError(1, "USER");
	}
	
	//If Wrong Domain Login for User
	public void wrongDomainLoginUser()
	{
		Models.InsertInToDB.loginError(2, "USER");
	}
	
	//If Account Locked For User
	public void accountLockedUser()
	{
		Models.InsertInToDB.loginError(3, "USER");
	}
	
	
	/*
	 * 
	 * Doc Error Handler
	 */

	
	
	//If Wrong Cate Login for Doctor
	public void wrongEmailIDAndPasswordDoc()
	{
		Models.InsertInToDB.loginError(1, "DOC");
	}
	
	//If Wrong Domain Login for Doctor
	public void wrongDomainLoginUserDoc()
	{
		Models.InsertInToDB.loginError(2, "DOC");
	}
	
	//If Account Locked For Doctor
	public void accountLockedUserDoc()
	{
		Models.InsertInToDB.loginError(3, "DOC");
	}
	
	
	/*
	 * 
	 * Mgmt Error Handler
	 */

	
	//If Wrong Cate Login for Manager
	public void wrongEmailIDAndPasswordMgmt()
	{
		Models.InsertInToDB.loginError(1, "MGMT");
	}
	
	//If Wrong Domain Login for Manager
	public void wrongDomainLoginMgmt()
	{
		Models.InsertInToDB.loginError(2, "MGMT");
	}
	
	//If Account Locked For Doctor
	public void accountLockedMgmt()
	{
		Models.InsertInToDB.loginError(3, "MGMT");
	}
	
	/*
	 * 
	 * Admin Error Handler
	 */

	//If Wrong Cate Login for Admin
	public void wrongEmailIDAndPasswordAdmin()
	{
		Models.InsertInToDB.loginError(1, "Admin");
	}
	
	//If Wrong Domain Login for Manager
	public void wrongDomainLoginAdmin()
	{
		Models.InsertInToDB.loginError(2, "Admin");
	}
	
	//If Account Locked For Doctor
	public void accountLockedAdmin()
	{
		Models.InsertInToDB.loginError(3, "Admin");
	}
	
	

	
	
}
