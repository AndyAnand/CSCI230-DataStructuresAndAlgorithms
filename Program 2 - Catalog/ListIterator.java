package library;

/** 
This interface is the iretator design pattern put in practice for Generic Lists
@author Andy Gajadhar
@since September 2, 2014
*/ 

public interface ListIterator<E> {
	
	/**
	 * hasNext checks if there is a next element in the list
	 * @return true if there is a next element, otherwise false
	 */
	 public boolean hasNext();
     
	 /**
	 * next is a method to get the next element of a list
	 * @return The next element of the list
	 */
	 public E next();
	 
	 /**
	 * remove deletes the current element in the iterator 
	 */
	 
	 public void remove();
}
