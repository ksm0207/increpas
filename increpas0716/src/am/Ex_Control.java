package am;
public class Ex_Control {
	
	
	
	public static void main(String[] args) {
		
		Ex_Control a1 = new Ex_Control();
		Ex_Control a2 = new Ex_Control();
		
		int a = 12;
		int b = 6;
		
		// 두개의 조건을 부여하여 모두 참이면? = true
		// 변수 c에는 true
		// 예 ) a 와 b가 서로 값이 다르고 a가 더 크다면?
		boolean c = a!=b && a > b;
		System.out.println(c);
		
		c =  !(a!=b && a>b);
		System.out.println("!(a!=b && a>b = "+ c);
		
	
	}
}


