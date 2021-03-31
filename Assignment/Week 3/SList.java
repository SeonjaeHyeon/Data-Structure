import java.util.NoSuchElementException;

public class SList <E extends Comparable<E>> {
	protected Node<E> head;
	private int size;
	
	public SList() {
		head = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public int search(E target) {
		Node<E> p = head;
		
		for (int k = 0; k < size; k++) {
			if (target == p.getItem()) {
				return k;
			}
			p = p.getNext();
		}
		
		return -1;
	}
	
	public void insertFront(E newItem) {
		head = new Node<E>(newItem, head);
		size++;
	}
	
	public void insertAfter(E newItem, Node<E> p) {
		p.setNext(new Node<E>(newItem, p.getNext()));
		size++;
	}
	
	public void deleteFront() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		head = head.getNext();
		size--;
	}
	
	public void deleteAfter(Node<E> p) {
		if (p == null) {
			throw new NoSuchElementException();
		}
		
		Node<E> t = p.getNext();
		if (t == null) {
			throw new NoSuchElementException();
		}
		p.setNext(t.getNext());
		t.setNext(null);
		size--;
	}
	
	public boolean checkCycle() {
		Node<E> p = head;
		
		for (int i = 0; i < size; i++) {
			p = p.getNext();
		}
		
		if (p != null) return true;
		
		return false;
	}
	
	public void print() {
		Node<E> p = head;
		
		while (p != null) {
			System.out.print(p.getItem() + "   ");
			p = p.getNext();
		}
		System.out.println();
	}
}
