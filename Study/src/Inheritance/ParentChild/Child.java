package Inheritance.ParentChild;

public class Child extends Parent{
	
	public String color = "황갈색";
	public String food = "소고기";
	
	// 부모메소드 재정의
	
	@Override
	public void getRunning() {
		scream = "어흥";
		running = "빠르게 달린다";
		System.out.println(color + " 사자는 " + scream + " 소리를  내며 " + running);
		System.out.println("좋아하는 먹이는 " + food + " 이다 ");
	}
}
