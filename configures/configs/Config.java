//Cassidy Jones

package configs;
import java.util.*;
import java.io.*;


public class Config {
	private Properties props;
	private String propsFile;
	
	/**
	 * Default constructor
	 *
	 */
	public Config(){
		this ("c:/myConfig.properties.txt");
	}
	
	public Config(String propsFile){
		props = new Properties();
		setPropsFile(propsFile);
		
	}
	
	public void storeProps(){
		try{
			File file = new File (propsFile +"out");
			file.createNewFile();
			
			props.store(new FileOutputStream(file), "ConfigProperties");
			FileOutputStream fos=
				new FileOutputStream(propsFile+".xml");
			props.storeToXML(fos ,"XML compliant");
			
		}
		catch (Exception e){
			if(e instanceof IOException){
				
			}
			else if (e instanceof FileNotFoundException){
				
			}
		}
	}
	
	public String getPropsFile(){
		return propsFile;
	}
	
	public void setPropsFile(String propsFile){
		if(propsFile != null){
			this.propsFile=propsFile;
		}
		else{
			System.out.println("The name of the properties file is invalid");
			
		}
	}
	
	/**

	* Loads the properties from a file.

	* @return true if the properties were loaded.

	*/

	public boolean loadProps() {

	boolean returnVal = true;

	try {

	props.load(new FileInputStream(propsFile));

	}

	catch (Exception e) {

	returnVal = false;

	if(e instanceof IOException){

	}

	else if (e instanceof FileNotFoundException){

	System.out.println("File " + propsFile +

	" could not be found!");

	}

	else {

	System.out.println("Unexpected Exception Occurred");

	}

	e.printStackTrace();

	}// end catch

	return returnVal;

	}// end method loadProps
	
	public void run(){
		boolean loaded = loadProps();
		if (props!=null && loaded){
			Set keys = props.keySet();
			Iterator it = keys.iterator();
			while(it.hasNext()){
				String key = (String)it.next();
				System.out.println(key + " = "+ props.getProperty(key));
			}
			storeProps();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "";
		Config c;
		
		if(args.length != 0){
			str = args[0];
			c = new Config(str);
			c.run();
		}
		c = new Config();
		c.run();
		

	}

}
