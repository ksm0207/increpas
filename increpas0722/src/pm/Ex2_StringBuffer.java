package pm;

public class Ex2_StringBuffer {
	
	public static void main(String[] args) {
		
		StringBuffer sb1 = new StringBuffer("1.문자열");
		StringBuffer sb2 = sb1;
		// StringBuffer : 문자열 편집이 용이한 클래스
		
		if (sb2 == sb1) {
			System.out.println(true);
		}
		
		// String 과 StringBuffer 의 움직임이 다름
		
		sb1 = sb1.append(" 2.문자열");
		
		if (sb1 == sb2) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		
		System.out.println(System.identityHashCode(sb1));
		System.out.println(System.identityHashCode(sb2));
		
		// 버퍼 : 임시기억장소 , 내부에 임시기억장소 가 있다고 생각하면됨
		// append() 를 호출하면 버퍼에서 수정 작업하는 방식
		
		System.out.println(sb1);
		System.out.println(sb2);
		
		// 0번지 부터 3번지 직전 까지 잘린다
		// 1.문자열 --> 1.문
		sb2.delete(0, 3);
		System.out.println(sb1);
		
		System.out.println(sb2.getClass());
		
		
		System.out.println("toString() : + "+sb2.toString().getClass());
	}
}
