package pm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class Ex4_Frame extends JFrame {

	private JPanel contentPane;
	private JTextArea ta;
	private JMenuItem new_item;
	private JMenuItem open_item;
	private JMenuItem save_item;
	private JMenuItem saveAs_item;
	private JMenuItem exit_item;
	
	File selected_file;
	FileInputStream fis;
	FileOutputStream fos;
	
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
		setBounds(100, 100, 890, 709);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu file_m = new JMenu("파일");
		menuBar.add(file_m);
		
		new_item = new JMenuItem("새파일");
		file_m.add(new_item);
		
		open_item = new JMenuItem("열기");
		file_m.add(open_item);
		
		save_item = new JMenuItem("저장...");
		file_m.add(save_item);
		
		saveAs_item = new JMenuItem("새이름으로 저장...");
		file_m.add(saveAs_item);
		
		JSeparator separator = new JSeparator();
		file_m.add(separator);
		
		exit_item = new JMenuItem("종료");
		file_m.add(exit_item);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		ta = new JTextArea();
		scrollPane.setViewportView(ta);
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				closed();
			}
		});
		
		exit_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				closed();
			}
		});
		
		open_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 파일선택기 생성 후 열기 수행한다.
				JFileChooser jfc = new JFileChooser("c:/");
				int cmd = jfc.showOpenDialog(Ex4_Frame.this);
				
				if(cmd == JFileChooser.APPROVE_OPTION) {
					// 열기버튼을 클릭한 경우!
					
					// 사용자가 선택한 파일 얻기
					selected_file = jfc.getSelectedFile();
					try {
						if(selected_file.exists()) {
							// 파일 존재여부 확인!!
							fis = new FileInputStream(selected_file);
							
							byte[] buf = new byte[2048];
							int size = -1;
							StringBuffer sb = new StringBuffer();
							
							while((size = fis.read(buf)) != -1) {
								//읽은 데이터들은 모두 buf에 있다.
								// 그 buf의 0번지부터 size의 길이만큼 가져와서
								// String으로 변환해야 한다.
								String s = new String(buf, 0, size);
								
								sb.append(s);//StringBuffer에 추가해 둔다.
							}// while의 끝
							
							ta.setText(sb.toString());// JTextArea에
							// 데이터들 표현!!!
							
							setTitle(selected_file.getAbsolutePath());
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				
			}
		});
		
		new_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 새파일 기능
				ta.setText("");
				selected_file = null;
				setTitle("");
			}
		});
		
		save_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 저장 기능
				
				// 현재 파일이 열려있는 상태인지? 아닌지?를 확인해야 한다.
				// selected_file이 null이 아니면 파일이 하나 선택되어
				// 열려있는 상태다.
				boolean check = true;
				if(selected_file == null) {
					// 파일선택기 생성 후 파일을 선택해야 한다.
					JFileChooser jfc = new JFileChooser("c:/");
					int cmd = jfc.showSaveDialog(Ex4_Frame.this);
					
					if(cmd != JFileChooser.APPROVE_OPTION)
						check = false;
					else
						selected_file = jfc.getSelectedFile();
				}
				
				if(check) //check가 true를 유지하고 있다면 저장을 한다.
					saveFile();
			}
		});
	}

	private void closed() {
		// 프로그램이 끝나기 전에 해야할 일들
		try {
			if(fis != null)
				fis.close();
			if(fos != null)
				fos.close();
		} catch (Exception e) { }
		System.exit(0);//프로그램 종료
	}
	
	private void saveFile() {
		// JTextArea에 있는 문자열들을 가져와서 FileOutputStream을 통해
		// 선택된 파일(selected_file)에 저장한다.
		String str = ta.getText();
		try {
			fos = new FileOutputStream(selected_file);
			
			// 가져온 문자열을 byte[]로 변환하자!
			byte[] buf = str.getBytes();
			
			fos.write(buf, 0, buf.length);
			fos.flush();
			
			setTitle(selected_file.getAbsolutePath());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}




