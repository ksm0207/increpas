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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import am.MyWinAdap;

public class LoginView extends JFrame {
	
	JPanel card_panel1, card_panel2;
	JButton btn1, btn2;
	JLabel id_label,pw_label;
	CardLayout cl;
	JTextField id_text,area_text;
	JPasswordField pw_text;
	JTextArea area;
	JPanel first_penal,last_panel;
	ImageCanvars talkImage;
	
//	GridLayout grid;
	
	public LoginView() {
		
		cl = new CardLayout();
		this.getContentPane().setLayout(cl);
	
		
		card_panel1 = new JPanel(new BorderLayout());
		
		first_penal = new JPanel();
	
		first_penal.add(id_label = new JLabel("ID : "));
		first_penal.add(id_text = new JTextField(10));
		first_penal.add(pw_label = new JLabel("PW"));
		first_penal.add(pw_text = new JPasswordField(10));
		
		first_penal.add(btn1 = new JButton("로그인"));
		card_panel1.add(first_penal, BorderLayout.SOUTH);
		card_panel1.add(talkImage = new ImageCanvars());
		this.getContentPane().add("FirstLoginView",card_panel1);
		
		/* --------------------------------------------------------- */
	
		card_panel2 = new JPanel(new BorderLayout());
		last_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		last_panel.add(area_text = new JTextField(40));
		last_panel.add(btn2 = new JButton("보내기"));
		card_panel2.add(last_panel, BorderLayout.SOUTH);
		card_panel2.add(new JScrollPane(area = new JTextArea()));
		
		this.getContentPane().add("LastAreaView",card_panel2);
		
		
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
			if (check_id.trim().isEmpty()) {
				System.out.println("아이디 미입력 확인");
				login.cl.show(login.getContentPane(), "FirstLoginView");
			}else if (check_pw.isEmpty()) {
				System.out.println("패스워드 미입력 확인");
			}else{
				System.out.println("로그인");
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
		}// end of ID PW Check if-else
		
		login.area_text.setText("");
	}
}


class ImageCanvars extends Canvas {
	Image talk;
	
	public ImageCanvars() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		talk = tk.getImage("src/images/talk.png");
	}
	
	@Override
	public void paint(Graphics g) {
	
		g.drawImage(talk, 100, 15, this);
	}
}
