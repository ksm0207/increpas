package pm.Runable;

import java.awt.Color;

public class SingleRun2 implements Runnable {

	ThreadSync sync;
	
	public SingleRun2(ThreadSync threadSync) {
		this.sync = threadSync;
	}

	@Override
	 
	public void run() {
		
		String name = Thread.currentThread().getName();
		System.out.println(name);
		
		while(true) {
			
			switch (name) {
			case "R":
				redOn();
				break;
			case "G":
				greenOn();
				break;
			case "Y":
				yellowOn();
				break;
			}
			
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	private synchronized void redOn() {
		
		sync.btn[0].setBackground(Color.RED);
		sync.btn[1].setBackground(Color.GRAY);
		sync.btn[2].setBackground(Color.GRAY);	
		
		System.out.println("Red ");
		
	}
	
	private synchronized void greenOn() {
		sync.btn[0].setBackground(Color.GRAY);
		sync.btn[1].setBackground(Color.GREEN);
		sync.btn[2].setBackground(Color.GRAY);
		
		System.out.println("Green ");
		
	}
	
	private synchronized void yellowOn() {	 
		sync.btn[0].setBackground(Color.GRAY);	
		sync.btn[1].setBackground(Color.GRAY);
		sync.btn[2].setBackground(Color.YELLOW); 
		
		System.out.println("Yellow ");
		 
	}
}
