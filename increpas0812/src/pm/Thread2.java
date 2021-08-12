package pm;

public class Thread2 {
	
	public void print() {
		System.out.println("Main ()");
	};
	
	public static void main(String[] args) {
		
		FirstThread first = new FirstThread();
		LastThread  last = new LastThread();
		
		
		
		first.start();
		last.start();
		
		Thread2 main = new Thread2();
		main.print();
	}
}

class FirstThread extends Thread{
	
	@Override
	public void run() {
		
		for(int i=1; i<=20; i++) {
			System.out.println("*");
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class LastThread extends Thread{
	
	@Override
	public void run() {
		
		for(int i=1; i<=10; i++) {
			System.out.println("~@");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
