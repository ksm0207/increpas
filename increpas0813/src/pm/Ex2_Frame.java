package pm;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Ex2_Frame extends JFrame{
	
	final static int METEORSCORE = 100;
	
	int scoreM;
	int count;
	
	JPanel game_panel;
	
	Ex2_me me;
	Dimension d = new Dimension(400,600);
	Thread thread , thread2;
	
	boolean flag = true;
	Image bg_img , user_img , meteor_img,unique_meteor_img;
	
	ArrayList<Ex2_Meteor> list = new ArrayList<Ex2_Meteor>();
	ArrayList<UniqueMeteor> u_list = new ArrayList<UniqueMeteor>();
	ArrayList<Exploslon> exploslon_List = new ArrayList<Exploslon>();
	
	Timer timer = new Timer();
	TimerTask timer_task ;
	
	// 폭발 이미지
	Image[] exp_img = new Image[27];
	
	
	public Ex2_Frame() {
		
		me =  new Ex2_me();
		
		bg_img = new ImageIcon("src/images/back.jpg").getImage();
		user_img = new ImageIcon("src/images/me.png").getImage();
		meteor_img = new ImageIcon("src/images/meteor.png").getImage();
		unique_meteor_img = new ImageIcon("src/images/unique_meteor.png").getImage();
		
		// 폭발이미지 추가
		for (int i=0; i<exp_img.length; i++) {
			
			String fname = String.format("src/images/exp_enemy_1/exp_%d.png", i+1);
			
			Image exp = new ImageIcon(fname).getImage();

			exp_img[i] = exp;
		}
		
		init_gamePan(); // 게임판 초기화
		init_me_pos(); // 사용자 위치 초기화
		startMeteorThread();
		uniqueThread();
		
		this.setLocation(300,50);
		this.pack();
//		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("게임");
		thread.start();
		thread2.start();
		
		this.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				System.out.println(me.pos.x);
				System.out.println("Game Panel Width : "+ game_panel.getWidth());
				System.out.println("BackGround Width : " + bg_img.getWidth(game_panel));
				
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					me.pos.x-=3;
					if(me.pos.x <= game_panel.getWidth() - bg_img.getWidth(game_panel)) {
						// me.pos.x = 0 ; // 벽에 붙어있게 만들기.
						me.pos.x = 368;   // 0이되면 오른쪽으로 즉시 이동
					}
					break;
				case KeyEvent.VK_RIGHT:
					me.pos.x+=3;
//					if(me.pos.x >= game_panel.getWidth() - bg_img.getWidth(game_panel) ) {
//						me.pos.x = game_panel.getWidth() - bg_img.getWidth(game_panel);
//						System.out.println(me.pos.x > game_panel.getWidth() - bg_img.getWidth(game_panel));
//					}
					game_panel.repaint();
				}
			}
		});
	}
	
	
	
	private void startMeteorThread() {
		thread = new Thread() {
			
			@Override
			public void run() {
				while(true) {
					
					Ex2_Meteor m = new Ex2_Meteor(Ex2_Frame.this, 35, 30);	
				// 운석의 x 좌표를 난수로 발생하여 생기게하기
					int rand = (int)(Math.random() * game_panel.getSize().width-35);
					
				// 위 난수를 가지고 m의 Rectangle로 지정하기.
					m.pos.x = rand;
					
					
				// 운석 저장
					list.add(m);
					m.start();
					try {
						sleep(1000);
						if(count == 5) {
							m.suspend();
							System.out.println("스레드 중단");
						}	
					} catch (Exception e) {
						// TODO: handle exception
					}
					setTitle(list.size() + "개");
				}
			}
		};
		
	}
	
	private void uniqueThread() {
		thread2 = new Thread() {
			
			@Override
			public void run() {
				while(flag) {
					
					UniqueMeteor u = new UniqueMeteor(Ex2_Frame.this, 35, 30);	
				// 운석의 x 좌표를 난수로 발생하여 생기게하기
					int rand = (int)(Math.random() * game_panel.getSize().width-35);
					
				// 위 난수를 가지고 m의 Rectangle로 지정하기.
					u.pos.x = rand;
					
					UniqueMeteor unique = new UniqueMeteor(Ex2_Frame.this, 35, 30);
					int rand2 = (int)(Math.random() * game_panel.getSize().width-35);
					
					unique.pos.x = rand2;
					
				// 운석 저장
					
					u_list.add(unique);
					
					unique.start();
					
					try {
						sleep(5000);
						if(count == 5) {
							unique.suspend();
							
						}	
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
			}
		};	
	}
	
	private void init_gamePan(){
		game_panel = new JPanel() {
			
			@Override
			protected void paintComponent(Graphics g) {
				
				
			
				g.drawImage(bg_img, 0, 0, this);
				g.drawImage(user_img, me.pos.x, me.pos.y, this);
				
				g.drawString("Score" + Integer.toString(scoreM), me.pos.x, me.pos.y);
				
				for (int i=0; i<list.size(); i++) {
					Ex2_Meteor ex2 = list.get(i);
					g.drawImage(meteor_img, ex2.pos.x, ex2.pos.y, this);
				}
				
				for(int i=0; i < u_list.size(); i ++) {
					UniqueMeteor unique = u_list.get(i);
					g.drawImage(unique_meteor_img,unique.pos.x, unique.pos.y,this);
				}
		
				for (int i=0; i< exploslon_List.size(); i++) {
					Exploslon func = exploslon_List.get(i);
					g.drawImage(exp_img[func.index],func.pt.x, func.pt.y,this);
					
					if(func.move_index()) {
						exploslon_List.remove(i);
					}
					
				}
			}
		
		};
	
		// ▼ 크기 예약
		game_panel.setPreferredSize(d);
		
		// 현재 창 가운데에 추가하기
		this.add(game_panel);
	}
	
	private void init_me_pos() {
	
		/* 사용자 이미지의 너비 지정 */
		int img_width = user_img.getWidth(this);
		System.out.println(img_width);
		int img_height = user_img.getHeight(this);
		
		/* Rectangle 의 너비 와 높이를 지정하기 */
		me.pos.x =  (d.width/2) - (img_width /2);
		System.out.println(me.pos.x);
		me.pos.y =  (d.height - (img_height - 5));
		
//		game_panel.getHeight()
		me.pos.width = img_width;
		me.pos.height = img_height;
	}
	
	public static void main(String[] args) {
		new Ex2_Frame();
		
	}
}

class Ex2_Meteor extends Thread{
	
	Rectangle pos = new Rectangle();
	
	int speed = 5;
	int score;
	
	
	boolean flag = true;
	
	Ex2_Frame frame; // 운석객체가 생성된 후 패널에 다시 그린다.
//						y좌표를 확인하여 객체를 ArrayList에 담고 삭제한다	

	public Ex2_Meteor(Ex2_Frame frame , int w , int h) {
		this.frame = frame;
		this.pos.width = w;
		this.pos.height = h;
		
	}
	
	@Override
	public void run() {
		
		while(true) {
			pos.y+=speed;
			
			try {
				sleep(10);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			frame.game_panel.repaint();
			
			
			// 사용자 이미지와 현재 운석이 충돌했거나
			// 운석이 바닥에 도달했다면 탈출하기
//			System.out.println(frame.me.pos.intersects(pos));
			
			if(frame.me.pos.intersects(pos)	) {					//운석높이 || pos.y >= frame.game_panel.getSize().getHeight() -(30)
				System.out.println("충돌발생!!");
				score =  Ex2_Frame.METEORSCORE;
				
				if(flag) {
					frame.count ++;
					frame.scoreM = frame. scoreM + Ex2_Frame.METEORSCORE;
					
					System.out.println("점수 : "+frame.scoreM);
				
					if(frame.count == 5) {
						JOptionPane.showMessageDialog(frame, "is Dead");
					}
					break;
				}
			
			}
			
				
			
		}
		
		/* ArrayList - 삭제 작업 */
		frame.list.remove(this);
		
		// 폭발 객체 생성
		Exploslon func = new Exploslon();
		
		func.pt.x = (int)pos.getCenterX() - func.size/2;
		func.pt.y = (int)pos.getCenterY() - func.size/2;
		
		frame.exploslon_List.add(func);
		
	}
}

class UniqueMeteor extends Thread{
	
	Rectangle pos = new Rectangle();
	
	int speed = 5;
	int score;
	
	
	boolean flag = true;
	
	Ex2_Frame frame; // 운석객체가 생성된 후 패널에 다시 그린다.
//						y좌표를 확인하여 객체를 ArrayList에 담고 삭제한다	

	public UniqueMeteor(Ex2_Frame frame , int w , int h) {
		this.frame = frame;
		this.pos.width = w;
		this.pos.height = h;
	}
	
	@Override
	public void run() {
		
		while(true) {
			pos.y+=speed;
			
			try {
				sleep(10);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			frame.game_panel.repaint();
			
			
			// 사용자 이미지와 현재 운석이 충돌했거나
			// 운석이 바닥에 도달했다면 탈출하기
			if(frame.me.pos.intersects(pos)	) {					//운석높이 || pos.y >= frame.game_panel.getSize().getHeight() -(30)
	
				score =  Ex2_Frame.METEORSCORE;
				
				if(flag) {
					frame.count ++;
					frame.scoreM = frame. scoreM + Ex2_Frame.METEORSCORE;
					
					System.out.println("점수 : "+frame.scoreM);
				
					if(frame.count == 5) {
						JOptionPane.showMessageDialog(frame, "is Dead");
					}
					break;
				}
			
			}
			
				
			
		}
		
		/* ArrayList - 삭제 작업 */
		frame.list.remove(this);
		
		frame.u_list.remove(this);
		
		// 폭발 객체 생성
		Exploslon func = new Exploslon();
		
		func.pt.x = (int)pos.getCenterX() - func.size/2;
		func.pt.y = (int)pos.getCenterY() - func.size/2;
		
		frame.exploslon_List.add(func);
		
	}
}





class Exploslon{
	int size = 128;
	Point pt = new Point();
	
	// 배열에 접근하는 index값
	int index;
	// 반복문이 gap 만큼 돌아갈때 index를 증가시킨다
	int gap =5;
	
	// gap
	int interval = gap;
	
	public boolean move_index() {
		if(interval == gap) {
			index ++;
		}
		interval --;
		
		if(interval == 0)
			interval = gap;
		
		return index >= 27;
	}
}
