import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Binary Tree ADT implementation
 * @author Andy Gajadhar		
 * @since October 13, 2014
 * 
 * @param <E>
 */

public class BinaryTree<E> implements BinaryTreeADT<E> {
	private NodeT<E> root;   
	private int size;
	
	/**
	 * A constructor that builds an expression tree
	 * @param exp a string representing the expression
	 */
	
	public BinaryTree(String exp){
		size = 0;
		buildTree(exp);
	}
	
	@Override
	public NodeT<E> addRoot(E e) {
		// TODO Auto-generated method stub
		root = new NodeT<>(e, null, null, null);
		size++;
		
		return root;
	}

	@Override
	public NodeT<E> addRight(BinaryTreeNode<E> n, E e) {
		// TODO Auto-generated method stub
		NodeT<E> right = new NodeT<>(e,n,null,null);
		n.setRight(right);
		size++;
		
		return right;
	}

	@Override
	public NodeT<E> addLeft(BinaryTreeNode<E> n, E e) {
		// TODO Auto-generated method stub
		NodeT<E> left = new NodeT<>(e,n,null,null);
		n.setLeft(left);
		size++;
		
		return left;
	}
	
	/**
	 * buildTree recursively constructs a expression tree given a string
	 * representing the expression
	 * 
	 * @param exp a expression
	 * 
	 */
	private void buildTree(String exp){
		E[] tokens = (E[]) exp.split(",");     //just making it working 
		ArrayList<E> tokensList = new ArrayList<>();
		
		for(int i = 0; i < tokens.length; i++){
			tokensList.add(tokens[i]);
		}
		this.addRoot(tokens[0]);
		
		buildInternal(this, this.getRoot(), tokensList);    //recursively builds the expression tree
		
	}
	
	/**
	 * recursively does a inorder transversal in a subtree of root n
	 * @param n    the root of the subtree
	 * @param sequence    a linkedlist for storing the elements found in the nodes
	 */
	
	private void inOrderTransverse(NodeT<E> n, LinkedList<E> sequence) {
		// TODO Auto-generated method stub
		if(n.getLeft() != null && n.getRight() != null)    //if it is not a leaf
			sequence.add((E) "(");
		if(n.getLeft() != null){    //goes left
			inOrderTransverse((NodeT<E>)n.getLeft(),sequence);
		}
		
		sequence.add(n.getElement());    //visiting
		
		if(n.getRight() != null){    //goes right
			inOrderTransverse((NodeT<E>)n.getRight(),sequence);
		}
		if(n.getLeft() != null && n.getRight() != null)
			sequence.add((E) ")");
	}

	/**
	 * recursively does a preorder transversal in a subtree of root n
	 * @param n    the root of the subtree
	 * @param sequence    a linkedlist for storing the elements found in the nodes
	 */
	
	private void preOrderTransverse(NodeT<E> n, LinkedList<E> sequence) {
		// TODO Auto-generated method stub
		sequence.add(n.getElement());    //visiting
		if(n.getLeft() != null){    //goes left
			preOrderTransverse((NodeT<E>)n.getLeft(),sequence);
		}
		if(n.getRight() != null){    //goes right
			preOrderTransverse((NodeT<E>)n.getRight(),sequence);
		}
	}
	
	/**
	 * recursively does a postorder transversal in a subtree of root n
	 * @param n    the root of the subtree
	 * @param sequence    a linkedlist for storing the elements found in the nodes
	 */
	
	private void postOrderTransverse(NodeT<E> n, LinkedList<E> sequence) {
		// TODO Auto-generated method stub
		if(n.getLeft() != null){    //goes left
			postOrderTransverse((NodeT<E>)n.getLeft(),sequence);
		}
		if(n.getRight() != null){    //goes right
			postOrderTransverse((NodeT<E>)n.getRight(),sequence);
		}
		sequence.add(n.getElement());
	}
	
	public boolean isEmpty(){
		return size == 0;
	}

	@Override
	public Iterable<E> inOrder() {
		// TODO Auto-generated method stub
		LinkedList<E> sequence = new LinkedList<>();
		
		if(!isEmpty()){
			inOrderTransverse(getRoot(), sequence);
		}
		return sequence;
	}

	@Override
	public Iterable<E> preOrder() {
		// TODO Auto-generated method stub
		LinkedList<E> sequence = new LinkedList<>();
		
		if(!isEmpty()){
			preOrderTransverse(getRoot(), sequence);
		}
		return sequence;
	}

	@Override
	public Iterable<E> postOrder() {
		// TODO Auto-generated method stub
		LinkedList<E> sequence = new LinkedList<>();
		
		if(!isEmpty()){
			postOrderTransverse(getRoot(), sequence);
		}
		return sequence;
	}

	@Override
	public NodeT<E> getRoot() {
		// TODO Auto-generated method stub
		return root;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	/**
	 * 
	 * buildInternal builds the expression tree recursively, according to the prefix traversal
	 * 
	 * NOTE: using the prefix traversal logic
	 * @param bt    a expression binary tree
	 * @param node   a tree node
	 * @param tokens    terms of the expression
	 */
	
	private void buildInternal(BinaryTree<E> bt, BinaryTreeNode<E> node, ArrayList<E> tokens){
		node.setElement(tokens.get(0));    //fill the node
		
		//when there is no more tokens or when a leaf is found(a number), this method must return 
		if(tokens.isEmpty() || !((String) tokens.get(0)).matches("[+|-|*|/]")){    // hard coding for the string type
			return;
		}
		
		//create node left and descend on it recursively
		tokens.remove(0);  //advances to the next token
		buildInternal(bt,bt.addLeft(node, null),tokens);    //goes to left
		tokens.remove(0);
		buildInternal(bt,bt.addRight(node, null),tokens);
		
	}
}
