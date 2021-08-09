package am;

import javax.swing.JFrame;

public class Ex2_Test extends JFrame {

	public Ex2_Test() {
		
		this.setBounds(250,200,300,400);
		this.setVisible(true);
		
		// 이벤트 리스너
		
		this.addWindowListener(new MyWinAdap());
	}
	public static void main(String[] args) {
		new Ex2_Test();
	}
}
