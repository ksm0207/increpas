package am;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Paint extends JFrame {

	GetCanvas canvas ;
	
	public Paint() {
		
		this.add(canvas = new GetCanvas());
		this.setBounds(300, 200, 540, 430);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.addKeyListener(new KeyAdap(this));
	
	}
	public static void main(String[] args) {
		new Paint();
	}
}

class GetCanvas extends Canvas {
	
	int cmd ;
	int x =10 , y= 10;
	/* cmd = 1 왼쪽 (49) */
	
	@Override
	public void paint(Graphics g) {
		
		// cmd 라는 변수의 값이 아래 항목을 가르키면
		// KEYEVENT.VK_1 ~ KEYEVENT.VK_5의 값들과 비교하여
		// 원하는 도형을 그려준다.
		switch (cmd) {
		
		case 37:
			g.drawOval(x, y, 100, 100);
			break;
		case 38:
			g.fillOval(x, y, 100, 100);
			break;
		case 39:
			g.drawRect(x, y, 100, 100);
			break;
		case 40:
			g.fillRect(x, y, 100, 100);
			break;
		case KeyEvent.VK_5:
			g.drawString("N",20, 10);
			break;	
		}
		
		
	}
}// end of (Inner)GetCanvas

class KeyAdap extends KeyAdapter {
	
	Paint paint;
	
	public KeyAdap(Paint paint) {
		// 인자로 넘어오는 값들은 현재 영역에 벗어나면 소멸되므로
		// 다른 메소드에서도 값을 전달할 수 있도록 멤버변수에 저장하기.
		this.paint = paint;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 특정 '키'를 누를때 마다 호출하는 곳
		// 할것 : 사용자가 누른 키를 canvas의 cmd에 저장
		
		paint.canvas.cmd = e.getKeyCode();
		paint.canvas.repaint();
		// ↑ repaint() 호출하면 update() --> paint() 순으로 호출
		System.out.println("paint.canvas.cmd : " + paint.canvas.cmd);
		
		// 입력 값 확인
		System.out.println("e.getKeyCode() : "+e.getKeyCode() +" : " +"e.getkeyChar() : "+ e.getKeyChar() +"/");
		System.out.println("KEY EVENT VK 1 = "+KeyEvent.VK_1);
	}
}
