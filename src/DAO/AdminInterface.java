package DAO;

import java.sql.SQLException;

import Beans.Admin;

public interface AdminInterface {
	public int changePassword(String adminName,String oldPassword,String newPassword,String reEnteredPassword) throws ClassNotFoundException, SQLException;
	public int addAdmin(Admin admin) throws ClassNotFoundException, SQLException;
}
