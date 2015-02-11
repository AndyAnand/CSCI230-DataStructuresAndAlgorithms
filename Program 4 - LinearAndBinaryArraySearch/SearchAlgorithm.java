/**
 * 
 * This is an abstract class that generalizes a search algorithm, delegating to its childs the search method.
 * 
 * @author Andy Gajadhar
 * @since September 23, 2014
 *
 */
public abstract class SearchAlgorithm {
	
	/**
	 * search performs a search by a determined element in a array
	 * 
	 * @param a
	 *         the array where the elements are stored
	 * @param value
	 *             the key to be searched in the array 
	 * @return the position of the found key in the array, if found, or -1 if not found
	 */
	public abstract int search(Integer[] a, Integer value);
}
