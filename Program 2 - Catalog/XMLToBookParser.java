package library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/** 
This class was created to parse an XML file containing information about books, in order to construct a list of them
@author Andy Gajadhar
@since September 2, 2014
*/ 

public class XMLToBookParser {
	private BufferedReader reader;    
	
	public XMLToBookParser(String filename) throws FileNotFoundException{
		this.reader = new BufferedReader(new FileReader(new File(filename)));
	}
	
	/**
	* The retrieveBooks method is useful for for parsing an XML file into a list of Books objects
	* It was created for internal use only.
	@return A SingleLinkedList with all books found in the XML file
	*/
	
	public SinglyLinkedList<Book> retrieveBooks(){
		SinglyLinkedList<Book> books = new SinglyLinkedList<>();
		// books variables
		String line = null;
		String author = null;
	    Integer id = null;
		String title = null;
		String genre = null;
		Float price = null;
		Date publishDate = null;
		String description = null;
		
		try {
			while(reader.ready()){
				line = reader.readLine();
				if(line.contains("<book")){    // book found in the xml file, so all of its attributes are retrieved
					id = Integer.parseInt(line.substring(line.indexOf("\"")+1, line.lastIndexOf("\"")).substring(2));    // extracting id
					line = reader.readLine();
					author = retrieveContent(line);
					line = reader.readLine();
					title = retrieveContent(line);
					line = reader.readLine();
					genre = retrieveContent(line);
					line = reader.readLine();
					price = Float.parseFloat(retrieveContent(line));
					line = reader.readLine();
					try {
						publishDate = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH).parse(retrieveContent(line));    // parsing the unusual xml data format to a Date object
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						System.out.println("Date error!! Program is being terminated");
						System.exit(-1);
					}
					line = reader.readLine();
					while(!line.contains("</")){    // the description tag content contained some linebreaks, so this was needed to recover all description pieces into one line
						line += reader.readLine().trim();
					}
					
					description = retrieveContent(line);    // last one
					
					books.addLast(new Book(id, author, title, genre, price, publishDate, description));    // finally add the book in the tail of the linked list
				}else{
					continue;    // ignore line
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
		return books;
		
	}
	
	/**
	* retrieveContent is a method that extract the content between XML tags
	* @param line 
	*                A XML line with a pair of tags
	* @return A string with the content between the XML tags
	*/
	
	private String retrieveContent(String line){
		return line.substring(line.indexOf(">")+1, line.lastIndexOf("</"));
	}
}
