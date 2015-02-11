import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class is responsible for fetching a movie information in JSON format
 * 
 * @author Andy Gajadhar
 * @since October 3, 2014
 */

public class MovieFetcher {
	
	/**
	 * 
	 * @param title
	 *              The title of the movie to be searched
	 * @return A JASONObject with the movie's information
	 */
	public static JSONObject fetchAMovie(String title){
		// as title will be used to compose the url to request movie data, " " will be replaced by "+" since urls doesnt contain spaces
		title = title.replace(" ", "+");
		
		String movieUrl = "http://www.omdbapi.com/?t=" + title + "&r=JSON";
		
		URL urlObj = null;
		try {
			urlObj = new URL(movieUrl);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Scanner reader = null;
		
		try {
			reader = new Scanner(urlObj.openStream());    // connects the scanner in the stream
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		String jsonData = reader.nextLine();    //fetching
		
		while (reader.hasNext()) //fetching
			jsonData = jsonData + "\n" + reader.nextLine();
		
		reader.close();
		
		JSONObject response = null;
		try {
			response = new JSONObject(jsonData);    // wrapping the fetched string, in JSON format, in a JSONObject
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}
	
}
