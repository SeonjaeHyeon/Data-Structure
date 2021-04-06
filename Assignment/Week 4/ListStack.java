import java.util.EmptyStackException;

public class ListStack<E> {
	private Node<E> top;
	private int size;
	
	public ListStack() {
		top = null;
		size = 0;
	}
	
	public int size() { return size; }
	
	public boolean isEmpty() { return size == 0; }
	
	public E peek() {
		if (isEmpty())
			throw new EmptyStackException();
		
		return top.getItem();
	}
	
	public void push(E newItem) {
		Node<E> newNode = new Node<E>(newItem, top);
		
		top = newNode;
		size++;
	}
	
	public E pop() {
		if (isEmpty())
			throw new EmptyStackException();
		
		E topItem = top.getItem();
		top = top.getNext();
		size--;
		
		return topItem;
	}
	
	public void print() {
		Node<E> p = top;
		
		while (p != null) {
			System.out.print(p.getItem() + "   ");
			p = p.getNext();
		}
		System.out.println();
	}
}
