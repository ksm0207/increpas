package pm.Example;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonCilckGetShapes extends JFrame {
	
	JPanel panel;
	JButton btn1,btn2,btn3;
	Canvas canvas;
	ActionListener action;
	int status = 0;
	
	public ButtonCilckGetShapes() {
		
		action = new  ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btn1) {
					status = 1;
				}else if(e.getSource() == btn2) {
					status = 2;
				}else if (e.getSource() == btn3) {
					status = 3;
				}
				canvas.repaint();
			}
		};
		
		canvas = new Canvas() {
			
			@Override
			public void paint(Graphics g) {
				
				if (status == 1) {
					g.setColor(Color.RED);
					g.drawRect(100, 100, 200, 90);
				}else if (status == 2) {
					g.setColor(Color.GREEN);
					g.drawRect(120, 100, 300, 110);
				}else if (status == 3) {
					g.setColor(Color.BLUE);
					g.drawRect(150, 100, 300, 110);
				}
			}
			@Override
			public void update(Graphics g) {
				paint(g);
			}
			
		};
		
		/* 버튼 만들기 */
		panel = new JPanel();
		panel.add(btn1 = new JButton("Red")); 
		panel.add(btn2 = new JButton("Green")); 
		panel.add(btn3 = new JButton("Blue"));
		this.add(panel,BorderLayout.NORTH);
		
		/* 액션 */
		this.add(canvas);
		this.btn1.addActionListener(action);
		this.btn2.addActionListener(action);
		this.btn3.addActionListener(action);
		
		
		/* 화면 영역 설정 */
		this.setBounds(100,100,550,400);
		this.setVisible(true);
		this.setTitle("0811 숙제 버튼 클릭하고 도형 만들기");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new ButtonCilckGetShapes();
	}

}
