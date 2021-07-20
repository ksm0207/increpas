package am;

public class Ex1_MultiFor {
	public static void main(String[] args) {
		
		// [결과]
		//   * * * * *
		//     * * * *
		//       * * *
		//         * *
		//           *
		String res = "";
		for (int i = 0 ; i <= 5 ; i ++) {
			
			for (int j = 1 ; j <= 5; j ++ ) {
				res = (i < j) ?  ("* ") : ("  ");
			
				System.out.print(res);
			}// end of for loop(2)
			System.out.println();
		}// end of for loop(1)
	}
}
