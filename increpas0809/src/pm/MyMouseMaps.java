package pm;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MyMouseMaps extends MouseAdapter{
	
	 Ex1_MouseTest ex1;
	 
	 
	public MyMouseMaps(Ex1_MouseTest ex1) {
		this.ex1 = ex1;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// 1. 마우스 클릭 시 X 좌표와 Y 좌표를 구하자.
		int x = e.getX();
		int y = e.getY();
		
		StringBuffer sb = new StringBuffer();
		sb.append("X좌표 : ");
		sb.append(x);
		sb.append(",Y좌표 : ");
		sb.append(y);
		
		ex1.setTitle(sb.toString());
		
//		System.out.println(sb.toString());

	}

}
