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
import View.Admin_Select_DDL;
import View.Admin_Tickets_View;

public class Admin_DDL_Execute 
{ // ADDLE - S

	// Declare swing components 
	JFrame ADDLE = new JFrame("Admin DDL Execute Screen");
	JLabel cp,cpn,conText, lImg, welcomSec, TicketNumber, QueryName;
	JButton ticketStatus, ddlOperation, dmlOperation, validateSQL, goBack, Logout;
	JTextField tTicketNumber;
	JTextArea tQuery;
	Image img,img1;
	Color c;
	String TicketAvailable;
	int Ticketresult, ConfirmMessage;
	String SQL_Syntax_Status;
	
	
	//To populate DCL Syntax in the Text Area
	String Select = "SELECT * FROM [ENTER_TABLE_NAME] ";
	String Insert = "INSERT INTO [ENTER_TABLE_NAME] VALUES[ENTER VALUES]";
	String Update = "UPDATE [ENTER_TABLE_NAME] SET [ENTER_COLUMN_NAME] WHERE [ENTER_CONDITION]";
	String Delete = "DELETE FROM [ENTER_TABLE_NAME] WHERE [ENTER_CONDITION]";
	
	
	//Create Reference Objects 
	EmptyFields_Error_Handler EEH = new EmptyFields_Error_Handler();
	Admin_Select_DDL ASDDL = new Admin_Select_DDL();
	
	
	/*
	 * 
	 * Below is to Provide DDL Options to Admin
	 * 
	 */
	
	public void Admin_DDL_Select()
	{ //DDLS - S
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		ADDLE.getContentPane().setBackground(c);
		
		
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
		tQuery.setText(Select);
		
		
		
		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(530, 450, 170, 20);
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_DDL();
				ADDLE.setVisible(false);
			}
		});
		
		validateSQL = new JButton("Validate SQL Query");
		validateSQL.setFont(new Font("Calibri", Font.PLAIN, 15));
		validateSQL.setBounds(730, 450, 170, 20);
		validateSQL.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tTicketNumber.getText().equals(""))
				{ //IF - 1.0 -S
					JOptionPane.showMessageDialog(tTicketNumber, "Please Input Your Reference Number");
					EEH.TicketNumberEmpty("Admin DDL Select");
				} //IF - 1.0 -E
				else
				{ //else 1.0 -S
					Ticketresult = validateTicket();
					if(Ticketresult == 1)
					{ //If 1.1 - S
						
						try 
						{ // try 1.0 -S
							//Validate SQL Query
							ResultSetFetch.validateSQLQuerySelect(tQuery.getText(), "SELECT STATEMENT", tTicketNumber.getText());
							
						} // try 1.0 -E 
						catch (Exception e1) 
						{ //catch 1.0 - S
							System.out.println("Admin_DDL_SCreen Error");
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} //catch 1.0 - S
						
					} //If 1.1 - E
					
				} //else 1.0 -E
				
				
				
			}
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
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				try {
					ResultSetFetch.updateLogoutTime("ADMIN",Login_All.UserName); // update Logout time
					new Login_All();
					ADDLE.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		
		ADDLE.add(cp);
		ADDLE.add(cpn);
		ADDLE.add(lImg);
		ADDLE.add(conText);
		ADDLE.add(welcomSec);
		ADDLE.add(goBack);
		ADDLE.add(TicketNumber);
		ADDLE.add(tTicketNumber);
		ADDLE.add(tQuery);
		ADDLE.add(QueryName);
		ADDLE.add(validateSQL);
		ADDLE.add(Logout);
		ADDLE.setSize(1500, 1500);
		ADDLE.setLayout(null);
		ADDLE.setVisible(true);
	} //DDLS - E
	
	
	/*
	 * 
	 * 
	 * DDL Insert
	 */
	public void Admin_DDL_Insert()
	{ //DDLI - I
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		ADDLE.getContentPane().setBackground(c);
		
		
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
		
		
		QueryName = new JLabel("Insert Query");
		QueryName.setFont(new Font("Calibri", Font.BOLD, 15));
		QueryName.setBounds(550, 280, 120, 20);
		
		tQuery = new JTextArea();
		tQuery.setLineWrap(true);
		tQuery.setWrapStyleWord(true);
		tQuery.setFont(new Font("Calibri", Font.PLAIN, 15));
		tQuery.setBounds(550,300, 400, 100);
		tQuery.setText(Insert);
		
		
		
		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(530, 450, 170, 20);
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_DDL();
				ADDLE.setVisible(false);
			}
		});
		
		validateSQL = new JButton("Validate SQL Query");
		validateSQL.setFont(new Font("Calibri", Font.PLAIN, 15));
		validateSQL.setBounds(730, 450, 170, 20);
		validateSQL.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{ // Action - S
				// TODO Auto-generated method stub
				if(tTicketNumber.getText().equals(""))
				{ // If 1.0 -S
					JOptionPane.showMessageDialog(tTicketNumber, "Please Input Your Reference Number");
					EEH.TicketNumberEmpty("Admin DDL Insert");
				} // If 1.0 -E
				else
				{ // else 1.0 -S
					Ticketresult = validateTicket();
					if(Ticketresult == 1)
					{ // If 1.1 - E
						try 
						{// try 1.1 -S
							//Validate SQL Query
						ResultSetFetch.validateSQLQueryDDL(tQuery.getText(), "INSERT STATEMENT",tTicketNumber.getText());
					} // try 1.1 -E
						catch (Exception e1) 
						{ //catch 1.1 - S
						// TODO Auto-generated catch block
						
						e1.printStackTrace();
					} //catch 1.1 - S
					} // If 1.1 - S
					
				} // else 1.0 -E
				
				
				
				
			} // Action - E
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
				try {
					ResultSetFetch.updateLogoutTime("ADMIN",Login_All.UserName); //Update Logout Time
					new Login_All();
					ADDLE.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		
		ADDLE.add(cp);
		ADDLE.add(cpn);
		ADDLE.add(lImg);
		ADDLE.add(conText);
		ADDLE.add(welcomSec);
		ADDLE.add(goBack);
		ADDLE.add(TicketNumber);
		ADDLE.add(tTicketNumber);
		ADDLE.add(tQuery);
		ADDLE.add(QueryName);
		ADDLE.add(validateSQL);
		ADDLE.add(Logout);
		ADDLE.setSize(1500, 1500);
		ADDLE.setLayout(null);
		ADDLE.setVisible(true);
	} //DDLI - E
	
	
	/*
	 * 
	 * DDL Update 
	 */
	public void Admin_DDL_Update()
	{ //DDLU - S
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		ADDLE.getContentPane().setBackground(c);
		
		
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
		
		
		QueryName = new JLabel("Update Query");
		QueryName.setFont(new Font("Calibri", Font.BOLD, 15));
		QueryName.setBounds(550, 280, 120, 20);
		
		tQuery = new JTextArea();
		tQuery.setLineWrap(true);
		tQuery.setWrapStyleWord(true);
		tQuery.setFont(new Font("Calibri", Font.PLAIN, 15));
		tQuery.setBounds(550,300, 400, 100);
		tQuery.setText(Update);
		
		
		
		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(530, 450, 170, 20);
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_DDL();
				ADDLE.setVisible(false);
			}
		});
		
		validateSQL = new JButton("Validate SQL Query");
		validateSQL.setFont(new Font("Calibri", Font.PLAIN, 15));
		validateSQL.setBounds(730, 450, 170, 20);
		validateSQL.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{ // Action - S
				// TODO Auto-generated method stub
				if(tTicketNumber.getText().equals(""))
				{ // If 1.0 - S
					JOptionPane.showMessageDialog(tTicketNumber, "Please Input Your Reference Number");
					EEH.TicketNumberEmpty("Admin DDL Update");
				}// If 1.0 - E
				else
				{ //else 1.0 - S
					Ticketresult = validateTicket();
					if(Ticketresult == 1)
					{ // If 1.1 - E
						try 
						{ // try 1.0 -S
							//Validate SQL Query
							ResultSetFetch.validateSQLQueryDDL(tQuery.getText(), "UPDATE STATEMENT",tTicketNumber.getText());
						} // try 1.0 -E 
						catch (Exception e1) 
						{ // catch 1.0 - S
							// TODO Auto-generated catch block
							
							e1.printStackTrace();
						} // catch 1.0 - E
					} // If 1.1 - S
					
				} //else 1.0 - E
				
				
				
				
			} // Action - E
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
				try {
					ResultSetFetch.updateLogoutTime("ADMIN",Login_All.UserName); //updatae Logout time
					new Login_All();
					ADDLE.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		
		ADDLE.add(cp);
		ADDLE.add(cpn);
		ADDLE.add(lImg);
		ADDLE.add(conText);
		ADDLE.add(welcomSec);
		ADDLE.add(goBack);
		ADDLE.add(TicketNumber);
		ADDLE.add(tTicketNumber);
		ADDLE.add(tQuery);
		ADDLE.add(QueryName);
		ADDLE.add(validateSQL);
		ADDLE.add(Logout);
		ADDLE.setSize(1500, 1500);
		ADDLE.setLayout(null);
		ADDLE.setVisible(true);
	} //DDLU - E
	
	/*
	 * 
	 * DDL Delete
	 * 
	 */
	
	public void Admin_DDL_Delete()
	{ // DDLD - S
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		ADDLE.getContentPane().setBackground(c);
		
		
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
		
		
		QueryName = new JLabel("Delete Query");
		QueryName.setFont(new Font("Calibri", Font.BOLD, 15));
		QueryName.setBounds(550, 280, 120, 20);
		
		tQuery = new JTextArea();
		tQuery.setLineWrap(true);
		tQuery.setWrapStyleWord(true);
		tQuery.setFont(new Font("Calibri", Font.PLAIN, 15));
		tQuery.setBounds(550,300, 400, 100);
		tQuery.setText(Delete);
		
		
		
		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(530, 450, 170, 20);
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_DDL();
				ADDLE.setVisible(false);
			}
		});
		
		validateSQL = new JButton("Validate SQL Query");
		validateSQL.setFont(new Font("Calibri", Font.PLAIN, 15));
		validateSQL.setBounds(730, 450, 170, 20);
		validateSQL.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{ //ACtion - S
				// TODO Auto-generated method stub
				if(tTicketNumber.getText().equals(""))
				{ // If 1.0 -S
					JOptionPane.showMessageDialog(tTicketNumber, "Please Input Your Reference Number");
					EEH.TicketNumberEmpty("Admin DDL Delete");
				} //If 1.0 -E
				else
				{ //else 1.0 -S
					Ticketresult = validateTicket();
					if(Ticketresult == 1)
					{ // If 1.1 - S
						try {
							//Validate SQL Query after confirmation
							ConfirmMessage = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Delete?");
							if(ConfirmMessage == JOptionPane.YES_OPTION);
							{ // If 1.1.1 - S
							ResultSetFetch.validateSQLQueryDDL(tQuery.getText(), "DELETE STATEMENT",tTicketNumber.getText());
							} // If 1.1.1 - E
						} // If 1.1 - E 
						catch (Exception e1)
						{ //catch 1.0 -S
							// TODO Auto-generated catch block
							
							e1.printStackTrace();
						} //catch 1.0 -S
					} // If 1.1 - E
					
				} //else 1.0 -E
				
				
				
			} //Action - E
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
				try {
					ResultSetFetch.updateLogoutTime("ADMIN",Login_All.UserName); //Update Logout Time
					new Login_All();
					ADDLE.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		
		ADDLE.add(cp);
		ADDLE.add(cpn);
		ADDLE.add(lImg);
		ADDLE.add(conText);
		ADDLE.add(welcomSec);
		ADDLE.add(goBack);
		ADDLE.add(TicketNumber);
		ADDLE.add(tTicketNumber);
		ADDLE.add(tQuery);
		ADDLE.add(QueryName);
		ADDLE.add(validateSQL);
		ADDLE.add(Logout);
		ADDLE.setSize(1500, 1500);
		ADDLE.setLayout(null);
		ADDLE.setVisible(true);
	} // DDLD - E
	
	//Validate TicketNumber against DB
	public int validateTicket()
	{ //VT - S
		
		
		System.out.println(tQuery.getText());
		try {
			
			TicketAvailable = Models.ResultSetFetch.validateTicketNumber(tTicketNumber.getText());
			if(TicketAvailable.equals("1"))
			{
				return 1;
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Invalid Ticket Number or Ticket is Not Open");
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return 0;
		
		
	} //VT - E
	
	
} // ADDLE - E

