package Customer;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

import Beans.CustomerFeedback;
import DAO.CustomerFeedbackImpl;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;


public class Feed implements ActionListener
{
	
JFrame j5;
Icon l,smiley1,smiley2,smiley3,smiley4,smiley5;
JLabel logo,t,utext,uname,rateus,description;
JTextField name1;
JRadioButton rb1,rb2,rb3,rb4,rb5;
JTextArea feed;
JButton submitbutton,backbutton;
JScrollPane scroll;
ButtonGroup bg;
JRadioButton prevrb;
String loginid;
int rate;
Connection con;
PreparedStatement psmt;
	void Feedback(String loginid)
	{   this.loginid=loginid;
		j5 = new JFrame();
		j5.setLayout(null);
		j5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j5.setTitle("Feedback Forum");
		j5.setResizable(true);
		j5.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//j2.getContentPane().setBackground(Color.green);
	    	
		//i2=new ImageIcon("image1.jpg");
		//b=new JLabel(i2);
		//b.setBounds(0, 0, 1000, 1000);
		//j1.setContentPane(b);
		//j1.add(b);
		
		bg=new ButtonGroup();
		
		l = new ImageIcon("log1.png");
		logo=new JLabel(l);
		logo.setBounds(980,20,460,156);
		j5.add(logo);

		t = new JLabel("Feedback");
		Font f= new Font("Monotype Corsiva",Font.BOLD,50);
		t.setFont(f);
	    t.setForeground(Color.DARK_GRAY);
		t.setBounds(390,50,600,50);
		j5.add(t);
		
		utext=new JLabel("Please provide us your feedback to help us serve you better..");
		Font f1= new Font("Monotype Corsiva",Font.ITALIC,20);
		utext.setFont(f1);
		utext.setBounds(100,120,600,50);
		j5.add(utext);
		
		uname=new JLabel("Name");
		Font f2= new Font("Monotype Corsiva",Font.BOLD,15);
		uname.setFont(f2);
		uname.setBounds(50,180,80,20);
		j5.add(uname);
		
		
		name1=new JTextField();
		name1.setBounds(130,180,600,30);
		j5.add(name1);

		rateus=new JLabel("Rate us");
		rateus.setFont(f2);
		rateus.setBounds(50,230,80,20);
		j5.add(rateus);
		
		smiley1=new ImageIcon("f1.png");
		rb1=new JRadioButton("h ",smiley1);
		//rb1.setIcon(smiley1);
		rb1.setToolTipText("Excellent");
		rb1.setBounds(130,230,50,50);
		rb1.addActionListener(this);
		bg.add(rb1);
		j5.add(rb1);
		

		smiley2=new ImageIcon("f2.png");
		rb2=new JRadioButton();
		rb2.setIcon(smiley2);
		rb2.setToolTipText("Very good");
		rb2.addActionListener(this);
		rb2.setBounds(180,230,50,50);
		bg.add(rb2);
		j5.add(rb2);
		

		smiley3=new ImageIcon("f3.png");
		rb3=new JRadioButton();
		rb3.setIcon(smiley3);
		rb3.addActionListener(this);
		rb3.setToolTipText("Needs Improvement");
		rb3.setBounds(230,230,50,50);
		bg.add(rb3);
		j5.add(rb3);
		
		smiley4=new ImageIcon("f4.png");
		rb4=new JRadioButton();
		rb4.setIcon(smiley4);
		rb4.addActionListener(this);
		rb4.setToolTipText("Average");
		rb4.setBounds(280,230,50,50);
		bg.add(rb4);
		j5.add(rb4);
		
		smiley5=new ImageIcon("f5.png");
		rb5=new JRadioButton();
		rb5.setIcon(smiley5);
		rb5.addActionListener(this);
		rb5.setToolTipText("Very bad");
		rb5.setBounds(330,230,50,50);
		bg.add(rb5);
		j5.add(rb5);
		
		
		
		
		description=new JLabel("Description");
		description.setFont(f2);
		description.setBounds(50,280,120,20);
		j5.add(description);
		
		feed= new JTextArea();
		 scroll = new JScrollPane(feed);
		          scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50,320,1300,300);
		j5.add(scroll);
		
		feed.setText("   Enter your text here..........");
		
		
		submitbutton=new JButton("Submit");
		submitbutton.setBounds(600,630,80,30);
		submitbutton.addActionListener(this);
		j5.add(submitbutton);
		
		backbutton=new JButton("Back");
		backbutton.setBounds(700,630,80,30);
		backbutton.addActionListener(this);
		j5.add(backbutton);
		
		j5.setVisible(true);
		
		
		
	}
	/*public static void main(String[] a)
	{
		Feed f=new Feed();
		f.Feedback(loginid);
	}*/
	@Override
	public void actionPerformed(ActionEvent a)
	{
		if(a.getSource()==rb1||a.getSource()==rb2||a.getSource()==rb3||a.getSource()==rb4||a.getSource()==rb5)
		{
			((JRadioButton)a.getSource()).setBackground(Color.GREEN);
		
		if(prevrb!=null)
			prevrb.setBackground(null);
		prevrb=(JRadioButton)a.getSource();
		
		if(rb1.isSelected())
		{
			rate=5;
		}
		
		if(rb2.isSelected())
		{
			rate=4;
		}
		if(rb3.isSelected())
		{
			rate=3;
		}
		if(rb4.isSelected())
		{
			rate=2;
		}
		
		if(rb5.isSelected())
		{
			rate=1;
		}
		}
		
		if(a.getSource()==submitbutton)
		{
			CustomerFeedback f=new CustomerFeedback();
			
			f.setCustomerId( loginid);
			f.setRating(rate);
		 f.setFeedback(feed.getText());
									
		 CustomerFeedbackImpl i=new CustomerFeedbackImpl();
		 try {
			i.getFeedback(f);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
					
					
					
					
					JOptionPane.showMessageDialog(this.j5, "Successfully submitted");
				    submitbutton.setEnabled(false);
				    feed.setEnabled(false);
				    name1.setEnabled(false);
					
			}
		
		if(a.getSource()==backbutton)
		{
		custh home=new custh();
		try {
			home.custhome(loginid);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
				
	}

			}



			
			
		
		
		
	





