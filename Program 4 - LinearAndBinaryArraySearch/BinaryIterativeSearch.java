/**
 * This class is an implementation of a iterative binary search algorithm.
 * 
 * @author Andy Gajadhar
 * @since September 23, 2014
 *
 */
public class BinaryIterativeSearch extends SearchAlgorithm{
	public int search(Integer[] a, Integer value){
		ExecutionTimer s = new ExecutionTimer();
		int answer;
		
		s.start();
		answer = letSearch(a, value);
		s.stop();
		
		System.out.println("Found it in "+s.durationInSeconds()+" using binary search with iteration.");
		
		return answer;
	}
	
	/**
	 * created just for encapsulating searching for measuring the time inside this class, not outside
	 * @param a
	 * @param value
	 * @return
	 */
	
	private int letSearch(Integer[] a, Integer value){
		int begin = 0;
		int middle = a.length/2;
		int end = a.length - 1;    
		
		if(a.length == 0)
			return -1;
		
		while(begin < end){    // will stop when one element is left to be compared , < (not !=) because in case of middle be 0, when going to the left end will become negative
			
			if(a[middle].intValue() == value.intValue()){
				return middle;
			}else if(a[middle].intValue() > value.intValue()){    // defines new search area in the left
				end = middle - 1;    // excluding middle since it was already compared
			}else{
				begin = middle + 1;
			}
			
			middle = (end + begin) / 2;    // defines new middle
		}
		
		return a[middle].intValue() == value.intValue() ? middle : -1;    // testing the last element, last chance!
	}
	
}
