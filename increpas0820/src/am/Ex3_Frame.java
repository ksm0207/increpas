package am;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

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

public class Ex3_Frame extends JFrame {
	
	int status;
	
	File file;
	BufferedInputStream bis;
	
	private JPanel contentPane;
	private JTextArea area;
	private JMenuItem new_item;
	private JMenuItem open_item;
	private JMenuItem exit_item;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex3_Frame frame = new Ex3_Frame();
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
	public Ex3_Frame() {
		
		setBounds(100, 100, 483, 526);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fime_m = new JMenu("New File");
		menuBar.add(fime_m);
		
		new_item = new JMenuItem("새 파일");
		fime_m.add(new_item);
		
		open_item = new JMenuItem("열기");
		fime_m.add(open_item);
		
		JSeparator separator = new JSeparator();
		fime_m.add(separator);
		
		exit_item = new JMenuItem("종료");
		
		fime_m.add(exit_item);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		area = new JTextArea();
		scrollPane.setViewportView(area);
		
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				
				System.exit(0);
				
			}
		});
	
		open_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("열기 버튼");
				JFileChooser file_open = new JFileChooser("c:/");
				
				int status = file_open.showOpenDialog(file_open);
				
				if(status == JFileChooser.APPROVE_OPTION) {
				
					file = file_open.getSelectedFile();
					System.out.println("파일을 선택하였습니다." + file);
					try {
						
						if (file.exists()) {
							bis = new BufferedInputStream(new FileInputStream(file));
							
							int file_size = -1;
							byte[] encoding = new byte[2048];
							StringBuffer sb = new StringBuffer();
							
							while((file_size = bis.read(encoding)) != -1) {
								String res = new String(encoding);
								sb.append(res);
							}
							area.setText(sb.toString());
						}
						
		
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
				
					System.out.println("선택 반환값 : "+JFileChooser.APPROVE_OPTION);
				}else {
					System.out.println("취소 반환 값 : " + status);
				}
					
			}
		});
	}

}
