package pm.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex4_Frame extends JFrame implements  MouseListener{
	
	JLabel label;
	JTextField text;
	JPanel north_panel , center_panel;
	JButton red_btn , green_btn, blue_btn;
	JTextArea area;

	public Ex4_Frame () {
		
		north_panel = new JPanel();
		center_panel = new JPanel();
		
		north_panel.add(label = new JLabel("단 : "));
		north_panel.add(text = new JTextField(5));
		north_panel.add(red_btn = new JButton("입력"));
		
		
		this.add(north_panel, BorderLayout.NORTH);
		this.add(center_panel);
		this.add(new JScrollPane(area = new JTextArea()));
		
		this.setVisible(true);
		this.setTitle("구구단");
		this.setBounds(300,300,400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		red_btn.addMouseListener(this);
		
		

	}

	
	public static void main(String[] args) {
		new Ex4_Frame();
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
		String value = text.getText(); // 텍스트 문자열 가져오기
		
		for (int i=1; i<=9; i++) {
			area.append(value);
			area.append(" * ");
			area.append(Integer.toString(i));
			area.append(" = ");
			area.append(Integer.toString(i*5));
			
			area.append("\r\n");
		}
//		area.setText(Integer.toString(x*=1));

		text.setText("");
	
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
