package Customer;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateTable{

	public CreateTable() throws ClassNotFoundException, SQLException {
		String ur1="jdbc:oracle:thin:@localhost:1521:xe";
		String user="SYSTEM";
		String pwd="harekrishna";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con= DriverManager.getConnection(ur1, user, pwd);
		
		PreparedStatement psmt=con.prepareStatement("insert into RoomDetails values(101,1,10000,1,1,'','','','')");
		boolean b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(102,1,10000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(103,1,10000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(104,1,10000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(105,1,10000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(106,1,10000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(107,1,10000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(108,1,10000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(109,1,10000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(110,2,15000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(111,2,15000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(112,2,15000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(113,2,15000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(114,2,15000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(115,2,15000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(116,2,15000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(117,2,15000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(118,2,15000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(119,2,15000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(120,2,15000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(201,1,10000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(202,1,10000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(203,1,10000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(204,1,10000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(205,1,10000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(206,1,10000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(207,1,10000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(208,1,10000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(209,1,10000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(210,2,15000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(211,2,15000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(212,2,15000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(213,2,15000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(214,2,15000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(215,2,15000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(216,2,15000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(217,2,15000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(218,2,15000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(219,2,15000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(220,2,15000,1,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(301,3,20000,1,1,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(302,3,20000,1,1,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(303,3,20000,1,1,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(304,3,20000,1,1,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(305,3,20000,1,1,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(306,3,20000,1,1,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(307,3,20000,1,1,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(308,3,20000,1,1,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(309,3,25000,1,1,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(401,4,30000,0,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(402,4,30000,0,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(403,4,30000,0,0,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(404,4,30000,0,1,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(405,4,30000,0,1,'','','','')");
		b =psmt.execute();
		psmt=con.prepareStatement("insert into RoomDetails values(501,5,30000,0,1,'','','','')");
		b =psmt.execute();
		
	}
	public static void main(String args[]) throws ClassNotFoundException, SQLException{
		CreateTable ar=new CreateTable();
	}

}
