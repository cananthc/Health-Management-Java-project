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
import java.sql.ResultSet;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;

import ErrorHandler.EmptyFields_Error_Handler;
import Models.ResultSetFetch;

public class newManager
{ //NM -S 

	
	//Declare swing components
	JFrame f = new JFrame("Manager Registration Screen");
	Image img;
	JLabel lImg, conText, nUR, nUser, lName, lPass, lPass1, lEmail, cp, cpn, lGender;
	JTextField tName, tEmail;
	JPasswordField tPass, tPass1;
	JPanel backgroundPanel;
	JButton uSubmit, uCancel, uReset;
	String searchEmail = "@";
	String[] sex = { "MALE", "FEMALE" };
	JComboBox<String> gender = new JComboBox<String>(sex);

	JComboBox<String> emailDomain = new JComboBox<String>();
	int choice;
	String MEmailID, PasswordHashValue;
	//Reference Object 
	EmptyFields_Error_Handler EEH = new EmptyFields_Error_Handler();
	ResultSet rs;
	Color c;
	
	
	
	public newManager() 
	{ //NMO -S 

		//Fetch list of domains available from DB
		try {
			domainListFetch();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		f.getContentPane().setBackground(c);

		backgroundPanel = new JPanel();
		backgroundPanel.add(lImg);
		backgroundPanel.setLayout(new OverlayLayout(backgroundPanel));
		backgroundPanel.setOpaque(true);

		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);

		nUR = new JLabel("New Manager registration");
		nUR.setFont(new Font("Calibri", Font.BOLD, 20));
		nUR.setForeground(Color.gray);
		nUR.setBounds(615, 50, 250, 100);

		nUser = new JLabel("Please Enter the details");
		nUser.setFont(new Font("Calibri", Font.PLAIN, 15));
		nUser.setBounds(635, 130, 200, 30);

		// Text text1 = new Text("Email");

		// Creating Text Filed for Name
		lName = new JLabel("Name");
		lName.setFont(new Font("Calibri", Font.PLAIN, 15));
		lName.setBounds(550, 195, 200, 30);

		tName = new JTextField();
		tName.setFont(new Font("Calibri", Font.PLAIN, 15));
		tName.setBounds(670, 200, 150, 20);

		// Creating Text Filed for Password
		lPass = new JLabel("Password");
		lPass.setFont(new Font("Calibri", Font.PLAIN, 15));
		lPass.setBounds(550, 225, 200, 30);

		lPass1 = new JLabel("Re-Enter Password");
		lPass1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lPass1.setBounds(550, 255, 200, 30);

		tPass = new JPasswordField();
		tPass.setFont(new Font("Calibri", Font.PLAIN, 15));
		tPass.setBounds(670, 230, 150, 20);

		tPass1 = new JPasswordField();
		tPass1.setFont(new Font("Calibri", Font.PLAIN, 15));
		tPass1.setBounds(670, 260, 150, 20);

		// Creating Text Filed for Email
		lEmail = new JLabel("EmailID");
		lEmail.setFont(new Font("Calibri", Font.PLAIN, 15));
		lEmail.setBounds(550, 285, 200, 30);

		tEmail = new JTextField();
		tEmail.setFont(new Font("Calibri", Font.PLAIN, 15));
		tEmail.setBounds(670, 290, 150, 20);
		
		emailDomain.setBounds(850, 290, 150, 20);
		emailDomain.setSelectedItem(null);

		lGender = new JLabel("Gender");
		lGender.setFont(new Font("Calibri", Font.PLAIN, 15));
		lGender.setBounds(550, 315, 100, 30);

		gender.setFont(new Font("Calibri", Font.PLAIN, 15));
		gender.setSelectedItem(null);
		gender.setBounds(670, 320, 150, 20);

		// Creating Buttons

		uReset = new JButton("Reset");
		uReset.setFont(new Font("Calibri", Font.PLAIN, 15));
		uReset.setBounds(670, 360, 125, 20);
		uReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				resetButton();

			}
		});

		uSubmit = new JButton("Submit");
		uSubmit.setFont(new Font("Calibri", Font.PLAIN, 15));
		uSubmit.setBounds(570, 410, 125, 20);
		uSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				submitButton(); //Perform validation
			}
		});

		uCancel = new JButton("Cancel");
		uCancel.setFont(new Font("Calibri", Font.PLAIN, 15));
		uCancel.setBounds(720, 410, 125, 20);
		uCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f.setVisible(false);
				new Welcome_Screen();

			}
		});

		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);

		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);

		f.add(cp);
		f.add(cpn);
		f.add(lImg);
		f.add(conText);
		f.add(nUR);
		f.add(nUser);
		f.add(lName);
		f.add(tName);
		f.add(lPass);
		f.add(lPass1);
		f.add(tPass);
		f.add(tPass1);
		f.add(lEmail);
		f.add(tEmail);
		f.add(lGender);
		f.add(gender);
		f.add(uReset);
		f.add(uSubmit);
		f.add(uCancel);
		f.add(emailDomain);
		f.setSize(1500, 1500);
		f.setLayout(null);
		f.setVisible(true);

	}//NMO -E 

	//Validate before inserting a record
	@SuppressWarnings("deprecation") // Password Field
	private void submitButton() {
		choice = gender.getSelectedIndex();
		if (tName.getText().equals("")) 
		{
			JOptionPane.showMessageDialog(tName, "Please Enter Your Name");
			EEH.NameEmpty("New Manager");
		}
		
		else if (tPass.getText().equals("") || tPass1.getText().equals("")) 
		{
			JOptionPane.showMessageDialog(tPass, "Please Enter The Password");
			EEH.PasswordEmpty("New Manager");
		} 
		
		else if (tEmail.getText().equals("")) 
		{
			JOptionPane.showMessageDialog(tEmail, "Please Enter Your Email-ID");
			EEH.EmailId_Empty("New Manager");
			
		} 
		
		else if(emailDomain.getSelectedIndex() == -1)
		{
			JOptionPane.showMessageDialog(emailDomain, "Please Choose Domain From The DropDown");
			emailDomain.setSelectedItem(null);
			EEH.domainEmpty("New Manager");
		}
		
		else if (tEmail.getText().contains(searchEmail))
		{
			JOptionPane.showMessageDialog(tEmail, "@ Symbol in the EmailID Textbox. Please Choose Domain From the DropDown");
			tEmail.setText("");
			EEH.EmailId_Symbol("New Manager");
		} 
		
		else if (choice == -1) 
		{
			JOptionPane.showMessageDialog(gender, "Please Select Your Gender");
			EEH.GenderEmpty("New Manager");
		} 
		else if (Arrays.equals(tPass1.getPassword(), tPass.getPassword())) {

					//Insert only if above conditions are satisfied
			try {
				MEmailID = tEmail.getText() + emailDomain.getSelectedItem();
				System.out.println(MEmailID);
				PasswordHashValue=ResultSetFetch.get_SecurePassword(tPass.getText());
				Models.InsertInToDB.insertNewManager(tName.getText(), PasswordHashValue,(String)gender.getSelectedItem(),MEmailID);
				
				resetButton();
				f.setVisible(false);
				new Login_All();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Error While Populating Records For Manager " + e);
				e.printStackTrace();
			}
			
		} else {
			JOptionPane.showMessageDialog(tPass, "Password Mismatch, Please Try Again");
			tPass.setText("");
			tPass1.setText("");
			EEH.PasswordMisMatch("New Manager");
		}
	}

	//Clear all text in JFrame
	private void resetButton() {
		tName.setText("");
		tPass.setText("");
		tPass1.setText("");
		tEmail.setText("");
		gender.setSelectedItem(null);

	}
	
	
	//Fetch domain from DB
	public  void domainListFetch() throws Exception
	{
		rs= ResultSetFetch.domainList();
		while (rs.next()) 
		{
			 emailDomain.addItem(rs.getString(1));
			 
		 }
		rs.close();
	}

}//NM -E 