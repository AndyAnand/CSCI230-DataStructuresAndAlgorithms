/**
 * This class implements the Stack ADT using a Singly Linked List for storing data
 * 
 * @author Andy Gajadhar
 * @since September 14, 2014
 * 
 * NOTE: Everything was tested and found to be working, that is: all methods
 */
public class StackL<E> implements StackInterface<E>{
	
	private SinglyLinkedList<E> stack;    // using the generic SLL (Singly Linked List) for implementing the stack
	
	public StackL() {
		stack = new SinglyLinkedList<>();
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return stack.isEmpty();    // using what is already implemented in SLL 
	}

	@Override
	public E peak() {
		// TODO Auto-generated method stub
		return stack.getFirst();
	}

	@Override
	public void push(E x) {
		// TODO Auto-generated method stub
		stack.addFirst(x);     // push operation reduces to addFirst of the Singly Linked List
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		//return stack.removeElementAtPosition(1);
		return stack.removeFirst();    // pop operation reduces to removefirst operation of the singly linked lists
	}

	@Override
	public void makeEmpty() {
		// TODO Auto-generated method stub
		stack = new SinglyLinkedList<>();    // only need to instantiate a new Singly Linked List and let the garbage collector get rid of the old one
		
	}
	
	/**
	 * size counts the number of elements in the stack
	 * @return the number of elements in this stack
	 */
	
	public int size(){
		return stack.size();    // Accessing the singly linked list size
	}
	
	public static void main(String[] args){
	
		StackL<Integer> s2 = new StackL<>();
		
		System.out.println("Size: "+s2.size());    // expected to be 0
		System.out.println("Peak: " + s2.peak());	// expected to be null, since the stack is empty   
		System.out.println("Popped: "+s2.pop());	// expected to be null, since the stack is empty
		
		s2.push(1);
		s2.push(2);
		s2.push(3);
		s2.push(4);
		s2.push(5);
		// stack will contain: top - > {5,4,3,2,1}
		System.out.println("Size: "+s2.size());    // 5 expected
		
		System.out.println("Peak: " + s2.peak());    // 5 expected
		System.out.println("Size: "+s2.size());    // 5 expected since peak does not remove the top
		
		System.out.println("Popped: "+s2.pop());    // 5 expected
		System.out.println("Popped: "+s2.pop());    // 4 expected
		System.out.println("Size: "+s2.size());    // 3 expected since two elements were removed
		
		System.out.println("Popped: "+s2.pop());    // 3 expected
		System.out.println("Size: "+s2.size());    // 2 expected
		
		System.out.println("Popped: "+s2.pop());    // 2 expected
		System.out.println("Size: "+s2.size());    // 1 expected
		
		System.out.println("Popped: "+s2.pop());   // 1 expected
		System.out.println("Size: "+s2.size());    // 0 expected
		
		System.out.println("Popped: "+s2.pop());    // null expected since that the stack is empty
		System.out.println("Size: "+s2.size());    // 0
		
		s2.push(1);
		s2.push(2);
		s2.push(3);
		s2.push(4);
		s2.push(5);
		System.out.println("Size: "+s2.size());    // 5 expected
		
		s2.makeEmpty();    // emptying the stack
		
		System.out.println("Size: "+s2.size());    // 0 expected after makeEmpty call
	}

}
