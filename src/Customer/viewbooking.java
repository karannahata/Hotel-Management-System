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

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import Beans.BookingDetail;
import DAO.BookingDetailImpl;
import Employee.BookingDetails;

public class viewbooking implements ActionListener {

	String bookingid;
	Connection con;
	JFrame frame;
	JTable Result;
	JButton backButton;
	JLabel logo_label;
	Icon logo_image;
	DefaultTableModel model;
	String loginid;
	JLabel h;
	
	
	public viewbooking(String loginid)
	{
		
		
		this.loginid=loginid;
		frame = new JFrame();
		backButton = new JButton("Back");
		int i=0;
		
		model = new DefaultTableModel(){
			
			private static final long serialVersionUID = 1L;
			String column[] = {"BookingId","Room Number","CheckinDate","CheckoutDate","Payment"};
			
			@Override
			public int getColumnCount() {
				return 5;
			}
			@Override
			public boolean isCellEditable(int arg0, int arg1) {
					return false;
			}
			
			@Override
			public void addColumn(Object arg0) {
				super.addColumn(arg0);
			}
			@Override
			public void addRow(Object[] arg0) {
				// TODO Auto-generated method stub
				super.addRow(arg0);
			}
			
		};
		
		//Result = new JTable(model);
		createFrame();
		
	}
	
	
	public void createFrame()
	{
		frame.setSize(1366, 768);
		frame.setLayout(null);
		logo_image = new ImageIcon("Capture5 - copy.PNG");
		logo_label = new JLabel(logo_image);
		logo_label.setBounds(1000, 50, 366, 156);
		frame.add(logo_label);
		

		h = new JLabel("Booked History");
		Font f= new Font("Amandella Script",Font.BOLD,100);
		h.setFont(f);
	    h.setForeground(Color.WHITE);
		h.setBounds(140,50,900,100);
		frame.add(h);	
		
		model.addColumn("Booking id");
		model.addColumn("Room number");
		model.addColumn("Checkin Date");
		model.addColumn("CheckOut Date");
		model.addColumn("Payment");
		
		
		
		backButton.setBounds(10, 10, 100, 35);
		backButton.addActionListener(this);
		fillTable();
		
	
		Result = new JTable(model);	
		
		//Result.setBounds(100,256,1200,450);
		//frame.add(Result);
		frame.add(backButton);
		
		TableColumn 
		tc = Result.getColumnModel().getColumn(0);
		tc.setHeaderValue("Booking ID");
		tc = Result.getColumnModel().getColumn(1);
		tc.setHeaderValue("Room Number ");
		tc = Result.getColumnModel().getColumn(2);
		tc.setHeaderValue("Checkin Date ");
		tc = Result.getColumnModel().getColumn(3);
		tc.setHeaderValue("Checkout Date ");
		tc = Result.getColumnModel().getColumn(4);
		tc.setHeaderValue("Amount ");
		
		JScrollPane P = new JScrollPane(Result);
		P.setBounds(100,256,1200,450);
		frame.add(P);
				
		Result.getColumnModel().getColumn(0).setPreferredWidth(70);
		Result.getColumnModel().getColumn(1).setPreferredWidth(70);
		Result.getColumnModel().getColumn(2).setPreferredWidth(70);
		Result.getColumnModel().getColumn(3).setPreferredWidth(70);
		Result.getColumnModel().getColumn(4).setPreferredWidth(70);
		Result.repaint();
		
		frame.getContentPane().setBackground(Color.decode("#1A242A"));
		frame.setVisible(true);
	}
	
	
	public void fillTable()
	{BookingDetailImpl bi=new BookingDetailImpl();
	
		BookingDetail b=new BookingDetail();
		try {
			b=bi.viewBooking(loginid);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			//Result.getColumnName(1);
			Object[] a = new Object[5];
			
			
			
				a[0] = b.getBookingId();
				a[1] = b.getRoomNumber();
				a[2] = b.getCheckIn();
				a[3] = b.getCheckOut();
				a[4]=b.getPayment();
				model.addRow(a);
			
			
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == backButton)
		{
			this.frame.setVisible(false);
			custh h=new custh();
			try {
				h.custhome(loginid);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}	