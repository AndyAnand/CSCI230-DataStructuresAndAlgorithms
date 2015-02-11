/**
 * This class is an implementation of a recursive binary search algorithm.
 * 
 * @author Andy Gajadhar
 * @since September 23, 2014
 *
 */
public class RecursiveBinarySearch extends SearchAlgorithm{

	@Override
	public int search(Integer[] a, Integer value) {
		// TODO Auto-generated method stub
		ExecutionTimer s = new ExecutionTimer();
		int answer;
		
		s.start();
		answer = limitSearch(a, value, 0, a.length - 1);
		s.stop();
		
		System.out.println("Found it in "+s.durationInSeconds()+" using binary search with recursion.");
		
		return answer;
	}
	
	/**
	 * limitSearch is a internal function used for performing recursive search, passing bounds of where to search for the next call
	 * 
	 * @param a
	 *          a array with the elements to be searched
	 * @param value
	 *              the value to be found 
	 * @param begin
	 *                  beginning of the array
	 * @param end
	 *                  final of the array                 
	 * 
	 * @return the position of the found key in the array, if found, or -1 if not found
	 */
	
	private int limitSearch(Integer[] a, Integer value, Integer begin, Integer end){
		int middle = (end+begin) / 2;
		
		if(end < begin){    // if the begin is trepassed by the end or the end trepassed by the begin, end of line
			return -1;
		}else if(a[middle].intValue() == value.intValue()){    // found!
			return middle;
		}else if(a[middle].intValue() < value.intValue()){    // not found, function recall itself for searching in the right
			return limitSearch(a, value, middle + 1, end);
		}else{
			return limitSearch(a, value, begin, middle-1);    // not found, function recall itself for searching in the left
		}
	}
}
