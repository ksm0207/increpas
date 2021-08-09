package pm.EX3;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ex3_MyMouseAdap extends MouseAdapter {
	
	Ex3_Frame frame;
	public Ex3_MyMouseAdap(Ex3_Frame frame) {
		// 받은 객체의 주소가 없어지기 전에 멤버변수에 저장!
		this.frame = frame;
	}

	// 필요한 메서드만 재정의
	@Override
	public void mousePressed(MouseEvent e) {
		// 클릭한 지점의 x,y좌표 값 알아내기
		int x = e.getX();
		int y = e.getY();
		
		frame.can.x = x;// 캔버스가 가지고 있는 x,y값을 변경한다.
		frame.can.y = y;
		
		System.out.println(x);
		
		//좌표가 변경되었으니... 다시 그림을 그리도록 한다.
		frame.can.repaint();
	}

	
	
}
