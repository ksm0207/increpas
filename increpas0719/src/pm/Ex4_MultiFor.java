package pm;

public class Ex4_MultiFor {
	public static void main(String[] args) {
		
		
		// 출력
		// 1 2 3 4 5
		// 1 2 3 4 5
		
//		for (int i = 1 ; i <= 5 ; i ++) {
//			System.out.printf("%-2d",i);
//		}
//		System.out.println();
//		for (int i = 1 ; i <= 5 ; i ++) {
//			System.out.printf("%-2d",i);
//		}
		
		// 안쪽에 있는 문장을 2번 반복하는 중첩for문
		for (int i = 1 ; i<=2 ; i ++) {
			for (int j = 1 ; j <= 5 ; j ++) {
				System.out.printf("%-2d",j);
			}
			System.out.println();
		}
	}
}
