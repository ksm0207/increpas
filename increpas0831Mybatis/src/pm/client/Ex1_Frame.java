package pm.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import pm.model.MyModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex1_Frame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	String[] cname = {"사번","이름","직종","부서"};
	String[][] data = 
		{
			{
				"200","일지매","IT_PROG","30"
			},
			
			{
				"220","이지매","IT_PROG","40"
			},
			
			{
				"205","삼지매","IT_PROG","50"
			}
		};
	

	/**
	 * Launch the application.
	 */
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
		
		setBounds(100, 100, 510, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		
//		table = new JTable(new MyModel(col_name, data));
		table = new JTable(new DefaultTableModel(data, cname));
		
		scrollPane.setViewportView(table);
		
		
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}
