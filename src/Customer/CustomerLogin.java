package Customer;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import Beans.Customer;
import DAO.CustomerImpl;

import java.awt.event.*;
import java.time.Month;
import java.util.Date;

import javax.swing.*;
import java.sql.*;


public class CustomerLogin implements ActionListener

{

	JFrame j1frame;
	JLabel loginidlabel,lpasswordlabel,headinglabel,imagelabel,notuserlabel;
	JTextField loginidfield;
	JPasswordField passwordfield;
	JButton btnsubmit,btnreset,forgotpass,signup;
	Icon i,i2,is;
	JRadioButton gen,gen1;
	JComboBox cou;
	Connection c;
	PreparedStatement customerlogin;
	ResultSet rs;
	JDateChooser dob;
	ButtonGroup bg;
	int i1;
	
	
	
	public void login()
	{
		j1frame = new JFrame();
		j1frame.setLayout(null);
		j1frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		j1frame.setTitle("Customer Login");
		//j1frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		j1frame.setBounds(400,100,650,600);
		j1frame.setResizable(true);
		j1frame.getContentPane().setBackground(Color.decode("#1A242A"));
		
		//i2=new ImageIcon("image1.jpg");
		//b=new JLabel(i2);
		//b.setBounds(0, 0, 1000, 1000);
		//j1frame.setContentPane(b);
		//j1frame.add(b);
		
		i = new ImageIcon("log1.png");
		imagelabel=new JLabel(i);
		imagelabel.setBounds(980,10,460,156);
		j1frame.add(imagelabel);
		
		/*headinglabel = new JLabel("Welcome Customer");
		Font f= new Font("Times New Roman",Font.ITALIC,40);
		headinglabel.setBackground(Color.white);
		headinglabel.setFont(f);
	    headinglabel.setForeground(Color.blue);
		headinglabel.setBounds(200,50,400,30);
		j1frame.add(headinglabel);*/
			
		
		//l=new JLabel("Already a user??? ");
		
	    loginidlabel = new JLabel("LOGIN ID");
	    Font f1= new Font("Amandella Script",Font.BOLD,40);
        loginidlabel.setFont(f1);
        loginidlabel.setForeground(Color.white);
        loginidlabel.setBackground(Color.white);
        loginidlabel.setToolTipText("This is your provided phoneno");
    
     	loginidlabel.setBounds(150,150,150,30);
		j1frame.add(loginidlabel);
		
		lpasswordlabel = new JLabel("PASSWORD");
		lpasswordlabel.setFont(f1);
		lpasswordlabel.setBounds(150,190,150,50);
		lpasswordlabel.setForeground(Color.WHITE);
		lpasswordlabel.setBackground(Color.WHITE);
		j1frame.add(lpasswordlabel);
		
		loginidfield=new JTextField();
		loginidfield.setBounds(350,150,150,30);
		j1frame.add(loginidfield);
		
		passwordfield = new JPasswordField();
		passwordfield.setBounds(350,195, 150,30);
		j1frame.add(passwordfield);
		
		btnsubmit= new JButton("Submit");
		btnsubmit.setBounds(100,300,100,35);
		btnsubmit.addActionListener(this);
		j1frame.add(btnsubmit);
		
		forgotpass= new JButton("Forgot password");
		forgotpass.setBounds(250,300,150,35);
		forgotpass.addActionListener(this);
		j1frame.add(forgotpass);
		
		
		btnreset= new JButton("Reset");
		btnreset.setBounds(450,300,100,35);
		btnreset.addActionListener(this);
		j1frame.add(btnreset);
		
		
		
		notuserlabel=new JLabel("Not an existing user??");
		notuserlabel.setForeground(Color.WHITE);
		Font f2= new Font("Arial",Font.BOLD,15);
		notuserlabel.setFont(f2);
		//notuserlabel.setBackground(Color.WHITE);
		notuserlabel.setBounds(180,400,200,35);
		j1frame.add(notuserlabel);
		
		signup=new JButton("Sign up");
		signup.setBounds(350,400,100,35);
		signup.addActionListener(this);
		j1frame.add(signup);
		j1frame.setVisible(true);
	

}

	public void actionPerformed(ActionEvent a) {
				
		if(a.getSource()==btnreset)
		{
			passwordfield.setText(null);
			
		    loginidfield.setText(null);
		 
		}
		
		if(a.getSource()==signup)
		{
			j1frame.dispose();
			signup s=new signup();
			s.signupp();
		}
		
		if(a.getSource()==forgotpass)
		{
			forgotpassword fp=new forgotpassword();
		}
		
		
	
		
		if(a.getSource()==btnsubmit)
		{
			CustomerImpl c = new CustomerImpl();
			
				try {System.out.println(passwordfield.getText());
					i1 = c.custlogin(loginidfield.getText(), passwordfield.getText());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			try {
				if(i1==1){
					
					 j1frame.dispose();  
				     custh c1=new custh();
				     try {
						c1.custhome(loginidfield.getText());
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}   
				   
				      }
				else{
					JOptionPane.showMessageDialog(null,"Invalid username or password .Please enter again or Click Signup");
					loginidfield.setText(null);
					passwordfield.setText(null);
				    
				}
			} 
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			
			
		
			
	     

			
	}

	
	}
	
	
	public static void main(String...a)
	{
		CustomerLogin ar=new CustomerLogin();
		ar.login();
	}
	   

	
}
