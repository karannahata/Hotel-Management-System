package Admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

class FirstFloor
{
	JButton singleBedroomButtons[];
	JButton doubleBedroomButtons[];
	JLabel singleRooms;
	JLabel doubleRooms;
	JLabel floor;
	public FirstFloor()
	{
		floor = new JLabel("Floor I");
		floor.setForeground(Color.white);
		singleBedroomButtons = new JButton[10];
		doubleBedroomButtons = new JButton[10];
		singleRooms = new JLabel("Single Bedrooms");
		singleRooms.setForeground(Color.white);
		doubleRooms = new JLabel("Double Bedrooms");
		doubleRooms.setForeground(Color.white);
		init();
	}
	public void init()
	{
		for(int i=0; i<10; i++)
		{
			singleBedroomButtons[i] = new JButton("Room "+(int)(i+101));
			doubleBedroomButtons[i] = new JButton("Room "+(int)(i+111));
			//singleBedroomButtons[i].setForeground(Color.white);
			//doubleBedroomButtons[i].setForeground(Color.white);
		}
	}
	
}

class SecondFloor
{
	JButton singleBedroomButtons[];
	JButton doubleBedroomButtons[];
	JLabel singleRooms;
	JLabel doubleRooms;
	JLabel floor;
	public SecondFloor()
	{
		floor = new JLabel("Floor II");
		floor.setForeground(Color.white);
		singleBedroomButtons = new JButton[10];
		doubleBedroomButtons = new JButton[10];
		singleRooms = new JLabel("Single Bedrooms ");
		singleRooms.setForeground(Color.white);
		doubleRooms = new JLabel("Double Bedrooms ");
		doubleRooms.setForeground(Color.white);
		init();
	}
	public void init()
	{
		for(int i=0; i<10; i++)
		{
			singleBedroomButtons[i] = new JButton("Room "+(int)(i+201));
			doubleBedroomButtons[i] = new JButton("Room "+(int)(i+211));
			//singleBedroomButtons[i].setForeground(Color.white);
			//doubleBedroomButtons[i].setForeground(Color.white);
		}
	}
}

class ThirdFloor
{
	JButton suiteButtons[];
	JLabel  suites;
	JLabel floor;
	public ThirdFloor()
	{
		floor = new JLabel("Floor III");
		floor.setForeground(Color.white);
		suiteButtons = new JButton[10];
		suites = new JLabel("Suites");
		suites.setForeground(Color.white);
		init();
	}
	public void init()
	{
		for(int i=0; i<10; i++)
		{
			suiteButtons[i] = new JButton("Room "+(int)(i+301));
			//suiteButtons[i].setForeground(Color.white);
		}
	}
}

class FourthFloor
{
	JButton deluxSuiteButtons[];
	JLabel deluxSuites;
	JLabel floor;
	public FourthFloor()
	{
		floor = new JLabel("Floor IV");
		floor.setForeground(Color.white);
		
		deluxSuites = new JLabel("Delux Suites");
		deluxSuites.setForeground(Color.white);
		deluxSuiteButtons = new JButton[10];
		init();
	}
	public void init()
	{
		for(int i=0; i<10; i++)
		{
			deluxSuiteButtons[i] = new JButton("Room "+(int)(i+401));
			//deluxSuiteButtons[i].setForeground(Color.white);
		}
	}
}

class FifthFloor
{

	JButton penthouseSuiteButtons[];
	JLabel penthouseSuites;
	JLabel floor;
	public FifthFloor()
	{
		floor = new JLabel("Floor V");
		floor.setForeground(Color.white);
		penthouseSuites = new JLabel("Penthouse Suite");
		penthouseSuites.setForeground(Color.white);
		
		penthouseSuiteButtons = new JButton[1];
		init();
	}
	public void init()
	{
		for(int i=0; i<1; i++)
		{
			penthouseSuiteButtons[i] = new JButton("Penthouse Suite");
			//penthouseSuiteButtons[i].setForeground(Color.white);
		}
	}
}

public class ViewRooms implements ActionListener {

	Icon logo_image;
	JLabel logo_label;
	FirstFloor F1 ;
	SecondFloor F2;
	ThirdFloor F3 ;
	FourthFloor F4;
	FifthFloor F5;
	JFrame frame;
	JLabel floorName;
	JButton backButton;
	public JPanel topPanel;
	JPanel bottomPanel;
	Connection con;
	String admin;
	ArrayList<String> RoomsANR; //available and notReserved
	ArrayList<String> RoomsAR; //available and Reserved
	ArrayList<String> RoomsUnavailable; 
	public ViewRooms(Connection con, String adminName)
	{
		F1 = new FirstFloor();
		F2 = new SecondFloor();
		F3 = new ThirdFloor();
		F4 = new FourthFloor();
		F5 = new FifthFloor();
		frame = new JFrame();
		topPanel = new JPanel();
		bottomPanel = new JPanel();
		bottomPanel.setLayout(null);
		topPanel.setLayout(null);
		backButton = new JButton("Return");
		RoomsANR = new ArrayList<String>();
		RoomsAR = new ArrayList<String>();
		RoomsUnavailable = new ArrayList<String>();
		this.con = con;
		this.admin = adminName;
		createFrame();
	}
	public void createFrame()
	{
		Font f1= new Font("Ariel",Font.BOLD,15);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setSize(1366,768);
		frame.setResizable(true);
		frame.setLayout(null);
		frame.setTitle("View Rooms and Bookings");
		topPanel.setBounds(0,0,1366,142);
		bottomPanel.setBounds(0,142,1366,714);
		logo_image = new ImageIcon("Capture5 - Copy.PNG");
		logo_label = new JLabel(logo_image);
		logo_label.setBounds(1000, 0, 366, 156);
		//System.out.println("Something");
		topPanel.add(logo_label);
		backButton.setBounds(35, 35, 100, 30);
		topPanel.add(backButton);
		
		Color C = Color.decode("#1A242A");
		topPanel.setBackground(C);
		
		//floor1
		//floorName.setText("First Floor :");
		F1.floor.setBounds(10,10, 80, 40);
		F1.singleRooms.setBounds(71, 10, 286, 40);
		F1.floor.setFont(f1);
		F1.singleRooms.setFont(f1);
		bottomPanel.add(F1.floor);
		bottomPanel.add(F1.singleRooms);
		int y = 43;
		int width=110,height = 29;
		for(int x = 71,i=0; i<10; x+=116)
		{
			F1.singleBedroomButtons[i].setBounds(x, y, width, height);
			bottomPanel.add(F1.singleBedroomButtons[i]);
			i++;
		}
		F1.doubleRooms.setBounds(71,79,386,40);
		F1.doubleRooms.setFont(f1);
		bottomPanel.add(F1.doubleRooms);
		y = 114;
		for(int x = 71,i=0; i<10; x+=116)
		{
			F1.doubleBedroomButtons[i].setBounds(x, y, width, height);
			bottomPanel.add(F1.doubleBedroomButtons[i]);
			i++;
		}
		
		
		//floor2
		F2.floor.setBounds(10,150, 80, 40);
		F2.singleRooms.setBounds(71,150,286,40);
		F2.floor.setFont(f1);
		F2.singleRooms.setFont(f1);
		bottomPanel.add(F2.floor);
		bottomPanel.add(F2.singleRooms);
		y=187;
		for(int x = 71,i=0; i<10; x+=116)
		{
			F2.singleBedroomButtons[i].setBounds(x, y, width, height);
			bottomPanel.add(F2.singleBedroomButtons[i]);
			i++;
		}
		F2.doubleRooms.setFont(f1);
		F2.doubleRooms.setBounds(71,221,286,40);
		bottomPanel.add(F2.doubleRooms);
		y = 257;
		for(int x = 71,i=0; i<10; x+=116)
		{
			F2.doubleBedroomButtons[i].setBounds(x, y, width, height);
			bottomPanel.add(F2.doubleBedroomButtons[i]);
			i++;
		}
		
		//floor3
		F3.floor.setFont(f1);
		F3.floor.setBounds(10,293,57,29);
		F3.suites.setFont(f1);
		F3.suites.setBounds(71,293,286,40);
		bottomPanel.add(F3.floor);
		bottomPanel.add(F3.suites);
		y=328;
		for(int x = 71,i=0; i<10; x+=116)
		{
			F3.suiteButtons[i].setBounds(x, y, width, height);
			bottomPanel.add(F3.suiteButtons[i]);
			i++;
		}
		
		//floor4
		F4.floor.setFont(f1);
		F4.floor.setBounds(10,364,57,29);
		F4.deluxSuites.setFont(f1);
		F4.deluxSuites.setBounds(71,361,285,29);
		bottomPanel.add(F4.floor);
		bottomPanel.add(F4.deluxSuites);
		y=400;
		for(int x = 71,i=0; i<5; x+=116)
		{
			F4.deluxSuiteButtons[i].setBounds(x, y, width, height);
			bottomPanel.add(F4.deluxSuiteButtons[i]);
			i++;
		}
		
		//floor5
		F5.floor.setFont(f1);
		F5.floor.setBounds(10,435,57,29);
		F5.penthouseSuites.setFont(f1);
		F5.penthouseSuites.setBounds(100,435,285,29);
		bottomPanel.add(F5.floor);
		bottomPanel.add(F5.penthouseSuites);
		y=471;
		for(int x = 71,i=0; i<1; x+=116)
		{
			F5.penthouseSuiteButtons[i].setBounds(x, y, width+100, height);
			bottomPanel.add(F5.penthouseSuiteButtons[i]);
			i++;
		}
	
		getRooms();
		fillColor();
		
		backButton.addActionListener(this);
		bottomPanel.setBackground(Color.decode("#1A242A"));
		frame.add(topPanel);
		frame.add(bottomPanel);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent Ae) 
	{
		if(Ae.getSource() == backButton)
		{
			this.frame.setVisible(false);
			new AdminHome(con,admin).frame.setVisible(true);
		}
	}
	
	public void getRooms()
	{
		PreparedStatement P;
		try {
			P = con.prepareStatement("select RoomNumber from RoomDetails where RoomAvailability = 1 and RoomReserved = 0");
			ResultSet Rs = P.executeQuery();
			while(Rs.next())
			{
				RoomsANR.add("Room "+Rs.getString(1));
			}
			
			P = con.prepareStatement("select RoomNumber from RoomDetails where RoomAvailability = 1 and RoomReserved = 1");
			Rs = P.executeQuery();
			while(Rs.next())
			{
				RoomsAR.add("Room "+Rs.getString(1));
			}
			
			P = con.prepareStatement("select RoomNumber from RoomDetails where RoomAvailability = 0");
			Rs = P.executeQuery();
			while(Rs.next())
			{
				RoomsUnavailable.add("Room "+Rs.getString(1));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	
	
	public void fillColor()
	{
		
		for(int i=0; i<10; i++)
		{
			
			//System.out.println(F1.singleBedroomButtons[i].getText());
			
			//FLOOR1 SINGLE
			if(RoomsANR.contains(F1.singleBedroomButtons[i].getText()))
				F1.singleBedroomButtons[i].setBackground(Color.green);
				
			
			if(RoomsAR.contains(F1.singleBedroomButtons[i].getText()))
				F1.singleBedroomButtons[i].setBackground(Color.yellow);
				
			
			if(RoomsUnavailable.contains(F1.singleBedroomButtons[i].getText()))
				F1.singleBedroomButtons[i].setBackground(Color.red);
				
			
			//FLOOR1 DOBULE
			if(RoomsANR.contains(F1.doubleBedroomButtons[i].getText()))
				F1.doubleBedroomButtons[i].setBackground(Color.green);
			
			if(RoomsAR.contains(F1.doubleBedroomButtons[i].getText()))
				F1.doubleBedroomButtons[i].setBackground(Color.yellow);

			if(RoomsUnavailable.contains(F1.doubleBedroomButtons[i].getText()))
				F1.doubleBedroomButtons[i].setBackground(Color.red);
			
			
			//FLOOR2 SINGLE
			if(RoomsANR.contains(F2.singleBedroomButtons[i].getText()))
				F2.singleBedroomButtons[i].setBackground(Color.green);
			
			if(RoomsAR.contains(F2.singleBedroomButtons[i].getText()))
				F2.singleBedroomButtons[i].setBackground(Color.yellow);

			if(RoomsUnavailable.contains(F2.singleBedroomButtons[i].getText()))
				F2.singleBedroomButtons[i].setBackground(Color.red);
			
			
			//FLOOR2 DOBULE
			if(RoomsANR.contains(F2.doubleBedroomButtons[i].getText()))
				F2.doubleBedroomButtons[i].setBackground(Color.green);
			
			if(RoomsAR.contains(F2.doubleBedroomButtons[i].getText()))
				F2.doubleBedroomButtons[i].setBackground(Color.yellow);

			if(RoomsUnavailable.contains(F2.doubleBedroomButtons[i].getText()))
				F2.doubleBedroomButtons[i].setBackground(Color.red);
		
			
			//Floor3
			if(RoomsANR.contains(F3.suiteButtons[i].getText()))
				F3.suiteButtons[i].setBackground(Color.green);
			
				//F3.suiteButtons[i].setBackground(Color.green);
			
			if(RoomsAR.contains(F3.suiteButtons[i].getText()))
				F3.suiteButtons[i].setBackground(Color.yellow);
			
			if(RoomsUnavailable.contains(F3.suiteButtons[i].getText()))
				F3.suiteButtons[i].setBackground(Color.red);
				
		}
		
		for(int i=0; i<5; i++)
		{
			//Floor4
			if(RoomsANR.contains(F4.deluxSuiteButtons[i].getText()))
	
				F4.deluxSuiteButtons[i].setBackground(Color.green);
			
			//if(RoomsAR.contains(F4.deluxSuiteButtons[i].getText()))
				F4.deluxSuiteButtons[i].setBackground(Color.yellow);
			
			if(RoomsUnavailable.contains(F4.deluxSuiteButtons[i].getText()))
				F4.deluxSuiteButtons[i].setBackground(Color.red);
			
		}
			
			
			//floor5
			if(RoomsANR.contains("Room 501"))
				F5.penthouseSuiteButtons[0].setBackground(Color.green);
			
			if(RoomsAR.contains("Room 501"))
				F5.penthouseSuiteButtons[0].setBackground(Color.yellow);
			
			if(RoomsUnavailable.contains("Room 501"))
				F5.penthouseSuiteButtons[0].setBackground(Color.red);
			
		
	}
}