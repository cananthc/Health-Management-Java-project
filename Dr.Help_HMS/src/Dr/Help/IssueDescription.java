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

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.OverlayLayout;

import ErrorHandler.EmptyFields_Error_Handler;
import Models.ResultSetFetch;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class IssueDescription
{ //ID -S
	
	//Declare all the necessary variables which is needed in JFrame
	JFrame DC = new JFrame("Issue Description");
	JLabel welcomtex1, conText, cp, cpn;
	JRadioButton headButton, neckToKnee, kneeToToe, medHist,HospSearch;
	JButton nextButton, resetButton,Logout;
	ButtonGroup group;
	public static String category;
	Image img,img1;
	
	//Create Ref Object for Empty Field Handler
	EmptyFields_Error_Handler EEH = new EmptyFields_Error_Handler();
	
	public IssueDescription() 
	{// ID -S

		
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		JLabel lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		Color c = new Color(245, 252, 196);
		DC.getContentPane().setBackground(c);

		JPanel backgroundPanel = new JPanel();
		backgroundPanel.add(lImg);
		backgroundPanel.setLayout(new OverlayLayout(backgroundPanel));
		backgroundPanel.setOpaque(true);

		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);

		welcomtex1 = new JLabel("Hello, Please Choose From The Below Options to Begin");
		welcomtex1.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomtex1.setForeground(Color.gray);
		welcomtex1.setBounds(500, 70, 500, 100);

		
		//Cat-1 Selection
		group = new ButtonGroup(); // For selecting only one Radio Button
		headButton = new JRadioButton("Head");
		headButton.setFont(new Font("Calibri", Font.PLAIN, 15));
		group.add(headButton);
		headButton.setBounds(600, 170, 150, 40);
		headButton.setBackground(c);

		//Cat-2 Selection
		neckToKnee = new JRadioButton("Neck to Knee");
		neckToKnee.setFont(new Font("Calibri", Font.PLAIN, 15));
		group.add(neckToKnee);
		neckToKnee.setBounds(600, 200, 150, 40);
		neckToKnee.setBackground(c);

		//Cat-3 Selection
		kneeToToe = new JRadioButton("Knee to Toe");
		kneeToToe.setFont(new Font("Calibri", Font.PLAIN, 15));
		group.add(kneeToToe);
		kneeToToe.setBounds(600, 230, 150, 40);
		kneeToToe.setBackground(c);

		//MedHistory Selection
		medHist = new JRadioButton("Medical History");
		medHist.setFont(new Font("Calibri", Font.PLAIN, 15));
		group.add(medHist);
		medHist.setBounds(600, 260, 150, 40);
		medHist.setBackground(c);
		
		
		//HospSearch Selection
		HospSearch = new JRadioButton("Search Medical Shop");
		HospSearch.setFont(new Font("Calibri", Font.PLAIN, 15));
		group.add(HospSearch);
		HospSearch.setBounds(600, 290, 200, 40);
		HospSearch.setBackground(c);		
		
		//Next Button Selection
		nextButton = new JButton("Next");
		nextButton.setFont(new Font("Calibri", Font.PLAIN, 15));
		nextButton.setBounds(570, 380, 85, 25);
		nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				moveNextScreen(); // Calls Next Screen
			}
		});

		
		//Reset All Values
		resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Calibri", Font.PLAIN, 15));
		resetButton.setBounds(700, 380, 85, 25);
		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				group.clearSelection(); // Clears Radio Button Selection

			}
		});

		//Copyrights
		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		
		
		// Logout Button
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
					ResultSetFetch.updateLogoutTime("USER",Login_All.UserName);
					new Login_All(); // Return Back to Login Page
					DC.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		// Add all the necessary items in JFrame
		DC.add(cp);
		DC.add(cpn);
		DC.add(Logout);
		DC.add(lImg);
		DC.add(conText);

		DC.add(welcomtex1);
		DC.add(headButton);
		DC.add(neckToKnee);
		DC.add(kneeToToe);
		DC.add(medHist);
		DC.add(HospSearch);
		DC.add(nextButton);
		DC.add(resetButton);
		DC.setLayout(null);
		DC.setVisible(true);
		DC.setSize(1500, 1500);

	} // ID -E

	// Move to the respective screen depending upon the RadioButton Selection
	private void moveNextScreen() 
	{ //MNS - S

		
		if (headButton.isSelected()) 
		{ //R 1.0 -S
			category="Head";
			new UserAppConfirmation(category);
			DC.setVisible(false);
		}//R 1.0 -E
		
		else if (neckToKnee.isSelected()) 
		{//R 1.1 -S
			category="NeckToKnee";
			new UserAppConfirmation(category);
			DC.setVisible(false);
		} //R 1.1 -E
		
		
		else if (kneeToToe.isSelected()) 
		{//R 1.2 -S
			category="KneeToToe";
			new UserAppConfirmation(category);
			DC.setVisible(false);
		}//R 1.2 -E
		
		
		else if (HospSearch.isSelected())
		{//R 1.3 -S
			new NearByMedicalShop("USER");
			DC.setVisible(false);
		}//R 1.3 -E		
		
		else if(medHist.isSelected())
		{//R 1.4 -S
			JOptionPane.showMessageDialog(medHist, "Page Under Construction");
		}//R 1.4 -E
		
		else 
		{//R 1.5 -S
			JOptionPane.showMessageDialog(nextButton, "Plese Select an Option To Proceed");
			EEH.userSelectionEmpty("User Screen IssueDescription");
			DC.setVisible(true);
		}//R 1.5 -E
		
	}//MNS - S

} //ID -E


