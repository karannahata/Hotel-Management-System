package DatabaseWork;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDatabase {
	public static void main(String ag[]) throws ClassNotFoundException, SQLException{
		String ur1="jdbc:oracle:thin:@localhost:1521:xe";
		String user="SYSTEM";
		String pwd="karan01";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con= DriverManager.getConnection(ur1, user, pwd);
		
		PreparedStatement psmt=con.prepareStatement("insert into CUSTOMERINFO values('Shreya','F','Sector-18 Rohini',110085,'','shreya.khana123@gmail.com',9818578706,515545545454,'shreya01')");
		boolean b =psmt.execute();
		System.out.println("inserted");
		
		/*String id = generateId(con);
		System.out.println(id);*/
		
	}
	
	public void deleteCustomer(String CustomerId,Connection con) throws SQLException{
		PreparedStatement psmt=con.prepareStatement("Delete from CustomerDetails where CustomerId='"+CustomerId+"'");
		psmt.execute();
	}
	
	
	public void addCustomer(String name, String gender, String address, String pincode, String email, String phone, String aadhar ,Connection con) throws ClassNotFoundException, SQLException {
		String id = generateId(con);
		PreparedStatement psmt=con.prepareStatement("insert into CustomerDetails values('"+id+"','"+name+"','"+gender+"','"+address+"','"+pincode+"','','"+email+"','"+phone+"','','','','','"+aadhar+"')");
		//PreparedStatement psmt=con.prepareStatement("insert into CustomerDetails values('cust04','Shreya','F','rohini',123654,'','shreya@.com',1236547899,'','','','',12365478899)");
		
		boolean b=psmt.execute();
	}
	
	
	public static String generateId(Connection con) throws SQLException{
		String id=null;
		PreparedStatement psmt1=con.prepareStatement("select * from CustomerDetails where CustomerId=(Select Max(CustomerId) from CustomerDetails)" );
		ResultSet rs = psmt1.executeQuery();
		rs.next();
		id=rs.getString(1);
		int lindex=id.length();
		int i = Integer.parseInt((String) id.subSequence(lindex-2, lindex));
		i++;
		id=id.substring(0,lindex-2)+i;
		return id;
	}

	public void editCustomer(String loginId,String name, String gender, String address, String pincode, String email, String phone, String aadhar, Connection con) throws SQLException {
		// TODO Auto-generated method stub
		deleteCustomer(loginId, con);
		System.out.println("deleted");
		PreparedStatement psmt=con.prepareStatement("insert into CustomerDetails values('"+loginId+"','"+name+"','"+gender+"','"+address+"','"+pincode+"','','"+email+"','"+phone+"','','','','','"+aadhar+"')");
		boolean b=psmt.execute();
	}
	
}
