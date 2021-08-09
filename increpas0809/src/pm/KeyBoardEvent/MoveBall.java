package pm.KeyBoardEvent;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import am.MyWinAdap;

public class MoveBall extends JFrame{
	
	BallCanvas canvas;
	
	public MoveBall() {
		
		canvas = new BallCanvas();
		
		this.setBounds(300,250,600,550);
		this.setVisible(true);
		this.setTitle("Ball Move");
		
		this.add(canvas);
		this.addWindowListener(new MyWinAdap());
		this.addKeyListener(new GetKeyAdapter(this));
	
	}
	
	
	public static void main(String[] args) {
		
		
		new MoveBall();
	}
}

class BallCanvas extends Canvas{
	
	Image ballImages;
	
	int x , y;
	
	public BallCanvas() {
		
		/* 이미지를 만들기 위해 필요한 객체 생성하기 */
		Toolkit tool = Toolkit.getDefaultToolkit();
		ballImages = tool.getImage("src/images/ball.png");
		
		/* 창의 너비 저장*/
		x = 120;
		y = 120;
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(ballImages,x,y,this);
	}
}

class GetKeyAdapter extends KeyAdapter{
	
	MoveBall ball ;
	
	public GetKeyAdapter(MoveBall ball) {
		this.ball = ball;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Ball canvas getWidth () : "+ball.canvas.getWidth());
		System.out.println("Ball canvas x : "+ball.canvas.x);
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT :
			ball.canvas.x -=3;
			if(ball.canvas.x <= 0) {
				ball.canvas.x = 0;
			}
			break;
		case KeyEvent.VK_RIGHT:
			ball.canvas.x +=3;
			
			if (ball.canvas.x >= (ball.canvas.getWidth() - ball.canvas.ballImages.getWidth(ball))) {
				ball.canvas.x = ball.canvas.getWidth() - ball.canvas.ballImages.getWidth(ball);
			}
			break;
			
		}
		ball.canvas.repaint();
		System.out.println("Ball canvas getWidth ()  - ball canvas Image.getWidth " + (ball.canvas.getWidth() - ball.canvas.ballImages.getWidth(ball)));
		System.out.println(e.getKeyChar()+":"+e.getKeyCode());
	}
	
}