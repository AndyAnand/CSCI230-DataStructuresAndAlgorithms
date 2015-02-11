/**
 * This is a partial interface of a Binary Tree, containing the necessary functions for this assignment
 * @author Andy Gajadhar
 * @since October 13, 2014
 *
 * @param <E>
 */


public interface BinaryTreeADT<E> {
	
	/**
	 * addRoot creates a new root for the tree containing e
	 * @param e
	 * 			an element
	 * @return
	 * 			the inserted node in the three
	 */
	
	public NodeT<E> addRoot(E e);
	
	/**
	 * getRoot retrieves the root of the tree
	 * @return the root of the tree
	 */
	public NodeT<E> getRoot();
	
	/**
	 * addRight adds a node to the right of another node
	 * @param n    a binary tree node
	 * @param e    the element to be stored at the right of n
	 * @return    the inserted node
	 */
	
	public NodeT<E> addRight(BinaryTreeNode<E> n, E e);
	
	/**
	 * addRight adds a node to the left of another node
	 * @param n    a binary tree node
	 * @param e    the element to be stored at the left of n
	 * @return    the inserted node
	 */
	
	public NodeT<E> addLeft(BinaryTreeNode<E> n, E e);
	
	/**
	 * inOrder() performs a inorder traversal in the tree collecting the node`s elements
	 * @return a collection containing the elements collected in the traversal
	 */
	
	public Iterable<E> inOrder();
	
	/**
	 * preOrder() performs a preorder traversal in the tree collecting the node`s elements
	 * @return a collection containing the elements collected in the traversal
	 */
	
	public Iterable<E> preOrder();
	
	/**
	 * postOrder() performs a postorder traversal in the tree collecting the node`s elements
	 * @return a collection containing the elements collected in the traversal
	 */
	
	public Iterable<E> postOrder();
	
	/**
	 * size gets the number of nodes of this tree
	 * @return a int with the number of nodes of this tree
	 */
	
	public int size();
}
