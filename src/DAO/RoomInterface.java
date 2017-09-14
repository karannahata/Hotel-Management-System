package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.Room;

public interface RoomInterface {
	public int setAvailability(int roomNumber,int value) throws ClassNotFoundException, SQLException;
	public int getAvailability(int roomNumber)throws ClassNotFoundException, SQLException;
	public int setReserved(int roomNumber,int value)throws ClassNotFoundException, SQLException;
	public int getReserved(int roomNumber)throws ClassNotFoundException, SQLException;
	public ResultSet getAvailableRoomsT1()throws ClassNotFoundException, SQLException;
	public ResultSet getAvailableRoomsT2()throws ClassNotFoundException, SQLException;
	public ResultSet getAvailableRoomsT3()throws ClassNotFoundException, SQLException;
	public ResultSet getAvailableRoomsT4()throws ClassNotFoundException, SQLException;
	public ResultSet getAvailableRoomsT5()throws ClassNotFoundException, SQLException;
	int[] fetchcost() throws Exception;
	public Room getRoom(int roomNumber) throws ClassNotFoundException, SQLException;
	//public ResultSet[] BookedRooms(int RequiredRooms[]) throws ClassNotFoundException, SQLException;
	
}
 