package pm;

public class Ex5_MultiFor {
	public static void main(String[] args) {
		// 1. 출력 결과
		// 6  7   8  9
		// 10 11 12 13 
		// 14 15 16
		
		int cnt = 6;
		
		for (int c = 1 ; c <= 3; c ++) { // start for 2 (행의 수를 만듦)
			for (int i = 1 ; i <= 4 ; i ++) { // start for1 (열의 수를 카운트)
				System.out.printf("%-3d",cnt++); // i 대신 cnt ++
			}
			System.out.println();
		}
	}// end of main
}

//for (int i = 1 ; i <=1 ; i ++) {
//	for (int j = 6 ; j <=17 ; j ++) {
//		System.out.printf("%-3d",j);
//		if (j == 9) {
//			System.out.println();
//		}else if (j == 13) {
//			System.out.println();
//		}
//	}
//}