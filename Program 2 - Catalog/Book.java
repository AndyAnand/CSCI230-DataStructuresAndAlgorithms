package library;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/** 
This class is an abstraction of a book
@author Andy Gajadhar
@since September 2, 2014
*/ 

public class Book {
	private static Integer globalId = 0;    //starts in 0 just in case of the first constructor being used first
	private Integer id;
	private String author;
	private String title;
	private String genre;
	private Float price;
	private Date publishDate;
	private String description;
	
	/**
	 * Constructor to be used when desired to create a Book instance
	 */
	
	public Book(String author, String title, String genre, Float price, Date publishDate, String description){
		this.id = ++globalId;
		this.author = author;
		this.title = title;
		this.genre = genre;
		this.price = price;
		this.publishDate = publishDate;
		this.description = description;
	}
	
	/**
	 * Constructor to be used when recovering books from file to memory
	 */
	
	public Book(Integer id, String author, String title, String genre, Float price, Date publishDate, String description){
		Book.globalId = id;    // setting the global to the latest id read from xml file (assuming it is ordered by id), to continue from it when adding new books
		this.id = id;
		this.author = author;
		this.title = title;
		this.genre = genre;
		this.price = price;
		this.publishDate = publishDate;
		this.description = description;
	}
	
	/**
	 * getId is a method used to retrieve book`s identifier
	 * @return The Integer that represents the book`s id
	 */
	
	public Integer getId(){
		return this.id;
	}
	
	/**
	 * setId is a method used to change book`s identifier
	 * @param Integer
	 * 			         id the identifier of the book 
	 */
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * getAuthor is a method used to retrieve book`s author
	 * @return A String that represents the book`s author`s name
	 */
	
	public String getAuthor() {
		return author;
	}
	
	/**
	 * setAuthor is a method used to change book`s author`s name
	 * @param String
	 * 			         author a new author name 
	 */
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
	public String getTitle() {
		return title;
	}
	
	/**
	 * setTitle is a method used to change book`s title
	 * @param String
	 * 			         title a new title for the book 
	 */
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * getGenre is a method used to retrieve book`s genre
	 * @return The String containing the book`s genre
	 */
	
	public String getGenre() {
		return genre;
	}
	
	/**
	 * setGenre is a method used to change book`s genre
	 * @param String
	 * 			         genre the category of the book 
	 */
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	/**
	 * getPrice is a method used to retrieve book`s price
	 * @return The Float that represents the book`s price
	 */
	
	public Float getPrice() {
		return price;
	}
	
	/**
	 * setPrice is a method used to change book`s price
	 * @param Float
	 * 			         price the new price of the book 
	 */
	
	public void setPrice(Float price) {
		this.price = price;
	}
	
	/**
	 * getPublishDate is a method used to retrieve book`s publishing date
	 * @return The Date object that contains the book's publishing date
	 */
	
	public Date getPublishDate() {
		return publishDate;
	}
	
	/**
	 * setPublishDate is a method used to change book`s publishing date
	 * @param Date
	 * 			         publishDate the new publishing date of the book 
	 */
	
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	/**
	 * getDescription is a method used to retrieve book`s brief description
	 * @return The String text containing the book`s description
	 */
	
	public String getDescription() {
		return description;
	}
	
	/**
	 * setDescription is a method used to change book`s description
	 * @param String
	 * 			         description a brief text describing the book`s content 
	 */
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * toString is a method for printing all information of a book
	 * @return A formatted String containing all information of a book 
	 */
	
	public String toString(){
		String out = new String();    // formatted string showing book informations
		SimpleDateFormat dateText = new SimpleDateFormat("mm/dd/yyyy", Locale.ENGLISH);
		
		out = out.concat("Book ID: bk" + id + "\n");
		out = out.concat("Title: " + title + "\n");
		out = out.concat("Author: " + author +"\n");
		out = out.concat("Genre: " + genre +"\n");
		out = out.concat("Publishing Date: " + dateText.format(publishDate) + "\n");
		out = out.concat("Description: \n");
		
		//only permits 50 chars per line
		int i = 1;
		for(char c : description.toCharArray()){
			if(i == 50)
				out = out.concat("\n");
			out = out.concat(c+"");
			i = i++ % 50;
		}
		// if after the description there is no line break, so one is inserted
		if(!out.endsWith("\n")){
			out = out.concat("\n");
		}
		out = out.concat("\n");    // extra space for highlighting the price
		// after showing all information, the user will see the price
		out = out.concat("Price: U$ " + price);
		
		return out;
	}
	
	
}
