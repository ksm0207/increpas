package pm;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import am.MyWinAdap;

public class LoginView extends JFrame {
	
	/* Jpanel */
	JPanel card_panel1, card_panel2,p1,p2;
	JPanel first_penal,last_panel;
	/* JButton */
	JButton btn1, btn2;
	/* JLabel */
	JLabel id_label,pw_label,icon_label;
	/* CardLayout */
	CardLayout cl;
	/*TextField */
	JTextField id_text,area_text;
	/* Password Field */
	JPasswordField pw_text;
	/* Area */
	JTextArea area;
	
	/* Area */
	ImageIcon icon;	
	
	public LoginView() {
		cl = new CardLayout();
		this.getContentPane().setLayout(cl);
	
		card_panel1 = new JPanel(new BorderLayout());
		first_penal = new JPanel(new GridLayout(2,1));
		p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		p1.add(new JLabel("ID : "));
		p1.add(id_text = new JTextField(10));
		p1.add(new JLabel("PW : "));
		p1.add(pw_text = new JPasswordField(10));
		p2.add(btn1 = new JButton(" 로그인 "));
		
		first_penal.add(p1);
		first_penal.add(p2);
		
		icon = new ImageIcon("src/images/talk.png");
		card_panel1.add(icon_label = new JLabel(icon));
		card_panel1.add(first_penal, BorderLayout.SOUTH);
		this.getContentPane().add("FirstLoginView",card_panel1);

		/* --------------------------------------------------------- */
	
		card_panel2 = new JPanel(new BorderLayout());
		last_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		last_panel.add(area_text = new JTextField(40));
		last_panel.add(btn2 = new JButton("보내기"));
		card_panel2.add(last_panel, BorderLayout.SOUTH);
		card_panel2.add(new JScrollPane(area = new JTextArea()));
		this.getContentPane().add("LastAreaView",card_panel2);
		
		
		/* 화면 영역 설정 */
		this.setTitle("LoginView");
		this.setBounds(110,50,550,450);
		this.setVisible(true);
		
		/* Window Event */
		this.addWindowListener(new MyWinAdap());
		
		/* Action Event */
		btn1.addActionListener(new LoginCheck(this));
		btn2.addActionListener(new LoginCheck(this));
		area_text.addActionListener(new LoginCheck(this));
		pw_text.addActionListener(new LoginCheck(this));
	
		
	}
	
	public static void main(String[] args) {
		new LoginView();
	}
}

class LoginCheck implements ActionListener{
	
	LoginView login;
	
	public LoginCheck(LoginView login) {
		this.login = login;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		String check_id = login.id_text.getText();
		String check_pw = login.pw_text.getText();
		String ioArea = login.area_text.getText();
		
		
		if (obj == login.btn1) {
			if (check_id.trim().isEmpty() || check_id.contains(" ")) {
				JOptionPane.showMessageDialog(login, "아이디에 공백이 포함되었거나 입력하지 않았습니다.");
				login.id_text.setText("");
				
			}else if (check_pw.trim().isEmpty() || check_pw.contains(" ")) {
				JOptionPane.showMessageDialog(login, "패스워드에 공백이 포함되었거나 입력하지 않았습니다.");
				login.pw_text.setText("");
			}else{
				JOptionPane.showMessageDialog(login, "로그인 성공!");
				System.out.println("아이디 확인 : "+ check_id);
				System.out.println("패스워드 확인 : " + check_pw);
				
				login.cl.show(login.getContentPane(), "LastAreaView");
				login.setTitle("LastView");
				login.area.append(check_id);
				login.area.append(" 님 안녕하세요 ?");
				login.area.append("\n");
				login.area.append("==========================");
				login.area.append("\n");
			}
		}else if (obj == login.btn2) {
			login.area.append(check_id);
			login.area.append(" : ");
			login.area.append(ioArea);
			login.area.append("\n");
		}
		// end of ID PW Check if-else
		
		
		login.area_text.setText("");
	}
}
