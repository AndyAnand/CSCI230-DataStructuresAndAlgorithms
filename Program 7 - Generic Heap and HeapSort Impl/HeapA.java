import java.util.ArrayList;

/**
 * This class implements a generic min binary heap in an Arraylist
 * 
 * @author Andy Gajadhar
 * @since  October 21, 2014
 * 
 * @param <E>    the type of data inside the heap
 */

public class HeapA<E extends Comparable> implements Heap<E>{     // bounded Comparable, the heap will only support Comparable objects since that comparison between heap objects are necessary
	
	private ArrayList<E> heap;
		
	public HeapA(){
		heap = new ArrayList<E>();
		heap.add(null);     // index 0 wont be used
	}
	
	public void insert(E value){
		int start = heap.size();    //gets the position of the new element in the heap
		
		heap.add(value);    //add at the last position
		
		while(start != 1 && heap.get(start).compareTo(heap.get(parentOf(start))) == -1){
			swap(heap, start, parentOf(start));
			start = parentOf(start);
		}
		
	}
	
	public E remove(){
		
		if(this.isEmpty())
			return null;
		
		int start = 1;    //the first element "root"
		
		E element = heap.get(start);    //the element of the root, the one with the most priority
		
		swap(heap, start, heap.size() - 1);    //swap the content of the root with the content of the last leaf
		heap.remove(heap.size() - 1);    //remove the last leaf
		
		// reestablish heap property (if needed) 
		int minimum;    //will store the index of the smallest value in a subtree
		
		while(hasChild(start)){    //deepest as possible
			minimum = start;
			
			if(hasLeft(start) && heap.get(minimum).compareTo(heap.get(leftOf(start))) == 1){    //if parent is greater than the left child, it should go down
				minimum = leftOf(start);
			}
			if(hasRight(start) && heap.get(minimum).compareTo(heap.get(rightOf(start))) == 1){    //if parent is greater than the left child, it should go down
				minimum = rightOf(start);
			}
			
			if(minimum == start)    //this subtree was already obeying the heap property
				break;
			else{
				swap(heap, minimum, start);
				start = minimum;
			}
		}
		
		return element;
	}
	
	public boolean isEmpty(){
		return heap.size() == 1;
	}
	
	public int size(){
		return heap.size() - 1;    //excluding the element of index 0
	}
	
	/**
	 * leftOf calculates the index of the left child of a given parent
	 * @param parent   the index of the parent
	 * @return     the position of the parent's left child
	 */
	
	private int leftOf(int parent){
		return parent*2;
	}
	
	/**
	 * rightOf calculates the index of the right child of a given parent
	 * @param parent   the index of the parent
	 * @return     the position of the parent's right child
	 */
	
	private int rightOf(int parent){
		return parent * 2 + 1;
	}
	
	/**
	 * parentOf calculates the position of the parent of an given child
	 * @param child   the index of the child
	 * @return     the position of the child's parent
	 */
	
	private int parentOf(int child){
		return child/2;
	}
	
	/**
	 * swap swaps the content of two positions in an arraylist
	 * @param ar    the arraylist
	 * @param i1    position 1
	 * @param i2    position 2
	 */
	
	private void swap(ArrayList<E> ar, int i1, int i2){
		E temp = ar.get(i1);
		
		ar.set(i1, ar.get(i2));
		ar.set(i2, temp);
	}
	
	//checks if a node has child
	/**
	 * hasChild checks if a node has some child
	 * @param index    the position of the node
	 * @return    true if the node has at least one child, false otherwise
	 */
	private boolean hasChild(int index){
		return hasLeft(index);    //only need to look for a left child
	}
	
	/**
	 * hasLeft checks if a node has a left child
	 * @param index    the position of the node
	 * @return    true if the node has a left child, false otherwise
	 */
	
	private boolean hasLeft(int index){
		if(index*2 <= this.size()){    
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * hasRight checks if a node has a right child
	 * @param index    the position of the node
	 * @return    true if the node has a right child, false otherwise
	 */
	
	private boolean hasRight(int index){
		if(index*2 + 1 <= this.size()){    
			return true;
		}else{
			return false;
		}
	}
	/*//some tests
	public static void main(String[] args){
		HeapA<Integer> h = new HeapA<Integer>();
		
		h.insert(0);
		System.out.println(h.heap);
		h.insert(5);
		System.out.println(h.heap);
		h.insert(2);
		System.out.println(h.heap);
		h.insert(3);
		System.out.println(h.heap);
		h.insert(1);
		System.out.println(h.heap);
		h.insert(4);
		System.out.println(h.heap);
		h.insert(-1);
		System.out.println(h.heap);
		
		System.out.println(h.remove());
		System.out.println(h.heap);
		System.out.println(h.remove());
		System.out.println(h.heap);
		System.out.println(h.remove());
		System.out.println(h.heap);
		System.out.println(h.remove());
		System.out.println(h.heap);
		System.out.println(h.remove());
		System.out.println(h.heap);
		System.out.println(h.remove());
		System.out.println(h.heap);
		System.out.println(h.remove());
		System.out.println(h.heap);
	}*/
}
