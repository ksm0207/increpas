package pm.JFrame;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class Ex2_WindowEvent extends JFrame implements WindowListener {
	
	public Ex2_WindowEvent() {
		
		// 창의 위치와 크기 설정
		this.setBounds(300,300,400,300);
		this.setVisible(true);
		
		// 창의 대한 이벤트 감지자 선언
		this.addWindowListener(this);
	}


	public static void main(String[] args) {
		new Ex2_WindowEvent();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("프로그램 종료");
		System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
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

}
