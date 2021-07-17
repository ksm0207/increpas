package increpas_example02;

public class OperTest3 {
	public static void main(String[] args) {
		
		int a,b;
		
		a = b = 10;  // a 0 , b 10 예측 실패
		             // a 10 , b 10 실제 값
		
		boolean c = ++ a > b ++ || a ++ >= ++ b;
		
		System.out.println(a + " " + b);
		
		System.out.println(c);
	}
}
