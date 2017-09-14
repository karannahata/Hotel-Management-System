package Employee;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import Beans.Customer;
import DAO.CustomerImpl;
import DatabaseWork.CustomerDatabase;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class EditCustomer implements ActionListener {
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
	Font f1;
	JDateChooser jc;
	UtilDateModel model;
	
	String loginId;
	String gender;
	public EditCustomer(String loginId,Customer customer) throws SQLException {
		this.loginId=loginId;
		
		frame=new JFrame();
		
		jc = new JDateChooser();
		
		nameLabel = new JLabel("Name :");
		emailLabel = new JLabel("Email :");
		genderLabel = new JLabel("Sex :");
		addrLabel = new JLabel("Address :");
		adharcardNumberLabel = new JLabel("Adhaar Card Number :");
		phoneNumberLabel = new JLabel("Phone number :");
		dobLabel = new JLabel("Date of Birth :");
		pincodeLabel = new JLabel("Pincode :");
		
		nameField = new JTextField();
		nameField.setText(customer.getCustomerName());
		gender =customer.getGender();
		addrField = new JTextField();
		addrField.setText(customer.getAddress());
		pincodeField = new JTextField();
		pincodeField.setText(customer.getPinCode());
		emailField = new JTextField();
		emailField.setText(customer.getEmailId());
		phoneNumberField = new JTextField();
		phoneNumberField.setText(customer.getPhoneNumber());
		adharcardField = new JTextField();
		adharcardField.setText(customer.getAadharNumber());
		
		maleButton = new JRadioButton(" Male");
		femaleButton = new JRadioButton(" Female");
		otherGenderButton = new JRadioButton(" Other");
	
		
		
		//jc.resetKeyboardActions();
		
		doneButton = new JButton("Done");
		resetButton = new JButton("Reset");
		backButton=new JButton("Back");	
		
		
		
		
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
		
		jc.setBounds(280,425,200,30);
		frame.add(jc);
		
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
		
		/*datePickerImpl.setBounds(280,425,200,30);
		frame.add(datePickerImpl);*/
		
		addrField.setBounds(900,170,200,50);
		frame.add(addrField);
		pincodeField.setBounds(900,250,200,50);
		frame.add(pincodeField);
		
		adharcardField.setBounds(900,410,200,50);
		frame.add(adharcardField);
		phoneNumberField.setBounds(900,330,200,50);
		frame.add(phoneNumberField);
		
		doneButton.setBounds(500,500,100,50);
		
		backButton.setBounds(10, 10, 100, 30);
		doneButton.setFont(f1);
		
		backButton.setFont(f1);
		doneButton.addActionListener(this);
		backButton.addActionListener(this);
		
		frame.add(doneButton);
		frame.add(resetButton);
		frame.add(backButton);
		
		if(gender.charAt(0)=='F'){
			femaleButton.setSelected(true);
		}
		if(gender.charAt(0)=='M'){
			maleButton.setSelected(true);
		}
		if(gender.charAt(0)=='O'){
			otherGenderButton.setSelected(true);
		}
		frame.setVisible(true);
	}
	/*public static void main(String ...S) throws SQLException
	{
		EditCustomer as = new EditCustomer("abc", rs, con);
	}*/
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==doneButton){
			Customer customer = new Customer();
			customer.setCustomerName(nameField.getText());
			customer.setAddress(addrField.getText());
			customer.setEmailId(emailField.getText());
			customer.setGender(gender);
			customer.setAadharNumber(adharcardField.getText());
			//customer.setDob(dob);
			customer.setPinCode(pincodeField.getText());
			customer.setPhoneNumber(phoneNumberField.getText());
			CustomerImpl ci = new CustomerImpl();
			int f=0;
			try {
				f=ci.editCustomer(loginId, customer);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(f==1){
				JOptionPane.showMessageDialog(frame,"Customer is edited");
			}
			else{

				JOptionPane.showMessageDialog(frame,"Custommer is not edited","Alert",JOptionPane.ERROR_MESSAGE);
			}
			
			frame.dispose();
		}
		if(e.getSource()==backButton){
			frame.dispose();
		}
		
	}
	


}
