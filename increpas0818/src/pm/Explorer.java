package pm;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.graalvm.compiler.java.JsrScope;

public class Explorer extends JFrame{
	
	JPanel west_panel; /* BorderLayout */
	JPanel west_north_panel;
	JTextField path_text;
	JButton confirm;
	
	JList<String> j_list,frame_list;
	
	
	public Explorer() {
		
		initPanel();
		
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				
				System.exit(0);
			}
		});
		
	
		path_text.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showList();
				
			}
		});
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String res = path_text.getText().trim();
				
				File file = new File(res);
				
				if(file.isDirectory()) {
					
//					String[] items = file.list();
					
					File[] list = file.listFiles();
					
//					ArrayList<String> f = new ArrayList<String>();
					Vector<String> v = new Vector<String>();
					
					for (int i=0; i<list.length; i++) {
						
						File hidden = list[i];
						
						if (!hidden.isHidden()) {
//							f.add(hidden.getName());
							v.add(hidden.getName());
						}
					}
					
//					String[] change = new String[f.size()];
					
					
//					f.toArray(change);
					
					j_list.setListData(v);
					
					
	
				}else {
					JOptionPane.showMessageDialog(Explorer.this, "존재하지 않는 폴더입니다.");
				}		
			}
		});
		j_list.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				int status = e.getClickCount();
				
				if (status == 2) {
					
					String get = path_text.getText();
					String select = j_list.getSelectedValue();
					
					StringBuffer sb = new StringBuffer();
			
		           

//		            	사용자가 직접 마지막에 "/"를 넣을 수도 있고,
//		            	안 넣을 수도 있기 때문에 그 부분을 처리해야 합니다.
					
					 sb.append(get);
					 if(select != "/")
		            	 sb.append(select);
		            	 sb.append("/");
		            	 
		            int idx = get.lastIndexOf("/");
					
		            if(idx != get.length() -1) {
		            	sb.append("/");
		            }
		            
		            
		            	
		            String res = sb.toString();
		             
		            path_text.setText(res);
		            showList();
		            
		          					
					System.out.println("더블클릭 " + select);
					
				}
			}
		});
		
		this.add(new JScrollPane(frame_list = new JList<String>()));
	}
	
	void showList() {
		String res = path_text.getText().trim();
		
		File file = new File(res);
		
		if(file.isDirectory()) {
			
			String[] frame_items = file.list();
			
			File[] list = file.listFiles();
			
//			ArrayList<String> f = new ArrayList<String>();
			Vector<String> v = new Vector<String>();
			
			for (int i=0; i<list.length; i++) {
				
				File hidden = list[i];
				
				if (!hidden.isHidden()) {
//					f.add(hidden.getName());
					v.add(hidden.getName());
				}
			}
			
//			String[] change = new String[f.size()];
			
			
//			f.toArray(change);
			
			j_list.setListData(v);
			frame_list.setListData(frame_items);
			
			

		}else {
			JOptionPane.showMessageDialog(Explorer.this, "존재하지 않는 폴더입니다.");
		}
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
	
	public static void main(String[] args ) {
		new Explorer();
	}

}
