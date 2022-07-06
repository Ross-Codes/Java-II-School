package javaII.dbBeans;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class BookBean {
	
	private Map<String,String> bookHash;
	private BufferedReader br ;
	private boolean populated = true;
	public String title;
	public Iterator titleList;
	
	public void getTitleList(){
		
	}
	
	public void setTitle(){
		this.title = title;
		
	}

	
	public BookBean(){
		// A HashMap is unsorted
		//myHash = new  HashMap<String,String>();
		// A TreeMap follows a natural sorting order.
		bookHash = new TreeMap<String,String>();
		
		populateBook();
	}
	/**
	 * Read the phonebook entries from a file.
	 *
	 */
	public void populateBook(){
		populated = true;
		try{
			br = new BufferedReader(new FileReader("bookData.txt"));
			// Each entry of a given line of the the file is comma-seperated.
			
			while(br.ready()) {
				
				String [] parseArray = br.readLine().split(":");
                
				
				bookHash.put(parseArray[0],new Book(parseArray[0],
						parseArray[1], parseArray[2], parseArray[3],
						parseArray[4], parseArray[5]));
				
			} 
		}
		catch(Exception e){
			populated = false;
			e.printStackTrace();
		}
		finally{
			if(br != null)
				try{
					br.close();
				}
			catch(Exception e){
				populated = false;
				e.printStackTrace();
			}
		}
		
	}
	public String getNumberValue(String key){
		String returnString = "Not Found";
		return bookHash.containsKey(key)? bookHash.get(key):returnString ;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
