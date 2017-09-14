package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.Employee;

public interface EmployeeInterface {
	public int addEmployees(Employee employee) throws ClassNotFoundException, SQLException;
	public int deleteEmployees(String loginId) throws ClassNotFoundException, SQLException;
	public ResultSet viewAllEmployees() throws ClassNotFoundException, SQLException;
	public int changePassword(String loginId,String oldPassword,String newPassword,String reEnteredPassword) throws ClassNotFoundException, SQLException ;
	public int verifyPassword(String loginId,String password) throws ClassNotFoundException, SQLException;
}
