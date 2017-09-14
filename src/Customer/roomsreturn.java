package Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class roomsreturn {
	Connection con;
	public ResultSet[] BookedRooms(int[] RequiredRooms) throws ClassNotFoundException, SQLException {
		
		try
	    {  
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","harekrishna");
	     }
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
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
	}
}
