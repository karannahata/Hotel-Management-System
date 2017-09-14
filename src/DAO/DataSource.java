package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	
	public Connection getDBConnection() throws SQLException,ClassNotFoundException
	{
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="system";
		String pwd="karan01";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(url,user,pwd);
	}
}
