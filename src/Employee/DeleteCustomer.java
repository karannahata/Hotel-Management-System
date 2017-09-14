package Employee;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Beans.Customer;
import DAO.CustomerImpl;
import DatabaseWork.CustomerDatabase;

public class DeleteCustomer  implements ActionListener {
	JFrame frame;
	Icon logo_image;
	JLabel logo_label;
	JLabel nameLabel, emailLabel, genderLabel, addrLabel, adharcardLabel, phoneNumberLabel, dobLabel,pincodeLabel;
	JLabel nameField, emailField, genderField, addrField, adharcardField, phoneNumberField, dobField,pincodeField;
	
	Icon img;
	JButton Delete,cancelButton;
	
	Font f1,f2;
	
	String CustomerId;
	
	public DeleteCustomer(String CustomerId,Customer customer) throws SQLException
	{
		
		this.CustomerId=CustomerId;
		
		
		frame = new JFrame();
		
		Delete = new JButton("Delete");
		cancelButton = new JButton("Cancel");
		
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
	
	public void createFrame() throws SQLException
	{
		f1 = new Font("Ariel",Font.BOLD,16);
		f2 = new Font("Ariel",Font.BOLD,22);
		
		frame.setLayout(null);
		frame.setBounds(0,0,1366,768);
		frame.setResizable(false);
		frame.setTitle("Customer Details");
		
		logo_image = new ImageIcon("Capture5 - copy.PNG");
		logo_label = new JLabel(logo_image);
		logo_label.setBounds(800, 10, 720, 156);
		frame.add(logo_label);
		
		nameLabel.setBounds(150,250,300,50);
		emailLabel.setBounds(150,330,300,50);
		genderLabel.setBounds(150,410,300,50);
		dobLabel.setBounds(150,490,300,50);
		addrLabel.setBounds(720,250,300,50);
		pincodeLabel.setBounds(720,330,300,50);
		phoneNumberLabel.setBounds(720,410,300,50);
		adharcardLabel.setBounds(720,490,300,50);
		
	
		nameLabel.setFont(f1);
		emailLabel.setFont(f1);
		genderLabel.setFont(f1);
		dobLabel.setFont(f1);
		addrLabel.setFont(f1);
		pincodeLabel.setFont(f1);
		phoneNumberLabel.setFont(f1);
		adharcardLabel.setFont(f1);
	
		frame.add(nameLabel);
		frame.add(emailLabel);
		frame.add(dobLabel);
		frame.add(genderLabel);
		frame.add(addrLabel);
		frame.add(pincodeLabel);
		frame.add(adharcardLabel);
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
		if(e.getSource()==Delete){
			int b=JOptionPane.YES_NO_CANCEL_OPTION;
				JOptionPane.showConfirmDialog(null, "Are you sure?","Warning", b);
			if(b==0){
				CustomerImpl c = new CustomerImpl();
				int f = 0;
				try {
					f = c.deleteCustomer(CustomerId);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
				if(f==1){
					JOptionPane.showMessageDialog(frame,"Customer is Deleted");
				}
				else{

					JOptionPane.showMessageDialog(frame,"Custommer is not ","Alert",JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		}
		if(e.getSource()==cancelButton){
			frame.dispose();
		}
		
	}
	
}
