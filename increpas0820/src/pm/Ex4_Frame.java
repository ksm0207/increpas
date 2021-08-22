package pm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Ex4_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField post_num;
	private JButton search_bt;
	private JTextField addr_tf;
	private JList<String> c_list;
	
	File f;
	BufferedReader br;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex4_Frame frame = new Ex4_Frame();
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
	public Ex4_Frame() {
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 627);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		post_num = new JTextField();
		panel.add(post_num);
		post_num.setColumns(6);
		
		JLabel lblNewLabel = new JLabel("     ");
		panel.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"강원도", "경기도", "경상남도", "경상북도", "서울특별시"}));
		panel.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("도로명 : ");
		panel.add(lblNewLabel_1);
		
		addr_tf = new JTextField();
		panel.add(addr_tf);
		addr_tf.setColumns(10);
		
		search_bt = new JButton("검색");
		panel.add(search_bt);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		c_list = new JList<String>();
		scrollPane.setViewportView(c_list);
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				
				
				System.exit(0);//프로그램 종료
			}
		});
		
		search_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				searchAddr();
			}
		});
		addr_tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				searchAddr();
			}
		});
		
		c_list.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				// JList에서 마우스를 클릭했을 때
				// JList에서 선택된 문자열을 얻어낸다.
				String item = c_list.getSelectedValue();//"06041:도산대로28길"
				
				String[] ar = item.split(":");
				post_num.setText(ar[0]);
			}
		});
		
	}

	private void searchAddr() {
		//사용자가 입력한 도로명 가져오기
		String addr = addr_tf.getText().trim();
		
		if(addr.length() <= 0) {
			JOptionPane.showMessageDialog(Ex4_Frame.this, "도로명을 입력하세요");
			addr_tf.setText("");//청소!!
			addr_tf.requestFocus();// 커저 가져다 놓기
			return;// 호출한 곳으로 돌아간다.
		}
		
		try {
			f = new File("C:/Users/user/Desktop/0820/서울특별시.txt");
			br = new BufferedReader(new FileReader(f));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ArrayList<String> list = new ArrayList<String>();
		String str = null;
		try {
			
			while((str = br.readLine()) != null) {
				StringBuffer sb = new StringBuffer();
				
				// |를 중심으로 잘라내기
				String[] ar = str.split("\\|");
				if(ar[8].contains(addr)) {
					sb.append(ar[0]);
					sb.append(":");
					sb.append(ar[8]);
					
					list.add(sb.toString());
				}
			}
			
			// 사용자가 입력한 도로명이 포함된 모든 주소의 우편번호들이
			// ArrayList에 저장된 상태다.
			String[] addr_ar = new String[list.size()];
			
			//ArrayList에 있는 모든 것들을 addr_ar에 복사해 넣자!
			list.toArray(addr_ar);
			
			//가운데에 있는 JList에 데이터목록으로 addr_ar을 지정해 준다.
			c_list.setListData(addr_ar);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}






