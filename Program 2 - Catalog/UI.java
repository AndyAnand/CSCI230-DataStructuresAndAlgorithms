package library;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/** 
This class represents the user interface, separated from the model. Treats user inputs
@author Andy Gajadhar
@since September 2, 2014
*/ 

public class UI {
	
	private Catalog cat;
	private Scanner keyboard;
	private Integer option;
	
	public UI(String filename){
		cat = new Catalog(filename);
		keyboard = new Scanner(System.in);
		option = -1;
	}
	
	private void sayHello(){
		System.out.println("Welcome to the catalog program! Please, choose one of the following options:");    // greeting the user
	}
	
	private void sayBye(){
		System.out.println("Thank you for using the catalog program, see you next time!");
	}
	
	private void drawMainMenu(){
		System.out.println();
		System.out.println("[1] Add a book in the catalog.");
		System.out.println("[2] Remove a book from the catalog.");
		System.out.println("[3] Search books by title.");
		System.out.println("[4] Show all books.");
		System.out.println("[5] Exit program.");
		System.out.println();
	}
	
	private Integer getOption(){
		System.out.println("Type your option number: ");
		
		return keyboard.nextInt();
	}
	
	private String getInputString(){
		return keyboard.nextLine();
	}
	
	public void run(){
		cat.loadBooks();
		sayHello();
		
		while(option != 5){
			drawMainMenu();
			option = getOption();
			keyboard.nextLine();    // takes out the \n from the buffer
			
			switch(option){
				case 1: 
					System.out.println("So you want to add a book, please type the book's informations as the system asks: ");
					System.out.println("Please enter the author's name and surname separated by comma(surname,name): ");
					String author = getInputString();
					
					System.out.println("Please enter the book's title: ");
					String title = getInputString();
					
					System.out.println("Please enter the book's genre: ");
					String genre = getInputString();
					
					System.out.print("Please enter the book's price: $ ");
					System.out.println();
					Float price = keyboard.nextFloat();
					keyboard.nextLine();
					
					System.out.println("Please enter the publishing date in the format yyyy-mm-dd: ");
					String dateText = getInputString();
					Date date = null;
					try {
						date = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH).parse(dateText);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println("Please a brief description of the book: ");
					String description = getInputString();
					cat.addABook(author, title, genre, price, date, description);
					System.out.println("The book has been added with success!!");
				break;
				case 2:
					System.out.println("So you want to remove a book, please type the book's title: ");
				    title = getInputString();
					Boolean removed = cat.removeABook(title);
					
					if(removed){
						System.out.println("The book has been removed with success!");
					}else{
						System.out.println("The book was not found in our catalog, try again!");
					}
				break;
				case 3:
					System.out.println("So you want to search a book by title, please type the search words: ");
					String keywords = keyboard.nextLine();
					System.out.println("Searching...");
					System.out.println("Information Found ");
					System.out.println("------------------------------------");
					Integer found = cat.search(keywords);
					System.out.println("------------------------------------");
					System.out.println(found + " book(s) found!");
					
				break;
				case 4:
					System.out.println("So you want to list all books, here we go!");
					System.out.println("Loading...");
					System.out.println("Information Found ");
					System.out.println("------------------------------------");
					found = cat.listAll();
					System.out.println("------------------------------------");
					System.out.println(found + " book(s) in the catalog!");
				break;
			}
		}
		cat.saveBooks();
		System.out.println("Saving books...");
		sayBye();
	}
}
