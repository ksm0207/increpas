package frame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame  {
	
	JPanel game_panel;
	Rectangle pos = new Rectangle();
	Dimension d = new Dimension(671,600);
	
	Image bg , user, default_meteor,unique_meteor;
	
	/* ArrayList */
	ArrayList<DefaultMeteorControllor> default_list = new ArrayList<DefaultMeteorControllor>();
	
	/* Class */
	GetRectangle gr;
	 
	

	public GameFrame() {
		gr = new GetRectangle();
		
		images();
		initPanel();
		initUserPos();
		initWindow();
		
		while(true) {
			System.out.println("Test");
																	// 운석의 떨어지는 시작점
			DefaultMeteorControllor dmc = new DefaultMeteorControllor(GameFrame.this, 35, 30);
			default_list.add(dmc);
			
			int rand = (int)(Math.random() * game_panel.getSize().width-35);
			dmc.rect.x = rand;
			
			default_list.add(dmc);
			
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	
		
		
		
		
		
		
		
	}
	private void images() {
		bg = new ImageIcon("src/images/back.png").getImage();
		user = new ImageIcon("src/images/user.png").getImage();
		default_meteor = new ImageIcon("src/images/meteor.png").getImage();
		unique_meteor = new ImageIcon("src/images/unique_meteor.png").getImage();
	}
	
	
	private void initWindow() {
		this.setLocation(300,50);
		this.pack();
//		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("하늘에서 떨어지는 운석 캐기");
	}

	
	private void initUserPos() {
		
		int img_width = user.getWidth(this);
		
		int img_height = user.getHeight(this);
		
		pos.x =  (d.width/2) - (img_width /2);

		pos.y =  (d.height - (img_height - (-1)));
		
		System.out.println(pos.y);
		
		pos.width = img_width;
		pos.height = img_height;
		
	}
	
	private void initPanel() {
		
		game_panel = new JPanel() {
			
			@Override
			protected void paintComponent(Graphics g) {
				
				g.drawImage(bg, 0, 0, this);
				g.drawImage(user, pos.x, pos.y, this);
				g.drawString("Score", pos.x, pos.y);
				
				for(int i=0; i<default_list.size(); i++) {
					DefaultMeteorControllor dmc = default_list.get(i);
					g.drawImage(default_meteor, dmc.rect.x , dmc.rect.y, this);
					                          // 운석의 떨어지는 시작점
				}
			}
			
		};
		
		game_panel.setPreferredSize(d);
		this.add(game_panel);
	}
	
	
	public static void main(String[] args) {
		new GameFrame();
		
	}
	
}
