package Thread.example1;

public class Thread02 {
	
	public static void main(String[] args) {
		
		RunThreadTest run = new RunThreadTest();
		run.start();
		
		RunThreadTest run2 = new RunThreadTest();
		run2.start();
	
	}
}

class RunThreadTest extends Thread{
	
	int x = 1;
	
	@Override
	public void run() {
		for (int i=0; i<=x; i++) {
			try {
				sleep(500);
				System.out.println("Thread Test : " + i);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
}
