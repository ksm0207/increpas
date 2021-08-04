package pm;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex5_Image extends JFrame implements ActionListener{
	
	ImageIcon img1 ,img2 ,img3 ,img4 ;
//	JLabel label;
	
	GridLayout grid;
	JButton [] btn;
	StringBuffer sb;
	
	public Ex5_Image() {
		
		initImage();
		btn = new JButton [4];
		for (int i=0; i<btn.length; i++) {
			
			sb = new StringBuffer();
			sb.append("버튼");
			sb.append((i+1));
			btn[i] = new JButton(sb.toString());
			switch (i) {
			case 0:
				btn[i] = new JButton(img1);
			
				this.add(btn[i]);
				break;
			
			}
		}// end of for (1)
		
//		Layout
		grid = new GridLayout(2,2);
		this.setLayout(grid);
		
		
		
		
//		Window Screen
		this.setBounds(650, 400, 850, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("Test");
	}
	
	public static void main(String[] args) {
		
		new Ex5_Image();
	}

	public void initImage() {
		img1 = new ImageIcon("src/images/kakao.png");
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btn[0]) {
			btn[0].setBackground(Color.black);
		}
		
	}
}
