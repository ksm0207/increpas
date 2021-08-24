package am;

import java.awt.Color;
import java.io.Serializable;

public class OvalPaint implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	int x;
	int y;
	int wh;
	Color color;
	
	public OvalPaint(int x, int y , int wh, Color color) {
		this.x = x;
		this.y = y;
		this.wh = wh;
		this.color = color;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWh() {
		return wh;
	}
	public void setWh(int wh) {
		this.wh = wh;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	

}
