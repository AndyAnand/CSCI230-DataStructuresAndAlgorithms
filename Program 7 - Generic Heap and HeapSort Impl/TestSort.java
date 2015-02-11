import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This class tests the heapSort implementation of the Sort class. It sorts an arraylist of random integers of size
 * provided by the user.
 * 
 * @author Andy Gajadhar
 * @since  October 23, 2014
 *
 */

public class TestSort {
	
	/**
	 * Do all the job, asks the size of the desired list, create the list with 
	 * size random elements, prints, order, print and count the time of execution
	 */
	public void run(){
		Scanner keyboard = new Scanner(System.in);
		int listSize;
		ArrayList<Integer> ar;
		ExecutionTimer stopWatch = new ExecutionTimer();
		
		System.out.print("Enter the size of the list to generate: ");
		
		listSize = keyboard.nextInt();
		
		ar = createIntArList(listSize);
		
		System.out.println("Original list: "+ar);
		
		stopWatch.start();
		ar = Sort.heapSort(ar);
		stopWatch.stop();
		
		System.out.println("Sorted list: "+ar);
		System.out.println("Time to sort: "+stopWatch.durationInMilliseconds()+" ms");
		
		keyboard.close();
	}
	
	/**
	 * createIntArList create an arrayList of random integers with a desired number of elements
	 * 
	 * @param size    the desired number of integers to be in the array
	 * @return    the created list of numbers
	 */
	
	private ArrayList<Integer> createIntArList(int size){
		Random r = new Random(System.currentTimeMillis());
		ArrayList<Integer> ar = new ArrayList<Integer>();
		
		for(int i = 0; i < size; i++){
			ar.add(r.nextInt(1000));    //populates the array with random numbers in the range[0, 1000)
		}
		
		return ar;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestSort().run();
	}

}
