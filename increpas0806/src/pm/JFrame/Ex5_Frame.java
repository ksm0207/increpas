package pm.JFrame;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex5_Frame extends JFrame implements MouseListener {

	JPanel north_panel;
	JTextField text1;
	JButton btn;
	JTextArea area;

	public Ex5_Frame() {
	
		north_panel = new JPanel();
		north_panel.add(text1 = new JTextField(12));
		north_panel.add(btn = new JButton("Ok"));
		this.add(north_panel, BorderLayout.NORTH);
		this.add(new JScrollPane(area = new JTextArea()));
		
		this.setVisible(true);
		this.setBounds(300,300,400,300);
		
		this.addWindowListener(new Ex3_Window());
		
		// 버튼에서 마우스 버튼을 클릭하면 현재 객체에서
		// 콜백메소드를 호출한다.
		btn.addMouseListener(this);
		
		north_panel.addMouseListener(this);
	}
	
	
	public static void main(String[] args) {
	
		new Ex5_Frame();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String value = text1.getText(); // 텍스트 문자열 가져오기
		
		// area에 추가하기
		area.append(value);
		area.append("\r\n"); // 엔터키로 줄바꿈
		// Text 청소
		text1.setText("");
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
