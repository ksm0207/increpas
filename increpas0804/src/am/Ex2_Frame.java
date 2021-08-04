package am;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex2_Frame extends JFrame {
	
	JButton [] btn;
	
	public Ex2_Frame() {
		
	// 생성자 초기화
		btn = new JButton[5];
		for (int i=0; i<btn.length; i++ ) {
			
			btn[i] = new JButton();
			
			switch (i) {
			case 0:
				btn[i] = new JButton("동");
				this.add(btn[i], BorderLayout.EAST);
				break;
			case 1:
				btn[i] = new JButton("서");
				this.add(btn[i], BorderLayout.WEST);
				break;
			case 2:
				btn[i] = new JButton("남");
				this.add(btn[i], BorderLayout.SOUTH);
				break;
			case 3:
				btn[i] = new JButton("북");
				this.add(btn[i], BorderLayout.NORTH);
				break;
			case 4:
				btn[i] = new JButton("센터");
				this.add(btn[i], BorderLayout.CENTER);
				break;
			}
		}
	
	
	this.setSize(700,500);
	this.setLocation(300,200);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	this.setVisible(true);
	this.setTitle("Test");
	
	
}
	public static void main(String[] args) {
		new Ex2_Frame();
	}

}
