package pm.Ex2;

public class Ex2_Outer {
	
	String msg = "대한민국";
	
	public Ex2_Outer() {
		// 생성자 영역
		
		// ↓ 익명클래스
		Ex2_Interface e2 = new Ex2_Interface() {
			
			// 1. Ex2_Interface는 직접 인스턴스를 생성할 수 없음
			// 2. 컴파일러는 현재 영역을 인터페이스로 인식안하고
			// 해당 인터페이스를 구현한 새로운 영역으로 인식함.
			// 즉 Ex2_Interface 를 구현한 클래스 영역으로 영역으로 봄
			@Override
			public void print() {
				System.out.println("바깥쪽 변수 MSG : " + msg);
				
			}
		};
		e2.print(); // 호출 후 메모리 영역에서 사라짐
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
