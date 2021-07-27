package am;

public class Ex1_Main {
	
	public void t1(Ex1_Class ex1) {
		ex1.inc();
	}
	
	public static void main(String[] args) {
		
		// ----------------------------------------
		
		// 필요한 메소드를 가진 객체를 생성한다
		Ex1_Class ex1 = new Ex1_Class();
		
		int value = ex1.getReturnValue();
		System.out.println(value);
		
		ex1.inc(); // 1 증가
		value = ex1.getReturnValue();
		System.out.println(value);
		
//		System.out.println(ex1.check(value));
		
		// ----------------------------------------
		
		// t1 이라는 메서드를 호출하기 
		Ex1_Main m1 = new Ex1_Main();
		m1.t1(ex1); // 주소값 넣기

		System.out.println(ex1.getReturnValue());
	
	}
}
