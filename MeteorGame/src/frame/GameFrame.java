package frame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameFrame extends JFrame  {
	
	/* Panel 및 Dimension 선언 */
	JPanel game_panel;
	Dimension d = new Dimension(671,600);
	
	/* 이미지 선언*/
	Image bg , user, default_meteor,unique_meteor,bomb_meteor;
	
	/* ArrayList */
	ArrayList<DefaultMeteorThread> default_list = new ArrayList<DefaultMeteorThread>();
	ArrayList<UniqueMeteorThread> unique_list = new ArrayList<UniqueMeteorThread>();
	ArrayList<BombMeteorThread> bomb_list = new ArrayList<BombMeteorThread>();
	
	/* Class */
	GetRectangle gr;
	Thread startThread , unique_meteor_thread , bomb_thread;
	 
	/* Score */
	int meteor_score = 0;
	int unique_score = 0;
	
	/* Life */
	int user_life = 1;
	
	public GameFrame() {
		gr = new GetRectangle();
		
		/*이미지, 패널, 유저위치,화면 */
		images();
		initPanel();
		initUserPos();
		initWindow();
		
		/* 운석 스레드 */
		defautMeteorThread();
		uniqueMeteorThread();
		bombMeteorThread();
		
		startThread.start();
		unique_meteor_thread.start();
		bomb_thread.start();
		
		/* 유저 키 이벤트 */
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					gr.pos.x-=10;
					if(gr.pos.x <= game_panel.getWidth() - bg.getWidth(game_panel)) {
						// me.pos.x = 0 ; // 벽에 붙어있게 만들기.
						gr.pos.x = 368;   // 0이되면 오른쪽으로 즉시 이동
					}
					break;
				case KeyEvent.VK_RIGHT:
					gr.pos.x+=10;

					game_panel.repaint();
				}
			}
		});
		
		
	}
	
	private void defautMeteorThread() {
		
		startThread = new Thread() {
		
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
						sleep(500);
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
	
	private void images() {
		bg = new ImageIcon("src/images/back3.png").getImage();
		user = new ImageIcon("src/images/user.png").getImage();
		default_meteor = new ImageIcon("src/images/meteor.png").getImage();
		unique_meteor = new ImageIcon("src/images/unique_meteor.png").getImage();
		bomb_meteor = new ImageIcon("src/images/bomb2.png").getImage();
		
		
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
				
				
			}
			
		};
		
		game_panel.setPreferredSize(d);
		this.add(game_panel);
	}
	
	
}
