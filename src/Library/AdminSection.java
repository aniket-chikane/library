package Library;

import java.awt.BorderLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminSection extends JFrame {

	 JPanel contentPane;
	PreparedStatement ps = null;
    ResultSet rs = null;
    ResultSetMetaData rsmd=null;
    
    JTable  table=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSection frame = new AdminSection();
					frame.setVisible(true);
					frame.setTitle("Admin Section");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.   
	 */
	public AdminSection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Librarian");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnNewButton.getText()=="Add Librarian")
				{
					AddLibrarian.main(null);
				}
			}
		});
		btnNewButton.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		btnNewButton.setBounds(143, 25, 172, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Librarian");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnNewButton_1.getText()=="View Librarian")
				{
					String column[]=null;
					String data[][]=null;
					try {
						Connect c = new Connect();
					c.getConnect();
					String query = "select * from LibrarianRecord ";
					ps = c.con.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					rs= ps.executeQuery();
					while(rs.next())
					System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5)+","+rs.getString(6));
					
				rsmd=rs.getMetaData();
				int col=rsmd.getColumnCount();
				column=new String[col];
				for(int i=1;i<=col;i++)
					column[i-1]=rsmd.getColumnName(i);
				    rs.last();
				    int row=rs.getRow();
				    
				   rs.beforeFirst();
				   data=new String[row][col];
				   
				   int count=0;
				   while(rs.next())
				   {
					   for(int i=1;i<=col;i++)
					   data[count][i-1]=rs.getString(i);
					   count++;
				   }
				   c.con.close();
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
					 table=new JTable(data,column);
					 table.setBounds(90,140,250,350);
					 contentPane.setVisible(true);
					JScrollPane sp=new JScrollPane(table);
					contentPane.add(sp);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		btnNewButton_1.setBounds(143, 80, 172, 32);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete Librarian");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnNewButton_2.getText()=="Delete Librarian")
				{
					DeleteLibrarian.main(null);
				}
			}
			
		});
		btnNewButton_2.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		btnNewButton_2.setBounds(143, 136, 172, 32);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnNewButton_3.getText()=="Logout")
				{
					LoginFrame.main(null);
				}
			}
		});
		btnNewButton_3.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		btnNewButton_3.setBounds(143, 190, 172, 32);
		contentPane.add(btnNewButton_3);
	}

}