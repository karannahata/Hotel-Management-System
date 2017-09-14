package Customer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import Beans.Customer;
import DAO.CustomerImpl;

public class signup implements ActionListener{
	JFrame spframe;
	JLabel imagelabel,headinglabel,namelabel,loginidlabel,passwordlabel,reenterpasswordlabel,phnnolabel,emaillabel,genderlabel,s10,s11,s12,s13,s14;
	JTextField t2,t3,t4,t5,t6,t7,t8,t9,t10;
	JPasswordField p1,p2;
	JButton submitbutton,submitresetbutton,submitbackbtn;
	Icon is;
	JRadioButton gendermaleb,genfemale;
	JComboBox cou;
	
	
	JDateChooser dob;
	ButtonGroup bg;
	String custid;

	void signupp(){
	
	spframe=new JFrame();
	spframe.setLayout(null);
	spframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	spframe.setTitle("Customer Signup");
	spframe.setResizable(true);
	spframe.setSize(1366,768);
	
	
	//spframe.getContentPane().setBackground(Color.green);
	is = new ImageIcon("log1.png");
	imagelabel=new JLabel(is);
	imagelabel.setBounds(980,10,460,156);
	spframe.add(imagelabel);
	//spframe.setVisible(true);
	
	headinglabel = new JLabel("SIGN UP");
	Font f= new Font("Monotype Corsiva",Font.BOLD,40);
	headinglabel.setFont(f);
    headinglabel.setForeground(Color.DARK_GRAY);
	headinglabel.setBounds(540,50,300,35);
	spframe.add(headinglabel);		
	namelabel = new JLabel("Name");
	Font f2= new Font("Times New Roman",Font.BOLD,15);
    namelabel.setFont(f2);
    //l1.setForeground(Color.white);
    namelabel.setBackground(Color.white);
    namelabel.setBounds(80,150,100,30);
    spframe.add(namelabel);
    loginidlabel = new JLabel("Loginid");
    loginidlabel.setFont(f2);
    //l1.setForeground(Color.white);
    loginidlabel.setBackground(Color.white);
    loginidlabel.setBounds(80,190,100,30);
    spframe.add(loginidlabel);
    
    passwordlabel = new JLabel("Enter password");
    passwordlabel.setFont(f2);
    //l1.setForeground(Color.white);
    passwordlabel.setBackground(Color.white);
    passwordlabel.setBounds(80,230,150,30);
    spframe.add(passwordlabel);
    
    reenterpasswordlabel = new JLabel("Reenter password");
    reenterpasswordlabel.setFont(f2);
    //l1.setForeground(Color.white);
    reenterpasswordlabel.setBackground(Color.white);
    reenterpasswordlabel.setBounds(80,270,150,30);
    spframe.add(reenterpasswordlabel);
    
    emaillabel = new JLabel("Email id");
    emaillabel.setFont(f2);
    //l1.setForeground(Color.white);
    emaillabel.setBackground(Color.white);
    emaillabel.setBounds(80,310,150,30);
    spframe.add(emaillabel);
    
    phnnolabel= new JLabel("Phone no");
    phnnolabel.setFont(f2);
    //l1.setForeground(Color.white);
    phnnolabel.setBackground(Color.white);
    phnnolabel.setBounds(80,350,150,30);
    phnnolabel.setToolTipText("This can be used as your loginid");
    spframe.add(phnnolabel);
    
    
    t2=new JTextField();
	t2.setBounds(280,150,150,30);
	spframe.add(t2);
	
	t3=new JTextField();
	t3.setBounds(280,190,150,30);
	spframe.add(t3);
    
	p1 = new JPasswordField();
	p1.setBounds(280,230,150,30);
	spframe.add(p1);
	
	p2 = new JPasswordField();
	p2.setBounds(280,270, 150,30);
	spframe.add(p2);
	
	emaillabel= new JLabel("Select security question");
    emaillabel.setFont(f2);
    //l1.setForeground(Color.white);
    emaillabel.setBackground(Color.white);
    emaillabel.setBounds(80,400,160,30);
    
    spframe.add(emaillabel);
    
    
	//String[] sq={"What is your first pet name ?","What was your childhood nickname?","What is your favourite movie?","In what town was your first job?"};
	cou=new JComboBox();
	cou.addItem("What is your first pet name ?");
	cou.addItem("What was your childhood name?");
	cou.addItem("What is your favourite movie?");
	cou.addItem("In what town was your first job?");
	cou.setBounds(280,400,190,30);
	spframe.add(cou);
	
	

	emaillabel= new JLabel("Answer");
    emaillabel.setFont(f2);
    //l1.setForeground(Color.white);
    //emaillabel.setBackground(Color.white);
    emaillabel.setBounds(80,440,160,30);
    
    spframe.add(emaillabel);
	
    genderlabel=new  JLabel("Gender");
    genderlabel.setFont(f2);
    genderlabel.setBounds(80,480,150,30);
    spframe.add(genderlabel);
    
    gendermaleb=new JRadioButton("Male");
    gendermaleb.setBounds(280,480,70,30);
    gendermaleb.setFont(f2);
    //gendermaleb.setBackground(Color.green);
    
    genfemale=new JRadioButton("Female");
    genfemale.setBounds(350,480,90,30);
    genfemale.setFont(f2);
    //genfemale.setBackground(Color.green);
bg=new ButtonGroup();
bg.add(gendermaleb);
bg.add(genfemale);
spframe.add(gendermaleb);
    spframe.add(genfemale);
    
    t4=new JTextField();
	t4.setBounds(280,440,150,30);
	spframe.add(t4);
	
	t5=new JTextField();
	t5.setBounds(280,310,150,30);
	spframe.add(t5);
	
	t6=new JTextField();
	t6.setBounds(280,350,150,30);
	spframe.add(t6);
	
	s10=new JLabel("Date of Birth");
	s10.setBounds(600,150,100,30);
    s10.setFont(f2);
    spframe.add(s10);
    
    dob=new JDateChooser("dd/MM/yyyy","##/##/####",'_');
    dob.setBounds(700,150,150,30);
    spframe.add(dob);
    
    
    s11 = new JLabel("Address");
    s11.setFont(f2);
    //l1.setForeground(Color.white);
    //s11.setBackground(Color.white);
    s11.setBounds(600,190,100,30);
    spframe.add(s11);
    
    s12 = new JLabel("Pincode");
    s12.setFont(f2);
    //l1.setForeground(Color.white);
    //s12.setBackground(Color.white);
    s12.setBounds(600,230,150,30);
    spframe.add(s12);
    
    s12 = new JLabel("Aadhar card no");
    s12.setFont(f2);
    //l1.setForeground(Color.white);
    //s12.setBackground(Color.white);
    s12.setBounds(600,270,150,30);
    spframe.add(s12);
    
    
    
    
    t7=new JTextField();
	t7.setBounds(700,190,150,30);
	spframe.add(t7);
	
	t8=new JTextField();
	t8.setBounds(700,230,150,30);
	spframe.add(t8);
	
	t9=new JTextField();
	t9.setBounds(700,270,150,30);
	spframe.add(t9);
	
	//t10=new JTextField();
	//t10.setBounds(700,310,150,30);
	//spframe.add(t10);
	
    
	submitbutton= new JButton("Submit");
	submitbutton.setBounds(500,550,100,35);
	submitbutton.addActionListener(this);
	spframe.add(submitbutton);
	
	submitresetbutton= new JButton("Reset");
	submitresetbutton.setBounds(650,550,100,35);
	submitresetbutton.addActionListener(this);
	spframe.add(submitresetbutton);
    
	submitbackbtn= new JButton("Back");
	submitbackbtn.setBounds(800,550,100,35);
	submitbackbtn.addActionListener(this);
	spframe.add(submitbackbtn);
spframe.setVisible(true);	
	
}
public void actionPerformed(ActionEvent a) {
	// TODO Auto-generated method stub
	if(a.getSource()==submitresetbutton)
	{   dob.setDate(null);
         p1.setText(null);
         p2.setText(null);
         t4.setText(null);
		    t5.setText(null);
		    t3.setText(null);
	    t2.setText(null);
	    t6.setText(null);
		    t7.setText(null);
		    t8.setText(null);
	    t9.setText(null);

	    
	}
	if(a.getSource()==submitbackbtn)
	{spframe.dispose();
		CustomerLogin c1=new CustomerLogin();
		c1.login();
	}
	
	if(a.getSource()==submitbutton)
	{
		Customer c=new Customer();
		
		     if(p1.getText().equals(p2.getText()))
		      { 
		    	CustomerImpl ci=new CustomerImpl();
		    	
		      c.setCustomerName(t2.getText());
		      c.setLoginId(t3.getText());
		      
		      c.setPassword(p1.getText());
		     c.setEmailId(t5.getText());
		      c.setPhoneNumber(t6.getText());
		      c.setSecurityQuestion(cou.getSelectedItem().toString());
		     c.setSecurityAnswer(t4.getText());
		      if(genfemale.isSelected()==true)
		      {
		    	  c.setGender("Female");
		      }
		      else if(gendermaleb.isSelected()==true)
		      {
		    	c.setGender("Male");
		      }
		      else
		      {
		    	  JOptionPane.showMessageDialog(null,"Please select your gender..");    
		      }
		      
		      
		      
		      //customersignup.setDate(9, new java.sql.Date(dob.getDate());
		      java.sql.Date dob1= new java.sql.Date(dob.getDate().getTime());
		      c.setDob(dob1);
		      c.setAddress(t7.getText());
		     c.setPinCode(t8.getText());
		      
		      c.setAadharNumber(t9.getText());
		      //customersignup .setString (13,t10.getText());
		      //system.out.println("Before insert");
		      
		     
		      int i=0;
		   
			try {
				 i=	ci.customerSignup(c);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(i==1)
			{
		      JOptionPane.showMessageDialog(null,"Successful.");
		      spframe.dispose();
		      CustomerLogin c1=new CustomerLogin();
		      
			}
		      
		      
		      }
		      else
		      {
		    	  JOptionPane.showMessageDialog(null,"Your passwords do not match please enter again...");
		      }
		     
	}
	
	


	}
	
}
/*public static void main(String a[])
{
	signup s=new signup();
	s.signupp();
}*/

