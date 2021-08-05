package pm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Example extends JFrame{
	
	JLabel employee_id , first_name , phone,job_id,department_name;
	JPanel sou_panel , sou_panel2 ,panel1,panel2,panel3,panel4,panel5,panel6,panel7,
	panel8;
	
	JTextField text1,text2,text3,text4,text5;
	JButton btn1,btn2,btn3,btn4,btn5;
	JTextArea area;
	JButton btn;
	ImageIcon img1;
	
	GridLayout grid , grid2;
	FlowLayout fLayout, fLayout2,fLayout3;
	
	public Example() {
		
		init();

//		Window Screen
		this.setBounds(400, 200, 450, 350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("사원관리");
		
	}

	public static void main(String[] args) {
		
		new Example();
	}
	
	public void init() {
		grid = new GridLayout(6,-1);
		sou_panel = new JPanel(grid);
		
		grid2= new GridLayout(1,10);
		sou_panel2 = new JPanel(grid2);
		
		fLayout = new FlowLayout(FlowLayout.LEFT);
		fLayout2 = new FlowLayout(FlowLayout.CENTER);
		
		panel1 = new JPanel(fLayout);
		panel2 = new JPanel(fLayout);
		panel3 = new JPanel(fLayout);
		panel4 = new JPanel(fLayout);
		panel5 = new JPanel(fLayout);
		panel6 = new JPanel(fLayout);
		panel7 = new JPanel(fLayout2);
		panel8 = new JPanel();
		
		
		employee_id = new JLabel("사번 : ");
		text1 = new JTextField(5);
		panel1.add(employee_id);
		panel1.add(text1);
		
		
		first_name = new JLabel("이름 : ");
		text2 = new JTextField(5);
		panel2.add(first_name);
		panel2.add(text2);
		
		phone = new JLabel("전화 : ");
		text3 = new JTextField(5);
		panel3.add(phone);
		panel3.add(text3);
		
		job_id = new JLabel("직책 : ");
		text4 = new JTextField(5);
		panel4.add(job_id);
		panel4.add(text4);
		
		department_name = new JLabel("부서 : ");
		text5 = new JTextField(5);
		panel5.add(department_name);
		panel5.add(text5);
		
		sou_panel.add(panel1);
		sou_panel.add(panel2);
		sou_panel.add(panel3);
		sou_panel.add(panel4);
		sou_panel.add(panel5);
		sou_panel.add(panel6);

		area = new JTextArea(20, 30);
		panel7.add(area);
		sou_panel2.add(panel7);
		
		btn1 = new JButton("전체");
		btn1.setBackground(Color.DARK_GRAY);
		btn1.setForeground(Color.white);
		
		btn2 = new JButton("추가");
		btn2.setBackground(Color.DARK_GRAY);
		btn2.setForeground(Color.white);
		
		btn3 = new JButton("검색");
		btn3.setBackground(Color.DARK_GRAY);
		btn3.setForeground(Color.white);
		
		btn4 = new JButton("삭제");
		btn4.setBackground(Color.DARK_GRAY);
		btn4.setForeground(Color.white);
		
		btn5 = new JButton("취소");
		btn5.setBackground(Color.DARK_GRAY);
		btn5.setForeground(Color.white);
		
		panel8.add(btn1);
		panel8.add(btn2);
		panel8.add(btn3);
		panel8.add(btn4);
		panel8.add(btn5);
		
		this.add(panel8,BorderLayout.SOUTH);
		this.add(sou_panel, BorderLayout.CENTER);
		this.add(sou_panel2,BorderLayout.EAST);
	}
}
