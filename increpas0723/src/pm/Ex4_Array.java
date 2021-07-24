package pm;

public class Ex4_Array {
	public static void main(String[] args) {
		
		// 2차원 배열을 생성해서 아래처럼 초기화 해보기
		//		1 0 0 0 
		//		0 1 0 0 
		//		0 0 1 0 
		//		0 0 0 1 
		
		int [][] array = new int [4][4];
		for (int i = 0 ; i < array.length ; i ++) {
			
			for (int j = 0 ; j < array[i].length ; j ++) {
				
				if (array[i] == array[j]) {
					array[i][j] = 1;
				}
			}
		}
		// 출력
		for (int i = 0 ; i < array.length ; i ++) {
			
			for (int j = 0 ; j < array.length ; j++) {
				System.out.printf("%-2d",array[i][j]);
			}
			System.out.println();
		}

	}
}
