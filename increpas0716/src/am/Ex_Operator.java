package am;

public class Ex_Operator {
	public static void main(String[] args) {
		// 1. 대입 연산자
		// 연산자를 중심으로 오른쪽의 값을 왼쪽으로 저장 !
		
		int a = 12;
		int b = 5;
		
		a+=b;
		System.out.println(a);
		System.out.println(b);
		
		a%=b;
		System.out.println(a);
		System.out.println(b);
		
		a*=b;
		System.out.println(a);
		System.out.println(b);
	}
}
