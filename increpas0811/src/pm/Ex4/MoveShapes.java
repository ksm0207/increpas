package pm.Ex4;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class MoveShapes extends JFrame {
	
	int x,y,wh;
	
	Canvas can;
	MouseAdapter mAdapter;
	
	public MoveShapes() {
		
		can = new Canvas (){
			@Override
			public void paint(Graphics g) {
				
				wh = (int)(Math.random()*101)+20;
				
				int rand1 = (int) (Math.random() * 255);
				int rand2 = (int) (Math.random() * 255);
				int rand3 = (int) (Math.random() * 255);
				
				
				Color randomColor = new Color(rand1, rand2, rand3);
				g.setColor(randomColor);
				
				if (x > 0 && y > 0) {
					g.fillOval(x, y, wh, wh);				
					x -= wh/2;
					y -= wh/2;
				}
			}
			
			@Override
			public void update(Graphics g) {
				paint(g);
			}
		};
		
		mAdapter = new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				can.repaint();
			}
		};
		
		this.add(can);
		this.setBounds(300,250,450,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
		
		can.addMouseListener(mAdapter);
	}

	
	public static void main(String[] args) {
		new MoveShapes();
	}

}
