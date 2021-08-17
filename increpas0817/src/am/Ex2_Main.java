package am;

public class Ex2_Main {

	public static void main(String[] args) {

		Ex2_Run run = new Ex2_Run();
		
		Thread t1 = new Thread(run,"T1");		
		Thread t2 = new Thread(run,"T2");
		
		t1.start();
		t2.start();

	}
}
