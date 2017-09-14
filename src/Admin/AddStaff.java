package Admin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

//import Welcome.SwitchRes;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;


public class AddStaff implements ActionListener{

	JFrame frame;
	Icon logo_image;
	JLabel logo_label;
	JLabel empidLabel,nameLabel, emailLabel, genderLabel, addrLabel, adharcardNumberLabel , phoneNumberLabel, dobLabel;
	JTextField nameField, emailField, addrField, adharcardField, phoneNumberField;
	JButton doneButton, backButton, resetButton;
	JRadioButton maleButton,femaleButton,otherGenderButton;
	//JComboBox dateBox,monthBox,yearBox;
	
	String gender;
	Date date;
	JLabel empIDLabel,pincodeLabel,ImageFile;
	JTextField empIDField,pincodeField;
	
	JFileChooser myFileChooser;
	JButton chooseAnImage;
	
	SwitchRes Sr = new SwitchRes();
	
	Font f1;
	
	File file;
	FileInputStream fis;
	
	JDatePickerImpl datePickerImpl;
	JDatePanelImpl datePanelImpl;
	UtilDateModel model;
	int returnval;
	Connection con;
	String admin;
	public Integer generateID()
	{
		//get from database and check the LAST ID. whichever ID it is. increment it.
		return new Integer(12);
	}
	public AddStaff(Connection con,String admin)
	{
		this.admin = admin;
		frame = new JFrame();
		this.con = con;
		model = new UtilDateModel();
		datePanelImpl = new JDatePanelImpl(model);
		datePickerImpl = new JDatePickerImpl(datePanelImpl);
		
		empidLabel = new JLabel("Employee Id: ");
		nameLabel = new JLabel("Name :");
		emailLabel = new JLabel("Email :");
		genderLabel = new JLabel("Sex :");
		addrLabel = new JLabel("Address :");
		adharcardNumberLabel = new JLabel("Adhaar Card Number :");
		phoneNumberLabel = new JLabel("Phone number :");
		dobLabel = new JLabel("Date of Birth :");
		empIDLabel = new JLabel("Employee ID :");
		pincodeLabel = new JLabel("Pincode :");
		ImageFile = new JLabel();
		
		nameField = new JTextField();
		emailField = new JTextField();
		addrField = new JTextField();
		adharcardField = new JTextField();
		phoneNumberField = new JTextField();
		pincodeField = new JTextField();
		empIDField = new JTextField();
		
		doneButton = new JButton("Done");
		resetButton = new JButton("Reset");
		backButton = new JButton("Return");
		chooseAnImage = new JButton("Choose an Image :");
		
		maleButton = new JRadioButton(" Male");
		femaleButton = new JRadioButton(" Female");
		otherGenderButton = new JRadioButton(" Other");
		
		
		createFrame();
	}	
	
	public void createFrame()
	{
		f1 = new Font("Ariel",Font.BOLD,20);
		frame.setLayout(null);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setSize(1366, 768);
		frame.setResizable(true);
		frame.setTitle("Staff Admission");
		
		logo_image = new ImageIcon("Capture5 - copy.PNG");
		logo_label = new JLabel(logo_image);
		logo_label.setBounds(1000, 10,366, 156);
		frame.add(logo_label);
		backButton.setBounds(10, 10, 100, 30);
		frame.add(backButton);	
		
		int ybase = 142; //180
		int incrY = 57;  //80
		int xbase = 213; //300
		
				
		nameLabel.setBounds(213,ybase,213,35);
		emailLabel.setBounds(213,ybase+(incrY),213,35);
		genderLabel.setBounds(213,ybase+(2*incrY),21300,35);
		dobLabel.setBounds(213,ybase+(3*incrY),213,35);
		addrLabel.setBounds(213,ybase+(4*incrY),213,35);
		pincodeLabel.setBounds(213,ybase+(5*incrY),213,35);
		empIDLabel.setBounds(213,ybase-incrY,213,35);
		phoneNumberLabel.setBounds(213,ybase+(6*incrY),213,35);
		adharcardNumberLabel.setBounds(213,ybase+(7*incrY),213,35);
		chooseAnImage.setBounds(746, ybase,213, 28); 
		chooseAnImage.setFont(f1);
		frame.add(chooseAnImage);
		
		ImageFile.setBounds(746,ybase+incrY,340,384);
		
		nameLabel.setFont(f1);
		emailLabel.setFont(f1);
		genderLabel.setFont(f1);
		dobLabel.setFont(f1);
		addrLabel.setFont(f1);
		pincodeLabel.setFont(f1);
		empIDLabel.setFont(f1);
		phoneNumberLabel.setFont(f1);
		adharcardNumberLabel.setFont(f1);
		
		
		frame.add(nameLabel);
		frame.add(emailLabel);
		frame.add(dobLabel);
		frame.add(genderLabel);
		frame.add(addrLabel);
		frame.add(pincodeLabel);
		frame.add(empIDLabel);
		frame.add(adharcardNumberLabel);
		frame.add(phoneNumberLabel);
		
		ButtonGroup Genders = new ButtonGroup();
		maleButton.setBounds(426,256,71,30);
		femaleButton.setBounds(498,256,71,30);
		otherGenderButton.setBounds(569,256,71,30);
		//maleButton.setFont(f1);
		//femaleButton.setFont(f1);
		//otherGenderButton.setFont(f1);
		Genders.add(maleButton);
		Genders.add(femaleButton);
		Genders.add(otherGenderButton);
		frame.add(maleButton);
		frame.add(femaleButton);
		frame.add(otherGenderButton);
		
		
		nameField.setBounds(426,142,142,35);
		frame.add(nameField);
		emailField.setBounds(426,200,142,35);
		frame.add(emailField);
		
		//date
		
		datePickerImpl.setBounds(426,314,142,35);
		frame.add(datePickerImpl);
		/*Integer date[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
		dateBox = new JComboBox(date);
		dateBox.setBounds(600,440,100,50);
		
		String month[] = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
		monthBox = new JComboBox(month);
		monthBox.setBounds(700,440,100,50);
		
		yearBox = new JComboBox();
		for(int i=1950; i<1999; i++)
		{
			yearBox.addItem(new Integer(i));
		}
		yearBox.setBounds(800,440,100,50);
		frame.add(dateBox);
		frame.add(monthBox);
		frame.add(yearBox);
		*/
		addrField.setBounds(426,371,142,35);
		frame.add(addrField);
		pincodeField.setBounds(426,426,142,35);
		frame.add(pincodeField);
		
		empIDField.setBounds(426,87,142,35);
		empIDField.setEditable(false);
		empIDField.setText(generateID().toString());
		frame.add(empIDField);
		
		adharcardField.setBounds(426,542,142,35);
		frame.add(adharcardField);
		phoneNumberField.setBounds(426,485,142,35);
		frame.add(phoneNumberField);
		
		doneButton.setBounds(213,600,142,35);
		resetButton.setBounds(426,600, 142, 35);
		doneButton.setFont(f1);
		resetButton.setFont(f1);
		
		frame.add(doneButton);
		frame.add(resetButton);
		frame.add(chooseAnImage);
		//myFileChooser.setBounds(1050,280,50,50);
		
		frame.add(ImageFile);
		
		frame.setVisible(true);
		
	
		doneButton.addActionListener(this);
		resetButton.addActionListener(this);
		chooseAnImage.addActionListener(this);
		backButton.addActionListener(this);
	}
	

	@Override
	public void actionPerformed(ActionEvent Ae) {
		// TODO Auto-generated method stub
		if(Ae.getSource()==doneButton)
		{
			try {
				if(this.maleButton.isSelected())
					gender ="M";
				else if(this.femaleButton.isSelected())
					gender = "F";
				else
					gender = "Other";
				
				date = model.getValue();
				DateFormat X = new SimpleDateFormat("dd/MM/yyyy");
				String $date = ""+X.format(date);
				
				Connection con = new AcquireConnection().acquireConnection();
				String insert = "insert into EmployeeDetails values('"+this.empIDField.getText()+"','"+this.nameField.getText()+"','"+this.gender+"','"+this.addrField.getText()+"','"+this.pincodeField.getText()+"','"+$date+"','"+this.emailField.getText()+"','123456','"+this.phoneNumberField.getText() +"',?)";
				PreparedStatement P = con.prepareStatement(insert);
				fis = new FileInputStream(file);
				P.setBinaryStream(1,fis,(int)file.length());
				P.execute();
				
				new JOptionPane().showMessageDialog(frame, "A Record added successfully");
				this.frame.setVisible(false);
				new AdminHome(con,admin).frame.setVisible(true);
			} catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this.frame, e.getMessage());
			}	
		}
		
		if(Ae.getSource() == chooseAnImage)
		{
			myFileChooser = new JFileChooser("F:/Here");
			frame.add(myFileChooser);
			returnval = myFileChooser.showOpenDialog(frame);
			if(returnval == JFileChooser.APPROVE_OPTION)
			{
				file = myFileChooser.getSelectedFile();
				Icon temp = new ImageIcon(file.getAbsolutePath());
				ImageFile.setIcon(temp); 	
			}
			else
			{
				//show up message dialog to choose an image
			}
		}
		
		if(Ae.getSource() == this.backButton)
		{
			this.frame.setVisible(false);
			new AdminHome(con,admin).frame.setVisible(true);;
		}
	}
}



