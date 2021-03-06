package frame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameFrame extends JFrame  {
	
	/* Panel 및 Dimension 선언 */
	JPanel game_panel;
	Dimension d = new Dimension(671,600);
	
	/* 이미지 - 배경,유저,기본운석,희귀운석,폭탄운석,하트운석*/
	Image bg , user, default_meteor,unique_meteor,bomb_meteor,life;
	
	/* 폭발 이미지 */
	Image[] boom = new Image[27];
	
	/* ArrayList */
	ArrayList<DefaultMeteorThread> default_list = new ArrayList<DefaultMeteorThread>();
	ArrayList<UniqueMeteorThread> unique_list = new ArrayList<UniqueMeteorThread>();
	ArrayList<BombMeteorThread> bomb_list = new ArrayList<BombMeteorThread>();
	ArrayList<HeartLifeUpThread> life_up = new ArrayList<HeartLifeUpThread>();
	ArrayList<Boom> boom_list = new ArrayList<Boom>();
	
	
	/* Class */
	GetRectangle gr;
	Thread default_thread , unique_meteor_thread , bomb_thread , heart_thread;
	 
	/* Score */
	int stage = 1;
	int meteor_score = 0;
	int unique_score = 0;
	
	/* Life */
	int user_life = 10;
	
	/* Audio */
	File get_wav;
	AudioInputStream stream;
	AudioFormat foramt;
	DataLine.Info info;
	Clip clip;
	
	
	
	public GameFrame() {
		gr = new GetRectangle();
		
		for(int i=0; i< boom.length; i++) {
			
			String bFile = String.format("src/images/exp_enemy_1/exp_%d.png", i+1);
			Image exp = new ImageIcon(bFile).getImage();
			
			boom[i] = exp;
		}
		
		/*이미지, 패널, 유저위치,화면 */
		images();
		initPanel();
		initUserPos();
		initWindow();
		
		
		
		/* 운석 스레드 */
		defautMeteorThread();
		uniqueMeteorThread();
		bombMeteorThread();
		heartLifeUp();
		
		
		
		
		default_thread.start();
		unique_meteor_thread.start();
		bomb_thread.start();
		heart_thread.start();
		
		/* 유저 키 이벤트 */
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					gr.pos.x-=35;
					if(gr.pos.x <= game_panel.getWidth() - bg.getWidth(game_panel)) {
						// me.pos.x = 0 ; // 벽에 붙어있게 만들기.
						gr.pos.x = 368;   // 0이되면 오른쪽으로 즉시 이동
					}
					break;
				case KeyEvent.VK_RIGHT:
					gr.pos.x+=35;

					game_panel.repaint();
				}
			}
		});
		
		
	}
	
	private void defautMeteorThread() {
		
		default_thread = new Thread() {
		
		@Override
		public void run() {
			
			while(true) {
				// 운석의 떨어지는 시작점
				DefaultMeteorThread dmc = new DefaultMeteorThread(GameFrame.this, 35, 30);
				
				int rand = (int)(Math.random() * game_panel.getSize().width-35);
				
				dmc.rect.x = rand;
				
				default_list.add(dmc);
			
				dmc.start();
				
				try {
					sleep(1000);
					if(user_life == 0) {
						
						dmc.suspend();
					}
					
				} catch (InterruptedException e) {
				e.printStackTrace();
				}
				setTitle(default_list.size() + "개");
			}
		}
	};
}
	
	private void uniqueMeteorThread() {
		unique_meteor_thread = new Thread() {
			@Override
			public void run() {
				
				while(true) {
					// 운석의 떨어지는 시작점
					UniqueMeteorThread umc = new UniqueMeteorThread(GameFrame.this, 50, 40);
					
					int rand = (int)(Math.random() * game_panel.getSize().width-35);
					
					
					umc.rect.x = rand;
					
					unique_list.add(umc);
				
					umc.start();
					
					try {
						sleep(10000);
						if(user_life == 0) {
							umc.suspend();
						}
					} catch (InterruptedException e) {
					e.printStackTrace();
					}
					
				}	
			}
		};
	}

	private void bombMeteorThread() {
		
		bomb_thread = new Thread() {
			@Override
			public void run() {
				
				while(true) {
					// 운석의 떨어지는 시작점
					BombMeteorThread bmc = new BombMeteorThread(GameFrame.this, 50, 40);
					
					int rand = (int)(Math.random() * game_panel.getSize().width-35);
					
					
					bmc.rect.x = rand;
					
					bomb_list.add(bmc);
				
					bmc.start();
					
					try {
						sleep(130);
						if(user_life == 0) {
							
							bmc.suspend();
						}
						
					} catch (InterruptedException e) {
					e.printStackTrace();
					}
					
				}	
			}
		};
		
	}
	
	private void heartLifeUp() {
		
		heart_thread = new Thread() {
			@Override
			public void run() {
				
				while(true) {
					
					// 운석의 떨어지는 시작점
					HeartLifeUpThread hmc = new HeartLifeUpThread(GameFrame.this, 50, 40);
					
					int rand = (int)(Math.random() * game_panel.getSize().width-35);
					
					
					hmc.rect.x = rand;
					
					life_up.add(hmc);
				
					hmc.start();
					
					try {
						sleep(18000);
						if(user_life == 0) {
							hmc.suspend();
						}
					} catch (InterruptedException e) {
					e.printStackTrace();
					}
					
				}	
			}
		};
	}
	
	private void boomImages() {
		
		
		
	}
	
	private void images() {
		bg = new ImageIcon("src/images/back3.png").getImage();
		user = new ImageIcon("src/images/user.png").getImage();
		default_meteor = new ImageIcon("src/images/meteor.png").getImage();
		unique_meteor = new ImageIcon("src/images/unique_meteor.png").getImage();
		bomb_meteor = new ImageIcon("src/images/bomb2.png").getImage();
		life = new ImageIcon("src/images/heart.png").getImage();
		
		
		
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
		
		gr.pos.x =  (d.width/2) - (img_width /2);

		gr.pos.y =  (d.height - (img_height - (-1)));
		
		
		
		gr.pos.width = img_width;
		gr.pos.height = img_height;
		
	}
	
	private void initPanel() {
		
		game_panel = new JPanel() {
			
			@Override
			protected void paintComponent(Graphics g) {
				
				g.drawImage(bg, 0, 0, this);
				g.drawImage(user, gr.pos.x, gr.pos.y, this);

				g.drawString("Stage : " +  stage  , 325, 530);
				g.drawString("Score : " + meteor_score  , gr.pos.x, gr.pos.y);
				g.drawString("Life : " +  user_life  , 325, 540);
				
				for(int i=0; i<default_list.size(); i++) {
					DefaultMeteorThread dmc = default_list.get(i);
					g.drawImage(default_meteor, dmc.rect.x , dmc.rect.y, this);
					                          // 운석의 떨어지는 시작점
				}
				
				for(int i=0; i<unique_list.size(); i++) {
					UniqueMeteorThread umc = unique_list.get(i);
					g.drawImage(unique_meteor, umc.rect.x , umc.rect.y, this);
					                         
				}
				
				for(int i=0; i<bomb_list.size(); i++) {
					BombMeteorThread bmc = bomb_list.get(i);
					g.drawImage(bomb_meteor, bmc.rect.x , bmc.rect.y, this);		                       
				}
				
				for(int i=0; i<life_up.size(); i++) {
				    HeartLifeUpThread hmc =  life_up.get(i);
					g.drawImage(life, hmc.rect.x , hmc.rect.y, this);
					                         
				}
				
				for (int i=0; i< boom_list.size(); i++) {		
					Boom b = boom_list.get(i);
					g.drawImage(boom[b.index],b.pt.x, b.pt.y,this);
					
					if(b.boomIndex()) {
						boom_list.remove(i);
					}
				}
			}
		};
		
		game_panel.setPreferredSize(d);
		this.add(game_panel);
	}
	
	
}
