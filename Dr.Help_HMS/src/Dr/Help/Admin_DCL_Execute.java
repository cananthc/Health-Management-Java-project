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
package Dr.Help;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ErrorHandler.EmptyFields_Error_Handler;
import Models.ResultSetFetch;

public class Admin_DCL_Execute

{//ADCLE - S
	
	
	//Declare Swing Components
	JFrame ADCLE = new JFrame("Admin DCL Execute Screen");
	JLabel cp,cpn,conText,lImg, welcomSec, TicketNumber, QueryName;
	JButton ticketStatus, ddlOperation, dmlOperation, validateSQL, goBack, Logout;
	JTextField tTicketNumber;
	JTextArea tQuery;
	Image img,img1;
	Color c;
	
	
	//To populate DCL Syntax in the Text Area
	String Grant= "GRANT [PRIVILEGE_TYPE] ON [TABLE_NAME] TO [GRANTEES]";
	String Revoke = "GRANT [PRIVILEGE_TYPE] ON [TABLE_NAME] FROM [GRANTEES]";
	
	String TicketAvailable; //Validate ticketNumber
	int Ticketresult; // Ticket available or not
	
	
	// Reference Objects for handling Empty Fields
	EmptyFields_Error_Handler EEH = new EmptyFields_Error_Handler();
		
	
	/*
	 * 
	 * Below is to Generate DCL Grant Operations Screen
	 * 
	 */
	public void Admin_DDL_Grant()
	{ //DDLG - S
		
		//Display Symbol of medicine
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		ADCLE.getContentPane().setBackground(c);
		
		
		//Header Text
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);
		
		
		
		//JLabel Attributes
		welcomSec = new JLabel("Enter Your Database Query");
		welcomSec.setBounds(640,100,400,100);
		welcomSec.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomSec.setForeground(Color.gray);
		
		
		//Copyrights of the project
		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		
		
		//Ticket Number Label
		TicketNumber = new JLabel("Enter Reference Ticket Number");
		TicketNumber.setFont(new Font("Calibri", Font.PLAIN, 15));
		TicketNumber.setBounds(550, 200, 250, 20);
		
		
		//Ticket Number Text
		tTicketNumber = new JTextField();
		tTicketNumber.setFont(new Font("Calibri", Font.PLAIN, 15));
		tTicketNumber.setBounds(820, 200, 120, 20);
		
		//Display Grant Query Syntax
		QueryName = new JLabel("Grant Query");
		QueryName.setFont(new Font("Calibri", Font.BOLD, 15));
		QueryName.setBounds(550, 280, 120, 20);
		
		
		tQuery = new JTextArea();
		tQuery.setLineWrap(true);
		tQuery.setWrapStyleWord(true);
		tQuery.setFont(new Font("Calibri", Font.PLAIN, 15));
		tQuery.setBounds(550,300, 400, 100);
		tQuery.setText(Grant);
		
		
		//Go Back one screen
		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(530, 450, 170, 20);
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_DCL(); // Navigate to DCL Main Menu Screen
				ADCLE.setVisible(false);
			}
		});
		
		validateSQL = new JButton("Validate SQL Query");
		validateSQL.setFont(new Font("Calibri", Font.PLAIN, 15));
		validateSQL.setBounds(730, 450, 170, 20);
		validateSQL.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{ //Action - S
				// TODO Auto-generated method stub
				if(tTicketNumber.getText().equals("")) // Check whether Ticket Number field is empty
				{ //If 1.0 -S
					JOptionPane.showMessageDialog(tTicketNumber, "Please Input Your Reference Number"); //Display Message
					EEH.TicketNumberEmpty("Admin DML Drop");
				} //If 1.0 -E
				else
				{ //else 1.0 - S
					Ticketresult = validateTicket();
					if(Ticketresult == 1)
					{ //If 1.1 - S
				try 
				{ //try 1.0 - S
					//Validate SQL Query
					ResultSetFetch.validateSQLQueryDCL(tQuery.getText(), "GRANT STATEMENT", tTicketNumber.getText());
				}//try 2.0 - E 
				catch (Exception e1) 
				{
					// TODO Auto-generated catch block
					
					e1.printStackTrace();
				}
					} //If 1.1 - E
				} //else 1.0 - E
			} //Action - E
		});
		
		Logout = new JButton("LOGOUT");
		Logout.setFont(new Font("Calibri", Font.BOLD, 15));
		Logout.setForeground(Color.GRAY);
		Logout.setBounds(1100, 120, 150, 30);
		
		ImageIcon img1 = new ImageIcon("l.png");
		Logout.setBackground(c);
		Logout.setIcon(img1);
		// Logout.setFont(new Font("Calibri", Font.PLAIN, 15));
		Logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try 
				{
					ResultSetFetch.updateLogoutTime("ADMIN",Login_All.UserName); //Update Logout Time
					new Login_All();
					ADCLE.setVisible(false);
				}
				catch (Exception e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		
		ADCLE.add(cp);
		ADCLE.add(cpn);
		ADCLE.add(lImg);
		ADCLE.add(conText);
		ADCLE.add(welcomSec);
		ADCLE.add(goBack);
		ADCLE.add(TicketNumber);
		ADCLE.add(tTicketNumber);
		ADCLE.add(tQuery);
		ADCLE.add(QueryName);
		ADCLE.add(validateSQL);
		ADCLE.add(Logout);
		ADCLE.setSize(1500, 1500);
		ADCLE.setLayout(null);
		ADCLE.setVisible(true);
	} //DDLG - E
	
	/*
	 * 
	 * Below is to Generate DCL Grant Operations Screen
	 * 
	 */
	
	public void Admin_DDL_Revoke()
	{//DDLR - S
		
		
		
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		ADCLE.getContentPane().setBackground(c);
		
		
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);
		
		
		
		
		welcomSec = new JLabel("Enter Your Database Query");
		welcomSec.setBounds(640,100,400,100);
		welcomSec.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomSec.setForeground(Color.gray);
		
		
		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		
		
		TicketNumber = new JLabel("Enter Reference Ticket Number");
		TicketNumber.setFont(new Font("Calibri", Font.PLAIN, 15));
		TicketNumber.setBounds(550, 200, 250, 20);
		
		
		tTicketNumber = new JTextField();
		tTicketNumber.setFont(new Font("Calibri", Font.PLAIN, 15));
		tTicketNumber.setBounds(820, 200, 120, 20);
		
		
		QueryName = new JLabel("Select Query");
		QueryName.setFont(new Font("Calibri", Font.BOLD, 15));
		QueryName.setBounds(550, 280, 120, 20);
		
		tQuery = new JTextArea();
		tQuery.setLineWrap(true);
		tQuery.setWrapStyleWord(true);
		tQuery.setFont(new Font("Calibri", Font.PLAIN, 15));
		tQuery.setBounds(550,300, 400, 100);
		tQuery.setText(Revoke);
		
		
		
		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(530, 450, 170, 20);
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_DCL();
				ADCLE.setVisible(false);
			}
		});
		
		validateSQL = new JButton("Validate SQL Query");
		validateSQL.setFont(new Font("Calibri", Font.PLAIN, 15));
		validateSQL.setBounds(730, 450, 170, 20);
		validateSQL.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{ // Action1 - S
				// TODO Auto-generated method stub
				if(tTicketNumber.getText().equals(""))
				{ // If 2.0 -S
					JOptionPane.showMessageDialog(tTicketNumber, "Please Input Your Reference Number");
					EEH.TicketNumberEmpty("Admin DML Drop");
				} // If 2.0 -E
				else
				{ // else 2.0 -S
					Ticketresult = validateTicket();
					if(Ticketresult == 1)
					{ // if 2.1 -S
				
				try 
				{//try 2.0 -S 
					
					//Validate SQL Query
					ResultSetFetch.validateSQLQueryDCL(tQuery.getText(), "REVOKE STATEMENT",tTicketNumber.getText()); 
				}//try 2.0 -E
				catch (Exception e1) 
					{// Catch 2.0 - S
						// TODO Auto-generated catch block
						
						e1.printStackTrace();
					}// Catch 2.0 - E
					}// if 2.1 -E
				} // else 2.0 -E
			} // Action1 - E
		});
		
		Logout = new JButton("LOGOUT");
		Logout.setFont(new Font("Calibri", Font.BOLD, 15));
		Logout.setForeground(Color.GRAY);
		Logout.setBounds(1100, 120, 150, 30);
		img1 = new ImageIcon(this.getClass().getResource("/l.png")).getImage();
		Logout.setBackground(c);
		Logout.setIcon(new ImageIcon(img1));
		Logout.setBorderPainted(false);
		// Logout.setFont(new Font("Calibri", Font.PLAIN, 15));
		Logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try 
				{
					ResultSetFetch.updateLogoutTime("ADMIN",Login_All.UserName); //Update Logout Time
					new Login_All();
					ADCLE.setVisible(false);
				}  
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		
		ADCLE.add(cp);
		ADCLE.add(cpn);
		ADCLE.add(conText);
		ADCLE.add(lImg);
		ADCLE.add(welcomSec);
		ADCLE.add(goBack);
		ADCLE.add(TicketNumber);
		ADCLE.add(tTicketNumber);
		ADCLE.add(tQuery);
		ADCLE.add(QueryName);
		ADCLE.add(validateSQL);
		ADCLE.add(Logout);
		ADCLE.setSize(1500, 1500);
		ADCLE.setLayout(null);
		ADCLE.setVisible(true);
	} //DDLR - S
	
	//Validate TicketNumber against DB
	public int validateTicket()
	{ //VT - S
		
		
		System.out.println(tQuery.getText());
		try { //try 2.0 - S
			
			TicketAvailable = Models.ResultSetFetch.validateTicketNumber(tTicketNumber.getText());
			if(TicketAvailable.equals("1"))
			{
				return 1;
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Invalid Ticket Number or Ticket is Not Open");
			}
		}//try 2.0 - E
		
		catch (Exception e2) 
		{
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return 0;
				
	}//VT - E
	
} //ADCLE - E