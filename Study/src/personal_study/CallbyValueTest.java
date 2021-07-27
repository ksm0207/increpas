package personal_study;

public class CallbyValueTest {
	
	public void swap(int x, int y){
		int temp ; // 임시변수
		temp = x;
		x = y;
		y = temp;
	}
	
	public static void main(String[] args) {
		CallbyValueTest cbv = new CallbyValueTest();
		
		int first = 10;
		int last = 20;
		
		System.out.println("Swap 전");
		System.out.println("first => " + first);
		System.out.println("last  => " + last);
		
		cbv.swap(first, last);
		
		System.out.println("Swap  후");
		System.out.println("first => " + first);
		System.out.println("last  => " + last);
		
	}

}
