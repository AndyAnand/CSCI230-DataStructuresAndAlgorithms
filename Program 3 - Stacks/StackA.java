/**
 * This class implements the Stack ADT using an 1D array for storing data
 * 
 * @author Andy Gajadhar
 * @since September 14, 2014
 * 
 * NOTE: Everything was tested and found to be working, that is: all methods
 */
public class StackA implements StackInterface<Integer>{
	
	private int capacity;    // actual quantity of elements that the stack can contain
	private int top;    // indicate the top index of the stack
	private Integer[] stack;    // using an 1D array for implementing the stack
	
	public StackA() {
		// TODO Auto-generated constructor stub
		capacity = 1000;
		top = -1;    // top will move from left to right (down to up, if thinking in a vertical view), thus starting in -1 , one position before 0 (the first possible index for top)
		stack = new Integer[capacity];   
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top == -1;    
	}

	@Override
	public Integer peak() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			return null;
		}else{
			return stack[top];
		}
	}

	@Override
	public void push(Integer x) {
		// TODO Auto-generated method stub
		
		if(isFull()){
			capacity *= 2;    // double the stack`s capacity
			stack = resizeStack(stack, capacity);    // allocates more memory, doubling the old stack occupied memory space and so being able to handle more size() push operations
		}
		
		stack[++top] = x;    // filling the new top
		
	}

	@Override
	public Integer pop() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			return null;
		}else if(isAlmostEmpty()){    // cuts down by the half the memory space occupied by the stack since it is not needed 
			capacity /= 2;
				
			stack = resizeStack(stack, capacity);    // resizing stack cutting its size by the half
		}
		
		Integer element = stack[top--];    // saves the stack`s peak value for return it and updates top
		
		return element;
	}

	@Override
	public void makeEmpty() {
		// TODO Auto-generated method stub
		top = -1;    // to make the stack empty, just need to put top right before the 0 index (possible first top)
	}
	
	/**
	 * isFull checks if the stack is full
	 * @return true if the stack is full, false otherwise
	 */
	
	private boolean isFull(){
		return size() == capacity;
	}
	
	/**
	 * size calculates the number of elements in the stack
	 * @return the stack`s size
	 */
	
	public int size(){
		return top+1;
	}
	
	/**
	 * resizeStack resizes a given stack to the new desired capacity
	 * copying as many values as possible from the old stack to the new stack
	 * 
	 * @param oldStack
	 *                the stack to be resized
	 * @param newCapacity
	 *                   the capacity of the new stack
	 * @return the new stack (array)
	 */
	
	private Integer[] resizeStack(Integer[] oldStack, int newCapacity){
		
		Integer[] newStack = new Integer[newCapacity];
		
		int limit = Math.min(oldStack.length, newCapacity);
		
		for(int i = 0; i < limit; i++){
			newStack[i] = oldStack[i];
		}
		
		return newStack;
	}
	
	/**
	 * isAlmostEmpty checks if the num of elements in the stack is below a quarter of the actual stacks`s capacity
	 * @return true if the num of elements in the stacks falls below stack`s capacity/4, false otherwise
	 */
	
	private boolean isAlmostEmpty(){
		
		if(size() < capacity/4.0){
			return true;
		}
		
		return false;
	}
	
	/**
	 * printStack prints all elements of the stack, used for testing
	 */
	
	private void printStack(){
		System.out.print("{");
		
		for(int i = 0; i < size(); i++){
			System.out.print(stack[i] + " ");
		}
		
		System.out.println("}");
	}
	
	public static void main(String[] args){
		StackA s1 = new StackA();
		System.out.println("Size in memory: "+s1.stack.length);    // just to know, expected to be 1000
		System.out.println("Size: "+s1.size());    // expected to be 0
		System.out.println("Peak: " + s1.peak());    // null expected, since there is no element
		System.out.println("Popped: "+s1.pop());
		
		s1.push(1);
		s1.push(2);
		s1.push(3);
		s1.push(4);
		
		s1.printStack();    // {1 2 3 4 } <- top 
		
		System.out.println("Size: "+s1.size());     // expected 4
		System.out.println("Peak: "+s1.peak());    // 4
		s1.printStack();    // {1 2 3 4 } <- top
		System.out.println("Popped: "+s1.pop());    // 4 removed
		System.out.println("Popped: "+s1.pop());    // 3 removed
		System.out.println("Popped: "+s1.pop());	// 2 removed
		System.out.println("Popped: "+s1.pop());	// 1 removed
		
		s1.printStack();    // {}
		System.out.println("Size: "+s1.size());    // 0 expected
		s1.push(1);
		System.out.println("Size: "+s1.size());    // 1 expected
		s1.makeEmpty();    // logically clearing stack
		System.out.println("Size: "+s1.size());    // 0 expected
		
		for(int i = 0; i < 5000000; i++){
			s1.push(i);
		}
		
		System.out.println("Size: "+s1.size());    // expected to be 5000000
		
		
		s1.makeEmpty();
		
		System.out.println("Size: "+s1.size());    // expected to be empty
		
	}
}
