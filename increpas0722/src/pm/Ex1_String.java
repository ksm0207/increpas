package pm;

public class Ex1_String {
	public static void main(String[] args) {
		
		String str = "1.문자열";
		
		str = str + 2 + ".문자열";
		System.out.println(str);
		
		// + 는 피연산자 중 문자열이 있으면
		// + 피연산자는 String 으로 바뀌고 Heap 영역에 새로운 "2" 가 생긴다
		// 문자열의 불변적 특징으로 인해 내부적 변경이 이루어질 수 없음!
		// 변경된 것 처럼 보이지만 변경된 것이 아니라 새롭게 객체가 생성됨
		
		
		
	}
}
