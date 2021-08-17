package am;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex1_Frame extends JFrame {
	
	JPanel center_panel;
	
	ArrayList<Shape> shape_list = new ArrayList<Shape>();
	
	public Ex1_Frame() {
		this.add(center_panel = new JPanel() {
			
			@Override
			protected void paintComponent(Graphics g) {
			
				/* ▼ center_panel 의 크기와 같은 크기의 이미지 객체를 그린다.*/
				
				Image buf = createImage(this.getWidth(), this.getHeight());
				
				/* 준비된 임시 이미지 객체에만 그림을 그릴 수 있는 붓 객체*/
				Graphics buf_g = buf.getGraphics();
				
				
				for(int i=0; i<shape_list.size(); i++) {
					Shape shape = shape_list.get(i);
					buf_g.fillOval(shape.x, shape.y, 100, 100);
				}
				g.drawImage(buf,0,0,this);
				
			}
		});
		
		this.setBounds(300,250,500,550);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		center_panel.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mousePressed(MouseEvent e) {
				
				int getX, getY;
				
				getX = e.getX() - 50;
				getY = e.getY() - 50;
				
				System.out.println(getX);
				System.out.println(getY);
				
				Shape shape = new Shape(Ex1_Frame.this, getX, getY);
				
				shape_list.add(shape);
				shape.start();
				
			}
		
		});
	}
	
	public static void main(String[] args) {
		
		// 1. 마우스를 클릭하면 도형이 생기고 아래로 떨어뜨리기.
		new Ex1_Frame();
		
	}

}
