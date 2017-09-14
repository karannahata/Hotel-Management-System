package Customer;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

import Admin.WelcomePage;
import DAO.CustomerImpl;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class custh implements ActionListener
{
   Icon l,i1,i2,i3,i4,background;
   JFrame j2frame;
   JLabel logo,h,backgroundlabel;
   JButton btnlogout,myaccountlabel,viewbookingsbtn,bookroomsbutton,feedbackbtn;
   String loginid;
   Connection c;
   ResultSet rs;
   PreparedStatement ps;
   String str;

   void custhome(String loginid) throws ClassNotFoundException, SQLException
  { 
	this.loginid=loginid;
	j2frame = new JFrame();
	j2frame.setLayout(null);
	j2frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	j2frame.setTitle("Customer Login");
	j2frame.setResizable(true);
//	j2frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	j2frame.setSize(1366,768);
	CustomerImpl c = new CustomerImpl();
	
str=c.namefetch(loginid);	

	//j2frame.getContentPane().setBackground(Color.green);
	
	//i2=new ImageIcon("image1.jpg");
	//b=new JLabel(i2);
	//b.setBounds(0, 0, 1000, 1000);
	//j1.setContentPane(b);
	//j1.add(b);
	//System.out.println(loginid);
	
	
	l = new ImageIcon("log1.png");
	logo=new JLabel(l);
	logo.setBounds(980,20,460,156);
	j2frame.add(logo);
	
	background=new ImageIcon("b2.jpg");
	backgroundlabel=new JLabel(background);
	backgroundlabel.setBounds(0,0,1400,800);
	
	
	h = new JLabel("Welcome  "+str);
	Font f= new Font("Amandella Script",Font.BOLD,100);
	h.setFont(f);
    h.setForeground(Color.WHITE);
	h.setBounds(140,50,900,100);
	j2frame.add(h);	
	    
	btnlogout=new JButton("Log out");
	btnlogout.setBounds(1250,5,80,15);
	btnlogout.setBackground(Color.WHITE);
	btnlogout.addActionListener(this);
	j2frame.add(btnlogout);
	
	i1=new ImageIcon("1.png");
	i2=new ImageIcon("2.png");
	i3=new ImageIcon("3.png");
	i4=new ImageIcon("4.png");
	
	
	myaccountlabel=new JButton("My account");
	myaccountlabel.setBounds(700,200,220,50);
	myaccountlabel.setIcon(i1);
	myaccountlabel.setBackground(Color.WHITE);

	myaccountlabel.addActionListener(this);
	
	j2frame.add(myaccountlabel);
	
	viewbookingsbtn=new JButton("View bookings");
	viewbookingsbtn.setBounds(700,300,220,50);
	viewbookingsbtn.setIcon(i2);
	viewbookingsbtn.addActionListener(this);
	viewbookingsbtn.setBackground(Color.WHITE);
	j2frame.add(viewbookingsbtn);
	
	bookroomsbutton=new JButton("Book rooms");
	bookroomsbutton.setBounds(700,400,220,50);
	bookroomsbutton.setIcon(i3);
	bookroomsbutton.setBackground(Color.white);
	bookroomsbutton.addActionListener(this);
	j2frame.add(bookroomsbutton);
	
	feedbackbtn=new JButton("Feedback");
	feedbackbtn.setBounds(700,500,220,50);
	feedbackbtn.setIcon(i4);
	feedbackbtn.addActionListener(this);
	feedbackbtn.setBackground(Color.WHITE);
	j2frame.add(feedbackbtn);
	
	j2frame.add(backgroundlabel);
	j2frame.setVisible(true);

	
	
}
/*public static void main(String[] a)
{custh c=new custh();
c.custhome();


}*/
public void actionPerformed(ActionEvent a) {
	// TODO Auto-generated method stub
	if(a.getSource()==feedbackbtn)
	{
		j2frame.dispose();
		Feed f1=new Feed();
		f1.Feedback(loginid);
	}
	
	if(a.getSource()==myaccountlabel)
	{
		j2frame.dispose();
		customeraccount acc=new customeraccount();
	    
				try {
					acc.customeracc(loginid);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		
	
	
	if(a.getSource()==viewbookingsbtn)
	{
		j2frame.dispose();
		viewbooking v=new viewbooking(loginid);
		
	}
	
	if(a.getSource()==bookroomsbutton)
	{
		j2frame.dispose();
		bookroom b1=new bookroom();
		b1.bkrom(loginid);
	}
	
	if(a.getSource()==btnlogout)
	{  
		j2frame.dispose();
		WelcomePage w=new WelcomePage();
	}


}//actioneventmethod

}//class end


