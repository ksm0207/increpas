package am;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FromSky extends JFrame implements Runnable{
	
	
	JPanel panel;
	Image image;
	
	int x_location;
	int y_location;
	
	ArrayList<SkyBullet> list;
	
	SkyBullet skys;
	
	
	public FromSky() {
		
		list = new ArrayList<SkyBullet>();
		
		this.add(panel = new JPanel() {
			
			@Override
			public void paint(Graphics g) {
				
				image = createImage(this.getWidth(),this.getHeight());
				
				Graphics graphics = image.getGraphics();
				graphics.fillRect(x_location, y_location, 70, 40);
				
				for (int i=0; i<list.size(); i++) {
					SkyBullet sb = list.get(i);
					graphics.fillOval(sb.x_location ,sb.y_location ,sb.bullet_width, sb.bullet_height);
				}
				
				setTitle(list.size() + "개");
				g.drawImage(image,0,0,this);
				
			}
			
		});
		
		
		this.setBounds(300,280,620,820);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		x_location = this.getWidth() / 2 - 35;
		y_location = this.getHeight() - 80;
		
		this.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					x_location -=3;
					break;
				case KeyEvent.VK_RIGHT:
					x_location +=3;
//					if()
					break;
				case KeyEvent.VK_SPACE:
					SkyBullet sb = new SkyBullet(FromSky.this, x_location +31, y_location);
					// 총알 저장
					list.add(sb);
					// 스레드 가동
					Thread thread = new Thread(sb);
					thread.start();
					break;
				}
				panel.repaint();
			}
		});
		
	}
	
	@Override
	public void run() {
		while(true) {
		
			y_location-=10; 
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			panel.repaint();
			if(y_location < 0) {
				System.out.println(y_location);
				list.remove(this);
				break;
			}
		}
	}	
	
	

	public static void main(String[] args) {
		new FromSky();
	}




	
}
class SkyBullet implements Runnable {
	
	int x_location;
	int y_location;
	int bullet_width = 8;
	int bullet_height = 12;
	
	public FromSky sky;
	
	
	public SkyBullet (FromSky sky , int x_location, int y_location) {
		this.sky = sky;
		this.x_location = x_location;
		this.y_location = y_location;
	}

	@Override
	public void run() {
		while(true) {
		
			y_location-=10; 
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			sky.panel.repaint();
			if(y_location < 0) {
				System.out.println(y_location);
				sky.list.remove(this);
				break;
			}
		}
	}	
	
	
}
