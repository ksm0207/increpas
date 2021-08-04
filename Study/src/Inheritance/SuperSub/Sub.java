package Inheritance.SuperSub;

public class Sub  extends Super{
	
	@Override
	void result() {
		System.out.println("Child @Override");
	}
	
	void result2() {
		System.out.println("Child Method");
	}
}
