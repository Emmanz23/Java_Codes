import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;

public class Main extends JFrame{
	
	private static JFrame frame;
	private static JButton login, register;
	private static JLabel user, pass, alert;
	private static JTextField username ;
	private static JPasswordField password;
	
	Main(){
		frame = new JFrame("LOGIN");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setBounds(500,250,400,250);
		frame.setResizable(false);
		
		user = new JLabel("Username");
		user.setBounds(50,40,80,20);
		user.setFont(new Font("Arial", Font.BOLD,15));
		frame.add(user);
		
		username = new JTextField();
		username.setBounds(140,40,150,20);
		frame.add(username);
		
		pass = new JLabel("Password");
		pass.setBounds(50,80,80,20);
		pass.setFont(new Font("Arial", Font.BOLD,15));
		frame.add(pass);
		
		password = new JPasswordField();
		password.setBounds(140,80,150,20);
		frame.add(password);
		
		login = new JButton("Login");
		login.setBounds(50,120,100,30);
		frame.add(login);
		
		register = new JButton("Register");
		register.setBounds(230,120,100,30);
		frame.add(register);
		
		alert = new JLabel("");
		alert.setBounds(152,150,100,30);
		frame.add(alert);
		
		frame.setLayout(null);
		frame.setVisible(true);	
		
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				String usern = username.getText();
				String passw = password.getText();
				
				String user;
				String pass;
				
				try {
					File file = new File("Personalinfo.txt");
					Scanner scan = new Scanner(file);
					
					while(scan.hasNext()) {
						String[] info = scan.nextLine().split("\n");
							
						for(int i = 0; i < info.length; i++) {
							String[] data = info[i].split(",");
							user = data[2];
							pass = data[3];
							
							String login = user + " " + pass;
							
							String[] signin = login.split(" ");
							
							if(usern.equals(signin[0]) && passw.equals(signin[1])) {
								
								frame.dispose();
								new Dashboard();
								System.out.println("true");
								
							}
							else {
								alert.setForeground(Color.red);
								alert.setText("Login Denied");
								System.out.println("false");
							}
							
						}
					}	
				}catch(Exception e1) {
					
				}
				
			}
		});
		
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				new Registerform();
				
			}
		});
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
		//new SchoolIdIncrement();

	}
}
