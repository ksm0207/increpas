package pm.Example;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;


public class ImageMove extends JFrame{
	
	int x = 275;
	int y = 660;
	
	
	Canvas canvas;
	KeyAdapter keyAdap;
	Toolkit tool = Toolkit.getDefaultToolkit();
	Image human_images = tool.getImage("src/images/person.png");
	
	
	public ImageMove() {
		
		canvas = new Canvas() {
			@Override
			public void paint(Graphics g) {
				g.drawImage(human_images,x,y,this);
				
				if (x == 0) {
					g.drawString("Don't Move!", 250, 500);
				}else if (x == canvas.getWidth() - human_images.getWidth(canvas)) {
					g.drawString("Don't Move!", 250, 500);
				}
			}
			
		};
		
		keyAdap = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT :
					x -=3;
					if(x <= 0) {
						x = 0;
					}
					break;
				case KeyEvent.VK_RIGHT:
					x +=3;
					if (x >= ( canvas.getWidth() - human_images.getWidth(canvas))) {
						x = canvas.getWidth() - human_images.getWidth(canvas);
						System.out.println("X 값 : " + x);
						System.out.println("canvas 너비 - 이미지-너비 결과");
						System.out.println((canvas.getWidth()) - (human_images.getWidth(canvas)));
					}
					break;
				}
				canvas.repaint();
			}
		};
		
		this.setBounds(300,250,600,750);
		this.setVisible(true);
		this.setTitle("Get Move!");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.add(canvas);
		this.addKeyListener(keyAdap);
	}
	
	public static void main(String[] args) {
		
		new ImageMove();
	}
}
