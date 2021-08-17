package am;

public class Ex2_Run implements Runnable {

	Object obj = new Object();
	int i=0;
	@Override
	public void run() {
		
		String name = Thread.currentThread().getName();
		
		
		
		synchronized (obj) {
			
			for(int i = 0 ; i<10; i++) {
				System.out.println("스레드 이름 : " + name +  " "+ (i));
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
	}
	

}
