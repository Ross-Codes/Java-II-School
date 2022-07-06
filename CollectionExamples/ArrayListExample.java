import java.util.*;

/**
 * ArrayListExample is an example of the use of an ArrayList
 * 
 */
public class ArrayListExample  {

    private  List myList ; // a reference variable to hold the List
    
    public void run() {
     
       	myList  = new ArrayList();
        
        myList.add("Hi");
        myList.add("there!");
        
        //Form 1
        Iterator it = myList.iterator();
        String str = "";
        while(it.hasNext()) {
            str = (String)it.next();
            System.out.println(str);
        }
        
        //Form 2
        for(Iterator it1 = myList.iterator(); it.hasNext();) {
            str = (String)it.next();
            System.out.println(str);
        }
        
    }


    /**
     *  The main program for the ArrayListExample class
     *
     *@param  args  The command line arguments
     */
    public static void main(String[] args) {

        ArrayListExample  example  = new ArrayListExample();

        example.run();
    }

}

