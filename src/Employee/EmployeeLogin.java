package Employee;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import DatabaseWork.EmployeeFetch;
import javax.swing.*;

import DAO.EmployeeImpl;

public class EmployeeLogin extends EmployeeFetch implements ActionListener  {
	private JFrame frame;
	private JLabel labelLogin,labelPassword;
	private JTextField fieldLogin ;
	private JPasswordField fieldPassword;
	private JButton btnSubmit,btnCancel;
	ImageIcon logo_image;
	JLabel logo_label;
	
	public EmployeeLogin(){
		frame = new JFrame();
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Management Login");
		frame.setBounds(400, 100, 650, 600);
		frame.setResizable(false);
	frame.getContentPane().setBackground(Color.decode("#1A242A"));
		 Font f1= new Font("Amandella Script",Font.BOLD,40);
		labelLogin = new JLabel("LOGIN");
		labelLogin.setForeground(Color.WHITE);
		
		labelLogin.setFont(f1);
		labelLogin.setBounds(150,170,100,30);
		frame.add(labelLogin);

		labelPassword = new JLabel("PASSWORD");
		labelPassword.setFont(f1);
		labelPassword.setBounds(150,210,150,50);
		labelPassword.setForeground(Color.WHITE);
		frame.add(labelPassword);
		
		fieldLogin=new JTextField();
		fieldLogin.setBounds(350,170,150,30);
		frame.add(fieldLogin);
		
		fieldPassword = new JPasswordField();
		fieldPassword.setBounds(350,215 , 150, 30);
		frame.add(fieldPassword);
		
		btnSubmit= new JButton("Submit");
		btnSubmit.setBounds(200,300,100,35);
		frame.add(btnSubmit);
		
		btnCancel= new JButton("Reset");
		btnCancel.setBounds(350,300,100,35);
		frame.add(btnCancel);
		
		logo_image = new ImageIcon("Capture5 - Copy.PNG");
		logo_label = new JLabel(logo_image);
		logo_label.setBounds(1000, 0, 366, 156);
		frame.add(logo_label);
		
		btnSubmit.addActionListener(this);
		btnCancel.addActionListener(this);
		
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==btnSubmit){
			String password=new String(fieldPassword.getPassword());
			String loginId=fieldLogin.getText();
			int f = 0;
			EmployeeImpl el = new EmployeeImpl();
			try {
				f= el.verifyPassword(loginId, password);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(f==1){
				MainPage cd = new MainPage(loginId);
				frame.dispose();
			}
			else if(f==0)
			JOptionPane.showMessageDialog(frame,"Wrong Id or Password","Alert",JOptionPane.ERROR_MESSAGE);
			else
				JOptionPane.showMessageDialog(frame,"Employee not found","Alert",JOptionPane.ERROR_MESSAGE);
				
		}
		/*ResultSet rs;
		String password=new String(fieldPassword.getPassword());
		String loginId=fieldLogin.getText();
		int flag=0;
		try {
			setConnection();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if(e.getSource()==btnSubmit){
			try {
				rs= getData(loginId);
				while(rs.next()){
					if(password.equals(rs.getString(1))){
						MainPage  cd = new MainPage(loginId,getConnection());
						flag=1;
						frame.dispose();
					}
				}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			fieldLogin.setText(null);
			fieldPassword.setText(null);
			if(flag==0)
			JOptionPane.showMessageDialog(frame,"Wrong Id or Password","Alert",JOptionPane.ERROR_MESSAGE);
		}*/
		if(e.getSource()==btnCancel){
			fieldLogin.setText(null);
			fieldPassword.setText(null);
		}
		
		
	}
public static void main(String[] args) {
		
		EmployeeLogin m2 = new EmployeeLogin();
		
	}
	
}
