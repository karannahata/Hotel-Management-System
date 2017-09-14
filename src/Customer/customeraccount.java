package Customer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.filechooser.FileNameExtensionFilter;

import Admin.WelcomePage;
import Beans.Customer;
import DAO.CustomerImpl;

import javax.swing.*;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class customeraccount implements ActionListener
{JFrame customeraccframe;
JLabel fname,lname,phnno,email,loginidd,address,city,state,pincode,logolabel,profileimagelabel;
JButton back,editdetails,save,logout,fpassword,browse;
Icon profileimage,logoimage;
JPanel middle;
File f;
String loginid;
JTextField phn,addressf,pin,emailf;
CustomerImpl c;
 

void customeracc(String loginid) throws ClassNotFoundException, SQLException

{  this.loginid=loginid;





	customeraccframe=new JFrame();
     customeraccframe.setSize(1366,768);
    
 	customeraccframe.setLayout(null);
 	customeraccframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	customeraccframe.setTitle("My Dashboard");
 	customeraccframe.setResizable(true);
 	//sp.setExtendedState(JFrame.MAXIMIZED_BOTH);
	logoimage= new ImageIcon("log1.png");
	logolabel=new JLabel(logoimage);
	logolabel.setBounds(970,20,460,156);
	customeraccframe.add(logolabel);
	
	profileimage= new ImageIcon("profile.jpg");
	profileimagelabel=new JLabel(profileimage);
	profileimagelabel.setBounds(20,10,150,150);
	
	customeraccframe.add(profileimagelabel);
	
	middle=new JPanel();
	middle.setBackground(Color.BLUE);
	middle.setBounds(0,200,1500,400);
	middle.setLayout(null);
	
	browse=new JButton("Browse");
	browse.setBounds(20,160,150,30);
	browse.addActionListener(this);
	customeraccframe.add(browse);
	fpassword=new JButton("Change password");
	fpassword.setBounds(1060,3,150,20);
	customeraccframe.add(fpassword);
	fpassword.addActionListener(this);
	back=new JButton("Back");
	back.setBounds(20,630,150,30);
	back.addActionListener(this);
	customeraccframe.add(back);
	editdetails=new JButton("Edit details");
	editdetails.setBounds(1100,630,200,30);
	editdetails.addActionListener(this);
	customeraccframe.add(editdetails);
	
	save=new JButton("Save");
	save.setBounds(1100,630,200,30);
	save.addActionListener(this);
	customeraccframe.add(save);
	save.setVisible(false);
	
	logout=new JButton("Logout");
	logout.setBounds(1220,3,120,20);
	logout.addActionListener(this);
	customeraccframe.add(logout);
	Font f2= new Font("Times New Roman",Font.BOLD,20);
	
	email= new JLabel("Email id");
    email.setFont(f2);
    email.setForeground(Color.white);
    email.setBounds(20,30,150,30);
    middle.add(email);
    
    emailf=new JTextField();
	emailf.setBounds(230,30,200,30);
	emailf.setEditable(false);
	middle.add(emailf);
    
    phnno= new JLabel("Phone");
    phnno.setFont(f2);
    //l1.setForeground(Color.white);
    phnno.setForeground(Color.white);
    phnno.setBounds(20,90,150,30);
    middle.add(phnno);
    
    phn=new JTextField();
	phn.setBounds(230,90,200,30);
	phn.setEditable(false);
	middle.add(phn);
    
    
    address= new JLabel("Address");
    address.setFont(f2);
    //l1.setForeground(Color.white);
    address.setForeground(Color.white);
    address.setBounds(20,150,150,30);
    middle.add(address);
    
    addressf=new JTextField();
	addressf.setBounds(230,150,200,30);
	addressf.setEditable(false);
	middle.add(addressf);
    
  /*  city= new JLabel("City");
    city.setFont(f2);
    //l1.setForeground(Color.white);
    city.setForeground(Color.white);
    city.setBounds(20,210,150,30);
    middle.add(city);
    state= new JLabel("State");
    state.setFont(f2);
    //l1.setForeground(Color.white);
    state.setForeground(Color.white);
    state.setBounds(20,270,150,30);
    middle.add(state);*/
    pincode= new JLabel("Pincode");
    pincode.setFont(f2);
    //l1.setForeground(Color.white);
    pincode.setForeground(Color.white);
    pincode.setBounds(20,210,150,30);
    middle.add(pincode);
    
    pin=new JTextField();
	pin.setBounds(230,210,200,30);
	pin.setEditable(false);
	middle.add(pin);
	
	Customer customer=new Customer();
	 c = new CustomerImpl();
	
	
	/*try
	{
	ps= c.prepareStatement("select PHONENO,EMAIL,ADDRESS,PINCODE from CUSTOMER where (LOGINID='"+loginid+"')");
    
	//customerlogin.setString(1,t1.getText());
    //customerlogin.setString(2,new String(p.getPassword()));
   
     r=ps.executeQuery();
     
    if(r.next())
    {phn.setText(r.getString(1));
    emailf.setText(r.getString(2));
    addressf.setText(r.getString(3));
    pin.setText(r.getString(4));
    }
    }
	catch(Exception e)
	{
		System.out.println(e);
	}
    */
	
	customer=c.viewCustomerdetails(loginid);
	addressf.setText(customer.getAddress());
	phn.setText(customer.getPhoneNumber());
	emailf.setText(customer.getEmailId());
	pin.setText(customer.getPinCode());
    	
    
    
    customeraccframe.add(logolabel);
	
	customeraccframe.add(middle);

	
	customeraccframe.setVisible(true);
	
	
}

/*public static void main(String s[])
{
	customeraccount c=new customeraccount();
	c.customeracc(loginid);
}*/

public void actionPerformed(ActionEvent a) {
	// TODO Auto-generated method stub
	if(a.getSource()==back){
		customeraccframe.dispose();
	custh h=new custh();
	try {
		h.custhome(loginid);
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
		try {
			h.custhome(loginid);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	if(a.getSource()==browse)
	{JFileChooser chooser=new JFileChooser();
	int returnval=chooser.showOpenDialog(customeraccframe);
	if(returnval==JFileChooser.APPROVE_OPTION){
		f=chooser.getSelectedFile();
		profileimagelabel.setIcon(new ImageIcon(f.getAbsolutePath()));
		
	}
	else
	{
		profileimagelabel.setIcon(profileimage);
	}
		
	}
	if(a.getSource()==fpassword)
	{    customeraccframe.dispose();
		ChangePassword cp=new ChangePassword(loginid);
		
	}
	if(a.getSource()==logout)
	{customeraccframe.dispose();
	WelcomePage w=new WelcomePage();
	
	}
	if(a.getSource()==editdetails)
	{  
		phn.setEditable(true);
	    emailf.setEditable(true);
	    addressf.setEditable(true);
	    pin.setEditable(true);
	    
	    
	    
	    editdetails.setVisible(false);
	  save.setVisible(true);
	    
	}
	if(a.getSource()==save)
	{
		PreparedStatement ps;
		
			
			phn.setEditable(false);
		    emailf.setEditable(false);
		    addressf.setEditable(false);
		    pin.setEditable(false);
		    
			try {
				c.editCustomerdetails(loginid, addressf.getText(), phn.getText(), pin.getText(), emailf.getText());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("done");
			save.setVisible(false);
			editdetails.setVisible(true);
			
			
	}

	
}
	
}