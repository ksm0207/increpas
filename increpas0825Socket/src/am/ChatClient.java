package am;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChatClient extends JFrame {

	private JPanel contentPane;
	private JTextField input_tf;
	private JButton send_bt;
	private JTextArea ta;
	
	//서버 통신을 위한 객체들
	Socket s;
	BufferedReader in;
	PrintWriter out;
	
	Thread t = new Thread() {

		@Override
		public void run() {
			// readLine을 체크!
			while(true) {
				try {
					String msg = in.readLine();// 서버쪽에서 메세지가
						//올 때까지 대기한다.
					
					// 받은 메세지가 종료메세지인지? 아닌지? 판단!
					if(msg.equals("Xx:X~"))
						break;// 무한반복 탈출
					else
						ta.append(msg+"\r\n");// 일반메세지
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			//종료메세지를 받은 경우
			closed();
		}
		
	};
	
	//서버 접속 - 생성자에서 호출함!
	private void connected() {
		try {
			s = new Socket("192.168.0.17", 3000);
			out = new PrintWriter(s.getOutputStream(), true);
			in = new BufferedReader(
				new InputStreamReader(s.getInputStream()));
			t.start();// *************
			setTitle("서버 접속완료!");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void closed() {
		try {
			if(out != null)
				out.close();
			if(in != null)
				in.close();
			if(s != null)
				s.close();
			System.out.println("프로그램 종료");
			System.exit(0);//프로그램 종료!!!!!!!
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatClient frame = new ChatClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChatClient() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		input_tf = new JTextField();
		panel.add(input_tf, BorderLayout.CENTER);
		input_tf.setColumns(10);
		
		send_bt = new JButton("보내기");
		panel.add(send_bt, BorderLayout.EAST);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		ta = new JTextArea();
		ta.setEditable(false);
		scrollPane.setViewportView(ta);
		
		connected();
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				//종료메세지를 서버로 보낸다.
				out.println("Xx:X~");
				//이 종료메세지가 결국 서버를 거쳐서 다시 현 객체가 가지는
				// 스레드쪽으로 돌아와서 무한반복을 탈출한 후 closed()메서드가
				// 호출되면서 종료를 하게 된다.
			}
		});
		
		input_tf.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
			}
		});
		
		send_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
						
			}
		});
		
		
	}

}
