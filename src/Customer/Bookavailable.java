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
import java.util.ArrayList;
import java.util.Date;
import java.awt.print.*;
import javax.print.attribute.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Admin.WelcomePage;
import Beans.BookingDetail;
import DAO.BookingDetailImpl;
import DAO.CustomerImpl;
import DAO.RoomImpl;

public class Bookavailable implements ActionListener,Printable
{
    JFrame frame;
    JButton cancel,book,logout,print;
    PreparedStatement p;
    ResultSet rs;
	int flag[]=new int[5],cost[]=new int[5];
	int roomsOfEachType[];
	boolean roomtyperequired[];
	Date checkindate,checkoutdate;
	int mealcheck;
	String loginid,bookingid;
	Icon is;
	JLabel logo,s2,customernamelabel,loginidlabel,checkinlabel,checkoutlabel,dashlabel1,rt,rt1,rt2,rt3,rt4,rt5,meallabel,paymentdetailslabel,dashlabel,totalamountlabel;
	Connection c;
    JTextField cname,cid,checkind,checkoutd,mf,totalamount;	
	JTextField[] rtf=new JTextField[5];
	ResultSet r[]=new ResultSet[5];
	
	

	public Bookavailable(BookingDetail B,boolean R[]) throws Exception
    {
 	this.checkindate=B.getCheckIn(); // checkindate;
 	//System.out.println(checkindate.toString());
 	this.checkoutdate=B.getCheckOut();
 	this.loginid=B.getCustomerloginId();
 	this.mealcheck=B.getMeal();
 	roomsOfEachType = new int[5];
 	for(int i=0;i<5;i++)
    	roomtyperequired[i] = R[i];
 	
	frame=new JFrame();
	frame.setLayout(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("Book Rooms");
	frame.setResizable(true);
	frame.setSize(1366,768);
	frame.getContentPane().setBackground(Color.WHITE);
	

	//sp.getContentPane().setBackground(Color.green);
	is = new ImageIcon("log1.png");
	logo=new JLabel(is);
	logo.setBounds(970,10,460,156);
	frame.add(logo);
	//sp.setVisible(true);
	
	s2 = new JLabel("Whooaa!! Rooms are Available...");
	Font f= new Font("Monotype Corsiva",Font.BOLD,40);
	s2.setFont(f);
    s2.setForeground(Color.BLUE);
	s2.setBounds(340,50,630,35);
	frame.add(s2);		
 	
	customernamelabel = new JLabel("Name");
	Font f2= new Font("Times New Roman",Font.BOLD,15);
    customernamelabel.setFont(f2);
    //l1.setForeground(Color.white);
    //s3.setBackground(Color.white);
    customernamelabel.setBounds(80,150,100,30);
    
    cname=new JTextField();
	cname.setBounds(250,150,150,30);
	cname.setEditable(false);
	frame.add(cname);
	
	CustomerImpl c = new CustomerImpl();
	
	cname.setText(c.namefetch(loginid));	
	
    frame.add(customernamelabel);
    
    loginidlabel = new JLabel("Loginid");
    loginidlabel.setFont(f2);
    //l1.setForeground(Color.white);
    loginidlabel.setBackground(Color.white);
    loginidlabel.setBounds(80,190,100,30);
    frame.add(loginidlabel);
    
    cid=new JTextField();
	cid.setBounds(250,190,150,30);
	cid.setEditable(false);
	frame.add(cid);
	cid.setText(loginid);
	
    checkinlabel = new JLabel("Checkin Date");
	//Font f2= new Font("Times New Roman",Font.BOLD,15);
    checkinlabel.setFont(f2);
    //l1.setForeground(Color.white);
    //s3.setBackground(Color.white);
    checkinlabel.setBounds(80,230,100,30);
    frame.add(checkinlabel);
    
    checkind=new JTextField();
	checkind.setBounds(250,230,150,30);
	checkind.setEditable(false);
	frame.add(checkind);
    checkind.setText(checkindate.toString());
	
	checkoutlabel = new JLabel("Checkout Date");
    checkoutlabel.setFont(f2);
    //l1.setForeground(Color.white);
    checkoutlabel.setBackground(Color.white);
    checkoutlabel.setBounds(80,270,100,30);
    frame.add(checkoutlabel);
    
    
    checkoutd=new JTextField();
	checkoutd.setBounds(250,270,150,30);
	checkoutd.setEditable(false);
	frame.add(checkoutd);
	//java.sql.Date dob1= new java.sql.Date(checkoutdate.getDate());
	checkoutd.setText(checkoutdate.toString());
	
    paymentdetailslabel = new JLabel("Payment Details  : ________________________________________________");
    paymentdetailslabel.setFont(f2);
    //l1.setForeground(Color.white);
    //paymentdetailslabel.setBackground(Color.white);
    paymentdetailslabel.setBounds(80,310,600,30);
    frame.add(paymentdetailslabel);
    
    
    
    rt=new JLabel("Room type : ");
	//Font f2= new Font("Times New Roman",Font.BOLD,15);
	rt.setBounds(80,350,150,30);
    rt.setFont(f2);
    frame.add(rt);
	
    rt1=new JLabel("Single Bedroom");
	//Font f2= new Font("Times New Roman",Font.BOLD,15);
	rt1.setBounds(100,380,150,20);
    rt1.setFont(f2);
    frame.add(rt1);
    
    rtf[0]=new JTextField();
	rtf[0].setBounds(250,380,150,20);
	rtf[0].setEditable(false);
	frame.add(rtf[0]);
    
    rt2=new JLabel("Double Bedroom");
	//Font f2= new Font("Times New Roman",Font.BOLD,15);
	rt2.setBounds(100,410,150,20);
    rt2.setFont(f2);
    frame.add(rt2);
    
    rtf[1]=new JTextField();
	rtf[1].setBounds(250,410,150,20);
	rtf[1].setEditable(false);
	frame.add(rtf[1]);
    
    rt3=new JLabel("Suites");
	//Font f2= new Font("Times New Roman",Font.BOLD,15);
	rt3.setBounds(100,440,150,20);
    rt3.setFont(f2);
    frame.add(rt3);
    
    rtf[2]=new JTextField();
	rtf[2].setBounds(250,440,150,20);
	rtf[2].setEditable(false);
	frame.add(rtf[2]);
    
    rt4=new JLabel("Deluxe Suites");
	//Font f2= new Font("Times New Roman",Font.BOLD,15);
	rt4.setBounds(100,470,150,20);
    rt4.setFont(f2);
    frame.add(rt4);
    
    rtf[3]=new JTextField();
	rtf[3].setBounds(250,470,150,20);
	rtf[3].setEditable(false);
	frame.add(rtf[3]);
    
    RoomImpl r=new RoomImpl();
    
    rt5=new JLabel("Penthouse");
	//Font f2= new Font("Times New Roman",Font.BOLD,15);
	rt5.setBounds(100,500,150,20);
    rt5.setFont(f2);
    frame.add(rt5);

    rtf[4]=new JTextField();
	rtf[4].setBounds(250,500,150,20);
	rtf[4].setEditable(false);
	frame.add(rtf[4]);
	int Amount=0;
    int[] costroom=new int[5];
    costroom=r.fetchcost();
    
    ArrayList<Integer> BookedRooms = new BookingDetailImpl().getRooms(B.getBookingId());
	for(Integer j : BookedRooms)
	{
		int local = j;
		int index = local/100;
		roomsOfEachType[index]++;
	}
	
	for(int i=0;i<5;i++)
	{
		if(!roomtyperequired[i])	
		{
		try
		{
			int cost=costroom[i] * roomsOfEachType[i]; //
			rtf[i].setText(costroom[i] +" * "+roomtyperequired[i]+"  =    Rs"+cost);
			Amount=Amount+cost;
	    }
	
		catch(Exception e)
	    {
		System.out.println(e);
    	}
	}
		else{
			rtf[i].setText(null);
		}
	}
    meallabel=new JLabel("Meal type :");
	//Font f2= new Font("Times New Roman",Font.BOLD,15);
	meallabel.setBounds(80,540,150,20);
    meallabel.setFont(f2);
    frame.add(meallabel);
    
    mf=new JTextField();
	mf.setBounds(250,540,150,20);
	mf.setEditable(false);
	frame.add(mf);
    if(mealcheck==1){
    	mf.setText("Included");
    }
    else
    {
    	mf.setText("Not Included");
    }
	 dashlabel=new JLabel("------------------------------------------------------------------------------------------------------");
		//Font f2= new Font("Times New Roman",Font.BOLD,15);
		dashlabel.setBounds(80,570,610,10);
	    dashlabel.setFont(f2);
	    frame.add(dashlabel);
	      
	    totalamountlabel=new JLabel("Total estimated amount :");
		//Font f2= new Font("Times New Roman",Font.BOLD,15);
		totalamountlabel.setBounds(80,580,610,20);
	    totalamountlabel.setFont(f2);
	    frame.add(totalamountlabel);
     
	    totalamount=new JTextField();
		totalamount.setBounds(250,580,150,20);
		totalamount.setEditable(false);
		frame.add(totalamount);
		totalamount.setText("Rs "+Integer.toString(Amount));
		
		dashlabel1=new JLabel("------------------------------------------------------------------------------------------------------");
		//Font f2= new Font("Times New Roman",Font.BOLD,15);
		dashlabel1.setBounds(80,610,610,20);
	    dashlabel1.setFont(f2);
	    frame.add(dashlabel1);
	    
	    logout=new JButton("Logout");
	    logout.setBounds(1200,0,100,20);
	    logout.addActionListener(this);
	    frame.add(logout);
	    
	    cancel=new JButton("Cancel");
	    cancel.setBounds(850,630,100,40);
	    cancel.addActionListener(this);
	    frame.add(cancel);
	    
	    book=new JButton("Book");
	    book.setBounds(1000,630,100,40);
	   book.addActionListener(this);
	    frame.add(book);
	    
	    print=new JButton("Print");
	    print.setBounds(1200,630,100,40);
	   print.addActionListener(this);
	    frame.add(print);
	    print.setVisible(false);
	    
	    
	    
 	frame.setVisible(true);
 	
 	
 	
    }
	
	
	public void actionPerformed(ActionEvent a) {
	
		// TODO Auto-generated method stub
		if(a.getSource()==logout)
		{
			WelcomePage w=new WelcomePage();
			
		}
		
		if(a.getSource()==book)
		{  
			
			roomsreturn rr=new roomsreturn();
		 try {
			r=rr.BookedRooms(roomsOfEachType);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		 
			book.setEnabled(false);
			print.setVisible(true);
			
			
		
			
		}
		
		if(a.getSource()==cancel)
		{
			bookroom b=new bookroom();
			b.bkrom(loginid);
					
		}
		
		if(a.getSource()==print)
		{
			 PrinterJob job = PrinterJob.getPrinterJob();
		        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
		        PageFormat pf = job.pageDialog(aset);
		        job.setPrintable(new CheckOut(), pf);
		        boolean ok = job.printDialog(aset);
		        if (ok) {
		            try {
		                 job.print(aset);
		            } catch (PrinterException ex) {
		             /* The job did not successfully complete */
		            }
		        }
		}
	  
	 


}
	@Override
	public int print(Graphics arg0, PageFormat arg1, int arg2) throws PrinterException {
		int page = 0;
		// TODO Auto-generated method stub
		if (page > 0) { /* We have only one page, and 'page' is zero-based */
	    return NO_SUCH_PAGE;

		}
	/* User (0,0) is typically outside the imageable area, so we must
	 * translate by the X and Y values in the PageFormat to avoid clipping
	 */
	/*Graphics2D g2d = (Graphics2D)g;
	g2d.translate(pf.getImageableX(), pf.getImageableY());

	/* Now we perform our rendering */
	/*g.drawString("Test the print dialog!", 100, 100);
	*/
	/* tell the caller that this page is part of the printed document */
	return PAGE_EXISTS;
		
	}}
