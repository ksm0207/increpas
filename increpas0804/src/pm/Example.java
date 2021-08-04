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
import javax.swing.JTextField;

public class Example extends JFrame{
	
	JLabel id , pw , img_label;
	JPanel sou_panel ,p1,p2,p3;
	JTextField idText;
	JPasswordField pwField;
	JButton btn;
	ImageIcon img1;
	
	GridLayout grid;
	FlowLayout fLayout;
	

	
	public Example() {
		
		init();

//		Window Screen
		this.setBounds(400, 200, 300, 430);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("KaKao Login");
	}

	public static void main(String[] args) {
		
		new Example();
	}
	
	public void init() {
		
		grid = new GridLayout(4,1);
		sou_panel = new JPanel(grid);
		
		img1 = new ImageIcon("src/images/kakao.png");
		
		img_label = new JLabel(img1);
		this.add(img_label);
		
		fLayout = new FlowLayout(FlowLayout.CENTER);
		p1 = new JPanel(fLayout);
		p2 = new JPanel(fLayout);
		p3 = new JPanel(fLayout);
		
		id = new JLabel("아이디 : ");
		idText = new JTextField(9);
		
		p1.add(id);
		p1.add(idText);
		p1.setBackground(new Color(250,225,0));
		
		pw = new JLabel("비밀번호 : ");
		pwField = new JPasswordField(9);
		p2.add(pw)
		p2.add(pwField);
		
		p2.setBackground(new Color(250,225,0));
		
		btn = new JButton("로그인");
		
		p3.add(btn);
		p3.setBackground(new Color(250,225,0));
		
		sou_panel.add(p1);
		sou_panel.add(p2);
		sou_panel.add(p3);
		
		sou_panel.setBackground(new Color(250,225,0));
		
		
		this.add(sou_panel, BorderLayout.SOUTH);
	}
}

//label2.setHorizontalAlignment(JLabel.CENTER);
