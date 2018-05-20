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
import ErrorHandler.Login_Error;
import Models.ResultSetFetch;

public class Login_All 
{ // LA -S

	//Declare all the necessary variables which is needed in JFrame
	JFrame LA = new JFrame("Login Screen");
	JLabel welcomTex,welcomTex2 ,captionTex,email, pwd, catDesc, conText, cp, cpn;
	JPasswordField pd;
	JTextField emailID;
	JButton login, newUser, clear, RaiseAReq, Exit;	
	JPanel backgroundPanel;
	String category[] = { "USER", "DOCTOR", "MANAGEMENT", "ADMIN" };
	JComboBox<String> catSel = new JComboBox<String>(category);
	JComboBox<String> domainSel = new JComboBox<String>();
	Color c;
	Image img, img1;
	String emailString = "@", PasswordHashValue;
	
	public static String UserName; // To Display the Name throughout the Screen
	
	ResultSet rs;
	
	//Create Ref Object for Error Handler
	Login_Error LE = new Login_Error();
	EmptyFields_Error_Handler EEH = new EmptyFields_Error_Handler();
	

	public Login_All()
	{
		//Fetch the Domain Name Dynamically From DB
		try 
		{ //try1.0 -S
			domainListFetch();
		} //try1.0 -E
		catch (Exception e1) 
		{ //Catch 1.0 -S
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}//Catch 1.0 -E
		
		
		//Display Image
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		JLabel lImg = new JLabel(new ImageIcon(img));
		lImg.setIcon(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		LA.getContentPane().setBackground(c); 

		
		//Add Image to background
		backgroundPanel = new JPanel();
		backgroundPanel.add(lImg);
		backgroundPanel.setLayout(new OverlayLayout(backgroundPanel));
		backgroundPanel.setOpaque(true);
		
		
		//Header Label for Image
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);

		//Header Label for Screen
		welcomTex = new JLabel("Welcome to Dr.Help");
		welcomTex.setBounds(600, 10, 250, 100);
		welcomTex.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomTex.setForeground(Color.gray);
		
		//Sub header Text
		captionTex = new JLabel("- For the People, Of the People, By the People");
		captionTex.setBounds(700,30,290,100);
		captionTex.setFont(new Font("Calibri", Font.PLAIN, 14));
		captionTex.setForeground(Color.gray);
		
		//Label depending upon the screen
		welcomTex2 = new JLabel("Please Login to Proceed");
		welcomTex2.setFont(new Font("Calibri", Font.PLAIN, 15));
		welcomTex2.setBounds(600,100,150,100);
		
		// Email-ID label
		email = new JLabel("Email_Id");
		email.setFont(new Font("Calibri", Font.PLAIN, 15));
		email.setBounds(550, 200, 100, 25);
	
		// Email-ID TextBox
		emailID = new JTextField(4);
		emailID.setFont(new Font("Calibri", Font.PLAIN, 15));
		emailID.setBounds(630, 200, 150, 25);
		
		
		//Email-ID Domain
		domainSel.setSelectedItem(null);
		domainSel.setFont(new Font("Calibri", Font.PLAIN, 15));
		domainSel.setBounds(800,200,120,20);
		
		// Password Label
		pwd = new JLabel("Password");
		pwd.setFont(new Font("Calibri", Font.PLAIN, 15));
		pwd.setBounds(550,250,100,25);
		
		// Password TextBox
		pd = new JPasswordField();
		pd.setFont(new Font("Calibri", Font.PLAIN, 15));
		pd.setBounds(630, 250, 150, 25);
		
		catDesc = new JLabel("Category");
		catDesc.setFont(new Font("Calibri", Font.PLAIN, 15));
		catDesc.setBounds(550, 300, 100, 25);
		
		// Category Selection
		catSel.setSelectedItem(null);
		catSel.setFont(new Font("Calibri", Font.PLAIN, 15));
		catSel.setBounds(630,300,150,20);
		
		//Login Button
		login = new JButton("Login");
		login.setFont(new Font("Calibri", Font.PLAIN, 15));
		login.setBounds(550, 390, 95, 25);
		
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LoginButton(); // Check for Login Validations
			}
		});
		
		//New Registration
		newUser = new JButton("SignUp");
		newUser.setFont(new Font("Calibri", Font.PLAIN, 15));
		newUser.setBounds(700,390,95,25);
		
		newUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LA.setVisible(false);
				new Welcome_Screen(); // Move to New Registration Page 
				
			}
		});
		
		
		// Clear Button
		clear = new JButton("Clear");
		clear.setFont(new Font("Calibri", Font.PLAIN, 15));
		clear.setBounds(635,345,85,25);
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				clearButton();	 // Call Clear Button Function	
			}
		});
		
		
		// Raise a ticket 
		RaiseAReq = new JButton("Raise A Request");
		RaiseAReq.setFont(new Font("Calibri", Font.PLAIN, 15));
		RaiseAReq.setBounds(604,440,150,25);
		RaiseAReq.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_Help("Login"); // Parameter to return back to Login Screen
				LA.setVisible(false);
			}
		});
		
		//Copyrights text
		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		
		//Exit the Application button
		Exit = new JButton("Exit");
        Exit.setFont(new Font("Calibri", Font.BOLD, 15));
        Exit.setForeground(Color.GRAY);
        Exit.setBounds(1100, 120, 150, 30);
        img1 = new ImageIcon(this.getClass().getResource("/l.png")).getImage();
        Exit.setBackground(c);
        Exit.setIcon(new ImageIcon(img1));
        Exit.setBorderPainted(false);
		Exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(1); //Exit the Application
			}
		});

		//Add all the necessary variables to be populated in JFrame
		LA.add(cp);
		LA.add(cpn);
		LA.add(Exit);
		LA.add(lImg);
		LA.add(conText);
		LA.add(welcomTex);
		LA.add(welcomTex2);
		LA.add(captionTex);
		LA.add(email);
		LA.add(emailID);
		LA.add(domainSel);
		LA.add(pwd);
		LA.add(pd);
		LA.add(catDesc);
		LA.add(catSel);
		LA.add(login);
		LA.add(newUser);
		LA.add(clear);
		LA.add(RaiseAReq);
		LA.setSize(1500, 1500);	
		LA.setLayout(null);
		LA.setVisible(true);
	}

	//Login Validation 
	private void LoginButton()
	{
		loginValidation(); //
		
	}
	
	//Clear Button actions
	private void clearButton()
	{
		emailID.setText("");
		pd.setText("");
		domainSel.setSelectedItem(null);
		catSel.setSelectedIndex(-1);
	}
	
	
	// Pass all thes Login Validations to make a successfull login
	@SuppressWarnings("deprecation")
	private void loginValidation()
	{
		
		if(emailID.getText().equals(""))
		{ //1.0- S
			JOptionPane.showMessageDialog(emailID, "Please Enter your Email-ID");
			EEH.EmailId_Empty("Login");
	    } //1.0- E
		
		else if(emailID.getText().contains(emailString))
		{ //1.1 - S
			JOptionPane.showMessageDialog(emailID, "Select Domain From the  Domain Filed");
			emailID.setText("");
			EEH.EmailId_Symbol("Login");
			
		}//1.1 - E
		
		else if(domainSel.getSelectedIndex() == -1)
		{//1.2 - S
			JOptionPane.showMessageDialog(domainSel, "Please Select Your Domain");
			EEH.domainEmpty("Login");
		}//1.2 - E
		
		
		else if(pd.getText().equals(""))
		{//1.3 - S
			JOptionPane.showMessageDialog(pd, "Please Enter Your Password");
			EEH.PasswordEmpty("Login");
		}//1.3 - E
		
		
		else if(catSel.getSelectedIndex() == -1)
		{//1.4 - S
			JOptionPane.showMessageDialog(catSel, "Select Your Login Type");
			EEH.CategoryEmpty("Login");
		}//1.4 -E
		
		else
		{//1.5 - S
			UserName = emailID.getText() + domainSel.getSelectedItem();
			System.out.println(UserName + catSel.getSelectedItem());
			try { //1.5.1 - S
				PasswordHashValue=ResultSetFetch.get_SecurePassword(pd.getText());
				Models.ResultSetFetch.getLoginDetails(UserName, PasswordHashValue ,(String)catSel.getSelectedItem());
				
				LA.setVisible(false);
		     	} //1.5.1 -E
			catch (Exception e) 
			{//1.5.2 - S
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//1.5.2 - E
			
		 
		}//1.5- E
	
	}
	
	
	//Fetch Domain List from DB and populate Dynamically
	public  void domainListFetch() throws Exception
	{ //DLF - S 
		rs= ResultSetFetch.domainList();
		while (rs.next()) 
		{// W-S
			domainSel.addItem(rs.getString(1));
			 
		}// W-E
		rs.close();
	}//DLF - E
	
	
	// Main Method to Start the Program
	public static void main(String[] args)
	{
		new Login_All();
		
	}
	
}// LA -E

