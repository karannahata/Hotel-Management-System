package Customer;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.toedter.calendar.JDateChooser;

import Admin.WelcomePage;
import Beans.BookingDetail;
import Beans.Customer;
import DAO.CustomerImpl;
import DAO.RoomImpl;

import java.text.DateFormat;
 
import java.sql.*;

public class bookroom implements ActionListener
{   
	JFrame j4frame;
	JLabel logo,heading,checkin,checkout,rt1,rt2,rt3,rt4,rt5,rt,meal;
	JCheckBox rtn1,rtn2,rtn3,rtn4,rtn5;
	Icon l;
	JRadioButton meal1,meal2,meal3,meal4;
	JDateChooser d1,d2;;	JButton btnbook,btnback,btnlogout;
	public JPanel left_panel;
	JPanel right_panel;
	String loginid;
	Connection con;
	ResultSet r;
	PreparedStatement p;
	String custID;
	
	void bkrom(String loginid)
	{
		this.loginid=loginid;
		j4frame = new JFrame();
		j4frame.setLayout(null);
		j4frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j4frame.setTitle("btnbook ");
		j4frame.setResizable(true);
		j4frame.setSize(1366,768);
		//j2.getContentPane().setBackground(Color.green);
	    	
		//i2=new ImageIcon("image1.jpg");
		//b=new JLabel(i2);
		//b.setBounds(0, 0, 1000, 1000);
		//j1.setContentPane(b);
		//j1.add(b);
		
		left_panel =new JPanel();
		left_panel.setBounds(0,0,900,768);
		left_panel.setLayout(null);
		
		right_panel=new JPanel();
		right_panel.setBounds(900,0,566,768);
	    right_panel.setLayout(null);
	   
		
		l = new ImageIcon("log1.png");
		logo=new JLabel(l);
		logo.setBounds(950,20,460,156);
		j4frame.add(logo);
		
		Images I = new Images(this);
		I.start();

		heading = new JLabel("btnbook ROOMS");
		Font f= new Font("Monotype Corsiva",Font.BOLD,50);
		heading.setFont(f);
	    heading.setForeground(Color.WHITE);
		heading.setBounds(390,50,600,50);
		left_panel.add(heading);	
			    
		checkin=new JLabel("Checkin Date");
		Font f2= new Font("Monotype Corsiva",Font.BOLD,15);
		checkin.setBounds(40,190,100,20);
	    checkin.setFont(f2);
	    right_panel.add(checkin);
		
	    /*Calendar now = Calendar.getInstance();
	   yy= now.get(Calendar.YEAR);
	   mm= now.get(Calendar.MONTH) + 1;
	   dd=now.get(Calendar.DATE);
	   */
	    
	    d1=new JDateChooser("dd/MM/yyyy","##/##/####",'_');
	    d1.setMinSelectableDate(new java.util.Date());
	    d1.setBounds(210,190,150,20);
	   right_panel.add(d1);
	   
	   d2=new JDateChooser("dd/MM/yyyy","##/##/####",'_');
	    d2.setMinSelectableDate(new java.util.Date());
	    d2.setBounds(210,240,150,20);
	   right_panel.add(d2);
	   
	   

	    checkout=new JLabel("Checkout Date");
		//Font f2= new Font("Times New Roman",Font.BOLD,15);
		checkout.setBounds(40,240,150,20);
	    checkout.setFont(f2);
	    right_panel.add(checkout);
		
	    rt=new JLabel("Room type : ");
		//Font f2= new Font("Times New Roman",Font.BOLD,15);
		rt.setBounds(40,290,150,20);
	    rt.setFont(f2);
	    right_panel.add(rt);
		
	    rt1=new JLabel("Single Bedroom");
		//Font f2= new Font("Times New Roman",Font.BOLD,15);
		rt1.setBounds(50,340,150,20);
	    rt1.setFont(f2);
	    right_panel.add(rt1);
	  
	    rt2=new JLabel("Double Bedroom");
		//Font f2= new Font("Times New Roman",Font.BOLD,15);
		rt2.setBounds(230,340,130,20);
	    rt2.setFont(f2);
	    right_panel.add(rt2);
	    
	    rt3=new JLabel("Suites");
		//Font f2= new Font("Times New Roman",Font.BOLD,15);
		rt3.setBounds(50,370,150,20);
	    rt3.setFont(f2);
	    right_panel.add(rt3);
	    
	    rt4=new JLabel("Deluxe Suites");
		//Font f2= new Font("Times New Roman",Font.BOLD,15);
		rt4.setBounds(230,370,150,20);
	    rt4.setFont(f2);
	    right_panel.add(rt4);
	    
	    rt5=new JLabel("Penthouse");
		//Font f2= new Font("Times New Roman",Font.BOLD,15);
		rt5.setBounds(50,400,150,20);
	    rt5.setFont(f2);
	    right_panel.add(rt5);
	    
	    meal=new JLabel("Meal type :");
		//Font f2= new Font("Times New Roman",Font.BOLD,15);
		meal.setBounds(40,450,150,20);
	    meal.setFont(f2);
	    right_panel.add(meal);
		
	    meal1=new JRadioButton("Meal");
	    meal1.setBounds(180,450,80,30);
	    meal1.setFont(f2);
	    //gen1.setBackground(Color.green);
	    meal2=new JRadioButton("No meals");
	    meal2.setBounds(270,450,150,30);
	    meal2.setFont(f2);
	    //gen1.setBackground(Color.green);
	    
       ButtonGroup bg=new ButtonGroup();
       bg.add(meal1);
       bg.add(meal2);
	   right_panel.add(meal1);    
	   right_panel.add(meal2); 
	  
	    rtn1=new JCheckBox();
	    rtn1.setBounds(180,340,40,20);
	    right_panel.add(rtn1);

	    
	    rtn2=new JCheckBox();
	    rtn2.setBounds(350,340,40,20);
	    right_panel.add(rtn2);
	    
	    rtn3=new JCheckBox();
	    rtn3.setBounds(180,370,40,20);
	    right_panel.add(rtn3);
	    
	    rtn4=new JCheckBox();
	    rtn4.setBounds(350,370,40,20);
	    right_panel.add(rtn4);
	 
	    rtn5=new JCheckBox();
	    rtn5.setBounds(180,400,40,20);
	    right_panel.add(rtn5);
	    
	    btnbook=new JButton("Check availibility");
	    btnbook.setBounds(100,560,180,40);
        btnbook.addActionListener(this);
        right_panel.add(btnbook) ;

	
	    btnback=new JButton("Back");
        btnback.setBounds(320,560,80,40);
        right_panel.add(btnback) ;
        btnback.addActionListener(this);

         btnlogout=new JButton("Logout");
         btnlogout.setBounds(1200,0,100,20);
         btnlogout.addActionListener(this);
         j4frame.add(btnlogout);
         j4frame.add(right_panel);

          j4frame.add(left_panel);
          j4frame.setVisible(true);
	}
		
	
	
/*	public static void main(String s[])
	{
		bookroom b=new bookroom();
		b.bkrom(loginid);
	}*/
	ResultSet Rs;
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		
		if(a.getSource()==btnback)
		{
			custh c2=new custh();
			try {
				c2.custhome(loginid);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(a.getSource()==btnbook)
		{
			ResultSet Rs1,Rs2,Rs3,Rs4,Rs5;
			RoomImpl R = new RoomImpl();
			java.util.Date checkindate= d1.getDate();
			java.util.Date checkoutdate= d2.getDate();
			int meal;
			//System.out.println(checkindate.toString());
			//mealcheck = meal1.isSelected();
			CustomerImpl X = new CustomerImpl();
			
			if(meal1.isSelected())
				meal = 1;
			else
				meal = 0;
			try
			{
				/*if(rtn1.isSelected())
					Rs1 = R.getAvailableRoomsT1();
				else 
					Rs1 = con.prepareStatement("").executeQuery();
				if(rtn2.isSelected())
					Rs2 = R.getAvailableRoomsT2();			
				else
					Rs2 = con.prepareStatement("").executeQuery();
				if(rtn3.isSelected())
					Rs3 = R.getAvailableRoomsT3();
				else
					Rs3 = con.prepareStatement("").executeQuery();
				if(rtn4.isSelected())
					Rs4 = R.getAvailableRoomsT4();
				else
					Rs4 = con.prepareStatement("").executeQuery();
				if(rtn5.isSelected())
					Rs5 = R.getAvailableRoomsT5();
				else
					Rs5 = con.prepareStatement("").executeQuery();
				*/
				BookingDetail temp = new BookingDetail();
				Customer C;
			
				C = X.fetchCustomer(loginid);
				temp.setCheckIn(d1.getDate()); //1
				temp.setCheckOut(d2.getDate()); //2
				temp.setCustomerId(C.getCustomerId()); //3
				temp.setMeal(meal); //4 
				temp.setCustomerloginId(loginid); //5
				this.j4frame.setVisible(false);
				new ListAvailableRooms(rtn1.isSelected(),rtn2.isSelected(),rtn3.isSelected(),rtn4.isSelected(),rtn5.isSelected(),temp).frame.setVisible(true);;
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*int rt[]=new int[5];
			int flag[]=new int[5];
			
			/*rt[0]=Integer.parseInt(rtn1.getSelectedItem().toString());
			rt[1]=	Integer.parseInt(rtn2.getSelectedItem().toString());	
			rt[2]=Integer.parseInt(rtn3.getSelectedItem().toString());
			rt[3]=Integer.parseInt(rtn4.getSelectedItem().toString());
			rt[4]=Integer.parseInt(rtn5.getSelectedItem().toString());
			
			RoomImpl r=new RoomImpl();
			try {
				flag=r.getavailable(rt);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				if(flag[0]==2||flag[1]==2||flag[3]==2||flag[4]==2||flag[2]==2)
				{
					JOptionPane.showMessageDialog(null,"Whoops!!Looks like we do not have any available rooms...Please change room type or check in dates ");
				}
				
				else
				{
					try {
						Bookavailable b=new Bookavailable(checkindate,checkoutdate,rt,mealcheck,loginid);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			*/				
		}
		if(a.getSource()==btnlogout)
		{
			WelcomePage w=new WelcomePage();
			
		}
		
	}
}


class Images extends Thread{

	JLabel images_label;
	Icon i[];
	bookroom w;
	public Images(bookroom w)
	{
		
		i = new Icon[6];
		i[0] = new ImageIcon("image1.jpg");
	    i[1] = new ImageIcon("image2.jpg");
		i[2] = new ImageIcon("image3.jpg");
		i[3] = new ImageIcon("image4.jpg");
		this.w = w;
		//w.left_panel = new JPanel();
		
		//w.left_panel.setBounds(0,0,900,768);
		//w.left_panel.setLayout(null);
		images_label = new JLabel();
		w.left_panel.add(images_label);
	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int index=0;
		while(true)
		{
			images_label.setIcon(i[index%4]);
			images_label.setBounds(0,0, 900, 768);
			 
			index++;
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
