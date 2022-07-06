package phoneBook;

import java.util.*;
import java.io.*;

/**
 * @author Dave Dalsveen
 * Program PhoneHash: This class is capable of loading a phoneBook
 * from a file. It also allows a user to obtain a phone number based on 
 * a name(the key).
 *
 * * HISTORY:    Date    Programmer     Modification
 *             --------  ------------   ---------------
 *			   01/07/07	 Dave Dalsveen  Initial Version
 *
 */
public class PhoneHash{
	// A HashMap is unsorted.
	// public Map<String, String> myHash = new  HashMap<String,String>();
	// A TreeMap follows a natural sorting order.
	private Map<String,String> myHash;

	private BufferedReader br ;
	
	// A boolean to indicate if something exeptional happendd during i/o.
	private boolean ioFailed = false;

	public static final String SENTINEL = "done";
	
	/**
	 * Default Constructor
	 * Creates a Map of PhoneBook Entries in memory. 
	 */
	public PhoneHash(){
		// A HashMap is unsorted
		//myHash = new  HashMap<String,String>();
		// A TreeMap follows a natural sorting order.
		myHash = new TreeMap<String,String>();
		
		populateBook();
	}
	/**
	 * Read the phonebook entries from a file.
	 *
	 */
	public void populateBook(){
		
		try{
			br = new BufferedReader(new FileReader("phonebook.txt"));
			// Each entry of a given line of the the file is comma-seperated.
			
			while(br.ready()) {
				
				String [] parseArray = br.readLine().split(",");
				String key = parseArray[0] + ", " +parseArray[1];
				String value = parseArray[2];
				
				myHash.put(key,value);
				
			}
		}
		catch(Exception e){
			ioFailed = true;
			e.printStackTrace();
		}
		finally{
			if(br != null)
				try{
					br.close();
				}
			catch(Exception e){
				ioFailed = true;
				e.printStackTrace();
			}
		}
		if(ioFailed){
			System.exit(-1);
		}
	}
	/**
	 * Given a name, get the number.
	 * @param key The name
	 * @return    The phone number
	 */
	public String getNumberValue(String key){
		String returnString = "Not Found";
		return myHash.containsKey(key)? myHash.get(key):returnString ;
	}
	/**
	 * Prints a list of names from the phonebook.
	 *
	 */	
	public void printPhoneBook(){
		System.out.println("The Phonebook:");
		Set keySet = myHash.keySet();
		Iterator it = keySet.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	/**
	 * This main method is required to run this as an application.
	 * It makes an object instance of this class(PhoneHash).
	 * It then will look up a phone number based on user input.
	 * @param args
	 * @throws IOException
	 */	
	public static void main(String[] args) throws IOException {
		PhoneHash hash = new PhoneHash();
		String key = "";
		// Now, retrieve the value given a key
		Scanner sc = new Scanner(System.in);
		while(!(key.equals( SENTINEL))) {
			
		    System.out.print("Please enter a name of the form lastname, firstname, " +
					"\nand I will show you the phone number, if it exists." +
					"\nEnter "+SENTINEL + " to quit." +
					"\nEnter  L for complete listing of names in the book =>");
			System.out.flush();
			key= sc.nextLine();
			if(key.equals("L")){
				hash.printPhoneBook();
				System.out.println("Hit return to continue");
				sc.nextLine();
			}
			else if (!key.equals(SENTINEL)){
				System.out.println("The phone number is " + hash.getNumberValue(key));
			}
			
		}
		
		
		
	}
}
