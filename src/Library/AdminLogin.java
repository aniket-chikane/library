package Library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
					frame.setVisible(true);
					frame.setTitle("Admin Login");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblNewLabel.setBounds(55, 58, 96, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(55, 125, 96, 24);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(161, 54, 225, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
		
			public void keyReleased(KeyEvent e) {
				if(e.getKeyText(e.getKeyCode())=="Enter")
				{
					if((textField.getText().equals("Admin")) && (textField_1.getText().equals("Admin@123")))
					{
						AdminSection.main(null);
					}
					else
					{
						JOptionPane.showMessageDialog(AdminLogin.this,"Oops! Enter the valid credentials");
					}
				}
			}
		});
		textField_1.setBounds(161, 120, 225, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="Login")
				{
					if((textField.getText().equals("Admin")) && (textField_1.getText().equals("Admin@123")))
					{
						AdminSection.main(null);
					}
					else
					{
						JOptionPane.showMessageDialog(AdminLogin.this,"Oops! Enter the valid credentials");
						textField.setText("");
						textField_1.setText("");
						
					}
				}
				
			}
		});
		btnNewButton.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		btnNewButton.setBounds(185, 193, 96, 29);
		contentPane.add(btnNewButton);
	}
}
