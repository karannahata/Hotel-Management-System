package Employee;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.View;

import Beans.Customer;


public class ViewCustomer implements ActionListener {
	JFrame frame;
	Icon logo_image;
	JLabel logo_label;
	JLabel nameLabel, emailLabel, genderLabel, addrLabel, adharcardLabel, phoneNumberLabel, dobLabel,pincodeLabel;
	JLabel nameField, emailField, genderField, addrField, adharcardField, phoneNumberField, dobField,pincodeField;
	
	Icon img;
	
	JButton okButton;
	
	Font f1,f2;
	
	public ViewCustomer(Customer customer) throws SQLException
	{
		frame = new JFrame();
		
		okButton = new JButton("Okay");
		okButton.addActionListener(this);
		
		nameLabel = new JLabel("Name :");
		emailLabel = new JLabel("Email :");
		genderLabel = new JLabel("Sex :");
		addrLabel = new JLabel("Address :");
		adharcardLabel = new JLabel("Adhaar Card Number :");
		phoneNumberLabel = new JLabel("Phone number :");
		dobLabel = new JLabel("Date of Birth :");
		pincodeLabel = new JLabel("Pincode :");
		
		nameField = new JLabel(customer.getCustomerName());
		emailField = new JLabel(customer.getEmailId());
		genderField = new JLabel(customer.getGender());
		addrField = new JLabel(customer.getEmailId());
		adharcardField = new JLabel(customer.getAadharNumber());
		phoneNumberField = new JLabel(customer.getPhoneNumber());
		dobField=new JLabel();
	//	dobField = new JLabel(customer.getDob().toString());
		pincodeField = new JLabel(customer.getPinCode());
		
		
		
		createFrame();
	}	
	
	public void createFrame()
	{
		f1 = new Font("Ariel",Font.BOLD,16);
		
		frame.getContentPane().setLayout(null);
		frame.setBounds(0,0,1366,768);
		frame.setResizable(false);
		frame.setTitle("Customer Details");
		
		logo_image = new ImageIcon("Capture5 - copy.PNG");
		logo_label = new JLabel(logo_image);
		logo_label.setBounds(800, 10, 720, 156);
		frame.getContentPane().add(logo_label);
		
		nameLabel.setBounds(150,250,100,50);
		emailLabel.setBounds(150,330,300,50);
		genderLabel.setBounds(150,410,300,50);
		dobLabel.setBounds(150,490,300,50);
		addrLabel.setBounds(720,250,121,50);
		pincodeLabel.setBounds(720,330,113,50);
		phoneNumberLabel.setBounds(720,410,140,50);
		adharcardLabel.setBounds(720,490,177,50);
		
		nameLabel.setFont(f1);
		emailLabel.setFont(f1);
		genderLabel.setFont(f1);
		dobLabel.setFont(f1);
		addrLabel.setFont(f1);
		pincodeLabel.setFont(f1);
		phoneNumberLabel.setFont(f1);
		adharcardLabel.setFont(f1);
		
		frame.getContentPane().add(nameLabel);
		frame.getContentPane().add(emailLabel);
		frame.getContentPane().add(dobLabel);
		frame.getContentPane().add(genderLabel);
		frame.getContentPane().add(addrLabel);
		frame.getContentPane().add(pincodeLabel);
		frame.getContentPane().add(adharcardLabel);
		frame.getContentPane().add(phoneNumberLabel);
	
		okButton.setBounds(600,600,100,30);
		frame.getContentPane().add(okButton);
		
		nameField.setBounds(280,258,200,40);
		frame.getContentPane().add(nameField);
		emailField.setBounds(280,338,200,40);
		frame.getContentPane().add(emailField);
		
	
		addrField.setBounds(915,253,200,50);
		frame.getContentPane().add(addrField);
		pincodeField.setBounds(915,330,200,50);
		frame.getContentPane().add(pincodeField);
		
		adharcardField.setBounds(915,490,200,50);
		frame.getContentPane().add(adharcardField);
		phoneNumberField.setBounds(915,413,200,50);
		frame.getContentPane().add(phoneNumberField);
		
		genderField.setBounds(280, 413, 200, 50);
		frame.getContentPane().add(genderField);
		
		dobField.setBounds(280, 493, 200, 50);
		frame.getContentPane().add(dobField);
		
		frame.setVisible(true);
	}
	
	

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==okButton){
			frame.dispose();
		}
	}
	public static void main(String[] args) throws SQLException {
		ViewCustomer v = new ViewCustomer(null);
	}

}
