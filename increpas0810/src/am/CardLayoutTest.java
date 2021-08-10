package am;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CardLayoutTest extends JFrame {
	
	JPanel card_panel1 , card_panel2;
	JButton btn1,btn2,btn3; /* 카드에 들어가는 버튼 */
	
	/* card_panel2에 들어갈 객체  */
	JTextField jText1;
	JButton confirm_btn;
	
	/* CardLayout */
	CardLayout cl;
	
	public CardLayoutTest() {
		
		/* 현재 Layout 변경 */
		
		cl = new CardLayout();
		this.getContentPane().setLayout(cl);
		
		/* getContentPane() -  컨테이너를 불러온다 . */
		
		
		/* 첫번째 화면 만들기 */
		card_panel1 = new JPanel();

		card_panel1.add(btn1 = new JButton("버튼1"));
		card_panel1.add(btn2 = new JButton("버튼2"));
		card_panel1.add(btn3 = new JButton("버튼3"));
		
		// CardLayout 은 이제 Container에 적용되었으니
		// 화면에 Container를 적용하기.
		this.getContentPane().add("FirstCard",card_panel1);
		
		/* 두번째 화면 만들기 */
		card_panel2 = new JPanel();
		
		card_panel2.add(jText1 = new JTextField(12));
		card_panel2.add(confirm_btn = new JButton("확인"));
		this.getContentPane().add("SecondCard",card_panel2);
		
		/* Window 객체 */
		this.addWindowListener(new MyWinAdap());
		
		/* Action Event */
		btn3.addActionListener(new CardActionHandler(this));
		confirm_btn.addActionListener(new CardActionHandler(this));
		
		/* 화면 영역 설정 */
		this.setBounds(110,80,550,380);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new CardLayoutTest();
	}
}

class CardActionHandler implements ActionListener{
	
	CardLayoutTest card;
	
	public CardActionHandler(CardLayoutTest card) {
		this.card = card;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 1. btn3 과 ok_bt를 구별해야되므로 이벤트를 발생시킨다
		
		Object obj = e.getSource();
		
		if(obj == card.btn3) {
			card.cl.show(card.getContentPane(), "SecondCard");
		}else if (obj == card.confirm_btn) {
			card.cl.show(card.getContentPane(), "FirstCard");
		}
		
		System.out.println("이벤트 감지");
	}
	
}
