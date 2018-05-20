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

public class Admin_DML_Execute 
{ //ADMLE - S

	
	//Declare swing components
	JFrame ADMLE = new JFrame("Admin DML Execute Screen");
	JLabel cp,cpn,conText, lImg, welcomSec, TicketNumber, QueryName;
	JButton ticketStatus, ddlOperation, dmlOperation, validateSQL, goBack, Logout;
	JTextField tTicketNumber;
	JTextArea tQuery;
	Image img,img1;
	Color c;
	String TicketAvailable;
	int Ticketresult, ConfirmMessage;
	
	
	//To populate DML Syntax in the Text Area
	String Create = "CREATE TABLE [ENTER_TABLE_NAME] [ENTER COLUMN_NAME AND DATATYPE]";
	String Alter = "ALTER TABLE [ENTER_TABLE_NAME] CONSTRAINT COLUMN_NAME";
	String Drop = "DROP TABLE [ENTER_TABLE_NAME]";
	
	
	//Create Reference objects
	EmptyFields_Error_Handler EEH = new EmptyFields_Error_Handler();
	
	
	
	/*
	 * 
	 * Below is to Generate DML Create Operations Screen
	 * 
	 */
	public void Admin_DDL_Create()
	{ //DDLC -S
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		ADMLE.getContentPane().setBackground(c);
		
		
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
		
		
		QueryName = new JLabel("Create Query");
		QueryName.setFont(new Font("Calibri", Font.BOLD, 15));
		QueryName.setBounds(550, 280, 120, 20);
		
		tQuery = new JTextArea();
		tQuery.setLineWrap(true);
		tQuery.setWrapStyleWord(true);
		tQuery.setFont(new Font("Calibri", Font.PLAIN, 15));
		tQuery.setBounds(550,300, 400, 100);
		tQuery.setText(Create);
		
		
		
		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(530, 450, 170, 20);
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_DML();
				ADMLE.setVisible(false);
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
				if(tTicketNumber.getText().equals(""))
				{ // If 1.0 -S
					JOptionPane.showMessageDialog(tTicketNumber, "Please Input Your Reference Number");
					EEH.TicketNumberEmpty("Admin DML Create");
				} // If 1.0 -E
				else
				{ //else 1.0- S
					Ticketresult = validateTicket();
					if(Ticketresult == 1)
					{ //If 1.1-
				
				try 
				{ //try 1.0 -S
					//Validate SQL Query
					ResultSetFetch.validateSQLQueryDML(tQuery.getText(), "CREATE STATEMENT",tTicketNumber.getText());
				} //try 1.0 -E 
				catch (Exception e1) 
				{ //catch 1.0 -S
					// TODO Auto-generated catch block
					
					e1.printStackTrace();
				} //catch 1.0 -E
					}//If 1.1-E
				} //else 1.0- E
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
					ResultSetFetch.updateLogoutTime("ADMIN",Login_All.UserName); //Update logout Time
					new Login_All();
					ADMLE.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		
		ADMLE.add(cp);
		ADMLE.add(cpn);
		ADMLE.add(lImg);
		ADMLE.add(conText);
		ADMLE.add(welcomSec);
		ADMLE.add(goBack);
		ADMLE.add(TicketNumber);
		ADMLE.add(tTicketNumber);
		ADMLE.add(tQuery);
		ADMLE.add(QueryName);
		ADMLE.add(validateSQL);
		ADMLE.add(Logout);
		ADMLE.setSize(1500, 1500);
		ADMLE.setLayout(null);
		ADMLE.setVisible(true);
	} //DDLC -E
	
	/*
	 * 
	 * Below is to Generate DML Alter Operations Screen
	 * 
	 */
	
	public void Admin_DDL_Alter()
	{
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		ADMLE.getContentPane().setBackground(c);
		
		
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
		
		
		QueryName = new JLabel("Alter Query");
		QueryName.setFont(new Font("Calibri", Font.BOLD, 15));
		QueryName.setBounds(550, 280, 120, 20);
		
		tQuery = new JTextArea();
		tQuery.setLineWrap(true);
		tQuery.setWrapStyleWord(true);
		tQuery.setFont(new Font("Calibri", Font.PLAIN, 15));
		tQuery.setBounds(550,300, 400, 100);
		tQuery.setText(Alter);
		
		
		
		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(530, 450, 170, 20);
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_DML();
				ADMLE.setVisible(false);
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
				if(tTicketNumber.getText().equals(""))
				{ //If 1.0 -S
					JOptionPane.showMessageDialog(tTicketNumber, "Please Input Your Reference Number");
					EEH.TicketNumberEmpty("Admin DML Alter");
				} //If 1.0 -E
				else
				{ //else 1.0 -S
					Ticketresult = validateTicket();
					if(Ticketresult == 1)
					{ //If 1.1 - S
				try 
				{ //try 1.0 -S
					//Validate SQL Query
					ResultSetFetch.validateSQLQueryDML(tQuery.getText(), "ALTER STATEMENT",tTicketNumber.getText());
				}  //try 1.0 -E
				catch (Exception e1) 
				{ //catch 1.0 - S
					// TODO Auto-generated catch block
					
					e1.printStackTrace();
				} //catch 1.0 - E
					}  //If 1.1 - E 
					} //else 1.0 -S
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
					ResultSetFetch.updateLogoutTime("ADMIN",Login_All.UserName); //Update logout time
					new Login_All();
					ADMLE.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		
		
		ADMLE.add(cp);
		ADMLE.add(cpn);
		ADMLE.add(lImg);
		ADMLE.add(conText);
		ADMLE.add(welcomSec);
		ADMLE.add(goBack);
		ADMLE.add(TicketNumber);
		ADMLE.add(tTicketNumber);
		ADMLE.add(tQuery);
		ADMLE.add(QueryName);
		ADMLE.add(validateSQL);
		ADMLE.add(Logout);
		ADMLE.setSize(1500, 1500);
		ADMLE.setLayout(null);
		ADMLE.setVisible(true);
	}
	
	/*
	 * 
	 * Below is to Generate DML Drop Operations Screen
	 * 
	 */
	public void Admin_DDL_Drop()
	{ //DMLD - S
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		ADMLE.getContentPane().setBackground(c);
		
		
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
		
		
		QueryName = new JLabel("Drop Query");
		QueryName.setFont(new Font("Calibri", Font.BOLD, 15));
		QueryName.setBounds(550, 280, 120, 20);
		
		tQuery = new JTextArea();
		tQuery.setLineWrap(true);
		tQuery.setWrapStyleWord(true);
		tQuery.setFont(new Font("Calibri", Font.PLAIN, 15));
		tQuery.setBounds(550,300, 400, 100);
		tQuery.setText(Drop);
		
		
		
		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(530, 450, 170, 20);
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_DML();
				ADMLE.setVisible(false);
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
				{ //If 1.0 -S
					JOptionPane.showMessageDialog(tTicketNumber, "Please Input Your Reference Number");
					EEH.TicketNumberEmpty("Admin DML Drop");
				}//If 1.0 -E
				else
				{ //else 1.0 -E
					Ticketresult = validateTicket();
					if(Ticketresult == 1)
					{//If 1.1 -S
				try 
				{ //try 1.0 -S
					//Validate SQL Query after confirmation dialogue
					ConfirmMessage = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Execute Drop Statement");
					if(ConfirmMessage == JOptionPane.YES_OPTION)
					{ //If 1.1.1 -S
					ResultSetFetch.validateSQLQueryDML(tQuery.getText(), "DROP STATEMENT",tTicketNumber.getText());
					}//If 1.1.1 -E
				
				}//try 1.0 -E
				catch (Exception e1)
				{ //catch 1.0 -E
					// TODO Auto-generated catch block
					
					e1.printStackTrace();
				} //catch 1.0 -S
					} //If 1.1 -E
				}//else 1.0 -S
			} // Action -E
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
					ResultSetFetch.updateLogoutTime("ADMIN",Login_All.UserName); //Update logout time
					new Login_All();
					ADMLE.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		
		ADMLE.add(cp);
		ADMLE.add(cpn);
		ADMLE.add(lImg);
		ADMLE.add(conText);
		ADMLE.add(welcomSec);
		ADMLE.add(goBack);
		ADMLE.add(TicketNumber);
		ADMLE.add(tTicketNumber);
		ADMLE.add(tQuery);
		ADMLE.add(QueryName);
		ADMLE.add(validateSQL);
		ADMLE.add(Logout);
		ADMLE.setSize(1500, 1500);
		ADMLE.setLayout(null);
		ADMLE.setVisible(true);
	} //DMLD - E
	
	//Validate TicketNumber against DB
	public int validateTicket()
	{ //VT -S
		
		
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
		
		
	} //VT -E
	
} //ADMLE - S