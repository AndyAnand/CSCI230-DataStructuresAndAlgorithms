package library;

/** 
This class is an implementation of the generic ListIterator interface for our SinglyLinkedList
@author Andy Gajadhar
@since September 2, 2014
*/ 

public class ListIteratorImpl<E> implements ListIterator<E> {
	private SinglyLinkedList<E> list;
	private Integer position;
	
	public ListIteratorImpl(SinglyLinkedList<E> list) {
		// TODO Auto-generated constructor stub
		this.list = list;
		this.position = 1;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(position <= list.size()){
			return true;
		}else
			return false;
	}

	@Override
	public E next() {
		// TODO Auto-generated method stub
		if(hasNext()){
			return list.getElementAtPosition(position++);
		}else
			return null;
	}
	
	public void remove(){
		list.removeElementAtPosition(position);
	}

}
