package ex.client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ex.vo.DeptVO;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField deptno_tf;
	private JTextField d_name_tf;
	private JTextField city_tf;

	MyFrame f;
	DeptVO dvo;
	private JButton okButton;
	private JButton cancelButton;
	/**
	 * Create the dialog.
	 */
	public MyDialog(MyFrame f, DeptVO dvo) {
		this.f = f;
		this.dvo = dvo;
		setBounds(100, 100, 227, 277);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(5, 1, 0, 0));
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			contentPanel.add(panel);
			{
				JLabel lblNewLabel = new JLabel("부서코드 :");
				panel.add(lblNewLabel);
			}
			{
				deptno_tf = new JTextField();
				deptno_tf.setEditable(false);
				panel.add(deptno_tf);
				deptno_tf.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			contentPanel.add(panel);
			{
				JLabel lblNewLabel_1 = new JLabel("부서명 :");
				panel.add(lblNewLabel_1);
			}
			{
				d_name_tf = new JTextField();
				panel.add(d_name_tf);
				d_name_tf.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			contentPanel.add(panel);
			{
				JLabel lblNewLabel_2 = new JLabel("도시명 :");
				panel.add(lblNewLabel_2);
			}
			{
				city_tf = new JTextField();
				panel.add(city_tf);
				city_tf.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		setVisible(true);
		
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	public void setData() {
		deptno_tf.setText(dvo.getDepartment_id());
		d_name_tf.setText(dvo.getDepartment_name());
		city_tf.setText(dvo.getLvo().getCity());
		
	}
}
