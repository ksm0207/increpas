package pm;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex3_Frame extends JFrame {
	
//	JButton btn1,btn2,btn3,btn4,btn5;
	JButton [] btn;
	
	public Ex3_Frame() {
		
		btn = new JButton [5];
	
		for (int i=0; i<btn.length; i++) {
			btn[i] = new JButton();
			
			switch (i) {
			case 0:
				btn[i] = new JButton("버튼1");
				this.add(btn[i]);
				break;
			case 1:
				btn[i] = new JButton("버튼2");
				this.add(btn[i]);
				break;
			case 2:
				btn[i] = new JButton("버튼3");
				this.add(btn[i]);
				break;
			case 3:
				btn[i] = new JButton("버튼4");
				this.add(btn[i]);
				break;
			case 4:
				btn[i] = new JButton("버튼5");
				this.add(btn[i]);
				break;
			}
		}// end of for (1)
		
		this.setLayout(new FlowLayout());
		
//		Window Screen
		this.setBounds(650, 400, 500, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("Test");
	}
	
	public static void main(String[] args) {
		
		new Ex3_Frame();
	}

}
