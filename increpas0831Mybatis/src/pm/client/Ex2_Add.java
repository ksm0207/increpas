package pm.client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import am.vo.EmpVO;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ex2_Add extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton add_btn;
	private JButton cancelButton;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField empno_tf;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JTextField name_tf;
	private JPanel panel_2;
	private JLabel lblNewLabel_2;
	private JTextField lname_tf;
	private JPanel panel_3;
	private JLabel lblNewLabel_3;
	private JTextField hire_tf;
	private JPanel panel_4;
	private JLabel lblNewLabel_4;
	private JTextField email_tf;
	private JPanel panel_5;
	private JLabel lblNewLabel_5;
	private JTextField job_tf;
	private JPanel panel_6;
	private JLabel lblNewLabel_6;
	private JTextField department_tf;
	
	Ex2_Frame parent;

	
	SqlSession session;
	SqlSessionFactory factory;
	/**
	 * Create the dialog.
	 */
	public Ex2_Add(Ex2_Frame parent) {
		
		this.parent = parent;
		
		setBounds(100, 100, 209, 503);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(7, 1, 0, 0));
		{
			panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			contentPanel.add(panel);
			{
				lblNewLabel = new JLabel("사번");
				panel.add(lblNewLabel);
			}
			{
				empno_tf = new JTextField();
				panel.add(empno_tf);
				empno_tf.setColumns(10);
			}
		}
		{
			panel_1 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			contentPanel.add(panel_1);
			{
				lblNewLabel_1 = new JLabel("이름");
				panel_1.add(lblNewLabel_1);
			}
			{
				name_tf = new JTextField();
				name_tf.setColumns(10);
				panel_1.add(name_tf);
			}
		}
		{
			panel_2 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			contentPanel.add(panel_2);
			{
				lblNewLabel_2 = new JLabel("성");
				panel_2.add(lblNewLabel_2);
			}
			{
				lname_tf = new JTextField();
				lname_tf.setColumns(10);
				panel_2.add(lname_tf);
			}
		}
		{
			panel_3 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			contentPanel.add(panel_3);
			{
				lblNewLabel_3 = new JLabel("입사일");
				panel_3.add(lblNewLabel_3);
			}
			{
				hire_tf = new JTextField();
				hire_tf.setColumns(10);
				panel_3.add(hire_tf);
			}
		}
		{
			panel_4 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			contentPanel.add(panel_4);
			{
				lblNewLabel_4 = new JLabel("이메일");
				panel_4.add(lblNewLabel_4);
			}
			{
				email_tf = new JTextField();
				email_tf.setColumns(10);
				panel_4.add(email_tf);
			}
		}
		{
			panel_5 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			contentPanel.add(panel_5);
			{
				lblNewLabel_5 = new JLabel("직종");
				panel_5.add(lblNewLabel_5);
			}
			{
				job_tf = new JTextField();
				job_tf.setColumns(10);
				panel_5.add(job_tf);
			}
		}
		{
			panel_6 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel_6.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			contentPanel.add(panel_6);
			{
				lblNewLabel_6 = new JLabel("부서코드");
				panel_6.add(lblNewLabel_6);
			}
			{
				department_tf = new JTextField();
				department_tf.setColumns(10);
				panel_6.add(department_tf);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				add_btn = new JButton("추가하기");
				add_btn.setActionCommand("OK");
				buttonPane.add(add_btn);
				getRootPane().setDefaultButton(add_btn);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
				
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
		});
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		
		add_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/* 사용자가 입력한 7개 데이터를 가져오기 */
				
				String employee_id = empno_tf.getText();
				String first_name = name_tf.getText();
				String last_name = lname_tf.getText();
				String hire_date = hire_tf.getText();
				String email = email_tf.getText();
				String job_id = job_tf.getText();
				String department_id = department_tf.getText();
			
				Map<String, String> list = new LinkedHashMap<String, String>();
				
				list.put("employee_id",employee_id);
				list.put("first_name", first_name);
				list.put("last_name", last_name);
				list.put("hire_date", hire_date);
				list.put("email", email);
				list.put("job_id", job_id);
				list.put("department_id", department_id);

				
				parent.addData(list);
//				
				
			}
		});
	}
	
}
