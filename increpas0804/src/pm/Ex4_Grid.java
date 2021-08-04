package pm;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex4_Grid extends JFrame {
	
//	JButton btn1,btn2,btn3,btn4,btn5;
	JButton [] btn;
	GridLayout grid;
	StringBuffer sb;
	
	public Ex4_Grid() {
		
		btn = new JButton [6];
		for (int i=0; i<btn.length; i++) {
			sb = new StringBuffer();
			sb.append("버튼");
			sb.append((i+1));
			btn[i] = new JButton(sb.toString());
			
			switch (i) {
			case 0:
				this.add(btn[i]);
				break;
			case 1:
				this.add(btn[i]);
				break;
			case 2:
				this.add(btn[i]);
				break;
			case 3:
				this.add(btn[i]);
				break;
			case 4:
				this.add(btn[i]);
				break;
			case 5:
				this.add(btn[i]);
				break;	
			}
		}// end of for (1)
		

		grid = new GridLayout(2,1);
		this.setLayout(grid);
	
		
//		Window Screen
		this.setBounds(650, 400, 500, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("Test");
	}
	
	public static void main(String[] args) {
		
		new Ex4_Grid();
	}

}
