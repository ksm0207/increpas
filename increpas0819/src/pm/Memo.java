package pm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import am.FileInput;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

public class Memo extends JFrame {

	private JPanel contentPane;
	private JTextArea ta;
	private JMenuItem new_item;
	private JMenuItem open_item;
	private JMenuItem save_item;
	private JMenuItem saveAs_item;
	private JMenuItem exit_item;
	
	String path = "C:/Users/user/Desktop/";
	
	File file = new File(path);
	
	FileInputStream fis;
	FileOutputStream fos;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Memo frame = new Memo();
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
	public Memo() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890, 709);
		setTitle("제목없음 - Java Swing 메모장  - by Kim");
		
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
				// 프로그램이 끝나기 전에 해야할 일들
				bufClose();
				closed();
				
			}
		});
		exit_item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bufClose();
				closed();		
			}
		});
	
		new_item.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setTitle("제목없음 - Java Swing 메모장");
				
				
				if (ta.getText().isEmpty()) {
					return;
				}else {
					int choice = JOptionPane.showConfirmDialog(Memo.this, "현재 내용을 저장하시겠습니까?", "확인창",
							JOptionPane.YES_NO_CANCEL_OPTION);	
					if(choice == 0) {
						savsAs();
					}else {
						file = null;
						ta.setText("");
					}
				}
		
//				System.out.println(choice);
				
			}
		});
	
		open_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser jfc = new JFileChooser(path);
				
				int status = jfc.showOpenDialog(Memo.this);
				
				if(status == JFileChooser.APPROVE_OPTION) {
					
					String title = jfc.getSelectedFile().toString();
					setTitle(title);
					
					if(file.exists()) {
						
						file = jfc.getSelectedFile();
						
						byte[] buf = new byte[2048];
						int size = -1;
						
						try {
							
							fis = new FileInputStream(file);
							ta.setText("");	
							
							for (int i=0; i< buf.length; i++) {
								if ((size = fis.read(buf))  != -1) {
									String res = new String(buf, 0, size);
									ta.append(res);	
								}else {
									return;
								}
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
				}
			}
		}
	});

		save_item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean flag = true;
				int status = 0 ;
				
				if (file != null) {
					System.out.println("File Null");
					JFileChooser jfc = new JFileChooser(file);
					status = jfc.showSaveDialog(Memo.this);
					
					if (!ta.getText().isEmpty()) {
						int choice = JOptionPane.showConfirmDialog(Memo.this, "변경된 내용이 있습니다 덮어 씌울까요?", "확인창",
								JOptionPane.YES_NO_CANCEL_OPTION);
						if(choice == 0) {
							JOptionPane.showMessageDialog(Memo.this, "저장하였습니다.");
							saveFile();
						}	
					}
					if (status != JFileChooser.APPROVE_OPTION) {
						flag = false;
					}else {				
						file = jfc.getSelectedFile();	
					}
					
				}
				if(flag)
					saveFile();
			
			}
		});
	
		saveAs_item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				savsAs();
			}
		});
	}
	
	void closed() {
		System.exit(0);
	}
	void savsAs() {
		
			JFileChooser jfc = new JFileChooser(path);
			int status = jfc.showSaveDialog(Memo.this);
			
			if (file != null ) {
				System.out.println(file);
				if (status == JFileChooser.APPROVE_OPTION) {
					
					StringBuffer sb = new StringBuffer();
					
					String save = jfc.getSelectedFile().toString();
					
					sb.append(save);
					sb.append(".txt");
					
					String res = sb.toString();
					
					file = jfc.getSelectedFile();
					
					try {
						
						fos = new FileOutputStream(res);
						String content = ta.getText();
						
						byte[] encoding = content.getBytes();
						if(status == JFileChooser.APPROVE_OPTION) {		
							fos.write(encoding);
							fos.flush();
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				}
			}
	}
	void saveFile() {
		
		String text = ta.getText();
		
		try {
			
			fos = new FileOutputStream(file);
			
			byte[] encoding = text.getBytes();
			
			fos.write(encoding);
			fos.flush();
			
			setTitle(file.getAbsolutePath());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	void bufClose() {
		if (fis != null) {
			try {
				fis.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (fos != null) {
			try {
				fos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
}
