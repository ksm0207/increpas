package am;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex1_Frame extends JFrame{
	
	int score = 0;
	String user_score;
	JPanel back;
	
	Image buf;
	int x , y;
	
	ArrayList<Bullet> b_list;
	
	
	public Ex1_Frame() {
		
		// ArrayList 생성
		b_list = new ArrayList<Bullet>();
		
		
		this.add(back = new JPanel() {
			@Override
			public void paint(Graphics g) {
				
				buf = createImage(this.getWidth(), this.getHeight());
				
//				System.out.println(buf.getWidth(this));
//				System.out.println(buf.getHeight(this));
				
				// buf에 그림을 그릴 수 있는 '전용' 붓
				Graphics buf_g = buf.getGraphics();
				
				
				user_score = Integer.toString(score);
				System.out.println(user_score);
				
				buf_g.drawString("Score : " + user_score, 287, 100);
				
				// back Panel 과 같은 크기의 이미지에 채워진 사각형 생성
				buf_g.fillRect(x, y, 70, 40);
				
				// 총알그리기.
				for(int i=0; i<b_list.size(); i++) {
					// 총알 생성
					Bullet b = b_list.get(i);
					System.out.println("B"+b);
					
					buf_g.fillOval(b.x, b.y, b.w, b.h);
				}
				
				// back Panel 이미지 생성
				g.drawImage(buf, 0, 0, this);
				setTitle(b_list.size() + "개");
			}
		});
		
		
		this.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					x -=3;
					break;
				case KeyEvent.VK_RIGHT:
					x +=3;
//					if()
					break;
				case KeyEvent.VK_SPACE:
					Bullet b = new Bullet(Ex1_Frame.this, x+31, y);
					// 총알 저장
					b_list.add(b);
					// 스레드 가동
					b.start();
					break;
				}
				back.repaint();
			
			}
		});
		this.setBounds(300,280,620,520);
		this.setVisible(true);
		
		// y 값 높이 설정
		y = this.getHeight() - 80;
		
		// x 값 너비 설정
		x = (this.getWidth() / 2) - 35;
		
		this.setTitle("Game");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new Ex1_Frame();
	}
}

class Bullet extends Thread{
	
	// 1. 총알 객체를 만드는 클래스
	// 2. 총알은 ArrayList로 관리한다.
	
	int x;
	int y;
	int w=8;
	int h=12;
	
	public Ex1_Frame frame;
	
	public Bullet(Ex1_Frame frame , int x , int y) {
		
		this.frame = frame;
		this.x=x;
		this.y=y;
	}

	@Override
	public void run() {
		// 일정 시간동안 y좌표를 감소시킨다.
		// 0이 되면 소멸한다.
		while(true) {
			y-=3;
			try {
				sleep(20);
				System.out.println(" Bullet : Thread 구동중");
			} catch (Exception e) {
				e.printStackTrace();
			}
			frame.back.repaint();
			
			if(y < 0) {
				System.out.println(y);
				frame.b_list.remove(this);
				break;
			}
			
		}
		
	}
}
