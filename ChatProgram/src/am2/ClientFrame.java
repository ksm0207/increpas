package am2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class ClientFrame extends JFrame {

	private JPanel contentPane;

	
	Socket s;
	ObjectOutputStream out;
	ObjectInputStream in;
	
	private JButton exit_bt;
	private JButton mkRoom_bt;
	private JList user_list;
	private JList room_list;
	private JPanel wait_p;
	private JPanel login_p;
	private JTextField name_tf;
	private JButton login_bt;
	
	CardLayout cl;
	
	Thread t = new Thread() {

		@Override
		public void run() {
			// 언제 서버로부터 자원이 도착할지 모르기 때문에
			// 현재 스레드로부터 계속~~~ in.readObject()해야 한다.
			bk:while(true) {
				try {
					//서버로부터 자원을 받을 때까지 대기한다.
					Object obj = in.readObject();
					
					Protocol2 p = (Protocol2) obj;
					
					switch(p.getCmd()) {
						case 0: //종료
							break bk;
							
						case 2: //접속 및 갱신
							//대기자 명단 갱신
							user_list.setListData(p.getNames());
							
							//방 목록 갱신
							room_list.setListData(p.getRooms());
							break;
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			closed();//스트림과 소켓 닫기
			System.exit(0);//프로그램 종료!
		}
		
	};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientFrame frame = new ClientFrame();
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
	public ClientFrame() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(cl = new CardLayout(0, 0));
		
		wait_p = new JPanel();
		contentPane.add(wait_p, "wait_room");
		wait_p.setLayout(new BorderLayout(0, 0));
		
		JPanel east_p = new JPanel();
		wait_p.add(east_p, BorderLayout.EAST);
		east_p.setLayout(new BorderLayout(0, 0));
		
		east_p.setPreferredSize(new Dimension(90, 300));
		
		
		JLabel lblNewLabel = new JLabel("[대기실]");
		east_p.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		east_p.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(3, 1, 0, 0));
		
		JButton join_bt = new JButton("방 참여");
		panel_2.add(join_bt);
		
		mkRoom_bt = new JButton("방만들기");
		panel_2.add(mkRoom_bt);
		
		exit_bt = new JButton("종료");
		panel_2.add(exit_bt);
		
		JScrollPane scrollPane = new JScrollPane();
		east_p.add(scrollPane, BorderLayout.CENTER);
		
		user_list = new JList();
		scrollPane.setViewportView(user_list);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		wait_p.add(scrollPane_1, BorderLayout.CENTER);
		
		room_list = new JList();
		scrollPane_1.setViewportView(room_list);
		
		login_p = new JPanel();
		contentPane.add(login_p, "login");
		login_p.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		login_p.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("대화명 :");
		panel_1.add(lblNewLabel_1);
		
		name_tf = new JTextField();
		panel_1.add(name_tf);
		name_tf.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel.add(panel_3);
		
		login_bt = new JButton("입장하기");
		panel_3.add(login_bt);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(ClientFrame.class.getResource("/images/main.PNG")));
		login_p.add(lblNewLabel_2, BorderLayout.CENTER);
		
		cl.show(contentPane, "login");// contentPane에 등록된
		//카드들 중 이름이 "login"인 카드를 보여준다.
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// 종료를 의미하는 프로토콜 생성
				Protocol2 p = new Protocol2();
				p.setCmd(0);
				try {
					//준비된 프로토콜을 서버로 보낸다
					out.writeObject(p);
					out.flush();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		
		login_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 사용자가 입력한 대화명을 가져온다.
				String name = name_tf.getText().trim();
				
				if(name.length() > 0) {
					// 서버 접속
					if(connected()) {
						try {
							//접속했으니.. 대화명을 보낸다.
							Protocol2 p = new Protocol2();
							p.setCmd(2);// 접속 및 갱신
							p.setMsg(name);//대화명 저장
							out.writeObject(p);//서버에 있는 
								//나의 분신(CopyClient)에게 보낸다.
						} catch (Exception e2) {
							// TODO: handle exception
						}
						
						//화면을 wait_room으로 전환
						cl.show(contentPane, "wait_room");
					}
				}else {
					JOptionPane.showMessageDialog(
							ClientFrame.this, "대화명을 입력하세요");
					name_tf.setText("");
					name_tf.requestFocus();
				}
			}
		});
		
		mkRoom_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 방 만들기 버튼을 클릭했을 때
				// 사용자로 하여금 방 제목을 입력 받는다.
				String rname = JOptionPane.showInputDialog(
					ClientFrame.this, "방 제목을 입력하세요");
				
				if(rname != null && rname.trim().length() > 0) {
					//방 제목을 입력한 후 확인버튼을 눌렀을 때
					
					//방 만들기 cmd가 3을 가지는 프로토콜 생성
					Protocol2 p = new Protocol2();
					p.setCmd(3);
					p.setMsg(rname.trim());
					
					try {
						out.writeObject(p);
						out.flush();
						
						//채팅화면으로 전환!
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				
			}
		});
	}

	private boolean connected() {
		boolean value=true;
		try {
			//서버 접속!!!!!!!!!!
			s = new Socket("192.168.0.17", 3030);
			out = new ObjectOutputStream(s.getOutputStream());
			in = new ObjectInputStream(s.getInputStream());
			//현재 in을 항상 readObject하는 스레드를 구동시켜야 한다.
			t.start();
			setTitle("접속완료");
		} catch (Exception e) {
			e.printStackTrace();
			value = false;
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
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}





