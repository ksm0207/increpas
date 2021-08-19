package am;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

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

public class FileInput extends JFrame {

	private JPanel contentPane;
	
	JTextArea ta;
	JMenuBar menuBar;
	JMenu file;
	
	File select_file;
	FileInputStream fis;
	
	private JMenuItem open_item;
	private JMenuItem select_files;
	private JMenuItem menuItem;
	private JMenuItem mntmNewMenuItem;
	private JSeparator separator;
	private JMenuItem mntmNewMenuItem_1;
	
	
	public FileInput() {
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 426, 483);
			setVisible(true);
			
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			
			setContentPane(contentPane);
			
			menuBar = new JMenuBar();
			contentPane.add(menuBar, BorderLayout.NORTH);
			
			file = new JMenu("파일");
			menuBar.add(file);
			
			select_files = new JMenuItem("새파일");
			file.add(select_files);
			
			open_item = new JMenuItem("열기");
			file.add(open_item);
			
			open_item.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JFileChooser jfc = new JFileChooser("C:/Users/user/Desktop/테스트/");
					
					int status = jfc.showOpenDialog(FileInput.this);
					
					if(status == JFileChooser.APPROVE_OPTION) {
						
						select_file = jfc.getSelectedFile();
						
						byte[] buf = new byte[2048];
						
						int size = -1;
						try {
							fis = new FileInputStream(select_file);
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
			});
			
			menuItem = new JMenuItem("저장");
			file.add(menuItem);
			
			mntmNewMenuItem = new JMenuItem("새 이름으로 저장");
			file.add(mntmNewMenuItem);
			
			separator = new JSeparator();
			file.add(separator);
			
			mntmNewMenuItem_1 = new JMenuItem("New menu item");
			file.add(mntmNewMenuItem_1);
			
			
			JScrollPane scrollPane = new JScrollPane();
			contentPane.add(scrollPane, BorderLayout.CENTER);
			
			ta = new JTextArea();
			scrollPane.setViewportView(ta);
		}
	

	public static void main(String[] args) {
		new FileInput();
	}

}
