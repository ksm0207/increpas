package am;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex3_Test extends JFrame{
	JPanel center_p;
	
	
	public Ex3_Test() {
		
		// 현재 창 가운데에 center_p를 생성 후 추가
		center_p = new JPanel();
		this.add(center_p);
		
//		this.setLayout(new FlowLayout());
		
		// 창의 위치와 크기 설정
		this.setBounds(300,300,400,300);
		this.setVisible(true);
		
		this.addWindowListener(new MyWinAdap());
//		center_p.addMouseListener(new MyMouseAdap(this)); 
		
	}
	
	public static void main(String[] args) {
		new Ex3_Test();
	}

}

//class MyMouseAdap extends MouseAdapter{
//
//	Ex3_Test ex3;
//	
//	public MyMouseAdap(Ex3_Test ex3) {
//		this.ex3 = ex3;
//	}
//	
//	@Override
//	public void mouseEntered(MouseEvent e) {
//		
//		ex3.center_p.setBackground(Color.RED);
//	}
//	@Override
//	public void mouseExited(MouseEvent e) {
//		ex3.center_p.setBackground(Color.GRAY);
//	}
//	
//}
