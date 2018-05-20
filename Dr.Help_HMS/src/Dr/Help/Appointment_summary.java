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
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.SwingConstants;

import Dr.Help.IssueDescription;
import Dr.Help.Login_All;
import Dr.Help.UserAppConfirmation;
import Models.InsertInToDB;
import Models.ResultSetFetch;

public class Appointment_summary 
 { // AS - S

	JFrame as = new JFrame("Summary Screen");
	JLabel welcomTex,welcomTex2 ,email, pwd, catDesc,conText,cp,cpn,lImg,cancelapt;
	JLabel hospital_name,slot,date,doctor,category,appointment_id;
	JPanel backgroundPanel;
	JButton cancel,bnew,Logout,history;
	Color c;
	Image img,img1;
	ResultSet rs=null;
	List<String> results = new ArrayList<String>();
	String appid,hname,cat,day,hour,catt,city;
	int ConfirmMessage;
	
	
	public Appointment_summary(String dte,String time,String hosp,String uname,String doc) throws Exception
	
	{ //ASSD - S
		
		rs=ResultSetFetch.getsummary(dte,time,hosp,uname);
		city=UserAppConfirmation.locName.toUpperCase();
		while(rs.next())
		{
			appid=rs.getString("AID");
			hname=rs.getString("HOSPITAL_NAME");
			cat=rs.getString("CATEGORY");
			day=rs.getString("DATE_SCHEDULED");
			hour=rs.getString("TIME_SLOT");
			
		}
		rs.close();
		
		// Display Category in the appointment Screen
		if(cat.equals("1"))
		{
			catt="Head";
		}
		
		else if(cat.equals("2"))
		{
			catt="Neck to Knee";
		}
		
		else if(cat.equals("3"))
		{
			catt="Knee to Toe";
		}
		
		// Display Image
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		as.getContentPane().setBackground(c);

		
		// Background Color
		backgroundPanel = new JPanel();
		backgroundPanel.add(lImg);
		backgroundPanel.setLayout(new OverlayLayout(backgroundPanel));
		backgroundPanel.setOpaque(true);
		
		// Header Text
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);

		// Appointment Label
		welcomTex = new JLabel("Appointment Confirmation",SwingConstants.CENTER);
		welcomTex.setBounds(0, 10, 1500, 100);
		welcomTex.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomTex.setForeground(Color.gray);
		
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
					as.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		// Display Hosp Name with City
		hospital_name = new JLabel("Hospital Name - "+hname+" in "+city,SwingConstants.CENTER);
		hospital_name.setFont(new Font("Calibri", Font.BOLD, 20));
		hospital_name.setBounds (0, 255, 1500, 50);

		
		//Display appointment ID
		appointment_id = new JLabel("Appointment number - "+appid,SwingConstants.CENTER);	 
		appointment_id.setFont(new Font("Calibri", Font.BOLD, 20));
		appointment_id.setBounds(0, 180, 1500, 100);

		
		//Display Category for appointment
		category = new JLabel("Visiting category - "+catt,SwingConstants.CENTER);
		category.setFont(new Font("Calibri", Font.BOLD, 20));
		category.setBounds(0, 305, 1500, 50);

		//Display Doc Name for appointment
		doctor=new JLabel("Appointment scheduled to Dr."+doc,SwingConstants.CENTER);
		doctor.setFont(new Font("Calibri", Font.BOLD, 20));
		doctor.setBounds(0, 350, 1500, 50);


		//Display date for appointment
		date=new JLabel("Date of visit - "+day,SwingConstants.CENTER);
		date.setFont(new Font("Calibri", Font.BOLD, 20));
		date.setBounds(0, 400, 1500, 50);

       //Display Time slot for appointment
		slot=new JLabel("Time scheduled for visit - "+hour,SwingConstants.CENTER);
		slot.setFont(new Font("Calibri", Font.BOLD, 20));
		slot.setBounds(0, 450, 1500, 50);
		
		
		//Cancel appointment Button
		cancelapt = new JLabel("Appointment cancelled",SwingConstants.CENTER);
		cancelapt.setFont(new Font("Calibri", Font.BOLD, 20));
		cancelapt.setBounds(0, 325, 1500, 50);
		cancelapt.setVisible(false);

		
		// To Cancel the current booked appointment
		cancel = new JButton("Cancel ");
		cancel.setFont(new Font("Calibri", Font.PLAIN, 15));
		cancel.setBounds(625,550 , 100, 20);
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e ) {
				try {
					ConfirmMessage = JOptionPane.showConfirmDialog(null, "Are you sure to cancel the appointment");
					if(ConfirmMessage == JOptionPane.YES_OPTION)
					{
					InsertInToDB.cancelappointment(dte,time,hosp,uname); // Delete appointment from DB
					appointment_id.setVisible(false);
					hospital_name.setVisible(false);
					category.setVisible(false);
					doctor.setVisible(false);
					date.setVisible(false);
					slot.setVisible(false);
					cancelapt.setVisible(true);
					cancel.setEnabled(false);
					}
				
					}catch(Exception v)
				{
						v.printStackTrace();
				}
				
			}
		});
		
		
		//Book another appointment
		bnew = new JButton(" Book New");
		bnew.setFont(new Font("Calibri", Font.PLAIN, 15));
		bnew.setBounds(775, 550, 100, 20);
		bnew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e ) {
				new IssueDescription(); // Move to the first User Screen
				as.setVisible(false);
		}});
		
		//Copyrights
		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		
		// Add what are all to be populated to JFrame 
		as.add(lImg);
		as.add(appointment_id);
		as.add(hospital_name);
		as.add(category);
		as.add(doctor);
		as.add(date);
		as.add(slot);
		as.add(welcomTex);
		as.add(cancelapt);
		as.add(conText);
		as.add(Logout);
		as.add(cancel);
		as.add(bnew);
		as.add(cp);
		as.add(cpn);
		as.setLayout(null);
		as.setSize(1500, 1500);	
		as.setVisible(true);
		
	}//ASSD - E
} // AS - E



