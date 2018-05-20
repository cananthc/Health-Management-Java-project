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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ErrorHandler.EmptyFields_Error_Handler;
import Models.ResultSetFetch;
import View.Admin_Tickets_View;

public class AdminTickets_Status 
{ //ATS -S

	//Declare swing components
	JFrame ATS = new JFrame("Admin Ticket Status");
	String Status[] = { "Open", "Closed", "InProgress"};
	String Priority[] = {"1", "2", "3", "4"};
	JComboBox<String> StatusList = new JComboBox<String>(Status);
	JComboBox<String> priorityList = new JComboBox<String>(Priority);
	JLabel Status_label, PriorityLabel, Header, appointCat, conText,cp,cpn, lImg;
	Color c;
	JButton Search, Reset, goBack, Logout;
	Image img,img1;
	
	//Create Reference objects
	Admin_Tickets_View ATV = new Admin_Tickets_View();
	EmptyFields_Error_Handler EEH = new EmptyFields_Error_Handler();
	
	
	
	/*
	 * 
	 * Below is to View List of Open/Closed/In-Progress tickets 
	 * 
	 */
	public AdminTickets_Status()
	{ //AT -S
		
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		ATS.getContentPane().setBackground(c);
		
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);

		Header = new JLabel("Welcome to Admin Ticket Section");
		Header.setFont(new Font("Calibri", Font.BOLD, 20));
		Header.setForeground(Color.gray);
		Header.setBounds(525, 100, 400, 50);

		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		
		
		
		Status_label = new JLabel("Select Ticket Status ");
		Status_label.setFont(new Font("Calibri", Font.PLAIN, 15));
		Status_label.setBounds(530, 180, 200, 100);

		StatusList.setSelectedItem(null);
		StatusList.setFont(new Font("Calibri", Font.PLAIN, 15));
		StatusList.setBounds(720, 220, 100, 20);
		
		
		PriorityLabel = new JLabel("Select Ticket Priority");
		PriorityLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		PriorityLabel.setBounds(530, 255, 150, 50);
		
		priorityList.setSelectedItem(null); 
		priorityList.setFont(new Font("Calibri", Font.PLAIN, 15));
		priorityList.setBounds(720, 270, 100, 20);
		
		
		// Perform validations before listing tickets
		Search = new JButton("Search");
		Search.setFont(new Font("Calibri", Font.PLAIN, 15));
		Search.setBounds(540, 365, 85, 20);
		Search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(StatusList.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(StatusList, "Please Select The Status of The Ticket");
					EEH.ticketStatusEmpty("Admin Ticket Status Selection");
				}
				else if(priorityList.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(priorityList, "Please Select The Priority of The Ticket");
					EEH.ticketPriorityEmpty("Admin Ticket Priority Selection");
				}
				else 
				{
					//Display Ticket as per the choice
					ATV.AdminTicketList((String) StatusList.getSelectedItem(), (String) priorityList.getSelectedItem()); 
				}
			}
		});

		Reset = new JButton("Reset");
		Reset.setFont(new Font("Calibri", Font.PLAIN, 15));
		Reset.setBounds(720, 365, 85, 20);
		Reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StatusList.setSelectedItem(null);
				priorityList.setSelectedItem(null); 
				
			}
		});

		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(630, 405, 85, 20);
		goBack.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_Screen();
				ATS.setVisible(false);
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
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					ResultSetFetch.updateLogoutTime("ADMIN",Login_All.UserName); //Update logout time
					new Login_All();
					ATS.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		ATS.add(cp);
		ATS.add(cpn);

		ATS.add(lImg);
		ATS.add(conText);
		ATS.add(Header);
		ATS.add(StatusList);
		ATS.add(Header);
		ATS.add(priorityList);
		ATS.add(PriorityLabel);
		ATS.add(Search);
		ATS.add(Reset);
		ATS.add(goBack);
		ATS.add(Status_label);
		ATS.add(cp);
		ATS.add(cpn);
		ATS.add(Logout);
		ATS.setLayout(null);
		ATS.setSize(1500, 1500);
		ATS.setVisible(true);
	} //AT -E
} //ATS -E
