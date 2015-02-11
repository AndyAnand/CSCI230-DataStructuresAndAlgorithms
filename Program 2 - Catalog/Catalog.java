package library;

import java.io.FileNotFoundException;
import java.util.Date;

/**
 * This is the Catalog class, it represents the library and its reponsible for the main functions of this program 
 * that it: add/remove a book, search for books and list all books. For this, it maintains a collection of the books it contains.
 * @author Andy Gajadhar
 * @since September 2, 2014
 */

public class Catalog {
	private SinglyLinkedList<Book> books;
	private XMLToBookParser bringFromFile;
	private BookToXMLParser putInFile;
	private String filename; 
	
	/**
	 * The constructor receives a filename, where the class will load and save books from/in XML file
	 */
	
	public Catalog(String filename){
		books = new SinglyLinkedList<>();
		this.filename = filename;
	}
	
	/**
	 * Loads all books into memory from filename XML file
	 */
	
	public void loadBooks(){
		try {
			bringFromFile = new XMLToBookParser(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File: "+filename+" not found!!");
			System.exit(-1);
		}
		
		books = bringFromFile.retrieveBooks();    // load the books in the memory
	}
	
	/**
	 * Stores all books into the XML file passed in the Constructor
	 */
	
	public void saveBooks(){
		putInFile = new BookToXMLParser(filename);
				
		putInFile.writeBooksInXML(books);    // save the books in the XML file
	}
	
	/**
	 * addABook adds a book in the catalog
	 * @param String
	 * 				    author the name of the author
	 * @param String    
	 *                  title the title of the book
	 * @param String                 
	 *                  genre the genre of the book
	 * @param Float
	 *                  price the price of the book
	 * @param Date      
	 *                  publishDate the publishing date
	 * @param String 
	 *        			description a brief text about the book
	 */

	
	public void addABook(String author, String title, String genre, Float price, Date publishDate, String description){
		books.addLast(new Book(author, title, genre, price, publishDate, description));
	}
	
	/**
	 * removeABook removes a book from the catalog
	 * @param String
	 *                 title the title of the book to be removed from the catalog
	 * @return true if a book was removed, false otherwise
	 */
	
	public boolean removeABook(String title){
		ListIterator<Book> it = books.getIterator();
		Book b = null;
		
		while(it.hasNext()){
			b = it.next();
			if(b.getTitle().equals(title)){
				it.remove();    // if the title perfectly matches the book`s title, the book will be removed
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * search looks for books that contains the keyword in their title
	 * and prints in the console the found books` information
	 * @param String
	 *                  keyword a word to be searched in the book`s titles
	 * @return the number of found books
	 */
	
	public int search(String keyword){
		ListIterator<Book> it = books.getIterator();
		Book b = null;
		SinglyLinkedList<Book> found = new SinglyLinkedList<>();    // to store the found books, if any
		
		while(it.hasNext()){
			b = it.next();
			if(b.getTitle().contains(keyword)){
				found.addLast(b);
			}
		}
		
		it = found.getIterator();    // uses it variable to get the found books iterator
		
		while(it.hasNext()){
			b = it.next();
			System.out.println(b+"\n");    // printing all the information about found books
		}
		
		return found.size();
	}
	
	/**
	 * listAll prints all informations of the catalog`s books in the console
	 * @return the total number of books in the catalog
	 */
	
	public int listAll(){
		ListIterator<Book> it = books.getIterator();
		Book b = null;
		
		while(it.hasNext()){
			b = it.next();
			System.out.println(b+"\n");    // printing all the information about found books
		}
		
		return books.size();
	}
}
