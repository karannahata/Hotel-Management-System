package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Beans.Room;
import Customer.Bookavailable;
import Main.Start;

public class RoomImpl implements RoomInterface {

	@Override
	public int setAvailability(int roomNumber,int value) throws ClassNotFoundException, SQLException 
	{
		Connection con = new Start().getConnection();
		PreparedStatement psmt=con.prepareStatement("Update RoomDetails set roomavailability='"+value+"' where roomnumber='"+roomNumber+"'");
		
		return psmt.executeUpdate();
	}
	
	@Override
	public int getAvailability(int roomNumber)throws ClassNotFoundException, SQLException 
	{
		Connection con = new Start().getConnection();
		PreparedStatement psmt = con.prepareStatement("Select roomavailability from RoomDetails where roomnumber='"+roomNumber+"'");
		return psmt.executeUpdate();
	}
	
	@Override
	public int getReserved(int roomNumber) throws ClassNotFoundException, SQLException{
		Connection con = new Start().getConnection();
		PreparedStatement psmt = con.prepareStatement("Select roomreserved from RoomDetails where roomnumber='"+roomNumber+"'");
		return psmt.executeUpdate();
	}

	@Override
	public int setReserved(int roomNumber, int value) throws ClassNotFoundException, SQLException {
		Connection con = new Start().getConnection();
		PreparedStatement psmt=con.prepareStatement("Update RoomDetails set roomreserved='"+value+"' where roomnumber='"+roomNumber+"'");
		
		return psmt.executeUpdate();
	}

	
	
	@Override
	public int[] fetchcost()throws Exception
	{
		int cost[]=new int[5];
		Connection con = new Start().getConnection();
		for(int i=0;i<5;i++)
		{
		
			try
			{
			PreparedStatement p= con.prepareStatement("select ROOMFARE from ROOMDETAILS where ROOMTYPE='"+(i+1)+"'");
			ResultSet rs=p.executeQuery();
		    rs.next();
		    cost[i]=Integer.parseInt(rs.getString(1));
			}
			catch(Exception e)
		    {
			System.out.println(e);
	    	}
		}
		return cost;
	}
	/*public ResultSet[] BookedRooms(int[] RequiredRooms) throws ClassNotFoundException, SQLException {
		Connection con=new Start().getConnection();
		ResultSet rs[]=new ResultSet[5];
		PreparedStatement psmt=con.prepareStatement("select roomnumber from RoomDetails where (roomavailability=1 and roomtype=1) and rownum<='"+RequiredRooms[0]+"'");
		rs[0]=psmt.executeQuery();
		psmt=con.prepareStatement("select roomnumber from RoomDetails where (roomavailability=1 and roomtype=2) and rownum<='"+RequiredRooms[1]+"'");
		rs[1]=psmt.executeQuery();
		psmt=con.prepareStatement("select roomnumber from RoomDetails where (roomavailability=1 and roomtype=3) and rownum<='"+RequiredRooms[2]+"'");
		rs[2]=psmt.executeQuery();
		psmt=con.prepareStatement("select roomnumber from RoomDetails where (roomavailability=1 and roomtype=4) and rownum<='"+RequiredRooms[3]+"'");
		rs[3]=psmt.executeQuery();
		psmt=con.prepareStatement("select roomnumber from RoomDetails where (roomavailability=1 and roomtype=5) and rownum<='"+RequiredRooms[4]+"'");
		rs[4]=psmt.executeQuery();
		
		
		return rs;
	}*/

	@Override
	public ResultSet getAvailableRoomsT1() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = new Start().getConnection();
		ResultSet Rs = con.prepareStatement("select roomnumber from ROOMDETAILS where roomavailability =1 and roomtype =1").executeQuery();
		return Rs;
	}

	@Override
	public ResultSet getAvailableRoomsT2() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = new Start().getConnection();
		ResultSet Rs = con.prepareStatement("select roomnumber from ROOMDETAILS where roomavailability =1 and roomtype =2").executeQuery();
		return Rs;
	}

	@Override
	public ResultSet getAvailableRoomsT3() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = new Start().getConnection();
		ResultSet Rs = con.prepareStatement("select roomnumber from ROOMDETAILS where roomavailability =1 and roomtype =3").executeQuery();
		return Rs;
	}

	@Override
	public ResultSet getAvailableRoomsT4() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = new Start().getConnection();
		ResultSet Rs = con.prepareStatement("select roomnumber from ROOMDETAILS where roomavailability =1 and roomtype =4").executeQuery();
		return Rs;
	}

	@Override
	public ResultSet getAvailableRoomsT5() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = new Start().getConnection();
		ResultSet Rs = con.prepareStatement("select roomnumber from ROOMDETAILS where roomavailability =1 and roomtype =5").executeQuery();
		return Rs;
	}

	@Override
	public Room getRoom(int roomNumber) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = new Start().getConnection();
		ResultSet Rs = con.prepareStatement("select * from ROOMDETAILS where ROOMNUmBER ="+roomNumber+"").executeQuery();
		Room temp = new Room();
		Rs.next();
		temp.setRoomNumber(roomNumber);
		temp.setRoomType(Rs.getInt("ROOMTYPE"));
		temp.setFare(Rs.getInt("COST"));
		
		if(Rs.getInt("ROOMAVAILABILITY")==1)
			temp.setAvailable(true);
		else if(Rs.getInt("ROOMAVAILABILITY")==0)
			temp.setAvailable(false);
		 
		if(Rs.getInt("ROOMRESERVED")==1)
			temp.setReserved(true);
		else if(Rs.getInt("ROOMRESERVED")==0)
			temp.setReserved(false);
		
		return temp;
	}

}
