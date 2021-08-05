package am;

public class Ex2_Static {
	
	String msg = "Test";
	
	static int su1 = getValue();
	static int su2 = 10;
	
	// 생성자 , 생성하려 할때 호출
	public Ex2_Static() {
		System.out.println("Ex2_Static 생성자 호출");
	}
	
	// 메소드도 같은 static 영역끼리 붙여야 오류가 발생하지않음
	// 호출 우선도가 제일 높다
	public static int getValue() {
		System.out.println("getValue()");
		return 100;
	}

	
}
