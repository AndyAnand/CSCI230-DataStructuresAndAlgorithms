import java.util.Iterator;

/**
 * This is the interface for the Deque ADT 
 * @author Andy Gajadhar
 * @since October 2, 2014
 * 
 */

public interface Deque<E> extends Iterable<E>{
	
	/**
	 * addFront add an element in the front of the deque
	 * @param e
	 *          the element to be added
	 */
	public void addFront(E e);
	
	/**
	 * addRear add an element in the rear of the deque
	 * @param e
	 * 			the element to be added
	 */
	public void addRear(E e);
	
	/**
	 * getFront gets but doesn't remove the element in the front of the deque
	 * @return the element in the front of the deque if the deque is not empty and null otherwise
	 */
	public E getFront();
	
	/**
	 * getRear gets but doesn't remove the element in the rear of the deque
	 * @return the element in the rear of the deque if the deque is not empty and null otherwise
	 */
	public E getRear();
	
	/**
	 * isEmpty checks if the deque is empty
	 * @return true if the deque has 0 elements and false otherwise
	 */
	public boolean isEmpty();
	
	/**
	 * removeFront gets and removes the element in the front of the deque
	 * @return the element in the front of the deque if the deque is not empty and null otherwise
	 */
	public E removeFront();
	
	/**
	 * removeRear gets and removs the element in the rear of the deque
	 * @return the element in the rear of the deque if the deque is not empty and null otherwise
	 */
	public E removeRear();
	
	/**
	 * size counts the number of elements in the deque
	 * @return the number of elements in the deque
	 */
	public int size();
	
	/**
	 * iterator gets the Deque iterator
	 * @return a iterator for the deque
	 */
	
	public Iterator<E> iterator();
}
