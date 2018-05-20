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

public class newDoctor 


{ //ND -S
	//Declare swing components
	JFrame f = new JFrame("Doctor Registration Screen");
	JDateChooser dateChooser = new JDateChooser();
	JLabel nUR, nUser, lImg, conText, lName, lPass, lPass1, lDob, lEmail, lPhone, lCat, lHospital, cp, cpn, lGender;
	JTextField tName, tDob, tEmail, tPhone, tCat, tHospital;
	JPasswordField tPass, tPass1;
	Image img;
	JPanel backgroundPanel;
	JButton uSubmit, uCancel, uReset;
	String[] catSelect = { "Head", "NeckToKnee", "KneeToToe" };
	JComboBox<String> catDisp = new JComboBox<String>(catSelect);
	int choice, choiceGender;
	String searchEmail = "@";
	String[] sex = { "MALE", "FEMALE" };
	JComboBox<String> gender = new JComboBox<String>(sex);
	ResultSet rs;
	JComboBox<String> emailDomain = new JComboBox<String>();
	Date date;
	int MM, DD, YYYY;
	String Date_Final, YY, DEmailID,PasswordHashValue;
	Color c;
	
	//Create Ref Objects for Empty Fields Identifier
	EmptyFields_Error_Handler EEH = new EmptyFields_Error_Handler();
	
	
	public newDoctor() 
	{ //NDO - S
		//Fetch domain list
		try {
			domainListFetch();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		dateChooser.setDateFormatString("yyyy-MM-dd");

		nUR = new JLabel("New Doctor registration");
		nUR.setFont(new Font("Calibri", Font.BOLD, 20));
		nUR.setForeground(Color.gray);
		nUR.setBounds(615, 50, 250, 100);

		nUser = new JLabel("Please Enter the details");
		nUser.setFont(new Font("Calibri", Font.PLAIN, 15));
		nUser.setBounds(635, 130, 200, 30);

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

		// Creating Text Filed for Date of Birth
		lDob = new JLabel("Date of Birth");
		lDob.setFont(new Font("Calibri", Font.PLAIN, 15));
		lDob.setBounds(550, 285, 200, 30);

		tDob = new JTextField();
		tDob.setFont(new Font("Calibri", Font.PLAIN, 15));
		// tDob.setBounds(650, 260, 150, 20);
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
		lPhone.setBounds(550, 345, 200, 30);

		tPhone = new JTextField();
		tPhone.setFont(new Font("Calibri", Font.PLAIN, 15));
		tPhone.setBounds(670, 350, 150, 20);

		// Creating Text Filed for Category
		lCat = new JLabel("Category");
		lCat.setFont(new Font("Calibri", Font.PLAIN, 15));
		lCat.setBounds(550, 375, 200, 30);

		catDisp.setSelectedItem(null);
		catDisp.setBounds(670, 380, 150, 20);
		catDisp.setFont(new Font("Calibri", Font.PLAIN, 15));

		// Creating Text Filed for Hospital
		lHospital = new JLabel("Hospital");
		lHospital.setFont(new Font("Calibri", Font.PLAIN, 15));
		lHospital.setBounds(550, 405, 200, 30);

		tHospital = new JTextField();
		tHospital.setFont(new Font("Calibri", Font.PLAIN, 15));
		tHospital.setBounds(670, 410, 150, 20);

		lGender = new JLabel("Gender");
		lGender.setFont(new Font("Calibri", Font.PLAIN, 15));
		lGender.setBounds(550, 435, 100, 30);

		gender.setFont(new Font("Calibri", Font.PLAIN, 15));
		gender.setSelectedItem(null);
		gender.setBounds(670, 440, 150, 20);

		uReset = new JButton("Reset");
		uReset.setFont(new Font("Calibri", Font.PLAIN, 15));
		uReset.setBounds(670, 480, 125, 20);
		uReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				resetButton();
			}
		});

		uSubmit = new JButton("Submit");
		uSubmit.setFont(new Font("Calibri", Font.PLAIN, 15));
		uSubmit.setBounds(570, 520, 125, 20);
		uSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					submitButton(); //Validate before inserting the record
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		uCancel = new JButton("Cancel");
		uCancel.setFont(new Font("Calibri", Font.PLAIN, 15));
		uCancel.setBounds(720, 520, 125, 20);
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
		f.add(lCat);
		f.add(catDisp);
		f.add(lHospital);
		f.add(tHospital);
		f.add(lGender);
		f.add(gender);
		f.add(uReset);
		f.add(uSubmit);
		f.add(uCancel);
		f.add(emailDomain);
		f.setSize(1500, 1500);
		f.setLayout(null);
		f.setVisible(true);

	} //NDO - E

	
	//Clears all text in JFrame
	private void resetButton() {
		tName.setText("");
		tPass.setText("");
		tPass1.setText("");
		tDob.setText("");
		tEmail.setText("");
		tPhone.setText("");
		catDisp.setSelectedItem(null);
		tHospital.setText("");
		dateChooser.setDate(null);
		gender.setSelectedItem(null);
	}

	//Perform Validation before insertion
	@SuppressWarnings("deprecation") //Password Field
	private void submitButton() 
	{
		choice = catDisp.getSelectedIndex();
		choiceGender = gender.getSelectedIndex();
		if(tName.getText().equals(""))
		{
			JOptionPane.showMessageDialog(tName, "Please Enter Your Name");
			EEH.NameEmpty("New Doctor");
		}
		else if(tPass.getText().equals("") || tPass1.getText().equals(""))
		{
			JOptionPane.showMessageDialog(tPass, "Please Enter The Password");
			EEH.PasswordEmpty("New Doctor");
		}
		else if(dateChooser.getDate() == null)
		{
			JOptionPane.showMessageDialog(dateChooser, "Please Enter Your DOB");
			EEH.DOBEmpty("New Doctor");
		}
		else if(tEmail.getText().equals(""))
		{
			JOptionPane.showMessageDialog(tEmail, "Please Enter Your Email-ID");
			EEH.EmailId_Empty("New Doctor");
		}
		else if(tEmail.getText().contains(searchEmail))
		{
			JOptionPane.showMessageDialog(tEmail, "@ Symbol in the EmailID Textbox. Please Choose Domain From the DropDown");
			tEmail.setText("");
			EEH.EmailId_Symbol("New Doctor");
		}
		
		else if(emailDomain.getSelectedIndex() == -1)
		{
			JOptionPane.showMessageDialog(emailDomain, "Please Choose Domain From The DropDown");
			emailDomain.setSelectedItem(null);
			EEH.domainEmpty("New Doctor");
		}
		
		else if(tPhone.getText().equals(""))
		{
			JOptionPane.showMessageDialog(tEmail, "Please Enter Your Phone Number");
			EEH.PhoneNumberEmpty("New Doctor");
		}
		else if(!(tPhone.getText().length() ==10))
		{
			JOptionPane.showMessageDialog(tPhone, "Please Enter Valid Phone Number");
			EEH.PhoneNumberInvalid("New Doctor");
		}
		else if(choice == -1)
		{
			JOptionPane.showMessageDialog(catDisp, "Please Choose a Category");
			EEH.docCateEmpty("New Doctor");
		}
		else if(tHospital.getText().equals(""))
		{
			JOptionPane.showMessageDialog(tHospital, "Enter Your Hospital Name");
			EEH.docHospEmpty("New Doctor");
		}
		else if(choiceGender == -1)
		{
			JOptionPane.showMessageDialog(gender, "Please Select Your Gender");
			EEH.GenderEmpty("New Doctor");
		}
		else if(Arrays.equals(tPass1.getPassword(), tPass.getPassword()))
		{
			//Insert if the above conditions are satisfied
		try
		{
			DEmailID = tEmail.getText()+emailDomain.getSelectedItem();
			System.out.println(DEmailID);
			PasswordHashValue=ResultSetFetch.get_SecurePassword(tPass.getText());
			Models.InsertInToDB.insertNewDoctor(tName.getText(),PasswordHashValue,getDOB(),
					(String)gender.getSelectedItem(),DEmailID,
					tPhone.getText(),(catDisp.getSelectedIndex()+1),tHospital.getText()); //Pass values to  insert Record
			
			//	JOptionPane.showMessageDialog(tName,"Successfully Registered. Please Login");
				resetButton();
				new Login_All();
				f.setVisible(false);
		}
		catch(Exception e)
		{
			System.out.println("Error While Populating Records For Doctor " + e);
		}
			
		}	
	    else
		{
			JOptionPane.showMessageDialog(tPass, "Password Mismatch, Please Try Again");
			tPass.setText("");
			tPass1.setText("");
			EEH.PasswordMisMatch("New Doctor");
			
		}
	}

	
	//Get DOB as per Oracle standard
	@SuppressWarnings("deprecation") // For Deprecation 
	public String getDOB() {
		date = dateChooser.getDate();
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
	
	// Fetch domain from DB
	public  void domainListFetch() throws Exception
	{
		rs= ResultSetFetch.domainList();
		while (rs.next()) 
		{
			 emailDomain.addItem(rs.getString(1));
			 
		 }
		rs.close();
	}

} //ND -E