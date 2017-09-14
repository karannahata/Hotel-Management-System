
package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Beans.BookingDetail;
import Beans.Room;
import Main.Start;

public class BookingDetailImpl implements BookingDetailInterface
{
	
	public void insertBooking(ArrayList<Room> rooms,BookingDetail detail) throws SQLException, ClassNotFoundException {
		Connection con=new Start().getConnection();
		int i=0;
		while(i<rooms.size()){
			PreparedStatement psmt =con.prepareStatement("insert into bookingdetail(?,?,?,?,?,?,?,?)");
			psmt.setInt(1, rooms.get(i).getRoomNumber());
			psmt.setDate(2, (Date) detail.getCheckIn());
			psmt.setDate(3, (Date) detail.getCheckOut());
			psmt.setString(4, detail.getCustomerloginId());
			psmt.setString(5, detail.getBookingId());
			psmt.setInt(6, detail.getPayment());
			psmt.setString(7, detail.getCustomerId());
			psmt.setInt(8, detail.getMeal());
			i++;
		}	
	}
	public int deleteBooking(String bookingId) throws SQLException, ClassNotFoundException 
	{
		Connection con=new Start().getConnection();
		PreparedStatement psmt =con.prepareStatement("delete from bookingdetail where bookingId='"+bookingId+"'");
		return psmt.executeUpdate();
	}

	@Override
	public BookingDetail viewBooking(String loginid) throws SQLException, ClassNotFoundException 
	{
		Connection con=new Start().getConnection();
		//ArrayList<BookingDetail> details = new ArrayList<BookingDetail>();
		PreparedStatement psmt =con.prepareStatement("select * from bookingdetail where loginid='"+loginid+"'");
		ResultSet rs = psmt.executeQuery();
		BookingDetail detail=new BookingDetail();
		while(rs.next()){
			detail.setRoomNumber(rs.getInt(1));
			detail.setCheckIn(rs.getDate(2));
			detail.setCheckOut(rs.getDate(3));
			detail.setCustomerloginId(rs.getString(4));
			detail.setBookingId(rs.getString(5));
			detail.setPayment(rs.getInt(6));
			detail.setCustomerId(rs.getString(7));
			//detail.setMeal(rs.getInt(8));
			//details.add(detail);
		}
		return detail;
	}
	
	//return the booked rooms under 1 booking ID
	public ArrayList<Integer> getRooms(String bookingId) throws SQLException, ClassNotFoundException 
	{
		Connection con=new Start().getConnection();
		ArrayList<Integer> roomNumber=  new ArrayList<Integer>();
		PreparedStatement psmt = con.prepareStatement("select roomnumber from bookingdetail where bookingid='"+bookingId+"'");
		ResultSet rs = psmt.executeQuery();
		
		while(rs.next()){
			roomNumber.add(rs.getInt(1));
		}	
		return roomNumber;
	}
	
	//return the total fare of all the rooms
	public int getFare(ArrayList<Integer> rooms) throws SQLException, ClassNotFoundException 
	{
		Connection con = new Start().getConnection();
		PreparedStatement psmt;
		int i=0;
		int fare=0;
		while(i<rooms.size())
		{
			psmt=con.prepareStatement("select roomfare from room where roomnumber='"+rooms.get(i)+"'");
			ResultSet rs = psmt.executeQuery();
			rs.next();
			fare+=rs.getInt(1);
			i++;
		}
		return fare;
	}
	
	@Override
	public String generateId() throws SQLException, ClassNotFoundException
	{
		String id=null;
		Connection con = new Start().getConnection();
		PreparedStatement psmt1=con.prepareStatement("select bookingid from BookingDetail where bookingId=(Select Max(bookingId) from BookingDetail)" );
		ResultSet rs = psmt1.executeQuery();
		rs.next();
		id=rs.getString(1);
		int lindex=id.length();
		int i = Integer.parseInt((String) id.subSequence(4, lindex));
		i++;
		id=id.substring(0,4)+i;
		return id;
	}
		

}
