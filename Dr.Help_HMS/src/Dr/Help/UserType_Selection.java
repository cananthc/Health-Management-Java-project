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
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

public class UserType_Selection
{ // UTS - S

	//Declare swing components
	JFrame UTS = new JFrame("Category Selection Screen"); // Display in the JFrame
	JLabel lImg, conText, cp, cpn;
	JButton back; // Go Back Button
	Color c;

	Image img;
	{
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		UTS.getContentPane().setBackground(c);

		JPanel backgroundPanel = new JPanel();
		backgroundPanel.add(lImg);
		backgroundPanel.setLayout(new OverlayLayout(backgroundPanel));
		backgroundPanel.setOpaque(true);

		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);
	}

	//Navigate as per choice 
	public UserType_Selection(int i) 
	{
		if (i == 1) {
			User_Screen(); //user
		} else if (i == 2) 
		{
			Doctor_Choice(); //Doc
		} else if (i == 3) {
			Manager_Choice(); //Manger
		} else if (i == 4) {
			Admin_Choice(); //Admin
		}
	}

	public void User_Screen() 
	{ //US -S

		JLabel User;
		JButton NUser;
		Color c;

		User = new JLabel("Please Select Your User Type");
		User.setFont(new Font("Calibri", Font.BOLD, 20));
		User.setForeground(Color.gray);
		User.setBounds(550, 100, 300, 30);

		NUser = new JButton("New User");
		NUser.setFont(new Font("Calibri", Font.PLAIN, 15));
		NUser.setBounds(600, 200, 135, 20);
		NUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UTS.setVisible(false);
				new newUser(); // Calls the Welcome_Screen Constructor
			}
		});
		// If this button is clicked then it will go back to Welcome_Screen
		back = new JButton("Go Back ");
		back.setFont(new Font("Calibri", Font.PLAIN, 15));
		back.setBounds(600, 250, 135, 20);
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UTS.setVisible(false);
				new Welcome_Screen(); // New User Registration
			}
		});
		
		

		
		
		UTS.add(lImg);
		UTS.add(conText);
		UTS.add(User);
		UTS.add(NUser);
		UTS.add(back);
		UTS.setSize(1500, 1500);
		UTS.setLayout(null);
		UTS.setVisible(true);
	} //US -E

	public void Doctor_Choice() 
	{ //DC - S
		JLabel Doctor;
		JButton NDoc, Logout;
		Color c;
		Doctor = new JLabel("Please Select Your Doctor Type");
		Doctor.setFont(new Font("Calibri", Font.BOLD, 20));
		Doctor.setForeground(Color.gray);
		Doctor.setBounds(550, 150, 300, 30);

		NDoc = new JButton("New Doctor");
		NDoc.setFont(new Font("Calibri", Font.PLAIN, 15));
		NDoc.setBounds(600, 200, 135, 20);
		NDoc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UTS.setVisible(false);
				new newDoctor(); // New Doctor Registration
			}
		});

		back = new JButton("Go Back ");
		back.setFont(new Font("Calibri", Font.PLAIN, 15));
		back.setBounds(600, 250, 135, 20);

		// addActionListener is used to perform what action needs to be performed if the
		// button is clicked
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UTS.setVisible(false);
				new Welcome_Screen(); // Go back to Welcome_Screen
			}
		});


		
		
		
		UTS.add(lImg);
		UTS.add(conText);
		UTS.add(Doctor); // Display Doctor Label in the JFrame
		UTS.add(NDoc); // Display New Doctor in the JFrame
		UTS.add(back); // Display back button in the JFrame
		UTS.setSize(1500, 1500);
		UTS.setLayout(null);
		UTS.setVisible(true);

	} //DC - E

	public void Manager_Choice() 
	{ //MC -S
		JLabel Manager;
		JButton  NManager, Logout;
		Color c;
		
		Manager = new JLabel("Please Select Your Manager Type");
		Manager.setFont(new Font("Calibri", Font.BOLD, 20));
		Manager.setForeground(Color.gray);
		Manager.setBounds(550, 150, 300, 30);

		NManager = new JButton("New Manager");
		NManager.setFont(new Font("Calibri", Font.PLAIN, 15));
		NManager.setBounds(600, 200, 135, 20);
		NManager.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UTS.setVisible(false);
				new newManager(); // New Manager Registration
			}
		});
		back = new JButton("Go Back ");
		back.setFont(new Font("Calibri", Font.PLAIN, 15));
		back.setBounds(600, 250, 135, 20);
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UTS.setVisible(false);
				new Welcome_Screen();
			}
		});
		
		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		
		
		UTS.add(cp);
		UTS.add(cpn);

		UTS.add(lImg);
		UTS.add(conText);
		UTS.add(Manager);

		UTS.add(NManager);
		UTS.add(back);
		UTS.setSize(1500, 1500);
		UTS.setLayout(null);
		UTS.setVisible(true);

	} //MC -E

	public void Admin_Choice() 
	{ //AC -S
		JLabel Admin;
		JButton  NAdmin, Logout;
		Color c;
		
		
		Admin = new JLabel("Please Select Your Admin Type");
		Admin.setFont(new Font("Calibri", Font.BOLD, 20));
		Admin.setForeground(Color.gray);
		Admin.setBounds(550, 150, 300, 30);

		NAdmin = new JButton("New Admin");
		NAdmin.setFont(new Font("Calibri", Font.PLAIN, 15));
		NAdmin.setBounds(600, 200, 135, 20);
		NAdmin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UTS.setVisible(false);
				
					new newAdmin(); // New Admin Registration
				
			}
		});
		back = new JButton("Go Back ");
		back.setFont(new Font("Calibri", Font.PLAIN, 15));
		back.setBounds(600, 250, 135, 20);
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UTS.setVisible(false);
				new Welcome_Screen();
			}
		});

		UTS.add(lImg);
		UTS.add(conText);
		UTS.add(Admin);
		UTS.add(NAdmin);
		UTS.add(back);
		UTS.setSize(1500, 1500);
		UTS.setLayout(null);
		UTS.setVisible(true);

	} //AC -E

} // UTS - E
