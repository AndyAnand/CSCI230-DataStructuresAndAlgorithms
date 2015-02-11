import java.util.Scanner;

/**
 * This class executes and measure the execution time of search algorithms,
 * while search for a key given by the user in array ordered from 1 to 100000.
 * 
 * @author Andy Gajadhar
 * @since September 23, 2014
 */

public class SearchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] array = new Integer[100000];
		Scanner keyboard = new Scanner(System.in);
		Integer key;    // value to be searched in the array
		
		for(int i = 0; i < array.length; i++){    // filling the array from 1 to 100000
			array[i] = i + 1;
		}
		
		System.out.print("Pick a number between 1 and 100,000: ");
		
		key = keyboard.nextInt();
		
		System.out.println();
		
		// calling search algorithms, the time measures will appear in the console
		Search.decideAndSearch(SearchType.ITR_LINEAR_SEARCH, array, key);
		Search.decideAndSearch(SearchType.REC_LINEAR_SEARCH, array, key);
		Search.decideAndSearch(SearchType.ITR_BINARY_SEARCH, array, key);
		Search.decideAndSearch(SearchType.REC_BINARY_SEARCH, array, key);
		
		keyboard.close();
	}

}
