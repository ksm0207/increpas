package am;

public class Ex_Decrease {
	public static void main(String[] args) {
		int b = 5;
		
		int a = 12;
		System.out.println(++a); // 13
		System.out.println(a++); // 13(14)
		System.out.println(++a); // 15
		
		int N = 1;
		
		System.out.println(++N); //  2
		
		System.out.println(N ++); //  2 출력 , Stack = 3)
		
		System.out.println(N ++); //  3 출력 , Stack = 4  
		
		System.out.println(++ N); //  5
		
	}
}
