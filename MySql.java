import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.*;
import dals.pwd.*;


/**
 * @author ddalsveen
 *
 * A Class to demonstrate a network database connection 
 * query to a MySQL database.
 */
public class MySql {
	
	
	
	/**
	 * 1) Log in to the MySql database server.
	 * 2) Obtain a driver.
	 * 3) Make a Connection.
	 * 4) Create a SQL statement.
	 * 5) Execute the SQL statement.
	 * 6) Extract data from the result set.
	 * 
	 * @param args: Not used.
	 */
	public static void main(String args[]) {
		char password[] = null;
		try {
			password = PasswordField.getPassword(System.in, "Enter your password: ");
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		if(password == null ) {
			System.out.println("No password entered");
			System.exit(0);
		} else {
			System.out.println("password accepted");
		}
		Connection con = null;
		
		try {
			// Get an object instance of the driver class
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// create a connection to the database server.
			String s = "jdbc:mysql://db.cs.cvtc.edu/bookData?user=dalsvedl&password="+String.copyValueOf(password);
			con = DriverManager.getConnection(s);
			
			if(!con.isClosed())
				System.out.println("Successfully connected to " +
				"MySQL server using TCP/IP...");
			
//			create Statement for executing SQL
			Statement myStatement = con.createStatement();
			ResultSet myResultSet = myStatement.executeQuery( 
					//"SELECT * FROM PetInfo WHERE Name= 'Penny'" );
			"SELECT * FROM bookDataTable " );
			System.out.printf("%-40s %-20s %-20s%n", "Title",  "Author", "Price");
			// add account numbers to accountNumberJComboBox
			while ( myResultSet.next() )
			{
				System.out.printf("%-40s %-20s %-20s%n",myResultSet.getString( "Title" ),
						myResultSet.getString( "Author" ) ,
						myResultSet.getString( "Price" ) );
				
			}
			
			myResultSet.close(); // close myResultSet
			
		} // end try
		
		
		
		
		catch(Exception e) {
			
			System.err.println("Exception: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(con != null)
					con.close();
			} catch(SQLException e) {}
		}
	}
}


