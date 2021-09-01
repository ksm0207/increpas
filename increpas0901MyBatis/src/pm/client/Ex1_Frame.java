package pm.client;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Reader;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import pm.vo.EmpVO;

public class Ex1_Frame extends JFrame {

	private JPanel contentPane;
	
	private JTextField value_tf;
	private JButton search_bt;
	private JScrollPane scrollPane;
	private JTable table;
	private JComboBox comboBox;
	
	SqlSessionFactory factory;
	String[] box_item = {"직종","이름","부서코드"};
	
	String[] cname = {"사번","성씨","입사일","이메일","직종","부서코드"};
	String[][] data;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex1_Frame frame = new Ex1_Frame();
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
	public Ex1_Frame() {

		setBounds(100, 100, 450, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		comboBox = new JComboBox(box_item);
		comboBox.setToolTipText("");
		panel.add(comboBox);
		
		value_tf = new JTextField();
		panel.add(value_tf);
		value_tf.setColumns(10);
		
		search_bt = new JButton("검색");
		panel.add(search_bt);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	
		db_con();
		
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				super.windowClosing(e);
			}
		});
		
		search_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/* 콤보상자에서 선택된 값을 얻어내기. */
				/* Index 값을 얻어내도됨. */
				System.out.println("검색버튼");
				
				int type = comboBox.getSelectedIndex();
				
				/* index
				 * 
				 * 직종 : 0
				 * 이름 : 1
				 * 부서코드 2
				 * 
				 * type으로 emp.xml 에 searchType 변수의 값으로 사용하기
				 * */
				
				/* 사용자가 입력한 '검색어' 를 가져오자.*/
				
				String value = value_tf.getText().trim();
				
				System.out.println(value);
				
				if(!value.isEmpty())
					search(type,value);
			
			}

			
		});
	
	}
	private void search(int type, String value) {	
		
		SqlSession session = factory.openSession();
		
		// search Mapper를 호출하기위한 Map 구조 생성
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("searchType",  String.valueOf(type));
		map.put("searchValue", value);
		
		List<EmpVO> list = session.selectList("emp2.search",map);
		
		session.close();
		
		viewTable(list);
	}
	
	private void viewTable(List<EmpVO> list) {
		
		boolean check = false;
		
		data = new String[list.size()][cname.length];
		
//		for(int i=0; i<data.length; i++) {
//			System.out.println("Data : " +data[i]);
//		}
		
		int i=0;
		// 이메일 직종 부서코드
		for(EmpVO vo : list) {
			data[i][0] = vo.getEmployee_id();
			data[i][1] = vo.getLast_name();
			data[i][2] = vo.getHire_date();
			data[i][3] = vo.getEmail();
			data[i][4] = vo.getJob_id();
			data[i][5] = vo.getDepartment_id();
			i++;
			check = true;
		}
	
		table.setModel(new DefaultTableModel(data,cname));
		
		if(!check) {
			JOptionPane.showMessageDialog(Ex1_Frame.this, "존재하지 않는 데이터 입니다.");
		}
	}
	
	private void db_con() {
		try {
			Reader reader = Resources.getResourceAsReader("pm/config/config.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			setTitle("DB Connection !");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
