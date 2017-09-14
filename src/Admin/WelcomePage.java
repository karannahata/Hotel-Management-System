package Admin;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import Admin.AdminLogin;
import Beans.Customer;
import Customer.CustomerLogin;
import Employee.EmployeeLogin;


/*class Images extends Thread{

	JLabel images_label;
	Icon i[];
	WelcomePage  ;
	public Images(WelcomePage w)
	{
		super();
		  = w;
		i = new Icon[6];
		i[0] = new ImageIcon("image1.jpg");
		i[1] = new ImageIcon("image2.jpg");
		i[2] = new ImageIcon("image3.jpg");
		i[3] = new ImageIcon("image4.jpg");
		
		images_label = new JLabel();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int index=0;
		while(true)
		{
			images_label.setIcon(i[index%4]);
			images_label.setBounds(0, 60, 1000, 768);
			 .left_panel.add(images_label);
			index++;
			try {
				sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}*/

class MyPhotoLabel
{

	JPanel PhotoPanel;
	JLabel PhotoLabel[];
	JLabel Title;
	int i;
	public MyPhotoLabel(String title,int i)
	{
		this.i = i;
		PhotoPanel = new JPanel();
		PhotoPanel.setLayout(new GridLayout(1,5));
		PhotoPanel.setBackground(Color.decode("#1A242A"));
		PhotoLabel = new JLabel[i];
		for(int a = 0; a<i; a++)
		{
			PhotoLabel[a] = new JLabel();
		}
		Title = new JLabel(title);
		//Title.setForeground(Color.white);
	}
	
	public void setImage(ImageIcon...I1)
	{
		int a = 0;
		for(ImageIcon temp : I1)
		{PhotoLabel[a].setForeground(Color.WHITE);
			PhotoLabel[a].setIcon(temp);
			PhotoPanel.add(PhotoLabel[a]);
			a++;
		}
	}	
}


 
    

public class WelcomePage implements ActionListener,MouseListener{
	
	public JFrame frame;
	JPanel right_panel;
	JLayeredPane left_panel;
	Icon logo_image;
	JLabel logo_label;
	JButton admin,managment,customer;
	JLabel info_label;
	MyPhotoLabel First,Second,Third,Fourth;
	JLabel Bg;
	Color C;
	
	public void callActionListner()
	{
		admin.addActionListener(this);
		customer.addActionListener(this);
		managment.addActionListener(this);
		First.Title.addMouseListener(this);
		Second.Title.addMouseListener(this);
		Third.Title.addMouseListener(this);
		Fourth.Title.addMouseListener(this);
	}
	
	public static void main(String a[])
	{
		new WelcomePage();
	}

	public WelcomePage()
	{
		frame = new JFrame();
		logo_image = new ImageIcon("Capture5 - Copy.PNG");
		logo_label = new JLabel(logo_image);
		frame.setLayout(null);
		// .frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		 frame.setSize(1366,768);
		 frame.setResizable(true);
		 left_panel = new JLayeredPane();
		 left_panel.setLayout(null);
		 right_panel = new JPanel();
		
		 right_panel.setLayout(null);
		 left_panel.setBounds(0,0,1050,768);
		 right_panel.setBounds(1050,0,1366,768);
		 Bg = new JLabel(new ImageIcon("image1.jpg"));
		 Bg.setBounds(0,50,1050,708);
		 left_panel.add(Bg,new Integer(1));
		
		//**************************************************************
		//Images I = new Images( );
		//I.start();
		//**************************************************************
		
		// .info_label = new JLabel("This is where all the info about hotel will come.");
		
		 logo_label.setBounds(0, 0, 366-50 , 156);
		
		// .frame.setContentPane( .lBg);
		
		 admin = new JButton("Admin Login");
		 managment = new JButton("Staff Login");
		 customer = new JButton("User Login");
		
		 admin.add(new JLabel(new ImageIcon("admin.png")));
		 admin.setBounds(0, 170, 316 , 110);
		 admin.setBackground(Color.white);
		 admin.setForeground(Color.black);
	
		
		 managment.add(new JLabel(new ImageIcon("staff.png")));
		 managment.setBounds(0,300 , 316, 110);
		 managment.setBackground(Color.white);
		 managment.setForeground(Color.black);
		// .managment.setHorizontalAlignment(SwingConstants.RIGHT);
		
		 customer.add(new JLabel(new ImageIcon("user.png")));
		 customer.setBounds(0, 430, 316, 110);
		 customer.setBackground(Color.white);
		 customer.setForeground(Color.black);
		// .customer.setHorizontalAlignment(SwingConstants.CENTER);
	
		 right_panel.add(logo_label);
		 right_panel.add(admin);
		 right_panel.add(managment);
		 right_panel.add(customer);
		
		
		 First = new MyPhotoLabel("Hotel",3);
		 First.Title.setBounds(0,0,80,50);
		 First.Title.setHorizontalAlignment(SwingConstants.CENTER);
		 First.Title.setBorder(BorderFactory.createCompoundBorder());
		 First.PhotoPanel.setBackground(Color.WHITE);
		 First.PhotoPanel.setVisible(false);
		 First.setImage(new ImageIcon("hotel1.jpg"), new ImageIcon("hotel5.jpg"), new ImageIcon("hotel4.jpg"));
		 left_panel.add( First.Title);
		 
		 Second = new MyPhotoLabel("Rooms",4);
		 Second.Title.setBounds(100,0,80,50);
		// .Second.PhotoPanel.setBounds(0,60,820,160);
		 Second.PhotoPanel.setBackground(Color.WHITE);
		 Second.PhotoPanel.setVisible(true);
		 Second.setImage(new ImageIcon("room1.jpg"),new ImageIcon("room2.jpg"), new ImageIcon("room3.jpg"),new ImageIcon("room4.jpg"));
		 left_panel.add( Second.Title);
		
		 Third = new MyPhotoLabel("Dining Area",5);
		 Third.Title.setBounds(200,0,80,50);
		/// .Second.PhotoPanel.setBounds(0,60,820,160);
		 Third.PhotoPanel.setBackground(Color.WHITE);
		 Third.PhotoPanel.setVisible(false);
		 Third.setImage(new ImageIcon("dining1.jpg"),new ImageIcon("dining2.jpg"), new ImageIcon("dining3.jpg"),new ImageIcon("dining4.jpg"),new ImageIcon("dining5.jpg"));
		 left_panel.add( Third.Title);
		
		 Fourth = new MyPhotoLabel("Surroundings",5);
		 Fourth.Title.setBounds(300,0,80,50);
		/// .Second.PhotoPanel.setBounds(0,60,820,160);
		 Fourth.PhotoPanel.setBackground(Color.WHITE);
		 Fourth.PhotoPanel.setVisible(false);
		 Fourth.setImage(new ImageIcon("surrounding1.jpg"),new ImageIcon("surrounding2.jpg"), new ImageIcon("surrounding3.jpg"),new ImageIcon("surrounding4.jpg"),new ImageIcon("surrounding5.jpg"));
		 left_panel.add( Fourth.Title);
		
		/*
		 .First.Title.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e)
			{
				// .First.setImage(new ImageIcon("image1.jpg"), new ImageIcon("image2.jpg"));
				 .First.Title.setBackground(Color.CYAN);
				 .First.PhotoPanel.setVisible(true);
			}
			public void mouseExited(MouseEvent e)
			{
				// .First.setImage(new ImageIcon("image1.jpg"), new ImageIcon("image2.jpg"));
				 .First.PhotoPanel.setVisible(false);
				 .First.Title.setBackground(Color.RED);
			}
		});
		 */
		
		// .left_panel.add( .First.Title);
		 left_panel.add( First.PhotoPanel, new Integer(2));
		 left_panel.add( Second.PhotoPanel, new Integer(2));
		 left_panel.add( Third.PhotoPanel, new Integer(2));
		 left_panel.add( Fourth.PhotoPanel, new Integer(2));
		
		 C = Color.decode("#1A242A");
		 
		 right_panel.setBackground(C);
		 left_panel.setBackground(C);
		 
		 callActionListner();
		 frame.add( left_panel);
		 frame.add( right_panel);
		 // .frame.add(logo_label);
		 // .frame.add(managment);
		 // .frame.add(admin);
		 // .frame.add(customer);
		 frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent Ae) {
		// TODO Auto-generated method stub
		if(Ae.getSource() == admin)
		{
			//this.frame.setVisible(false);
			AdminLogin A = new AdminLogin();
		}
		/*else if(Ae.getSource() == First.Title)
		{
			First.setImage(new ImageIcon("image1.jpg"), new ImageIcon("image2.jpg"));
			frame.add(First.PhotoPanel);
		}*/
		if(Ae.getSource()==customer){
		//	this.frame.setVisible(false);
			CustomerLogin c = new CustomerLogin();
			c.login();
		}
		if(Ae.getSource()==managment){
			//this.frame.setVisible(false);
			EmployeeLogin e = new EmployeeLogin();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Hello");
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == First.Title) //hotel
		{	
			First.PhotoPanel.setBounds(0,50,800,160);
			First.PhotoPanel.setVisible(true);
		}
		if(e.getSource() == Second.Title) //rooms
		{
			Second.PhotoPanel.setBounds(0,50,930,160);
			Second.PhotoPanel.setVisible(true);
		}
		if(e.getSource() == Third.Title){ //dining
			Third.PhotoPanel.setBounds(0,50,780,160);
			Third.PhotoPanel.setVisible(true);
		}
		if(e.getSource() == Fourth.Title){ //surroundings
			Fourth.PhotoPanel.setBounds(0,50,780,160);
			Fourth.PhotoPanel.setVisible(true);
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub	
		if(e.getSource() == First.Title)
			First.PhotoPanel.setVisible(false);
		else if(e.getSource() == Second.Title)
			Second.PhotoPanel.setVisible(false);
		else if(e.getSource() == Third.Title)
			Third.PhotoPanel.setVisible(false);
		else if(e.getSource() == Fourth.Title)
			Fourth.PhotoPanel.setVisible(false);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
