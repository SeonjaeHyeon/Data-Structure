
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("연습문제 2.17");
		
		int[] list1 = {1, 5, 9};
		int[] list2 = {2, 3, 6, 7, 8};
		
		var s1 = new SList<Integer>();
		var s2 = new SList<Integer>();
		
		for (int i = list1.length - 1; i >= 0; i--) {
			s1.insertFront(list1[i]);
		}
		for (int i = list2.length - 1; i >= 0; i--) {
			s2.insertFront(list2[i]);
		}
		
		System.out.print("첫번째 단순연결리스트: "); s1.print();
		System.out.print("두번째 단순연결리스트: "); s2.print();
		
		s1.merge(s2);
		System.out.print("합친 후 첫번째 단순연결리스트: "); s1.print();
		
		int[] list3 = {9, 8, 2, 4, 7, 6};
		int k = 7;
		
		var s3 = new SList<Integer>();
		for (int i = list3.length - 1; i >= 0; i--) {
			s3.insertFront(list3[i]);
		}
		
		System.out.println("\n연습문제 2.20");
		System.out.print("분리 전 단순연결리스트: "); s3.print();
		System.out.println("정수 k: " + k);
		
		Object[] result = s3.split(k);
		var t1 = (SList<Integer>) result[0];
		var t2 = (SList<Integer>) result[1];
		
		System.out.print("분리 후 첫번째 단순연결리스트: "); t1.print();
		System.out.print("분리 후 두번째 단순연결리스트: "); t2.print();
	}

}
