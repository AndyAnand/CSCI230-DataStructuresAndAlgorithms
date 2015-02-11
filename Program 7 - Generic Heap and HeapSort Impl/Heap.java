
/**
 * An interface for the heap ADT.
 * @author Andy Gajadhar
 * @since  October 21, 2014
 * @param <E>
 */

public interface Heap<E> {
	
	/**
	 * insert adds an element in the heap
	 * 
	 * @param e    the element to be added
	 */
	public void insert(E e);
	
	/**
	 * remove removes an element of the heap
	 * 
	 * @return    the removed element
	 */
	public E remove();
	
	/**
	 * isEmpty checks whether the heap is empty or not
	 * @return    true if the heap is empty, false otherwise
	 */
	public boolean isEmpty();
	
	/**
	 * size counts the number of elements in the heap
	 * @return    the number of elements in the heap
	 */
	public int size();
}
