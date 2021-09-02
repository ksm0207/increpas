package pm.client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EmpModify extends JDialog {

	private final JPanel contentPanel = new JPanel();

	EmpMain main;
	private JTextField empno_tf;
	private JTextField lname_tf;
	private JTextField email_tf;
	private JTextField job_tf;
	private JTextField hire_tf;
	private JTextField dptno_tf;
	
	public EmpModify(EmpMain main) {
		
		this.main = main;
		
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
				empno_tf.setEditable(false);
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
				JButton okButton = new JButton("저장");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		this.setVisible(true);
	}// end of EmpModify

}
