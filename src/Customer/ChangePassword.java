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
import DAO.CustomerImpl;
import javax.swing.*;

public class ChangePassword implements ActionListener{

	JFrame frame;
	Icon logo_image;
	JLabel logo_label;
	JLabel oldPasswordLabel,newPasswordLabel,reenterLabel;
	JPasswordField oldPassword, newPassword,reenter;
	JButton doneButton,resetButton,returnButton; 
	Connection c;
	Font f1;
	String loginid;
	public ChangePassword(String loginid)
	{Color C = Color.decode("#1A242A");
		this.loginid = loginid;
		
		frame = new JFrame();
		frame.getContentPane().setBackground(C);
		oldPasswordLabel = new JLabel("Old password :");
		newPasswordLabel = new JLabel("New Password :");
		reenterLabel = new JLabel("Renter New Password:");
		oldPasswordLabel.setForeground(Color.WHITE); 
		newPasswordLabel.setForeground(Color.WHITE);
		reenterLabel.setForeground(Color.WHITE);
	
		oldPassword = new JPasswordField();
		newPassword = new JPasswordField();
		reenter = new JPasswordField();
		
		doneButton = new JButton("Save");
		resetButton = new JButton("Reset");
		returnButton = new JButton("Return");
		
		fillframe();
	}
	
	public void fillframe()
	{
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setBounds(0,0,1366,768);
		f1 = new Font("Ariel",Font.BOLD,20);
		logo_image = new ImageIcon("log1.PNG");
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

	public void actionPerformed(ActionEvent Ae) {
		// TODO Auto-generated method stub
		if(Ae.getSource() == returnButton)
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
		if(Ae.getSource() == resetButton)
		{
			oldPassword.setText("");
			newPassword.setText("");
			reenter.setText("");
		}
		if(Ae.getSource() == doneButton)
		{
			CustomerImpl cust=new CustomerImpl();
			int flag = 0;
			try {
				flag = cust.changePassowrd(loginid, oldPassword.getText(), newPassword.getText(), reenter.getText());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
					if(flag==1)
					{
												
						JOptionPane.showMessageDialog(this.frame,"Password changed successfully.");
					}
					else if(flag==0)
					{
						JOptionPane.showMessageDialog(this.frame,"Old Password does not match the database");
					}
					else
					{
						JOptionPane.showMessageDialog(this.frame,"Passwords do not match.");
						reenter.setText("");
						newPassword.setText("");
					}
				}
	}
}
			
	
	
	

