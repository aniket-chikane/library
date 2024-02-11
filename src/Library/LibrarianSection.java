package Library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class LibrarianSection extends JFrame {

	private JPanel contentPane;
	PreparedStatement ps = null;
    ResultSet rs = null;

	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianSection frame = new LibrarianSection();
					frame.setVisible(true);
					frame.setTitle("Librarian Section");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LibrarianSection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Books");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="Add Books")
				{
					AddBooks.main(null);
				}
			}
		});
		btnNewButton.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		btnNewButton.setBounds(127, 11, 183, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Books");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnNewButton_1.getText()=="View Books")
				{
					//String column[]=null;
					//String data[][]=null;
					try {
						Connect c = new Connect();
					c.getConnect();
					String query = "select * from bookrecord ";
					ps = c.con.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					rs= ps.executeQuery();
					while(rs.next())
					System.out.println(rs.getInt(1)+" " +rs.getString(2)+" "+rs.getInt(3)+" " +rs.getString(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" " +rs.getInt(7));
			}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
			}
		});
		btnNewButton_1.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		btnNewButton_1.setBounds(127, 53, 183, 31);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Issue Book");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IssueBook.main(null);
			}
		});
		btnNewButton_2.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		btnNewButton_2.setBounds(127, 95, 183, 31);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View Issued Books");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnNewButton_3.getText()=="View Issued Books")
				{
					//String column[]=null;
					//String data[][]=null;
					try {
						Connect c = new Connect();
					c.getConnect();
					String query = "select * from studentrecord";
					ps = c.con.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					rs= ps.executeQuery();
					while(rs.next())
					System.out.println(rs.getInt(1)+" " +rs.getInt(2)+" " +rs.getString(3)+" "+rs.getInt(4));
			}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
			}
					
			
		});
		btnNewButton_3.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		btnNewButton_3.setBounds(127, 137, 183, 31);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Return Book");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="Return Book")
				{
					ReturnBook.main(null);
				}
			}
		});
		btnNewButton_4.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		btnNewButton_4.setBounds(127, 179, 183, 31);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Logout");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="Logout")
				{
					LoginFrame.main(null);
				}
			}
		});
		btnNewButton_5.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		btnNewButton_5.setBounds(127, 221, 183, 31);
		contentPane.add(btnNewButton_5);
	}

}

