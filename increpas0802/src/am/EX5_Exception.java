package am;

public class EX5_Exception {
	
	public static void main(String[] args) {
		try {
			System.out.println(10/0);
		}finally {
			// 문법적인 오류는 아니지만
			// 예외처리를 한 것도 아니다
		}
	}
}
