package pm.Runable;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ThreadSync extends JFrame {
	
	JButton [] btn = new JButton[3];
	
	public ThreadSync () {
		
		for(int i=0; i<btn.length; i++) {
			btn[i] = new JButton();
			
			switch (i) {
			case 0:
				
				btn[i].setBackground(Color.RED);
				break;
			case 1:
				
				btn[i].setBackground(Color.GREEN);
				break;
			case 2:
				
				btn[i].setBackground(Color.YELLOW);
				break;	
			}
			this.add(btn[i]);
		}
		
		/* 색상 스레드들이 수행할 일들을 가지고 있는 객체 생성 */
		SingleRun2 sr = new SingleRun2(this);
		
		Thread t1 = new Thread(sr,"R");
		t1.start();
		
		Thread t2 = new Thread(sr,"G");
		t2.start();
		
		Thread t3 = new Thread(sr,"Y");
		t3.start();
		
		
		this.setLayout(new GridLayout(1,3));
		this.setBounds(300,200,350,150);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ThreadSync();
	}

}
