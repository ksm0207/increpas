package Inheritance;

public class Parent {
	
	public String scream = "킁킁";
	public String running = "걷는다";
	
	public void getRunning() {
		System.out.println("부모님의 동물은 " + 
	            scream + " "
				+ " 소리를 내고 "
				+ " 앞으로" + running);
	}
}
