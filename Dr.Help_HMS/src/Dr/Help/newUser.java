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
import java.util.Date;

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

import com.toedter.calendar.JDateChooser;

import ErrorHandler.EmptyFields_Error_Handler;
import Models.ResultSetFetch;

public class newUser 
{ //NU -S
	//Declare swing components
	public String dob;
	JFrame f = new JFrame("User Registration Screen");
	JDateChooser dateChooser = new JDateChooser();
	JLabel lImg, conText, nUR, nUser, lName, lPass, lPass1, lDob, lEmail, lPhone, cp, cpn, lGender;
	JTextField tName, tDob, tEmail, tPhone;
	JPasswordField tPass, tPass1;
	JButton uSubmit, uCancel, uReset;
	Image img;
	JPanel backgroundPanel;
	String[] sex = { "MALE", "FEMALE" };
	JComboBox<String> gender = new JComboBox<String>(sex);

	JComboBox<String> emailDomain = new JComboBox<String>();
	int choice;
	String searchEmail = "@";
	Date date;
	int MM, DD, YYYY;
	String Date_Final, YY, UEmailID, PasswordHashValue;
	ResultSet rs;
	Color c;
	
	
	//Create Ref Objects
	EmptyFields_Error_Handler EEH = new EmptyFields_Error_Handler();

	
	/*
	 * New User Details
	 * 
	 */
	public newUser() 
	{ //NUO -S
		//Fetch domain from DB
		try {
			domainListFetch();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dateChooser.setDateFormatString("dd/MM/yyyy");

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

		nUR = new JLabel("New User registration");
		nUR.setFont(new Font("Calibri", Font.BOLD, 20));
		nUR.setForeground(Color.gray);
		nUR.setBounds(615, 50, 250, 100);

		nUser = new JLabel("Please Enter the details");
		nUser.setFont(new Font("Calibri", Font.PLAIN, 15));
		nUser.setBounds(635, 130, 200, 30);

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

		tPass = new JPasswordField();
		tPass.setFont(new Font("Calibri", Font.PLAIN, 15));
		tPass.setBounds(670, 230, 150, 20);

		lPass1 = new JLabel("Re-Enter Password");
		lPass1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lPass1.setBounds(550, 255, 200, 30);

		tPass1 = new JPasswordField();
		tPass1.setFont(new Font("Calibri", Font.PLAIN, 15));
		tPass1.setBounds(670, 260, 150, 20);

		// Creating Text Filed for Date of Birth
		lDob = new JLabel("Date of Birth");
		lDob.setFont(new Font("Calibri", Font.PLAIN, 15));
		lDob.setBounds(550, 285, 200, 30);

		tDob = new JTextField();
		tDob.setFont(new Font("Calibri", Font.PLAIN, 15));
		// tDob.setBounds(900, 260, 150, 20);
		dateChooser.setBounds(670, 290, 170, 20);

		// Creating Text Filed for Email
		lEmail = new JLabel("EmailID");
		lEmail.setFont(new Font("Calibri", Font.PLAIN, 15));
		lEmail.setBounds(550, 315, 200, 30);

		tEmail = new JTextField();
		tEmail.setFont(new Font("Calibri", Font.PLAIN, 15));
		tEmail.setBounds(670, 320, 150, 20);

		emailDomain.setBounds(850, 320, 150, 20);
		emailDomain.setSelectedItem(null);
		
		// Creating Text Filed for Phone
		lPhone = new JLabel("Phone");
		lPhone.setFont(new Font("Calibri", Font.PLAIN, 15));
		lPhone.setBounds(550, 346, 200, 30);

		tPhone = new JTextField();
		tPhone.setFont(new Font("Calibri", Font.PLAIN, 15));
		tPhone.setBounds(670, 350, 150, 20);

		lGender = new JLabel("Gender");
		lGender.setFont(new Font("Calibri", Font.PLAIN, 15));
		lGender.setBounds(550, 376, 100, 30);

		gender.setFont(new Font("Calibri", Font.PLAIN, 15));
		gender.setSelectedItem(null);
		gender.setBounds(670, 380, 150, 20);

		// Creating Buttons
		uReset = new JButton("Reset");
		uReset.setFont(new Font("Calibri", Font.PLAIN, 15));
		uReset.setBounds(670, 420, 125, 20);
		uReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				resetButton();

			}
		});

		uSubmit = new JButton("Submit");
		uSubmit.setFont(new Font("Calibri", Font.PLAIN, 15));
		uSubmit.setBounds(570, 470, 125, 20);
		uSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
					submitButton(); //Validate before inserting records
				

			}
		});

		uCancel = new JButton("Cancel");
		uCancel.setFont(new Font("Calibri", Font.PLAIN, 15));
		uCancel.setBounds(750, 470, 125, 20);
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
		f.add(lDob);
		f.add(tDob);
		f.add(dateChooser);
		f.add(lEmail);
		f.add(tEmail);
		f.add(lPhone);
		f.add(tPhone);
		f.add(lGender);
		f.add(gender);
		f.add(uSubmit);
		f.add(uCancel);
		f.add(uReset);
		f.add(emailDomain);
		f.setSize(1500, 1500);
		f.setLayout(null);
		f.setVisible(true);

	} //NUO -E

	//Validations 
	// Submit Button Actions
	@SuppressWarnings("deprecation") // Password Field
	private void submitButton() {
		choice = gender.getSelectedIndex();
		if (tName.getText().equals("")) 
		{
			JOptionPane.showMessageDialog(tName, "Please Enter Your Name");
			EEH.NameEmpty("New User");
			
		}
		
		else if (tPass.getText().equals("") || tPass1.getText().equals("")) 
		{
			JOptionPane.showMessageDialog(tPass, "Please Enter The Password");
			EEH.PasswordEmpty("New User");
			tPass.setText("");
			tPass1.setText("");
		} 
		
		else if (dateChooser.getDate() == null)
		{
			JOptionPane.showMessageDialog(dateChooser, "Please Enter Your DOB");
			EEH.DOBEmpty("New User");
		} 
		
		else if (tEmail.getText().equals("")) 
		{
			JOptionPane.showMessageDialog(tEmail, "Please Enter Your Email-ID");
			EEH.EmailId_Empty("New User");
		} 
		
				
		else if (tEmail.getText().contains(searchEmail))
		{
			JOptionPane.showMessageDialog(tEmail, "@ Symbol in the EmailID Textbox. Please Choose Domain From the DropDown");
			tEmail.setText("");
			EEH.InvalidEmailID("New User");
		}
		
		else if(emailDomain.getSelectedIndex() == -1)
		{
			JOptionPane.showMessageDialog(emailDomain, "Please Choose Domain From The DropDown");
			emailDomain.setSelectedItem(null);
			EEH.domainEmpty("New User");
		}
		
		else if (tPhone.getText().equals("")) 
		{
			JOptionPane.showMessageDialog(tEmail, "Please Enter Your Phone Number");
			EEH.PhoneNumberEmpty("New User");
		} 
		
		else if (!(tPhone.getText().length() == 10)) 
		{
			JOptionPane.showMessageDialog(tPhone, "Please Enter Valid Phone Number");
			tPhone.setText("");
			EEH.PhoneNumberInvalid("New User");
		} 
		
		else if (choice == -1) 
		{
			JOptionPane.showMessageDialog(gender, "Please Select Your Gender");
			EEH.GenderEmpty("New User");
		}

		else if (Arrays.equals(tPass1.getPassword(), tPass.getPassword())) {

			// Insert into Users Table after Validations
			try {
				
				UEmailID = tEmail.getText() + emailDomain.getSelectedItem();
				PasswordHashValue=ResultSetFetch.get_SecurePassword(tPass.getText());
				
				Models.InsertInToDB.insertNewUsers(tName.getText(),PasswordHashValue , getDOB(),
						(String) gender.getSelectedItem(), UEmailID, tPhone.getText());
				
				//JOptionPane.showMessageDialog(tName, "Successfully Registered. Please Login");
				resetButton();
				new Login_All();
				f.setVisible(false);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Error While Populating User Records " + e);
			}

		} else {
			JOptionPane.showMessageDialog(tPass, "Password Mismatch, Please Try Again");
			tPass.setText("");
			tPass1.setText("");
			EEH.PasswordMisMatch("New User");

		}
	}

	// Reset Button actions
	private void resetButton() {
		tName.setText("");
		tPass.setText("");
		tPass1.setText("");
		dateChooser.setDate(null);
		tEmail.setText("");
		tPhone.setText("");
		gender.setSelectedItem(null);
	}

	// Format DOB to match Oracle Standards
	@SuppressWarnings("deprecation") //  For Deprecation
	public String getDOB() {
		date = dateChooser.getDate();
		System.out.println(date);
		MM = date.getMonth();
		DD = date.getDate();
		YYYY = date.getYear();
		if (YYYY >= 100) {
			YY = String.valueOf(YYYY).substring(1);
			Date_Final = ((MM + 1) + "-" + DD + "-" + YY);
		} else {
			Date_Final = ((MM + 1) + "-" + DD + "-" + YYYY);
			System.out.println(Date_Final);
		}

		System.out.println(Date_Final);
		return Date_Final;
	}
	
	//Fetch domain list from DB
	
	public  void domainListFetch() throws Exception
	{
		rs= ResultSetFetch.domainList();
		while (rs.next()) 
		{
			 emailDomain.addItem(rs.getString(1));
			 
		 }
		rs.close();
	}
	
	
} //NU -E
