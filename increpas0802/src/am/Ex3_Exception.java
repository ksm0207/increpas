package am;

public class Ex3_Exception {
	public static void main(String[] args) {
		
		try {
			System.out.println(10/0);
			System.out.println("RES=======>>> ");
		}catch (Exception e) {
			// TODO: 올래 발생하는 예외는
			//       ArithmeticException 이지만 (자식클래스)
			//       부모클래스 Exception 으로 처리가능하다
			
			System.out.println("예외 발생 ! :" + e);	
		}finally {
			// 예외가 발생하거나 , 않거나 무조건 수행하는 곳
			System.out.println("Finally =======>");
		}
		
	}
}
