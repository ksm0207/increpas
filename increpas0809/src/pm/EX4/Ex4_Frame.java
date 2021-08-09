package pm.EX4;

import javax.swing.JFrame;

import am.MyWinAdap;

public class Ex4_Frame extends JFrame {

	Ex4_Canvas can;
	
	public Ex4_Frame() {
		this.add(can = new Ex4_Canvas());
		
		this.setBounds(300, 250, 600, 550);
		this.setVisible(true);
		
		this.addWindowListener(new MyWinAdap());
		this.addKeyListener(new Ex4_KeyAdap(this));
	}
	
	public static void main(String[] args) {
		new Ex4_Frame();

	}

}
