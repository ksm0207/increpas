package pm;

public class Ex8_MultiFor {
	public static void main(String[] args) {
		
		// 별찍기 (숙제)
		// *
		// * *
		// * * *
		// * * * *
		// * * * * *
		
		// 상단 
		for (int i = 0 ; i < 5 ; i ++) {
			for (int j = 0 ; j <= i ; j ++) {
				System.out.print("* " + " ");
			}
			System.out.println();
		}// end of for loop(1)
		
		// 하단
		for (int i = 5 ; i > 0 ; i --) {
			
			for (int j = 1 ; j <= i ; j ++) {
				System.out.print("* " + " ");
			}
			System.out.println();
		}
		
		
		
	}
}
