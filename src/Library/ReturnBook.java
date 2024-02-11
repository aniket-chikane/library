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

public class ReturnBook extends JFrame {

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
					ReturnBook frame = new ReturnBook();
					frame.setVisible(true);
					frame.setTitle("Return Book");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReturnBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book No.");
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblNewLabel.setBounds(48, 44, 90, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student id");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(48, 102, 90, 23);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(176, 43, 203, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(176, 101, 203, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Return Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="Return Book")
				{
					Connect c=new Connect();
					c.getConnect();
			        String q=textField.getText();
			        int i=Integer.parseInt(q);
					try
					{
						String s="delete from studentrecord where bno=?";
					PreparedStatement ps=c.con.prepareStatement(s);
					ps.setInt(1, i);
					int r=0;
					r=ps.executeUpdate();
					if(r==0)
					{
	            		JOptionPane.showMessageDialog(ReturnBook.this,"Oops! Something Went Wrong");
	            	}
	            	else
	            	{
	            		JOptionPane.showMessageDialog(ReturnBook.this,"Book Return successfully!!");
	            		String p1="update bookrecord set quantity=quantity+1 where bno=?";
		            	String p2="update bookrecord set issuebooks=issuebooks-1 where bno=?";
		            	
		            	PreparedStatement ps1=c.con.prepareStatement(p1);
		            	ps1.setInt(1,i);
		            	ps1.executeUpdate();
		            	PreparedStatement ps2=c.con.prepareStatement(p2);
		            	ps2.setInt(1,i);
		            	ps2.executeUpdate();
	            	}
	            	 
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		btnNewButton.setBounds(84, 170, 141, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		btnNewButton_1.setBounds(249, 170, 118, 31);
		contentPane.add(btnNewButton_1);
	}

}
