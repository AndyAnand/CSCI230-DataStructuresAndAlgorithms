import java.util.ArrayList;

/**
 * A class with static methods for sorting ArrayList
 * 
 * NOTE: only heapSort is disponible in this version
 * 
 * @author Andy Gajadhar
 * @since October 23, 2014
 */

public class Sort {
	
	private Sort(){    //no one can instantiate this class
		
	}
	
	/**
	 * heapSort sorts in a crescent order an arrayList of comparable elements 
	 * 
	 * @param ar    the arraylist
	 * @return     a sorted arraylist
	 */
	public static <E extends Comparable> ArrayList<E> heapSort(ArrayList<E> ar){
		Heap<E> heap = new HeapA<E>();
		
		while(!ar.isEmpty())
			heap.insert(ar.remove(0));
		
		while(!heap.isEmpty())
			ar.add(heap.remove());
		
		return ar;
	}
}
