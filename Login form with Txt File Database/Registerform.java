import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class Registerform extends JFrame{
	private static JFrame frame;
	private static JLabel firstname, lastname, username, password, password1,idnum;
	private static JTextField user, fname, lname;
	private static JPasswordField pass, pass1;
	private static JButton register, login;
	private static JLabel fnamealert, lnamealert,usernamealert, passwordalert,password1alert, registeralert, idnumber;
	private static File file;
	private static PrintWriter pw;
	
	Registerform(){
			

				frame = new JFrame("Register");
				frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
				frame.setBounds(550,200,400,410);
				frame.setResizable(false);
				
				idnumber = new JLabel("Register Form");
				idnumber.setBounds(60,30,120,20);
				idnumber.setFont(new Font("Arial", Font.BOLD, 16));
				frame.add(idnumber);
				
				firstname = new JLabel("First Name");
				firstname.setBounds(60,80,80,20);
				frame.add(firstname);

				lastname = new JLabel("Last Name ");
				lastname.setBounds(60,120,80,20);
				frame.add(lastname);
				
				username = new JLabel("Username ");
				username.setBounds(60,160,80,20);
				frame.add(username);
				
				password = new JLabel("Password ");
				password.setBounds(60,200,80,20);
				frame.add(password);
				
				password1 = new JLabel("Retype Password");
				password1.setBounds(60,240,120,20);
				frame.add(password1);
				
				fname = new JTextField("");
				fname.setBounds(170,80,120,20);
				frame.add(fname);
				
				lname = new JTextField("");
				lname.setBounds(170,120,120,20);
				frame.add(lname);
				
				user = new JTextField("");
				user.setBounds(170,160,120,20);
				frame.add(user); 
				
				pass = new JPasswordField("");
				pass.setBounds(170,200,120,20);
				frame.add(pass); 
				
				pass1 = new JPasswordField("");
				pass1.setBounds(170,240,120,20);
				frame.add(pass1);
				
				fnamealert = new JLabel("");
				fnamealert.setBounds(300,80,150,20);
				fnamealert.setFont(new Font("Arial", Font.PLAIN, 9));
				fnamealert.setForeground(Color.red);
				frame.add(fnamealert);
				
				lnamealert = new JLabel("");
				lnamealert.setBounds(300,120,150,20);
				lnamealert.setFont(new Font("Arial", Font.PLAIN, 9));
				lnamealert.setForeground(Color.red);
				frame.add(lnamealert);
				
				usernamealert = new JLabel("");
				usernamealert.setBounds(300,160,150,20);
				usernamealert.setFont(new Font("Arial", Font.PLAIN, 9));
				usernamealert.setForeground(Color.red);
				frame.add(usernamealert);
				
				passwordalert = new JLabel("");
				passwordalert.setBounds(300,200,150,20);
				passwordalert.setFont(new Font("Arial", Font.PLAIN, 9));
				passwordalert.setForeground(Color.red);
				frame.add(passwordalert);
				
				password1alert = new JLabel("");
				password1alert.setBounds(300,240,150,20);
				password1alert.setFont(new Font("Arial", Font.PLAIN, 9));
				password1alert.setForeground(Color.red);
				frame.add(password1alert);
				
				registeralert = new JLabel("");
				registeralert.setBounds(150,320,120,20);
				frame.add(registeralert);
				
				register = new JButton("Register");
				register.setBounds(60,300,90,20);
				frame.add(register);
				
				login = new JButton("Login");
				login.setBounds(240,297,90,22);
				frame.add(login);
				
				frame.setLayout(null);
				frame.setVisible(true);
				
				register.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String firstname = fname.getText();
						String lastname = lname.getText();
						String username = user.getText();
						String password = pass.getText();
						String password1 = pass1.getText();
						
						if(password.length() > 0) {
							if(password.length() >= 0 && password.length() <= 8) {
								passwordalert.setText("Atleast 9 letters");
							}
							else {
									passwordalert.setText("");
							}
						}
						else {
							passwordalert.setText("Empty");
						}
						
						if(password1.length() > 0) {
							if (password.equals("")) {
								passwordalert.setText("Empty");
								password1alert.setText("");
							}
							else if(!password.equals(password1)) {
								password1alert.setText("Password not match");
							}
							else {
									password1alert.setText("");
							}
						}
						else {
							password1alert.setText("Empty");
						}

						if(username.length() > 0) {
							if(username.length() >= 0 && username.length() <= 6) {
								usernamealert.setText("Atleast 7 letters");
						}
							else {
								usernamealert.setText("");
							}
						}
						else {
							usernamealert.setText("Empty");
						}
						
						if(!(firstname.length() > 0)) {
							fnamealert.setText("Empty");
						}
						else {
							fnamealert.setText("");
						}
								
						
						if(!(lastname.length() > 0)) {
							lnamealert.setText("Empty");
						}
						else {
							lnamealert.setText("");
						}
						
						
						if(password.equals(password1) && password.length() >= 9 && password1.length() >= 9 && username.length() >= 7 && firstname.length() > 0 && lastname.length() > 0) {
							registeralert.setText("Register Approved");
							registeralert.setBounds(140,320,120,20);
							registeralert.setForeground(Color.green);
							
							
			
							fname.setText("");
							lname.setText("");
							user.setText("");
							pass.setText("");
							pass1.setText("");
							
							
							

							try {
									
								file = new File("Personalinfo.txt");
								pw = new PrintWriter(new FileOutputStream(file, true));
								pw.append(firstname + "," + lastname + "," + username + "," + password + "\n");
								pw.close();
							}
							catch(Exception e1) {
									
							}
						}
						else {
							registeralert.setText("Register Denied");
							registeralert.setForeground(Color.red);
						} 
						
						}
					
				});
				
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				new Main();
				
			}
			
		});
				
			}
	}

