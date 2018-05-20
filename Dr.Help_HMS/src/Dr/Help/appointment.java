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

import Dr.Help.IssueDescription;
import Dr.Help.Login_All;
import Dr.Help.Management_Report;
import Dr.Help.UserAppConfirmation;
import Dr.Help.newUser;
import Models.Connector;
import Models.InsertInToDB;
import Models.ResultSetFetch;

public class appointment 
{ //DocApp - S

	
	// Add all the necessary variables
	JFrame HL = new JFrame("Appointments");
	JDateChooser dateChooser = new JDateChooser();
	String locName, ate,docn;
	JComboBox<?> hospitals;
	JLabel citylist, conText, cp, cpn, Hospitals, appointmentdate, welcomTex1, lImg;
	Image img,img1;
	Color c;
	JButton  appointment, show, Logout;
	java.sql.PreparedStatement pa = null;
	ResultSet rs = null;
	int category;
	String dname=Login_All.UserName;
	String hosp, l;

	// Date formatter
	SimpleDateFormat date = new SimpleDateFormat("MM-dd-yyyy");
	
	//To populate appointment booked slots dynamically
	List<String> comboBoxNames = new ArrayList<String>();
	ArrayList<String> array = new ArrayList<String>(
	Arrays.asList("9.00 A.M", "9.30 A.M", "10.00 A.M", "10.30 A.M", "11.00 A.M", "11.30 A.M"));
	JRadioButton[] rb = new JRadioButton[6];
	ButtonGroup group = new ButtonGroup();
	List<String> results = new ArrayList<String>();

	public appointment()
	
	{ //Appoin - S
		
		// Image add
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		HL.getContentPane().setBackground(c);
		
		// Date formatter
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(730, 230, 170, 25);
		
		// Background Color
		JPanel backgroundPanel = new JPanel();
		backgroundPanel.add(lImg);
		backgroundPanel.setLayout(new OverlayLayout(backgroundPanel));
		backgroundPanel.setOpaque(true);

		// Header Text
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);
		
		try 
		{ //try 1.0 - S
			rs = ResultSetFetch.docname(dname); // Return Docname from DB
		}//try 1.0 - E
		
		catch (Exception e2) 
		{ //Catch 1.0 - S
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} //Catch 1.0 - E
		
		
		try 
		{ //try 2.0 - S
			while (rs.next()) 
			{
				docn = rs.getString(1);
			}

		} //try 2.0 - E
		catch (SQLException e2)
		{ //Catch 2.0 - S
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} // cATCH 2.0 - e

		
		// Display Doc Name
		welcomTex1 = new JLabel("Hello, Dr."+ docn +". Select a date to view your appointments");
		welcomTex1.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomTex1.setForeground(Color.gray);
		welcomTex1.setBounds(500, 70, 600, 100);

		
		// Select Appointment Date 
		appointmentdate = new JLabel("Appointment Date");
		appointmentdate.setFont(new Font("Calibri", Font.PLAIN, 15));
		appointmentdate.setBounds(530, 230, 200, 25);

		
		//Copyrights
		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		
		//Logout
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
					ResultSetFetch.updateLogoutTime("DOCTOR",Login_All.UserName);
					new Login_All();
					HL.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		// Add required fields in JFrame
		HL.add(cp);
		HL.add(cpn);
		HL.add(Logout);
		HL.add(lImg);
		HL.add(conText);
		HL.add(appointmentdate);
		HL.add(dateChooser);
		HL.add(welcomTex1);
		HL.add(lImg);
		// locName = LocName;
		HL.setSize(1500, 1500);
		HL.setLayout(null);
		HL.setVisible(true);

		
		int y = 280, x = 530; // Display Radio Button dynamically
		for (int j = 0; j < 6; j++) 
		{

			rb[j] = new JRadioButton(array.get(j)); // Add radio buttons dynamically
			group.add(rb[j]);
			rb[j].setBounds(x, y, 100, 25);
			rb[j].setBackground(c);
			rb[j].setEnabled(false);
			HL.add(rb[j]);

			x += 100; // Increment x position for a radio buttons
		}

		// Button to show appointments
		show = new JButton("Check Appointments ");
		show.setBounds(600, 350, 180, 20);
		show.setFont(new Font("Calibri", Font.PLAIN, 15));
		show.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try 
				{
					check(dname);
				} 
				catch (Exception e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//  Fetch Details and display the Details
		appointment = new JButton("Details");
		appointment.setBounds(800, 350, 100, 20);
		;
		appointment.setFont(new Font("Calibri", Font.PLAIN, 15));
		appointment.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				// hosp = (String) hospitals.getSelectedItem();
				
				// If 9.00 AM Radio button is selected then display its details
				if (rb[0].isSelected()) 
				{
					l = "9.00 A.M";
					details(hosp, l);
					new visit(ate, l, dname);
					HL.setVisible(false);
				}
				
				// If 9.30 AM Radio button is selected then display its details
				else if (rb[1].isSelected()) 
				{
					l = "9.30 A.M";
					details(hosp, l);
					new visit(ate, l, dname);
					HL.setVisible(false);
				}
				
				// If 10.00 AM Radio button is selected then display its details
				else if (rb[2].isSelected()) 
				{
					l = "10.00 A.M";
					details(hosp, l);
					new visit(ate, l, dname);
					HL.setVisible(false);
				} 
				
				// If 10.30 AM Radio button is selected then display its details
				else if (rb[3].isSelected()) 
				{
					l = "10.30 A.M";
					details(hosp, l);
					new visit(ate, l, dname);
					HL.setVisible(false);
				} 
				
				// If 11.00 AM Radio button is selected then display its details
				else if (rb[4].isSelected()) 
				{
					l = "11.00 A.M";
					details(hosp, l);
					new visit(ate, l, dname);
					HL.setVisible(false);
				} 
				
				// If 11.30 AM Radio button is selected then display its details
				else if (rb[5].isSelected()) 
				{
					l = "11.30 A.M";
					details(hosp, l);
					new visit(ate, l, dname);
					HL.setVisible(false);
				} 
				
				// Else print no time slot selected
				else 
				{
					JOptionPane.showMessageDialog(null, "No time slot choosen please retry");// TODO Auto-generated
																								// method stub
				}

			}
		});

		HL.add(appointment);
		
		HL.add(show);
		
	} //Appoin - E

	@SuppressWarnings("unused")
	private void elseif(boolean equals) {
		// TODO Auto-generated method stub

	}
	
	
    //
	public void details(String hosp, String l)
	{
		try {
			check(hosp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ate = date.format(dateChooser.getDate());

		// InsertInToDB.bookappointment(hosp, ate, l, category, Login_All.UserName);

	}

	// Choose details to list the appointments
	public void check(String hosp) throws Exception
	{ // check -S
		if (dateChooser.getDate() == null) 
		{
			JOptionPane.showMessageDialog(dateChooser, "Please choose a day");
		} 
		
	    else 
	    { // else - S
	    	// to display appointments till sysdate + 30 days alone
			Date Today = new Date();
			String ate = date.format(dateChooser.getDate());
			String today = date.format(Today);
			Date day0 = date.parse(today);
			Date day1 = date.parse(ate);
			long diff = day1.getTime() - day0.getTime();
			int days = (int) (diff / (60 * 60 * 1000 * 24));
			if (days > -1.0 && days <= 30.0) 
			{ // If 3.0 -S
				int result = 0;

				rs = ResultSetFetch.checkapp(dname, ate);  // Check Timeslots for the logged in Doctor
				while (rs.next())  
				{ //while 3.0 -S
					results.add(rs.getString("TIME_SLOT")); // Fetch Time slots from DB

					result++; // Increment to fetch the Time_Slots filled

				}//while 3.0 - E
				
				for (int j = 0; j < 6; j++) 
				{ // for 3.0 - S
					rb[j].setEnabled(false);
				} // for 3.0 - E
				
				if (result == 0) 
				{ // If 3.1 - S
					for (int j = 0; j < 6; j++) {
						rb[j].setEnabled(false); // Dont display anything if all the time slots are filled
					}

				}// If 3.1 - E
				
				if (result == 6) 
				{// If 3.2 - S
					for (int j = 0; j < 6; j++) 
					{ // for 3.2 - S
						rb[j].setEnabled(true);
					} // for 3.2 - E
					JOptionPane.showMessageDialog(null, "No Appointments");

				} // If 3.2 - E
				else
				  { // else 3.2 - S
					for (int j = 0; j < result; j++) 
					{ // for 3.2.1 - S
						
						// If respective 9.00 AM time slot is  not available in DB then display the below radio buttons
						if (results.get(j).equals("9.00 A.M")) 
						{
							rb[0].setEnabled(true); 
						}
						
						// If respective 9.30 AM time slot is not available in DB then display the below radio buttons
						else if (results.get(j).equals("9.30 A.M")) 
						{
							rb[1].setEnabled(true);
						}
						
						// If respective 10.00 AM time slot is not available in DB then display the below radio buttons
						else if (results.get(j).equals("10.00 A.M")) {
							rb[2].setEnabled(true);
						} 
						
						// If respective 10.30 AM time slot is not available in DB then display the below radio buttons
						else if (results.get(j).equals("10.30 A.M")) {
							rb[3].setEnabled(true);
						}
						
						// If respective 11.00 AM time slot is not available in DB then display the below radio buttons
						else if (results.get(j).equals("11.00 A.M"))
						{
							rb[4].setEnabled(true);
						}
						
						// If respective 11.30 AM time slot is not available in DB then display the below radio buttons
						else if (results.get(j).equals("11.30 A.M"))
						{
							rb[5].setEnabled(true);
						}

					} // for 3.2.1 - S
				} // else 3.2 - E

			} // If 3.0 -E
			
			else 
			{
				JOptionPane.showMessageDialog(null, "Appointment can be viewed only for 30 days from today");
			}
		}// else - E
	} // check -S

} //DocApp - E


