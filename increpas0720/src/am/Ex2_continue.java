package am;

public class Ex2_continue {
	public static void main(String[] args) {
		
		bk:for (int i = 0 ; i < 5 ; i ++ ) {
		
			for (int j = 0 ; j < 5 ; j ++) {		
				
				// 3의 배수를 만나면 출력하지 말자! 
				// 어떻게 ? : 앞에서 비교하면됨
				if ((j +1) %3 == 0 ) {
					// break --> continue로 변경
					// continue : 특정 값을 만나면 건너뛰기만 함
					continue bk;
					// 즉 3의 배수를 만나면 건너뛰기 한다는 것
				}
				System.out.printf("%-2d" , j + 1);
			}
			
			System.out.println();
		}// end of for loop(1)
	}
}
