package pm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Example extends JFrame{
	
	int x;
	Image image; // 이미지는 가운데 위치에 있는 Jpanel의 크기와 같은 이미지
	JPanel p;
	Thread thread;
	int status = 0;
	
	public Example() {
		
		p = new JPanel() {
		
		@Override
		public void paint(Graphics g) {
			g.drawImage(image, 0, 0, this);
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
					
					x +=5;
					if(x >= p.getWidth() - 100) {
						break;
					}
					
					repaint();
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
	p.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			
			boolean flag;
			
			System.out.println("마우스 클릭 감지 !");
			System.out.println(status);
			
			switch (status) {
			case 0:
				thread.suspend();
				status=1;
				break;
			case 1:
				thread.resume();
				break;
			}
		}
		@Override
		public void mouseExited(MouseEvent e) {
		
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
		
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
	
		}
	});
	thread.start();
}
	public static void main(String[] args) {
		new Example();
	}
}
