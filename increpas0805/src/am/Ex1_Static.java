package am;

public class Ex1_Static {
	// 멤버변수 <==> 인스턴스변수 같은 의미
	String str = "대한민국";
	int a = 100;

	// 정적멤버변수 (인스턴스변수 라고 하지 않음 )
	static String msg = "힘내라";
	static int b = 200;
	
	
// 	멤버메소드 <==> 인스턴스메소드
	public void print() {
		System.out.println("String str : " + str);
		System.out.println("int a : " + a);
	}
	
// 	정적멤버메소드 <==> 멤버변수는 들어올 수 없음
	public static void staticPrint() {
		System.out.println("Static msg : " + msg);
		System.out.println("Static b : " + b);
//		System.out.println("Static str" + str);
// 		Error : 정적 필드가 아닌 필드 str을 정적 참조할 수 없습니다.
	}
	
	
	
}
