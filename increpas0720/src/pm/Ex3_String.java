package pm;

public class Ex3_String {
	public static void main(String[] args) {
		
		String str = "Test"; // 초기화 작업
		                 // 암시적 객체생성
		                 // String 객체게만 주어지는 객체 생성법
		
		
		String s1 = new String("Test"); 
					     // 명시적 객체생성
						 // 객체들이 생성할 때 사용하는 생성법
		if (str == s1) {
			System.out.println("서로 주소가 같다");
		}else {
			System.out.println("서로 주소가 다르다");
		}
		
		if (str.equals(s1)) {
			System.out.println("서로 내용이 같다");
		}else {
			System.out.println("서로 내용이 다르다");
		}
		
	}
}
