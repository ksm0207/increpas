package am;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex3_Frame extends JFrame{
	
	JButton btn1,btn2,btn3;
	JPanel p1;
	
	public Ex3_Frame(String title) {
		this.setTitle(title);
		
		btn1 = new JButton("버튼1");
		btn2 = new JButton("버튼2");
		btn3 = new JButton("버튼3");
		
		// 생성된 버튼들을 Jpanel에 추가해야 하므로 객체를 생성한다
		p1 = new JPanel();
		
		// 생성된 Jpanel에 버튼 추가
		p1.add(btn1);
		p1.add(btn2);
		p1.add(btn3);
		
		// 버튼 3개를 가지고 있는 Jpanel을 현재 창의 North 영역에추가
		this.add(p1, BorderLayout.NORTH);
		
		// 현재 창 크기 지정
		this.setSize(700,500);
		
		// 현재 창 위치 지정
		this.setLocation(600,200);
		
		// 현재 창 보여주기
		this.setVisible(true);

		// X버튼 클릭시 종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Ex3_Frame("Hello");
	}
}
