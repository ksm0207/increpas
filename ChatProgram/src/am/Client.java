package am;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import javax.swing.ScrollPaneConstants;

public class Client extends JFrame {

	/*통신관련객체*/
	Socket socket;
	ObjectOutputStream obj_out;
	ObjectInputStream obj_in;

	
	private final static int PORT = 3000;
	private final static String SERVERIP = "192.168.0.17";
	
	private JPanel contentPane;
	private JButton exit_bt;
	private JButton create_Room;
	private JButton join_bt;
	private JButton out_bt;
	private JList user_list;
	private JList room_list;
	private JPanel wait_p;
	private JPanel login_p;
	private JTextField name_tf;
	private JButton login_bt;
	private JTextArea area;
	private JButton send_btn;
	
	private JList join_list;
	private JPanel chat_panel;
	private JTextField send_text;
	
	SimpleDateFormat simpleDate;
	Date date;
	
	
	ArrayList<Protocol> pro_list = new ArrayList<Protocol>();
	Protocol proto;
	
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
					proto = (Protocol) obj;	
				
					switch(proto.getStatus()) {
						case 0: //종료
							break bk;
						case 1:
							area.append(proto.getUserMessage()+"\r\n");
							area.setCaretPosition(area.getText().length());
							break;
						case 2: //접속 및 갱신
							System.out.println("Client Switch : Case 2");
							//대기자 명단 갱신							
							user_list.setListData(proto.getUsers());
							//방 목록 갱신
							room_list.setListData(proto.getRooms());
							break;				
							
						case 4:
							System.out.println("Case 4");
							join_list.setListData(proto.getUsers());
							area.append(proto.getUserMessage()+"\r\n");
							area.setCaretPosition(
								area.getText().length());
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
		
		join_bt = new JButton("방 참여");
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
		
		chat_panel = new JPanel();
		contentPane.add(chat_panel, "join");
		chat_panel.setLayout(new BorderLayout(0, 0));
		chat_panel.setPreferredSize(new Dimension(110,300));
		
		JPanel join_panel = new JPanel();
		chat_panel.add(join_panel, BorderLayout.EAST);
		join_panel.setLayout(new BorderLayout(0, 0));
		
		join_panel.setPreferredSize(new Dimension(110, 250));
		
		
		JLabel join_label = new JLabel("참여자");
		join_panel.add(join_label, BorderLayout.NORTH);
		
		JPanel panel_21 = new JPanel();
		join_panel.add(panel_21, BorderLayout.SOUTH);
		panel_21.setLayout(new GridLayout(1, 1, 0, 0));
		
		out_bt = new JButton("나가기");
		panel_21.add(out_bt);
		
		JScrollPane scrollPane1 = new JScrollPane();
		join_panel.add(scrollPane1, BorderLayout.CENTER);
		
		join_list = new JList();
		scrollPane1.setViewportView(join_list);
		
		JScrollPane scrollPane_11 = new JScrollPane();
		chat_panel.add(scrollPane_11, BorderLayout.CENTER);
		
		area = new JTextArea();
		area.setLineWrap(true);
		area.setFont(new Font("Monospaced", Font.PLAIN, 15));
		area.setRows(23);
		scrollPane_11.setViewportView(area);
		
		JPanel panel1 = new JPanel();
		chat_panel.add(panel1, BorderLayout.SOUTH);
		panel1.setLayout(new BorderLayout(0, 0));
		
		send_text = new JTextField();
		panel1.add(send_text, BorderLayout.CENTER);
		send_text.setColumns(10);
		
		send_btn = new JButton("전송");
		panel1.add(send_btn, BorderLayout.EAST);
		
		
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
				System.out.println("Login Button");
				try {
					
					if (chkName.length() > 0) {
						cl.show(contentPane, "wait_room");
						if(checkAccept()) {
							try {
								setTitle(getTimeZone());
								StringBuffer sb = new StringBuffer();		
								proto = new Protocol();
								proto.setStatus(2);	
								sb.append(chkName);	
								
								proto.setUserMessage(sb.toString());
								obj_out.writeObject(proto);
							} catch (Exception e2) {
								// TODO: handle exception
							}
						}	
					}else {
						JOptionPane.showMessageDialog(Client.this, "아이디에 공백이 포함되었습니다 다시 입력해주세요.");
						name_tf.requestFocus();
						name_tf.setText("");
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
				setTitle(roomTitle);
				if(roomTitle != null && ! roomTitle.trim().isEmpty()) {
					System.out.println("Create Room");
					try {
						proto = new Protocol();
						proto.setStatus(3);
						proto.setUserMessage(roomTitle);
						
						obj_out.writeObject(proto);
						cl.show(contentPane, "join");
						
						
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
				}
			}
		});
		
		join_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				/* room_list에서 선택한 방 정보에 참여하기. */
				
				int select_room = room_list.getSelectedIndex();
				
				System.out.println(select_room);
				setTitle("Room Name : "+select_room);
				
				if (select_room < 0) {
					JOptionPane.showMessageDialog(Client.this, "방을 선택하세요 !");
				}else {
					
					joinRoom();
				}
				
				
			}
		});
		
		room_list.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int click_count = e.getClickCount();
				
				if(click_count == 2)
					joinRoom();
				
			}
		});
		
		out_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("방 나가기 버튼");
				
				area.setText(""); // --> 방 나가기를 했을때 채팅한 내용을 모두 청소하기.
				
				proto = new Protocol();
				proto.setStatus(5);
				
				try {
					obj_out.writeObject(proto);
					obj_out.flush();
					cl.show(contentPane, "wait_room");
				} catch (Exception e2) {
					// TODO: handle exception
				}
	
			}
		});
		
		send_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("메세지 버튼");
				
				sendMessage();
				
			}
		});
		
		send_text.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
				
			}
		});
	
		
	}
	
	private boolean checkAccept() {
		boolean flag = true;
		try {
			socket = new Socket(Client.SERVERIP , Client.PORT);
			obj_out = new ObjectOutputStream(socket.getOutputStream());
			obj_in = new ObjectInputStream(socket.getInputStream());
			thread.start();
		} catch (Exception e) {
			e.printStackTrace();
			return flag = false;
		}
		return flag;
		
	}
	private void sendMessage() {
		
		String text = send_text.getText().trim();
		proto = new Protocol();
		proto.setStatus(1);
		proto.setUserMessage(text);
		
		try {
			obj_out.writeObject(proto);
		} catch (Exception e2) {
			// TODO: handle exception
		}
		send_text.setText("");
	}
	
	private void joinRoom() {
	      /* 사용자가 room_list에서 선택한 Index 값을 가져와서 참여하기 */
	      int room_index = room_list.getSelectedIndex();
	      
	      /* room_index로 부터 N번째 있는 방 정보를 얻어내기. */
	      /* 그 후 서버로 프로토콜을 만들어서 보내기 */
	      proto = new Protocol();
	      proto.setStatus(4);
	      proto.setRoom_index(room_index);
 
	      try {
			obj_out.writeObject(proto);
			cl.show(contentPane, "join");
		} catch (Exception e) {
			// TODO: handle exception
		}
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
