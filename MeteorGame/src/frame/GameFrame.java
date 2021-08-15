package frame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame  {
	
	JPanel game_panel;
	
	Dimension d = new Dimension(671,600);
	
	Image bg , user, default_meteor,unique_meteor;
	
	/* ArrayList */
	ArrayList<DefaultMeteorThread> default_list = new ArrayList<DefaultMeteorThread>();
	
	/* Class */
	GetRectangle gr;
	Thread startThread;
	 
	

	public GameFrame() {
		gr = new GetRectangle();
		
		images();
		initPanel();
		initUserPos();
		initWindow();
		
		startThread = new Thread() {
			
			@Override
			public void run() {
				
				while(true) {
					System.out.println("Test");
					// 운석의 떨어지는 시작점
					DefaultMeteorThread dmc = new DefaultMeteorThread(GameFrame.this, 35, 30);
					
					int rand = (int)(Math.random() * game_panel.getSize().width-35);
					
					
					dmc.rect.x = rand;
					
					default_list.add(dmc);
				
					dmc.start();
					
					try {
						
						sleep(1000);
					} catch (InterruptedException e) {
					e.printStackTrace();
					}
					setTitle(default_list.size() + "개");
				}
				
				
				
			
			}
		};
		startThread.start();
		
		this.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(gr.pos.x);
				System.out.println("Game Panel Width : "+ game_panel.getWidth());
				System.out.println("BackGround Width : " + bg.getWidth(game_panel));
				
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					gr.pos.x-=5;
					if(gr.pos.x <= game_panel.getWidth() - bg.getWidth(game_panel)) {
						// me.pos.x = 0 ; // 벽에 붙어있게 만들기.
						gr.pos.x = 368;   // 0이되면 오른쪽으로 즉시 이동
					}
					break;
				case KeyEvent.VK_RIGHT:
					gr.pos.x+=5;

					game_panel.repaint();
				}
			}
		});
		
		
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
				g.drawString("Score", gr.pos.x, gr.pos.y);
				
				for(int i=0; i<default_list.size(); i++) {
					DefaultMeteorThread dmc = default_list.get(i);
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
