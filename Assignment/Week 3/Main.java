
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 사이클이 있는 단순연결리스트 생성
		var s1 = new SList<Integer>();
		Node<Integer> last1 = s1.head;  // 마지막 노드
		
		for (int i = 0; i < 4; i++) {
			if (last1 == null) {
				s1.insertFront(i);
				last1 = s1.head;
			}
			else {
				s1.insertAfter(i, last1);
				last1 = last1.getNext();
			}
		}
		System.out.print("리스트 s1: "); s1.print();
		
		// 마지막 노드의 next를 head 노드로 설정
		last1.setNext(s1.head);
		System.out.println("마지막 노드의 next 노드 item: " + last1.getNext().getItem());
		
		// 사이클이 있는지 확인
		System.out.println("리스트 s1의 사이클: " + s1.checkCycle());
		
		System.out.println();
		
		// 사이클이 없는 단순연결리스트 생성
		var s2 = new SList<Integer>();
		Node<Integer> last2 = s2.head;  // 마지막 노드
		
		for (int i = 10; i < 14; i++) {
			if (last2 == null) {
				s2.insertFront(i);
				last2 = s2.head;
			}
			else {
				s2.insertAfter(i, last2);
				last2 = last2.getNext();
			}
		}
		System.out.print("리스트 s2: "); s2.print();
		System.out.println("마지막 노드의 next 노드: " + last2.getNext());  // next 노드가 null이기 때문에 getItem()을 호출할 수 없다.
		
		// 사이클이 있는지 확인
		System.out.println("리스트 s2의 사이클: " + s2.checkCycle());
	}

}
