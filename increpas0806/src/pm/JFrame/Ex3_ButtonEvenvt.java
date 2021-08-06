package pm.JFrame;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex3_ButtonEvenvt extends JFrame {

	JButton btn1;
	Ex3_Window windowEvent;
	JLabel label;
	int i = 0;
	
	public Ex3_ButtonEvenvt() {
		
		// 현재 창의 레이아웃을 FlowLayout 으로 변경
		this.setLayout(new FlowLayout());
		
		// 현재 창의 버튼 추가
		this.add(btn1 = new JButton("버튼1"));
		
		// 창의 위치와 크기 설정
		this.setBounds(300,300,400,300);
		this.setVisible(true);
		
		// 현재 창에 WindowEventListener 등록
		// 창을 닫을때 프로그램이 종료
		windowEvent = new Ex3_Window();
		
		
		this.addWindowListener(this.windowEvent); // 현 객체의 주소값 넣기
		
		label = new JLabel("0");
		this.add(label);
		
		btn1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				label.setText(Integer.toString((i+=1)));
			}
		});
	}
	
	
	public static void main(String[] args) {
		new Ex3_ButtonEvenvt();
	}


}
