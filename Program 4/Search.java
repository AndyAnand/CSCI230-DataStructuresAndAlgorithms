/**
 * This class is responsible for choosing which search algorithm to use and also for executing it, based on a Enum passed by the user.
 * This designed was inspired by the strategy pattern.
 * 
 * @author Andy Gajadhar
 * @since September 23, 2014
 */
public class Search {
	
	/**
	 * decideAndSearch decide what kind of search to use in a array and executes it
	 * 
	 * @param searchMethod 
	 *                     a enum that acts like a switcher of algorithms, indicating which algorithm to use
	 * @param a 
	 *          the array where the elements are stored
	 * @param value
	 *              the key to be searched in the array    
	 * @return  the position of the found key in the array, if found, or -1 if not found
	 */
	
	public static int decideAndSearch(SearchType searchMethod, Integer[] a, Integer value){
		SearchAlgorithm alg = null;
		
		switch(searchMethod){
			
			case ITR_LINEAR_SEARCH:
				alg = new LinearIterativeSearch();
				break;
			case REC_LINEAR_SEARCH:
				alg = new RecursiveLinearSearch();
				break;
			case ITR_BINARY_SEARCH:
				alg = new BinaryIterativeSearch();
				break;
			case REC_BINARY_SEARCH:
				alg = new RecursiveBinarySearch();
				break;
			default:
				alg = new LinearIterativeSearch();
				break;
		
		}
		
		return alg.search(a, value);
			
	}
}
