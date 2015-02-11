//Based on an interface by Mark Allen Weiss. Modified by C. Starr

// StackInterface
//
// ******************PUBLIC OPERATIONS*********************
// void push( x )         --> Insert x
// Object pop( )          --> Remove most recently inserted item
// Object peak( )         --> Return most recently inserted item
// boolean isEmpty( )     --> Return true if empty; else false
// void clearStack( )      --> Remove all items from the stack

public interface StackInterface<E>
{
	
	   /**
     * Test if the stack is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( );

    
    /**
     * Get the most recently inserted item in the stack.
     * Does not alter the stack.
     * @return the most recently inserted item in the stack.
     */
    public E peak( );

    
    /**
     * Insert a new item into the stack.
     * @param x the item to insert.
     */
    public void push(E x );
    
    
    /**
     * Remove and return the most recently inserted item
     * from the stack.
     * @return the most recently inserted item in the stack.
     */
    public E pop( );

  
    /**
     * Make the stack logically empty.
     */
    public void makeEmpty( );

}
