package pm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class MyAddress extends JFrame {

	
	private JPanel contentPane;
	
	private JTextField area;
	private JTextField resText;
	private JButton confirm;
	private JScrollPane scrollPane;
	private JList<String> list;
	
	BufferedReader br;
	FileInputStream fis;
	String path = "C:/Users/user/Desktop/0820/서울특별시.txt";
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyAddress frame = new MyAddress();
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
	public MyAddress() {
		
		
		setBounds(100, 100, 415, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		resText = new JTextField();
		panel.add(resText);
		resText.setColumns(10);
		
		JLabel label = new JLabel("도로명 :");
		panel.add(label);
		
		area = new JTextField();
		area.setToolTipText("");
		panel.add(area);
		area.setColumns(10);
		
		confirm = new JButton("검색");
		panel.add(confirm);
		
		list = new JList();
		contentPane.add(list, BorderLayout.CENTER);
		
		
		
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
				try {
					fis.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					br.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				 String search = area.getText();
				 String text = "";
		
				 System.out.println("검색 : " + search);
			 
				try {
					fis = new FileInputStream(path);
					br = new BufferedReader(new InputStreamReader(fis));	
					
					Vector<String> vector = new Vector<String>();
					JOptionPane.showMessageDialog(MyAddress.this, "검색중...");	
						
					while((text = br.readLine()) != null ) {	
						if(text.contains(search)) {
							StringBuffer sb = new StringBuffer();	
							
							String[] sp =  text.split("\\|");
							sb.append(sp[0]);
							sb.append(":");
							sb.append(sp[8]);
							vector.add(sb.toString());
							area.setText("");
						}
		
					}// end of while
					
					list.setListData(vector);
					
					if (vector.isEmpty()) {
						JOptionPane.showMessageDialog(MyAddress.this, "검색하신 "+search + " 는 없는 결과 입니다.");	
					}else {
						JOptionPane.showMessageDialog(MyAddress.this, search + " 결과 입니다. ");	
					}
					
					fis.close();
					br.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}			
			}
		});
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				int click = e.getClickCount();
				
				if (click == 2) {
					String get = list.getSelectedValue();
					
					String[] res = get.split(":");
					resText.setText(res[0]);	
				}
			}
		});
	}
	
}
