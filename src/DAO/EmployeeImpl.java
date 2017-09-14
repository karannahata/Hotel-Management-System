package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.Employee;
import Main.Start;

public class EmployeeImpl implements EmployeeInterface{

	public int addEmployees(Employee employee) throws ClassNotFoundException, SQLException {
		Connection con=new Start().getConnection();
		PreparedStatement psmt=con.prepareStatement("insert into CustomerDetails values(?,?,?,?,?,?,?,?)");
		
		psmt.setString(1, employee.getEmployeeId());
		psmt.setString(2, employee.getEmployeeName());
		psmt.setString(3, employee.getAddress());
		psmt.setString(4, employee.getGender());
		psmt.setString(5, employee.getPinCode());
		psmt.setString(6, employee.getEmailId());
		psmt.setString(7, employee.getPassword());
		psmt.setString(8, employee.getPhoneNumber());
		psmt.setDate(9, (Date) employee.getDob());
		
		return psmt.executeUpdate();
	}

	public int deleteEmployees(String loginId) throws ClassNotFoundException, SQLException {
		Connection con=new Start().getConnection();
		
		PreparedStatement psmt=con.prepareStatement("Delete from EmployeeDetails where EmployeeId='"+loginId+"'");
		
		return psmt.executeUpdate();
	}

	public ResultSet viewAllEmployees() throws ClassNotFoundException, SQLException {
		Connection con=new Start().getConnection();
		PreparedStatement psmt =con.prepareStatement("Select * from EmployeeDetails");
		return psmt.executeQuery();
	}

	public int changePassword(String loginId,String oldPassword,String newPassword,String reEnteredPassword) throws ClassNotFoundException, SQLException {
		Connection con=new Start().getConnection();
		if(newPassword.equals(reEnteredPassword)){
			PreparedStatement ps =con.prepareStatement("update EmployeeDetails  set Password='"+newPassword+"' where (Password='"+oldPassword+"' and EmployeeId='"+loginId+"')");
			return ps.executeUpdate();
		}
		return 2;
	}

	public int verifyPassword(String loginId, String password) throws ClassNotFoundException, SQLException {
		Connection con=new Start().getConnection();
		PreparedStatement ps =con.prepareStatement("select Password from EmployeeDetails where EmployeeId='"+loginId+"'");
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			if(password.equals(rs.getString(1)))
				return 1;
			else
				return 0;		
		}
		return 2;
	}

	
}
