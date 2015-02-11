package library;

/** 
This class is a SinglyLinkedList implementation of List ADT
@author Andy Gajadhar
@since September 1, 2014
NOTE: Everything was tested and found to be working, that is: all methods, some of the tests are commented in the end of the class
*/ 

public class SinglyLinkedList<E> implements ListInterface<E>{
	private Node<E> head;	// the beginning of the LinkedList
	private Node<E> tail;	// the end of the LinkedList
	private Integer length;  // keeps tracking list's size
	
	// constructor 
	public SinglyLinkedList() {
		// TODO Auto-generated constructor stub
		length = 0;    // initially the linkedlist has no elements
		head = null;    // head points to nothing, since there are no elements
		tail = null;    // tail points to nothing, since there are no elements
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return length;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return length == 0;
	}
	
	@Override
	public E getFirst() {
		// TODO Auto-generated method stub
		if(isEmpty()){    //if the linked list is empty, there is no head
			return null;
		}else{
			return head.getElement();
		}
	}

	@Override
	public E getLast() {
		// TODO Auto-generated method stub
		if(isEmpty()){    //if the linked list is empty, there is no tail
			return null;
		}else{
			return tail.getElement();
		}
	}

	@Override
	public void addFirst(E e) {
		// TODO Auto-generated method stub
		if(isEmpty()){    //when the linked list has no elements, the first one will also be the tail
			head = tail = new Node<E>(e,null);
		}else{
			head = new Node<E>(e, head);    //head will point to the newest create node and the newest created node will point to the old head
		}
		this.length++;
	}

	@Override
	public void addLast(E e) {
		// TODO Auto-generated method stub
		if(isEmpty()){
			tail = head = new Node<E>(e,null);    //when the linked list has no elements, the last one will also be the head
		}else{
			Node<E> newNode = new Node<E>(e, null);
			tail.setNext(newNode);    
			tail = newNode;    // the new tail will be the newest created node
		}
		this.length++;
	}

	@Override
	public E removeElementAtPosition(int listPosition) {
		// TODO Auto-generated method stub
		Node<E> current = head;    // while iterating through the linked list, current will always contain the actual element of the actual iteration
		Node<E> previous = null;    // will contain the previous iterated element, needed when there is a remotion of an element with neighborhood or when removing the tail of the linked list 
		
		if(isEmpty()){
			return null;
		}else{
			for(int i = 1; i < listPosition; i++){    // looping until current contains listPosition-th element of the list
				previous = current;
				current = current.getNext();
			}
			
			if(head == tail){    // just happens when there is only one element, so the list will be emptied 
				head = null;
				tail = null;
			}else if(current == head){    // removing an element in the beginning of the linked list
				 head = current.getNext();
			}else if(current == tail){    // removing an element in the end of the linked list	
				tail = previous;
			}else{    // removing an element that is between two elements
				previous.setNext(current.getNext());    //skipping current node (letting garbage collector do the job after method returns)
			}
			
			this.length--;
			
			return current.getElement();

		}
	}

	@Override
	public E getElementAtPosition(int listPosition) {
		// TODO Auto-generated method stub
		Node<E> node = head;    // node is a reference used to navigate through the sequence of next nodes, starting from the head of the list
		
		if(isEmpty()){
			return null;
		}
		
		for(int i = 1; i < listPosition; i++){
			node = node.getNext();
		}
		
		return node.getElement();
	}
	
	public ListIterator<E> getIterator(){
		return new ListIteratorImpl<E>(this);
	}
	
	/*
	private void printList(){
		System.out.print("{");
		Node<E> n = head;
		for(int i = 0; i < this.size(); i++){
			System.out.print(n.getElement()+ " ");
			n = n.getNext();
		}
		System.out.println("}");
	}
	
	public static void main(String[] args){
		SinglyLinkedList<Integer> ll = new SinglyLinkedList<>();
		System.out.println("Must be true, is it true? "+ ll.isEmpty());
		ll.addFirst(6);
		ll.addFirst(7);
		ll.addFirst(8);
		ll.addFirst(9);
		ll.printList();
		ll = new SinglyLinkedList<>();
		ll.addFirst(9);
		ll.addFirst(8);
		ll.addFirst(7);
		ll.addFirst(6);
		ll.printList();
		System.out.println(ll.getFirst());
		System.out.println(ll.getLast());
		System.out.println(ll.size());
		System.out.println(ll.removeElementAtPosition(1));
		System.out.println("Must be false, is it false? "+ ll.isEmpty());
		System.out.println(ll.removeElementAtPosition(1));
		System.out.println(ll.removeElementAtPosition(1));
		System.out.println(ll.removeElementAtPosition(1));
		System.out.println("Must be true, is it true? "+ ll.isEmpty());
		System.out.println("Must be null, is it null? "+ ll.getElementAtPosition(1));
		
		ll.printList();
		
		ll = new SinglyLinkedList<>();
		ll.addFirst(9);
		ll.addFirst(8);
		ll.addFirst(7);
		ll.addFirst(6);
		System.out.println(ll.getElementAtPosition(1));
		System.out.println("Must be false, is it false? "+ ll.isEmpty());
		System.out.println(ll.getElementAtPosition(2));
		System.out.println(ll.getElementAtPosition(3));
		System.out.println(ll.getElementAtPosition(4));
		ll.printList();
	}
	*/
}
