package pm.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Reader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import am.vo.EmpVO;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.FlowLayout;

public class Ex2_Frame extends JFrame {

	SqlSession session;
	SqlSessionFactory factory;
	
	String[] cname = {"사번","이름","직종","입사일","부서코드"};
	String[][] data;
	
	private JPanel contentPane;
	private JButton total_btn;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton emp_no_btn;
	private JButton emp_name_btn;
	private JButton add_bt;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex2_Frame frame = new Ex2_Frame();
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
	public Ex2_Frame() {
		setBounds(100, 100, 636, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		total_btn = new JButton("전체");
		panel.add(total_btn);
		
		emp_no_btn = new JButton("사번검색");
		panel.add(emp_no_btn);
		
		emp_name_btn = new JButton("사번 이름 검색");
		panel.add(emp_name_btn);
		
		add_bt = new JButton("추가");
		panel.add(add_bt);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		db_connected();
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		total_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// factory 로부터 sqlSession을 얻어내기
				SqlSession session = factory.openSession();
				
				// 세션을 이용해서 사원의 전체 정보를 가져오기
				List<EmpVO> list = session.selectList("emp.all");
				
				// JTable로 표현하기 위해서 가져온 list를 String[][] 배열로 변환
//				data = list.toArray(new String[list.size()][cname.length]); 캐스팅불가
				data = new String[list.size()][cname.length];
				
				int i=0;
				for(EmpVO vo : list) {
					data[i][0] = vo.getEmployee_id();
					data[i][1] = vo.getFirst_name();
					data[i][2] = vo.getJob_id();
					data[i][3] = vo.getHire_date();
					data[i][4] = vo.getDepartment_id();
					i++;
					
				}
			
				table.setModel(new DefaultTableModel(data,cname));
				session.close();
				
				
			}
		});
		
		emp_no_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SqlSession session = factory.openSession();
				String emp_no = JOptionPane.showInputDialog(Ex2_Frame.this,"검색할 사번을 입력하세요");
				
				EmpVO evo = session.selectOne("emp.search_empno",emp_no);
				boolean check = false;
				if(evo != null) {
					
					data = new String[1][cname.length];	
					data[0][0] = evo.getEmployee_id();
					data[0][1] = evo.getFirst_name();
					data[0][2] = evo.getJob_id();
					data[0][3] = evo.getHire_date();
					data[0][4] = evo.getDepartment_id();
					table.setModel(new DefaultTableModel(data,cname));
					check = true;
				}
				if(!check) {
					JOptionPane.showMessageDialog(Ex2_Frame.this, "존재하지 않은 데이터 입니다.");
				}
	
			}
		});
		
		emp_name_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog(Ex2_Frame.this,"사번 이름을 입력하세요.");
				
				if (name != null) {
					SqlSession session = factory.openSession();
					List<EmpVO> list2 = session.selectList("emp.search_name",name);
					viewTable(list2);	
					session.close();
				}
			}
		});
		
		add_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Ex2_Add(Ex2_Frame.this);
			
				
			}
		});
	}
	
	/* DB 연결은 함수처리후 생성자에 둘것.*/
	
	private void db_connected() {
		try {
			Reader reader = Resources.getResourceAsReader("am/config/config.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			setTitle("DB연결 완료");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void viewTable(List<EmpVO> list) {
		boolean check = false;
		data = new String[list.size()][cname.length];
		int i=0;
		
		for(EmpVO vo : list) {
			data[i][0] = vo.getEmployee_id();
			data[i][1] = vo.getFirst_name();
			data[i][2] = vo.getJob_id();
			data[i][3] = vo.getHire_date();
			data[i][4] = vo.getDepartment_id();
			i++;
			check = true;
		}
	
		table.setModel(new DefaultTableModel(data,cname));
		if(!check) {
			JOptionPane.showMessageDialog(Ex2_Frame.this, "존재하지 않는 데이터 입니다.");
		}
	}
	
	public void addData(Map<String, String> list) {
		
		System.out.println("addData : " + list);
		
		SqlSession session = factory.openSession(true); // AutoCommit
		
		// INSERT 성공시 추가된 레코드 수가 status에 저장됨.
		int status = session.insert("emp.add",list);
		System.out.println("Status: "+status);
		
		if(status > 0) {
			JOptionPane.showMessageDialog(this, "추가 완료");
		}else {
			JOptionPane.showMessageDialog(this, "추가 실패");
		}
		 
	}

}
