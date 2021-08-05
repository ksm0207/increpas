package pm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Example extends JFrame {
	
	JLabel label1,label2,label3,label4,label5;
	JTextField text1 ,text2,text3,text4,text5;
	FlowLayout fLayout;
	GridLayout grid , grid2;
	JPanel sou_panel,sou_btn,panel1,panel2,panel3,panel4,panel5,panel6;
	JButton btn1;
	
	public Example() {
		windowView();
	
	}
	
	
	
	public static void main(String[] args) {
		new Example();
	}
	public void windowView() {
		/* 창의 위치와 크기지정 */
		this.setTitle("Test");
		this.setBounds(600,150,400,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


