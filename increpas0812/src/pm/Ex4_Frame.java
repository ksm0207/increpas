package pm;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex4_Frame extends JFrame{

	int x;
	JPanel p;
	Thread thread;
	
	public Ex4_Frame() {
		
	
		p = new JPanel() {
		
		@Override
		public void paint(Graphics g) {
			g.setColor(Color.BLUE);
			g.fillOval(x, 150, 100, 100);
		}
	};
		thread = new Thread() {
			
			@Override
			public void run() {
				
				while(true) {
					
					x +=5;
					if(x >= p.getWidth() - 100) {
						break;
					}
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
	this.setBounds(300,250,600,320);
	this.setVisible(true);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	thread.start();	
}

	public static void main(String[] args) {
		new Ex4_Frame();
	}
	
}
