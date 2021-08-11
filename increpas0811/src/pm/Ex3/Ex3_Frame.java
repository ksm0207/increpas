package pm.Ex3;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Ex3_Frame extends JFrame{
	
	Canvas can;
	KeyAdapter k_adapter;
	MouseListener mouse;
	
	int x = 10 , y = 10;
	
	public Ex3_Frame() {
		can = new Canvas() {
			
			@Override
			public void paint(Graphics g) {
				
				int rand1 = (int) (Math.random() * 255);
				int rand2 = (int) (Math.random() * 255);
				int rand3 = (int) (Math.random() * 255);

				Color randomColor = new Color(rand1, rand2, rand3);
				g.setColor(randomColor);
				
				g.fillOval(70, 70, 100, 100);
				g.fillRect(70, 70, 100, 100);
				
			}
		};
		
		k_adapter = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int cmd = e.getKeyCode();
				
				System.out.println("cmd KeyCode : "+cmd);
				System.out.println("Key Pressed 호출");
				
				switch (cmd) {
				case KeyEvent.VK_LEFT:
					x -= 3;
					break;
				case KeyEvent.VK_RIGHT:
					x += 3;
					break;
				}
				
			}
		};
		mouse = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				int x_val = e.getX();
				int y_val = e.getY();
				
				x = x_val;
				y = y_val;
				
				can.repaint();
				System.out.println("MousePressed 호출 ");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
	
		
		this.add(can);
		this.setBounds(300,250,450,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
		this.addKeyListener(k_adapter);
		can.addMouseListener(mouse);
		
	}
	
	public static void main(String[] args) {
		new Ex3_Frame();
	}

}
