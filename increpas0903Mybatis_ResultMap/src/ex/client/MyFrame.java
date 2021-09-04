package ex.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import ex.vo.DeptVO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class MyFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;

	SqlSessionFactory factory;
	
	List<DeptVO> list;
	String[] cname = {"부서코드","부서명","지역코드"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
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
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 276, 397);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("컨트롤");
		menuBar.add(mnNewMenu);
		
		JMenuItem total_item = new JMenuItem("전체");
		mnNewMenu.add(total_item);
		
		JMenuItem search_item = new JMenuItem("검색");
		mnNewMenu.add(search_item);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem exit_item = new JMenuItem("종료");
		mnNewMenu.add(exit_item);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		db_connected();
		
		//전체보기
		total_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SqlSession ss = factory.openSession();
				
				list = ss.selectList("dept_loc.all");
				viewTable();
			}
		});
		
		//테이블에서 더블클릭시
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				int cnt = e.getClickCount();
				
				if(cnt == 2) {//더블클릭을 구별했다.
					//선택된 행번호를 얻어낸다.
					int r = table.getSelectedRow();
					
					DeptVO vo = list.get(r);
					new MyDialog(MyFrame.this, vo).setData();
				}
			}
		});
	}

	private void db_connected() {
		try {
			Reader r = Resources.getResourceAsReader(
				"ex/config/config.xml");
			factory = new SqlSessionFactoryBuilder().build(r);
			r.close();
			setTitle("준비완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void viewTable() {
		String[][] data = new String[list.size()][cname.length];
		
		//비어있는 2차원배열 요소에 List에 있는 자원들로 채워준다.
		int i = 0;
		for(DeptVO vo : list) {
			data[i][0] = vo.getDepartment_id();
			data[i][1] = vo.getDepartment_name();
			data[i][2] = vo.getLvo().getLocation_id();
			
			++i;//행의 이동을 위해 i값 증가!
		}
		
		table.setModel(new DefaultTableModel(data, cname));
	}
}
