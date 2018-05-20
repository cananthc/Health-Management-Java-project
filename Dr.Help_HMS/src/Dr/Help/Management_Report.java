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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import ErrorHandler.EmptyFields_Error_Handler;
import Models.ResultSetFetch;
import View.Report_View;
import View.User_Report;


public class Management_Report
{ //MR - S

	
	//Declare swing components
	JFrame MR = new JFrame("Management Report Section");
	JLabel cp,cpn,conText, lImg, welcomSec;
	JButton docReport, userReport, RaiseANewReq, HospSearch, HospVenture, HospCategory, feedBackReport, Logout;
	JTextField sDate, eDate;
	Image img,img1;
	Color c;
	Date date;
	int MM, DD, YYYY;
	String Date_Final_Start,Date_Final_End, YY;
	JDateChooser sdateChooser = new JDateChooser();
	JDateChooser edateChooser = new JDateChooser();
	
	//Create Reference objects
	View.Report_View RV = new Report_View();
	View.User_Report URV = new User_Report();
	EmptyFields_Error_Handler EEH = new EmptyFields_Error_Handler();
	
	
	
	/*
	 * 
	 * Below is to Provide Management Reports Option
	 * 
	 */
	public Management_Report()
	{ //MRC- S
		
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		MR.getContentPane().setBackground(c);
		
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);
		
		
		
		welcomSec = new JLabel("Please Select Your Option for Reports");
		welcomSec.setBounds(640,50,400,100);
		welcomSec.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomSec.setForeground(Color.gray);
		
		
		docReport = new JButton("Doctor Report");
		docReport.setBounds(530,150,170,20);
		docReport.setFont(new Font("Calibri", Font.PLAIN, 15));
		docReport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				doctorReport(); //Doctor Report
				MR.setVisible(false);
				
			}
		});
		
		
		userReport = new JButton("User Report");
		userReport.setBounds(730,150,170,20);
		userReport.setFont(new Font("Calibri", Font.PLAIN, 15));
		userReport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				userReport(); //User Report
				MR.setVisible(false);
			}
		});
		
		
		RaiseANewReq = new JButton("Raise A Request");
		RaiseANewReq.setFont(new Font("Calibri", Font.PLAIN, 15));
		RaiseANewReq.setBounds(930, 150, 170, 20);
		RaiseANewReq.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_Help("Management"); //Raise A Request 
				MR.setVisible(false);
			}
		});
		
		
		HospSearch = new JButton("Hospital Search");
		HospSearch.setFont(new Font("Calibri", Font.PLAIN, 15));
		HospSearch.setBounds(530, 200, 170, 20);
		HospSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new NearByMedicalShop("MANAGEMENT"); //Search Med Shop Report
				MR.setVisible(false);
			}
		});
		
		HospVenture = new JButton("Hospital Venture");
		HospVenture.setFont(new Font("Calibri", Font.PLAIN, 15));
		HospVenture.setBounds(730, 200, 170, 20);
		HospVenture.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Hosp_Venture(); //Hosp Venture Report
				MR.setVisible(false);
			}
		});
		
		HospCategory = new JButton("Hospital Category List");
		HospCategory.setFont(new Font("Calibri", Font.PLAIN, 15));
		HospCategory.setBounds(930, 200, 170, 20);
		HospCategory.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub 
				new Hosp_Category(); //Hosp  Category Report
				MR.setVisible(false);
			}
		});
		
		feedBackReport = new JButton("Provide Feeback To Developers");
		feedBackReport.setFont(new Font("Calibri", Font.PLAIN, 15));
		feedBackReport.setBounds(530, 250, 250, 20);
		feedBackReport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				feedBackReport(); //Feeback Report
				MR.setVisible(false);
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
					ResultSetFetch.updateLogoutTime("MANAGEMENT",Login_All.UserName); //Update logout time
					new Login_All();
					MR.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		MR.add(cp);
		MR.add(cpn);
		MR.add(lImg);
		MR.add(conText);
		MR.add(welcomSec);
		MR.add(Logout);
		MR.add(docReport);
		MR.add(userReport);
		MR.add(RaiseANewReq);
		MR.add(HospSearch);
		MR.add(HospCategory);
		MR.add(HospVenture);
		MR.add(feedBackReport);
		MR.setSize(1500, 1500);
		MR.setLayout(null);
		MR.setVisible(true);
	} //MRC- E
	
	
	
	/*
	 * 
	 * Below is to Provide Doctor Report to Management
	 * 
	 */
	
	public void doctorReport()
	{ //DR -S
		//Declare swing components
		JFrame DR = new JFrame("Doctor Report");
		JLabel lImg, welcomtex, dateText, startDate, endDate ;
		JButton resetSD, resetED, submit, goBack, Logout;
		Color c;
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		DR.getContentPane().setBackground(c);
		
	
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);
	
		welcomtex = new JLabel("Hello, Welcome to Doctor's Report Section.");
		welcomtex.setBounds(570, 10, 400, 100);
		welcomtex.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomtex.setForeground(Color.gray);
		dateText = new JLabel("Please Select Your Dates for the Report Generation");
		dateText.setBounds(570,90,400,50);
		dateText.setFont(new Font("Calibri", Font.BOLD, 15));
		dateText.setForeground(Color.gray);
		
		
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
			{ //Action - S  
				// TODO Auto-generated method stub
				if(sdateChooser.getDate() != null)
				{ //If  1.0 - S
					if(edateChooser.getDate() != null)
					{//If  1.1 - S
						
						RV.DocViewList(getStartDate(), getEndDate()); //Call this method to display Doctors Report
					}//If  1.1 - E
					else
					{ //else  1.1 - S
						JOptionPane.showMessageDialog(submit, "Please Choose End Date");
						EEH.endDateEmptyReport("Mgmt Doc Report");
					}//else  1.1 - E
				} //If  1.0 - E
				else
				{//else   1.0 - S
					JOptionPane.showMessageDialog(submit, "Please Choose Start Date");
					EEH.startDateEmptyReport("Mgmt Doc Report");
				} //else  1.0 - E
				
			} //Action - E
		});
				
		goBack = new JButton("Go Back");
		goBack.setBounds(750, 350, 135, 20);
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Management_Report(); //Go back
				DR.setVisible(false);
				
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
				try 
				{
					ResultSetFetch.updateLogoutTime("MANAGEMENT",Login_All.UserName); //Update Logout time
					new Login_All();
					DR.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		
		DR.add(cp);
		DR.add(cpn);
		DR.add(lImg);
		DR.add(Logout);
		DR.add(conText);
		DR.add(welcomtex);
		DR.add(dateText);
		DR.add(startDate);
		DR.add(endDate);
		DR.add(sdateChooser);
		DR.add(edateChooser);
		DR.add(resetSD);
		DR.add(resetED);
		DR.add(submit);
		DR.add(goBack);
		
		DR.setLayout(null);
		DR.setSize(1500, 1500);
		DR.setVisible(true);
		
		
	
	} //DR -E
	
	/*
	 * 
	 * Below is to Provide User Report to Management
	 * 
	 */
	
	public void userReport()
	{ //UR -S
		
		//Declare swing components
	    JFrame UR = new JFrame("User Report");
		JLabel lImg, welcomtex, dateText, startDate, endDate ;
		JButton resetSD, resetED, submit, goBack, Logout;
		Color c;
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		UR.getContentPane().setBackground(c);
		
	
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);
	
		welcomtex = new JLabel("Hello, Welcome to Doctor's Report Section.");
		welcomtex.setBounds(570, 10, 400, 100);
		welcomtex.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomtex.setForeground(Color.gray);
		dateText = new JLabel("Please Select Your Dates for the Report Generation");
		dateText.setBounds(570,90,400,50);
		dateText.setFont(new Font("Calibri", Font.BOLD, 15));
		dateText.setForeground(Color.gray);
		
		
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
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(sdateChooser.getDate() != null)
				{ //If 1.0 -S
					if(edateChooser.getDate() != null)
					{ //If 1.1 -S
						
						URV.getUserAppointment(getStartDate(), getEndDate()); //Call this method to Display UserReport
					} //If 1.1 -E
					else
					{ //else 1.0 -S
						JOptionPane.showMessageDialog(submit, "Please Choose End Date");
						EEH.endDateEmptyReport("Mgmt Doc Report");
					}//else 1.0 -S
				} //If 1.0 -E
				else
				{
					JOptionPane.showMessageDialog(submit, "Please Choose Start Date");
					EEH.startDateEmptyReport("Mgmt Doc Report");
				}
				
			}
		});
				
		goBack = new JButton("Go Back");
		goBack.setBounds(750, 350, 135, 20);
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Management_Report();
				UR.setVisible(false);
				
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
					System.out.println(Login_All.UserName);
					ResultSetFetch.updateLogoutTime("MANAGEMENT",Login_All.UserName); //Update Logout Time
					new Login_All();
					UR.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	
		
		UR.add(cp);
		UR.add(cpn);
		UR.add(lImg);
		UR.add(Logout);
		UR.add(conText);
		UR.add(welcomtex);
		UR.add(dateText);
		UR.add(startDate);
		UR.add(endDate);
		UR.add(sdateChooser);
		UR.add(edateChooser);
		UR.add(resetSD);
		UR.add(resetED);
		UR.add(submit);
		UR.add(goBack);
		
		UR.setLayout(null);
		UR.setSize(1500, 1500);
		UR.setVisible(true);
		
		}
	
	
	
	/*
	 * 
	 * Below is to Provide Feedback Report to Management
	 * 
	 */
	public void feedBackReport()
	{ //Feedback Report -S
		
		//Declare Swing components
		JFrame FBR = new JFrame("FeedBack Report");
		
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		FBR.getContentPane().setBackground(c);
		
		JLabel welcomtex, headText, feedback;
		JButton resetSD, resetED, submit, goBack, Logout;
		JTextArea tFeedback;
	
		welcomtex = new JLabel("Hello, Welcome to Feedback Section.");
		welcomtex.setBounds(570, 10, 400, 100);
		welcomtex.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomtex.setForeground(Color.gray);
		
		headText = new JLabel("Please Provide Your Feedback");
		headText.setBounds(570,90,400,50);
		headText.setFont(new Font("Calibri", Font.BOLD, 15));
		headText.setForeground(Color.gray);
		
		
		feedback = new JLabel("Enter Your Feeback. Less than 4000 words:");
		
		feedback.setFont(new Font("Calibri", Font.BOLD, 15));
		feedback.setBounds(550, 280, 300, 20);
		
		tFeedback = new JTextArea();
		tFeedback.setLineWrap(true);
		tFeedback.setWrapStyleWord(true);
		tFeedback.setFont(new Font("Calibri", Font.PLAIN, 15));
		tFeedback.setBounds(550,300, 400, 100);
	
		
		
		submit = new JButton("Submit Feedback");
		submit.setBounds(570,450,150,20);
		submit.setFont(new Font("Calibri", Font.PLAIN, 15));
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tFeedback.getText().equals(""))
				{
					JOptionPane.showMessageDialog(tFeedback, "Please Enter a Feedback");
				}
				else
				{
					Models.InsertInToDB.feedbackComments(tFeedback.getText()); //Inserts Feedback into DB
					JOptionPane.showMessageDialog(tFeedback, "Feedback Submitting successfully");
					MR.setVisible(false);
					new Management_Report();
				}
			}
		});
	
				
		goBack = new JButton("Go Back");
		goBack.setBounds(750, 450, 150, 20);
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Management_Report();
				FBR.setVisible(false);
				
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
					ResultSetFetch.updateLogoutTime("MANAGEMENT",Login_All.UserName); //Update logout time
					new Login_All();
					FBR.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		
		FBR.add(cp);
		FBR.add(cpn);
		FBR.add(lImg);
		FBR.add(conText);
		FBR.add(welcomtex);
		FBR.add(headText);
		FBR.add(feedback);
		FBR.add(tFeedback);
		FBR.add(submit);
		FBR.add(goBack);
		FBR.add(Logout);
		FBR.setLayout(null);
		FBR.setSize(1500, 1500);
		FBR.setVisible(true);
		
	
	} //Feedback Report -E
	
	
	//Calculate Start Date a per Oracle Data
	@SuppressWarnings("deprecation")
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


	//Calculate Start Date a per Oracle Data
@SuppressWarnings("deprecation")
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
	



} //MR - E
