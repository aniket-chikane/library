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

public class IssueBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBook frame = new IssueBook();
					frame.setVisible(true);
					frame.setTitle("Issue Book");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IssueBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book No.");
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 34, 126, 23);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(157, 33, 216, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Student Id");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(10, 84, 126, 23);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 82, 216, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Student Name");
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(10, 133, 126, 23);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(157, 130, 216, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Student Contact");
		lblNewLabel_3.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(10, 183, 126, 23);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(157, 183, 216, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Issue Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="Issue Book")
				{
					String s1=textField.getText();
					String s2=textField_1.getText();
					String s3=textField_2.getText();
					String s4=textField_3.getText();
					
					int i1=Integer.parseInt(s1);
					int i2=Integer.parseInt(s2);
					int i4=Integer.parseInt(s4);
					Connect c=new Connect();
					c.getConnect();
					PreparedStatement ps=null;
					try
					{
						String s="insert into studentrecord values(?,?,?,?,?)";
						ps=c.con.prepareStatement(s);
						ps.setInt(1, i1);
						ps.setInt(2, i2);
						ps.setString(3, s3);
						ps.setInt(4, i4);
						java.util.Date d= new java.util.Date();
		            	long l= d.getTime();
		            	java.sql.Date sd=new java.sql.Date(l);
		            	ps.setDate(5, sd);
		            	int r=0;
		            	r=ps.executeUpdate();
		            	if(r==0)
		            	{
		            		JOptionPane.showMessageDialog(IssueBook.this,"Oops! Something Went Wrong");
		            	}
		            	else
		            		JOptionPane.showMessageDialog(IssueBook.this,"Book Issued successfully!!");
		            	String p1="update bookrecord set quantity=quantity-1 where bno=?";
		            	String p2="update bookrecord set issuebooks=issuebooks+1 where bno=?";
		            	
		            	PreparedStatement ps1=c.con.prepareStatement(p1);
		            	ps1.setInt(1,i1);
		            	ps1.executeUpdate();
		            	PreparedStatement ps2=c.con.prepareStatement(p2);
		            	ps2.setInt(1,i1);
		            	ps2.executeUpdate();
					}
					
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
					
				}
			}
		});
		btnNewButton.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		btnNewButton.setBounds(113, 227, 115, 23);
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
		btnNewButton_1.setBounds(250, 227, 115, 23);
		contentPane.add(btnNewButton_1);
	}

}
