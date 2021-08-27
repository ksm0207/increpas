package am;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import java.awt.Font;

public class Chat extends JFrame {

	private JPanel contentPane;
	
	private JList join_list;
	private JPanel area_panel;
	private JTextField send_text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat frame = new Chat();
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
	public Chat() {
		
		setBounds(100, 100, 589, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
//		contentPane.setLayout(cl = new CardLayout(0, 0));
		
		area_panel = new JPanel();
		contentPane.add(area_panel);
		area_panel.setLayout(new BorderLayout(0, 0));
		area_panel.setPreferredSize(new Dimension(110,300));
		
		JPanel join_panel = new JPanel();
		area_panel.add(join_panel, BorderLayout.EAST);
		join_panel.setLayout(new BorderLayout(0, 0));
		
		join_panel.setPreferredSize(new Dimension(110, 250));
		
		
		JLabel join_label = new JLabel("참여자");
		join_panel.add(join_label, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		join_panel.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(1, 1, 0, 0));
		
		JButton exit_room = new JButton("나가기");
		panel_2.add(exit_room);
		
		JScrollPane scrollPane = new JScrollPane();
		join_panel.add(scrollPane, BorderLayout.CENTER);
		
		join_list = new JList();
		scrollPane.setViewportView(join_list);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		area_panel.add(scrollPane_1, BorderLayout.CENTER);
		
		JTextArea area = new JTextArea();
		area.setFont(new Font("Monospaced", Font.PLAIN, 15));
		area.setRows(23);
		scrollPane_1.setViewportView(area);
		
		send_text = new JTextField();
		area_panel.add(send_text, BorderLayout.SOUTH);
		send_text.setColumns(10);
		
		JPanel panel = new JPanel();
		area_panel.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		
		
		
	}

}
