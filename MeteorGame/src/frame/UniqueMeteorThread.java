package frame;

import java.awt.Rectangle;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class UniqueMeteorThread extends Thread{
	
	Rectangle rect = new Rectangle();
	
	int speed = 3;
	boolean flag = true;
	
	GameFrame g_frame;
	
	
	public UniqueMeteorThread(GameFrame g_frame , int x , int y) {
		this.g_frame = g_frame;
		
		// 운석의 너비 높이
		this.rect.width = x;
		this.rect.height = y;	
		
//		System.out.println("DefaultMeteorThread : " + this.g_frame.gr.pos);
//		System.out.println("DefaultMeteorThread : " + this.rect.width);
//		System.out.println("DefaultMeteorThread : " + this.rect.height);
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
			
//			java.awt.Rectangle[x=185,y=559,width=30,height=46]
//			System.out.println("이미지 : "+g_frame.gr.pos);
//			System.out.println("운석 : " + rect);
//			System.out.println(g_frame.gr.pos);
			if(g_frame.gr.pos.intersects(rect)){
				if(flag) {
					getUniqueSound();
					g_frame.meteor_score = g_frame.meteor_score + MeteorScoreValue.UNIQUEMETEO;
					System.out.println(g_frame.meteor_score);
					break;
				}
				break;
			}
		}// end of while
	
		g_frame.unique_list.remove(this);
	
	}
	private void getUniqueSound() {
		
		g_frame.get_wav = new File("src/music/unique_meteor.wav");
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
