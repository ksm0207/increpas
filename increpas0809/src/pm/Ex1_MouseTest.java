package pm;

import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import am.MyWinAdap;

public class Ex1_MouseTest extends JFrame{

	JPanel center_panel;
	ArrayList<MyMouseMaps> m_items = new ArrayList<MyMouseMaps>();
	
	
	public Ex1_MouseTest() {
	
//		center_panel = new JPanel();
		this.add(center_panel = new JPanel());
		
		
		this.setBounds(300,400,350,200);
		this.setVisible(true);
		System.out.println("생성자 호출");
	
		
		this.addWindowListener(new MyWinAdap());
		center_panel.addMouseListener(new MyMouseMaps(this));
		
		
		
		System.out.println(m_items.size());
	
	}
	
	public static void main(String[] args) {
		
		new Ex1_MouseTest();
	}
	
}

