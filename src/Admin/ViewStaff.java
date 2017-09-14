package Admin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ViewStaff implements ActionListener {

	JFrame frame;
	Icon logo_image;
	JLabel logo_label;
	JButton backButton;
	JTable Result;
	Connection con;
	String admin;
	DefaultTableModel model;
	
	
	public ViewStaff(Connection con, String adminName)
	{
		frame = new JFrame();
		backButton = new JButton("Return");
		Result = new JTable();
		this.con = con;
		this.admin = adminName;
		
		model = new DefaultTableModel(){
			
			private static final long serialVersionUID = 1L;
			//String column[] = {"","Rating/5","Feedback"};
			
			@Override
			public int getColumnCount() {
				return 11;
			}
			@Override
			public boolean isCellEditable(int arg0, int arg1) {
					return false;
			}
		
			@Override
			public void addColumn(Object arg0) {
				// TODO Auto-generated method stub
				super.addColumn(arg0);
			}
			@Override
			public void addRow(Object[] arg0) {
				// TODO Auto-generated method stub
				super.addRow(arg0);
			}
			
		};
		createFrame();
	}
	
	public void createFrame()
	{
		frame.setSize(1366, 768);
		frame.setLayout(null);
		logo_image = new ImageIcon("Capture5 - copy.PNG");
		logo_label = new JLabel(logo_image);
		logo_label.setBounds(1000, 50, 366, 156);
		frame.add(logo_label);
		
		model.addColumn("SNo");
		model.addColumn("Image");
		model.addColumn("Employee ID");
		model.addColumn("Name");
		model.addColumn("Gender");
		model.addColumn("Address");
		model.addColumn("Pincode");
		model.addColumn("DOB");
		model.addColumn("Email");
		model.addColumn("Password");
		model.addColumn("Contact");
	
		backButton.setBounds(50, 100, 100, 35);
		backButton.addActionListener(this);
		fillTable();
		
	
		Result = new JTable(model);	
		
		//Result.setBounds(100,256,1200,450);
		//frame.add(Result);
		frame.add(backButton);
		
		/*TableColumn tc = Result.getColumnModel().getColumn(0);
		tc.setHeaderValue(" ");
		tc = Result.getColumnModel().getColumn(1);
		tc.setHeaderValue("Employee ID");
		tc = Result.getColumnModel().getColumn(2);
		tc.setHeaderValue("Rating ");
		tc = Result.getColumnModel().getColumn(3);
		tc.setHeaderValue("Comments ");
		*/
		JScrollPane P = new JScrollPane(Result);
		P.setBounds(100,256,1200,450);
		frame.add(P);
				
		/*Result.getColumnModel().getColumn(1).setPreferredWidth(70);
		Result.getColumnModel().getColumn(1).setPreferredWidth(200);
		Result.getColumnModel().getColumn(2).setPreferredWidth(30);
		Result.getColumnModel().getColumn(3).setPreferredWidth(900);
		Result.repaint();
		*/
		frame.getContentPane().setBackground(Color.decode("#1A242A"));
		frame.setVisible(true);
	}
	
	
	public void fillTable()
	{
		PreparedStatement P;
		try {
			P = con.prepareStatement("Select * from EmployeeDetails");
			ResultSet Rs = P.executeQuery();
			//Result.getColumnName(1);
			Object[] a = new Object[11];
			
			int i=0;
			while(Rs.next())
			{
				a[0] = new Integer(i+1);
				a[1] = Rs.getString(10);
				a[2] = Rs.getString(1);
				a[3] = Rs.getString(2);
				a[4] = Rs.getString(3);
				a[5] = Rs.getString(4);
				a[6] = Rs.getString(5);
				a[7] = Rs.getString(6);
				a[8] = Rs.getString(7);
				a[9] = Rs.getString(8);
				a[10] =  Rs.getString(9);
				model.addRow(a);
				i++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == backButton)
		{
			this.frame.setVisible(false);
			new AdminHome(con,admin).frame.setVisible(true);
		}
	}
		
}

