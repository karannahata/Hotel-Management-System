package Customer;





import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import DAO.CustomerImpl;

public class forgotpassword implements ActionListener{

	JFrame frame,frame1;
	Icon logo_image;
	JLabel logo_label;
	JLabel SQuesLabel,SAnsLabel,newPasswordLabel,reenterLabel,loginidLabel;
	JPasswordField  newPassword,reenter;
	JButton submitButton,resetButton,returnButton,doneButton,resetpbutton; 
	Connection c;
	Font f1;
	PreparedStatement p;
	
	JComboBox cou;
	JTextField ans,loginid;
	public forgotpassword()
	{
		

		
		frame = new JFrame();
		
		SQuesLabel = new JLabel("Security Question:");
		SAnsLabel = new JLabel("Answer :");
		loginidLabel=new JLabel("Loginid :");
		
		cou=new JComboBox();
		cou.addItem("What is your first pet name ?");
		cou.addItem("What was your childhood name?");
		cou.addItem("What is your favourite movie?");
		cou.addItem("In what town was your first job?");
		
		ans=new JTextField();
		loginid=new JTextField();
		
		submitButton = new JButton("Submit");
		resetButton = new JButton("Reset");
		returnButton = new JButton("Cancel");
		
	
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	frame.setBounds(400,200,450,400);
	f1 = new Font("Ariel",Font.BOLD,15);
	//logo_image = new ImageIcon("log1.PNG");
	//logo_label = new JLabel(logo_image);
	//logo_label.setBounds(1000, 35, 366, 156);
	frame.setLayout(null);
	//frame.add(logo_label);
	returnButton.setBounds(10, 10, 100, 30);
	frame.add(returnButton);	
	
	loginidLabel.setBounds(10,70,150,30);
	SQuesLabel.setBounds(10,130,150,30);
	SAnsLabel.setBounds(10,190,150,30);
	loginidLabel.setFont(f1);
	SQuesLabel.setFont(f1);
	SAnsLabel.setFont(f1);
	cou.setFont(f1);
	

	ans.setBounds(170,190,214,30);
	cou.setBounds(170,130,214,30);
	loginid.setBounds(170,70,214,30);
	submitButton.setBounds(85,310,100,30);
	resetButton.setBounds(200,310,100,30);
	frame.add(loginidLabel);
	frame.add(loginid);
	frame.add(SQuesLabel);
	frame.add(SAnsLabel);
	frame.add(ans);
	frame.add(cou);
	//frame.add(newPassword);
	//frame.add(reenter);
	frame.add(submitButton);
	frame.add(resetButton);
	frame.setVisible(true);
	frame.add(returnButton);
	submitButton.addActionListener(this);
	resetButton.addActionListener(this);
	returnButton.addActionListener(this);
	
	
	//frame.add(returnButton);
}
void changepass()
{
	frame.dispose();
	frame1 = new JFrame();
//oldPasswordLabel = new JLabel("Old password :");
newPasswordLabel = new JLabel("New Password :");
reenterLabel = new JLabel("Reenter New Password:");


newPassword = new JPasswordField();
reenter = new JPasswordField();

doneButton = new JButton("Save");
resetpbutton = new JButton("Reset");

frame1.setBounds(400,200,450,400);
f1 = new Font("Ariel",Font.BOLD,15);
frame1.setLayout(null);
frame1.setResizable(false);


newPasswordLabel.setBounds(10,70,150,30);
reenterLabel.setBounds(10,130,150,30);

newPasswordLabel.setFont(f1);
reenterLabel.setFont(f1);


newPassword.setBounds(170,70,150,30);
reenter.setBounds(170,130,150,30);

doneButton.setBounds(85,250,100, 30);
resetpbutton.setBounds(200,250,100,30);

frame1.add(newPasswordLabel);
frame1.add(reenterLabel);

frame1.add(newPassword);
frame1.add(reenter);
frame1.add(doneButton);
frame1.add(resetpbutton);
frame1.setVisible(true);

doneButton.addActionListener(this);
resetpbutton.addActionListener(this);
frame1.setVisible(true);



}

	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		if(a.getSource()==resetButton)
		{loginid.setText(null);
			ans.setText(null);
		}
	if(a.getSource()==returnButton)
	{
		frame.dispose();
	
	}
	
	if(a.getSource()==submitButton)
	{
		int i=0;
		CustomerImpl c=new CustomerImpl();
		try {
			i=c.forgotPassword(loginid.getText(),cou.getSelectedItem().toString(),ans.getText());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			if(i==1)
			{	
			        changepass();
			}
			       
				
				else
				{
					JOptionPane.showMessageDialog(this.frame,"Security question and answer do not match..or You entered wrong loginid,,");
					ans.setText("");
					
				}
			
		
		
		}
	
	
	if(a.getSource()==resetpbutton)
	{
		reenter.setText("");
		newPassword.setText("");
	}
	
	if(a.getSource()==doneButton)
	{CustomerImpl c=new CustomerImpl();
	int flag=0;
	
	try {
		flag=c.resetPassword(newPassword.getText(), reenter.getText(), loginid.getText());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		 if(flag==1)
			{
			
			
			
			JOptionPane.showMessageDialog(this.frame,"Password changed successfully.");
			frame1.dispose();
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
