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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;

import ErrorHandler.EmptyFields_Error_Handler;
import Models.ResultSetFetch;
import View.MedView;

public class NearByMedicalShop 
{ //NBMS - S

	
	//Declare swing components
	JFrame NBMS = new JFrame();
	JLabel welcomTex,conText,welcomTex2, locName, ZipCode, Choice,lImg;
	JTextField tlocName, tZipCode;
	Color c; 
	JButton fetch, reset, goBack, Logout;
	Image img,img1;
	MedView MV = new MedView();
	
	
	//Create a Reference Object for Empty Fields Handler
	EmptyFields_Error_Handler EEH = new EmptyFields_Error_Handler();
	
	/*
	 * 
	 * Below is to Provide List of Hosp 
	 * 
	 */
	
	public NearByMedicalShop(String Screen)
	{ //NBMSO - S
		
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		NBMS.getContentPane().setBackground(c);
		
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);

		welcomTex = new JLabel("Welcome to Dr.Help");
		welcomTex.setBounds(600, 10, 250, 100);
		welcomTex.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomTex.setForeground(Color.gray);
		
		welcomTex2 = new JLabel("Please Enter Below To Find NearBy Pharmacies");
		welcomTex2.setFont(new Font("Calibri", Font.PLAIN, 15));
		welcomTex2.setBounds(600,100,350,100);
		
		
		
		locName = new JLabel("Location");
		locName.setFont(new Font("Calibri", Font.PLAIN, 15));
		locName.setBounds(550, 200, 100, 25);
		
		tlocName = new JTextField(4);
		tlocName.setFont(new Font("Calibri", Font.PLAIN, 15));
		tlocName.setBounds(630, 200, 150, 25);
		
		Choice = new JLabel("(OR)");
		Choice.setBounds(680, 225, 100, 25);
		
		
		ZipCode = new JLabel("ZipCode");
		ZipCode.setFont(new Font("Calibri", Font.PLAIN, 15));
		ZipCode.setBounds(550,250,100,25);
		
		tZipCode = new JTextField();
		tZipCode.setFont(new Font("Calibri", Font.PLAIN, 15));
		tZipCode.setBounds(630, 250, 150, 25);
		
		
		//Perform Validations and list hosp
		fetch = new JButton("Fetch");
		fetch.setFont(new Font("Calibri", Font.PLAIN, 15));
		fetch.setBounds(570, 325, 95, 25);
		
		fetch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{ //Action - S
				// TODO Auto-generated method stub
				
			if(tlocName.getText().equals(""))
			{ //If 1.0 -S
				if(tZipCode.getText().equals(""))
				{//If 1.1 -S
					JOptionPane.showMessageDialog(tlocName, "Please Enter Any One");
					EEH.locationORZipCodeEmpty("Hosp Search");
				} //If 1.1 -E
				else
				{ //else 1.1 -S
					try {
						searchByZipCode(tZipCode.getText()); //Search Hosp depending upon ZipCode
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}//else 1.1 -E
			} //If 1.0 -E
			else
			{ //else 1.0 -S
				try {
					System.out.println(tlocName.getText().toUpperCase());
					searchMedicalShopByLocation(tlocName.getText().toUpperCase()); //Search Hops  Depending upon Location
				} catch (Exception e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} //else 1.0 -E
			
			} //Action - E
		});
		
		reset = new JButton("Clear");
		reset.setFont(new Font("Calibri", Font.PLAIN, 15));
		reset.setBounds(700,325,85,25);
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					clearButton(); //Clear all text
			}
		});
			
		
		//Go back to respective screen
		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(630,385,85,25);
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Screen.equals("USER"))
				{
					new IssueDescription();
					NBMS.setVisible(false);
				}
				else if(Screen.equals("MANAGEMENT"))
				{
					new Management_Report();
					NBMS.setVisible(false);
				}
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
					System.out.println(Login_All.UserName);
					ResultSetFetch.updateLogoutTime("MANAGEMENT",Login_All.UserName); //Update Logout Time
					new Login_All();
					NBMS.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		NBMS.add(lImg);
		NBMS.add(conText);
		NBMS.add(welcomTex);
		NBMS.add(welcomTex2);
		NBMS.add(locName);
		NBMS.add(tlocName);
		NBMS.add(ZipCode);
		NBMS.add(tZipCode);
		NBMS.add(Choice);
		NBMS.add(fetch);
		NBMS.add(reset);
		NBMS.add(goBack);
		NBMS.add(Logout);
		NBMS.setLayout(null);
		NBMS.setSize(1500, 1500);
		NBMS.setVisible(true);
	} //NBMSO - E
	
	

	
	//Pass Location to the below Method to display
	public void searchMedicalShopByLocation(String tLocName) throws Exception
	{
		MV.MedViewByLoc(tLocName);
	}
	
	//Pass Zipcode to the below Method to display
	public void searchByZipCode(String tZipCode) throws Exception
	{
		MV.MedView(tZipCode);
	}
	
	
	//Clears text in the JFrame
	public void clearButton()
	{
		tlocName.setText("");
		tZipCode.setText("");
	}
	 
} //NBMS - E
