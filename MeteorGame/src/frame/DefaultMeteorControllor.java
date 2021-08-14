package frame;

import java.awt.Rectangle;

import javax.swing.JOptionPane;

public class DefaultMeteorControllor extends Thread{
	
	
	
	Rectangle rect = new Rectangle();
	
	int speed = 3;
	
	GameFrame g_frame;
	
	public DefaultMeteorControllor(GameFrame g_frame , int x_width , int y_height) {
		this.g_frame = g_frame;
		this.rect.x = x_width;
		this.rect.y = y_height;
		
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			rect.y += speed;
			
			try {
				sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
			g_frame.game_panel.repaint();
			
			if(g_frame.gr.pos.intersects(rect)) {					//운석높이 || pos.y >= frame.game_panel.getSize().getHeight() -(30)
			
				break;
			}
			
		}// end of while
		
		g_frame.default_list.remove(this);
	
	}
	

}
