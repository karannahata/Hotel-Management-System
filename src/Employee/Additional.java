package Employee;


	import java.awt.Color;
	import java.awt.Font;
	import javax.swing.*;
	import java.awt.event.*;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.*;
	import com.toedter.calendar.JDateChooser;


	public class Additional implements ActionListener
	{   
		int dd,mm,yy;
		JFrame frame;
		JLabel logo,c,checkInLabel,checkOutLabel,singleRoomLabel,doubleRoomLabel,suitesLabel,deluxeSuitesLabel,pentHouseLabel,roomTypeLabel,meal;
		JComboBox rtn1,rtn2,rtn3,rtn4,rtn5;
		Icon l;
		JRadioButton meal1,meal2,meal3,meal4;
		JDateChooser d1,d2;
		JButton book,back;
		public JPanel left_panel;
		JPanel right_panel;
		String loginid;
		
		public Additional (){
			frame = new JFrame();
			frame.setLayout(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("Book ");
			frame.setResizable(true);
			frame.setSize(1366,768);
			
			left_panel =new JPanel();
			left_panel.setBounds(0,0,900,768);
			left_panel.setLayout(null);
			
			right_panel=new JPanel();
			right_panel.setBounds(900,0,566,768);
		    right_panel.setLayout(null);
		   
			
			l = new ImageIcon("log1.png");
			logo=new JLabel(l);
			logo.setBounds(950,20,460,156);
			frame.add(logo);

			c = new JLabel("BOOK ROOMS");
			Font f= new Font("Monotype Corsiva",Font.BOLD,50);
			c.setFont(f);
		    c.setForeground(Color.WHITE);
			c.setBounds(390,50,600,50);
			left_panel.add(c);	
			
			checkInLabel=new JLabel("checkInLabel Date");
			Font f2= new Font("Monotype Corsiva",Font.BOLD,15);
			checkInLabel.setBounds(40,190,100,20);
		    checkInLabel.setFont(f2);
		    right_panel.add(checkInLabel);
			
		    d1=new JDateChooser("dd/MM/yyyy","##/##/####",'_');
		    d1.setMinSelectableDate(new Date());
		    d1.setBounds(210,190,150,20);
		    right_panel.add(d1);
		   
		    d2=new JDateChooser("dd/MM/yyyy","##/##/####",'_');
		    d2.setMinSelectableDate(new Date());
		    d2.setBounds(210,240,150,20);
		    right_panel.add(d2);
		   
		    checkOutLabel=new JLabel("checkOutLabel Date");
			checkOutLabel.setBounds(40,240,150,20);
		    checkOutLabel.setFont(f2);
		    right_panel.add(checkOutLabel);
			
		    roomTypeLabel=new JLabel("Room type : ");
			roomTypeLabel.setBounds(40,290,150,20);
		    roomTypeLabel.setFont(f2);
		    right_panel.add(roomTypeLabel);
			
		    singleRoomLabel=new JLabel("Single Bedroom");
			singleRoomLabel.setBounds(50,340,150,20);
		    singleRoomLabel.setFont(f2);
		    right_panel.add(singleRoomLabel);
		  
		    doubleRoomLabel=new JLabel("Double Bedroom");
			doubleRoomLabel.setBounds(230,340,130,20);
		    doubleRoomLabel.setFont(f2);
		    right_panel.add(doubleRoomLabel);
		    
		    suitesLabel=new JLabel("Suites");
			suitesLabel.setBounds(50,370,150,20);
		    suitesLabel.setFont(f2);
		    right_panel.add(suitesLabel);
		    
		    deluxeSuitesLabel=new JLabel("Deluxe Suites");
			deluxeSuitesLabel.setBounds(230,370,150,20);
		    deluxeSuitesLabel.setFont(f2);
		    right_panel.add(deluxeSuitesLabel);
		    
		    pentHouseLabel=new JLabel("Penthouse");
			pentHouseLabel.setBounds(50,400,150,20);
		    pentHouseLabel.setFont(f2);
		    right_panel.add(pentHouseLabel);
		    
		    meal=new JLabel("Meal type :");
			meal.setBounds(40,450,150,20);
		    meal.setFont(f2);
		    right_panel.add(meal);
			
		    meal1=new JRadioButton("Meal");
		    meal1.setBounds(180,450,80,30);
		    meal1.setFont(f2);
		    meal2=new JRadioButton("No meals");
		    meal2.setBounds(270,450,150,30);
		    meal2.setFont(f2);
		    
		    ButtonGroup bg=new ButtonGroup();
		    bg.add(meal1);
		    bg.add(meal2);
		    right_panel.add(meal1);    
		    right_panel.add(meal2); 
		  
		    rtn1=new JComboBox();
		    for(int i=0;i<11;i++) {
		    	rtn1.addItem(i);
		    }
		    rtn1.setBounds(180,340,40,20);
		    right_panel.add(rtn1);

		    
		    rtn2=new JComboBox();
		    for(int i=0;i<11;i++) {
		    	rtn2.addItem(i);
		     }
		    rtn2.setBounds(350,340,40,20);
		    right_panel.add(rtn2);
		    
		    rtn3=new JComboBox();
		    for(int i=0;i<11;i++) {
		    	rtn3.addItem(i);
		    }
		     rtn3.setBounds(180,370,40,20);
		    right_panel.add(rtn3);
		    
		    rtn4=new JComboBox();
		    for(int i=0;i<6;i++){
		    	rtn4.addItem(i);
		    }
		    rtn4.setBounds(350,370,40,20);
		    right_panel.add(rtn4);
		 
		    rtn5=new JComboBox();
		    for(int i=0;i<2;i++) {
		    	rtn5.addItem(i);
		    }
		    rtn5.setBounds(180,400,40,20);
		    right_panel.add(rtn5);
		    
		    book=new JButton("Check availibility");
		    book.setBounds(100,560,180,40);
	        book.addActionListener(this);
	        right_panel.add(book) ;

		
		    back=new JButton("Back");
	        back.setBounds(320,560,80,40);
	        right_panel.add(back) ;
	        back.addActionListener(this);
	        
	        frame.add(right_panel);

	        frame.add(left_panel);
	        frame.setVisible(true);
		}
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==book){
				
			}
			
		}
			
}
