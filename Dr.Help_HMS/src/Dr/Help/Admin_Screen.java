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
import javax.swing.JTextField;

import Models.ResultSetFetch;

public class Admin_Screen 
{ //ADS -S

	
	//Declare Swing Components
	JFrame AS = new JFrame("Admin Screen");
	JLabel cp,cpn,conText, lImg, welcomSec;
	JButton ticketStatus, ddlOperation, dmlOperation, dclOperation, Logout;
	JTextField sDate, eDate;
	Image img,img1;
	Color c;
	
	
	
	/*
	 * 
	 * Below is to Provide Admin Options
	 * 
	 */
	public Admin_Screen()
	{ //AS -S
		
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		AS.getContentPane().setBackground(c);
		
		
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);
		
		
		
		
		welcomSec = new JLabel("Please Select Your Option To Proceed");
		welcomSec.setBounds(640,100,400,100);
		welcomSec.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomSec.setForeground(Color.gray);
		
		
		ticketStatus = new JButton("View Open Tickets");
		ticketStatus.setBounds(530,200,170,20);
		ticketStatus.setFont(new Font("Calibri", Font.PLAIN, 15));
		ticketStatus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AdminTickets_Status(); //Ticket Statua
				AS.setVisible(false);
			}
		});
		
		
		
		ddlOperation = new JButton("DDL");
		ddlOperation.setBounds(730,200,170,20);
		ddlOperation.setFont(new Font("Calibri", Font.PLAIN, 15));
		ddlOperation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_DDL(); //DDL Options
				AS.setVisible(false);
			}
		});
		
		
		
		dmlOperation = new JButton("DML");
		dmlOperation.setFont(new Font("Calibri", Font.PLAIN, 15));
		dmlOperation.setBounds(930, 200, 170, 20);
		dmlOperation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_DML(); //DML Options
				AS.setVisible(false);
			}
		});
		
		
		
		dclOperation = new JButton("DCL");
		dclOperation.setFont(new Font("Calibri", Font.PLAIN, 15));
		dclOperation.setBounds(530, 250, 170, 20);
		dclOperation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_DCL(); //DCL Options
				AS.setVisible(false);
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
				try {
					ResultSetFetch.updateLogoutTime("ADMIN",Login_All.UserName); //Update Logout time
					new Login_All();
					AS.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		
		AS.add(cp);
		AS.add(cpn);
		AS.add(lImg);
		AS.add(conText);
		AS.add(welcomSec);
		AS.add(ticketStatus);
		AS.add(ddlOperation);
		AS.add(dmlOperation);
		AS.add(dclOperation);
		AS.add(Logout);
		AS.setSize(1500, 1500);
		AS.setLayout(null);
		AS.setVisible(true);
	} //AS -E
	

} //ADS -E
