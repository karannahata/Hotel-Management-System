package Employee;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Beans.BookingDetail;
import Beans.Customer;
import DAO.BookingDetailImpl;
import DAO.CustomerImpl;
import DAO.RoomImpl;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class CheckIn implements ActionListener {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	String bookingId;
	JButton btnBook,btnCancel;
	ArrayList<Integer> rooms;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckIn window = new CheckIn();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public CheckIn(String bookingId) throws ClassNotFoundException, SQLException {
		this.bookingId=bookingId;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		BookingDetailImpl bdi = new BookingDetailImpl();
		BookingDetail detail=bdi.viewBooking(bookingId);
		CustomerImpl cdi= new CustomerImpl();
		Customer customer=cdi.viewCustomer(detail.getCustomerId());
		rooms = bdi.getRooms(bookingId);
		int i=0;
		String room=null;
		while(i<rooms.size()){
			room+=rooms.get(i);
		}
		
		JLabel lblNewLabel = new JLabel("Customer Id");
		lblNewLabel.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		lblNewLabel.setBounds(36, 81, 116, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Customer Name");
		lblNewLabel_1.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		lblNewLabel_1.setBounds(36, 119, 132, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblRoomNo = new JLabel("Room no.");
		lblRoomNo.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		lblRoomNo.setBounds(36, 156, 92, 14);
		frame.getContentPane().add(lblRoomNo);
		
		textField = new JTextField();
		textField.setText(detail.getCustomerId());
		textField.setBounds(172, 78, 169, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText(customer.getCustomerName());
		textField_1.setBounds(172, 116, 169, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText(room);
		textField_2.setColumns(10);
		textField_2.setBounds(172, 153, 169, 20);
		frame.getContentPane().add(textField_2);
		
		btnBook = new JButton("Book");
		btnBook.setBounds(96, 211, 89, 23);
		frame.getContentPane().add(btnBook);
		btnBook.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(216, 211, 89, 23);
		frame.getContentPane().add(btnCancel);
		btnCancel.addActionListener(this);
		
		JLabel lblCheckIn = new JLabel("Check In");
		lblCheckIn.setFont(new Font("Perpetua Titling MT", Font.BOLD, 18));
		lblCheckIn.setBounds(156, 24, 132, 26);
		frame.getContentPane().add(lblCheckIn);
		
		frame.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBook){
			RoomImpl ri = new RoomImpl();
			int i=0;
			while(i<rooms.size()){
				try {
					ri.setAvailability(rooms.get(i), 0);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				i++;
			}
			frame.dispose();
		}
		
	}
}
