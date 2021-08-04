package Inheritance.example;


class A{
	
	String classA = "클래스 A";
	
	public void aSay() {
		System.out.println("Class A");
		System.out.println("부모클래스 : "+classA + " 호출 ");
	}
}

class B extends A{
	
	String classB = "클래스 B";
	
	public void bSay() {
		System.out.println("Class B");
		System.out.println("부모 클래스 : "+classA + " 호출 ");
		System.out.println("자식 클래스 : "+classB + " 호출 ");
	}
}

class C extends B{
	
	String classC = "클래스 C";
	
	public void cSay() {
		System.out.println("Class C");
		System.out.println("조 부모 클래스 : "+classA + " 호출 ");
		System.out.println("부모 클래스 : "+classB + " 호출 ");
		System.out.println("자기자신 클래스 : "+classC + " 호출 ");
	}
}


public class Main {
	
	public static void main(String[] args) {
		
		A a = new A();

//		A 클래스 자신의 메소드 사용
//		a.객체로 b.객체(자식) 접근 불가		
		a.aSay(); 
		System.out.println("====================");
		B b = new B();
	
//		B 클래스 부모 메소드 호출		
		b.aSay();
//		B 클래스 자신의 메소드	
		b.bSay();
		System.out.println("====================");
		
		C c = new C();
		
		c.aSay();
		c.bSay();
		c.cSay();
		
		System.out.println("====================");
	}
}
