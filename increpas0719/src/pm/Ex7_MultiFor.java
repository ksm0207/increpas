package pm;

public class Ex7_MultiFor {
	public static void main(String[] args) {
		// 출력
		
		// * * * * *
		// * * * * 
		// * * *
		// * *
		// *

		for (int i = 5 ; i > 0 ; i --) { // 5 4 3 2 1
			
			for (int j = 1 ; j <= i;  j ++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
	}
}
