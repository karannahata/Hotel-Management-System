package Employee;
import java.awt.print.*;
import java.sql.SQLException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javax.print.attribute.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Beans.BookingDetail;
import Beans.Customer;
import DAO.BookingDetailImpl;
import DAO.CustomerImpl;

public class CheckOut implements ActionListener,Printable{
	
	Icon icon;
	JLabel iconLabel,s2,CustName,CustId,roomsLabel,Stayperiod,checkin,checkout,meals,Amount;;
	JTextField customerNameField,customerIdField,stayField,checkInField,checkOutField,mealField;
	JTextArea roomArea,amountArea;
	JFrame frame;
	JButton print;
	
	Customer customer;
	BookingDetail detail;
	//BookingDetail details;
	String bookingId;
	BookingDetailImpl bd;
	public CheckOut(String bookingId) throws ClassNotFoundException, SQLException{
		this.bookingId=bookingId;
		bd = new BookingDetailImpl();
		detail= bd.viewBooking(bookingId) ;
		CustomerImpl ci = new CustomerImpl();
//		detail=details.get(0);
		customer=ci.viewCustomer(detail.getCustomerId());
		ArrayList<Integer> roomNumber = bd.getRooms(bookingId);
		
		String allRooms=null;
		int i=0;
		while(i<roomNumber.size()){
			allRooms+=roomNumber.get(i)+" ";
			i++;
		}
		frame = new JFrame();
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Check Out");
		frame.setResizable(true);
		frame.setSize(1366,768);
		icon = new ImageIcon("log1.png");
	
		iconLabel=new JLabel(icon);
		iconLabel.setBounds(980,10,460,156);
		frame.add(iconLabel);
		
		
		s2 = new JLabel("Check out Details");
		Font f= new Font("Monotype Corsiva",Font.BOLD,40);
		s2.setFont(f);
	    s2.setForeground(Color.DARK_GRAY);
		s2.setBounds(540,50,400,35);
		frame.add(s2);	
		
		CustName = new JLabel("Customer name  :");
		Font f2= new Font("Times New Roman",Font.BOLD,15);
	    CustName.setFont(f2);
	    CustName.setBounds(80,150,150,30);
	    frame.add(CustName);
	    
	    customerNameField=new JTextField();
	    customerNameField.setText(customer.getCustomerName());
	    customerNameField.setBounds(250,150,200,30);
	    customerNameField.setEditable(false);
	    frame.add(customerNameField);
	    
	    CustId = new JLabel("Customer Id :");
	    CustId.setFont(f2);
	    CustId.setBounds(80,190,100,30);
	    frame.add(CustId);
	  
	    customerIdField=new JTextField();
	    customerIdField.setText(customer.getCustomerId());
	    customerIdField.setBounds(250,190,200,30);
	    customerIdField.setEditable(false);
	    frame.add(customerIdField);
	    
				
		roomsLabel= new JLabel("Room details  :");
		roomsLabel.setFont(f2);
	    roomsLabel.setBounds(80,230,100,30);
	    frame.add(roomsLabel);
	    
	    roomArea=new JTextArea();
	    roomArea.setText(allRooms);
	    roomArea.setBounds(250,230,200,60);
	    roomArea.setEditable(false);
	    frame.add(roomArea);
	    
	    Stayperiod = new JLabel("Stay period :");
	    Stayperiod.setFont(f2);
	    Stayperiod.setBounds(80,300,100,30);
	    frame.add(Stayperiod);
	    
	    long stay=ChronoUnit.DAYS.between(detail.getCheckIn().toInstant(), detail.getCheckOut().toInstant());
	    
	    stayField=new JTextField();
	    stayField.setText(Long.toString(stay));
	    stayField.setBounds(250,300,200,30);
	    stayField.setEditable(false);
	    frame.add(stayField);
	    
		checkin = new JLabel("Checkin date :");
		checkin.setFont(f2);
	    checkin.setBounds(80,340,100,30);
	    frame.add(checkin);
	    
	    checkInField=new JTextField();
	    checkInField.setText(detail.getCheckIn().toString());
	    checkInField.setBounds(250,340,200,30);
	    checkInField.setEditable(false);
	    frame.add(checkInField);
	    
	    checkout = new JLabel("Checkout date :");
	    checkout.setFont(f2);
	    checkout.setBounds(80,380,150,30);
	    frame.add(checkout);
	    
	    checkOutField=new JTextField();
	    checkOutField.setText(detail.getCheckOut().toString());
	    checkOutField.setBounds(250,380,200,30);
	    checkOutField.setEditable(false);
	    frame.add(checkOutField);
	    
	    meals = new JLabel("Meal Details :");
	    meals.setFont(f2);
	    meals.setBounds(80,420,100,30);
	    frame.add(meals);
	    
	    mealField=new JTextField();
	    mealField.setText(Integer.toString(detail.getMeal()));
	    mealField.setBounds(250,420,200,30);
	    mealField.setEditable(false);
	    frame.add(mealField);
	    
	    Amount = new JLabel("Amount to be paid :");
	    Amount.setFont(f2);
	    Amount.setBounds(80,460,300,30);
	    frame.add(Amount);
	    
	    amountArea=new JTextArea();
	    amountArea.setText(Integer.toString(bd.getFare(roomNumber)));
	    amountArea.setBounds(250,460,200,150);
	    amountArea.setEditable(false);
	    frame.add(amountArea);
	    
	    print=new JButton("Print");
	    print.setBounds(550,530,80,30);
	   
	    frame.add(print);
	    print.addActionListener(this);
	    
	    frame.setVisible(true);
	 }
	

	public void actionPerformed(ActionEvent a) {
	// TODO Auto-generated method stub
		if(a.getSource()==print)
		{
				PrinterJob job = PrinterJob.getPrinterJob();
		        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
		        PageFormat pf = job.pageDialog(aset);
		        try {
					job.setPrintable(new CheckOut(bookingId), pf);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        boolean ok = job.printDialog(aset);
		        if (ok) {
		            try {
		                 job.print(aset);
		            } catch (PrinterException ex) {
		             /* The job did not successfully complete */
		            }
		        }
		    try {
				bd.deleteBooking(bookingId);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
		}
	}
	

	public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
		// TODO Auto-generated method stub
		if (page > 0) { /* We have only one page, and 'page' is zero-based */
	    return NO_SUCH_PAGE;
	
		}
	
		return PAGE_EXISTS;
	}
}
