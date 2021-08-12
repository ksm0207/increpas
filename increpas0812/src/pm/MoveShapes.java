package pm;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class MoveShapes extends JFrame {

	int x;
	Canvas canvas;
	Thread thread;
	
	
	public MoveShapes() {
		canvas = new Canvas() {
			
			@Override
			public void paint(Graphics g) {
				g.setColor(Color.BLUE);
				g.fillOval(x, 250, 100, 100);
			}
		};
		
		thread = new Thread() {
			
			@Override
			public void run() {
				System.out.println("스레드 감지");
				while(true) {
					canvas.repaint();
					try {
						x += 50;
						if(x >= canvas.getWidth() - 100) {
							System.out.println("스레드 종료");
							break;
						}
						sleep(500);
					} catch (Exception e) {
						
					}
				}
			}
		
		};
	
		this.add(canvas);
		this.setBounds(350,300,400,550);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		thread.start();
	}
	
	public static void main(String[] args) {
		new MoveShapes();
		
	}
}
