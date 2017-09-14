package Customer;

import java.awt.print.*;
import javax.print.attribute.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CheckOut implements ActionListener,Printable{
	
	Icon is;
	JLabel s1,s2,CustName,CustId,rooms,Stayperiod,checkin,checkout,meals,Amount;;
	JTextField ct1,ct2,ct3,ct4,ct5,ct6;
	JTextArea tf,ct7;
	JFrame co;
	JButton print;
void checkout()
{co = new JFrame();
co.setLayout(null);
co.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
co.setTitle("Check Out");
co.setResizable(true);
co.setSize(1366,768);
	is = new ImageIcon("log1.png");

	s1=new JLabel(is);
	s1.setBounds(980,10,460,156);
	co.add(s1);
	//sp.setVisible(true);
	
	s2 = new JLabel("Check out Details");
	Font f= new Font("Monotype Corsiva",Font.BOLD,40);
	s2.setFont(f);
    s2.setForeground(Color.DARK_GRAY);
	s2.setBounds(540,50,400,35);
	co.add(s2);		
	CustName = new JLabel("Customer name  :");
	Font f2= new Font("Times New Roman",Font.BOLD,15);
    CustName.setFont(f2);
    //l1.setForeground(Color.white);
    //.setBackground(Color.white);
    CustName.setBounds(80,150,150,30);
    co.add(CustName);
    
    ct1=new JTextField();
    ct1.setBounds(250,150,200,30);
    ct1.setEditable(false);
    co.add(ct1);
    CustId = new JLabel("Customer Id :");
    CustId.setFont(f2);
    //l1.setForeground(Color.white);
    //CustId.setBackground(Color.white);
    CustId.setBounds(80,190,100,30);
    co.add(CustId);
  
    ct2=new JTextField();
    ct2.setBounds(250,190,200,30);
    ct2.setEditable(false);
    co.add(ct2);
    
			
	rooms= new JLabel("Room details  :");
	//Font f2= new Font("Times New Roman",Font.BOLD,15);
    rooms.setFont(f2);
    //l1.setForeground(Color.white);
    //.setBackground(Color.white);
 rooms.setBounds(80,230,100,30);
    co.add(rooms);
    
    tf=new JTextArea();
    tf.setBounds(250,230,200,60);
    tf.setEditable(false);
    co.add(tf);
    
    Stayperiod = new JLabel("Stay period :");
    Stayperiod.setFont(f2);
    //l1.setForeground(Color.white);
    //CustId.setBackground(Color.white);
    Stayperiod.setBounds(80,300,100,30);
    co.add(Stayperiod);
    ct3=new JTextField();
    ct3.setBounds(250,300,200,30);
    ct3.setEditable(false);
    co.add(ct3);
    
	checkin = new JLabel("Checkin date :");
	//Font f2= new Font("Times New Roman",Font.BOLD,15);
    checkin.setFont(f2);
    //l1.setForeground(Color.white);
    //.setBackground(Color.white);
    checkin.setBounds(80,340,100,30);
    co.add(checkin);
    
    ct4=new JTextField();
    ct4.setBounds(250,340,200,30);
    ct4.setEditable(false);
    co.add(ct4);
    
    checkout = new JLabel("Checkout date :");
    checkout.setFont(f2);
    //l1.setForeground(Color.white);
    //CustId.setBackground(Color.white);
    checkout.setBounds(80,380,150,30);
    co.add(checkout);
    
    ct5=new JTextField();
    ct5.setBounds(250,380,200,30);
    ct5.setEditable(false);
    co.add(ct5);
    
    meals = new JLabel("Meal Details :");
	//Font f2= new Font("Times New Roman",Font.BOLD,15);
    meals.setFont(f2);
    //l1.setForeground(Color.white);
    //.setBackground(Color.white);
    meals.setBounds(80,420,100,30);
    co.add(meals);
    
    ct6=new JTextField();
    ct6.setBounds(250,420,200,30);
    ct6.setEditable(false);
    co.add(ct6);
    
    Amount = new JLabel("Amount to be paid :");
    Amount.setFont(f2);
    //l1.setForeground(Color.white);
    //CustId.setBackground(Color.white);
    Amount.setBounds(80,460,300,30);
    co.add(Amount);
    ct7=new JTextArea();
    ct7.setBounds(250,460,200,150);
    ct7.setEditable(false);
    co.add(ct7);
    
    print=new JButton("Print");
    print.setBounds(550,530,80,30);
   // print.setBackground(Color.RED);
    co.add(print);
   print.addActionListener(this);
   
   
    
    
    co.setVisible(true);
    
    
}
public static void main(String a[])
{CheckOut check=new CheckOut();
check.checkout();
	}
public void actionPerformed(ActionEvent a) {
	// TODO Auto-generated method stub
	if(a.getSource()==print)
	{
				 PrinterJob job = PrinterJob.getPrinterJob();
	        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
	        PageFormat pf = job.pageDialog(aset);
	        job.setPrintable(new CheckOut(), pf);
	        boolean ok = job.printDialog(aset);
	        if (ok) {
	            try {
	                 job.print(aset);
	            } catch (PrinterException ex) {
	             /* The job did not successfully complete */
	            }
	        }
	}
}
	

public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
	// TODO Auto-generated method stub
	if (page > 0) { /* We have only one page, and 'page' is zero-based */
    return NO_SUCH_PAGE;

	}
/* User (0,0) is typically outside the imageable area, so we must
 * translate by the X and Y values in the PageFormat to avoid clipping
 */
/*Graphics2D g2d = (Graphics2D)g;
g2d.translate(pf.getImageableX(), pf.getImageableY());

/* Now we perform our rendering */
/*g.drawString("Test the print dialog!", 100, 100);
*/
/* tell the caller that this page is part of the printed document */
return PAGE_EXISTS;

	//return 0;
}
}
