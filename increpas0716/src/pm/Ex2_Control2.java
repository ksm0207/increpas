package pm;

public class Ex2_Control2 {
	public static void main(String[] args) {
		
		// 삼항연산자
		
		int a =  (5 < 4) ? (5) : (4);
		System.out.println(a);
		
		int a1 = 12;
		int b1 = 20;
		
		boolean check = (a1 > b1) ? true : false;
		System.out.println(check);
		
		int val1 = 20;
		int val2 = 30;
		
		int test = ((val1 > val2) ? (val1 + val2) : (val1 - val2));
		
		System.out.println(test);
		
	}
}
