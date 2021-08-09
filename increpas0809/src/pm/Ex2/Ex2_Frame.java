package pm.Ex2;

import javax.swing.JFrame;

import am.MyWinAdap;

public class Ex2_Frame extends JFrame {

	Ex2_Canvas can;
	
	public Ex2_Frame() {
		this.add(can = new Ex2_Canvas());
		
		this.setBounds(300, 100, 500, 450);
		this.setVisible(true);
		
		this.addWindowListener(new MyWinAdap());//종료 이벤트
	}
	
	public static void main(String[] args) {
		new Ex2_Frame();

	}

}
