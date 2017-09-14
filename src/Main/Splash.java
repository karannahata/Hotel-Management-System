package Main;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.*;
 
public class Splash extends JFrame {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel imglabel;
    private ImageIcon img;
    private static JProgressBar pbar;
    Thread t = null;
 
    public Splash() {
        super("Splash");
        setSize(404, 310);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
       // setBackground(Color.decode("#1A242A"));
        //setForeground(Color.decode("#1A242A"));
        img = new ImageIcon("splashimage.png");
        imglabel = new JLabel(img);
        add(imglabel);
        setLayout(null);
       
        JLabel copyrt = new JLabel
        		   ("Copyright 2017, Sark Hotels and Resorts", JLabel.CENTER);
        		 copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        		 copyrt.setForeground(Color.white);
        		copyrt.setBounds(0,240,404,30);
        		copyrt.setForeground(Color.WHITE);
       add(copyrt);
       
       //Color oraRed = new Color(156, 20, 20,  255);
       getRootPane().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 10));
        pbar = new JProgressBar();
        pbar.setMinimum(0);
        pbar.setMaximum(100);
        pbar.setStringPainted(true);
        pbar.setForeground(Color.RED);
        imglabel.setBounds(0, 0, 404, 310);
        add(pbar);
        pbar.setPreferredSize(new Dimension(310, 30));
        pbar.setBounds(0, 270, 384, 20);
 
        Thread t = new Thread() {
 
            public void run() {
                int i = 0;
                while (i <= 100) {
                    pbar.setValue(i);
                    pbar.setString(i+"% Completed");
                    if(i>50)
                    {
                    	pbar.setForeground(Color.GREEN);
                    }
                    try {
                        sleep(90);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    i++;
                }
            }
        };
        t.start();
    }
}