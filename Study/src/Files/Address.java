package Files;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Address extends JFrame {
	
private JPanel contentPane;
	
	private JTextField search_text;
	private JTextField clickText;
	private JButton confirm;
	
	private JList<String> list;
	
	BufferedReader br;
	FileInputStream fis;
	String path = "C:/Users/user/Desktop/0820/서울특별시.txt";
	
	public Address() {
		setBounds(100, 100, 415, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		clickText = new JTextField();
		panel.add(clickText);
		clickText.setColumns(10);
		
		JLabel label = new JLabel("도로명 :");
		panel.add(label);
		
		search_text = new JTextField();
		search_text.setToolTipText("");
		panel.add(search_text);
		search_text.setColumns(10);
		
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
				
				String search = search_text.getText();
				String text = "";
				Vector<String> vector = new Vector<String>();
				
				System.out.println("검색 : " + search);
				
				try {
					
					fis = new FileInputStream(path);
					br = new BufferedReader(new InputStreamReader(fis));
					
					JOptionPane.showMessageDialog(Address.this, search + "  검색중...  ");
					while ((text = br.readLine()) != null ) {	
						
						if(text.contains(search)) {
							StringBuffer sb = new StringBuffer();
							
							String[] sub = text.split("\\|");
							
							sb.append(sub[0]);
							sb.append(":");
							sb.append(sub[8]);
							vector.add(sb.toString());						
						}
						search_text.setText("");
						
					}
					if (vector.isEmpty()) {
						JOptionPane.showMessageDialog(Address.this, search + " 는(은) 없는 결과 입니다.");
					}else {
						JOptionPane.showMessageDialog(Address.this, search + " 검색 결과 입니다.");
						list.setListData(vector);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String firstCode = list.getSelectedValue();
				clickText.setText(firstCode.substring(0,5));
			}
		});
	}

	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Address frame = new Address();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
