package Employee;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import DatabaseWork.*;
import javax.swing.JTextField;

import DAO.EmployeeImpl;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class ChangePassword extends EmployeeFetch implements ActionListener {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JButton btnNewButton,btnCancel;
	private String loginId;
	
	public ChangePassword(String loginId) {
		initialize(loginId);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String loginId) {
		this.loginId=loginId;
		frame = new JFrame();
		frame.setBounds(400, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Old Password");
		lblNewLabel.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		lblNewLabel.setBounds(56, 66, 119, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		lblNewPassword.setBounds(56, 110, 119, 33);
		frame.getContentPane().add(lblNewPassword);
		
		JLabel lblConfirmpassword = new JLabel("Confirm Password");
		lblConfirmpassword.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		lblConfirmpassword.setBounds(56, 154, 161, 33);
		frame.getContentPane().add(lblConfirmpassword);
		
		textField = new JTextField();
		textField.setBounds(232, 72, 137, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(232, 116, 137, 20);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(232, 160, 137, 20);
		frame.getContentPane().add(passwordField_1);
		
		btnNewButton = new JButton("OK");
		btnNewButton.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		btnNewButton.setBounds(107, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		btnCancel.setBounds(232, 227, 89, 23);
		frame.getContentPane().add(btnCancel);
		btnCancel.addActionListener(this);
		
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCancel){
			frame.dispose();
		}
		if(e.getSource()==btnNewButton){
			String s1=new String(passwordField.getPassword()) ;
			String s2=new String(passwordField_1.getPassword()) ;
			String s0=textField.getText();
			int f=0;
			EmployeeImpl el = new EmployeeImpl();
			try {
				f = el.changePassword(loginId, s0, s1,s2);
				
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(f==1){
				frame.dispose();
				JOptionPane.showMessageDialog(frame,"Password Changed Successfully");
				
			}
			else if(f==0){
				JOptionPane.showMessageDialog(frame,"Old Password Incorrect","Alert",JOptionPane.ERROR_MESSAGE);
			}
			else{
				JOptionPane.showMessageDialog(frame,"Passwords are not matching","Alert",JOptionPane.ERROR_MESSAGE);
			}
			/*ResultSet rs = null;
			try {
				rs = getData(loginId);
				rs.next();
			} catch (ClassNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				//System.out.println(rs.getString(1)+ " "+textField.getText() );
				System.out.println(loginId);
				if(textField.getText().equals(rs.getString(1))){
					String s1=new String(passwordField.getPassword()) ;
					String s2=new String(passwordField_1.getPassword()) ;
					if(s1.equals(s2)){
						Update u = new Update();
						try {
							u.updatePassword(s1,textField.getText(),loginId);
							frame.dispose();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else{
						JOptionPane.showMessageDialog(frame,"Passwords are not matching","Alert",JOptionPane.ERROR_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(frame,"Old Password Incorrect","Alert",JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			*/
		}
	}
}
