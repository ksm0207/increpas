package pm;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class Ex6_Frame extends JFrame{
	
	JProgressBar redBar , greenBar , blueBar;
	
	boolean red = true;
	boolean green = true;
	boolean blue = true;
	int add;
	KeyAdapter adap;
	
	Thread red_thread , green_thread, blue_thread;
	
	public Ex6_Frame() {
		
		this.setLayout(new GridLayout(3,1));
		
		initProgressBar();
		getThread();
		startThread();
		
		adap = new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyChar());
				switch (e.getKeyChar()) {
				case 'r':
					System.out.println("r 키 입력 감지");
					if(red) {
						red_thread.suspend();
					}else {
						red_thread.resume();
					}
					red = !red;
					break;
				case 'g':
					System.out.println("g 키 입력 감지");
					if(green) {
						green_thread.suspend();
					}else {
						green_thread.resume();
					}
					green = !green;
					break;
				case 'b':
					System.out.println("b 키 입력 감지");
					
					if(blue) {
						blue_thread.suspend();
					}else {
						blue_thread.resume();
					}
					blue = !blue;
					break;	
				}
			};
		};
		this.setBounds(300,200,300,150);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.addKeyListener(adap);
		
	}
	
	public void initProgressBar() {
		this.add(redBar = new JProgressBar(0,100));
		redBar.setForeground(Color.RED);
		redBar.setValue(10);
		redBar.setLayout(new FlowLayout());
		
		this.add(greenBar = new JProgressBar(0,100));
		greenBar.setForeground(Color.GREEN);
		greenBar.setValue(17);
		
		
		this.add(blueBar = new JProgressBar(0,100));
		blueBar.setForeground(Color.BLUE);
		blueBar.setValue(15);
	}
	
	public void getThread() {
		red_thread = new Thread() {
			@Override
			public void run() {
				
				while(true) {
					add = redBar.getValue();
					add++;
					
					if(add > 100) {
						add = 0;
					}
					redBar.setValue(add);
					try {
						sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		green_thread = new Thread() {
			@Override
			public void run() {
				
				while(true) {
					add = greenBar.getValue();
					add++;
					
					if(add > 100) {
						add = 0;
					}
					greenBar.setValue(add);
					try {
						sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		blue_thread = new Thread() {
			@Override
			public void run() {
				
				while(true) {
					add = blueBar.getValue();
					add++;
					
					if(add > 100) {
						add = 0;
					}
					blueBar.setValue(add);
					try {
						sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
	}
	
	public void startThread() {
		red_thread.start();
		green_thread.start();
		blue_thread.start();
	}
	
	
	public static void main(String[] args) {
		new Ex6_Frame();
	}
}
