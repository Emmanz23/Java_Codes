import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard {
	
	private static JFrame frame;
	private static JLabel user, pass, alert;
	private static JTextField username, password;
	public static JButton Login;
	public static boolean next;
	
	Dashboard(){

		frame = new JFrame("Dashboard");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setBounds(500,250,400,250);
		frame.setResizable(false);
		
		frame.setLayout(null);
		frame.setVisible(true);	
		
		
	}

}
