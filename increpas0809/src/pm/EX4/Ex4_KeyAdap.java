package pm.EX4;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ex4_KeyAdap extends KeyAdapter {

	Ex4_Frame frame;
	
	public Ex4_KeyAdap(Ex4_Frame frame) {
		this.frame = frame;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 키를 누를 때마다 호출 되는 곳!!
	
		
		// 사용자가 방향키를 눌렀을 때만 수행한다.
		switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT :
				frame.can.x -= 3;
				if(frame.can.x < 0)
					frame.can.x = 0;
				break;
			case KeyEvent.VK_RIGHT :
				frame.can.x += 3;
				if(frame.can.x > 
					frame.can.getWidth()-frame.can.dog.getWidth(frame))
					frame.can.x = frame.can.getWidth()-frame.can.dog.getWidth(frame);
				break;
		}
		frame.can.repaint();
		System.out.println(e.getKeyChar()+":"+e.getKeyCode());
	}

	
}
