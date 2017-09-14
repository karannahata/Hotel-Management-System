package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import Beans.BookingDetail;
import Beans.Room;

public interface BookingDetailInterface {
	public void insertBooking(ArrayList<Room> rooms,BookingDetail detail) throws SQLException, ClassNotFoundException;
	public int deleteBooking(String bookingId) throws SQLException, ClassNotFoundException;
	public BookingDetail viewBooking(String bookingId) throws SQLException, ClassNotFoundException;
	public ArrayList<Integer> getRooms(String bookingId)throws SQLException, ClassNotFoundException;
	String generateId() throws SQLException, ClassNotFoundException;
	
	//public int getFare(ArrayList<Integer> rooms)throws SQLException, ClassNotFoundException;
	
}
