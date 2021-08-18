package pm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Ex1_Frame extends JFrame {

	//왼쪽 화면에 들어갈 객체들
	JPanel west_p, w_north_p;
	JTextField path_tf;
	JButton ok_bt;
	JList<String> list, f_list;
	
	public Ex1_Frame() {
		west_p = new JPanel(new BorderLayout());
		w_north_p = new JPanel(new BorderLayout());
		w_north_p.add(path_tf = new JTextField());
		w_north_p.add(ok_bt = new JButton("확인"), BorderLayout.EAST);
		
		west_p.add(w_north_p, BorderLayout.NORTH);
		west_p.add(new JScrollPane(list = new JList<String>()));
		
		this.add(west_p, BorderLayout.WEST);
				
		this.add(new JScrollPane(f_list = new JList<String>()));
		
		this.setBounds(300, 200, 700, 600);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// 종료하기 전에 해야할 일들이 있다면 여기서 해야 한다.
				
				System.exit(0);//프로그램 종료
			}
		});
		
		ok_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 확인 버튼을 클릭했을 때만 수행하는 곳!
				showList();
			}
		});
		
		path_tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// path_tf에서 엔터를 쳤을 때 수행하는 곳
				showList();
			}
		});
		
		list.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				// 더블클릭을 했는지를 판단하기 위해
				// 클릭카운트 값을 받는다.
				int cnt = e.getClickCount();
				if(cnt == 2) {
					// 더블클릭을 했다면 JList에 선택된 값을 가져온다.
					String s = list.getSelectedValue();
					//setTitle(s);
					
					//선택된 값을 가지고 JTextField에 있는 문자열과
					//합쳐서 다시 JTextField에 문자열로 지정한다.
					String txt = path_tf.getText().trim(); // "c:/"
					
					StringBuffer sb = new StringBuffer(txt);
					
					//txt의 마지막 문자가 "/"가 아닐 때 "/"를 추가하면 된다.
					// 먼저 txt뒤에서 "/"를 찾는다.
					int idx = txt.lastIndexOf("/");
					if(idx != txt.length()-1)
						sb.append("/");
					
					sb.append(s); // c:/mystudy
					
					path_tf.setText(sb.toString());
					showList();
				}
			}
		});
	}
	
	private void showList() {
		// 사용자가 path_tf에 입력한 값을 가져와야 한다.
		String text = path_tf.getText().trim();
		
		//사용자가 입력한 경로를 문자열로 받았으니 File객체 생성하자!
		File f = new File(text);
		
		if(f.isDirectory()) {
			// 생성된 File객체가 폴더일 경우에만 하위 요소들을 모두
			// 문자열 배열로 받아 JList의 항목으로 지정한다.
			String[] sub_ar = f.list();
			f_list.setListData(sub_ar);
			
			//지정된 경로의 하위요소들을 File[]로 받아야 한다.
			//이유는 isHidden() 또는 isFile()과 같은 기능들을 사용해야
			// 표현할 이름들을 가려낼 수 있기 때문이다.
			File[] ar = f.listFiles();
			
			//위에서 받은 배열에서 표현할 폴더명이 몇개있는지?를 확인할 수 없다.
			//그래서 가변적 길이를 가진 ArrayList를 준비하여
			// 표현할 수 있는 이름(숨김이 아니고 파일이 아닌 폴더들)을
			// 저장한다.
			ArrayList<String> aList = new ArrayList<String>();
			
			for(int i=0; i<ar.length; i++) {
				// ar에서 하나씩 가져오면 File객체다.
				File ff = ar[i];
				
				// 가져온 ff가 숨김이 아닌지? 그리고 파일이 아닌지? 판단!
				if(!ff.isHidden() && ff.isDirectory())
					aList.add(ff.getName());
			}
			
			//현재 영역에 왔다면 JList에 표현할 폴더명들은 모두 
			//aList에 저장된 상태다.
			// 그래서 aList에 있는 것들을 String[]로 만들어야 한다.
			String[] sub = new String[aList.size()];
			
			//aList의 내용을 준비된 sub배열에 복사해 넣는다.
			//for(int i=0; i<aList.size(); i++) {
			//	sub[i] = aList.get(i);
			//}
			aList.toArray(sub);			
			
			list.setListData(sub);
		} else {
			JOptionPane.showMessageDialog(Ex1_Frame.this, 
					"폴더가 아니거나 존재하지 않습니다.");
		}
	}
	
	
	public static void main(String[] args) {
		new Ex1_Frame();

	}

}
