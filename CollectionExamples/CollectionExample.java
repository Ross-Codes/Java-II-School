import java.util.*;
import java.io.*;
/**
 * @author ddalsveen
 * An example of Collections; Arraylists and HashSets
 */
public class CollectionExample {
	private Scanner console;
	private PrintWriter pw;
	private List<String> list; // A list is an ordered collection
	private Set set ; // A set is a collection in which no duplicates are allowed.
	private Map map ; // A map is not a subset of the collection interface.
	private boolean ioFailed = false;
	
	/**
	 * Method buildList
	 * Creates an instance of ArrayList.
	 * Reads from an input file and populates the list with the data
	 * from the file.
	 */
	public void buildList(){
		list = new  ArrayList <String>();
		try{
			console = new Scanner(new FileReader("infile.txt"));

			System.out.println("While reading from input..");
			while(console.hasNextLine()){
				String s = console.nextLine();
				list.add(s);
				System.out.println(s);
				System.out.flush();
				
			}
			System.out.println("\n\n\n");
		}
		catch(IOException e){
			e.printStackTrace();
			ioFailed = true;
		}
		finally{
			
			console.close();
		}
		if(ioFailed){
			System.exit(-1);
		}
	}
	/*
	 * Use the toString method of list to print it.
	 */
	public void printStringList(){
		
		System.out.println(list);
		
		
	}
	/**
	 * method RemoveDuplicates
	 * 	Removes duplicates from a collection and stores
	 * 	the result to a file.
	 *  Uses a HashSet Implemetation to remove the duplicates
	 *  from the (Array)list.
	 *  
	 */
	public void removeDuplicates(){
		set= new HashSet<String>(list);
		
		Iterator<String>  it =  set.iterator(); // Why the warning?
		
		try{
			pw = new PrintWriter(new FileWriter("unique.txt"));
			while(it.hasNext()){
				String s = it.next();
				pw.println(s);
				System.out.println(s);
				System.out.flush();
				
			}
		}
		catch(IOException e){
			e.printStackTrace();
			System.exit(0);
		}finally{
			
			pw.close();
			
			
		}
		
		
	}
	
	/**
	 * Create an instance of CollectionExample and call its methods..
	 * 
	 * @param args (Unused)
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CollectionExample example = new CollectionExample();
		example.buildList();
		example.printStringList();
		example.removeDuplicates();
		
	}
	
}
