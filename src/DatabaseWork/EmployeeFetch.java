package DatabaseWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeFetch {
	static Connection con;
	public static void setConnection() throws ClassNotFoundException, SQLException{
		String ur1="jdbc:oracle:thin:@localhost:1521:xe";
		String user="SYSTEM";
		String pwd="karan01";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con= DriverManager.getConnection(ur1, user, pwd);
	}
	
	public ResultSet getData(String loginId) throws ClassNotFoundException, SQLException{
		PreparedStatement ps =con.prepareStatement("select Password from EmployeeDetails where EmployeeId='"+loginId+"'");
		ResultSet rs = ps.executeQuery();
		return rs;
		
	}
	public Connection getConnection(){
		return con;
	}
}
