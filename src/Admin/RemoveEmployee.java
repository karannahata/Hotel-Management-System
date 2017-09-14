package Admin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class RemoveEmployee implements ActionListener {

	Connection con;
	JFrame frame;
	String Admin;
	JLabel nameLabel, emailLabel, genderLabel, addrLabel, adharcardLabel, phoneNumberLabel, dobLabel,pincodeLabel;
	JLabel nameField, emailField, genderField, addrField, adharcardField, phoneNumberField, dobField,pincodeField;
	
	JButton Delete,cancelButton;
	
	Font f1,f2;
	ResultSet rs;
	String CustomerId;
	PreparedStatement P; 
	ResultSet Rs;
	String EmpId;
	String admin;
	
	public RemoveEmployee(Connection con, String admin)
	{
		this.con=con;
		this.admin = admin;
		frame = new JFrame();
		
		Delete = new JButton("Delete");
		cancelButton = new JButton("Cancel");
		
		nameLabel = new JLabel("Name :");
		emailLabel = new JLabel("Email :");
		genderLabel = new JLabel("Gender :");
		addrLabel = new JLabel("Address :");
		//adharcardLabel = new JLabel("Adhaar Card Number :");
		phoneNumberLabel = new JLabel("Phone number :");
		dobLabel = new JLabel("Date of Birth :");
		pincodeLabel = new JLabel("Pincode :");
		
		nameField = new JLabel();
		emailField = new JLabel();
		addrField = new JLabel();
		//adharcardField = new JLabel();
		phoneNumberField = new JLabel();
		pincodeField = new JLabel();
		genderField = new JLabel();
		dobField = new JLabel();
		
		//CustomerId=new JLabel("Enter Customer Id:");
		
		createFrame();
	}

	public void createFrame()
	{
		f1 = new Font("Ariel",Font.BOLD,16);
		f2 = new Font("Ariel",Font.BOLD,22);
		
		frame.setLayout(null);
		frame.setBounds(0,0,1366,768);
		frame.setResizable(false);
		frame.setTitle("Customer Details");
		
		nameLabel.setBounds(150,250,300,50);
		emailLabel.setBounds(150,330,300,50);
		genderLabel.setBounds(150,410,300,50);
		dobLabel.setBounds(150,490,300,50);
		addrLabel.setBounds(720,250,300,50);
		pincodeLabel.setBounds(720,330,300,50);
		phoneNumberLabel.setBounds(720,410,300,50);
		//adharcardLabel.setBounds(720,490,300,50);
		
		
		nameLabel.setFont(f1);
		emailLabel.setFont(f1);
		genderLabel.setFont(f1);
		dobLabel.setFont(f1);
		addrLabel.setFont(f1);
		pincodeLabel.setFont(f1);
		phoneNumberLabel.setFont(f1);
		//adharcardLabel.setFont(f1);
	
		frame.add(nameLabel);
		frame.add(emailLabel);
		frame.add(dobLabel);
		frame.add(genderLabel);
		frame.add(addrLabel);
		frame.add(pincodeLabel);
		//frame.add(adharcardLabel);
		frame.add(phoneNumberLabel);
	
		
		Delete.setBounds(450,600,100,30);
		frame.add(Delete);
		Delete.addActionListener(this);
		cancelButton.setBounds(600,600,100,30);
		frame.add(cancelButton);
		
		nameField.setBounds(280,258,200,40);
		frame.getContentPane().add(nameField);
		emailField.setBounds(280,338,200,40);
		frame.getContentPane().add(emailField);
		
	
		addrField.setBounds(915,253,200,50);
		frame.getContentPane().add(addrField);
		pincodeField.setBounds(915,330,200,50);
		frame.getContentPane().add(pincodeField);
		
		//adharcardField.setBounds(915,490,200,50);
		//frame.getContentPane().add(adharcardField);
		phoneNumberField.setBounds(915,413,200,50);
		frame.getContentPane().add(phoneNumberField);
		
		genderField.setBounds(280, 413, 200, 50);
		frame.getContentPane().add(genderField);
		
		dobField.setBounds(280, 493, 200, 50);
		frame.getContentPane().add(dobField);
		
		
		EmpId = JOptionPane.showInputDialog(frame,"Enter the employee ID to be deleted :-");
		try {
			P = con.prepareStatement("select * from EmployeeDetails where EmployeeID = '"+EmpId+"'");
			ResultSet rs = P.executeQuery();
			
			rs.next();
					
			nameField.setText(rs.getString(2));
			emailField.setText(rs.getString(7));
			genderField.setText(rs.getString(3));
			addrField.setText(rs.getString(4));
			//adharcardField = new JLabel(rs.getString(13));
			phoneNumberField.setText(rs.getString(8));
			dobField.setText(rs.getString(6));
			pincodeField.setText(rs.getString(5));
			
			frame.setVisible(true);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this.frame, e.getMessage());
		}
		
		Delete.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==Delete)
		{
			int b=JOptionPane.showConfirmDialog(Delete, this, "Are you sure?", 0);
			//System.out.println(b);
			if(b==0){
				try {
					P = con.prepareStatement("delete from EmployeeDetails where Employeeid ='"+ EmpId +"'");
					P.execute();
					JOptionPane.showMessageDialog(this.frame,"Record Successfuly deleted.");
					this.frame.setVisible(false);
					new AdminHome(con,admin).frame.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this.frame, e1.getMessage());
				}
			}
			else if(b==1)
			{
				this.frame.setVisible(false);
				new AdminHome(con,admin).frame.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(this.frame, "Invalid Input");
			}	
		}
		if(e.getSource()==cancelButton){
			this.frame.setVisible(false);
			new AdminHome(con,admin).frame.setVisible(true);
		}
	}
}
