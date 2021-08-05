package am;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class Ex3_IconTest extends JFrame{
   
  /*  변수 선언  */	
	JButton btn;
	JLabel label;
	JPanel panel;
	ImageIcon icon1, icon2;
	
	
	public Ex3_IconTest() {
		init();
		view();
	}
	
	public static void main(String[] args) {
		
		new Ex3_IconTest();
	}
	
	public void init() {
		/* 이미지 준비 */
		icon1 = new ImageIcon("src/images/search.png");
		icon2 = new ImageIcon("src/images/dog.png");
		
		/* 버튼에 이미지를 넣고 배경을 바꾼다 */
		btn = new JButton(icon1);
		btn.setBorder(new BevelBorder(BevelBorder.RAISED));

		/* 화면 가운데에 넣기 (객체생성) */
		panel = new JPanel();
		
		/* 패널에 버튼을 추가하기 */
		panel.add(btn);
		
		/* 라벨에 이미지 추가하기 */
		panel.add(label = new JLabel(icon2));
		
		/* 패널을 창의 NORTH 영역에 추가하기 */
		this.add(panel,BorderLayout.NORTH);
	}
	
	public void view() {
		/* 창의 위치와 크기지정 */
		this.setTitle("Test");
		this.setBounds(600,150,400,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
