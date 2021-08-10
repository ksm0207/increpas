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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import am.MyWinAdap;

public class LoginView extends JFrame {
	
	JPanel card_panel1, card_panel2;
	JButton btn1, btn2;
	JLabel idLabel;
	CardLayout cl;
	JTextField id_Text,jText2;
	JTextArea area;
	JPanel f_penal,l_panel;
	ImageCanvars talkImage;
	
//	GridLayout grid;
	
	public LoginView() {
		
		cl = new CardLayout();
		this.getContentPane().setLayout(cl);
	
		
		card_panel1 = new JPanel(new BorderLayout());
		
		f_penal = new JPanel();
	
		f_penal.add(idLabel = new JLabel("ID : "));
		f_penal.add(id_Text = new JTextField(10));
		f_penal.add(btn1 = new JButton("로그인"));
		card_panel1.add(f_penal, BorderLayout.SOUTH);
		card_panel1.add(talkImage = new ImageCanvars());
		this.getContentPane().add("FirstLoginView",card_panel1);
		
		/* --------------------------------------------------------- */
	
		card_panel2 = new JPanel(new BorderLayout());
		l_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		l_panel.add(jText2 = new JTextField(40));
		l_panel.add(btn2 = new JButton("보내기"));
		card_panel2.add(l_panel, BorderLayout.SOUTH);
		card_panel2.add(new JScrollPane(area = new JTextArea()));
		
		this.getContentPane().add("LastLoginView",card_panel2);
		
		
		this.setTitle("Login View ");
		this.setBounds(110,50,550,450);
		this.setVisible(true);
		
		/* Window Event */
		this.addWindowListener(new MyWinAdap());
		
		/* Action Event */
		btn1.addActionListener(new LoginCheck(this));
		btn2.addActionListener(new LoginCheck(this));
		jText2.addActionListener(new LoginCheck(this));
	
		
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
		
		String check_id = login.id_Text.getText();
		String output = login.jText2.getText();
		
		if (obj == login.btn1) {
			if (check_id.trim().isEmpty()) {
				System.out.println("아이디 공백 탐지 : " + login.id_Text.getText());
				login.cl.show(login.getContentPane(), "FirstLoginView");
			}else {
				System.out.println("아이디 확인 : "+ login.id_Text.getText());
				login.cl.show(login.getContentPane(), "LastLoginView");
			}
		}else if (obj == login.btn2) {
			login.area.append(output);
			login.area.append("\n");
		}// end of Id Check if-else
		
		login.jText2.setText("");
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
