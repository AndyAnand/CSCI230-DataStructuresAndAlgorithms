/**
 * 
 * This class is a implementation of a generic BinaryTreeNode with a 
 * parent, left and right node.
 * @author Andy Gajadhar	
 * @since October 13, 2014
 *
 * @param <E>
 */
public class NodeT<E> implements BinaryTreeNode<E> {
	
	private E element;
	private NodeT<E> parent;
	private NodeT<E> left;
	private NodeT<E> right;
	
	public NodeT(E e, BinaryTreeNode<E> p, BinaryTreeNode<E> l, BinaryTreeNode<E> r){
		element = (E) e;
		left = (NodeT<E>) l;
		right = (NodeT<E>) r;
		parent = (NodeT<E>) p;
	}
	
	@Override
	public E getElement() {
		// TODO Auto-generated method stub
		return element;
	}

	@Override
	public void setElement(E data) {
		// TODO Auto-generated method stub
		element = data;
	}

	@Override
	public BinaryTreeNode<E> getParent() {
		// TODO Auto-generated method stub
		return parent;
	}

	@Override
	public void setParent(BinaryTreeNode<E> p) {
		// TODO Auto-generated method stub
		parent = (NodeT<E>) p;
	}

	@Override
	public BinaryTreeNode<E> getLeft() {
		// TODO Auto-generated method stub
		return left;
	}

	@Override
	public BinaryTreeNode<E> getRight() {
		// TODO Auto-generated method stub
		return right;
	}

	@Override
	public void setLeft(BinaryTreeNode<E> child) {
		// TODO Auto-generated method stub
		left = (NodeT<E>) child;
	}

	@Override
	public void setRight(BinaryTreeNode<E> child) {
		// TODO Auto-generated method stub
		right = (NodeT<E>) child;
	}

	@Override
	public void removeFromParent() {
		// TODO Auto-generated method stub
		if(parent.getLeft().equals(this)){
			parent.setLeft(null);
		}else
			parent.setRight(null);
		parent = null;
	}

}
