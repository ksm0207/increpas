package frame;

import java.awt.Rectangle;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JOptionPane;

public class HeartLifeUpThread extends Thread{
	
	Rectangle rect = new Rectangle();
	
	int speed = 5;
	boolean flag = true;
	
	GameFrame g_frame;
	
	
	public HeartLifeUpThread(GameFrame g_frame , int x , int y) {
		this.g_frame = g_frame;
		
		// 운석의 너비 높이
		this.rect.width = x;
		this.rect.height = y;	
		
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
			
			if(g_frame.gr.pos.intersects(rect)){
				if(flag) {
					getLifeUp();
					g_frame.user_life = g_frame.user_life +1;
					break;
				}
				break;
			}
			
		}// end of while
		
		g_frame.life_up.remove(this);
	}
	
	private void getLifeUp() {
		
		g_frame.get_wav = new File("src/music/lifeup.wav");
		try {
			g_frame.stream = AudioSystem.getAudioInputStream(g_frame.get_wav);
			g_frame.foramt = g_frame.stream.getFormat();
			g_frame.info = new DataLine.Info(Clip.class, g_frame.foramt);
			g_frame.clip = (Clip)AudioSystem.getLine(g_frame.info);
			g_frame.clip.open(g_frame.stream);
			g_frame.clip.start();			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

}
