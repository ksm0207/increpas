package am;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ActionTest extends JFrame{
	
	JPanel north_panel;
	JTextField jText1;
	JButton btn;
	JTextArea area;
	

	public ActionTest() {
		
		/* North Panel 설정*/
		north_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		north_panel.add(jText1 = new JTextField(10));
		north_panel.add(btn = new JButton("확인"));
		this.add(north_panel,BorderLayout.SOUTH);
		/* end */
		
		/* JTextArea 설정 */
		this.add(new JScrollPane(area = new JTextArea()));
		
		/* 화면 설정 */
		this.setBounds(200,100,550,400);
		this.setVisible(true);
		
		/* Window */
		this.addWindowListener(new MyWinAdap());
		
		/* ActionEvent */
		btn.addActionListener(new BtnTextHandler(this));
		jText1.addActionListener(new BtnTextHandler(this));
	}

	public static void main(String[] args) {
		new ActionTest();
		
	}
}

class BtnTextHandler implements ActionListener{
	
	ActionTest action;
	
	public BtnTextHandler(ActionTest action) {
		this.action = action;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 액션이벤트를 발생시킬 객체가 JButton 만 있는 것이 아니라
		// JTextField도 있다. 어떤 객체가 ActionEvent를 발생시켰는지
		// 가려내야 한다.
		// Btn , Text 동작은 같으므로 구분할 필요 없다.
		System.out.println("액션감지");
		
		Object obj = e.getSource();
		
		// 1. 사용자가 text에 입력한 값을 가져오기.
		String text = action.jText1.getText();
		
		System.out.println(text);
		
		// 2. 가져온 Text를 JTextArea로 전달
		action.area.append(text);
		action.area.append("\n");
		
		System.out.println(action.area);
		
		// 3. area 필드 청소
		action.jText1.setText("");
		
	}
	
}// end of BtnTextHandler