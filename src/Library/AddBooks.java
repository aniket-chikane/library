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
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AddBooks extends JFrame {

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
					AddBooks frame = new AddBooks();
					frame.setTitle("Add Book");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddBooks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book No");
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 39, 87, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book Name");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(10, 73, 87, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Author");
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(10, 107, 87, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Publisher");
		lblNewLabel_3.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(10, 141, 87, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Quantity");
		lblNewLabel_4.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(10, 175, 87, 23);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(128, 38, 198, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(128, 72, 198, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(128, 106, 198, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(128, 140, 198, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(128, 174, 198, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
             if(e.getActionCommand()=="Add")
             {
            	 String s1=textField.getText();
            	 String s2=textField_1.getText();
            	 String s3=textField_2.getText();
            	 String s4=textField_3.getText();
            	 String s5=textField_4.getText();
            	 Connect c=new Connect();
            	 c.getConnect();
            	 try
            	 {
            		 String  z="insert into bookrecord(bname,bno,author,publisher,quantity,issuebooks,addeddate) values(?,?,?,?,?,?,?)";
            	 PreparedStatement ps=c.con.prepareStatement(z);
            	 int vv=Integer.parseInt(s5);
            	 ps.setString(1, s2);
            	 ps.setString(2, s1);
            	 ps.setString(3, s3);
            	 ps.setString(4, s4);
            	 ps.setInt(5,vv);
            	 ps.setInt(6, 0);
            	 java.util.Date d= new java.util.Date();
            	long l= d.getTime();
            	java.sql.Date sd=new java.sql.Date(l);
            	ps.setDate(7, sd);
            	int r=0;
            	r=ps.executeUpdate();
            	if(r==0)
            	{
            		JOptionPane.showMessageDialog(AddBooks.this,"Oops! insertion failed");
            	}
            	else
            		JOptionPane.showMessageDialog(AddBooks.this,"Record inserted successfully!!");
            	 
            	 }
            	 catch(Exception ew)
            	 {
            		 ew.printStackTrace();
            	 }
            	 
            	 
             }
			}
			
		});
		btnNewButton.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		btnNewButton.setBounds(93, 227, 75, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="Back")
				{
					LibrarianSection.main(null);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		btnNewButton_1.setBounds(199, 227, 75, 23);
		contentPane.add(btnNewButton_1);
	}

}
