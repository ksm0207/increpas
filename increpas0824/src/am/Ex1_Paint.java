package am;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class Ex1_Paint extends JFrame {

	private JPanel contentPane;
	private JButton black_bt;
	private JButton gray_bt;
	private JButton red_bt;
	private JButton yellow_bt;
	private JButton blue_bt;
	private JButton white_bt;
	private JComboBox combo;
	private JPanel center_panel;
	private JMenu file_m;
	private JMenuItem new_item;
	private JMenuItem open_item;
	private JMenuItem save_item;
	private JMenuItem exit_item;
	
	
	String path = "C:/Users/user/Desktop/Serializable";
	
	File file;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	ArrayList<OvalPaint> list = new ArrayList<OvalPaint>();
	Color color = Color.BLACK;
	private JButton pink_btn;
	private JButton green_btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex1_Paint frame = new Ex1_Paint();
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
	public Ex1_Paint() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 580);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		file_m = new JMenu("파일");
		menuBar.add(file_m);
		
		new_item = new JMenuItem("새 파일");
		file_m.add(new_item);
		
		open_item = new JMenuItem("열기...");
		file_m.add(open_item);
		
		save_item = new JMenuItem("저장");
		file_m.add(save_item);
		
		JSeparator separator = new JSeparator();
		file_m.add(separator);
		
		exit_item = new JMenuItem("종료");
		file_m.add(exit_item);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(3, 2, 0, 0));
		
		combo = new JComboBox();
		panel_2.add(combo);
		combo.setModel(new DefaultComboBoxModel(new String[] {"5", "15", "20", "25", "30"}));
		
		black_bt = new JButton("");
		black_bt.setBackground(Color.BLACK);
		panel_2.add(black_bt);
		
		gray_bt = new JButton("");
		gray_bt.setBackground(Color.GRAY);
		panel_2.add(gray_bt);
		
		red_bt = new JButton("");
		red_bt.setBackground(Color.RED);
		panel_2.add(red_bt);
		
		yellow_bt = new JButton("");
		yellow_bt.setBackground(Color.YELLOW);
		panel_2.add(yellow_bt);
		
		blue_bt = new JButton("");
		blue_bt.setBackground(Color.BLUE);
		panel_2.add(blue_bt);
		
		white_bt = new JButton("");
		white_bt.setBackground(Color.WHITE);
		panel_2.add(white_bt);
		
		pink_btn = new JButton("");
		pink_btn.setBackground(Color.PINK);
		panel_2.add(pink_btn);
		
		green_btn = new JButton("");
		green_btn.setBackground(Color.GREEN);
		panel_2.add(green_btn);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		setColorBtn();
		ovalPaint();
		ovalMouseListener();
		
		contentPane.add(center_panel, BorderLayout.CENTER);
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				closed();
				System.exit(0);//프로그램 종료
			}
		});
		
		new_item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("새파일");
			}
		});
		
		open_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser jfc = new JFileChooser(path);
				
				int status = jfc.showSaveDialog(Ex1_Paint.this);
				
				if (status == JFileChooser.APPROVE_OPTION) {
					file = jfc.getSelectedFile();
					System.out.println("선택한 파일 : " + file);
					openFile();
				}
				
				
			}
		});
		
		save_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean flag = true;
				
				if(file == null) {
					
					JFileChooser jfc = new JFileChooser(path);
					
					int status = jfc.showSaveDialog(Ex1_Paint.this);
					
					if (status == JFileChooser.APPROVE_OPTION) {
						file = jfc.getSelectedFile();
						System.out.println("선택한 파일 : " + file);
					}else {
						flag = false;
					}
					
					if(flag) {
						saveFile();
					}
				}
			}
		});
	}
	private void setColorBtn() {
		black_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				color = Color.BLACK;
			}
		});
		gray_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				color = Color.GRAY;
			}
		});
		red_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				color = Color.RED;
			}
		});
		yellow_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				color = Color.YELLOW;
			}
		});
		blue_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				color = Color.BLUE;
			}
		});
		white_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				color = Color.WHITE;
			}
		});
		
		pink_btn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						color = Color.PINK;
					}
				});
		
		green_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				color = Color.GREEN;
			}
		});
	}
	
	private void ovalPaint() {
		center_panel = new JPanel() {

			@Override
			public void paint(Graphics g) {
				Image buf = 
					createImage(this.getWidth(), this.getHeight());
				Graphics buf_g = buf.getGraphics();
				
				// ArrayList에 있는 객체를 꺼내서 그림그리기.
				
				for(int i=0; i<list.size(); i++ ) {
					OvalPaint oval = list.get(i);
					buf_g.setColor(oval.color);
					buf_g.fillOval(oval.x, oval.y, oval.wh, oval.wh);	
				}
				
				//buf를 현재 JPanel에 그린다.
				g.drawImage(buf, 0, 0, this);
				
			}
			
		};
	}
	
	private void ovalMouseListener() {
		center_panel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int wh = (int)(Math.random()*180+20);
				int x = e.getX() - wh/2;
				int y = e.getY() - wh/2;
				
				//타원 객체 생성
				OvalPaint ov = new OvalPaint(x, y, wh, color);
				
				list.add(ov);// ArrayList에 추가
				center_panel.repaint();
				
			}
		});
	}
	
	private void saveFile() {
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(list);
			oos.flush();
			setTitle(file.getName());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void openFile() {
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			
			Object obj = ois.readObject();
			if(obj != null) {
				list = (ArrayList<OvalPaint>) obj;
				center_panel.repaint();	
			}
			setTitle(file.getName());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void closed() {
		
		try {
			
			if(ois != null) {
				ois.close();
			}
			if(oos != null) {
				oos.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
