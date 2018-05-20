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
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.OverlayLayout;

import com.toedter.calendar.JDateChooser;

import Models.Connector;
import Models.InsertInToDB;
import Models.ResultSetFetch;
import Dr.Help.Appointment_summary;
import ErrorHandler.EmptyFields_Error_Handler;

public class Hosp_List 
{ //HL - S 

	
	// Declare all the necessary Variables
	JFrame HL = new JFrame("Hosptail List");
	JDateChooser dateChooser = new JDateChooser();
	String locName;
	JComboBox<?> hospitals;
	JLabel citylist,conText,cp,cpn,Hospitals,appointmentdate;
	JButton goBack, appointment,show,Logout;
	java.sql.PreparedStatement pa=null;
	ResultSet rs = null;
	int category;
	String usrcat=IssueDescription.category;
	String hosp,l,docid,docname,hid;
	List<String> comboBoxNames = new ArrayList<String>();
	SimpleDateFormat date = new SimpleDateFormat("MM-dd-yyyy");
	JRadioButton[] rb = new JRadioButton[6];
	ButtonGroup group = new ButtonGroup();
	Image img,img1;
	
	//Array List to populate the Fixed Appointment timings
	ArrayList<String> array = new ArrayList<String>(Arrays.asList("9.00 A.M", "9.30 A.M", "10.00 A.M", "10.30 A.M", "11.00 A.M", "11.30 A.M"));
	List<String> results = new ArrayList<String>();
	
	//Create Ref objects to handle Empty Fields
	 EmptyFields_Error_Handler EEH = new EmptyFields_Error_Handler();
	 
	 
	 public Hosp_List(int i, String LocName)
	{ // HLC - S
		 
		locName = LocName;
		
		//Background Image
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		JLabel lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		Color c = new Color(245, 252, 196);
		HL.getContentPane().setBackground(c);
		
		
		//Date Picker
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(730, 230, 170, 25);
		
		//Background Image
		JPanel backgroundPanel = new JPanel();
		backgroundPanel.add(lImg);
		backgroundPanel.setLayout(new OverlayLayout(backgroundPanel));
		backgroundPanel.setOpaque(true);

		//Header Label for Image
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);
		
		//Label depending upon the screen
		Hospitals = new JLabel("Available Hospitals");
		Hospitals.setFont(new Font("Calibri", Font.PLAIN, 15));
		Hospitals.setBounds(530, 180, 200, 25);
		
		//Choose Appointment Date Label
		appointmentdate = new JLabel("Choose the Appointment Date");
		appointmentdate.setFont(new Font("Calibri", Font.PLAIN, 15));
		appointmentdate.setBounds(530, 230, 200, 25);
		
		//Copyrights
		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		
		//Logout Button
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
					ResultSetFetch.updateLogoutTime("USER",Login_All.UserName);
					new Login_All();
					HL.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	
		
		
		// Get the Category Type Selected for Further reference 
		if(usrcat.equals("Head"))
		{
			category=1;
		}
		else if(usrcat.equals("NeckToKnee"))
		{
			category=2;
		}
		else if(usrcat.equals("KneeToToe"))
		{
			category=3;
		}
		
		
		
		//Display Hosp From Location 1 Depending upon the Medical Insurance Option
		// 0  -> With Medical Insurance 
		// -1 -> Without Medical Insurance
		if(i==0)
		{
			city_0(0);
		}
		else if(i==-1)
		{
			city_0(-1);
		}
		
		//Display Hosp From Location 2 Depending upon the Medical Insurance Option
		// 0  -> With Medical Insurance 
		// -1 -> Without Medical Insurance
		else if(i==1)
		{
			city_1(0);
		}
		else if(i==-2)
		{
			city_1(-2);
		}
		
		//Display Hosp From Location 3 Depending upon the Medical Insurance Option
		// 0  -> With Medical Insurance 
		// -1 -> Without Medical Insurance
		else if(i==2)
		{
			city_2(0);
		}
		else if(i==-3)
		{
			city_2(-3);
		}
		
		//Display Hosp From Location 3 Depending upon the Medical Insurance Option
		// 0  -> With Medical Insurance 
		// -1 -> Without Medical Insurance
		else if(i==3)
		{
			city_3(0);
		}
		else if(i==-4)
		{
			city_3(-4);
		}
		
		//Go back one pagr
		goBack = new JButton("Go Back");
		goBack.setBounds(570, 350, 100, 20);
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e ) {
				new UserAppConfirmation(usrcat);
				HL.setVisible(false);
				
			}
		});
			

	
		
		   int y = 280,x=530; // Fixed X and y bounds for the Radio Button to display dynamically
			for (int j = 0; j <6; j++) 
			{
			    rb[j] = new JRadioButton(array.get(j));
				group.add(rb[j]);
				rb[j].setBounds(x, y, 100, 25); 
				rb[j].setBackground(c);
				rb[j].setEnabled(false);
				HL.add(rb[j]);
				
				x += 100; // Increment Radio Button Position automatically
			}

			
			// Check availability Option for the requested time
			show = new JButton("Check Slot ");
			show.setBounds(700, 350, 120, 20);
			show.setFont(new Font("Calibri", Font.PLAIN, 15));
			show.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) 
				{
					hosp=(String) hospitals.getSelectedItem(); // Display Hops List depending upon the selection
					try 
					{
						check(hosp);
					} catch (Exception e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}});
			
			
		// Book an appointment	
		appointment = new JButton("Book");
		appointment.setBounds(850, 350, 100, 20);
		appointment.setFont(new Font("Calibri", Font.PLAIN, 15));
		appointment.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{ // Appointment - S
				hosp=(String) hospitals.getSelectedItem();
				if(rb[0].isSelected())
				{
					l="9.00 A.M";
					book(hosp,l); // Pass the values to display confirmation
				}
				else if(rb[1].isSelected())
				{
					l="9.30 A.M";
					book(hosp,l); // Pass the values to display confirmation
				}
				else if(rb[2].isSelected())
				{
					l="10.00 A.M";
					book(hosp,l); // Pass the values to display confirmation
				}
				else if(rb[3].isSelected())
				{
					l="10.30 A.M";
					book(hosp,l); // Pass the values to display confirmation
				}
				else if(rb[4].isSelected())
				{
					l="11.00 A.M";
					book(hosp,l); // Pass the values to display confirmation
				}
				else if(rb[5].isSelected())
				{
					l="11.30 A.M";
					book(hosp,l); // Pass the values to display confirmation				
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No time slot choosen please retry");// TODO Auto-generated method stub
				}
		
			}});// Appointment - E
		
    	//Add all the necessary things to be shown in JFrame
		HL.add(cp);
		HL.add(cpn);
		HL.add(Logout);
  		HL.add(lImg);
		HL.add(conText);
		HL.add(appointmentdate);
		HL.add(dateChooser);
		HL.setSize(1500, 1500);
		HL.setLayout(null);
		HL.setVisible(true);
		HL.add(appointment);		
		HL.add(goBack);
		HL.add(show);
		HL.add(Hospitals);
		
	}// HLC - E
	
	

	 //List of Hosp to be populated if First Location is Chosen
	 //-1 -> Hosp without Medical Insurance
	public void city_0(int i)
	{ // City - 0 -S
		
		if(i==-1)
		{
		citylist = new JLabel("Hello Please find the Hosptails Without Insurance Coverage at " + locName);
		citylist.setFont(new Font("Calibri", Font.BOLD, 20));
		citylist.setForeground(Color.gray);
		citylist.setBounds(450, 70, 650,20);
		HL.add(citylist);
		try {
			 rs= ResultSetFetch.hosplist(locName,0,category); // Fetch Results for Hosp without Insurance
			while (rs.next()) {
				 String name = rs.getString("HOSPITAL_NAME"); // Column Name from the DB 
				 comboBoxNames.add(name); // Add the hosp Name into Combobox from results fetched in DB
				 }
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		hospitals = new JComboBox<Object>(comboBoxNames.toArray()); // Display Hosp Names after fetching from  DB
		hospitals.setBounds(730,180,300,25);
		HL.add(hospitals);
		}
		
		else
		{
			citylist = new JLabel("Hello Please find the Hosptails With Insurance Coverage at " + locName);
			citylist.setFont(new Font("Calibri", Font.BOLD, 20));
			citylist.setForeground(Color.gray);
			citylist.setBounds(450, 70, 650,20);
			try {
				 rs= ResultSetFetch.hosplist(locName,1,category); // Fetch Results for Hosp with Insurance
				while (rs.next()) {
					 String name = rs.getString("HOSPITAL_NAME"); // Column Name from the DB 
					 comboBoxNames.add(name); // Add the hosp Name into Combobox from results fetched in DB
					 }
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			hospitals = new JComboBox<Object>(comboBoxNames.toArray()); // Display Hosp Names after fetching from  DB
			hospitals.setBounds(730,180,300,25);
			HL.add(hospitals);
			HL.add(citylist);
		}
	} // City - 0 -E
	@SuppressWarnings("unused")
	private void elseif(boolean equals) {
		// TODO Auto-generated method stub
		
	}


	//List of Hosp to be populated if Second Location is Chosen
	public void city_1(int i)
	{// City - 1 -S
		if(i==-2)
		{
		citylist = new JLabel("Hello Please find the Hosptails Without Insurance Coverage at " + locName);
		citylist.setFont(new Font("Calibri", Font.BOLD, 20));
		citylist.setForeground(Color.gray);
		citylist.setBounds(450, 70, 650,20);
		try {
			 rs= ResultSetFetch.hosplist(locName,0,category);   // Fetch Results for Hosp without Insurance
			while (rs.next()) {
				 String name = rs.getString("HOSPITAL_NAME");  // Column Name from the DB 
				 comboBoxNames.add(name); // Add the hosp Name into Combobox from results fetched in DB
				 }
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		hospitals = new JComboBox<Object>(comboBoxNames.toArray()); // Display Hosp Names after fetching from  DB
		hospitals.setBounds(730,180,300,25);
		HL.add(hospitals);
		HL.add(citylist);
		}
		else
		{
			citylist = new JLabel("Hello Please find the Hosptails With Insurance Coverage at " + locName);
			citylist.setFont(new Font("Calibri", Font.BOLD, 20));
			citylist.setForeground(Color.gray);
			citylist.setBounds(450, 70, 650,20);
			try {
				 rs= ResultSetFetch.hosplist(locName,1,category);  // Fetch Results for Hosp with Insurance
				while (rs.next()) {
					 String name = rs.getString("HOSPITAL_NAME"); // Column Name from the DB 
					 comboBoxNames.add(name); // Add the hosp Name into Combobox from results fetched in DB
					 }
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			hospitals = new JComboBox<Object>(comboBoxNames.toArray()); // Display Hosp Names after fetching from  DB
			hospitals.setBounds(730,180,300,25);
			HL.add(hospitals);
			HL.add(citylist);
		}
	}// City - 1 -E
	
	//List of Hosp to be populated if Third Location is Chosen
	public void city_2(int i)
	{ // City - 2 -S
		
		if(i==-3)
		{
			citylist = new JLabel("Hello Please find the Hosptails Without Insurance Coverage at " + locName);
			citylist.setFont(new Font("Calibri", Font.BOLD, 20));
			citylist.setForeground(Color.gray);
			citylist.setBounds(450, 70, 650,20);
			try {
				 rs= ResultSetFetch.hosplist(locName,0,category); // Fetch Results for Hosp without Insurance
				while (rs.next()) {
					 String name = rs.getString("HOSPITAL_NAME");  // Column Name from the DB 
					 comboBoxNames.add(name); // Add the hosp Name into Combobox from results fetched in DB
					 }
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			hospitals = new JComboBox<Object>(comboBoxNames.toArray()); // Display Hosp Names after fetching from  DB
			hospitals.setBounds(730,180,300,25);
			HL.add(hospitals);
			HL.add(citylist);
		}
		else
		{
			citylist = new JLabel("Hello Please find the Hosptails With Insurance Coverage at " + locName);
			citylist.setFont(new Font("Calibri", Font.BOLD, 20));
			citylist.setForeground(Color.gray);
			citylist.setBounds(450, 70, 650,20);try {
				 rs= ResultSetFetch.hosplist(locName,1,category); // Fetch Results for Hosp with Insurance
				while (rs.next()) {
					 String name = rs.getString("HOSPITAL_NAME"); // Column Name from the DB 
					 comboBoxNames.add(name); // Add the hosp Name into Combobox from results fetched in DB
					 }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			hospitals = new JComboBox<Object>(comboBoxNames.toArray());// Display Hosp Names after fetching from  DB
			hospitals.setBounds(730,180,300,25);
			HL.add(hospitals);
			HL.add(citylist);	
		}
	}// City - 2 -E
	
	
	//List of Hosp to be populated if Fourth Location is Chosen
	public void city_3(int i)
	{// City - 3 -S
		if(i==-4)
		{ 
			citylist = new JLabel("Hello Please find the Hosptails Without Insurance Coverage at " + locName);
			citylist.setFont(new Font("Calibri", Font.BOLD, 20));
			citylist.setForeground(Color.gray);
			citylist.setBounds(450, 70, 650,20);
			try {
				 rs= ResultSetFetch.hosplist(locName,0,category);  // Fetch Results for Hosp without Insurance
				while (rs.next()) {
					 String name = rs.getString("HOSPITAL_NAME"); // Column Name from the DB 
					 comboBoxNames.add(name); // Add the hosp Name into Combobox from results fetched in DB
					 
					 }
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			hospitals = new JComboBox<Object>(comboBoxNames.toArray()); // Display Hosp Names after fetching from  DB
			hospitals.setBounds(730,180,300,25);
			HL.add(hospitals);
			HL.add(citylist);
		}
		else
		{
			citylist = new JLabel("Hello Please find the Hosptails With Insurance Coverage at " + locName);
			citylist.setFont(new Font("Calibri", Font.BOLD, 20));
			citylist.setForeground(Color.gray);
			citylist.setBounds(450, 70, 650,20);
			try {
				 rs= ResultSetFetch.hosplist(locName,1,category); // Fetch Results for Hosp with Insurance
				while (rs.next()) {
					 String name = rs.getString("HOSPITAL_NAME"); // Column Name from the DB 
					 comboBoxNames.add(name); // Add the hosp Name into Combobox from results fetched in DB
					 }
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			hospitals = new JComboBox<Object>(comboBoxNames.toArray()); // Display Hosp Names after fetching from  DB
			hospitals.setBounds(730,180,300,25);
			HL.add(hospitals);
			HL.add(citylist);	
		}
		
	} // City - 3 -E
	
	
	// Proceed to Book the appointment
	public void book(String hosp,String l)
	{ //book - S
		try
		{ // Try -1 -S
			check(hosp); // Time slots available for the hosp and populate dynamically
		}// Try -1 -E
		
		catch (Exception e) 
		{ // Catch -1 -S
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// Catch -1 -E

			String ate=date.format(dateChooser.getDate());
			
			
			try 
			{ // Try -2 -S
				rs=ResultSetFetch.getdoc(hosp ); // Get respective Doctor Name Depending upon the Location, Hosp
				while (rs.next())
				{
				docname=rs.getString("DOCTOR_NAME"); // Doc Name from the respective Hosp
				docid=rs.getString("DOCTOR_EMAIL_ID"); // Doc Email ID from the respective Hosp
				hid=rs.getString("H_ID");//Getting Hospital Id for the selected hospital
				}
				rs.close();
			} // Try -2 -E
			
			catch (SQLException e1) 
			{// Catch -2 -S
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}// Catch -2 -E
			
			catch (Exception e) 
			{ // Catch -2.1 -S
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// Catch -2.2 -E
			InsertInToDB.bookappointment(hosp, ate,l,category,Login_All.UserName,docid,hid);// Add Appointment Details to DB
			
			try
			{ // Try -3 -S
				new Appointment_summary(ate,l,hosp,Login_All.UserName,docname);// Populate Appointment Summary Screen
				HL.setVisible(false);
			} // Try -3 -E
			catch (Exception e) 
			{// Catch -3 -S
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// Catch -3 -E
	}//book - E
	
	
	// Check what are all the available time slots for booking an appointment
	public void check(String hosp) throws Exception
	{ //CheckSlot - S
		if(dateChooser.getDate() == null)
		{ // If 1.0 - S
			JOptionPane.showMessageDialog(dateChooser, "Please choose a day"); 
			EEH.appointmentDateEmpty("User Appointment Screen");
			
		}// If 1.0 - E
		else 
		{ //else 1.0 - S
			
			// To Ensure only appointment is booked for Future dates and less than sysdate + 30
			Date Today=new Date();
			String ate=date.format(dateChooser.getDate());
			String today=date.format(Today);
			Date day0= date.parse(today);
			Date day1=date.parse(ate);
			long diff= day1.getTime()-day0.getTime();
			int days=(int) (diff/(60*60*1000*24));
				
				if(days>0.0 && days<=30.0) // Allow appointments only for SYSDATE + 30 
				{ // If 1.1. - S
						
					int result=0;
					
					rs=ResultSetFetch.checkdate(hosp, ate);  // Check if TimeSlot is available 
					while (rs.next())
						{ // While 1.0 - S
						results.add(rs.getString("TIME_SLOT")); // Column Name from DB
						
						result++; // Iterate the loop
						
						}// While 1.0 - E
					for (int j = 0; j < 6; j++)
					 { //for 1.0 - S
					  rb[j].setEnabled(true); // Display Radio button if available
					 } //for 1.0 - E
					
					if(result==0)
					{ // If - 1.2 - S
						  for (int j = 0; j < 6; j++)
						  {
						  rb[j].setEnabled(true); // Display Radio button if available
						  }
													  
					}// If - 1.2 - E
					
					  if(result==6) // If all slots are booked 
					  {
						  for (int j = 0; j < 6; j++)
						  {
						  rb[j].setEnabled(false); // Dont Display Radio button if slots are full
						  }
						  JOptionPane.showMessageDialog(null, "All slots are booked");
						  
					  }
					else 
					{ //else 1.0 - S 
							
						// Populate the radio button dynamically depending up available slots
						for (int j = 0; j < result; j++) 
						{// for 1.1 - S
						if (results.get(j).equals("9.00 A.M"))
							{
							rb[0].setEnabled(false);								
							}
						else if (results.get(j).equals("9.30 A.M"))
							{
							rb[1].setEnabled(false);
							}
						else if (results.get(j).equals("10.00 A.M"))
							{
							rb[2].setEnabled(false);
							}
						else if (results.get(j).equals("10.30 A.M"))
							{
							rb[3].setEnabled(false);
							}
						else if (results.get(j).equals("11.00 A.M"))
							{
							rb[4].setEnabled(false);
							}
						else if (results.get(j).equals("11.30 A.M"))
							{
							rb[5].setEnabled(false);
							}
						
						}// for 1.1 - E
					} //else 1.0 - E
				 
				 }// If 1.1. - E
				else
				{
					JOptionPane.showMessageDialog(null, "Appointment can be booked one day prior to 30 days from now");
					
				}
				rs.close();
			}//else 1.0 - E
		}//CheckSlot - E
	
	}//HL - E		
							
			
		
		
				
		
	
		


