package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.Customer;
import Main.Start;

public class CustomerImpl implements CustomerInterface {
	
	Connection con;

	public int addCustomer(Customer customer) throws SQLException, ClassNotFoundException {
		con=new Start().getConnection();
		
		//String id = generateId();
		
		PreparedStatement psmt=con.prepareStatement("insert into CustomerDetails(CustomerId,Name,Gender,Address,pincode,dob,email,phonenumber,aadharnumber) values(?,?,?,?,?,?,?,?,?)");
		
		//psmt.setString(1, id);
		psmt.setString(2, customer.getCustomerName());
		psmt.setString(3, customer.getGender());
		psmt.setString(4, customer.getAddress());
		psmt.setString(5, customer.getPinCode());
		psmt.setDate(6, (Date) customer.getDob());
		psmt.setString(7, customer.getEmailId());
		psmt.setString(8, customer.getPhoneNumber());
		psmt.setString(13,customer.getAadharNumber());
		
		return psmt.executeUpdate();
	}
	
	public int custlogin(String loginid,String password) throws SQLException, ClassNotFoundException
	{con=new Start().getConnection();
	
	PreparedStatement psmt=con.prepareStatement("Select * from CustomerDetails where login=? and password=?");
	psmt.setString(1,loginid);
	psmt.setString(2,password);
	ResultSet rs=psmt.executeQuery();
	if(rs.next())
	{
		return 1;
	}
	else return 0;
	}

	public int deleteCustomer(String loginId) throws ClassNotFoundException, SQLException {
		con=new Start().getConnection();
		
		PreparedStatement psmt=con.prepareStatement("Delete from CustomerDetails where CustomerId='"+loginId+"'");
		
		return psmt.executeUpdate();
	}
	
	

	public String namefetch(String loginid) throws ClassNotFoundException,SQLException
	{
		con=new Start().getConnection();
	try
	 {PreparedStatement ps;
	 
	   ps= con.prepareStatement("select NAME from CUSTOMERDETAILS where (LOGIN='"+loginid+"')");
   
	//customerlogin.setString(1,t1.getText());
   //customerlogin.setString(2,new String(p.getPassword()));
  ResultSet rs;
      rs=ps.executeQuery();
    
      if(rs.next())
       {
   	   return rs.getString(1);   
       }
   
	 }
     

	   catch(Exception e)
     {
	    e.printStackTrace();
     }
		
	return null;
		
	}
	
	public int editCustomerdetails(String loginId,String address,String phnno,String pin,String email) throws ClassNotFoundException, SQLException {
		
		con=new Start().getConnection();
		PreparedStatement psmt=con.prepareStatement("update CustomerDetails set address=?,pinCode=?,email=?,PhoneNumber=?  where LOGIN='"+loginId+"'");
		

		psmt.setString(1,address);
		psmt.setString(2,pin);
		psmt.setString(3,email);
		psmt.setString(4,phnno);
		
		
		return psmt.executeUpdate();
	}
	
	
	public int editCustomer(String loginId, Customer customer) throws ClassNotFoundException, SQLException {
		con=new Start().getConnection();
		PreparedStatement psmt=con.prepareStatement("update CustomerDetails set Name=?,gender=?,address=?,pinCode=?,email=?,PhoneNumber=?,AadharNumber=?  where CustomerId='"+loginId+"'");
		

		psmt.setString(1, customer.getCustomerName());
		psmt.setString(2, customer.getGender());
		psmt.setString(3, customer.getAddress());
		psmt.setString(4, customer.getPinCode());
		//psmt.setDate(6, arg1);
		psmt.setString(5, customer.getEmailId());
		psmt.setString(6, customer.getPhoneNumber());
		psmt.setString(7, customer.getAadharNumber());
		
		return psmt.executeUpdate();
	}
	
	public int resetPassword(String newPassword,String reenter,String loginid)throws Exception
	{
		con=new Start().getConnection();
		PreparedStatement ps;
		
		if(newPassword.equals(reenter)){
		try {
			ps = con.prepareStatement("update CUSTOMERDETAILS set PASSWORD=? where LOGIN=?");
			ps.setString(1,newPassword);
			ps.setString(2,loginid);
			ps.executeUpdate();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
		}
		else
		{
			return 0;
		}
	}

	public int changePassowrd(String loginId, String oldPassword, String newPassword, String reEnteredPassword) throws ClassNotFoundException, SQLException {
		con=new Start().getConnection();
		System.out.println(oldPassword+" "+newPassword+" "+loginId);
		if(newPassword.equals(reEnteredPassword)){
			PreparedStatement ps =con.prepareStatement("update CustomerDetails  set Password='"+newPassword+"' where (Password='"+oldPassword+"' and LOGIN='"+loginId+"')");
			return ps.executeUpdate();
		}
		
		return 2;
	}

	public int customerSignup(Customer customer) throws ClassNotFoundException, SQLException {
		con=new Start().getConnection();
		String id = generateId();
		
		PreparedStatement psmt=con.prepareStatement(" insert into CUSTOMERdetails(NAME,LOGIN,PASSWORD,EMAIL,PHONENumber,SQUESTION,SANSWER,GENDER,DOB,ADDRESS,PINCODE,AADHARNUMBER,CUSTOMERID)"
		        + " values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
 java.util.Date dob1=customer.getDob();
		java.sql.Date d=new java.sql.Date(dob1.getDate());
		
		psmt.setString(1, customer.getCustomerName());
		psmt.setString(2,customer.getLoginId());
		psmt.setString(3, customer.getPassword());
		psmt.setString(4, customer.getEmailId());
		psmt.setString(5, customer.getPhoneNumber());
		psmt.setString(6, customer.getSecurityQuestion());
		psmt.setString(7, customer.getSecurityAnswer());
		psmt.setString(8, customer.getGender());
		psmt.setDate(9,d);
		psmt.setString(10,customer.getAddress());
		psmt.setString(11,customer.getPinCode());
		psmt.setString(12,customer.getAadharNumber());
		psmt.setString(13,id);
		
		
		return psmt.executeUpdate();
	
	}

	public int forgotPassword(String loginId, String sQuestion, String sAnswer) throws ClassNotFoundException, SQLException {
		 con=new Start().getConnection();
		
		PreparedStatement psmt =con.prepareStatement("Select squestion,sanswer from CustomerDetails where login='"+loginId+"'");
		ResultSet rs=psmt.executeQuery();
		rs.next();
		if(sQuestion.equals(rs.getString(1))&&sAnswer.equals(rs.getString(2))){
			return 1;
		}
		return 0;
	}
	
	public ResultSet viewAllCustomer() throws ClassNotFoundException, SQLException {
		 con=new Start().getConnection();
		PreparedStatement psmt =con.prepareStatement("Select * from CustomerDetails");
		return psmt.executeQuery();
	}
	
	public String generateId() throws SQLException, ClassNotFoundException{
		String id=null;
		 con = new Start().getConnection();
		PreparedStatement psmt1=con.prepareStatement("select CustomerID from CustomerDetails");
		ResultSet rs = psmt1.executeQuery();
		while(!rs.isLast())
			rs.next();
		id=rs.getString(1);
		int lindex=id.length();
		int i = Integer.parseInt((String) id.subSequence(4, lindex));
		i++;
		id=id.substring(0,lindex-2)+i;
		return id;
	}

	public Customer viewCustomer(String customerId) throws ClassNotFoundException, SQLException {
		 con=new Start().getConnection();
		PreparedStatement psmt =con.prepareStatement("Select * from CustomerDetails where LOGIN='"+customerId+"'");
		ResultSet rs= psmt.executeQuery();
		rs.next();
		Customer customer = new Customer();
		customer.setCustomerName(rs.getString(2));
		customer.setAddress(rs.getString(4));
		customer.setGender(rs.getString(3));
		customer.setPinCode(rs.getString(5));
		customer.setEmailId(rs.getString(7));
		customer.setPhoneNumber(rs.getString(8));
		customer.setAadharNumber(rs.getString(13));
		return customer;
	}
	
	public Customer viewCustomerdetails(String customerId) throws ClassNotFoundException, SQLException {
		 con=new Start().getConnection();
		PreparedStatement psmt =con.prepareStatement("Select ADDRESS,EMAIL,PHONENUMBER,PINCODE from CustomerDetails where LOGIN='"+customerId+"'");
		ResultSet rs= psmt.executeQuery();
		rs.next();
		Customer customer = new Customer();
		
		customer.setAddress(rs.getString(1));
		
		customer.setPinCode(rs.getString(4));
		customer.setEmailId(rs.getString(2));
		customer.setPhoneNumber(rs.getString(3));
		
		return customer;
	}
	
	public Customer fetchCustomer(String loginId) throws ClassNotFoundException, SQLException {
		con=new Start().getConnection();
		PreparedStatement psmt =con.prepareStatement("Select * from CustomerDetails where login='"+loginId+"'");
		ResultSet rs= psmt.executeQuery();
		rs.next();
		Customer customer = new Customer();
		customer.setCustomerName(rs.getString(2));
		customer.setAddress(rs.getString(4));
		customer.setGender(rs.getString(3));
		customer.setPinCode(rs.getString(5));
		customer.setEmailId(rs.getString(7));
		customer.setPhoneNumber(rs.getString(8));
		customer.setAadharNumber(rs.getString(13));
		return customer;
	}
	

	
	}
