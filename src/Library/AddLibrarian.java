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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddLibrarian extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLibrarian frame = new AddLibrarian();
					frame.setVisible(true);
					frame.setTitle("Add Librarian");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddLibrarian() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 47, 83, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(10, 79, 83, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(10, 111, 83, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(10, 143, 83, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Contact No");
		lblNewLabel_4.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(10, 175, 83, 21);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(130, 45, 232, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(130, 80, 232, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(130, 109, 232, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(130, 141, 232, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(130, 173, 232, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String pass =  textField_1.getText();
				String mail =  textField_2.getText();
				String Address  =  textField_3.getText();
				String contactno =  textField_4.getText();
				LibrarianDatabase ld = new LibrarianDatabase();
				int rec =0;
			 rec =	ld.CheckRec(name,pass,mail,Address,contactno);
			if(rec==0)
				JOptionPane.showMessageDialog(AddLibrarian.this,"Oops! insertion failed");
			else
			JOptionPane.showMessageDialog(AddLibrarian.this,rec+" record added successfully");
				
			}
		});
		btnNewButton.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		btnNewButton.setBounds(113, 219, 100, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="Back")
				{
				   AdminSection.main(null);	
				}
				}
			
		});
		btnNewButton_1.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		btnNewButton_1.setBounds(235, 219, 100, 31);
		contentPane.add(btnNewButton_1);
	}

}
