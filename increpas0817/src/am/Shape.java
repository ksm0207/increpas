package am;

import java.awt.Rectangle;

public class Shape extends Thread {
	
	Ex1_Frame frame;
	Rectangle rect = new Rectangle();
	int x;
	int y;
	
	int sp = 3;
	
	public Shape(Ex1_Frame frame,int x, int y) {
		this.frame = frame;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			y += sp;
			
			try {
				
				sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			frame.center_panel.repaint();
			
			if(y > frame.center_panel.getHeight() - 100) {
				break;
				
			}
			
		}
		
		/* 스레드 소멸 */
		frame.shape_list.remove(this);
	}
	
	

}
