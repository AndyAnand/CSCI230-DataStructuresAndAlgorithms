/**
 * This class is an implementation of a recursive linear search algorithm.
 * 
 * @author Andy Gajadhar
 * @since September 23, 2014
 *
 */

public class RecursiveLinearSearch extends SearchAlgorithm{
	
	
	@Override
	
	public int search(Integer[] a, Integer value) {
		// TODO Auto-generated method stub
		ExecutionTimer s = new ExecutionTimer();
		int answer;
		
		s.start();
		answer = limitSearch(a, value, 0);
		s.stop();
		
		System.out.println("Found it in "+s.durationInSeconds()+" using linear search with recursion.");
		
		return answer;
	}
	
	/**
	 * limitSearch is a internal function used for performing recursive search, passing bounds of where to search for the next call
	 * 
	 * @param a
	 *          a array with the elements to be searched
	 * @param value
	 *              the value to be found 
	 * @param beginning
	 *                  where to begin in the array
	 * @return the position of the found key in the array, if found, or -1 if not found
	 */
	
	private int limitSearch(Integer[] a, Integer value, Integer beginning){
		if(beginning.intValue() == a.length)    // end reached
			return -1;
		else if(a[beginning].intValue() == value.intValue())    // found!
			return beginning;
		else{
			return limitSearch(a, value, ++beginning);    // else keep trying! starting from previous position + 1
		}
	}
}
