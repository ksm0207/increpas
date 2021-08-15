package view;

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

import frame.GameFrame;
import javax.swing.UIManager;
import java.awt.Font;

public class AppMainView extends JFrame {
	
	/* Jpanel */
	JPanel card_panel1, card_panel2,p1,p2;
	JPanel first_penal,last_panel;
	/* JButton */
	JButton btn1, btn2;
	/* JLabel */
	JLabel icon_label;
	/* CardLayout */
	CardLayout cl;
	
	/* Area */
	ImageIcon icon;	
	
	boolean check = true;
	
	public AppMainView() {
		cl = new CardLayout();
		this.getContentPane().setLayout(cl);
		
		card_panel1 = new JPanel(new BorderLayout());
		first_penal = new JPanel();
		
		p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p2 = new JPanel();
		
		
		p2.add(btn1 = new JButton(" Start "));
	
		first_penal.add(p2,BorderLayout.NORTH);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(check) {
					JOptionPane.showMessageDialog(AppMainView.this, "Game Start!");
					AppMainView.this.dispose();
					new GameFrame();
				}
	
			}
		});
		
		first_penal.add(p1);
		
		icon = new ImageIcon("src/images/back2.png");
		card_panel1.add(icon_label = new JLabel(icon));
		card_panel1.add(first_penal, BorderLayout.SOUTH);
		this.getContentPane().add("FirstLoginView",card_panel1);

		/* --------------------------------------------------------- */
	
		/* 화면 영역 설정 */
		this.setTitle("ViewTest1");
		this.setBounds(110,50,600,550);
		this.setVisible(true);
		
		/* Window Event */
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		/* Action Event */
		
	
		
	}
	
	public static void main(String[] args) {
		new AppMainView();
	}
}

class StartButton implements ActionListener{
	
	AppMainView view;
	
	
	public StartButton(AppMainView view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
				
		
		
	}
	
}
