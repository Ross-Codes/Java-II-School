/**
 * Author: Cassidy Jones
 */

package javaII.dbBeans;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.sql.*;

public class BookBean {
	
	//Set the variables
	private Map<String,Book> bookHash;

	private boolean populated = true;
	public String title;
	public Iterator<String> titleList;
	private Book b = null;
	Connection connection = null;
	String sql = "select * from bookDataTable";



	//Default Constructor
	public BookBean(){
		// A HashMap is unsorted
		//myHash = new  HashMap<String,String>();
		// A TreeMap follows a natural sorting order.
		bookHash = new TreeMap<String,Book>();
		
		populateBook();
	}
	/**
	 * Read the book entries from a file.
	 *
	 */
	public void populateBook(){
		populated = true;
		
		try{
			
			   
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			connection = DriverManager.getConnection("jdbc:odbc:bookData");    
			System.out.println("Connection made");	  

			Statement statement = connection.createStatement(); 
			ResultSet resultSet = statement.executeQuery(sql);
			
			// Each entry of a given line of the the file is comma-seperated.
			while (resultSet.next()) {   
								               
				String title=resultSet.getString("title");
				String author = resultSet.getString("author");
				String isbn = resultSet.getString("isbn");
				String publisher = resultSet.getString("publisher");
				String date = resultSet.getString("datePublished");
				String price = resultSet.getString("price");
				
				
				bookHash.put(title,new Book(title,
						author, isbn, publisher,
						date, Double.parseDouble(price)));
			}

			resultSet.close(); 
			statement.close(); 
		}
		//catch the exceptions
		catch(Exception e){
			populated = false;
			e.printStackTrace();
		}

		finally{
			if(connection != null)
				try{

					connection.close();
				}
			catch(Exception e){
				populated = false;
				e.printStackTrace();
			}
		}
		
	}
	public Book getBook(){
		
		return b ;
	}
	/**
	 * @param args
	 */
	/**
	 * @return Returns the populated.
	 */
	 public void setTitle(String title){
		 this.title = title;
		 b = bookHash.get(title);
		 
	 }
	public boolean isPopulated() {
		return populated;
	}
	/**
	 * @param populated The populated to set.
	 */
	public void setPopulated(boolean populated) {
		this.populated = populated;
	}
	/**
	 * @return Returns the titleList.
	 */
	public Iterator<String> getTitleList() {
		Set<String> keySet = bookHash.keySet();
		titleList = keySet.iterator();
		return titleList;
	}

	/**
	 * @return Returns the title.
	 */
	public String getTitle() {
		return title;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookBean b = new BookBean();
		System.out.println("Is populated = " + b.isPopulated());
		Iterator <String> it = b.getTitleList();
		//print the list of titles
		while(it.hasNext()){
			System.out.println(it.next());
			
		}
		b.setTitle("nothing");
		
		Iterator<String> it2 = b.getTitleList();
		//print the list of titles
		while(it2.hasNext()){
			String title = it2.next();
			b.setTitle(title);
			System.out.println(b.getBook());
			
		}

	}
	

}
