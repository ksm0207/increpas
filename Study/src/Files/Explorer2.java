package Files;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Explorer2 extends JFrame{
	
	JPanel west_panel; /* BorderLayout */
	JPanel west_north_panel;
	JTextField path_text;
	JButton confirm;
	JList<String> j_list,frame_list;
	
	
	public Explorer2() {
		initPanel();
		
		path_text.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {
				showList();
				
			}
		});
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Click");
				
				String path = path_text.getText();
				
				System.out.println("경로 : " + path);
				
				File file = new File(path);
				
				String[] copy_ar = file.list();
				
				
			
				Vector<String> vector = new Vector<String>();
				
				if (file.isDirectory()) {
					
					File[] items = file.listFiles();
					
					
					for (int i=0; i<items.length; i++) {
						
						File hiddenFile = items[i];
						
						if (!hiddenFile.isHidden()) {
//							이 추상 경로 이름으로 표시된 파일 또는 디렉토리의 이름을 반환하고
//							경로 이름의 이름 순서가 비어 있으면 빈 문자열이 반환됩니다
							
							vector.add(hiddenFile.getName());
							
						}
						
					}
			
					j_list.setListData(vector);
					frame_list.setListData(vector);
					
					
				}else {
					JOptionPane.showMessageDialog(Explorer2.this, "존재하지 않는 폴더입니다.");
					
				}			
			}
		});
		
		j_list.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				int status = e.getClickCount();
				
				String get = path_text.getText();
				String selected = j_list.getSelectedValue();
			
				if (status == 2) {
					StringBuffer sb = new StringBuffer();
					
					sb.append(get);
					if(selected.length() > 0 ) {
						sb.append(selected);
						sb.append("/");
					}
					path_text.setText(sb.toString());	
					showList();
				}
			}
		});
		
		this.add(new JScrollPane(frame_list = new JList<String>()));
		frame_list.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				int status = e.getClickCount();
				
				String get = path_text.getText();
				String selected = frame_list.getSelectedValue();
			
				if (status == 2) {
					StringBuffer sb = new StringBuffer();
					
					sb.append(get);
					if(selected.length() > 0 ) {
						sb.append(selected);
						sb.append("/");
					}
					path_text.setText(sb.toString());	
					showList();
				}
			}
		});
	
	}
	
	public static void main(String[] args) {
		new Explorer2();
	}
	
	void initPanel() {
		west_panel = new JPanel(new BorderLayout());
		west_north_panel = new JPanel(new BorderLayout());
		
		/* Border Layout 가운데 영역 */
		west_north_panel.add(path_text = new JTextField());
		west_north_panel.add(confirm = new JButton("확인"), BorderLayout.EAST);
		
		west_panel.add(west_north_panel,BorderLayout.NORTH);
		west_panel.add(new JScrollPane(j_list = new JList<String>()));
		
		this.add(west_panel, BorderLayout.WEST);
		
		this.setBounds(200,100,500,450);
		this.setVisible(true);
	}
	
	void showList() {
		String path = path_text.getText();
		
		System.out.println("경로 : " + path);
		
		File file = new File(path);
		
		Vector<String> vector = new Vector<String>();
		
		if (file.isDirectory()) {
			
			File[] items = file.listFiles();
			
			
			for (int i=0; i<items.length; i++) {
				
				File hiddenFile = items[i];
				
				if (!hiddenFile.isHidden()) {
//					이 추상 경로 이름으로 표시된 파일 또는 디렉토리의 이름을 반환하고
//					경로 이름의 이름 순서가 비어 있으면 빈 문자열이 반환됩니다
					vector.add(hiddenFile.getName());
				}
				
			}
			j_list.setListData(vector);
			frame_list.setListData(vector);
			
		}else {
			JOptionPane.showMessageDialog(Explorer2.this, "존재하지 않는 폴더입니다.");
			
		}		
	}
	void lastList() {
		showList();
	}
}
