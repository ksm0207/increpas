package Thread;

public class Thread01 {

	int x = 5;
	
	Thread thread ;
	Runnable runna;
	
	public Thread01() {
		
		thread = new Thread() {
			
			@Override
			public void run() {
				try {
					for (int i=0; i<=x; i++) {
						sleep(1000);
						if (x > 0) {
							System.out.println("Thread Test : " + (i));	
							if(i == 5) {
								System.out.println("Exit");
							}
						}
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		
	}
	
	
	public static void main(String[] args) {
		
		Thread01 ex = new Thread01();
		ex.thread.start();
		
	}
}
