package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.Customer;

public interface CustomerInterface {
	public int addCustomer(Customer customer) throws SQLException, ClassNotFoundException;
	public int deleteCustomer(String loginId) throws ClassNotFoundException, SQLException;
	public int editCustomer(String loginId,Customer customer) throws ClassNotFoundException, SQLException;
	public int changePassowrd(String loginId,String oldPassword,String newPassword,String reEnteredPassword) throws ClassNotFoundException, SQLException;
	public int customerSignup(Customer customer) throws ClassNotFoundException, SQLException;
	public int forgotPassword(String loginId,String sQuestion,String sAnswer) throws ClassNotFoundException, SQLException;
	public ResultSet viewAllCustomer() throws ClassNotFoundException, SQLException;
	public Customer viewCustomer(String customerId) throws ClassNotFoundException, SQLException;
	//public int loginIn(String loginId,String password) throws ClassNotFoundException, SQLException;
	public Customer fetchCustomer(String loginId) throws ClassNotFoundException, SQLException;
}
