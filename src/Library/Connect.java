package Library;
import java.sql.Connection;
import java.sql.DriverManager;
 class Connect {
	
	  public Connection con= null;
	 public void getConnect()
	 {
		 try {
		con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","1234");
		System.out.println("connection established");
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
		 
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("connection ");
		//Connect.getConnect();
	}


 }
 
