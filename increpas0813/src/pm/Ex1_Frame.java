package pm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex1_Frame extends JFrame {

	ArrayList<Ex1_Ball> list;
	
	JPanel p = new JPanel() {

		@Override
		public void paint(Graphics g) {
			// 현재 p와 같은 크기의 이미지 객체 생성
			Image buf = createImage(this.getWidth(), this.getHeight());
			
			// buf에만 그릴 수 있는 붓과 같은 객체를 준비한다.
			Graphics buf_g = buf.getGraphics();
			
			// ArrayList에 있는 Ex1_Ball을 모두 그린다.
			for(int i=0; i<list.size(); i++) {
				Ex1_Ball ball = list.get(i);
				
				buf_g.setColor(ball.color);
				buf_g.fillOval(ball.x, ball.y, ball.wh, ball.wh);
			}
			
			g.drawImage(buf, 0, 0, this);
			
		}
		
	};
	
	public Ex1_Frame() {
		list = new ArrayList<Ex1_Ball>();
		this.add(p);
		
		this.setBounds(300, 200, 500, 550);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);//프로그램 종료
			}
		});
		
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					int wh = (int)(Math.random()*101+20);
					int x = (int)(Math.random()*(p.getWidth()-wh));
					int y = -wh;
					int r = (int)(Math.random()*256);
					int g = (int)(Math.random()*256);
					int b = (int)(Math.random()*256);
					Color c = new Color(r, g, b);
					int speed = (int)(Math.random()*470+30);
					
					Ex1_Ball ball = new Ex1_Ball(
						x, y, wh, speed, c, Ex1_Frame.this);
					
					list.add(ball);
					ball.start();//스레드 구동
				}
			}
		});
	}
	
	public static void main(String[] args) {
		new Ex1_Frame();

	}

}
