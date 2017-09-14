package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.CustomerFeedback;
import Main.Start;

public class CustomerFeedbackImpl implements CustomerFeedbackInterface{
	public ResultSet viewAllFeedback() throws ClassNotFoundException, SQLException {
		Connection con=new Start().getConnection();
		PreparedStatement psmt =con.prepareStatement("Select * from CustomerDetails");
		return psmt.executeQuery();
		
	}

	public int getFeedback(CustomerFeedback feedback) throws ClassNotFoundException, SQLException {
		Connection con=new Start().getConnection();
		PreparedStatement psmt =con.prepareStatement("insert into CustomerFeedback values(?,?,?)");
		psmt.setString(1, feedback.getCustomerId());
		psmt.setInt(2, feedback.getRating());
		psmt.setString(3,feedback.getFeedback());
		
		return psmt.executeUpdate();
	}

}
