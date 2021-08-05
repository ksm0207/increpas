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
	JPanel sou_panel ,panel1,panel2,panel3,panel4,panel5,panel6;
	JTextField text1,text2,text3,text4,text5;
	JButton btn1,btn2,btn3,btn4,btn5;
	JTextArea area;
	JButton btn;
	ImageIcon img1;
	
	GridLayout grid , grid2;
	FlowLayout fLayout, fLayout2;
	

	
	public Example() {
		
		init();

//		Window Screen
		this.setBounds(400, 200, 800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("KaKao Login");
		
	}

	public static void main(String[] args) {
		
		new Example();
	}
	
	public void init() {
		grid = new GridLayout(11,2);
		sou_panel = new JPanel(grid);
		area = new JTextArea();
		

		btn1 = new JButton();
		btn2 = new JButton();
		btn3 = new JButton();
		btn4 = new JButton();
		btn5 = new JButton();
		
		fLayout = new FlowLayout(FlowLayout.LEFT);
		panel1 = new JPanel(fLayout);
		panel2 = new JPanel(fLayout);
		panel3 = new JPanel(fLayout);
		panel4 = new JPanel(fLayout);
		panel5 = new JPanel(fLayout);
		panel6 = new JPanel(fLayout);
		
		
//		fLayout2 = new FlowLayout(FlowLayout.RIGHT);
//		right_panel = new JPanel(fLayout2);
		
		
		
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
		
		area = new JTextArea("Hello",2, 25);
		panel6.add(btn1);
		
		
		
	
		
//		btn = new JButton("로그인");
//		btn.setBackground(new Color(82,56,55));
//		
//		
//		panel3.add(btn);
//		panel3.setBackground(new Color(250,225,0));
		
		sou_panel.add(panel1);
		sou_panel.add(panel2);
		sou_panel.add(panel3);
		sou_panel.add(panel4);
		sou_panel.add(panel5);
		sou_panel.add(btn1);
		sou_panel.add(btn2);
		sou_panel.add(btn3);
		sou_panel.add(btn4);
		sou_panel.add(btn5);
		
		sou_panel.add(panel6);
//		area_panel.add(area);
		
//		sou_panel.setBackground(new Color(250,225,0));
		
		
		this.add(sou_panel, BorderLayout.SOUTH);
//		this.add(right_panel,BorderLayout.WEST);
	}
}

//label2.setHorizontalAlignment(JLabel.CENTER);
