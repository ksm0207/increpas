package am;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Client extends JFrame {

	/*통신관련객체*/
	Socket socket;
	ObjectOutputStream obj_out;
	ObjectInputStream obt_in;
	Thread thread;
	
	
	private JPanel contentPane;
	private JPanel wait_panel;
	private JPanel east_panel;
	private	JPanel login_panel;
	private JLabel label;
	private JPanel panel_2;
	private JButton exit_btn;
	private JScrollPane scrollPane;
	private JList user_list;
	private JScrollPane scrollPane_1;
	private JList room_list;
	private JButton join_btn;
	private JButton create_btn;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_3;
	private JLabel lblNewLabel;
	private JButton login_btn;
	private JLabel lblNewLabel_1;
	private JTextField name_text;
	
	CardLayout c1;
	

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
		setBounds(100, 100, 594, 604);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		wait_panel = new JPanel();
		contentPane.add(wait_panel, "wait_room");
		wait_panel.setLayout(new BorderLayout(0, 0));
		
		east_panel = new JPanel();
		wait_panel.add(east_panel, BorderLayout.EAST);
		east_panel.setLayout(new BorderLayout(0, 0));
		east_panel.setPreferredSize(new Dimension(110, 300));
		
		label = new JLabel("대기실");
		east_panel.add(label, BorderLayout.NORTH);
		
		panel_2 = new JPanel();
		east_panel.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(3, 1, 0, 0));
		
		join_btn = new JButton("방 참여하기");
		panel_2.add(join_btn);
		
		create_btn = new JButton("방 만들기");
		panel_2.add(create_btn);
		
		exit_btn = new JButton("나가기");
		panel_2.add(exit_btn);
		
		scrollPane = new JScrollPane();
		east_panel.add(scrollPane, BorderLayout.CENTER);
		
		user_list = new JList();
		scrollPane.setViewportView(user_list);
		
		scrollPane_1 = new JScrollPane();
		wait_panel.add(scrollPane_1, BorderLayout.WEST);
		
		room_list = new JList();
		wait_panel.add(room_list, BorderLayout.CENTER);
		
		login_panel = new JPanel();
		contentPane.add(login_panel,"login");
		login_panel.setLayout(new CardLayout(0, 0));
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		login_panel.add(panel_1, "login");
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_1.add(panel_3, BorderLayout.SOUTH);
		
		lblNewLabel_1 = new JLabel("이름 :");
		panel_3.add(lblNewLabel_1);
		
		name_text = new JTextField();
		panel_3.add(name_text);
		name_text.setColumns(10);
		
		login_btn = new JButton("Login");
		panel_3.add(login_btn);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Client.class.getResource("/Images/main.png")));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel, BorderLayout.CENTER);
		
		
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
		});
	}

}
