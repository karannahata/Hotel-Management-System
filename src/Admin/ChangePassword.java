package Admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class ChangePassword implements ActionListener{

	JFrame frame;
	Icon logo_image;
	JLabel logo_label;
	JLabel oldPasswordLabel,newPasswordLabel,reenterLabel;
	JPasswordField oldPassword, newPassword,reenter;
	JButton doneButton,resetButton,returnButton; 
	Connection con;
	Font f1;
	String admin;
	public ChangePassword(Connection con, String admin)
	{Color C = Color.decode("#1A242A");
	
		this.admin = admin;
		this.con = con;
		frame = new JFrame();
		frame.getContentPane().setBackground(C);
		oldPasswordLabel = new JLabel("Old password :");
		newPasswordLabel = new JLabel("New Password :");
		reenterLabel = new JLabel("Renter :");
		oldPasswordLabel.setForeground(Color.WHITE);
		newPasswordLabel.setForeground(Color.WHITE);
		reenterLabel.setForeground(Color.WHITE);
		oldPassword = new JPasswordField();
		newPassword = new JPasswordField();
		reenter = new JPasswordField();
		
		doneButton = new JButton("Done");
		resetButton = new JButton("Reset");
		returnButton = new JButton("Return");
		
		fillframe();
	}
	
	public void fillframe()
	{
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setBounds(0,0,1366,768);
		f1 = new Font("Ariel",Font.BOLD,20);
		logo_image = new ImageIcon("Capture5 - copy.PNG");
		logo_label = new JLabel(logo_image);
		logo_label.setBounds(1000, 35, 366, 156);
		frame.setLayout(null);
		frame.add(logo_label);
		returnButton.setBounds(10, 10, 100, 30);
		frame.add(returnButton);	
		
		
		oldPasswordLabel.setBounds(428,214,214,50);
		newPasswordLabel.setBounds(428,271,214,50);
		reenterLabel.setBounds(428,329,214,50);
		oldPasswordLabel.setFont(f1);
		newPasswordLabel.setFont(f1);
		reenterLabel.setFont(f1);
		
		oldPassword.setBounds(642,214,214,50);
		newPassword.setBounds(642,271,214,50);
		reenter.setBounds(642,329,214,50);
		
		doneButton.setBounds(535, 386, 100, 50);
		resetButton.setBounds(678, 386, 100, 50);
		
		frame.add(oldPasswordLabel);
		frame.add(newPasswordLabel);
		frame.add(reenterLabel);
		frame.add(oldPassword);
		frame.add(newPassword);
		frame.add(reenter);
		frame.add(doneButton);
		frame.add(resetButton);
		frame.setVisible(true);
		
		doneButton.addActionListener(this);
		resetButton.addActionListener(this);
		returnButton.addActionListener(this);
		
		
		//frame.add(returnButton);
	}

	@Override
	public void actionPerformed(ActionEvent Ae) {
		// TODO Auto-generated method stub
		if(Ae.getSource() == returnButton)
		{
			this.frame.setVisible(false);
			new AdminHome(con,admin).frame.setVisible(false);
		}
		if(Ae.getSource() == returnButton)
		{
			this.frame.setVisible(false);
			new AdminHome(con,admin).frame.setVisible(true);
			
		}
		if(Ae.getSource() == resetButton)
		{
			oldPassword.setText("");
			newPassword.setText("");
			reenter.setText("");
		}
		if(Ae.getSource() == doneButton)
		{
			String url1 = "select Password from AdminDetail where AdminID = '"+admin+"'";
			try {
				ResultSet rs = con.prepareStatement(url1).executeQuery();
				rs.next();
				if(new String(oldPassword.getPassword()).equals(rs.getString(1)))
				{
					if(new String(reenter.getPassword()).equals(new String(newPassword.getPassword())))
					{
						//String url = "Update AdminDetail set Password = '"+newPassword.getPassword()+" where Password = '"+oldPassword.getPassword()+"'";
						//con.prepareStatement(url).executeUpdate();
						PreparedStatement ps =con.prepareStatement("update AdminDetail set Password='"+new String(newPassword.getPassword())+"' where Password='"+new String(oldPassword.getPassword())+"'");
						ps.executeUpdate();
						JOptionPane.showMessageDialog(this.frame,"Password changed successfully.");
					}
					else
					{
						JOptionPane.showMessageDialog(this.frame,"Passwords do not match.");
						reenter.setText("");
						newPassword.setText("");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this.frame,"Old Password does not match the database");
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
