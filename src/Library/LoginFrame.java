package Library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
					frame.setTitle("Login");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Admin Login");
		JButton btnNewButton_1 = new JButton("Librarian Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnNewButton_1.getText()=="Librarian Login")
				 {
					 LibrarianLogin.main(null);
					 
				 }
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(btnNewButton.getText()=="Admin Login")
				{
					AdminLogin.main(null);
				}
				 
			}
		});
		btnNewButton.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		btnNewButton.setBounds(127, 55, 167, 46);
		contentPane.add(btnNewButton);
		
		
		btnNewButton_1.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		btnNewButton_1.setBounds(127, 130, 167, 46);
		contentPane.add(btnNewButton_1);
	}
}
