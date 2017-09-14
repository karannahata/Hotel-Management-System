package Employee;

 import java.awt.*;
//import org.jdesktop.swingx.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.chrono.JapaneseDate;

import javax.swing.plaf.IconUIResource;

import net.sourceforge.jdatepicker.JDatePanel;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;
import javax.swing.*;

public class BookingDetails implements ActionListener {
	String loginId;
	JButton jb,jb1;
	Icon img;
	BorderLayout bl;
	JLabel jl,jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10;
	JComboBox tb;
	ButtonGroup bg,bg1;
	JPanel jp;
	JRadioButton jc,jc1;
	JTextField tf,tf1;
	//JCalender jd;
	JFrame jf;
	
	
	BookingDetails(String loginId)
	{
		this.loginId=loginId;
		jf= new JFrame("Management");
		jf.setBounds(0,0,1366,768);
		jf.setLayout(null);
		jf.setForeground(Color.WHITE);
		jf.setResizable(false);

		jp=new JPanel(null);
		jp.setBackground(Color.WHITE);
		//jp.setBorder(BorderFactory.createLineBorder(Color.blue,5));
		jp.setBounds(0,200,1360,300);
		
		UtilDateModel model=new UtilDateModel();
		JDatePanelImpl datePanelImpl=new JDatePanelImpl(model);
		JDatePickerImpl datePickerImpl=new JDatePickerImpl(datePanelImpl);
		datePickerImpl.setBounds(330,80,180,26);
		jp.add(datePickerImpl);
		
		UtilDateModel model1=new UtilDateModel();
		JDatePanelImpl datePanelImpl1=new JDatePanelImpl(model1);
		JDatePickerImpl datePickerImpl1=new JDatePickerImpl(datePanelImpl1);
		datePickerImpl1.setBounds(330,190,180,26);
		jp.add(datePickerImpl1);
		
		
		img=new ImageIcon("hotel.jpg");
		jl6=new JLabel(img); 
		jf.setContentPane(jl6);
	
		bg1 =new ButtonGroup();
		jc=new JRadioButton("Meal");
	 	jc.setBounds(1100,110,170,50);
	 	jc.setBackground(Color.WHITE);
		jc.setFont(new Font("Courier",Font.ITALIC,19));
		bg1.add(jc);
		jp.add(jc);
		
	 	jc1=new JRadioButton("Without Meal");
		jc1.setFont(new Font("Courier",Font.ITALIC,19));
	 	jc1.setBounds(1100,145,170,50);
	 	jc1.setBackground(Color.WHITE);
	 	bg1.add(jc1);
	 	jp.add(jc1);
 	
	 	jb= new JButton("Search");
	 	jb.setBounds(1100,420,120,30);
		jb.setFont(new Font("Courier",Font.CENTER_BASELINE,19));
		jf.add(jb);
		jb.addActionListener(this);
		
	 	/*jb1= new JButton("Support");
	 	jb1.setBounds(1000,15,120,30);
		jb1.setFont(new Font("Courier",Font.CENTER_BASELINE,19));
		jf.add(jb1);
		jb1.addActionListener(this);
		
	 	jb2= new JButton("Logout");
	 	jb2.setBounds(1120,15,100,30);
		jb2.setFont(new Font("Courier",Font.CENTER_BASELINE,19));
		jf.add(jb2);
		jb2.addActionListener(this);*/
		
	 	jb1= new JButton("Back");
	 	jb1.setBounds(20, 20, 100, 30);
		jb1.setFont(new Font("Courier",Font.CENTER_BASELINE,19));
		jf.add(jb1);
		jb1.addActionListener(this);
		
		jl=new JLabel("Check-In Date");
		jl.setBounds(30,80,300,30);
		jl.setFont(new Font("Calibri",Font.ITALIC,40));
		jp.add(jl);

		jl3=new JLabel("Check-Out Date");
		jl3.setBounds(30,190,300,30);
		jl3.setFont(new Font("Calibri",Font.ITALIC,40));
		jp.add(jl3);

		jl8=new JLabel("Food:");
		jl8.setBounds(1100,80,100,30);
		jl8.setFont(new Font("Calibri",Font.ITALIC,40));
		jp.add(jl8);
		
		jl9=new JLabel("Guests:");
		jl9.setBounds(700,80,300,30);
		jl9.setFont(new Font("Calibri",Font.ITALIC,40));
		jp.add(jl9);
		
		tb=new JComboBox();
		tb.addItem("1");
		tb.addItem("2");
		tb.addItem("3");
		tb.addItem("4");
		tb.setBounds(850,80,70,30);
		tb.setFont(new Font("Courier",Font.ITALIC,19));
		jp.add(tb);		
		
		jf.add(jp);
		jf.setVisible(true);
	}
	
	
	public static void main(String... S)
	{
		BookingDetails g= new BookingDetails("abc");
		
	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/*public void actionPerformed(ActionEvent e) {
		if(e.getSource()== jb){
			ViewRooms Vr = new ViewRooms(null, loginId);
		}	
		if(e.getSource()== jb1){
			AddCustomer ci = new AddCustomer(loginId);
		}
		
		jf.dispose();
	}*/

}