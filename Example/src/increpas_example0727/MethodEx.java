package increpas_example0727;

public class MethodEx {

	public int sum(int a , int b) {
		
		return a + b;
	}	
	
	public static void main(String[] args) {
		
		MethodEx ex = new MethodEx();
		
		int res = ex.sum(1000, -10);
		System.out.println("res ===> "+res);
		
		
		
	}
}
