package am.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Reader;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import am.vo.DeptVO;
import am.vo.EmpVO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class Ex2_Main extends JFrame {

	SqlSessionFactory factory;
	
	private JPanel contentPane;
	private JTable table;
	private JPanel panel;
	private JButton total_btn;
	
	String[] column = {"부서코드","부서명","인원수","사원번호","이름","직종"};
	String[][] row;
	List<DeptVO> dvo_list;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex2_Main frame = new Ex2_Main();
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
	public Ex2_Main() {
		db_con();
		init();
		

		this.addWindowFocusListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		total_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Total");
				
				SqlSession session = factory.openSession();
				dvo_list = session.selectList("dept_emp.all");
				row = new String[dvo_list.size()][column.length];
				
				viewTable();		
			}	
		});
	}
	
	private void viewTable() {		
		int i =0;
		for(DeptVO dvo : dvo_list) {
			List<EmpVO> emp_list = dvo.getEmp_list();
			
			row[i][0] = dvo.getDepartment_id();
			row[i][1] = dvo.getDepartment_name();
			row[i][2] = String.valueOf(dvo.getEmp_list().size());
			
			for(EmpVO emp : emp_list) {
				row[i][3] = emp.getEmployee_id();
				row[i][4] = emp.getFirst_name();
				row[i][5] = emp.getJob_id();
			}
			
			i++;
		}
		table.setModel(new DefaultTableModel(row, column));
		
	}
	
	
	private void init() {
		setBounds(100, 100, 547, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		total_btn = new JButton("전체보기");
		panel.add(total_btn);
	}
	
	private void db_con() {
		
		try {
			
			Reader read = Resources.getResourceAsReader("am/conf/config.xml");
			factory = new SqlSessionFactoryBuilder().build(read);
			read.close();
			System.out.println("DB on");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
