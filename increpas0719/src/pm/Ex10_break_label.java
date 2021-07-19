package pm;

public class Ex10_break_label {
	public static void main(String[] args) {
		
		bk:for (int i = 0 ; i < 4 ; i ++) {
			for (int j = 0 ; j < 5 ; j ++) {
				System.out.printf("%-2d" , j+1);
				// 3의 배수를 만나면 반복문 탈출
				if ( (j+1) %3 ==0 ) {
					break bk; // label을 붙이면 for(1) 문을 탈출한다
				}
			} // end of for(2)
			System.out.println();
		}// end of for(1)
	}
}
