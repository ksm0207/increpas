package am;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

import java.io.*;

public class ExampleMemo extends JFrame {

	private JPanel contentPane;
	private JTextArea area;
	private JMenuItem new_item;
	private JMenu file_m;
	private JMenuItem open_item;
	private JMenuItem save_item;
	private JMenuItem save_as;
	private JSeparator separator;
	private JMenuItem exit_item;
	
	String path = "c:/";
	
	File selected_file;
	FileInputStream fis;
	
	BufferedReader br;
	BufferedWriter bw;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExampleMemo frame = new ExampleMemo();
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
	public ExampleMemo() {
		
		
		
		setBounds(100, 100, 529, 712);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		file_m = new JMenu("New menu");
		menuBar.add(file_m);
		
		new_item = new JMenuItem("새파일");
		file_m.add(new_item);
		
		open_item = new JMenuItem("열기");
		file_m.add(open_item);
		
		save_item = new JMenuItem("저장");
		file_m.add(save_item);
		
		save_as = new JMenuItem("다른 이름으로 저장");
		file_m.add(save_as);
		
		exit_item = new JMenuItem("종료");
		file_m.add(exit_item);
		
		separator = new JSeparator();
		file_m.add(separator);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		area = new JTextArea();
		scrollPane.setViewportView(area);
		
		
		/* '종료' Event */
		exit_item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				closed();
			}
		});
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				closed();
				
			}
		});
		
		
		open_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				readData();
				System.out.println("Open Click");
				
			}
		});
		
		/* 저장 , 다른이름으로 저장 Event */
		
		save_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		save_as.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveData(true);
				
			}
		});
		
		
	}
	private void closed() {
		
		try {
			if(br != null) {
				br.close();	
			}
			if(bw != null) {
				bw.close();				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.exit(0);
	}

	private void readData() {
		
		try {
			
			String text = "";
			
			JFileChooser jfc = new JFileChooser("c:/");
			selected_file = new File(path);
			
			int status = jfc.showOpenDialog(jfc);
			
			if (status == JFileChooser.APPROVE_OPTION) {
				
				selected_file = jfc.getSelectedFile();
				
				if (selected_file.exists()) {
					
					fis = new FileInputStream(selected_file);
					br = new BufferedReader(new InputStreamReader(fis));
					
					while((text = br.readLine()) != null) {
						StringBuffer sb = new StringBuffer();
						sb.append(text);
						area.setText(sb.toString());
					}
				}
				
			}
	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void save() {}
	
	private boolean saveData(boolean check) {
		
		return check;
	}
}
