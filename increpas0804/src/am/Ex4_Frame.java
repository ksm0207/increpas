package am;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex4_Frame extends JFrame {
	
	JPanel p1 [];
	JCheckBox jBox1 , jBox2 , jBox3;
	
	
	public Ex4_Frame() {
		this.setTitle("Hello World");
		
		p1 = new JPanel[3];

		for (int i=0; i < p1.length; i++) {
			
			p1[i] = new JPanel();
			switch (i) {
			case 0:
				jBox1 = new JCheckBox("자바");
				p1[i].add(jBox1);
				this.add(p1[i], BorderLayout.EAST);
				break;
			case 1:
				jBox2 = new JCheckBox("파이썬");
				p1[i].add(jBox2);
				this.add(p1[i], BorderLayout.WEST);
				break;
			case 2:
				jBox3 = new JCheckBox("C");
				p1[i].add(jBox3);
				this.add(p1[i], BorderLayout.NORTH);
				break;
			}
			
		}
	
		this.setSize(700,500);
		this.setLocation(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new Ex4_Frame();
	}

}
