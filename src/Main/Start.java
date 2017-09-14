package Main;

import java.sql.Connection;
import java.sql.SQLException;

import Admin.WelcomePage;
import DAO.DataSource;
import javax.swing.SwingUtilities;
public class Start{
	
	static Connection con;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		con=new DataSource().getDBConnection();
		Splash s=new Splash();
        s.setVisible(true);
        Thread t=Thread.currentThread();
        try {
			t.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        s.dispose();
        SwingUtilities.invokeLater(new Runnable(){
            public void run()
            {
                //opening the main application
            	WelcomePage w = new WelcomePage();
            }
        });	//EmployeeLogin m2 = new EmployeeLogin();
		
		//CustomerLogin c = new CustomerLogin();
		//c.login();
	}
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		con=new DataSource().getDBConnection();
		return con;
	}

}
