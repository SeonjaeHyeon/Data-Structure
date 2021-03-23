import java.util.NoSuchElementException;

public class SList <E extends Comparable<E>> {
	protected Node<E> head;
	private int size;
	
	public SList() {
		head = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return head == null;
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
	
	public void merge(SList<E> o) {
		Node<E> p = null;  // 현재 노드
		Node<E> b = null;  // 이전 노드
		Node<E> q = o.head;  // 다른 리스트의 현재 노드

		for (int i = 0; i < o.size(); i++) {
			p = head;
			
			while (p != null) {
				if (p.compareTo(q) >= 0) {  // 리스트의 현재 값이 다른 리스트의 현재 값보다 크거나 같을 때
					if (b == null) {
						insertFront(q.getItem());  // 리스트의 맨앞에 값을 추가하는 경우
					}
					else {
						insertAfter(q.getItem(), b);  // 리스트의 중간에 값을 추가하는 경우
					}
					
					break;
				}
				
				b = p;
				p = p.getNext();
			}
			
			if (p == null && size > 0) {  // 리스트의 맨마지막에 값을 추가하는 경우
				insertAfter(q.getItem(), b);
			}
			
			q = q.getNext();
		}
		
	}
	
	public Object[] split(E delimiter) {
		SList<E> s1 = new SList<E>();
		SList<E> s2 = new SList<E>();
		
		Node<E> p = head;
		
		while (p != null) {
			E item = p.getItem();
			
			if (item.compareTo(delimiter) <= 0) {  // 구분자 값보다 같거나 작을 경우
				s1.insertFront(item);
			}
			else {  // 구분자 값보다 클 경우
				s2.insertFront(item);
			}
			
			p = p.getNext();
		}
		
		return new Object[] {s1, s2};
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
