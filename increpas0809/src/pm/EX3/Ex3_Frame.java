package pm.EX3;

import javax.swing.JFrame;

import am.MyWinAdap;

public class Ex3_Frame extends JFrame {

	Ex3_Canvas can;
	
	public Ex3_Frame() {
		//현재 창 가운데에 캔버스 객체 생성하여 추가하기
		this.add(can = new Ex3_Canvas());
		
		this.setBounds(400, 250, 500, 450);
		this.setVisible(true);
		
		this.addWindowListener(new MyWinAdap());//종료
		can.addMouseListener(new Ex3_MyMouseAdap(this));
	}
	
	public static void main(String[] args) {
		new Ex3_Frame();

	}

}
