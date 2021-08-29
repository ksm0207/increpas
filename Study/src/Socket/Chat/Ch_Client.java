package Socket.Chat;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ch_Client extends JFrame {

	private JPanel contentPane;

	
	Socket s;
	ObjectOutputStream out;
	ObjectInputStream in;
	
	Thread t = new Thread() {

		@Override
		public void run() {
			bk:while(true) {
				try {
					Object obj = in.readObject();
					if(obj != null) {
						Protocol p = (Protocol) obj;
						
						switch(p.getCmd()){
							case 0:// 종료
								break bk;
							case 2:// 채팅 메세지
								ta.append(p.getMsg()+"\r\n");
								ta.setCaretPosition(
									ta.getText().length());
								break;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}//무한반복의 끝
			
			closed();
		}
		
	};
	private JTextField nickName_tf;
	private JButton join_bt;
	private JPanel card1;
	private JPanel card2;
	private JTextField input_tf;
	private JButton send_bt;
	private JTextArea ta;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ch_Client frame = new Ch_Client();
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
	public Ch_Client() {
		
		setBounds(100, 100, 379, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		card1 = new JPanel();
		contentPane.add(card1, "login");
		card1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		card1.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("대화명 :");
		panel_2.add(lblNewLabel);
		
		nickName_tf = new JTextField();
		panel_2.add(nickName_tf);
		nickName_tf.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_1.add(panel_3);
		
		join_bt = new JButton(" 입장하기 ");
		panel_3.add(join_bt);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		card1.add(lblNewLabel_1, BorderLayout.CENTER);
		
		card2 = new JPanel();
		contentPane.add(card2, "chat");
		card2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		card2.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		input_tf = new JTextField();
		panel.add(input_tf, BorderLayout.CENTER);
		input_tf.setColumns(10);
		
		send_bt = new JButton("보내기");
		panel.add(send_bt, BorderLayout.EAST);
		
		JScrollPane scrollPane = new JScrollPane();
		card2.add(scrollPane, BorderLayout.CENTER);
		
		ta = new JTextArea();
		ta.setEditable(false);
		scrollPane.setViewportView(ta);
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				if(s != null) { // 서버에 접속된 상태
					Protocol p = new Protocol();
					p.setCmd(0);
					try {
						out.writeObject(p);//서버로 보내기
					} catch (Exception e2) {
						
					}
				}else
					closed();	
			}
		});
		
		join_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 사용자가 입력한 대화명을 가져온다.
				String name = nickName_tf.getText().trim();
				if(name.length() > 0) {
					//화면 바꾸기
					CardLayout cl = 
						(CardLayout) contentPane.getLayout();
					cl.show(contentPane, "chat");
					
					if(connected()){//서버접속
						//대화명 보내기
						Protocol p = new Protocol();
						p.setCmd(1);
						p.setMsg(name);
						setTitle(p.toString());
					
						try {
							out.writeObject(p);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					
				} else {
					JOptionPane.showMessageDialog(
						Ch_Client.this, "대화명을 입력하세요");
					nickName_tf.setText("");
					nickName_tf.requestFocus();//커서 가져다 놓기
				}
				
			}
		});
		
		input_tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
	//			sendMessage();
			}
		});
		send_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				sendMessage();
			}
		});
	}
	
	private void sendMessage() {
		try {
			String msg = input_tf.getText().trim();
			if(msg.length() > 0) {
				//사용자가 입력 메세지를 서버로 보낸다.
				Protocol p = new Protocol();
				p.setCmd(2);
				p.setMsg(msg);
				
				out.writeObject(p);//서버로 보낸다.
			}
			input_tf.setText("");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private boolean connected() {
		boolean value = true;
		
		try {
			s = new Socket("192.168.0.17", 3000);
			out = new ObjectOutputStream(s.getOutputStream());
			in = new ObjectInputStream(s.getInputStream());
			t.start();
		} catch (Exception e) {
			e.printStackTrace();
			value = false;//문제가 발생했다면 value값을 false로 변경!!
		}
		
		return value;
	}
	
	private void closed() {
		try {
			if(out != null)
				out.close();
			if(in != null)
				in.close();
			if(s != null)
				s.close();
			
			System.exit(0);//프로그램 종료!
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}