package pm.JFrame;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Example extends JFrame implements  MouseListener{
	
	JLabel label;
	JTextField text;
	JPanel north_panel , center_panel;
	JButton btn; 
	JTextArea area;

	public Example () {
		
		north_panel = new JPanel();
		center_panel = new JPanel();
		
		north_panel.add(label = new JLabel("단 : "));
		north_panel.add(text = new JTextField(5));
		north_panel.add(btn = new JButton("입력"));
		
		this.add(north_panel, BorderLayout.NORTH);
		this.add(center_panel);
		this.add(new JScrollPane(area = new JTextArea()));
		
		this.setVisible(true);
		this.setTitle("구구단");
		this.setBounds(300,300,400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn.addMouseListener(this);
	}

	public static void main(String[] args) {
		new Example();
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		
		String value = text.getText(); 
		int x = Integer.parseInt(value);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=1; i<=9; i++) {
			sb.append(value);
			area.append(value);
			area.append(" * ");
			area.append(Integer.toString(i));
			area.append(" = ");
			area.append(Integer.toString(x*i));
			area.append("\r\n");
		}
		
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
