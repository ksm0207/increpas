package pm;

import java.awt.Color;

public class Ex1_Ball extends Thread {

	int x, y, wh, speed;
	Color color;
	
	Ex1_Frame f;

	public Ex1_Ball(int x, int y, int wh, int speed,
			Color color, Ex1_Frame f) {
		this.x = x;
		this.y = y;
		this.wh = wh;
		this.speed = speed;
		this.color = color;
		this.f = f;
	}

	@Override
	public void run() {
		// 현재 스레드가 해야할 일
		while(true) {
			y += 3;
			f.p.repaint();
			try {
				Thread.sleep(speed);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(y > f.p.getHeight()-wh)
				break;
		}//무한반복의 끝
		
		//f에 있는 ArrayList에서 현재 객체를 삭제한다.
		f.list.remove(this);
	}
	
	
}





