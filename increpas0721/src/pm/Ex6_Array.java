package pm;

public class Ex6_Array {
	
	public static void main(String[] args) {
		
		int [] ar = new int [4];
		
		// 1 ~ 100 까지의 값들 중 하나를 배열에 하나씩 저장하는
		// 반복문을 만들어보자
		
		// 초기화 반복문
		for (int i = 0 ; i < ar.length ; i++) {
			ar[i] = (int)(Math.random()*100)+1;
			
		}
		
		// 출력 반복문
		for (int i = 0 ; i < ar.length; i ++) {
			System.out.println(ar[i]);
		}
	}
}
