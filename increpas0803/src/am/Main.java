package am;

public class Main {
	
	public static void main(String[] args) {
		
		Child child = new Child();
		child.childPrint();
		System.out.println("============");
		// 자식클래스 생성
		
		Parent p1 = new Child();
		p1.childPrint(); // 메소드 재정의
		System.out.println("============");
		// 자식클래스 생성
		
		Parent p2 = new Parent();
		p2.childPrint();
		System.out.println("============");
	
	}
}
