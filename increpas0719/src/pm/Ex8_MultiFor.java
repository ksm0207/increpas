package pm;

public class Ex8_MultiFor {
	public static void main(String[] args) {
		
		// 별찍기 (숙제)
		// *
		// * *
		// * * *
		// * * * *
		// * * * * *
		
		for (int i = 0 ; i < 5 ; i ++) {
			for (int j = 0 ; j <= i ; j ++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
