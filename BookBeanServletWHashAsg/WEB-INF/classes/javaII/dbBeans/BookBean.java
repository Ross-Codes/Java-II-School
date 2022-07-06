

package javaII.dbBeans;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class BookBean {
	
	private Map<String,Book> bookHash;
	private BufferedReader br ;
	private boolean populated = true;
	public String title;
	public Iterator<String> titleList;
	private Book b = null;
	


	
	public BookBean(){
		// A HashMap is unsorted
		//myHash = new  HashMap<String,String>();
		// A TreeMap follows a natural sorting order.
		bookHash = new TreeMap<String,Book>();
		
		populateBook();
	}
	/**
	 * Read the phonebook entries from a file.
	 *
	 */
	public void populateBook(){
		populated = true;
		try{
			br = new BufferedReader(new FileReader("c:\\bookData.txt"));
			// Each entry of a given line of the the file is comma-seperated.
			
			while(br.ready()) {
				
				String [] parseArray = br.readLine().split(":");
                
				
				bookHash.put(parseArray[0],new Book(parseArray[0],
						parseArray[1], parseArray[2], parseArray[3],
						parseArray[4], Double.parseDouble(parseArray[5])));
				
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
		Iterator it = b.getTitleList();
		//print the list of titles
		while(it.hasNext()){
			System.out.println(it.next());
			
		}
		b.setTitle("nothing");
		System.out.println(b.getBook());
		Iterator it2 = b.getTitleList();
		//print the list of titles
		while(it2.hasNext()){
			System.out.println(it2.next());
			
		}

	}
	

}
