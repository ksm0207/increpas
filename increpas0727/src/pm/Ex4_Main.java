package pm;

public class Ex4_Main {

	public static void main(String[] args) {
		
		Ex4_Ref ex4 = new Ex4_Ref();
		
		// char 배열 선언 생성 초기화
		char [] ar = {'A','J','K'};
		
		for (int i=0; i<ar.length; i++){
			System.out.printf("%2c", ar[i]);
		}
		System.out.println();
		
		ex4.test(ar);
		
		for (int i=0; i<ar.length; i++) {
			System.out.printf("%2c", ar[i]);
		}
	}
}
