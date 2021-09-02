package pm.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	EmpDialog ed;
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
		setBounds(100, 100, 872, 642);
		
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
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				int click = e.getClickCount();
				
				if(click == 2) {
					
					/* 더블 클릭한 레코드의 행 번호를 얻어내기 */
					int index = table.getSelectedRow();
					
					String empno = (String)table.getValueAt(index, 0);
					/*
						String lname = (String)table.getValueAt(index, 1);
						String job = (String)table.getValueAt(index, 2);
						String email = (String)table.getValueAt(index, 3);
						String hire = (String)table.getValueAt(index, 4);
						String dptno = (String)table.getValueAt(index, 5);
						
						EmpVO evo = new EmpVO();
						
						evo.setEmployee_id(empno);
						evo.setLast_name(lname);
						evo.setJob_id(job);
						evo.setEmail(email);
						evo.setHire_date(hire);
						evo.setDepartment_id(dptno);
					*/
					
					EmpVO evo = getEmp(empno);
					ed = new EmpDialog(EmpMain.this, evo);
					ed.setData();
	
				}
				
			}
		});
	}
	
	/* 사번으로 사원 검색 기능 DB를 활용한 방법 */
	
	public EmpVO getEmp(String empno) {
		
		SqlSession session = factory.openSession();
		
		EmpVO evo = session.selectOne("emp.search_empno",empno);
		
		session.close();
		
		
		return evo;
		
	}
	
	public void update2(Map<String,EmpVO> map) {
		
	}
	
	/* 사번을 조건으로 수정하는 기능 */
	
	public int updateEmp(Map<String,String> map) {
		
		System.out.println("Update Data : " + map);
		
		SqlSession session = factory.openSession(true);
		
		int update = session.update("emp.update",map);
		
		System.out.println("Update value : " +update);
		
		session.close();
		return update;
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
