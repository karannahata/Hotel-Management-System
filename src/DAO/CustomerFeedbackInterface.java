package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.CustomerFeedback;

public interface CustomerFeedbackInterface {
	public int getFeedback(CustomerFeedback feedback) throws ClassNotFoundException, SQLException;
	public ResultSet viewAllFeedback() throws ClassNotFoundException, SQLException;
}
