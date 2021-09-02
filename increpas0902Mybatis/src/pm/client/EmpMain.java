package pm.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import pm.vo.EmpVO;

public class EmpMain extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JMenuItem search_item;
	private JMenuItem add_item;
	private JMenuItem total_item;
	private JMenuItem exit_item;
	
	SqlSessionFactory factory;
	
	String[] cname = {"사번","성씨","직종","이메일","입사일","부서코드"};
	String [][] data;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpMain frame = new EmpMain();
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
	public EmpMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 642);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("메뉴");
		menuBar.add(mnNewMenu);
		
		total_item = new JMenuItem("전체");
		mnNewMenu.add(total_item);
		
		add_item = new JMenuItem("추가");
		mnNewMenu.add(add_item);
		
		search_item = new JMenuItem("검색");
		mnNewMenu.add(search_item);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		exit_item = new JMenuItem("종료");
		mnNewMenu.add(exit_item);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		 db_con();
		 
		 total_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("전체 메뉴 선택");
				
				SqlSession session = factory.openSession();
				
//				EmpVO evo = session.selectOne("emp.all");
				List<EmpVO> list = session.selectList("emp.all");			
				viewTable(list);
				session.close();
			}
			
		});
		
		 add_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("검색 메뉴 선택");
				
				
			}
		});
		 
		table.addMouseListener(new MouseAdapter() {
		
			
		});
		 
		 
	}
	
	private void addData(Map<String,EmpVO[]> list) {
		
	}
	
	private void viewTable(List<EmpVO> list) {
		
		data = new String[list.size()][cname.length];
		int i=0;
		
		for(EmpVO evo : list) {
			
			data[i][0] = evo.getEmployee_id();
			data[i][1] = evo.getLast_name();
			data[i][2] = evo.getJob_id();
			data[i][3] = evo.getEmail();
			data[i][4] = evo.getHire_date();
			data[i][5] = evo.getDepartment_id();
			i++;
			
			table.setModel(new DefaultTableModel(data,cname));
		}
		
	}
	
	private void db_con() {
		
		try {
			
			Reader read = Resources.getResourceAsReader("pm/config/config.xml");
			factory = new SqlSessionFactoryBuilder().build(read);
			read.close();
			setTitle("DB Connection !");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
