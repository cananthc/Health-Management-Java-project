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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Models.ResultSetFetch;

public class Admin_DDL 

{ // DDL - S

	//Declare swing components
	JFrame ADDL = new JFrame("Admin DDL Screen");
	JLabel cp,cpn,conText, lImg, welcomSec;
	JButton SelectOption, InsertOption, UpdateOption, DeleteOperation, goBack, Logout;
	JTextArea populateStatement;
	Image img,img1;
	Color c;
	
	//Create Reference Objects
	Admin_DDL_Execute ADDLE = new Admin_DDL_Execute();
	
	
	/*
	 * 
	 * Below is to Provide DDL Options to Admin
	 * 
	 */
	public Admin_DDL()
	{ // DDLO - S
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		ADDL.getContentPane().setBackground(c);
		
		
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);
		
		
		
		
		welcomSec = new JLabel("Please Select Your Option To Proceed");
		welcomSec.setBounds(640,100,400,100);
		welcomSec.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomSec.setForeground(Color.gray);
		
		
		SelectOption = new JButton("Select");
		SelectOption.setBounds(530,200,170,20);
		SelectOption.setFont(new Font("Calibri", Font.PLAIN, 15));
		SelectOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ADDLE.Admin_DDL_Select(); // DDL Select Execution
				ADDL.setVisible(false);
			}
		});
		
		
			
		
		InsertOption = new JButton("Insert");
		InsertOption.setBounds(730,200,170,20);
		InsertOption.setFont(new Font("Calibri", Font.PLAIN, 15));
		InsertOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ADDLE.Admin_DDL_Insert(); // DDL Insert Execution
				ADDL.setVisible(false);
			}
		});
		
		
		UpdateOption = new JButton("Update");
		UpdateOption.setFont(new Font("Calibri", Font.PLAIN, 15));
		UpdateOption.setBounds(930, 200, 170, 20);
		UpdateOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ADDLE.Admin_DDL_Update(); // DDL Update Execution
				ADDL.setVisible(false);
			}
		});
		
		
		DeleteOperation = new JButton("Delete");
		DeleteOperation.setFont(new Font("Calibri", Font.PLAIN, 15));
		DeleteOperation.setBounds(530, 250, 170, 20);
		DeleteOperation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ADDLE.Admin_DDL_Delete();
				ADDL.setVisible(false);
			}
		});
		
		
		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(930, 250, 170, 20);
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_Screen();
				ADDL.setVisible(false);
			}
		});
		
		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		
		
		
		
		
		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		
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
					ResultSetFetch.updateLogoutTime("ADMIN",Login_All.UserName); // Update Logout time
					new Login_All();
					ADDL.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		
		
		ADDL.add(cp);
		ADDL.add(cpn);
		ADDL.add(conText);
		ADDL.add(lImg);
		ADDL.add(welcomSec);
		ADDL.add(SelectOption);
		ADDL.add(InsertOption);
		ADDL.add(UpdateOption);
		ADDL.add(DeleteOperation);
		ADDL.add(goBack);
		ADDL.add(Logout);
		ADDL.setSize(1500, 1500);
		ADDL.setLayout(null);
		ADDL.setVisible(true);
	} // DDLO - E


} // DDL - E
