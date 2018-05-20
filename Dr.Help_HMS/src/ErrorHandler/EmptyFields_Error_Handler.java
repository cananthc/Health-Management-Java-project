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

public class EmptyFields_Error_Handler 
{

	/*
	 * 
	 *  Common Empty Fields Handler For All Signup
	 */
	public void EmailId_Empty(String Screen)
	{
		Models.InsertInToDB.emptyFieldsHandler(1, Screen);
	
	}
	
	public void EmailId_Symbol(String Screen)
	{
		Models.InsertInToDB.emptyFieldsHandler(2, Screen);
	
	}
	
	public void domainEmpty(String Screen)
	{
		Models.InsertInToDB.emptyFieldsHandler(3, Screen);
	
	}
	
	public void PasswordEmpty(String Screen)
	{
		Models.InsertInToDB.emptyFieldsHandler(4, Screen);
	
	}
	
	public void CategoryEmpty(String Screen)
	{
		Models.InsertInToDB.emptyFieldsHandler(5, Screen);
	
	}
	
	
	
	
	
	
	/*
	 * 
	 *  Signup Common Fields
	 */
	
	public void NameEmpty(String Screen)
	{
		Models.InsertInToDB.emptyFieldsHandler(6, Screen);
	
	}
	
			
	public void PasswordMisMatch(String Screen)
	{
		Models.InsertInToDB.emptyFieldsHandler(7, Screen);
	
	}
	
	public void DOBEmpty(String Screen)
	{
		Models.InsertInToDB.emptyFieldsHandler(8, Screen);
	
	}
	
	public void PhoneNumberEmpty(String Screen)
	{
		Models.InsertInToDB.emptyFieldsHandler(9, Screen);
	
	}
	
	public void InvalidEmailID(String Screen)
	{
		Models.InsertInToDB.emptyFieldsHandler(10, Screen);
	
	}
	
	public void PhoneNumberInvalid(String Screen)
	{
		Models.InsertInToDB.emptyFieldsHandler(11, Screen);
	
	}
	
	public void GenderEmpty(String Screen)
	{
		Models.InsertInToDB.emptyFieldsHandler(12, Screen);
	
	}
	
	/*
	 * New Doctor Signup Empty Fields Handler
	 * 
	 */
	
	public void docCateEmpty(String Screen)
	{
		Models.InsertInToDB.emptyFieldsHandler(13, Screen);
	}
	
	public void docHospEmpty(String Screen)
	{
		Models.InsertInToDB.emptyFieldsHandler(14, Screen);
	}
	
	
	/*
	 * User Screen 
	 * 
	 */
	
	public void userSelectionEmpty(String Screen)
	{
		Models.InsertInToDB.emptyFieldsHandler(15, Screen);
	}
	
	public void userHospSearch(String Screen)
	{
		Models.InsertInToDB.emptyFieldsHandler(16, Screen);
	}
	
	public void appointmentDateEmpty(String Screen)
	{
		Models.InsertInToDB.emptyFieldsHandler(26, Screen);
	}
	
	
	/*
	 * Manager Report Section Screen
	 * 
	 */
	
	public void startDateEmptyReport(String Screen)
	{
		Models.InsertInToDB.emptyFieldsHandler(17, Screen);
	}
	
	public void endDateEmptyReport(String Screen)
	{
		Models.InsertInToDB.emptyFieldsHandler(18, Screen);
	}
	
	public void locationORZipCodeEmpty(String Screen)
	{
		Models.InsertInToDB.emptyFieldsHandler(22, Screen);
	}
	/*
	 * 
	 * Raise a Request Screen
	 * 
	 */
	
	public void issueDescriptionEmpty(String Screen)
	{
		Models.InsertInToDB.emptyFieldsHandler(19, Screen);
	}
	
	public void PriorityEmpty(String Screen)
	{
		Models.InsertInToDB.emptyFieldsHandler(20, Screen);
	}
	
	public void reValidateTicket(String Screen)
	{
		Models.InsertInToDB.emptyFieldsHandler(21, Screen);
	}
	
	/*
	 * 
	 * Admin Ticket Screen
	 */
	public void ticketStatusEmpty(String Screen)
	{
		Models.InsertInToDB.emptyFieldsHandler(23, Screen);
	}
	
	public void ticketPriorityEmpty(String Screen)
	{
		Models.InsertInToDB.emptyFieldsHandler(24, Screen);
	}
	
	 
	/*
	 * 
	 * Admin DDL
	 * 
	 */
	public void TicketNumberEmpty(String Screen)
	{
		Models.InsertInToDB.emptyFieldsHandler(25, Screen);
	}
	
	
}
