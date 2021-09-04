package pm.client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.ibatis.session.SqlSession;

import pm.vo.EmpVO;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EmpDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	EmpMain main;
	EmpVO evo;
	
	private JTextField empno_tf;
	private JTextField lname_tf;
	private JTextField email_tf;
	private JTextField job_tf;
	private JTextField hire_tf;
	private JTextField dptno_tf;
	private JButton add_bt;
	private JButton cancel_bt;
	
	public EmpDialog(EmpMain main , EmpVO evo) {
		
		this.main = main;
		this.evo = evo;
		
		setBounds(100, 100, 206, 479);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(6, 1, 0, 0));
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			contentPanel.add(panel);
			{
				JLabel lblNewLabel = new JLabel("사번");
				panel.add(lblNewLabel);
			}
			{
				empno_tf = new JTextField();
				panel.add(empno_tf);
				empno_tf.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			contentPanel.add(panel);
			{
				JLabel lblNewLabel = new JLabel("성씨");
				panel.add(lblNewLabel);
			}
			{
				lname_tf = new JTextField();
				lname_tf.setColumns(10);
				panel.add(lname_tf);
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			contentPanel.add(panel);
			{
				JLabel lblNewLabel = new JLabel("이메일");
				panel.add(lblNewLabel);
			}
			{
				email_tf = new JTextField();
				email_tf.setColumns(10);
				panel.add(email_tf);
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			contentPanel.add(panel);
			{
				JLabel lblNewLabel = new JLabel("직종");
				panel.add(lblNewLabel);
			}
			{
				job_tf = new JTextField();
				job_tf.setColumns(10);
				panel.add(job_tf);
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			contentPanel.add(panel);
			{
				JLabel lblNewLabel = new JLabel("입사일");
				panel.add(lblNewLabel);
			}
			{
				hire_tf = new JTextField();
				hire_tf.setColumns(10);
				panel.add(hire_tf);
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			contentPanel.add(panel);
			{
				JLabel lblNewLabel = new JLabel("부서코드");
				panel.add(lblNewLabel);
			}
			{
				dptno_tf = new JTextField();
				dptno_tf.setColumns(10);
				panel.add(dptno_tf);
			}
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				add_bt = new JButton("저장");
				add_bt.setActionCommand("OK");
				buttonPane.add(add_bt);
				getRootPane().setDefaultButton(add_bt);
			}
			{
				cancel_bt = new JButton("Cancel");
				cancel_bt.setActionCommand("Cancel");
				buttonPane.add(cancel_bt);
			}
		}
		
		this.setVisible(true);
		
		add_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String text = add_bt.getText();
				
				if(text.equals("저장")) {
					System.out.println("Insert Button : "+ true);
				}
				
				if(text.equals("수정")) {
					System.out.println("Update Button : " + true);
					
					String empno = empno_tf.getText();
					String lname = lname_tf.getText();
					String job = job_tf.getText();
					String email = email_tf.getText();
					String hire = hire_tf.getText();
					String dptno = dptno_tf.getText();
					
					
					Map<String, String> map = new LinkedHashMap<String, String>();
					
					/*내가 빠트린 부분 : evo 와 비교하여 틀린 것들만 Map구조에 넣어준다.*/
					/* evo 객체를 비교해주기 */
				
					if(!evo.getLast_name().equals(lname)) {
						map.put("last_name", lname);
						
						/* evo.set .. 구문 추가 : 바뀐내용이 추가됨과 동시에 */
						/* 새로운 값으로 바꾸기 위한 코드 */
						evo.setLast_name(lname);
					}
					if(!evo.getJob_id().equals(job)) {
						map.put("job_id", job);
						evo.setJob_id(job);
					}
					if(!evo.getEmail().equals(email)) {
						map.put("email", email);
						evo.setEmail(email);
					}
					if(!evo.getHire_date().equals(hire)) {
						map.put("hire_date",hire);
						evo.setHire_date(hire);
					}
					if(!evo.getDepartment_id().equals(dptno)) {
						map.put("department_id",dptno);
						evo.setDepartment_id(dptno);
					}
					
					System.out.println("Case 1 : " + !evo.getLast_name().equals(lname));
					System.out.println("Case 2 : " + !evo.getJob_id().equals(job));
					System.out.println("Case 3 : " + !evo.getEmail().equals(email));
					System.out.println("Case 4 : " + !evo.getHire_date().equals(hire));
					System.out.println("Case 5 : " + !evo.getDepartment_id().equals(dptno));
					/* 비교끝 */
					
					/* 조건 값인 사번은 따로 저장해준다.*/
					map.put("employee_id",empno);
					
					/* 수정한 것이 하나도 없다면. (수정 성공시 값은 1로 넘어감) --> */
					if(map.size() < 2)
						
						return;
					
					int status = main.edit(map);
					if(status > 0) {
						main.editTable(evo); /* 수정된 내용을 editTable에 인자로  evo 넣어주기  */
						JOptionPane.showMessageDialog(EmpDialog.this, "업데이트 성공 !");						
					}
					else {
						JOptionPane.showMessageDialog(EmpDialog.this, "업데이트 실패 ...");
					}
						
				}
				
			}
		});
		
		cancel_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}// end of EmpModify
	
	/* Table에서 더블 클릭 후 호출하는 메소드 .*/
	public void setData() {
		
		if(evo != null) {
			
			empno_tf.setText(evo.getEmployee_id());
			empno_tf.setEditable(false); /* TextField 비활성화 */
			
			lname_tf.setText(evo.getLast_name());
			email_tf.setText(evo.getEmail());
			job_tf.setText(evo.getJob_id());
			hire_tf.setText(evo.getHire_date());
			dptno_tf.setText(evo.getDepartment_id());
		}
		add_bt.setText("수정");
		this.setTitle("정보 보기");
	}
	
	/* 저장 기능을 수행했을 때 텍스트 청소해주기. */
	private void clearTF() {
		empno_tf.setText("");
		lname_tf.setText("");
		email_tf.setText("");
		job_tf.setText("");
		hire_tf.setText("");
		dptno_tf.setText("");
	}
	
}
