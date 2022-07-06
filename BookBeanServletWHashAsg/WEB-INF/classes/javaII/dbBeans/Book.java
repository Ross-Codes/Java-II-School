/***
 * This class is representation of a book.
 */

package javaII.dbBeans;

public class Book {
//	Define reference variables
	private String title = "";
	private String author = "";
	private String isbn = "";
	private String publisher = "";
	private String Date = "";
	private double price = 0;
	
	public Book(){
		this(" ", " ", " ", " ", " ", 0);
	}
	public Book(String title, String author, String isbn,
			String publisher, String date, double price){
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publisher = publisher;
		this.Date = date;
		this.price = price;
		
	}

	public String toString(){
		return "Title: " + title + ", Author: " + author +
		", ISBN: " + isbn;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
