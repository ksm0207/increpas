package pm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex5_Frame extends JFrame{
	
	int x;
	Image image; // 이미지는 가운데 위치에 있는 Jpanel의 크기와 같은 이미지
	JPanel p;
	Thread thread;
	
	public Ex5_Frame() {
		
	
		p = new JPanel() {
		
		@Override
		public void paint(Graphics g) {
			g.drawImage(image, x, 100, this);
		}
	};
		thread = new Thread() {
			
			@Override
			public void run() {
				
				while(true) {
					
					x +=5;
					// 패널의 크기와 같은 이미지 객체를 생성하기
					image = createImage(p.getWidth(), p.getHeight());
					
					// image에만 그림을 그릴 수 있는 그래픽스를 얻어내기
					Graphics img_g = image.getGraphics();
					
					img_g.fillOval(x, 100, 100, 100);
					
					p.repaint();
					
					try {
						sleep(50);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		};

	
		
	this.add(p);
	this.setBounds(300,250,600,420);
	this.setVisible(true);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	thread.start();	
}
	public static void main(String[] args) {
		new Ex5_Frame();
	}
}
