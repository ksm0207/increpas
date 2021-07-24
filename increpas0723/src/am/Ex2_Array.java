package am;

public class Ex2_Array {
	
	public static void main(String[] args) {
		
		// 정수형 2차원 배열 생성
		// 2차원 배열 : 1차원 배열을 여러개 모아둔 것 이다.
//		int [][] ar = new int [저장할 1차원 배열의 수]
//				              [각 1차원 배열의 길이];
		
		                  // 길이가 4개짜리인 1차원 배열 2개를 저장하는
		                  // 2차원 배열을 생성했다.
		int [][] ar = new int [2][4]; 
		
		
		int count = 1;
		// 배열의 값을 저장 후 안쪽 for문 연산 후 출력
		for (int i = 0 ; i < 2 ; i ++) {	
			
			for (int j = 0 ; j < 4 ; j ++) {
				ar[i][j] = count;
				count ++;
				System.out.printf("%-2d",ar[i][j]);
			}// end of for loop(2)
			System.out.println();
		}// end of for loop(1)
		
		
	}
}
