package Employee;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.*;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import Beans.Customer;
import DAO.CustomerImpl;
import DatabaseWork.CustomerDatabase;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;


public class AddCustomer implements ActionListener {

	JFrame frame;
	Icon logo_image;
	JLabel logo_label;
	JLabel empidLabel,nameLabel, emailLabel, genderLabel, addrLabel, adharcardNumberLabel , phoneNumberLabel, dobLabel,jli;
	JTextField nameField, emailField, addrField, adharcardField, phoneNumberField;
	JButton doneButton, backButton, resetButton;
	JRadioButton maleButton,femaleButton,otherGenderButton;
	
	Icon img;
	JLabel empIDLabel,pincodeLabel,ImageFile;
	JTextField empIDField,pincodeField;
	String gender;
	Date dob;
	JFileChooser myFileChooser;
	JButton chooseAnImage;
	String eid;
	
	Font f1;
	
	JDateChooser jc ;
	public AddCustomer(String eid)
	{this.eid=eid;
		
		frame = new JFrame();
		jc  = new JDateChooser();
		Color C = Color.decode("#1A242A");
		frame.getContentPane().setBackground(C);
		
		nameLabel = new JLabel("Name :");
		emailLabel = new JLabel("Email :");
		genderLabel = new JLabel("Sex :");
		addrLabel = new JLabel("Address :");
		adharcardNumberLabel = new JLabel("Adhaar Card Number :");
		phoneNumberLabel = new JLabel("Phone number :");
		dobLabel = new JLabel("Date of Birth :");
		pincodeLabel = new JLabel("Pincode :");
		
		
		
		nameLabel.setForeground(Color.WHITE);
		emailLabel.setForeground(Color.WHITE);
		genderLabel.setForeground(Color.WHITE);
		addrLabel.setForeground(Color.white);
		adharcardNumberLabel.setForeground(Color.WHITE);
		phoneNumberLabel.setForeground(Color.WHITE);
		dobLabel.setForeground(Color.WHITE);
		pincodeLabel.setForeground(Color.WHITE);
		
		
		nameField = new JTextField();
		emailField = new JTextField();
		addrField = new JTextField();
		adharcardField = new JTextField();
		phoneNumberField = new JTextField();
		pincodeField = new JTextField();
	
		doneButton = new JButton("Done");
		resetButton = new JButton("Reset");
		backButton=new JButton("Back");	
		
		maleButton = new JRadioButton(" Male");
		femaleButton = new JRadioButton(" Female");
		otherGenderButton = new JRadioButton(" Other");
		
		
		createFrame();
	}	
	
	public void createFrame()
	{
		f1 = new Font("Ariel",Font.BOLD,16);
		
		frame.setLayout(null);
		frame.setBounds(0,0,1366,768);
		frame.setResizable(false);
		frame.setTitle("Customer Details");
		
		logo_image = new ImageIcon("Capture5 - copy.PNG");
		logo_label = new JLabel(logo_image);
		logo_label.setBounds(800, 10, 720, 156);
		frame.add(logo_label);
		
		nameLabel.setBounds(150,170,300,50);
		emailLabel.setBounds(150,250,300,50);
		genderLabel.setBounds(150,330,300,50);
		dobLabel.setBounds(150,410,300,50);
		addrLabel.setBounds(720,170,300,50);
		pincodeLabel.setBounds(720,250,300,50);
		phoneNumberLabel.setBounds(720,330,300,50);
		adharcardNumberLabel.setBounds(720,410,300,50);
				
		nameLabel.setFont(f1);
		emailLabel.setFont(f1);
		genderLabel.setFont(f1);
		dobLabel.setFont(f1);
		addrLabel.setFont(f1);
		pincodeLabel.setFont(f1);
		phoneNumberLabel.setFont(f1);
		adharcardNumberLabel.setFont(f1);
		
		
		frame.add(nameLabel);
		frame.add(emailLabel);
		frame.add(dobLabel);
		frame.add(genderLabel);
		frame.add(addrLabel);
		frame.add(pincodeLabel);
		frame.add(adharcardNumberLabel);
		frame.add(phoneNumberLabel);
		
		ButtonGroup Genders = new ButtonGroup();
		maleButton.setBounds(270,340,70,30);
		femaleButton.setBounds(350,340,90,30);
		otherGenderButton.setBounds(440,340,100,30);
		maleButton.setFont(f1);
		femaleButton.setFont(f1);
		otherGenderButton.setFont(f1);
		Genders.add(maleButton);
		Genders.add(femaleButton);
		Genders.add(otherGenderButton);
		frame.add(maleButton);
		frame.add(femaleButton);
		frame.add(otherGenderButton);
		
		nameField.setBounds(280,170,200,40);
		frame.add(nameField);
		emailField.setBounds(280,250,200,40);
		frame.add(emailField);
		
		jc.setBounds(280,425,200,30);
		frame.add(jc);
		
		addrField.setBounds(900,170,200,50);
		frame.add(addrField);
		pincodeField.setBounds(900,250,200,50);
		frame.add(pincodeField);
		
		adharcardField.setBounds(900,410,200,50);
		frame.add(adharcardField);
		phoneNumberField.setBounds(900,330,200,50);
		frame.add(phoneNumberField);
		
		doneButton.setBounds(500,500,100,50);
		resetButton.setBounds(700,500, 100, 50);
		backButton.setBounds(10, 10, 100, 30);
		doneButton.setFont(f1);
		resetButton.setFont(f1);
		backButton.setFont(f1);
		
		frame.add(doneButton);
		frame.add(resetButton);
		frame.add(backButton);
		
		doneButton.addActionListener(this);
		resetButton.addActionListener(this);
		backButton.addActionListener(this);
		
		frame.setVisible(true);
	}
	


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==doneButton){
			Customer customer = new Customer();
			customer.setCustomerName(nameField.getText());
			customer.setAddress(addrField.getText());
			customer.setEmailId(emailField.getText());
			customer.setGender(gender);
			customer.setAadharNumber(adharcardField.getText());
			customer.setDob(dob);
			customer.setPinCode(pincodeField.getText());
			customer.setPhoneNumber(phoneNumberField.getText());
			CustomerImpl ci= new CustomerImpl();
			try {
				if(ci.addCustomer(customer)==1){
					JOptionPane.showMessageDialog(frame,"Customer is added");
				}
				else{
					JOptionPane.showMessageDialog(frame,"Custommer is not added","Alert",JOptionPane.ERROR_MESSAGE);
				}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.setVisible(false);
			}
		
		if(e.getSource()==resetButton){
			nameField.setText(null); emailField.setText(null);
			addrField.setText(null); adharcardField.setText(null);
			phoneNumberField.setText(null); pincodeField.setText(null);
		
		}
		if(e.getSource()==backButton){
			MainPage m=new MainPage(eid);
			
			frame.dispose();
		}
		
	}
	

}
