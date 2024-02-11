package Library;

import java.awt.BorderLayout;
import java.sql.PreparedStatement;
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

public class DeleteLibrarian extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteLibrarian frame = new DeleteLibrarian();
					frame.setVisible(true);
					frame.setTitle("Delete Librarian");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DeleteLibrarian() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Id");
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblNewLabel.setBounds(24, 50, 102, 26);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(160, 51, 202, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id;
				if(e.getActionCommand()=="Delete")
				{
					id=textField.getText();
				int id1=Integer.parseInt(id);
				//LibrarianDatabase li= new LibrarianDatabase();
				int rec=0;
				PreparedStatement ps=null;
				Connect c=new Connect();
				c.getConnect();
				int r=0;
				try
				{
				ps=c.con.prepareStatement("delete from LibrarianRecord where Lid=?");
				ps.setInt(1, id1);
				
				r=ps.executeUpdate();
				
				}
				catch(Exception ez)
				{
					ez.printStackTrace();
				}
				if(r==0)
				{
					JOptionPane.showMessageDialog(DeleteLibrarian.this,"Deletion Failed!");
				}
				else
				{
					JOptionPane.showMessageDialog(DeleteLibrarian.this," record Delete successfully");
				}
				}
			}
		});
		btnNewButton.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		btnNewButton.setBounds(107, 122, 96, 32);
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
		btnNewButton_1.setBounds(238, 122, 96, 32);
		contentPane.add(btnNewButton_1);
	}

}
