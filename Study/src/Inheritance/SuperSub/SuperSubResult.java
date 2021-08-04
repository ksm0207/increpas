package Inheritance.SuperSub;

public class SuperSubResult {
	
	public static void main(String[] args) {
		
		Super sr = new Sub();
		sr.result();
		
//		sr.result2(); 접근불가
		
//		위 처럼 부모 레퍼런스를 참조하여 자식 클래스의
//      result2() 메소드는 참조 할 수 없다
//      sr 의 참조범위는 상속한 멤버 와 오버라이드된 범위까지이다
	}
}
