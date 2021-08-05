package pm.Ex2;

public class Ex2_Main {

	public static void main(String[] args) {
		
		Ex2_Child child = new Ex2_Child();
		System.out.println("자식클래스1 : "+child.getData());
		
		System.out.println("===================");
		
		Ex2_Child2 child2 = new Ex2_Child2();
		System.out.println("자식클래스2 : "+child2.getData());
		
	}
}
