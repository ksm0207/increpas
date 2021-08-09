package am;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex1_Test extends JFrame implements ActionListener{
	
	JPanel north_p;
	JButton left_btn , center_btn, right_btn;
	FlowLayout flow = null;
	
	public Ex1_Test() {
		
		north_p = new JPanel();
		
		left_btn = new JButton("Left");
		right_btn = new JButton("Right");
		center_btn = new JButton("Center");
		
		// 생성된 버튼 객체들을 north_p에 추가
		north_p.add(left_btn);
		north_p.add(right_btn);
		north_p.add(center_btn);
		
		// 버튼 3개를 가지는 north_p를 현재 창의 north영역에 뿌리기
		
		this.add(north_p,BorderLayout.NORTH);
		
		/* 화면 설정 */
		this.setBounds(450,200,400,350);
		this.setVisible(true);
		
		/* 이벤트 감지자 등록 */
		this.addWindowListener(new getWindowListener());
		left_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 버튼 객체가 현 위치에 있는 메소드에 도착하면
				// 이벤트 처리를 할 수 있는 메소드
				
				// 하지만 어떤객체가 현 메소드에 오는지는 모르기 때문에
				// ↓ Object 타입으로 객체를 얻어내주고 체크를 해주자.
				
				Object obj = e.getSource();
				
				if (obj == left_btn) {
					
					System.out.println("Cilck");
					flow = new FlowLayout(FlowLayout.LEFT);
				}else if (obj == center_btn) {
					System.out.println("Cilck");
					flow = new FlowLayout(FlowLayout.CENTER);
				}else {
					System.out.println("Cilck");
					flow = new FlowLayout(FlowLayout.RIGHT);
				}
//				this.setLayout(flow);
//				this.validate();
			}
		});
		
		
	}

	public static void main(String[] args) {
	
		new Ex1_Test();	
	}
	
//	1. Window 인터페이스 구현
	class getWindowListener implements WindowListener {
		
		/* ---------------- Window InterFace -----------------*/
		
		@Override
		public void windowOpened(WindowEvent e) {
		
		}

		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("프로그램 종료");
			System.exit(0);
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			System.out.println("프로그램 창 닫기");
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
	} // end of class

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == left_btn) {
			
			System.out.println("Cilck");
			flow = new FlowLayout(FlowLayout.LEFT);
		}else if (obj == center_btn) {
			System.out.println("Cilck");
			flow = new FlowLayout(FlowLayout.CENTER);
		}else {
			System.out.println("Cilck");
			flow = new FlowLayout(FlowLayout.RIGHT);
		}
		this.setLayout(flow);
//		this.validate();
		
	}

}
