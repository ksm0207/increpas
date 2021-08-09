package pm.Ex2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Ex2_Canvas extends Canvas {

	@Override
	public void paint(Graphics g) {
		// 그림을 그리는 동작
		// 인자인 Graphics가 붓과 같은 객체다.
		g.drawLine(10, 10, 290, 10);
		g.setColor(Color.RED);//붓의 색상 변경!
		g.drawRect(10, 20, 100, 100);
		
		g.setColor(Color.ORANGE);
		g.fillRect(120, 20, 100, 100);//채워진 사각형
		
		g.drawOval(10, 130, 100, 100);
		g.setColor(Color.RED);
		g.fillOval(120, 130, 100, 100);//채워진 타원
		
		g.drawString("INCREPAS", 30, 185);
		
		//이미지를 그리기 위해 필요한 객체 Image가 있어야 한다.
		//이전에 Toolkit이 먼저 있어야 한다.
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage("src/images/dog.png");
		
		g.drawImage(img, 10, 240, this);//이미지옵져버는 컴포넌트로부터
								//상속받은 객체들은 모두 가지고 있다.
	
	}

	
}
