package increpas_example02;

public class OperTest2 {
	public static void main(String[] args) {
		// 1. 연습문제 2번 결과 예측하기
		int a = 10;
		int b = 20;

		
		System.out.println(++a); // 11
		System.out.println(++ a + b ++); // 12 + 20 = 32
		
		System.out.println
		(							   //     1    +    286    = 287
				(++a % 3) +  (a * ++b) // (13 % 3) + (13 * 22) = 287
		);
	}
}
