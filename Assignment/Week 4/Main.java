
public class Main {
	
	public static void checkPair(String str) {
		ListStack<String> stack = new ListStack<String>();
		String[] array = str.split(" ");
		boolean isPair = true;
		String result = "";
		
		for (String s: array) {
			result += s + " ";
			
			if (s.equals("{") || s.equals("(")) {
				stack.push(s);
			}
			else {
				if (stack.isEmpty()) {
					isPair = false;
					break;
				}
				
				String tmp = stack.pop();
				if (tmp.equals("{") && s.equals(")") || tmp.equals("(") && s.equals("}")) {
					isPair = false;
					break;
				}
			}
			
			System.out.print("스택: ");
			stack.print();
		}
		
		System.out.print("\n결과: ");
		if (stack.isEmpty() && isPair) {  // 괄호 짝이 맞는 경우
			System.out.println("괄호 짝이 맞습니다.");
		}
		else {  // 괄호 짝이 맞지 않는 경우
			System.out.println("괄호 짝이 맞지 않습니다.");
			System.out.println(result + "<-- 맞지 않는 부분");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("현선재 / 60201716 / DS과제 #4\n");
		
		String str1 = "{ { ( ) { ( ) } } }";
		String str2 = "{ { ( ) { ( ) } ) ( ) }";
		
		System.out.println("예제1: " + str1);
		checkPair(str1);
		
		System.out.println("\n예제2: " + str2);
		checkPair(str2);
	}

}
