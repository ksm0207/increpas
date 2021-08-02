package am;

public class Ex6_Exception {
	
	public static void main(String[] args) throws Exception {
		Ex6_Exception ex6 = new Ex6_Exception();
		
		ex6.ex1();
	}
	
	public void ex1() {
		System.out.println("Ex2() 메소드 호출 결과 : ");
		
		// 호출 지점에서 예외처리 해야함
		try {
			ex2();
		} catch (Exception e) {
			// TODO 예외가 발생한 경우를 순차적으로 하나씩 출력
			e.printStackTrace();
		}
		System.out.println("Ex()2 끝");
	}
	
					  // Exception이 발생했을 떄 호출한 곳으로 이동
	public void ex2() throws Exception {
		System.out.println(10/0);
		System.out.println("Ex2() ");
	}
}
