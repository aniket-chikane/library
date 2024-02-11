package Library;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
public class LibrarianDatabase {
	Connect c = new Connect();
	  PreparedStatement ps = null;
	  int rec =0;
	ResultSet rs =null;
	public int CheckRec(String name,String pass,String mail,String Address,String contactno)
	{
		String query = "insert into LibrarianRecord values(?,?,?,?,?,?)";
		try {
			c.getConnect();
		ps = c.con.prepareStatement(query);
		ps.setInt(1,5);
		ps.setString(2,name);
		ps.setString(3,pass);
		ps.setString(4,mail);
		ps.setString(5,Address);
		ps.setString(6,contactno);
		
		
		rec = ps.executeUpdate();
		 
		
		}
		catch(Exception e)
		{
		  	e.printStackTrace();
		}
		return rec;
	}
	public int deleteRecord(int id1)
	{
		c.getConnect();
		int r=0;
		try
		{
		ps=c.con.prepareStatement("delete from LibrarianRecord where id=?");
		ps.setInt(1, id1);
		
		r=ps.executeUpdate();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return r;
	}
	public static void main(String args[])
	{
		LibrarianDatabase l= new LibrarianDatabase();
		int r=0;
		r=l.CheckRec("fj","dhf","dghf","hfj","jf");
		if(r==0)
		{
			System.out.println("not");
		}
		else
			System.out.println("yes");
	}
	
	
}
