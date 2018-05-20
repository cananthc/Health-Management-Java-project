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

import ErrorHandler.EmptyFields_Error_Handler;
import Models.ResultSetFetch;

public class Hosp_Category 
{ //HC - S

	//Declare swing components
	JFrame HC = new JFrame("Hospital Venture");
	JLabel lImg, welcomtex, optionText, CategorySelect, cp,cpn,conText ;
	JButton reset, submit, goBack, Logout;
	Color c;
	Image img,img1;
	String CategoryList[] = { "Head", "NeckToKnee", "KneeToToe",};
	JComboBox<String> CatDisplay = new JComboBox<String>(CategoryList);
	
	
	//Crete Ref Objects
	View.Hosp_Category VHC = new View.Hosp_Category();
	EmptyFields_Error_Handler EEH = new EmptyFields_Error_Handler();
	
	
	
	public Hosp_Category()
	{ //HCO - S
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		HC.getContentPane().setBackground(c);
		
	
		
	
		welcomtex = new JLabel("Hello, Welcome to Hospital List Category .");
		welcomtex.setBounds(570, 10, 450, 100);
		welcomtex.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomtex.setForeground(Color.gray);
		
		optionText = new JLabel("Please Select Your Options for the Report Generation");
		optionText.setBounds(570,90,400,50);
		optionText.setFont(new Font("Calibri", Font.BOLD, 15));
		optionText.setForeground(Color.gray);
		
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);
		
		
		CategorySelect = new JLabel("Pick Your Category To Display Hospital List");
		CategorySelect.setFont(new Font("Calibri", Font.PLAIN, 15));
		CategorySelect.setBounds(570,210,300,50);
		CatDisplay.setBounds(570,270,120,20);
		CatDisplay.setSelectedItem(null);
		
		reset = new JButton("Reset");
		reset.setBounds(800,270,95,20);
		reset.setFont(new Font("Calibri", Font.PLAIN, 15));
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CatDisplay.setSelectedItem(null);
			}
		});
		
		submit = new JButton("Fetch Reports");
		submit.setBounds(570,350,135,20);
		submit.setFont(new Font("Calibri", Font.PLAIN, 15));
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int count = CatDisplay.getSelectedIndex();
				if(count == -1)
				{
					JOptionPane.showMessageDialog(submit, "Please Select an Option");
					EEH.CategoryEmpty("Hosp Category Report Screen");
					
				}
				else 
				{
					
					VHC.HospCategory((count+1)); //Category converted as per DB
				}
				
				
			}
		});
		
		
		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		
		
		goBack = new JButton("Go Back");
		goBack.setBounds(750, 350, 135, 20);
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Management_Report(); //GO back
				HC.setVisible(false);
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
					ResultSetFetch.updateLogoutTime("MANAGEMENT",Login_All.UserName); //Update Logout time
					new Login_All();
					HC.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		
		
		HC.add(cp);
		HC.add(cpn);
		HC.add(lImg);
		HC.add(welcomtex);
		HC.add(conText);
		HC.add(optionText);
		HC.add(CategorySelect);
		HC.add(CatDisplay);
		HC.add(reset);
		HC.add(submit);
		HC.add(goBack);
		HC.add(Logout);
		HC.setLayout(null);
		HC.setSize(1500, 1500);
		HC.setVisible(true);
		
	} //HCO - E
	

} //HC - E
