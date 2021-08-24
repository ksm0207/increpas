package pm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Example extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_1_1_1;
	private JPanel panel_1_1_3;
	private JPanel panel_1_1_2;
	private JPanel panel_5;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	
	
	private JTextArea textArea;
	
	private JButton total_btn;
	private JButton add_btn;
	private JButton search_btn;
	private JButton remove_btn;
	private JButton cancel_btn;
	
	private JTextField employee_id;
	private JTextField first_name;
	private JTextField phone;
	private JTextField job_id;
	private JTextField department;
	
	private String path = "C:/Users/user/Desktop/0820/obj_test6.txt";
	private File file;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	ArrayList<Employees> emp = new ArrayList<Employees>();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Example frame = new Example();
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
	public Example() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(7, 1, 0, 0));
		
		JLabel label = new JLabel("");
		panel.add(label);
		
		panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel.add(panel_1);
		
		lblNewLabel = new JLabel("사번");
		panel_1.add(lblNewLabel);
		
		employee_id = new JTextField();
		panel_1.add(employee_id);
		employee_id.setColumns(10);
		
		panel_1_1_1 = new JPanel();
		panel.add(panel_1_1_1);
		
		lblNewLabel_1 = new JLabel("이름");
		panel_1_1_1.add(lblNewLabel_1);
		
		first_name = new JTextField();
		first_name.setColumns(10);
		panel_1_1_1.add(first_name);
		
		panel_1_1_2 = new JPanel();
		panel.add(panel_1_1_2);
		
		lblNewLabel_3 = new JLabel("전화");
		panel_1_1_2.add(lblNewLabel_3);
		
		phone = new JTextField();
		phone.setColumns(10);
		panel_1_1_2.add(phone);
		
		panel_1_1_3 = new JPanel();
		panel.add(panel_1_1_3);
		
		lblNewLabel_2 = new JLabel("직책");
		panel_1_1_3.add(lblNewLabel_2);
		
		job_id = new JTextField();
		job_id.setColumns(10);
		panel_1_1_3.add(job_id);
		
		panel_5 = new JPanel();
		panel.add(panel_5);
		
		lblNewLabel_4 = new JLabel("부서");
		panel_5.add(lblNewLabel_4);
		
		department = new JTextField();
		department.setColumns(10);
		panel_5.add(department);
		
		textArea = new JTextArea();
		contentPane.add(textArea, BorderLayout.CENTER);
		
		panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		total_btn = new JButton("전체");
		panel_2.add(total_btn);
		
		add_btn = new JButton("추가");
		panel_2.add(add_btn);
		
		search_btn = new JButton("검색");
		panel_2.add(search_btn);
		
		remove_btn = new JButton("삭제");
		panel_2.add(remove_btn);
		
		cancel_btn = new JButton("취소");
		panel_2.add(cancel_btn);
		
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				
					try {
						loadFile();
						if (oos == null) {
							oos = new ObjectOutputStream(new FileOutputStream(file));
							oos.writeObject(emp);
							oos.flush();
						}
						ois.close();
						oos.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.exit(0);
				
			}
		});
		
		add_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("추가 버튼 클릭 ");
				
				File file = new File("C:/Users/user/Desktop/0820/obj_test6.txt");
				
				try {
					
					emp.add(new Employees(
					employee_id.getText(),
					first_name.getText(),
					phone.getText(),
					job_id.getText(),
					department.getText()));
				
					oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(emp);
					System.out.println("저장 완료 !");
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	
		total_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				File file = new File("C:/Users/user/Desktop/0820/obj_test6.txt");
				try {
					ois = new ObjectInputStream(new FileInputStream(file));
					Object obj = ois.readObject();
					
					ArrayList<Employees> emp = (ArrayList<Employees>) obj;
					
					
					StringBuffer sb = new StringBuffer();
					
					for (int i=0; i<emp.size(); i++) {
						Employees data = emp.get(i);
						sb.append(data.getId());
						sb.append(" ");
						sb.append(data.getName());
						sb.append(" ");
						sb.append(data.getPh());
						sb.append(" ");
						sb.append(data.getJob());
						sb.append(" ");
						sb.append(data.getDepart());
						sb.append("\n");
						textArea.setText(sb.toString());
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	
		search_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	
	
	private void loadFile() {
		
		file = new File(path);
		
		try {
			
			if(!file.exists()) {
			    file.createNewFile();
			}
			
			ois = new ObjectInputStream(new FileInputStream(file));
			
			Object obj = ois.readObject();
			
			if (obj != null) {
				emp = (ArrayList<Employees>) obj;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
