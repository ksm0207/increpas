package Thread.blog;

public class A extends B implements Runnable{

	@Override
	public void run() {
		for(int i=1; i<=5; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("Runnable Thread :" + i);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		A a = new A();
		
		Thread thread = new Thread(a);
		thread.start();
	}

}
