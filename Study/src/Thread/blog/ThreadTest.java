package Thread.blog;

public class ThreadTest extends Thread{
	
	@Override
	public void run() {
		// TODO 스레드를 이용하여 처리할 코드를 구현영역.
		try {
			sleep(1000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ThreadTest t = new ThreadTest();
		t.start();
		
	}
	
}
