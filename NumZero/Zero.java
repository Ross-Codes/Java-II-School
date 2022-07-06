import java.io.*;

public class Zero{
	
	    static BufferedReader keyboard
	            = new BufferedReader(new InputStreamReader(System.in));

	    public static void main(String[] args)
	    {
	        double num1;                                           
                                      

	        try                                                         
	        {
	            System.out.print("Please enter a number: ");         
	            System.out.flush();                                     
	            num1 = Double.parseDouble(keyboard.readLine());        
	            System.out.println();                                   
	        	        
	        }

	        catch(Exception e)                                          
	        {
	            System.out.println("Error: " + e.toString());         
	        }
	    }
	}

