package DatabaseWork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
	Connection con;
	public void updatePassword(String newPassword,String oldPassword,String loginId) throws ClassNotFoundException, SQLException{
		EmployeeFetch ef= new EmployeeFetch();
		this.con=ef.getConnection();
		
		PreparedStatement ps =con.prepareStatement("update EmployeeDetails  set Password='"+newPassword+"' where (Password='"+oldPassword+"' and EmployeeId='"+loginId+"')");
		ps.executeUpdate();
	}
}
