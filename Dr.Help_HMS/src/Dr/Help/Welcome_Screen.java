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

public class Welcome_Screen 
{ //WS - S

	
	
	public Welcome_Screen() // Constructor
	{ //WSO- S

		//Declare swing components
		JFrame WS = new JFrame("Login Screen"); // Title
		JLabel headerTex, catTex, conText, cp, cpn;
		JButton User, Doctor, Manager, Admin, goBack, Logout;

		Image img,img1;
		JLabel lImg;
		Color c;

		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		WS.getContentPane().setBackground(c);
		
		
		JPanel backgroundPanel = new JPanel();
		backgroundPanel.add(lImg);
		backgroundPanel.setLayout(new OverlayLayout(backgroundPanel));
		backgroundPanel.setOpaque(true);

		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);

		headerTex = new JLabel("Welcome to Dr.Help Registration Page"); // Display in the JFrame
		headerTex.setFont(new Font("Calibri", Font.BOLD, 20));
		headerTex.setForeground(Color.gray);
		headerTex.setBounds(560, 70, 350, 100); // Position X, Y, Length, Width

		catTex = new JLabel("Please Select Your Category"); // Display in the JFrame
		catTex.setFont(new Font("Calibri", Font.PLAIN, 15));
		catTex.setBounds(630, 130, 200, 100); // Position X, Y, Length, Width

		User = new JButton("User"); // User Button
		User.setFont(new Font("Calibri", Font.PLAIN, 15));
		User.setBounds(650, 220, 100, 20); //// Position X, Y, Length, Width

		// Move to Next Screen addActionListener is used to perform what needs to be
		// done if the button is clicked
		User.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new UserType_Selection(1); // Call the UserType_Selection Constructor
				WS.setVisible(false); // Don't Display Welcome_Screen if false

			}
		});

		Manager = new JButton("Manager"); // Manager Button
		Manager.setFont(new Font("Calibri", Font.PLAIN, 15));
		Manager.setBounds(650, 260, 100, 20); // Position X, Y, Length, Width
		Manager.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new UserType_Selection(3); // Calls the UserType_Selection Constructor
				WS.setVisible(false); // Don't Display Welcome_Screen if false
			}
		});

		Doctor = new JButton("Doctor"); // Doctor Button
		Doctor.setFont(new Font("Calibri", Font.PLAIN, 15));
		Doctor.setBounds(650, 300, 100, 20); // Position X, Y, Length, Width
		Doctor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new UserType_Selection(2); // Calls the UserType_Selection Constructor
				WS.setVisible(false); // Don't Display Welcome_Screen if false
			}
		});

		Admin = new JButton("Admin"); // Doctor Button
		Admin.setFont(new Font("Calibri", Font.PLAIN, 15));
		Admin.setBounds(650, 340, 100, 20); // Position X, Y, Length, Width
		Admin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new UserType_Selection(4); // Calls the UserType_Selection Constructor
				WS.setVisible(false); // Don't Display Welcome_Screen if false

			}
		});

		goBack = new JButton("Go Back");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(650, 380, 100, 20);
		goBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				WS.setVisible(false);
				new Login_All(); //Go back

			}
		});
		
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
				new Login_All();
				WS.setVisible(false);
			}
		});
		
		
		
		WS.add(cp);
		WS.add(cpn);

		WS.add(lImg); // Display Label 1 in the JFrame
		WS.add(conText);
		WS.add(headerTex); // Display Label 1 in the JFrame
		WS.add(catTex); // Display Label 2 in the JFrame
		WS.add(User); // Display User Button in the JFrame
		WS.add(Manager); // Display Manager Button in the JFrame
		WS.add(Doctor); // Display Doctor Button in the JFrame
		WS.add(Admin); // Display Admin Button in the JFrame
		WS.add(goBack);
		WS.setSize(1500, 1500); // JFrame Length and Width
		WS.setLayout(null); // Dont have the border
		WS.setVisible(true); // Display the Welcome_Screen JFrame

	} //WSO- E 

} //WS - E
