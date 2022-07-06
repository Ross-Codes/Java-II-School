/**
 * A Representation of a Book
 */
package javaII.dbBeans;

/**
 * A representation of a Book.
 * @author Cassidy Jones
 *
 */
public class Book {
	private String title = "";
	private String author = "";
	private String ISBN = "";
	private String publisher = "";
	private String pubDate = "";
	private double price =0;
	
	/**
	 * The default, or no-arg, constructor
	 *
	 */
	public Book(){
		this("","","","","",0);
	}
	/**
	 * A Constructor that takes the required Strings
	 * containing book info 
	 * @param bookInfo
	 */	
	public Book(String title, String author, String ISBN, 
			String publisher, String pubDate, double price){
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.publisher = publisher;
		setPubDate(pubDate);
		this.price = price;
	}
	
	/**
	 * @return Returns the price.
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price The price to set.
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	
	/**
	 * @return Returns the author.
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author The author to set.
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return Returns the iSBN.
	 */
	public String getISBN() {
		return ISBN;
	}
	/**
	 * @param isbn The iSBN to set.
	 */
	public void setISBN(String isbn) {
		ISBN = isbn;
	}
	/**
	 * @return Returns the pubDate.
	 */
	public String getPubDate() {
		return pubDate;
	}
	/**
	 * @param pubDate The pubDate to set.
	 */
	public void setPubDate(String pubDate) {
		//if(pubDate.length() > 10);
		//pubDate = pubDate.substring(0,10);
		this.pubDate = pubDate;
	}
	/**
	 * @return Returns the publisher.
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * @param publisher The publisher to set.
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/**
	 * @return Returns the title.
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title The title to set.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	public String toString (){
		return ("Title: " + this.title +" Author: " + this.author + " \nISBN: " + this.ISBN + " \nPublisher: " + this.publisher +
				" \nPublishing Date: " + this.pubDate + " \nPrice:$" + this.price);
	}
	
}
