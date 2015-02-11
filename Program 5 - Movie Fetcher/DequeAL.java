import java.util.ArrayList;
import java.util.Iterator;


public class DequeAL<E> implements Deque<E>{
	ArrayList<E> deque;
	
	public DequeAL(){
		this.deque = new ArrayList<>();
	}
	
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return deque.iterator();
	}

	@Override
	public void addFront(E e) {
		// TODO Auto-generated method stub
		deque.add(0, e);
	}

	@Override
	public void addRear(E e) {
		// TODO Auto-generated method stub
		deque.add(deque.size(), e);
	}

	@Override
	public E getFront() {
		// TODO Auto-generated method stub
		return (this.isEmpty()) ? null : deque.get(0);
	}

	@Override
	public E getRear() {
		// TODO Auto-generated method stub
		return (this.isEmpty()) ? null : deque.get(deque.size() - 1);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return deque.isEmpty();
	}

	@Override
	public E removeFront() {
		// TODO Auto-generated method stub
		E element = null;
		
		if(!isEmpty())
			element = deque.remove(0);
		
		return element;
	}

	@Override
	public E removeRear() {
		// TODO Auto-generated method stub
		E element = null;
		
		if(!isEmpty())
			element = deque.remove(deque.size() - 1);
		
		return element;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return deque.size();
	}
	
	public void print(){
		Iterator<E> it = this.iterator();
		
		while(it.hasNext()){
			System.out.print(it.next() + " ");
		}
		System.out.println("\n");
	}
	
}
