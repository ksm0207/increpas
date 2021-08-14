package frame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame{
	
	JPanel game_panel;
	Rectangle pos = new Rectangle();
	Dimension d = new Dimension(671,600);
	
	Image bg , user, default_meteor,unique_meteor;
	

	public GameFrame() {
		
		images();
		initPanel();
		initUserPos();
		initWindow();
		
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				
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
		this.setResizable(false);
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
			}
			
		};
		
		game_panel.setPreferredSize(d);
		this.add(game_panel);
	}
	
	
	public static void main(String[] args) {
		new GameFrame();
		
	}
	
	
}
