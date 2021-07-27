package pm;

public class Ex1_Main {

	
	public static void main(String[] args) {
		
		// Ex1_Test 라는 클래스의 test() 와 inc()가 필요하다
		// 즉 객체 생성 후 호출하여라.
		Ex1_Test t1 = new Ex1_Test();
		
		// 지역변수 선언
		int value = 10;
		
		// 인자 값 전달
		t1.test(); // Test()
		t1.inc(value); // 11
		
		// 13번행에 있는 value를 출력하면 10
		System.out.println(value);
		
	}
}
