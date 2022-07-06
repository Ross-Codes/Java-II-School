package javaII.dbBeans;
import java.util.*;
import java.io.*;

/**
 * BookBean that contains a (non-static) HashMap of Book Objects
 * called bookHash. The Java Class should be placed in the javaII.dbBeans 
 * package. Populate the bookHash from a file containing a 
 * list of books. This HashMap should be populated when the
 * default constructor of the BookBean is called. The file 
 * can have a format of your choosing, but each Book should 
 * contain the following data: ISBN, title, author, publisher,
 * date published, and price. You should have a reference 
 * variable for title in the BookBean Class. 
 * You should also have a (public) setter for title. 
 * You should also have a reference variable called titleList
 * of type Iterator. The getter called getTitleList should 
 * return an iterator based upon the set of keys from the 
 * HashMap. The key for the HashMap should be the title of 
 * the book. You should also have a reference variable for a
 * Book Object. When the getter for book is called (getBook()),
 *  you should return a Book from the HashMap based on the 
 *  current value of title. Implicit in this specification is 
 *  the need for a Book Class. 
 *  This Book Class should also be in the dbBean package, 
 *  and contain reference variables for ISBN, title, author, 
 *  publisher, date published, and price. One constructor of 
 *  the Book class should take all of its attributes as 
 *  arguments. The default constructor should assign the Book's
 *   attributes with default values. 
 *   
 */

/**
 * @author ddalsveen
 *
 */
public class BookBean {
	private Map<String,Book> bookHash = null;
	private String title = null;
	private Iterator<String> titleList = null;
	private Book book = null;
	private BufferedReader br = null;
	private boolean populated = false;
	
	/**
	 * Default Constructor populates the bean
	 *
	 */
	public BookBean(){
		// Create the HashMap in memory
		bookHash = new HashMap<String,Book>();
		populated = true;
		try{
			// Open a file for reading to read the book data
			br = new BufferedReader(new FileReader("c:\\bookData.txt"));
			// while there's data, populate the hashmap with bookData
			while(br.ready()){
				// Parse the String using ':' as the delimiter
			    String [] strArray = br.readLine().split(":");
			    // instantiate a book and place it in the hashmap
			    bookHash.put(strArray[0],new Book(strArray[0],strArray[1],strArray[2],
			    		strArray[3],strArray[4],Double.parseDouble(strArray[5])));
			    
			}

			
		}
		// On any exception, assume the bean was not populated
		catch(Exception e){
			populated = false;
			e.printStackTrace();
		}
		// The finally block is done unconditionally
		finally{
			try{
				br.close();
			}
			catch(Exception e){
				populated = false;
			}
		}
		
		
	}
	


	/**
	 * @return Returns the title.
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @return Returns the boolean populated.
	 */
	public boolean isPopulated(){
		return populated;
	}
	
	/**
	 * @return Returns the book.
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * @param title The title to set.
	 */
	public void setTitle(String title) {
		this.title = title;
		book = bookHash.get(this.title);
	}

	/**
	 * @return Returns the titleList.
	 */
	public Iterator<String> getTitleList() {
		// Create a set of keys in memory
		Set<String> keySet = bookHash.keySet();
		// get the iterator from the set.
		titleList =  keySet.iterator();
		return titleList;
	}


	
	/**
	 * Exists solely to test this BookBean
	 * @param args: Not used.
	 */
	public static void main(String[] args) {
		// Test this Class
		// Create an Object instance of BookBean
		BookBean b = new BookBean();
		// Check the iterator
		Iterator it = b.getTitleList();
		// This is a list of titles
		System.out.println("A list of titles");
		while (it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println("End of list of titles\n\n");
		// Select a title and set it in the bean
		String title = "The Great Escapade";
		b.setTitle(title);
		// Look it up in the hashMap and print it
		System.out.println(b.getBook());
		
		
	}
	
}
