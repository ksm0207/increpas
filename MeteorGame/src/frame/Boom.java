package frame;

import java.awt.Point;

public class Boom {
	
	int size = 128;
	Point pt = new Point();
	
	int index;
	
	int gap = 5;
	
	int interval = gap;
	
	public boolean boomIndex() {
		
		if(interval == gap) {
			index ++;
		}
		interval --;
		
		if(interval == 0) {
			interval = gap;
		}
		return index >= 27;
	}

}
