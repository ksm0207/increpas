package Starcraft;

import java.util.ArrayList;

public class Barracks {
	
	ArrayList<TerranVO> items = new ArrayList<TerranVO>();
	
	public void getInit() {
		items.add(new TerranVO("마린", 50, 0, 1));
		items.add(new TerranVO("파이어뱃", 50, 25, 1));
		items.add(new TerranVO("고스트", 25, 75, 1));
		items.add(new TerranVO("메딕", 50, 25, 1));
	}
	
	public void getViewUnit() {
		
		for (int i=0; i<items.size(); i++) {
			System.out.println((i+1) +"."+items.get(i));
		}
		
	}

}
