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
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import ErrorHandler.EmptyFields_Error_Handler;
import Models.ResultSetFetch;
import View.HospVenture_View;
import View.Report_View;

public class Hosp_Venture 
{ //HV -S

	JFrame HospV = new JFrame("Hospital Venture");
	JLabel lImg, welcomtex, dateText, startDate, endDate, cp,cpn,conText ;
	JButton resetSD, resetED, submit, goBack, Logout;
	JTextField sDate, eDate;
	Date date;
	int MM, DD, YYYY;
	Color c;
	Image img,img1;
	String Date_Final_Start,Date_Final_End, YY;
	JDateChooser sdateChooser = new JDateChooser();
	JDateChooser edateChooser = new JDateChooser();
	
	//Create Ref Object
	HospVenture_View HV = new HospVenture_View();
	EmptyFields_Error_Handler EEH = new EmptyFields_Error_Handler();
	
	public Hosp_Venture()
	{ //HVO - S
		
		
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		HospV.getContentPane().setBackground(c);
		
	
		
	
		welcomtex = new JLabel("Hello, Welcome to Hospital Venture Report Section.");
		welcomtex.setBounds(570, 10, 450, 100);
		welcomtex.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomtex.setForeground(Color.gray);
		dateText = new JLabel("Please Select Your Dates for the Report Generation");
		dateText.setBounds(570,90,400,50);
		dateText.setFont(new Font("Calibri", Font.BOLD, 15));
		dateText.setForeground(Color.gray);
		
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);
		
		startDate = new JLabel("Enter Your Start Date");
		startDate.setBounds(570,150,150,50);
		startDate.setFont(new Font("Calibri", Font.PLAIN, 15));
		sdateChooser.setBounds(750, 165, 150, 20);
		sDate = new JTextField();
		
				
		endDate = new JLabel("Enter Your End Date");
		endDate.setBounds(570,210,150,50);
		endDate.setFont(new Font("Calibri", Font.PLAIN, 15));
		edateChooser.setBounds(750,225,150,20);
		eDate = new JTextField();
		
		resetSD = new JButton("Reset Start Date");
		resetSD.setBounds(570,280,135,20);
		resetSD.setFont(new Font("Calibri", Font.PLAIN, 15));
		resetSD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sdateChooser.setDate(null);
			}
		});
		
		resetED = new JButton("Reset End Date");
		resetED.setBounds(750,280,135,20);
		resetED.setFont(new Font("Calibri", Font.PLAIN, 15));
		resetED.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				edateChooser.setDate(null);
			}
		});
		
		submit = new JButton("Fetch Reports");
		submit.setBounds(570,350,135,20);
		submit.setFont(new Font("Calibri", Font.PLAIN, 15));
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{ //Action -S
				// TODO Auto-generated method stub
				if(sdateChooser.getDate() != null)
				{ //If 1.0 -S
					if(edateChooser.getDate() != null)
					{//If 1.1 -S
						
						HV.HospVenture(getStartDate(), getEndDate());
					}//If 1.1 -E
					else
					{ //else 1.1 -SS
						JOptionPane.showMessageDialog(submit, "Please Choose End Date");
						EEH.endDateEmptyReport("Mgmt Hosp Venture Report");
					} //else 1.1 -E
				} //If 1.0 -E
				else
				{ //else 1.0 -S
					JOptionPane.showMessageDialog(submit, "Please Choose Start Date");
					EEH.startDateEmptyReport("Mgmt Hosp Venture Report");
				} //else 1.0 -E
				
			} //Action -E
		});
				
		goBack = new JButton("Go Back");
		goBack.setBounds(750, 350, 135, 20);
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Management_Report(); //Go back
				HospV.setVisible(false);
				
			}
		});
	
		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		
		
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
					HospV.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		
		HospV.add(cp);
		HospV.add(cpn);
		HospV.add(lImg);
		HospV.add(welcomtex);
		HospV.add(conText);
		HospV.add(dateText);
		HospV.add(startDate);
		HospV.add(endDate);
		HospV.add(sdateChooser);
		HospV.add(edateChooser);
		HospV.add(resetSD);
		HospV.add(resetED);
		HospV.add(submit);
		HospV.add(goBack);
		HospV.add(Logout);
		HospV.setLayout(null);
		HospV.setSize(1500, 1500);
		HospV.setVisible(true);
		
	} //HVO - E
	
	//Start Date Calculation
	public String getStartDate() 
	{
		date = sdateChooser.getDate();
		MM = date.getMonth();
		DD = date.getDate();
		YYYY = date.getYear();
		if (YYYY >= 100) {
			YY = String.valueOf(YYYY).substring(1);
			Date_Final_Start = ((MM + 1) + "-" + DD + "-" + YY);
		} else {
			Date_Final_Start = ((MM + 1) + "-" + DD + "-" + YYYY);
			System.out.println(Date_Final_Start);
		}

		System.out.println(Date_Final_Start);
		return Date_Final_Start;
	}


	//End Date Calculation
		public String getEndDate() 
		{
			date = edateChooser.getDate();
			MM = date.getMonth();
			DD = date.getDate();
			YYYY = date.getYear();
			if (YYYY >= 100) {
				YY = String.valueOf(YYYY).substring(1);
				Date_Final_End = ((MM + 1) + "-" + DD + "-" + YY);
			} else {
				Date_Final_End = ((MM + 1) + "-" + DD + "-" + YYYY);
				System.out.println(Date_Final_End);
			}
	
			System.out.println(Date_Final_End);
			return Date_Final_End;
    	}

} //HV -E
	



