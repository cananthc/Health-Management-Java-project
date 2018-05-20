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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;

import ErrorHandler.EmptyFields_Error_Handler;
import Models.ResultSetFetch;
import Dr.Help.Hosp_List;

public class UserAppConfirmation
{ // UAC - S

	
	// Declare all the necessary Variables
	JFrame UAC = new JFrame("Appointment Schedule");
	JLabel DropDownLabel, ZipCodeLabel, Header, appointCat, conText,cp,cpn;
	JTextField ipLoc, appointDesc;
	String location[] = { "Chicago", "Dallas", "New York", "Phoenix" };
	JComboBox<String> cb = new JComboBox<String>(location);
	JCheckBox insurOpt;
	JButton Search, Reset, goBack,Logout;
	int choice;
	int category;
	Image img,img1;
	public static String locName;
	
	// Create Ref Object to Handle Empty Fields
	EmptyFields_Error_Handler EEH = new EmptyFields_Error_Handler();
	
	public UserAppConfirmation(String getMedCat) 
	{ // UACC - S

		// Image
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		JLabel lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		Color c = new Color(245, 252, 196);
		UAC.getContentPane().setBackground(c);

		// Background Panel
		JPanel backgroundPanel = new JPanel();
		backgroundPanel.add(lImg);
		backgroundPanel.setLayout(new OverlayLayout(backgroundPanel));
		backgroundPanel.setOpaque(true);

		//Header Label for Image
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);

		// Display Screen Name
		Header = new JLabel("Welcome to Appointment Schedule Screen");
		Header.setFont(new Font("Calibri", Font.BOLD, 20));
		Header.setForeground(Color.gray);
		Header.setBounds(525, 100, 400, 50);

		// Select Location Label
		DropDownLabel = new JLabel("Select Your Location of Visit");
		DropDownLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		DropDownLabel.setBounds(530, 180, 200, 100);

	
		// Appointment Category Label
		appointCat = new JLabel("Category");
		appointCat.setFont(new Font("Calibri", Font.PLAIN, 15));
		appointCat.setBounds(530, 255, 150, 50);

		// Appointment Description TextField
		appointDesc = new JTextField();
		appointDesc.setFont(new Font("Calibri", Font.PLAIN, 15));
		appointDesc.setBounds(720, 270, 100, 20);

		// Select Location to book an appointment
		cb.setSelectedItem(null);
		cb.setFont(new Font("Calibri", Font.PLAIN, 15));
		cb.setBounds(720, 220, 90, 20);

		
		//Checkbox for Medical Insurance
		insurOpt = new JCheckBox("Do you Have Medical Insurance?");
		insurOpt.setFont(new Font("Calibri", Font.PLAIN, 15));
		insurOpt.setBackground(c);
		insurOpt.setBounds(530, 345, 250, 50);

		//Go-Back one screen 
		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(630, 445, 85, 20);

		// Grayout the Text area to ensure Category is not changed
		appointDesc.setText(getMedCat.toString());
		appointDesc.setEditable(false);
		
		
		// Rest all the fields
		Reset = new JButton("Reset");
		Reset.setFont(new Font("Calibri", Font.PLAIN, 15));
		Reset.setBounds(720, 405, 85, 20);
		Reset.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ipLoc.setText(" "); //Clear Location Text
				cb.setSelectedItem(null); // Reset Dropdown of the Location

			}
		});

		// Move to next screen after selecting required fields
		Search = new JButton("Search");
		Search.setFont(new Font("Calibri", Font.PLAIN, 15));
		Search.setBounds(540, 405, 85, 20);
		Search.addActionListener(new ActionListener()
		{ //S - S

			@Override
			public void actionPerformed(ActionEvent e) 
			{//SearchOp - S
				// TODO Auto-generated method stub

				choice = cb.getSelectedIndex(); // Get selected Index from the Dropdown
				locName=(String) cb.getSelectedItem(); // Get Location Name
				//System.out.println(locName);
				
				if (choice == -1)
				{ //Se 1.0 -S

					JOptionPane.showMessageDialog(cb, "Please Select a Location");
					EEH.userHospSearch("User Hosp Location Search");
					cb.setFont(new Font("Calibri", Font.PLAIN, 30));
				} //Se 1.0 -E
				
				else 
				{ //Se 1.1 -S
					if (choice == 0) 
					{//Se 1.1.1 -S
						if (insurOpt.isSelected()) 
							{ //Se 1.1.1.1 -S
							new Hosp_List(choice, locName);
							UAC.setVisible(false);
							}//Se 1.1.1.1 -E
						else 
							{//Se 1.1.1.2 -S
							new Hosp_List(-1, locName);
							UAC.setVisible(false);
							}//Se 1.1.1.2 -E
						
					}//Se 1.1.1 -E
					
					else if (choice == 1) 
					{//Se 1.1.2 -S
						if (insurOpt.isSelected()) 
							{//Se 1.1.2.1 -S
							new Hosp_List(choice, locName);
							UAC.setVisible(false);
							}//Se 1.1.2.1 -E 
						else 
							{//Se 1.1.2.2 -S
							new Hosp_List(-2, locName);
							UAC.setVisible(false);
							}//Se 1.1.2.2 -E

					}//Se 1.1.2 -E 
					
					else if (choice == 2) 
					{//Se 1.1.3 -S
						if (insurOpt.isSelected()) 
							{//Se 1.1.3.1 -S
								new Hosp_List(choice, locName);
								UAC.setVisible(false);
							}//Se 1.1.3.1 -E
						else 
							{//Se 1.1.3.2 -S
							new Hosp_List(-3, locName);
							UAC.setVisible(false);
							}//Se 1.1.3.2 -E
					} //Se 1.1.3 -E
					
					else if (choice == 3) 
					{//Se 1.1.4 -S
						if (insurOpt.isSelected()) 
							{//Se 1.1.4.1 -S
							new Hosp_List(choice, locName);
							UAC.setVisible(false);
							}//Se 1.1.4.1 -E 
						else 
							{//Se 1.1.4.2 -S
								new Hosp_List(-4, locName);
								UAC.setVisible(false);
							}//Se 1.1.4.2 -E
					}//Se 1.1.4 -E

					else 
					{//Se 1.1.5 -S
						JOptionPane.showMessageDialog(Search, "Please Select an Option");
						Search.setFont(new Font("Calibri", Font.PLAIN, 15));
						UAC.setVisible(true);
					}//Se 1.1.5 -E
					
				}//Se 1.1 -E

			}//SearchOp - S
		}); //S - E

		goBack.addActionListener(new ActionListener() 
		{ //Go-Back -S

			@Override
			public void actionPerformed(ActionEvent e) {
				UAC.setVisible(false);
				new IssueDescription();

			}
		});//Go-Back -E
		
		//Copyrights
		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		
		//Logout Option
		Logout = new JButton("LOGOUT");
		Logout.setFont(new Font("Calibri", Font.BOLD, 15));
		Logout.setForeground(Color.GRAY);
		Logout.setBounds(1100, 120, 150, 30);
		img1 = new ImageIcon(this.getClass().getResource("/l.png")).getImage();
		Logout.setBackground(c);
		Logout.setIcon(new ImageIcon(img1));
		Logout.setBorderPainted(false);
		Logout.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try 
				{
					ResultSetFetch.updateLogoutTime("USER",Login_All.UserName);
					new Login_All(); // Return Back to Login Page
					UAC.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		//Add all the necessary Fields need in the JFrame
		UAC.add(cp);
		UAC.add(cpn);
		UAC.add(Logout);
		UAC.add(lImg);
		UAC.add(conText);
		UAC.add(insurOpt);
		UAC.add(DropDownLabel);
		UAC.add(Header);
		
		UAC.add(Search);
		UAC.add(Reset);
		UAC.add(goBack);
		UAC.add(appointCat);
		UAC.add(appointDesc);
		UAC.add(cb);
		UAC.setLayout(null);
		UAC.setSize(1500, 1500);
		UAC.setVisible(true);

	}// UACC - E
	
	
}// UAC - E

