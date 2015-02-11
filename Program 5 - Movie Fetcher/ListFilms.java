import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

import org.json.JSONObject;

/**
 * This class read some movietitles from a file and retrieve their information in the
 * OMDB through their API.  
 * 
 * @author Andy Gajadhar
 * @since October 3, 2014
 * 
 * NOTE: Based on ExampleWebAPICall.java Dr. Starr's code.
 */

public class ListFilms {
	
	public void run(){
		
		Scanner fileReader = null;
		Deque<JSONObject> movies = new DequeAL<JSONObject>();
		
		try {
			fileReader = new Scanner(new File("MovieTitles.txt"));
			
			while(fileReader.hasNextLine()){
				movies.addRear(MovieFetcher.fetchAMovie(fileReader.nextLine()));    //adding in the rear to maintain the MovieTitles sequence
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Iterator<JSONObject> it = movies.iterator();    // iterator for iterating trough the deck
		
		while(it.hasNext()){
			System.out.println(it.next());    //printing each JSONObject
		}
	
	}
	
	public static void main(String[] args){
		ListFilms lister = new ListFilms();
		
		lister.run();
	}
}
