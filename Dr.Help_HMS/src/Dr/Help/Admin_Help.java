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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;

import ErrorHandler.EmptyFields_Error_Handler;
import Models.ResultSetFetch;

public class Admin_Help 
{ //AH -S
	
	//Declare Swing Components
	JFrame AH = new JFrame("Admin Help");
	JLabel conText, welcomTex, captionTex, welcomTex2, Name ,Issue_Description,Issue_Detail, cp, cpn, lImg, PriorityLabel, Mobile;
	JTextField tName, tMobile;
	JTextArea tIssue_Detail;
	JButton Submit, Clear, GoBack, Logout;
	String Issue[] = { "CREATE", "DELETE", "DROP", "ACCESS", "REPORTS", "UNLOCK ACCOUNT" };
	JComboBox<String> IssueCat = new JComboBox<String>(Issue);
	Integer[] Priority = {1,2,3,4};
	JComboBox<Integer> Prior = new JComboBox<Integer>(Priority);
	Color c;
	Image img,img1; 
	JPanel backgroundPanel;
	String ShowMessage, UerName;
	int Result,Prior_Status, SLA_Status, Hours_Remaning,confrmationNumber ;
	
	//Ref Object for Empty Fields
	EmptyFields_Error_Handler EEH = new EmptyFields_Error_Handler();
	
	
	
	/*
	 * 
	 * Below is used to raise a Ticket to Admin
	 * 
	 */
	public Admin_Help(String Screen)
	{ //ADH - S
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);
	
		welcomTex = new JLabel("Welcome to Dr.Help");
		welcomTex.setBounds(600, 10, 250, 100);
		welcomTex.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomTex.setForeground(Color.gray);
		
	
		captionTex = new JLabel("- For the People, Of the People, By the People");
		captionTex.setBounds(700,30,290,100);
		captionTex.setFont(new Font("Calibri", Font.PLAIN, 14));
		captionTex.setForeground(Color.gray);
	
		
		welcomTex2 = new JLabel("Please Create Your Request");
		welcomTex2.setFont(new Font("Calibri", Font.PLAIN, 15));
		welcomTex2.setBounds(600,100,200,100);
		
		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		
		img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		lImg = new JLabel(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		AH.getContentPane().setBackground(c);

		backgroundPanel = new JPanel();
		backgroundPanel.add(lImg);
		backgroundPanel.setLayout(new OverlayLayout(backgroundPanel));
		backgroundPanel.setOpaque(true);
	
		Name = new JLabel("Name");
		Name.setFont(new Font("Calibri", Font.PLAIN, 15));
		Name.setBounds(550, 200, 100, 20);
		
		tName = new JTextField();
		tName.setFont(new Font("Calibri", Font.PLAIN, 15));
		tName.setBounds(820, 200, 120, 20);
		
		Mobile = new JLabel("Contact Number");
		Mobile.setFont(new Font("Calibri", Font.PLAIN, 15));
		Mobile.setBounds(550,240,130,20);
		
		tMobile = new JTextField();
		tMobile.setFont(new Font("Calibri", Font.PLAIN, 15));
		tMobile.setBounds(820, 240, 120, 20);;
		
		Issue_Description = new JLabel("Select Your Issue Type");
		Issue_Description.setFont(new Font("Calibri", Font.PLAIN, 15));
		Issue_Description.setBounds(550, 280, 160, 25);
		IssueCat.setSelectedItem(null);
		IssueCat.setBounds(820, 280, 125, 20);
		
		Issue_Detail= new JLabel("Detailed Description About the Request");
		Issue_Detail.setFont(new Font("Calibri", Font.PLAIN, 15));
		Issue_Detail.setBounds(550, 330, 250, 25);
		
		tIssue_Detail = new JTextArea();
		tIssue_Detail.setLineWrap(true);
		tIssue_Detail.setWrapStyleWord(true);
		tIssue_Detail.setFont(new Font("Calibri", Font.PLAIN, 15));
		tIssue_Detail.setBounds(820,330, 120, 120);
		
		PriorityLabel = new JLabel("Priority Level");
		PriorityLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		PriorityLabel.setBounds(550, 480, 100, 25);
		Prior.setSelectedItem(null);
		Prior.setBounds(820, 480, 125, 20);
		
		Submit = new JButton("Submit");
		Submit.setBounds(630, 550, 85, 25);
		Submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LoginValidation(); // Perform Validation before creating a Ticket
			}
		});
		
		
		
		Clear= new JButton("Reset");
		Clear.setBounds(730, 550, 85, 25);
		Clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clearButton();
			}
		});
		
		//Return back to respective Screen as per Login
		GoBack= new JButton("GoBack");
		GoBack.setBounds(830, 550, 85, 25);
		GoBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Screen.equals("USER"))
				{
					new IssueDescription();
					AH.setVisible(false);
				}
				else if(Screen.equals("Management"))
				{
					new Management_Report();
					AH.setVisible(false);
				}
				else if (Screen.equals("Login"))
				{
					new Login_All();
					AH.setVisible(false);
				}
			}
		});
		
		
		Logout = new JButton("LOGOUT");
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
				try {
					ResultSetFetch.updateLogoutTime(Screen,Login_All.UserName); //Update Logout time
					new Login_All();
					AH.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					AH.setVisible(false);
					new Login_All();
					e1.printStackTrace();
				}
			}
		});

		
		AH.add(lImg);
		AH.add(conText);
		AH.add(welcomTex);
		AH.add(welcomTex2);
		AH.add(captionTex);
		AH.add(Name);
		AH.add(tName);
		AH.add(Mobile);
		AH.add(tMobile);
		AH.add(Issue_Description);
		AH.add(cp);
		AH.add(cpn);
		AH.add(IssueCat);
		AH.add(Issue_Detail);
		AH.add(tIssue_Detail);
		AH.add(PriorityLabel);
		AH.add(Prior);	
		AH.add(Submit);
		AH.add(Clear);
		AH.add(GoBack);
		//AH.add(Logout);
		AH.setLayout(null);
		AH.setSize(1500, 1500);
		AH.setVisible(true);
	
	} //ADH - E
	
	
	//Clear Button function
	private void clearButton()
	{
		tName.setText("");
		IssueCat.setSelectedItem(null);
		tIssue_Detail.setText("");
		Prior.setSelectedItem(null);
		tMobile.setText("");
		
	}
	
	
	//perform Validatiosn before creating a ticket
	private void LoginValidation()
	{  //Valid -S
		if(tName.getText().equals(""))
		{
			JOptionPane.showMessageDialog(tName, "Enter Your Name");
			EEH.NameEmpty("Raise A Request");
		}
		else if(tMobile.getText().equals(""))
		{
			JOptionPane.showMessageDialog(tMobile, "Enter Your Contact Number");
			EEH.PhoneNumberEmpty("Raise A Request");
		}
		else if (!(tMobile.getText().length() == 10)) 
		{
			JOptionPane.showMessageDialog(tMobile, "Please Enter Valid Phone Number");
			tMobile.setText("");
			EEH.PhoneNumberInvalid("Raise A Request");
		} 
		else if(IssueCat.getSelectedIndex() == -1)
		{
			JOptionPane.showMessageDialog(IssueCat, "Select Any One Category");
			EEH.CategoryEmpty("Raise A Request");
		}
		else if(tIssue_Detail.getText().equals(""))
		{
			JOptionPane.showMessageDialog(tIssue_Detail, "Enter Details About Your Request");
			EEH.issueDescriptionEmpty("Raise A Request");
		}
		else if(Prior.getSelectedIndex() == -1)
		{
			JOptionPane.showMessageDialog(Prior, "Select Your Priority");
			EEH.PriorityEmpty("Raise A Request");
		}
		else 
		{ //else -S
			//Ask Confirmation
			Result = JOptionPane.showConfirmDialog(Submit, "Are You Sure You Want to Submit");
			if(Result == JOptionPane.YES_OPTION)
			{ //If 1.1 -S
				Prior_Status = Prior.getSelectedIndex()+1;
				SLAandHours(Prior_Status);
				confrmationNumber= getRandomTicketID();
				Models.InsertInToDB.insertRequestTick(confrmationNumber, tName.getText(),tMobile.getText(),(String) IssueCat.getSelectedItem(), 
													tIssue_Detail.getText(), Prior_Status, SLA_Status, Hours_Remaning); //Submit Ticket
				
				ShowMessage = "Your Request has Been Successfully Submitted. RefNum is " + confrmationNumber;
				JOptionPane.showMessageDialog(null, ShowMessage);
				clearButton();
				
			} //If 1.1 -E
			else
			{//else 1.1 -S
				JOptionPane.showMessageDialog(null, "Please Click On Submit When You Are Ready");
				EEH.reValidateTicket("Raise A Request");
			} //else 1.1 -S
		} //else -E
		
		
	} //Valid -E
	
	
	//Calculate SLA and Hours depending upon the Priority
	private void SLAandHours(int Prior_Status )
	{ //SLA- S
		if(Prior_Status == 1)
		{
			SLA_Status=1;
			Hours_Remaning=2;
		}
		else if (Prior_Status == 2)
		{
			SLA_Status=1;
			Hours_Remaning=4;
		}
		else if(Prior_Status == 3)
		{
			SLA_Status=2;
			Hours_Remaning=8;
		}
		else if(Prior_Status == 4)
		{
			SLA_Status=3;
			Hours_Remaning=16;
		}
		
	} //SLA- E
	
	
	//Generate Ticket Number for each request
	public static int getRandomTicketID() 
	{
		Random r = new Random(System.currentTimeMillis());
		return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}
		
	
	
	
	
}  //AH -E
