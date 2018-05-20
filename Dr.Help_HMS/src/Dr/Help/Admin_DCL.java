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

public class Admin_DCL 
{ // ADCL - S
	
	// Declare swing components 
	JFrame ADCL = new JFrame("Admin DCL Screen");
	JLabel cp,cpn,conText, lImg, welcomSec;
	JButton GrantOption, RevokeOption, goBack, Logout;
	JTextArea populateStatement;
	Image img, img1;
	Color c;
	
	
	//Call Reference methods
	Admin_DCL_Execute ADCLE = new Admin_DCL_Execute();
	
	/*
	 * 
	 * Below is to Provide DCL Options to Admin
	 * 
	 */
	
	public Admin_DCL()
	{ //DCLO - S
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		ADCL.getContentPane().setBackground(c);
		
		
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);
		
		
		
		
		welcomSec = new JLabel("Please Select Your Option To Proceed");
		welcomSec.setBounds(640,100,400,100);
		welcomSec.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomSec.setForeground(Color.gray);
		
		
		GrantOption = new JButton("Grant");
		GrantOption.setBounds(530,200,170,20);
		GrantOption.setFont(new Font("Calibri", Font.PLAIN, 15));
		GrantOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ADCLE.Admin_DDL_Grant(); //Call Grant Method for execution
				ADCL.setVisible(false);
			}
		});
		
		
			
		
		RevokeOption = new JButton("Revoke");
		RevokeOption.setBounds(730,200,170,20);
		RevokeOption.setFont(new Font("Calibri", Font.PLAIN, 15));
		RevokeOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ADCLE.Admin_DDL_Revoke(); //Call Revoke Method for execution
				ADCL.setVisible(false);
			}
		});
		
		
		
		
		
		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(930, 200, 170, 20);
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_Screen();
				ADCL.setVisible(false);
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
					ResultSetFetch.updateLogoutTime("ADMIN",Login_All.UserName); //Update Logout Time
					new Login_All();
					ADCL.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		
		ADCL.add(cp);
		ADCL.add(cpn);
		ADCL.add(lImg);
		ADCL.add(conText);
		ADCL.add(welcomSec);
		ADCL.add(GrantOption);
		ADCL.add(RevokeOption);
		ADCL.add(Logout);
		ADCL.add(goBack);
	
		ADCL.setSize(1500, 1500);
		ADCL.setLayout(null);
		ADCL.setVisible(true);
	} //DCLO - E
} // ADCL - E
