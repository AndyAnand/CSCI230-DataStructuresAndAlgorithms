package library;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/** 
This class makes the opposite way of the XMLtoBookParser, it writes an list of Book objects into a XML file
@author Andy Gajadhar
@since September 2, 2014
*/

public class BookToXMLParser {
	private BufferedWriter writer;
	
	public BookToXMLParser(String filename){
		File f = new File(filename);
		
		f.delete(); // delete the old file, to create a new one with new content
				
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Catalog File Creation Failed!! Program is ending");
			System.exit(-1);
		}
		
		try {
			writer = new BufferedWriter(new FileWriter(f));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Catalog File Creation Failed!! Program is ending");
			System.exit(-1);
		}
	}
	
	/**
	 * writeBooksInXML saves a list of Book objects in a XML file
	 * 
	 * @param SinglyLinkedList<Book>
	 *            books a list of books to be saved on the catalog.xml file
	 */
	
	public void writeBooksInXML(SinglyLinkedList<Book> books){
		writeXMLHeader();    // writes the header in the file
		
		try {
			ListIterator<Book> i = books.getIterator();    // implementation of iterator design pattern
			Book book = null;
			
			writer.write("<catalog>");
			writer.newLine();
			
			while(i.hasNext()){
				book = i.next();
				writeOneBookInXML(book);
				writer.newLine();
			}
			
			writer.write("</catalog>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO Error!");
			System.exit(-1);
		}
		try {
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * writeXMLHeader insert a line into the XML file declaring its version
	 */
	
	private void writeXMLHeader(){
		try {
			writer.write("<?xml version=\"1.0\"?>");
			writer.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO Error!");
			System.exit(-1);
		}
	}
	
	/**
	 * writeOneBookInXML gets a single Book object and save it in a XML file
	 * 
	 * @param Book
	 *            b o book object to be saved in a XML file
	 */
	
	private void writeOneBookInXML(Book b){
		SimpleDateFormat dateText = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH); // will be useful to format a Date object to yyyy-mm-dd string format
		
		//writing property by property of a Book in the XML file
		try {
			writer.write("\t<book id=\"bk"+b.getId()+"\">");
			writer.newLine();
			writer.write("\t\t<author>"+b.getAuthor()+"</author>");
			writer.newLine();
			writer.write("\t\t<title>"+b.getTitle()+"</title>");
			writer.newLine();
			writer.write("\t\t<genre>"+b.getGenre()+"</genre>");
			writer.newLine();
			writer.write("\t\t<price>"+b.getPrice()+"</price>");
			writer.newLine();
			writer.write("\t\t<publish_date>"+dateText.format(b.getPublishDate())+"</publish_date>");
			writer.newLine();
			writer.write("\t\t<description>"+b.getDescription()+"</description>");
			writer.newLine();
			writer.write("\t</book>");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO Error!");
			System.exit(-1);
		}
	}
}
