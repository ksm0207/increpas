package am;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex1_Frame extends JFrame{
	
	// 현재 창에서 필요로 하는 객체들을 선언
	JButton btn1 , btn2 , btn3;
	
	public Ex1_Frame() {
		// 생성자 초기화
		
		btn1 = new JButton("버튼1");
		btn2 = new JButton("버튼2");
		btn3 = new JButton("버튼3");
		
		// 생성된 버튼객체들을 현재 객체에 추가한다
		this.add(btn1, BorderLayout.NORTH);
		this.add(btn2, BorderLayout.CENTER); // 상위클래스 Component 으로 부터 상속
		this.add(btn3, BorderLayout.SOUTH);
		
		this.setSize(500,400);
		this.setLocation(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
		this.setTitle("Hello");
		
	}
	
	public static void main(String[] args) {
		Ex1_Frame frame = new Ex1_Frame();
		
		
		
		
		
	}
}
