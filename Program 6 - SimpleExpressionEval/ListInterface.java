

/**
 * This is the interface for the ADT List
 * 
 * @author Chris Starr
 * @since August 24, 2014
 */

public interface ListInterface<E> {

	/**
	 * size returns the number of elements in the list of type E
	 * 
	 * @return the integer number of elements in the list
	 */
	public int size();

	/**
	 * isEmpty is a boolean function that returns true if the list has at least
	 * one element false otherwise.
	 * 
	 * @return true if the list is not empty, false otherwise
	 */
	public boolean isEmpty();

	/**
	 * getFirst returns the first element in the list if it exists, null
	 * otherwise
	 * 
	 * @return the first element in the list
	 */
	public E getFirst();

	/**
	 * getLast returns the last element in the list if it exists, null otherwise
	 * 
	 * @return the last element in the list
	 */
	public E getLast();

	/**
	 * addFirst inserts a new element into the list at the front of the list
	 * 
	 * @param E
	 *            e a new element to be added
	 */
	public void addFirst(E e);

	/**
	 * addLast inserts a new element into the list at the end of the list
	 * 
	 * @param E
	 *            e a new element to be added
	 */
	public void addLast(E e);

	/**
	 * remove deletes a list element from the list by specifying its position in
	 * the list. Counting list elements starts at 1, not zero. If that list
	 * position does not exist in the list, then null is returned, else the list
	 * element that existed at that list position is returned (for use or to
	 * ignore).
	 */
	public E removeElementAtPosition(int listPosition);

	/**
	 * get returns the list element at the list position. If that position does
	 * not exist in the list then a null is returned.
	 */
	public E getElementAtPosition(int listPosition);

}
