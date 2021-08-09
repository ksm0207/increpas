package pm.EX3;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Ex3_Canvas extends Canvas {

	Image dog;
	int x,y;
	
	public Ex3_Canvas() {
		// 이미지를 만들기 위해 필요한 객체 생성
		Toolkit tk = Toolkit.getDefaultToolkit();
		dog = tk.getImage("src/images/dog.png");
		//화면에서 처음에 이미지를 나타나지 않도록 하기 위해
		// y의 값을 -120으로 지정하자!
		y = -120;
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawLine(10, y, 290, 10);
		g.setColor(Color.RED);//붓의 색상 변경!
//		g.drawImage(dog, x, y, this);
	}

	
}
