package Admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.sql.*;

public class AddAnotherAdmin implements ActionListener {

	JFrame frame;
	JLabel nameLabel,passwordLabel;
	JTextField nameField,passwordField;
	JButton confirm,cancel;
	Icon logo_image;
	JLabel logo_label;
	Font f1;
	Connection con;
	String admin;
	
	public AddAnotherAdmin(Connection con, String admin)
	{
		this.con = con;
		this.admin = admin;
		frame = new JFrame();
		nameLabel = new JLabel("Name :");
		passwordLabel = new JLabel("Password :");
		nameField = new JTextField();
		passwordField = new JPasswordField();
		confirm = new JButton("Confirm");
		cancel = new JButton("Cancel");
		f1 = new Font("Ariel",Font.BOLD,20);
		createFrame();
	
	}
	public void createFrame()
	{
		frame.setLayout(null);
		frame.setBounds(0,0,1366,768);
		logo_image = new ImageIcon("Capture5 - Copy.PNG");
		logo_label = new JLabel(logo_image);
		logo_label.setBounds(1000,10,366,156);
		frame.add(logo_label);
		Color C = Color.decode("#1A242A");
		frame.getContentPane().setBackground(C);
		nameLabel.setBounds(300,300,200,50);
		passwordLabel.setBounds(300,400,200,50);
		nameField.setBounds(400,300,200,50);
		passwordField.setBounds(400,400,200,50);
		nameLabel.setForeground(Color.WHITE);
		passwordLabel.setForeground(Color.white);
		nameLabel.setFont(f1);
		passwordLabel.setFont(f1);
		nameField.setFont(f1);
		passwordField.setFont(f1);
		
		confirm.setBounds(350, 500, 100, 30);
		cancel.setBounds(500, 500, 100, 30);
		
		frame.add(nameLabel);
		frame.add(passwordLabel);
		frame.add(nameField);
		frame.add(passwordField);
		frame.add(confirm);
		frame.add(cancel);
		
		confirm.addActionListener(this);
		cancel.addActionListener(this);
		
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent Ae) {
		// TODO Auto-generated method stub
		if(Ae.getSource() == cancel)
		{
			
		}
		if(Ae.getSource() == confirm)
		{
			this.frame.setVisible(false);
			new AdminHome(con,admin).frame.setVisible(true);
		}
	}

}
