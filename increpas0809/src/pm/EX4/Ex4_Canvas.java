package pm.EX4;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Ex4_Canvas extends Canvas {
	Image dog;
	
	int x, y;
	
	public Ex4_Canvas() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		dog = tk.getImage("src/images/dog.png");
		
		// 현재 창의 너비/2 - 이미지너비/2 x에 저장
		x = 150;
		y = 100;
	}

	@Override
	public void paint(Graphics g) {
	
		g.drawImage(dog, x, y, this);
	}
	
	
}
