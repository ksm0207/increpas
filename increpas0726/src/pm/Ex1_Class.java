package pm;

public class Ex1_Class {

	// 1. 두 수를 받아서 곱한 값을 반환하는 동작
	public int multipl (int x , int y) {
		
		int value = (x * y);
		
		return value;
	}
	
	public static void main(String[] args) {
		
		Ex1_Class ex1 = new Ex1_Class();
		
		int res = ex1.multipl(50, 5);
		
		System.out.println(res);
	}
}
