package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import frame.GameFrame;

public class AppMainView extends JFrame {
	
	JPanel background;
	JButton gamebtn;
	Image bg ;
	
	public AppMainView() {
		
		bg = new ImageIcon("src/images/back3.png").getImage();
		background = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				
				g.drawImage(bg,0,0,this);
			}
		};
		
		gamebtn = new JButton("Start!");
		
		this.setTitle("Home");
		this.setSize(400,600);
//		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		background.setLayout(null);
		background.setBounds(0,0,400,600);
		
		gamebtn.setBounds(0,515,395,50);
		gamebtn.setBackground(new Color(20,29,40));
		gamebtn.setForeground(Color.WHITE);
		
		this.add(gamebtn,BorderLayout.NORTH);
		this.add(background);
		
		gamebtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(gamebtn == e.getSource())
					AppMainView.this.dispose();
					new GameFrame();
			}
		});
	}
	public static void main(String[] args) {
		new AppMainView();
	}
}

