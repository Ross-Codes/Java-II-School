package javaII;
/**
 * Author: Cassidy Jones
 * Date: 1/24/2007
 */

import java.io.*;
public class LabOne {
	private BufferedReader read = null;
	private PrintWriter write = null;
	
	private String inputFile = "";
	private String outputFile = "";
	
	

	/**
	 * @return Returns the inputFile.
	 */
	public String getInputFile() {
		return inputFile;
	}

	/**
	 * @param inputFile The inputFile to set.
	 */
	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	/**
	 * @return Returns the outputFile.
	 */
	public String getOutputFile() {
		return outputFile;
	}

	/**
	 * @param outputFile The outputFile to set.
	 */
	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}
	
	public void run() {
		try{			
			read = new BufferedReader(new FileReader(inputFile));
			write = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
			while(read.ready()){
				String s = read.readLine();
				write.println(s);			
			}
		}
		catch(Exception e){
			e.printStackTrace();			
		}
		
		finally{
			try{
				read.close();
				write.close();
			}
			catch(Exception e){
				e.printStackTrace();
				System.exit(-1);
			}
		}
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		LabOne labOne = new LabOne();
		labOne.setInputFile(args[0]);
		labOne.setOutputFile(args[1]);
		labOne.run();
	}

}
