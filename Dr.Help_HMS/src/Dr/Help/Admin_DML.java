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

import Models.ResultSetFetch;

public class Admin_DML
{ //ADML- S

	
	//Declare Swing components
	JFrame ADML = new JFrame("Admin DML Screen");
	JLabel cp,cpn,conText, lImg, welcomSec;
	JButton CreateOption, AlterOption, UpdateOption, DropOperation, goBack, Logout;
	JTextArea populateStatement;
	Image img,img1;
	Color c;
	
	
	//Create Reference objects
	Admin_DML_Execute ADMLE = new Admin_DML_Execute();
	
	
	
	/*
	 * 
	 * Below is to Provide DML Options to Admin
	 * 
	 */
	public Admin_DML()
	{ //ADMO - S
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		ADML.getContentPane().setBackground(c);
		
		
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);
		
		
		
		
		welcomSec = new JLabel("Please Select Your Option To Proceed");
		welcomSec.setBounds(640,100,400,100);
		welcomSec.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomSec.setForeground(Color.gray);
		
		
		CreateOption = new JButton("Create");
		CreateOption.setBounds(530,200,170,20);
		CreateOption.setFont(new Font("Calibri", Font.PLAIN, 15));
		CreateOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ADMLE.Admin_DDL_Create(); //Move to  Create Statement
				ADML.setVisible(false);
			}
		});
		
		
			
		
		AlterOption = new JButton("Alter");
		AlterOption.setBounds(730,200,170,20);
		AlterOption.setFont(new Font("Calibri", Font.PLAIN, 15));
		AlterOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ADMLE.Admin_DDL_Alter(); //Move to  Alter Statement
				ADML.setVisible(false);
			}
		});
		
		
		DropOperation = new JButton("Drop");
		DropOperation.setFont(new Font("Calibri", Font.PLAIN, 15));
		DropOperation.setBounds(930, 200, 170, 20);
		DropOperation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ADMLE.Admin_DDL_Drop(); //Move to  Drop Statement
				ADML.setVisible(false);
			}
		});
		
		
		
		
		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(730, 250, 170, 20);
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_Screen();
				ADML.setVisible(false);
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
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				try {
					ResultSetFetch.updateLogoutTime("ADMIN",Login_All.UserName); //Update Logout time
					new Login_All();
					ADML.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		
		ADML.add(cp);
		ADML.add(cpn);
		ADML.add(lImg);
		ADML.add(conText);
		ADML.add(welcomSec);
		ADML.add(CreateOption);
		ADML.add(AlterOption);
		ADML.add(DropOperation);
		ADML.add(goBack);
		ADML.add(Logout);
		ADML.setSize(1500, 1500);
		ADML.setLayout(null);
		ADML.setVisible(true);
	} //ADMO - E
} //ADML- E
