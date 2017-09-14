package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Beans.Admin;
import Main.Start;

public class AdminImpl implements AdminInterface {

	public int changePassword(String adminName,String oldPassword,String newPassword,String reEnteredPassword) throws ClassNotFoundException, SQLException {
		Connection con=new Start().getConnection();
		
		if(newPassword.equals(reEnteredPassword)){
			PreparedStatement ps =con.prepareStatement("update EmployeeDetails  set Password='"+newPassword+"' where (Password='"+oldPassword+"' and EmployeeId='"+adminName+"')");
			return ps.executeUpdate();
		}
		
		return 2;
	}

	public int addAdmin(Admin admin) throws ClassNotFoundException, SQLException {
		Connection con=new Start().getConnection();
		
		PreparedStatement psmt=con.prepareStatement("insert into AdminDetail values(?,?)");
		psmt.setString(1, admin.getAdminName() );
		psmt.setString(2, admin.getPassword());
		
		return psmt.executeUpdate();
	}

}
