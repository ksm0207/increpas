package am;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JFrame {
	
	// 1. Menu 작업에 필요한 객체 선언
	JMenuBar menu_bar;
	JMenu file_menu , edit_menu, color_menu;
	JMenuItem new_itme, open_item, save_item, exit_item, cut_item,copy_item,
	          paste_item, red_item, green_item, blue_item; 
	
	public Menu() {
		
		file_menu = new JMenu("파일");   // 파일메뉴 생성
		edit_menu = new JMenu("편집");   // 편집메뉴 생성
		color_menu = new JMenu("색상");  // 색상메뉴 생성
		items();
		
		// 메뉴아이템을 JMenu를 추가할 JMenuBar를 생성한다
		menu_bar = new JMenuBar();
		
		// 메뉴추가
		menu_bar.add(file_menu);
		menu_bar.add(edit_menu);
		menu_bar.add(color_menu); 
		
		this.setJMenuBar(menu_bar);

		this.setBounds(200,200,550,350);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		exit_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		open_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 열기를 선택했을 때 액션 이벤트 - ( 파일선택기)
				JFileChooser jfc = new JFileChooser("c:/users/user/Documents/GitHub/increpas");						
				
				// jfc를 보여주기 위해 내부클래스에서
				// 외부쪽 클래스를 가리키는 방법은 외부클래스명.this
				int status = jfc.showOpenDialog(Menu.this);
				
				System.out.println(status);
				
				// 파일 Open = 1  반환
				// 파일 Exit = 0  반환
			
			}
		});
	}
	
	public void items() {
		ArrayList<JMenuItem> list = new ArrayList<JMenuItem>();
//		Arrays.asList(list);
//		
//		System.out.println(list.size());
		

		list.add(new_itme = new JMenuItem("새문서"));
		list.add(open_item = new JMenuItem("열기"));
		list.add(save_item = new JMenuItem("저장"));
		list.add(exit_item = new JMenuItem("종료"));
		
		list.add(cut_item = new JMenuItem("자르기"));
		list.add(copy_item = new JMenuItem("복사"));
		list.add(paste_item = new JMenuItem("붙이기"));
		
		list.add(red_item = new JMenuItem("Red"));
		list.add(green_item = new JMenuItem("Green"));
		list.add(blue_item = new JMenuItem("Blue"));
		
		
		for(int i=0; i<list.size(); i++) {
			
			if(i <= 3) {
				file_menu.add(list.get(i));
				file_menu.addSeparator(); // 구분선
			}else if(i >= 4 && i <= 6 ) {
				edit_menu.add(list.get(i));
			}else {
				color_menu.add(list.get(i));
			}
		}
	}// end of items()

	public static void main(String[] args) {
		
		new Menu();
	}
}