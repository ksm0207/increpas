package pm;

import am.Cup;

public class Ex1_Main {
	
	public static void main(String[] args) {
		// 오전에 만든 Cup을 import 하여 배열로 만들기
		
		Cup [] ar = new Cup [3];
		
		for (int i=0 ; i < ar.length; i++) {
			ar[i] = new Cup();
			switch (i) {
			case 0:
				ar[i].setColor("Red");
				ar[i].setCupCapacity(100);
				ar[i].setCupMaterial("유리");
				break;
			case 1:
				ar[i].setColor("Blue");
				ar[i].setCupCapacity(100);
				ar[i].setCupMaterial("유리");
				break;	
			case 2:
				ar[i].setColor("Green");
				ar[i].setCupCapacity(100);
				ar[i].setCupMaterial("유리");
				break;	
			}
			System.out.println(ar[i].getColor());
			System.out.println(ar[i].getCupCapacity());
			System.out.println(ar[i].getCupMaterial());
		}
	}
	
}
