package pm;

public class Ex4_Array {
	
	public static void main(String[] args) {
		
		// 배열선언
		int [] ar ;
		
		// 배열생성
		ar = new int [3];
		
		// 배열 초기화
		
		ar[1] = 200;
		ar[0] = 100;
		ar[2] = 200;
		
		for (int i = 0 ; i < 3 ; i ++) {
			System.out.println(ar[i]);
		}
		
		
		
		for (int i = 0 ; i < ar.length ; i ++) {
//			System.out.println(ar[i]);
			ar[i] = (i+1) * 1000;
			System.out.println(ar[i]);
		}
		
	}
}
