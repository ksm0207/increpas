package pm;

public class ThreadTest {
	
	public void print() {
		System.out.println("Main 실행 ");
	}

	
	public static void main(String[] args) {
		
		ThreadTest main = new ThreadTest();
		StartThered start = new StartThered();
		
		start.start();
		main.print();
		
		
		
	}
}

class StartThered extends Thread{
	
	@Override
	public void run() {
		
		for (int i=0; i<=100; i++) {
			
			try {
				sleep(100);
				System.out.println("Thread : " + (i));
				
			} catch (Exception e) {
				
			}
		}
	
	}
}
