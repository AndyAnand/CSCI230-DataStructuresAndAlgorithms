

public class Node<E>{
	private E element;
	private Node<E> next;
	
	public Node(){
		this.element = null;
		this.next = null;
	}
	
	public Node(E e, Node<E> n){
		this.element = e;
		this.next = n;
	}
	
	public E getElement(){
		return this.element;
	}
	
	public void setElement(E e){
		this.element = e;
	}
	
	public Node<E> getNext(){
		return this.next;
	}
	
	public void setNext(Node<E> n){
		this.next = n;
	}
}
