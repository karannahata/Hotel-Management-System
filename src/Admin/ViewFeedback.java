package Admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class ViewFeedback implements ActionListener {

	String admin;
	Connection con;
	JFrame frame;
	JTable Result;
	JButton backButton;
	JLabel logo_label,h;
	Icon logo_image;
	DefaultTableModel model;
	
	public ViewFeedback(Connection con, String Admin)
	{
		
		this.con = con;
		this.admin = Admin;
		frame = new JFrame();
		backButton = new JButton("Return");
		int i=0;
		
		model = new DefaultTableModel(){
			
			private static final long serialVersionUID = 1L;
			String column[] = {"CustId","Rating/5","Feedback"};
			
			@Override
			public int getColumnCount() {
				return 4;
			}
			@Override
			public boolean isCellEditable(int arg0, int arg1) {
					return false;
			}
			
			@Override
			public void addColumn(Object arg0) {
				super.addColumn(arg0);
			}
			@Override
			public void addRow(Object[] arg0) {
				// TODO Auto-generated method stub
				super.addRow(arg0);
			}
			
		};
		
		//Result = new JTable(model);
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
		

		h = new JLabel("Feedbacks");
		Font f= new Font("Amandella Script",Font.BOLD,100);
		h.setFont(f);
	    h.setForeground(Color.WHITE);
		h.setBounds(140,50,900,100);
		frame.add(h);	
		
		model.addColumn("SNo");
		model.addColumn("Customer ID");
		model.addColumn("Rating");
		model.addColumn("Comments");
		
		
		
		backButton.setBounds(10, 10, 100, 35);
		backButton.addActionListener(this);
		fillTable();
		
	
		Result = new JTable(model);	
		
		//Result.setBounds(100,256,1200,450);
		//frame.add(Result);
		frame.add(backButton);
		
		TableColumn tc = Result.getColumnModel().getColumn(0);
		tc.setHeaderValue(" ");
		tc = Result.getColumnModel().getColumn(1);
		tc.setHeaderValue("Customer ID");
		tc = Result.getColumnModel().getColumn(2);
		tc.setHeaderValue("Rating ");
		tc = Result.getColumnModel().getColumn(3);
		tc.setHeaderValue("Comments ");
		
		JScrollPane P = new JScrollPane(Result);
		P.setBounds(100,256,1200,450);
		frame.add(P);
				
		Result.getColumnModel().getColumn(1).setPreferredWidth(70);
		Result.getColumnModel().getColumn(1).setPreferredWidth(200);
		Result.getColumnModel().getColumn(2).setPreferredWidth(70);
		Result.getColumnModel().getColumn(3).setPreferredWidth(840);
		Result.repaint();
		
		frame.getContentPane().setBackground(Color.decode("#1A242A"));
		frame.setVisible(true);
	}
	
	
	public void fillTable()
	{
		PreparedStatement P;
		try {
			P = con.prepareStatement("Select * from CustomerFeedback");
			ResultSet Rs = P.executeQuery();
			//Result.getColumnName(1);
			Object[] a = new Object[4];
			
			int i=0;
			while(Rs.next())
			{
				a[0] = new Integer(i+1);
				a[1] = Rs.getString(1);
				a[2] = new Integer(Rs.getInt(2));
				a[3] = Rs.getString(3);
				model.addRow(a);
				i++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this.frame, e.getMessage());
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