package pm;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ex2_Frame extends JFrame{
	
	JTextField tf1;
	JLabel label;
	FlowLayout f1;
	
	public Ex2_Frame() {

//		Layout
		f1 = new FlowLayout(); // Default : Center
		this.setLayout(f1);	   // 현재 창의 레이아웃 변경
		
//		Label
		label = new JLabel("이름 :");
		
//		TexField
		tf1 = new JTextField(15);
		
		this.add(label);
		
		this.add(tf1);
		
//		Window Screen
		this.setSize(700,400);
		this.setLocation(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("Test");
	}

	public static void main(String[] args) {
		
		new Ex2_Frame();
	}
}
