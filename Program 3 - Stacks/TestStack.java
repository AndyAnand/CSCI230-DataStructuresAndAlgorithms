/**
 * This class tests the stacks implementations in Singly Linked List and 1D array, measuring the execution time 
 * (in milliseconds) for pushing and popping n elements, n starting at 100000 and going until 2000000 skipping 100000 
 * on each iteration.
 * 
 * @author Andy Gajadhar
 * @since September 16, 2014
 */
public class TestStack {
	/**
	 * run executes the tests over the stacks adt implementations in singly linked list and 1d array printing
	 * the execution times in milliseconds
	 */
	public void run(){
		
		StackA stackArray = new StackA();    // stack implementation in array
		StackL<Integer> stackList = new StackL<>();    // stack implementation in singly linked list
		ExecutionTimer stopwatch = new ExecutionTimer();     // a stopwatch for measuring execution time
		int n = 100000;    // intitial value of push and pops 
		
		while(n < 2000001){
		
			stopwatch.start();    // starts timing
			
			// pushing and popping in the stack that uses array
			for(int i = 0; i < n; i++){
				stackArray.push(i);
			}
			
			for(int i = 0; i < n; i++){
				stackArray.pop();
			}
			
			stopwatch.stop();    // stops timing
			
			System.out.println("Stack with array implentation test:");
			System.out.println("To push and pop "+n+" values took "+stopwatch.durationInMilliseconds()+" milliseconds");
			
			stopwatch.reset();    // reseting stopwatch for a new measure 
			
			
			stopwatch.start();
			
			//pushing and popping in the stack that uses Singly Linked List
			for(int i = 0; i < n; i++){
				stackList.push(i);
			}
			
			for(int i = 0; i < n; i++){
				stackList.pop();
			}
			
			stopwatch.stop();
			
			System.out.println("Stack with list implentation test:");
			System.out.println("To push and pop "+n+" values took "+stopwatch.durationInMilliseconds()+" milliseconds");
			
			stopwatch.reset();  
			
			n += 100000;
			
			// preparing structures for the next iteration
			stackArray.makeEmpty();
			stackList.makeEmpty();
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestStack test = new TestStack();
		test.run();
		
	}

}
