package Employee;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Admin.WelcomePage;
import Beans.Customer;
import DAO.CustomerImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class MainPage implements ActionListener {

	private JFrame frame;
	JLabel logo_label;
	ImageIcon logo_image,image;
	JButton btnViewButton,btnEditCustomer,btnAddCustomer,btnDeleteCustomer ,btnCheckIn, btnCheckOut, btnViewRooms, btnChangePassword,btnLogOut ;
	String EmpId;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public MainPage(String EmpId) {
		this.EmpId=EmpId;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1366, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Color C = Color.decode("#1A242A");
		frame.getContentPane().setBackground(C);
		
		logo_image = new ImageIcon("Capture5 - Copy.PNG");
		logo_label = new JLabel(logo_image);
		logo_label.setBounds(1000, 0, 366, 156);
		frame.getContentPane().add(logo_label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(40, 206, 215, 397);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(C);
		
		btnViewButton = new JButton("View Customer");
		btnViewButton.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		btnViewButton.setBounds(21, 142, 170, 44);
		panel_1.add(btnViewButton);
		btnViewButton.addActionListener(this);
		
		btnEditCustomer = new JButton("Edit Customer");
		btnEditCustomer.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		btnEditCustomer.setBounds(21, 238, 170, 44);
		panel_1.add(btnEditCustomer);
		btnEditCustomer.addActionListener(this);
		
		btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		btnAddCustomer.setBounds(21, 56, 170, 44);
		panel_1.add(btnAddCustomer);
		btnAddCustomer.addActionListener(this);
		
		btnDeleteCustomer = new JButton("Delete Customer");
		btnDeleteCustomer.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		btnDeleteCustomer.setBounds(21, 325, 170, 50);
		panel_1.add(btnDeleteCustomer);
		btnDeleteCustomer.addActionListener(this);
		
		image=new ImageIcon("hotel.jpg");
		JLabel j=new JLabel(image);
		j.setBounds(285,220,785,363);
		
		frame.add(j);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(1103, 206, 215, 397);
		panel.setBackground(C);
		frame.getContentPane().add(panel);
		
		btnCheckIn = new JButton("Check In");
		btnCheckIn.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		btnCheckIn.setBounds(26, 142, 170, 47);
		panel.add(btnCheckIn);
		btnCheckIn.addActionListener(this);
		
		btnCheckOut = new JButton("Check Out");
		btnCheckOut.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		btnCheckOut.setBounds(26, 238, 170, 47);
		panel.add(btnCheckOut);
		btnCheckOut.addActionListener(this);
		
		btnViewRooms = new JButton("View Rooms");
		btnViewRooms.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		btnViewRooms.setBounds(21, 56, 170, 47);
		panel.add(btnViewRooms);
		btnViewRooms.addActionListener(this);
		
		btnChangePassword = new JButton("Change Password");
		btnChangePassword.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		btnChangePassword.setBounds(480, 620, 190, 30);
		frame.add(btnChangePassword);
		btnChangePassword.addActionListener(this);
		
		btnLogOut = new JButton("Logout");
		btnLogOut.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		btnLogOut.setBounds(690, 620, 190, 30);
		frame.add(btnLogOut);
		btnLogOut.addActionListener(this);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(265, 206, 801, 397);
		frame.getContentPane().add(panel_2);
		
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== btnAddCustomer){
			AddCustomer ac= new AddCustomer(EmpId);
		}
		
		if(e.getSource()== btnViewButton){
			String s = JOptionPane.showInputDialog("Enter Customer Id");
			CustomerImpl c = new CustomerImpl();
			Customer customer;
			try {
				customer = c.viewCustomer(s);
				ViewCustomer v = new ViewCustomer(customer);
			} catch (ClassNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		}
		if(e.getSource()== btnEditCustomer){
			String s = JOptionPane.showInputDialog("Enter Customer Id");
			CustomerImpl c = new CustomerImpl();
			Customer customer;
			try {
				customer = c.viewCustomer(s);
				EditCustomer ec=new EditCustomer(s, customer);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		if(e.getSource()== btnDeleteCustomer){
			String s = JOptionPane.showInputDialog("Enter Customer Id");
			CustomerImpl c = new CustomerImpl();
			Customer customer;
			try {
				customer = c.viewCustomer(s);
				DeleteCustomer dc = new DeleteCustomer(s,customer);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		
		if(e.getSource()== btnCheckIn){
			String s = JOptionPane.showInputDialog("Enter Booking Id");
			try {
				CheckIn c = new CheckIn(s);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/*ResultSet rs=null;
			try {
				PreparedStatement psmt = con.prepareStatement("Select * from CustomerDetails where CustomerId='"+s+"'");
				rs = psmt.executeQuery();
				rs.next();
				BookingDetails bd = new BookingDetails(s);
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}*/
		}
		if(e.getSource()== btnCheckOut){
			String id = JOptionPane.showInputDialog("Enter Booking Id");
			try {
				CheckOut c = new CheckOut(id);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		if(e.getSource()== btnViewRooms){
			ViewRooms vr = new ViewRooms(EmpId);
		}
		
		
		if(e.getSource()== btnChangePassword){
			ChangePassword cp= new ChangePassword(EmpId);
		}
		if(e.getSource()== btnLogOut){
			WelcomePage w=new WelcomePage();
			
			frame.dispose();
		}
		
	}
	public static void main(String s[]){
		MainPage mp = new MainPage("01");
	}
}
