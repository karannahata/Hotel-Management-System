package Admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.*;

//import Welcome.WelcomePage;

public class AdminHome implements ActionListener {

	Icon logo_image;
	JLabel logo_label;
	JLabel title;
	JButton addStaffButton,viewRoomsButton,changePasswordButton,logoutButton,viewStaffButton,viewCustomerButton;
	JButton viewFeedback,removeEmployee;
	JButton addAnotherAdmin;
	JFrame frame;
	Connection con;
	String adminName;
	
	public AdminHome(Connection con, String admin)
	{
		frame = new JFrame();
		
		addStaffButton = new JButton("Add new Staff");
		viewRoomsButton = new JButton("View Rooms");
		changePasswordButton = new JButton("Change Password");
		logoutButton = new JButton("Logout");
		viewStaffButton = new JButton("View Staff Database");
		viewCustomerButton = new JButton("View customer Database");
		viewFeedback = new JButton("View Feedbacks");
		removeEmployee = new JButton("Remove an Employee");
		addAnotherAdmin = new JButton("Add Another Admin");
		//title = new JLabel("Welcome Administrator");
		
		//title.setForeground(Color.white);
		this.con = con;
		this.adminName = admin;
		createFrame();
	}
	public void createFrame()
	{
	
		Font f1= new Font("Ariel",Font.BOLD,20);
		logo_image = new ImageIcon("Capture5 - Copy.PNG");
		logo_label = new JLabel(logo_image);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setSize(1366,768);
		frame.setResizable(true);
		frame.setLayout(null);
		frame.setTitle("Administrator Home");
		
		Icon X = new ImageIcon("image3.jpg");
		JLabel A = new JLabel(X);
		frame.setContentPane(A);
		
		logo_label.setBounds(1000, 50, 360 , 156);
		changePasswordButton.setBounds(1000,10,142,30);
		logoutButton.setBounds(1194,10,142,30);
		title = new JLabel("Welcome Administrator");
		Font f= new Font("Amandella Script",Font.BOLD,100);
		title.setFont(f);
	    title.setForeground(Color.WHITE);
		title.setBounds(140,50,900,100);
		frame.add(title);	
		
		
		//title.setFont(new Font("Ariel",Font.ITALIC,100));
		addStaffButton.setBounds(1000+20, 210, 360-35, 45);
		viewRoomsButton.setBounds(1000+20, 280, 360-35, 45);
		viewStaffButton.setBounds(1000+20, 350, 360-35, 45);
		viewCustomerButton.setBounds(1000+20, 430, 360-35, 45);
		viewFeedback.setBounds(1000+20,520,350-35,45);
		removeEmployee.setBounds(1000+20,590, 360-35, 45);
		addAnotherAdmin.setBounds(1000+20, 660 , 360-35, 45);
		
		addStaffButton.setFont(f1);
		viewRoomsButton.setFont(f1);
		viewStaffButton.setFont(f1);
		viewCustomerButton.setFont(f1);
		viewFeedback.setFont(f1);
		removeEmployee.setFont(f1);
		addAnotherAdmin.setFont(f1);
		title.setFont(new Font("Ariel",Font.BOLD,60));
		
		frame.add(title);
		frame.add(viewRoomsButton);
		frame.add(viewStaffButton);
		frame.add(viewCustomerButton);
		frame.add(addStaffButton);
		frame.add(viewFeedback);
		frame.add(removeEmployee);
		frame.add(addAnotherAdmin);
		frame.add(logo_label);
		frame.add(logoutButton);
		frame.add(changePasswordButton);
		frame.setVisible(true);
		
		changePasswordButton.addActionListener(this);
		logoutButton.addActionListener(this);
		viewRoomsButton.addActionListener(this);
		viewStaffButton.addActionListener(this);
		viewCustomerButton.addActionListener(this);
		removeEmployee.addActionListener(this);
		addStaffButton.addActionListener(this);
		viewFeedback.addActionListener(this);
		addAnotherAdmin.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent Ae) {
		// TODO Auto-generated method stub
		if(Ae.getSource() == changePasswordButton)
		{
			ChangePassword Cp = new ChangePassword(con,adminName);
			this.frame.setVisible(false);
			Cp.frame.setVisible(true);
		}
		
		if(Ae.getSource() == logoutButton)
		{
			WelcomePage  Wp = new WelcomePage();
			this.frame.setVisible(false);
			 Wp.frame.setVisible(true);
		}
		
		if(Ae.getSource() == addStaffButton)
		{
			AddStaff As = new AddStaff(con,adminName);
			this.frame.setVisible(false);
			As.frame.setVisible(true);
		}
		
		if(Ae.getSource() == viewRoomsButton)
		{
			ViewRooms Vr = new ViewRooms(con,adminName);
			this.frame.setVisible(false);
			Vr.frame.setVisible(true);
		}
		
		if(Ae.getSource() == viewCustomerButton)
		{
			ViewCustomer Vc = new ViewCustomer(con,adminName);
			Vc.frame.setVisible(true);
			this.frame.setVisible(false);		
		}
		
		if(Ae.getSource() == viewStaffButton)
		{
			ViewStaff Vs = new ViewStaff(con,adminName);
			this.frame.setVisible(false);
			Vs.frame.setVisible(true);
		}
		if(Ae.getSource() == viewFeedback)
		{
			ViewFeedback Vf = new ViewFeedback(con,adminName);
			this.frame.setVisible(false);
			Vf.frame.setVisible(true);
		}
		if(Ae.getSource() == removeEmployee)
		{
			RemoveEmployee Re = new RemoveEmployee(con,adminName);
			this.frame.setVisible(false);
			Re.frame.setVisible(true);
		}
		if(Ae.getSource() == addAnotherAdmin)
		{
			
			new AddAnotherAdmin(con,adminName).frame.setVisible(true);
			this.frame.setVisible(false);
		}
	}
}
