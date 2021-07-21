package personal_study;

public class Ex7_Array {

	public static void main(String[] args) {
		
		 // 도전문제 ( 재 도전 )
		
		// 정수 3개를 저장할 수 있는 배열을 만든다
		// 1 ~ 9 까지의 값들 중 난수를 발생한다
	    // 중복을 허용하면 안된다
		
		int [] array = new int [3];
		boolean flag = true;
		
		
		for (int i = 0 ; i < array.length;  ) {
			array[i] = (int)(Math.random()* 10) +1;	
			flag = true;
						   //            j < i 
			               //i = 0 일때 (0 < 0) false
						   //i = 1       0 < 1  true
			               //i = 2       0 < 2  true
			for (int j = 0 ; j < i ; j ++) {
				
				
				System.out.println("i === > " + i + " j ===== > " + j);
				
				System.out.println("res : " + (j < i) );
				if (array[i] == array[j])
					flag = false;
					
					System.out.println("중복값이 존재합니다 " + array[i] + " i 진행 횟수 : " + i);
					break;
			}// end of for loop(2)
			
			if (flag)
				i++;
			
		} // end of for loop(1)
		
		// 출력
		
		for (int i = 0 ; i < array.length; i ++) {
//			System.out.println("array[i] ===== > " + array[i]);
		}
	}
}