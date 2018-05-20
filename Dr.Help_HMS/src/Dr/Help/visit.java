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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;

import com.toedter.calendar.JDateChooser;

import Models.ResultSetFetch;

public class visit 
{ // Visit -S

	
	// Declare all the necessary details for the Jframe 
	JFrame LA = new JFrame("Visit details Screen");
	JLabel welcomTex1, pName, tName, aID, diagnosis, pvDate, drugs, conText, cp, cpn, taID, lvisit,taDate,apDate, taTime, apTime, lImg;
	JPasswordField pd;
	JTextField emailID;
	JButton aSubmit, aCancel, aReset, History, Disease, Logout;
	Image img,img1;
	Color c;
	SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
	JDateChooser sdateChooser = new JDateChooser();
	Date date;
	int MM, DD, YYYY;
	String Date_Final_p, YY, appId, uMail, uName, Name, vDate, sDia, sDrug, sVisit, sRef, pDate;
	ResultSet rs = null;

	

	public visit(String aDate, String tslot, String dname) 
	
	{ // VisitCons - S

		
		//Image Icon display
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		LA.getContentPane().setBackground(c);

		// Panel backgroud for color and image
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
		{ //try 1.0 -S
			rs = ResultSetFetch.selapp(dname, aDate, tslot); // To populate earlier medical details in the Screen
		} //try 1.0 -E
		catch (Exception e2) 
		{ //catch 1.0 -S
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}//catch 1.0 -E
		
		
		try 
		{ //try 2.0 -S
			while (rs.next()) 
			{ //while 2.0 -S
				// Get details of the columns
				appId = rs.getString(1);
				uMail = rs.getString(2);
				sDia = rs.getString(3);
				sDrug = rs.getString(4);
				sVisit = rs.getString(5);
				sRef = rs.getString(6);
				System.out.println(sVisit);
		   }//while 2.0 -E

		} //try 2.0 -E
		
		catch (SQLException e2) 
		{//catch 2.0 -S
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}//catch 2.0 -E

		
		try 
		{//try 3.0 -S
			rs = ResultSetFetch.selusr(uMail); // Fetch User Name from  DB for the respective appointment
		}//try 3.0 -E 
		
		catch (Exception e2) 
		{//catch 3.0 -S
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}//catch 3.0 -S
		
		
		try 
		{//try 4.0 -S
			while (rs.next()) 
			{
				Name = rs.getString(1); // Store the name from the above fetched result

			}
		}//try 4.0 -S 
		
		catch (SQLException e2) 
		{//catch 4.0 -S
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}//catch 4.0 -E
		
		
		//System.out.println(Name);

		// Visit Summary for the User
		welcomTex1 = new JLabel("Visit Summary for Mr." + Name);
		welcomTex1.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomTex1.setForeground(Color.gray);
		welcomTex1.setBounds(500, 70, 500, 100);

		//Appointment Selection Lable
		JLabel a = new JLabel("Appointments selection");
		a.setFont(new Font("Calibri", Font.BOLD, 20));
		a.setForeground(Color.gray);
		a.setBounds(615, 50, 250, 100);
		
		//Enter Details to be filled or updated
		JLabel nUser = new JLabel("Please Enter the details");
		nUser.setFont(new Font("Calibri", Font.PLAIN, 15));
		nUser.setBounds(635, 130, 200, 30);

		//Appointment ID Lable
		aID = new JLabel("Appointment ID");
		aID.setFont(new Font("Calibri", Font.BOLD, 15));
		aID.setBounds(450, 160, 120, 20);

		//Appointment ID label from Database 
		taID = new JLabel(appId);
		taID.setFont(new Font("Calibri", Font.PLAIN, 15));
		taID.setBounds(560, 160, 120, 20);
		
		//Appointment Date label
		apDate = new JLabel("Appointment Date");
		apDate.setFont(new Font("Calibri", Font.BOLD, 15));
		apDate.setBounds(750, 160, 120, 20);

		
		//Appointment date from DB
		taDate = new JLabel(aDate);
		taDate.setFont(new Font("Calibri", Font.PLAIN, 15));
		taDate.setBounds(900, 160, 120, 20);

		
		//Patient Name Label
		pName = new JLabel("Patient Name");
		pName.setFont(new Font("Calibri", Font.BOLD, 15));
		pName.setBounds(450, 200, 120, 20);

		//Patient Name from DB
		tName = new JLabel(Name);
		tName.setFont(new Font("Calibri", Font.PLAIN, 15));
		tName.setBounds(560, 200, 120, 20);
		
		//Appointment Time Label
		apTime = new JLabel("Appointment Time");
		apTime.setFont(new Font("Calibri", Font.BOLD, 15));
		apTime.setBounds(750, 200, 120, 20);

		//Patient Time slot from DB
		taTime = new JLabel(tslot);
		taTime.setFont(new Font("Calibri", Font.PLAIN, 15));
		taTime.setBounds(900, 200, 120, 20);

		
		//Diagnosis Label
		diagnosis = new JLabel("Diagnosis");
		diagnosis.setFont(new Font("Calibri", Font.BOLD, 15));
		diagnosis.setBounds(450, 250, 120, 20);

		//Enter Diagnosis given to the patient
		JTextArea tDia = new JTextArea(sDia);
		tDia.setLineWrap(true);
		tDia.setWrapStyleWord(true);
		tDia.setFont(new Font("Calibri", Font.PLAIN, 15));
		tDia.setBounds(560, 250, 400, 75);

		//Drugs Label
		drugs = new JLabel("Drugs");
		drugs.setFont(new Font("Calibri", Font.BOLD, 15));
		drugs.setBounds(450, 340, 120, 20);

		//Enter Drugs prescribed to the patient
		JTextArea tDrugs = new JTextArea(sDrug);
		tDrugs.setLineWrap(true);
		tDrugs.setWrapStyleWord(true);
		tDrugs.setFont(new Font("Calibri", Font.PLAIN, 15));
		tDrugs.setBounds(560, 340, 400, 75);

		//Next visit lable
		pvDate = new JLabel("Next Visit");
		pvDate.setBounds(450, 420, 150, 50);
		pvDate.setFont(new Font("Calibri", Font.BOLD, 15));
		sdateChooser.setBounds(560, 435, 150, 20);

		//Visit depends on first or last 
		lvisit = new JLabel(sVisit);
		lvisit.setFont(new Font("Calibri", Font.BOLD, 15));
		lvisit.setBounds(560, 435, 150, 20);

		// Refer to new doctor
		JLabel lDoctor = new JLabel("Refer to");
		lDoctor.setFont(new Font("Calibri", Font.BOLD, 15));
		lDoctor.setBounds(450, 465, 200, 30);
		
		// Enter to be referred Doc
		JTextField tDoctor = new JTextField(sRef);
		tDoctor.setFont(new Font("Calibri", Font.PLAIN, 15));
		tDoctor.setBounds(560, 470, 150, 20);

		// GO back a screen
		aCancel = new JButton("Go Back");
		aCancel.setFont(new Font("Calibri", Font.PLAIN, 15));
		aCancel.setBounds(450, 530, 150, 25);

		aCancel.addActionListener(new ActionListener() 
		{ // Go back to the appointment Screen

			@Override
			public void actionPerformed(ActionEvent e) {
				LA.setVisible(false);
				try 
				{
					new appointment();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		
		//Update details in the DB after entering details
		aSubmit = new JButton("Submit");
		aSubmit.setFont(new Font("Calibri", Font.PLAIN, 15));
		aSubmit.setBounds(675, 530, 150, 25);
		aSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{ //Submit -S
				
				LA.setVisible(true);
				String diagnosis = tDia.getText();
				String Drugs = tDrugs.getText();
				String rDoctor = tDoctor.getText();

				if (sdateChooser.getDate() == null)
				{ // If 1.0 -S
					
					try 
					{ //try 1.0 -S
						ResultSetFetch.updateApp1(dname, aDate, tslot, diagnosis, Drugs,  rDoctor); //Update the appointment table
					} //try 1.0 -E
					
					catch (Exception e1)
					{//catch 1.0 -S
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}//catch 1.0 -E
					JOptionPane.showMessageDialog(null, "Appointment details updated sucessfully");
					LA.setVisible(false);
					new appointment(); // Go back to appointment Screen after Updating
					

				} // If 1.0 -E
				
				else 
				{ //else 1.0 -S
					Date day0 = null;
					Date day1 = null;
					Date Today = new Date();
					String pdate = format.format(sdateChooser.getDate());
					System.out.println(pdate);
					String today = format.format(Today);

					try 
					{ //try 2.0 -S
						day0 = format.parse(today);
						day1 = format.parse(pdate);
					} //try 2.0 -E
					
					catch (ParseException e1)
					{//catch 2.0 -S
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}//catch 2.0 -E

					//Can check only sysdate+ 30 days appoinment
					long diff = day1.getTime() - day0.getTime();
					int days = (int) (diff / (60 * 60 * 1000 * 24));
					if (days > 0.0 && days <= 30.0) 
					{ //if 2.0 -S
						String vdate = format.format(sdateChooser.getDate());
						System.out.println(vdate);
						try 
						{//try 3.0 -E
							if (sVisit != null) 
							{ // if 3.0.1 -S
								vDate = sVisit;
								System.out.println("Date box");
								System.out.println(vDate);
							} // if 3.0.1 -S
							
							else 
							{// else 3.0.1 -S
								vDate = vdate;
								System.out.println("Text box");
							}// else 3.0.1 -E
							
							try 
							{//try 3.1 -S
								ResultSetFetch.updateApp(dname, aDate, tslot, diagnosis, Drugs, vDate, rDoctor);
							} //try 3.1 -E
							
							catch (Exception e1) 
							{//catch 3.1 -S
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}//catch 3.1 -E
							JOptionPane.showMessageDialog(null, "Appointment details updated sucessfully");
							
							LA.setVisible(false);
							new appointment();

						} //try 3.0 -E
						
						catch (Exception e1) 
						{//catch 3.0 -S
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}//catch 3.0 -E

					}//if 2.0 -E 
					
					else 
					{//else 2.0 -S
						JOptionPane.showMessageDialog(null, "Next Appointment can be only for 30 days from tomorrow");
					}//else 2.0 -E
					
				} //else 1.0 -E

			}//Submit -S

		});

		// To Check Medical history
		History = new JButton("Medical History");
		History.setFont(new Font("Calibri", Font.PLAIN, 15));
		History.setBounds(450, 575, 150, 25);
		History.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{ // TODO Auto-generated
				JOptionPane.showMessageDialog(History, "Coming Soon");
			}
		});

		//To predict disease cause
		Disease = new JButton("Disease Info");
		Disease.setFont(new Font("Calibri", Font.PLAIN, 15));
		Disease.setBounds(675, 575, 150, 25);
		Disease.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{ // TODO Auto-generated
				JOptionPane.showMessageDialog(History, "Coming Soon");
			}
		});

		// Reset button to clear the Drugs, Diagnosis textbox
		aReset = new JButton("Reset");
		aReset.setFont(new Font("Calibri", Font.PLAIN, 15));
		aReset.setBounds(900, 530, 150, 25);
		aReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				tDrugs.setText(" ");
				tDia.setText(" ");
				tDoctor.setText(" ");
				// tEmail.setText(" ");
				// tPhone.setText(" ");
			}
		});

		
		
		//Logout button action
		Logout = new JButton("Logout");
		Logout.setFont(new Font("Calibri", Font.BOLD, 15));
		Logout.setForeground(Color.GRAY);
		Logout.setBounds(1100, 120, 150, 30);
		img1 = new ImageIcon(this.getClass().getResource("/l.png")).getImage();
        Logout.setBackground(c);
        Logout.setIcon(new ImageIcon(img1));
		Logout.setBorderPainted(false);
		Logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try 
				{
					ResultSetFetch.updateLogoutTime("DOCTOR",Login_All.UserName);
					new Login_All(); // Return Back to Login Page
					LA.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		//Copyrights
		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);

		
		// add necessary variables to be populated in JFrame
		LA.add(cp);
		LA.add(cpn);
		LA.add(conText);
		LA.add(lImg);
		LA.add(welcomTex1);
		LA.add(aID);
		LA.add(pName);
		LA.add(tName);
		LA.add(diagnosis);
		LA.add(tDia);
		LA.add(taID);
		LA.add(drugs);
		LA.add(tDrugs);
		LA.add(pvDate);
		LA.add(lDoctor);
		LA.add(tDoctor);
		LA.add(apDate);
		LA.add(apTime);
		LA.add(taDate);
		LA.add(taTime);
		LA.add(aSubmit);
		LA.add(aCancel);
		LA.add(History);
		LA.add(aReset);
		System.out.println(sVisit);
		
		// If it is a first visit then display date to schedule Next visit
		if (sVisit == null) 
		{
			LA.add(sdateChooser);
			System.out.println("Date box");
		} 
		else  // Else populate Last visit
		{
			LA.add(lvisit);
			System.out.println("Text box");
		}
		
		LA.add(Disease);
		LA.add(Logout);
		LA.setSize(1500, 1500);
		LA.setLayout(null);
		LA.setVisible(true);

	}// VisitCons - E


} // Visit -E

