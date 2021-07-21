package am;

public class Ex1_String {
	public static void main(String[] args) {
		
		String s1 = "TEST";
		String s2 = new String("Test");
		String s3 = "Test";
		
		System.out.println(System.identityHashCode(s1)); // 2104457164 210.445.7164
		System.out.println(System.identityHashCode(s2)); // 1521118594 152.111.8594
		System.out.println(System.identityHashCode(s3)); // 2104457164 210.445.7164
		
		if (s1 == s2) {
			System.out.println("주소가 같다");
		}else {
			System.out.println("주소가 다르다");
		}
		if (s1 == s3) {
			System.out.println("s1 == s3 " + true);
		}else {
			System.out.println("s1 == s3" + false);
		}
		
		// 내용비교
		
		if (s1.equals(s2)) {
			System.out.println(" 같은 내용 입니다.");
		}else {
			System.out.println(" 다른 내용 입니다.");
		}
		
		if (s2.equals(s3)) {
			System.out.println(" 같은 내용 입니다.");
		}else {
			System.out.println(" 다른 내용 입니다.");
		}
		
		// 대소문자 비교
		if (s1.equalsIgnoreCase(s2)) {
			System.out.println(" 같은 내용 입니다.");
		}else {
			System.out.println(" 다른 내용 입니다.");
		}
	}
}
