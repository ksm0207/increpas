package pm;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import am.MyWinAdap;

public class CardLayoutTest2 extends JFrame {
	
	JPanel card_panel1, card_panel2, p1, p2;
	JButton btn1, btn2, confrim_btn;
	CardLayout cl;
	
	public CardLayoutTest2() {
		
		
		/* 현재 창의 Cantainer에 CardLayout을 지정한다 */
		cl = new CardLayout();
		this.getContentPane().setLayout(cl);
		
		/* 첫번째 화면 만들기 */
		card_panel1 = new JPanel(new BorderLayout());
		JPanel n1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		n1.add(btn1 = new JButton("다음"));
		card_panel1.add(n1, BorderLayout.SOUTH);
		card_panel1.add(p1 = new JPanel());
		p1.setBackground(Color.BLUE);
		
		/* 현재 창의 Container에 '저장할 이름' 으로 카드를 저장한다 */
		this.getContentPane().add("BlueCard",card_panel1);
		
		/* ---------------------------------------------------------*/
		
		/* 두번째 화면 만들기 */
		card_panel2 = new JPanel(new BorderLayout());
		JPanel n2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		n2.add(btn2 = new JButton("이전"));
		card_panel2.add(n2, BorderLayout.NORTH);
		card_panel2.add(p2 = new JPanel());
		p2.setBackground(Color.RED);
		
		this.getContentPane().add("RedCard",card_panel2);
		
		this.setTitle("Card Layout Example ");
		this.setBounds(110,50,550,250);
		this.setVisible(true);
		
		/* Window Event */
		this.addWindowListener(new MyWinAdap());
		
		/* Button Action Event */
		btn1.addActionListener(new BackGroundAction(this));
		btn2.addActionListener(new BackGroundAction(this));
		
	}
	
	public static void main(String[] args) {
		new CardLayoutTest2();
	}
}

class BackGroundAction implements ActionListener{
	
	CardLayoutTest2 card2;
	
	public BackGroundAction(CardLayoutTest2 card2) {
		this.card2 = card2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if(obj == card2.btn1) {
			card2.cl.show(card2.getContentPane(), "RedCard");
		}else{
			card2.cl.show(card2.getContentPane(), "BlueCard");
		}
		
		System.out.println("이벤트 감지");
		
	}
	
}
