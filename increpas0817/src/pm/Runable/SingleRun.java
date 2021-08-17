package pm.Runable;

import java.awt.Color;

public class SingleRun implements Runnable {

	ThreadSync sync;
	
	public SingleRun(ThreadSync threadSync) {
		this.sync = threadSync;
	}

	@Override
	 
	public void run() {
		
		String name = Thread.currentThread().getName();
		System.out.println(name);
		
		while(true) {
		
			if(name.contains("R")) {
				
				synchronized (sync) {
					
					sync.btn[0].setBackground(Color.RED);
					sync.btn[1].setBackground(Color.GRAY);
					sync.btn[2].setBackground(Color.GRAY);	
					
					System.out.println("빨강 신호등 ");
				}
				
			}else if (name.contains("G")) {
				
				synchronized (sync) {
					
					sync.btn[0].setBackground(Color.GRAY);
					sync.btn[1].setBackground(Color.GREEN);
					sync.btn[2].setBackground(Color.GRAY);
					
					System.out.println("초록 신호등 ");
					
				}
			}else if(name.contains("Y")) {
				
				 synchronized(sync) { 
					 
						sync.btn[0].setBackground(Color.GRAY);	
						sync.btn[1].setBackground(Color.GRAY);
						sync.btn[2].setBackground(Color.YELLOW); 
						
						System.out.println("노랑 신호등 ");
					 }
			 }
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}	
}
