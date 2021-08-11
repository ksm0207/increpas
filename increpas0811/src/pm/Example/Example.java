package pm.Example;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class Example extends JFrame {
	
	int x;
	int y;
	
	Canvas can;
	MouseAdapter mAdapter;
	
	public Example() {
		
		can = new Canvas (){
			@Override
			public void paint(Graphics g) {
			
				StringBuilder sb = new StringBuilder();
				String windowX = Integer.toString(x);
				String windowY = Integer.toString(y);
				
				sb.append("X 좌표 : ");
				sb.append(windowX);
				sb.append("  ,  ");
				sb.append("Y 좌표 : ");
				sb.append(windowY);
				sb.toString();
	
				g.drawString(sb +"" , x , y);					
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
				
				System.out.println("X 좌표 : " + x);
				System.out.println("Y 좌표 : " + y);
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
		new Example();
	}

}
