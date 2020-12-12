package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.DBConnection;

public class Main implements ActionListener {
	private static JLabel userLabel;
	private static JLabel passwordLabel;
	private static JTextField userText;
	private static  JPasswordField passwordText;
	private static JButton button;
	private static String username = "Empty";
	private static String password;
	private static JFrame login;
	private static ScoreDAO s;
	public static void main(String[] args) throws Exception {
		final String url = "game-database.c5vzyypaaxx4.us-east-1.rds.amazonaws.com";
		final String user = "admin";
		final String password = "Nintendo9182!#";		
		Connection conn = null;
		try {
		conn = DBConnection.getConnection(url, user, password);
		System.out.println("Connection Works");
		}
		catch(Exception e) {
        e.printStackTrace();
        System.out.println("Connection Failed");
		}
		s =new ScoreDAO(conn);
		login= new JFrame();
		JPanel panel = new JPanel();
		login.add(panel);
		panel.setLayout(null);
		
		userLabel = new JLabel("Username");
		userLabel.setBounds(10,20,80,25);
		panel.add(userLabel);
		
		userText = new JTextField(20);
		userText.setBounds(100, 20, 165, 25);
		panel.add(userText);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10,50,80,25);
		panel.add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText);
		
		button = new JButton("Login");
		button.setBounds(10,80,80,25);
		button.addActionListener(new Main());
		panel.add(button);
		
		login.setBounds(10,10,710,610);
		login.setTitle("Login Page");
		login.setResizable(true);
		login.setVisible(true);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		username = userText.getText();
		password = passwordText.getText();
		try {
			s.select(username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(username != "Empty")
		{
			login.setVisible(false);
			JFrame obj = new JFrame();
			Gameplay game = new Gameplay();
			obj.setBounds(10,10,710,610);
			obj.setTitle("Break Ball");
			obj.setResizable(true);
			obj.setVisible(true);
			obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			obj.add(game);	
		}
		
	}

}
