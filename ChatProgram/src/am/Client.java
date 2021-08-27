package am;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Client extends JFrame {

	/*통신관련객체*/
	Socket socket;
	ObjectOutputStream obj_out;
	ObjectInputStream obj_in;

	
	private final static int PORT = 3030;
	private final static String SERVERIP = "192.168.0.17";
	
	private JPanel contentPane;
	private JButton exit_bt;
	private JButton create_Room;
	private JList user_list;
	private JList room_list;
	private JPanel wait_p;
	private JPanel login_p;
	private JTextField name_tf;
	private JButton login_bt;
	
	private JList join_list;
	private JPanel area_panel;
	private JTextField send_text;
	
	SimpleDateFormat simpleDate;
	Date date;
	
	CardLayout cl;
	
	
	Thread thread = new Thread() {

		@Override
		public void run() {
			// 언제 서버로부터 자원이 도착할지 모르기 때문에
			// 현재 스레드로부터 계속~~~ in.readObject()해야 한다.
			bk:while(true) {
				try {
					//서버로부터 자원을 받을 때까지 대기한다.
					Object obj = obj_in.readObject();
					
					Protocol p = (Protocol) obj;
					
					switch(p.getStatus()) {
						case 0: //종료
							break bk;
							
						case 2: //접속 및 갱신
							//대기자 명단 갱신
							user_list.setListData(p.getUsers());
							
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

		private void closed() {
			try {
				if(obj_out != null)
					obj_out.close();
				if(obj_in != null)
					obj_in.close();
				if(socket != null)
					socket.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
	};
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
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
	public Client() {
		
		setBounds(100, 100, 535, 565);
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
		
		east_p.setPreferredSize(new Dimension(250, 300));
		
		
		JLabel lblNewLabel = new JLabel("[대기실]");
		east_p.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		east_p.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(3, 1, 0, 0));
		
		JButton join_bt = new JButton("방 참여");
		panel_2.add(join_bt);
		
		create_Room = new JButton("방만들기");
		panel_2.add(create_Room);
		
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
		lblNewLabel_2.setIcon(new ImageIcon(Client.class.getResource("/images/main.png")));
		login_p.add(lblNewLabel_2, BorderLayout.CENTER);
		
		/*================================================================================*/
		
		area_panel = new JPanel();
		contentPane.add(area_panel,"join");
		area_panel.setLayout(new BorderLayout(0, 0));
		area_panel.setPreferredSize(new Dimension(110,300));
		
		JPanel join_panel = new JPanel();
		area_panel.add(join_panel, BorderLayout.EAST);
		join_panel.setLayout(new BorderLayout(0, 0));
		
		join_panel.setPreferredSize(new Dimension(110, 250));
		
		
		JLabel join_label = new JLabel("참여자");
		join_panel.add(join_label, BorderLayout.NORTH);
		
		JPanel panel_21 = new JPanel();
		join_panel.add(panel_21, BorderLayout.SOUTH);
		panel_21.setLayout(new GridLayout(1, 1, 0, 0));
		
		JButton exit_room = new JButton("나가기");
		panel_21.add(exit_room);
		
		JScrollPane scrollPane1 = new JScrollPane();
		join_panel.add(scrollPane1, BorderLayout.CENTER);
		
		join_list = new JList();
		scrollPane1.setViewportView(join_list);
		
		JScrollPane scrollPane_11 = new JScrollPane();
		area_panel.add(scrollPane_11, BorderLayout.CENTER);
		
		JTextArea area = new JTextArea();
		area.setFont(new Font("Monospaced", Font.PLAIN, 15));
		area.setRows(23);
		scrollPane_11.setViewportView(area);
		
		send_text = new JTextField();
		area_panel.add(send_text, BorderLayout.SOUTH);
		send_text.setColumns(10);
		
		JPanel panel1 = new JPanel();
		area_panel.add(panel1, BorderLayout.NORTH);
		panel1.setLayout(new BorderLayout(0, 0));
		
		
		cl.show(contentPane, "login");// contentPane에 등록된
		//카드들 중 이름이 "login"인 카드를 보여준다.
		
		
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				Protocol p = new Protocol();
				p.setStatus(0);
				
				try {
					obj_out.writeObject(p);
					obj_out.flush();
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}			
		}); // end of winWowAdapter()
		
		login_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				/* 서버접속 */
				String chkName = name_tf.getText();
				try {
					socket = new Socket(Client.SERVERIP, Client.PORT);
					
					if (socket.isConnected()) {
						
						obj_out = new ObjectOutputStream(socket.getOutputStream());
						obj_in = new ObjectInputStream(socket.getInputStream());
						thread.start();
						System.out.println("클라이언트 접속 On");
						
						if (chkName.isEmpty() || chkName.contains(" ")) {
							JOptionPane.showMessageDialog(Client.this, "아이디에 공백이 포함되었습니다 다시 입력해주세요.");
							name_tf.setText("");
							name_tf.requestFocus();
						}else {
							setTitle(getTimeZone());
							StringBuffer sb = new StringBuffer();
							
							Protocol protocol = new Protocol();
							protocol.setStatus(2);
							
							sb.append(chkName);
							sb.append(loginDate());
							
							protocol.setUserMessage(sb.toString());
							obj_out.writeObject(protocol);
							cl.show(contentPane, "wait_room");
						}
					
					}
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		
		create_Room.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				String roomTitle = JOptionPane.showInputDialog(Client.this," 방 제목을 입력하세요.");
				
				if(roomTitle != null && ! roomTitle.trim().isEmpty()) {
					
					StringBuffer sb = new StringBuffer();
					sb.append(roomTitle);
					sb.append(" - ");
					sb.append("Host : ");
					sb.append(name_tf.getText());
					
					
					System.out.println("Create Room");
					
					cl.show(contentPane, "join");
					Protocol protocol = new Protocol();
					
					if (isCheck()) {
						protocol.setStatus(3);
						protocol.setUserMessage(sb.toString());
						
						try {
							obj_out.writeObject(protocol);
							obj_out.flush();
							
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}else {
						System.out.println("Error");
					}	
				}
			}
		});
	
		room_list.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				int click = e.getClickCount();
				
				if (click == 2) {
					cl.show(contentPane, "join");
				}
				
				System.out.println("Room Click");
				
			}
		});
	}
	
	private boolean isCheck() {
		boolean flag = true;
		try {
			socket = new Socket("192.168.0.17", 3000);
			obj_out = new ObjectOutputStream(socket.getOutputStream());
			obj_in = new ObjectInputStream(socket.getInputStream());
			thread.start();
			
		} catch (Exception e) {
			return flag = false;
		}
		return flag;
		
		
	}
	
	private String getTimeZone() {
		simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		date = new Date();
		
		String cur = simpleDate.format(date);
		
		return cur;
	}
	
	private String loginDate() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("   ");
		sb.append("로그인 날짜 : ");
		sb.append(getTimeZone());
		sb.append("\n");
		
		
		return sb.toString();
	}
	
}
