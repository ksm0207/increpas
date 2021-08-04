package pm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Ex1_Frame extends JFrame {
	
	
	JList<String> list;
	JPanel p1;
	JButton btn1 , btn2 , btn3;
	JScrollPane scroll;
	Font f1;
	
	public Ex1_Frame () {
		String [] array = new String[30];
		p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		btn1 = new JButton("방 새로만들기");
		btn2 = new JButton("참여하기");
		btn3 = new JButton("나가기");
		
		
		
		for (int i=0; i<array.length; i++) {
			array[i] = "항목" + (i+1);
		}
		
		
		list = new JList<String>(array);
		scroll = new JScrollPane(list);

//      Button
		
		p1.add(btn1);
		p1.setBackground(Color.DARK_GRAY);
		
//      View		
		this.add(scroll);
		this.add(p1,BorderLayout.NORTH);
		
//		Window Screen
		this.setSize(700,400);
		this.setLocation(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("Test");
	}
	
	public static void main(String[] args) {
		
		new Ex1_Frame();
	}

}
